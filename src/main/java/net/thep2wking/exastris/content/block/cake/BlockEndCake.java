package net.thep2wking.exastris.content.block.cake;

import javax.annotation.Nonnull;

import org.jetbrains.annotations.NotNull;

import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.integration.top.ITOPInfoProvider;
import net.thep2wking.exastris.util.handler.IHasModel;

public class BlockEndCake extends BlockCake implements IHasModel, ITOPInfoProvider {
    private final String name;
    private final CreativeTabs tab;
    private final SoundType sound;
    private final float hardness;
    private final float resistance;
    private final float lightLevel;

    public BlockEndCake(String name, CreativeTabs tab, Material material, SoundType sound, float hardness,
            float resistance, float lightLevel) {
        super();
        this.name = name;
        this.tab = tab;
        this.sound = sound;
        this.hardness = hardness;
        this.resistance = resistance;
        this.lightLevel = lightLevel;
        setUnlocalizedName(ExAstris.PREFIX + this.name);
        setRegistryName(ExAstris.PREFIX + this.name);
        setSoundType(this.sound);
        setHardness(this.hardness);
        setResistance(this.resistance);
        setLightLevel(this.lightLevel);
        setCreativeTab(this.tab);
        setDefaultState(this.blockState.getBaseState().withProperty(BITES, 0));
        ExAstrisBlocks.BLOCKS.add(this);

        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("This is an intended overwrite, overwriting the default Ex Nihilo End Cake");
        }
    }

    @Override
    public void registerModels() {
        ExAstris.PROXY.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    @SuppressWarnings("null")
    public boolean onBlockActivated(World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state,
            EntityPlayer playerIn, @Nonnull EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (itemstack.isEmpty()) {
            return this.eatCake(worldIn, pos, state, playerIn);
        } else {
            int bites = state.getValue(BlockCake.BITES);
            if (itemstack.getItem() == Items.ENDER_EYE && bites > 0) {
                if (!worldIn.isRemote) {
                    worldIn.setBlockState(pos, state.withProperty(BITES, bites - 1), 3);
                    worldIn.playSound((EntityPlayer) null, pos, SoundEvents.BLOCK_END_PORTAL_FRAME_FILL,
                            SoundCategory.BLOCKS, 0.5f, 1f);
                    itemstack.shrink(1);
                }
                return true;
            }
        }
        return false;
    }

    private boolean eatCake(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (!worldIn.isRemote && !player.isRiding() && player.isCreative()) {
            player.changeDimension(1);
        }

        if (!player.canEat(true) || player.dimension == 1) {
            return false;
        } else {
            player.addStat(StatList.CAKE_SLICES_EATEN);
            player.getFoodStats().addStats(2, 0.1F);
            int i = state.getValue(BITES);

            if (i < 6) {
                worldIn.setBlockState(pos, state.withProperty(BITES, i + 1), 3);
            } else {
                worldIn.setBlockToAir(pos);
            }

            if (!worldIn.isRemote && !player.isRiding()) {
                player.changeDimension(1);
            }
            return true;
        }
    }

    @NotNull
    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(ExAstrisItems.END_CAKE);
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
            IBlockState blockState, IProbeHitData data) {
        Block block = world.getBlockState(data.getPos()).getBlock();
        if (block instanceof BlockEndCake) {
            probeInfo.progress(7 - blockState.getValue(BITES), 7, probeInfo.defaultProgressStyle().suffix(" " + I18n.format("top.exastris.bites")));

            // probeInfo.horizontal().progress(7 - blockState.getValue(BITES), 7,
            // probeInfo.defaultProgressStyle()
            // .suffix(" Bites
            // left").filledColor(0xFF26722f).alternateFilledColor(0xFF1a3c3c)
            // .borderColor(0xFFFFFFFF));

            probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER))
                    .text(TextFormatting.WHITE + "{*top.exastris.refill*}" + " ")
                    .item(new ItemStack(Items.ENDER_EYE, 1, 0));
        }
    }
}
