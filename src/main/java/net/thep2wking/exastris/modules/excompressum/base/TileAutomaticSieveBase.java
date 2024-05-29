package net.thep2wking.exastris.modules.excompressum.base;

import java.util.Collection;
import java.util.Random;

import javax.annotation.Nullable;

import net.blay09.mods.excompressum.api.sievemesh.SieveMeshRegistryEntry;
import net.blay09.mods.excompressum.handler.VanillaPacketHandler;
import net.blay09.mods.excompressum.registry.ExRegistro;
import net.blay09.mods.excompressum.registry.heavysieve.HeavySieveRegistry;
import net.blay09.mods.excompressum.registry.sievemesh.SieveMeshRegistry;
import net.blay09.mods.excompressum.tile.TileEntityBase;
import net.blay09.mods.excompressum.utils.DefaultItemHandler;
import net.blay09.mods.excompressum.utils.ItemHandlerAutomation;
import net.blay09.mods.excompressum.utils.SubItemHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.modules.excompressum.content.ItemUpgradeFortune;
import net.thep2wking.exastris.modules.excompressum.content.ItemUpgradeSpeed;

public abstract class TileAutomaticSieveBase extends TileEntityBase implements ITickable {
    private static final int UPDATE_INTERVAL = 20;

    private final DefaultItemHandler itemHandler = new DefaultItemHandler(this, 24) {
        @Override
        public boolean isItemValid(int slot, ItemStack itemStack) {
            if (inputSlots.isInside(slot)) {
                return isSiftable(itemStack);
            } else if (meshSlots.isInside(slot)) {
                return isMesh(itemStack);
            } else if (upgradeSlotSpeed.isInside(slot)) {
                return isUpgradeSpeed(itemStack);
            } else if (upgradeSlotFortune.isInside(slot)) {
                return isUpgradeFortune(itemStack);
            }
            return true;
        }

        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            if (meshSlots.isInside(slot)) {
                isDirty = true;
            }
        }
    };
    private final SubItemHandler inputSlots = new SubItemHandler(itemHandler, 0, 1);
    private final SubItemHandler outputSlots = new SubItemHandler(itemHandler, 1, 21);
    private final SubItemHandler meshSlots = new SubItemHandler(itemHandler, 21, 22);
    private final SubItemHandler upgradeSlotSpeed = new SubItemHandler(itemHandler, 22, 23);
    private final SubItemHandler upgradeSlotFortune = new SubItemHandler(itemHandler, 23, 24);

    private final ItemHandlerAutomation itemHandlerAutomation = new ItemHandlerAutomation(itemHandler) {
        @Override
        public boolean canExtractItem(int slot, int amount) {
            return super.canExtractItem(slot, amount) && outputSlots.isInside(slot);
        }

        @Override
        public boolean canInsertItem(int slot, ItemStack itemStack) {
            return super.canInsertItem(slot, itemStack) && (inputSlots.isInside(slot) || meshSlots.isInside(slot)
                    || upgradeSlotSpeed.isInside(slot) || upgradeSlotFortune.isInside(slot));
        }
    };

    private ItemStack currentStack = ItemStack.EMPTY;

    private int ticksSinceSync;
    protected boolean isDirty;

    private float progress;
    public IBlockState cachedState;
    private boolean isDisabledByRedstone;

    @Override
    public void update() {
        if (!world.isRemote) {
            ticksSinceSync++;
            if (ticksSinceSync > UPDATE_INTERVAL) {
                if (isDirty) {
                    VanillaPacketHandler.sendTileEntityUpdate(this);
                    isDirty = false;
                }
                ticksSinceSync = 0;
            }
        }
        int effectiveEnergy = getEffectiveEnergy();
        if (!isDisabledByRedstone() && getEnergyStored(null) >= effectiveEnergy) {
            if (currentStack.isEmpty()) {
                ItemStack inputStack = inputSlots.getStackInSlot(0);
                SieveMeshRegistryEntry sieveMesh = getSieveMesh();
                if (!inputStack.isEmpty() && sieveMesh != null && isSiftableWithMesh(inputStack, sieveMesh)) {
                    boolean foundSpace = false;
                    for (int i = 0; i < outputSlots.getSlots(); i++) {
                        if (outputSlots.getStackInSlot(i).isEmpty()) {
                            foundSpace = true;
                        }
                    }
                    if (!foundSpace) {
                        return;
                    }
                    currentStack = inputStack.splitStack(1);
                    if (inputStack.isEmpty()) {
                        inputSlots.setStackInSlot(0, ItemStack.EMPTY);
                    }
                    extractEnergy(effectiveEnergy, false);
                    VanillaPacketHandler.sendTileEntityUpdate(this);
                    progress = 0f;
                }
            } else {
                extractEnergy(effectiveEnergy, false);
                progress += getEffectiveSpeed();
                isDirty = true;
                if (progress >= 1) {
                    if (!world.isRemote) {
                        SieveMeshRegistryEntry sieveMesh = getSieveMesh();
                        if (sieveMesh != null) {
                            Collection<ItemStack> rewards = rollSieveRewards(currentStack, sieveMesh,
                                    getEffectiveLuck(), world.rand);
                            for (ItemStack itemStack : rewards) {
                                if (!addItemToOutput(itemStack)) {
                                    world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1.5,
                                            pos.getZ() + 0.5, itemStack));
                                }
                            }
                            if (ExRegistro.doMeshesHaveDurability()) {
                                ItemStack meshStack = meshSlots.getStackInSlot(0);
                                if (!meshStack.isEmpty()) {
                                    if (meshStack.attemptDamageItem(1, world.rand, null)) {
                                        getWorld().playSound(null, this.pos, SoundEvents.ENTITY_ITEM_BREAK,
                                                SoundCategory.BLOCKS, 0.5f, 2.5f);
                                        meshStack.shrink(1);
                                        meshSlots.setStackInSlot(0, ItemStack.EMPTY);
                                    }
                                }
                            }
                        } else {
                            if (!addItemToOutput(currentStack)) {
                                world.spawnEntity(new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1.5,
                                        pos.getZ() + 0.5, currentStack));
                            }
                        }
                    }
                    progress = 0f;
                    currentStack = ItemStack.EMPTY;
                }
            }
        }
    }

    private boolean addItemToOutput(ItemStack itemStack) {
        int firstEmptySlot = -1;
        for (int i = 0; i < outputSlots.getSlots(); i++) {
            ItemStack slotStack = outputSlots.getStackInSlot(i);
            if (slotStack.isEmpty()) {
                if (firstEmptySlot == -1) {
                    firstEmptySlot = i;
                }
            } else {
                if (slotStack.getCount() + itemStack.getCount() <= slotStack.getMaxStackSize()
                        && slotStack.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(slotStack, itemStack)) {
                    slotStack.grow(itemStack.getCount());
                    return true;
                }
            }
        }
        if (firstEmptySlot != -1) {
            outputSlots.setStackInSlot(firstEmptySlot, itemStack);
            return true;
        }
        return false;
    }

    public int getEffectiveEnergy() {
        return (int) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.ENERGY_USAGE_PER_TICK
                + (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.ENERGY_USAGE_PER_TICK
                        * getEnergyUpgradeMultiplier()));
    }

    public float getEffectiveSpeed() {
        return (float) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.DEFAULT_SIFTEING_SPEED
                * getSpeedMultiplier());
    }

    public float getEffectiveLuck() {
        ItemStack meshStack = meshSlots.getStackInSlot(0);
        if (!meshStack.isEmpty()) {
            return ExRegistro.getMeshFortune(meshStack)
                    + (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.FORTUNE_UPGRADE ? getUpgradeFortune() : 0);
        }
        return 0f;
    }

    public boolean isSiftable(ItemStack itemStack) {
        return ExRegistro.isSiftable(itemStack) || (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.HEAVY_SIEVE_RECIPES ? HeavySieveRegistry.isSiftable(itemStack) : false);
    }

    public boolean isSiftableWithMesh(ItemStack itemStack, SieveMeshRegistryEntry sieveMesh) {
        return ExRegistro.isSiftableWithMesh(itemStack, sieveMesh) || (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.HEAVY_SIEVE_RECIPES ? HeavySieveRegistry.isSiftableWithMesh(itemStack, sieveMesh) : false);
    }

    public boolean isMesh(ItemStack itemStack) {
        return SieveMeshRegistry.getEntry(itemStack) != null;
    }

    public boolean isUpgradeSpeed(ItemStack itemStack) {
        return itemStack != null && itemStack.getItem() instanceof ItemUpgradeSpeed
                && ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.SPEED_UPGRADE;
    }

    public boolean isUpgradeFortune(ItemStack itemStack) {
        return itemStack != null && itemStack.getItem() instanceof ItemUpgradeFortune
                && ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.FORTUNE_UPGRADE;
    }

    public Collection<ItemStack> rollSieveRewards(ItemStack itemStack, SieveMeshRegistryEntry sieveMesh, float luck,
            Random rand) {
                if(ExRegistro.isSiftable(itemStack)) {
                    return ExRegistro.rollSieveRewards(itemStack, sieveMesh, luck, rand) ;
                } else {
                    return HeavySieveRegistry.rollSieveRewards(itemStack, sieveMesh, luck, rand);
                }
    }

    @Override
    protected boolean hasUpdatePacket() {
        return true;
    }

    @Override
    protected void readFromNBTSynced(NBTTagCompound tagCompound, boolean isSync) {
        currentStack = new ItemStack(tagCompound.getCompoundTag("CurrentStack"));
        if (isSync) {
            meshSlots.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("MeshStack")));
            upgradeSlotSpeed.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeSpeedStack")));
            upgradeSlotFortune.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeFortuneStack")));
        } else {
            itemHandler.deserializeNBT(tagCompound.getCompoundTag("ItemHandler"));
        }
        isDisabledByRedstone = tagCompound.getBoolean("IsDisabledByRedstone");
    }

    
	public void readRestorableFromNBT(NBTTagCompound tagCompound) {
        meshSlots.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("MeshStack")));
        upgradeSlotSpeed.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeSpeedStack")));
        upgradeSlotFortune.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeFortuneStack")));
	}

    @Override
    protected void writeToNBTSynced(NBTTagCompound tagCompound, boolean isSync) {
        tagCompound.setTag("CurrentStack", currentStack.writeToNBT(new NBTTagCompound()));
        tagCompound.setFloat("Progress", progress);
        if (isSync) {
            ItemStack meshStack = meshSlots.getStackInSlot(0);
            tagCompound.setTag("MeshStack", meshStack.writeToNBT(new NBTTagCompound()));
            ItemStack upgradeSpeedStack = upgradeSlotSpeed.getStackInSlot(0);
            tagCompound.setTag("UpgradeSpeedStack", upgradeSpeedStack.writeToNBT(new NBTTagCompound()));
            ItemStack upgradeFortuneStack = upgradeSlotFortune.getStackInSlot(0);
            tagCompound.setTag("UpgradeFortuneStack", upgradeFortuneStack.writeToNBT(new NBTTagCompound()));
        } else {
            tagCompound.setTag("ItemHandler", itemHandler.serializeNBT());
        }
        tagCompound.setBoolean("IsDisabledByRedstone", isDisabledByRedstone());
    }

    public void writeRestorableToNBT(NBTTagCompound tagCompound) {
        ItemStack meshStack = meshSlots.getStackInSlot(0);
        tagCompound.setTag("MeshStack", meshStack.writeToNBT(new NBTTagCompound()));
        ItemStack upgradeSpeedStack = upgradeSlotSpeed.getStackInSlot(0);
        tagCompound.setTag("UpgradeSpeedStack", upgradeSpeedStack.writeToNBT(new NBTTagCompound()));
        ItemStack upgradeFortuneStack = upgradeSlotFortune.getStackInSlot(0);
        tagCompound.setTag("UpgradeFortuneStack", upgradeFortuneStack.writeToNBT(new NBTTagCompound()));
	}

    public abstract int getMaxEnergyStored();

    public abstract int getEnergyStored(@Nullable EnumFacing from);

    public abstract int extractEnergy(int maxExtract, boolean simulate);

    public abstract void setEnergyStored(int energy);

    public float getEnergyPercentage() {
        return (float) getEnergyStored(null) / (float) getMaxEnergyStored();
    }

    public boolean isProcessing() {
        return progress > 0f;
    }

    public float getProgress() {
        return progress;
    }

    public ItemStack getCurrentStack() {
        return currentStack;
    }

    public float getUpgradeSpeed() {
        ItemStack stack = upgradeSlotSpeed.getStackInSlot(0);
        double speedIncresePerUpgrade = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.SPEED_UPGRADE_MODIFIER;
        return (float) (stack.getCount() * speedIncresePerUpgrade);
    }

    public float getUpgradeFortune() {
        ItemStack stack = upgradeSlotFortune.getStackInSlot(0);
        double fortuneIncresePerUpgrade = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.FORTUNE_UPGRADE_MODIFIER;
        return (float) (stack.getCount() * fortuneIncresePerUpgrade);
    }

    public float getEnergyUpgradeMultiplier() {
        int speedCount = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.SPEED_UPGRADE
                ? upgradeSlotSpeed.getStackInSlot(0).getCount()
                : 0;
        float speedImpact = (float) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.SPEED_UPGRADE_ENERGY_MULTIPLIER);

        int fortuneCount = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.FORTUNE_UPGRADE
                ? upgradeSlotFortune.getStackInSlot(0).getCount()
                : 0;
        float fortuneImpact = (float) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.FORTUNE_UPGRADE_ENERGY_MULTIPLIER);

        float energyMultiplier = (speedCount * speedImpact) + (fortuneCount * fortuneImpact);
        return energyMultiplier;
    }

    public float getSpeedMultiplier() {
        final float EFFICIENCY_BOOST = 0.25f;
        float boost = 1f;
        ItemStack meshStack = meshSlots.getStackInSlot(0);
        if (!meshStack.isEmpty()) {
            boost += EFFICIENCY_BOOST * ExRegistro.getMeshEfficiency(meshStack)
                    + (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.SPEED_UPGRADE ? getUpgradeSpeed() : 0);
        }
        return boost;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY
                || super.hasCapability(capability, facing);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T) itemHandlerAutomation;
        }
        return super.getCapability(capability, facing);
    }

    public DefaultItemHandler getItemHandler() {
        return itemHandler;
    }

    @Nullable
    public SieveMeshRegistryEntry getSieveMesh() {
        ItemStack meshStack = meshSlots.getStackInSlot(0);
        if (!meshStack.isEmpty()) {
            return SieveMeshRegistry.getEntry(meshStack);
        }
        return null;
    }

    public ItemStack getMeshStack() {
        return meshSlots.getStackInSlot(0);
    }

    public boolean isCorrectSieveMesh() {
        ItemStack inputStack = inputSlots.getStackInSlot(0);
        SieveMeshRegistryEntry sieveMesh = getSieveMesh();
        return inputStack.isEmpty() || sieveMesh == null || isSiftableWithMesh(inputStack, sieveMesh);
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        cachedState = null;
        return oldState.getBlock() != newState.getBlock();
    }

    public boolean isDisabledByRedstone() {
        return isDisabledByRedstone;
    }

    public void setDisabledByRedstone(boolean disabledByRedstone) {
        isDisabledByRedstone = disabledByRedstone;
        isDirty = true;
        ticksSinceSync = UPDATE_INTERVAL;
    }
}