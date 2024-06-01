package net.thep2wking.exastris.modules.excompressum.base;

import java.util.Collection;
import java.util.Random;

import javax.annotation.Nullable;

import exnihilocreatio.items.tools.IHammer;
import net.blay09.mods.excompressum.api.ExNihiloProvider;
import net.blay09.mods.excompressum.compat.Compat;
import net.blay09.mods.excompressum.handler.VanillaPacketHandler;
import net.blay09.mods.excompressum.registry.ExRegistro;
import net.blay09.mods.excompressum.registry.compressedhammer.CompressedHammerRegistry;
import net.blay09.mods.excompressum.tile.TileEntityBase;
import net.blay09.mods.excompressum.utils.DefaultItemHandler;
import net.blay09.mods.excompressum.utils.ItemHandlerAutomation;
import net.blay09.mods.excompressum.utils.SubItemHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.CapabilityItemHandler;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.modules.excompressum.content.ItemUpgradeFortune;
import net.thep2wking.exastris.modules.excompressum.content.ItemUpgradeSpeed;

public abstract class TileAutomaticHammererBase extends TileEntityBase implements ITickable {
	private static final int UPDATE_INTERVAL = 20;

	private final DefaultItemHandler itemHandler = new DefaultItemHandler(this, 24) {
		@Override
		public boolean isItemValid(int slot, ItemStack itemStack) {
			if (slot == 0) {
				return isHammerable(itemStack);
			} else if (slot == 21) {
				return isHammerUpgrade(itemStack);
			} else if (slot == 22) {
				return isUpgradeSpeed(itemStack);
			} else if (slot == 23) {
				return isUpgradeFortune(itemStack);
			}
			return true;
		}

		@Override
		protected void onContentsChanged(int slot) {
			super.onContentsChanged(slot);
			if (hammerSlots.isInside(slot)) {
				isDirty = true;
			}
		}
	};

	private final SubItemHandler inputSlots = new SubItemHandler(itemHandler, 0, 1);
	private final SubItemHandler outputSlots = new SubItemHandler(itemHandler, 1, 21);
	private final SubItemHandler hammerSlots = new SubItemHandler(itemHandler, 21, 22);
	private final SubItemHandler upgradeSlotSpeed = new SubItemHandler(itemHandler, 22, 23);
	private final SubItemHandler upgradeSlotFortune = new SubItemHandler(itemHandler, 23, 24);

	private final ItemHandlerAutomation itemHandlerAutomation = new ItemHandlerAutomation(itemHandler) {
		@Override
		public boolean canExtractItem(int slot, int amount) {
			return super.canExtractItem(slot, amount) && outputSlots.isInside(slot);
		}

		@Override
		public boolean canInsertItem(int slot, ItemStack itemStack) {
			return super.canInsertItem(slot, itemStack) && inputSlots.isInside(slot) || hammerSlots.isInside(slot)
					|| upgradeSlotSpeed.isInside(slot) || upgradeSlotFortune.isInside(slot);
		}
	};

	private ItemStack currentStack = ItemStack.EMPTY;

	private int ticksSinceUpdate;
	protected boolean isDirty;

	private float progress;
	public IBlockState cachedState;
	private boolean isDisabledByRedstone;

	@Override
	public void update() {
		if (!world.isRemote) {
			ticksSinceUpdate++;
			if (ticksSinceUpdate > UPDATE_INTERVAL) {
				if (isDirty) {
					VanillaPacketHandler.sendTileEntityUpdate(this);
					isDirty = false;
				}
				ticksSinceUpdate = 0;
			}
		}
		int effectiveEnergy = getEffectiveEnergy();
		if (!isDisabledByRedstone() && getEnergyStored(null) >= effectiveEnergy) {
			if (currentStack.isEmpty()) {
				ItemStack inputStack = inputSlots.getStackInSlot(0);
				if (!inputStack.isEmpty() && isHammerable(inputStack)) {
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
						Collection<ItemStack> rewards = rollHammerRewards(currentStack, getMiningLevel(),
								getEffectiveLuck(), world.rand);
						for (ItemStack itemStack : rewards) {
							if (!addItemToOutput(itemStack)) {
								EntityItem entityItem = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 1.5,
										pos.getZ() + 0.5, itemStack);
								double motion = 0.05;
								entityItem.motionX = world.rand.nextGaussian() * motion;
								entityItem.motionY = 0.2;
								entityItem.motionZ = world.rand.nextGaussian() * motion;
								world.spawnEntity(entityItem);
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
		return (int) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.ENERGY_USAGE_PER_TICK
				+ (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.ENERGY_USAGE_PER_TICK
						* getEnergyUpgradeMultiplier()));
	}

	public float getEffectiveSpeed() {
		return (float) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.DEFAULT_HAMMERING_SPEED
				* getSpeedMultiplier());
	}

	public float getEffectiveLuck() {
		float luck = 0f;
		ItemStack hammer = hammerSlots.getStackInSlot(0);
		if (!hammer.isEmpty() && isHammerUpgrade(hammer)) {
			luck += EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, hammer)
					+ (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.FORTUNE_UPGRADE ? getUpgradeFortune()
							: 0);
		} else {
			luck += (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.FORTUNE_UPGRADE ? getUpgradeFortune() : 0);
		}
		return luck;
	}

	@Override
	protected boolean hasUpdatePacket() {
		return true;
	}

	@Override
	protected void readFromNBTSynced(NBTTagCompound tagCompound, boolean isSync) {
		currentStack = new ItemStack(tagCompound.getCompoundTag("CurrentStack"));
		if (isSync) {
			hammerSlots.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("HammerStack")));
			upgradeSlotSpeed.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeSpeedStack")));
			upgradeSlotFortune.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeFortuneStack")));
		} else {
			itemHandler.deserializeNBT(tagCompound.getCompoundTag("ItemHandler"));
		}
		isDisabledByRedstone = tagCompound.getBoolean("IsDisabledByRedstone");
	}

	public void readRestorableFromNBT(NBTTagCompound tagCompound) {
		hammerSlots.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("HammerStack")));
		upgradeSlotSpeed.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeSpeedStack")));
		upgradeSlotFortune.setStackInSlot(0, new ItemStack(tagCompound.getCompoundTag("UpgradeFortuneStack")));
	}

	@Override
	protected void writeToNBTSynced(NBTTagCompound tagCompound, boolean isSync) {
		tagCompound.setTag("CurrentStack", currentStack.writeToNBT(new NBTTagCompound()));
		tagCompound.setFloat("Progress", progress);
		if (isSync) {
			ItemStack hammerStack = hammerSlots.getStackInSlot(0);
			tagCompound.setTag("HammerStack", hammerStack.writeToNBT(new NBTTagCompound()));
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
		ItemStack hammerStack = hammerSlots.getStackInSlot(0);
		tagCompound.setTag("HammerStack", hammerStack.writeToNBT(new NBTTagCompound()));
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
		double speedIncresePerUpgrade = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SPEED_UPGRADE_MODIFIER;
		return (float) (stack.getCount() * speedIncresePerUpgrade);
	}

	public float getUpgradeFortune() {
		ItemStack stack = upgradeSlotFortune.getStackInSlot(0);
		double fortuneIncresePerUpgrade = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.FORTUNE_UPGRADE_MODIFIER;
		return (float) (stack.getCount() * fortuneIncresePerUpgrade);
	}

	public float getEnergyUpgradeMultiplier() {
		int speedCount = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SPEED_UPGRADE
				? upgradeSlotSpeed.getStackInSlot(0).getCount()
				: 0;
		float speedImpact = (float) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SPEED_UPGRADE_ENERGY_MULTIPLIER);

		int fortuneCount = ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.FORTUNE_UPGRADE
				? upgradeSlotFortune.getStackInSlot(0).getCount()
				: 0;
		float fortuneImpact = (float) (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.FORTUNE_UPGRADE_ENERGY_MULTIPLIER);

		float energyMultiplier = (speedCount * speedImpact) + (fortuneCount * fortuneImpact);
		return energyMultiplier;
	}

	public float getSpeedMultiplier() {
		final float HAMMER_BOOST = 0.5f;
		final float EFFICIENCY_BOOST = 0.25f;
		float boost = 1f;
		ItemStack hammer = hammerSlots.getStackInSlot(0);
		if (!hammer.isEmpty() && isHammerUpgrade(hammer)) {
			boost += HAMMER_BOOST;
			boost += EFFICIENCY_BOOST * EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, hammer)
					+ (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SPEED_UPGRADE ? getUpgradeSpeed() : 0);
		} else {
			boost += (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SPEED_UPGRADE ? getUpgradeSpeed() : 0);
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

	public ItemStack getHammerStack() {
		return hammerSlots.getStackInSlot(0);
	}

	@Nullable
	@SuppressWarnings("deprecation")
	public IBlockState getCurrentBlock() {
		if (currentStack.isEmpty()) {
			return null;
		}
		Block block = Block.getBlockFromItem(currentStack.getItem());
		if (block != Blocks.AIR) {
			return block.getStateFromMeta(currentStack.getMetadata());
		}
		return null;
	}

	public boolean isHammerUpgrade(ItemStack itemStack) {
		if (itemStack.getItem() == Compat.TCONSTRUCT_HAMMER) {
			NBTTagCompound tagCompound = itemStack.getTagCompound();
			if (tagCompound != null) {
				NBTTagList traits = tagCompound.getTagList("Traits", Constants.NBT.TAG_STRING);
				for (NBTBase tag : traits) {
					if (((NBTTagString) tag).getString().equalsIgnoreCase(Compat.TCONSTRUCT_TRAIT_SMASHING)) {
						return true;
					}
				}
			}
		}
		return isAllowedHammer(itemStack);
	}

	public boolean isAllowedHammer(ItemStack itemStack) {
		if (itemStack.getItem() instanceof IHammer
				|| ExRegistro.isNihiloItem(itemStack, ExNihiloProvider.NihiloItems.HAMMER_DIAMOND)) {
			IHammer hammer = (IHammer) itemStack.getItem();
			if (hammer.getMiningLevel(itemStack) >= ToolMaterial.DIAMOND.getHarvestLevel()) {
				return true;
			}
		}
		return false;
	}

	public boolean isUpgradeSpeed(ItemStack itemStack) {
		return itemStack != null && itemStack.getItem() instanceof ItemUpgradeSpeed
				&& ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SPEED_UPGRADE;
	}

	public boolean isUpgradeFortune(ItemStack itemStack) {
		return itemStack != null && itemStack.getItem() instanceof ItemUpgradeFortune
				&& ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.FORTUNE_UPGRADE;
	}

	public boolean isHammerable(ItemStack itemStack) {
		return ExRegistro.isHammerable(itemStack)
				|| (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.EX_COMPRESSUM_COMPRESSED_HAMMER_RECIPES
						? CompressedHammerRegistry.isHammerable(itemStack)
						: false);
	}

	public Collection<ItemStack> rollHammerRewards(ItemStack itemStack, int miningLevel, float luck, Random rand) {
		if (ExRegistro.isHammerable(itemStack)) {
			return ExRegistro.rollHammerRewards(itemStack, miningLevel, luck, rand);
		} else {
			return CompressedHammerRegistry.rollHammerRewards(itemStack, luck, rand);
		}
	}

	public int getMiningLevel() {
		return Item.ToolMaterial.DIAMOND.getHarvestLevel();
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
		ticksSinceUpdate = UPDATE_INTERVAL;
	}
}