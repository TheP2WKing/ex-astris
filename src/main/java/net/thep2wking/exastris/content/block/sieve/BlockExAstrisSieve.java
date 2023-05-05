package net.thep2wking.exastris.content.block.sieve;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.config.ModConfig;
import exnihilocreatio.items.ItemMesh;
import exnihilocreatio.tiles.TileSieve;
import exnihilocreatio.util.ItemStackItemHandler;
import exnihilocreatio.util.Util;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.util.handler.EnumToolType;
import net.thep2wking.exastris.util.handler.IHasModel;

public class BlockExAstrisSieve extends BlockSieve implements IHasModel {
    private final String groupName;
    private final CreativeTabs tab;
    private final SoundType sound;
    private final int harvestLevel;
    private final EnumToolType toolType;
    private final float hardness;
    private final float resistance;
    private final float lightLevel;

    public static final PropertyEnum<EnumExAstrisSieve> VARIANT = PropertyEnum.create("variant",
            EnumExAstrisSieve.class);

    public BlockExAstrisSieve(String groupName, CreativeTabs tab, Material material, SoundType sound,
            int harvestLevel, EnumToolType toolType, float hardness, float resistance, float lightLevel) {
        this.groupName = groupName;
        this.tab = tab;
        this.sound = sound;
        this.harvestLevel = harvestLevel;
        this.toolType = toolType;
        this.hardness = hardness;
        this.resistance = resistance;
        this.lightLevel = lightLevel;
        setUnlocalizedName(ExAstris.PREFIX + this.groupName);
        setSoundType(this.sound);
        setHarvestLevel(this.toolType.getToolType(), this.harvestLevel);
        setHardness(this.hardness);
        setResistance(this.resistance);
        setLightLevel(this.lightLevel);
        setCreativeTab(this.tab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSieve.MESH, MeshType.NO_RENDER)
                .withProperty(VARIANT, EnumExAstrisSieve.OAK));
        ExAstrisBlocks.BLOCKS.add(this);
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (EnumExAstrisSieve type : EnumExAstrisSieve.values()) {
            items.add(new ItemStack(this, 1, type.getMeta()));
        }
    }

    @Override
    @Nonnull
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { VARIANT, BlockSieve.MESH });
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumExAstrisSieve type = (EnumExAstrisSieve) state.getValue(VARIANT);
        return type.getMeta();
    }

    @Override
    @SuppressWarnings("null")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumExAstrisSieve.values()[meta]);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
            EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (EnumExAstrisSieve type : EnumExAstrisSieve.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.getMeta(),
                    new ModelResourceLocation(ExAstris.PREFIX + this.groupName + "_" + type.getMaterialType(),
                            "inventory"));
            ModelLoader.setCustomStateMapper(this, new DefaultStateMapper());
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote)
            return true;

        // I think this should work. Let's just go with it.
        if (player instanceof FakePlayer && !ModConfig.mechanics.fakePlayersCanSieve) {
            return false;
        }
        TileSieve te = (TileSieve) world.getTileEntity(pos);

        if (te == null)
            return true;

        ItemStack heldItem = player.getHeldItem(hand);

        // Removing a mesh
        if (heldItem.isEmpty() && !te.getMeshStack().isEmpty() && player.isSneaking()
                && te.setMesh(ItemStack.EMPTY, true)) {
            // Removing a mesh.
            Util.dropItemInWorld(te, player, te.getMeshStack(), 0.02f);
            te.setMesh(ItemStack.EMPTY, false);
            return true;
        }

        // Inserting blocks
        IItemHandler cap = null;
        if (ModConfig.compatibility.generalItemHandlerCompat)
            cap = heldItem.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        if (cap == null)
            cap = new ItemStackItemHandler(heldItem);

        int slot = 0;
        int maxSlot = cap.getSlots();
        for (; slot < maxSlot; slot++) {
            ItemStack stack = cap.getStackInSlot(slot);
            if (!stack.isEmpty() && stack.getItem() instanceof ItemMesh) {
                // Adding a mesh
                boolean added = te.setMesh(cap.extractItem(slot, 1, true));
                if (added) {
                    cap.extractItem(slot, 1, player.isCreative());
                    return true;
                }
            }
            if (te.addBlock(cap.extractItem(slot, 1, true))) {
                // Adding a block
                world.playSound(null, pos, SoundEvents.BLOCK_GRAVEL_STEP, SoundCategory.BLOCKS, 0.5f, 1f);
                cap.extractItem(slot, 1, player.isCreative());
                for (int dx = -ModConfig.sieve.sieveSimilarRadius; dx <= ModConfig.sieve.sieveSimilarRadius; dx++) {
                    for (int dz = -ModConfig.sieve.sieveSimilarRadius; dz <= ModConfig.sieve.sieveSimilarRadius; dz++) {
                        if (cap.getStackInSlot(slot).isEmpty())
                            continue; // No more items
                        TileEntity otherTE = world.getTileEntity(pos.add(dx, 0, dz));
                        if (!(otherTE instanceof TileSieve))
                            continue; // Not a sieve
                        TileSieve sieve = (TileSieve) otherTE;
                        if (!te.isSieveSimilarToInput(sieve))
                            continue; // Not a similar sieve
                        if (sieve.addBlock(cap.extractItem(slot, 1, true))) {
                            cap.extractItem(slot, 1, player.isCreative());
                        }
                    }
                }
                return true;
            }
        }

        List<BlockPos> toSift = new ArrayList<>();
        for (int xOffset = -1
                * ModConfig.sieve.sieveSimilarRadius; xOffset <= ModConfig.sieve.sieveSimilarRadius; xOffset++) {
            for (int zOffset = -1
                    * ModConfig.sieve.sieveSimilarRadius; zOffset <= ModConfig.sieve.sieveSimilarRadius; zOffset++) {
                TileEntity entity = world.getTileEntity(pos.add(xOffset, 0, zOffset));
                if (entity instanceof TileSieve) {
                    TileSieve sieve = (TileSieve) entity;

                    if (te.isSieveSimilar(sieve))
                        toSift.add(pos.add(xOffset, 0, zOffset));
                }
            }
        }
        for (BlockPos posIter : toSift) {
            if (posIter != null) {
                TileSieve sieve = (TileSieve) world.getTileEntity(posIter);
                if (sieve != null)
                    sieve.doSieving(player, false);
                world.playSound(null, pos, SoundEvents.BLOCK_SAND_STEP, SoundCategory.BLOCKS, 0.3f, 0.6f);
            }
        }
        return true;
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
            IBlockState blockState, IProbeHitData data) {

        TileSieve sieve = (TileSieve) world.getTileEntity(data.getPos());
        if (sieve == null)
            return;

        if (sieve.getMeshStack().isEmpty()) {
            probeInfo.text(TextFormatting.RED + "{*top.exastris.nomesh*}");
            return;
        }

        probeInfo.progress(Math.round(sieve.getProgress() * 100), 100, probeInfo.defaultProgressStyle().suffix("%"));

        if (!sieve.getMeshStack().isEmpty()) {
            probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER))
                    .item(sieve.getMeshStack())
                    .text(TextFormatting.GREEN + " " + IProbeInfo.STARTLOC + sieve.getMeshStack().getUnlocalizedName()
                            + ".name"
                            + IProbeInfo.ENDLOC);
        }

        if (mode == ProbeMode.EXTENDED) {
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(sieve.getMeshStack());
            for (Map.Entry<Enchantment, Integer> enchantment : enchantments.entrySet()) {
                probeInfo.text(TextFormatting.BLUE + enchantment.getKey().getTranslatedName(enchantment.getValue()));
            }
        }
    }
}