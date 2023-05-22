package net.thep2wking.exastris.modules.vanilla.content;

import javax.annotation.Nullable;

import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisBlockBase;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.integration.top.ITOPInfoProvider;
import net.thep2wking.exastris.util.handler.EnumToolType;

@SuppressWarnings("deprecation")
public class BlockFrostyDirt extends ExAstrisBlockBase implements ITileEntityProvider, ITOPInfoProvider {
    public BlockFrostyDirt(String name, CreativeTabs tab, Material material, SoundType sound, int harvestLevel,
            EnumToolType toolType, float hardness, float resistance, float lightLevel) {
        super(name, tab, material, sound, harvestLevel, toolType, hardness, resistance, lightLevel);
        GameRegistry.registerTileEntity(TileFrostyDirt.class, ExAstris.PREFIX + name);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    @Nullable
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileFrostyDirt();
    }

    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SuppressWarnings("null")
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
            IBlockState blockState, IProbeHitData data) {
        if (ExAstrisConfig.MODULE_VANILLA.BLOCK_TRANSFORMATION.SNOW_FROM_FROSTY_DIRT) {
            TileFrostyDirt tile = (TileFrostyDirt) world.getTileEntity(data.getPos());

            probeInfo.progress(tile.getVolume(), 100, probeInfo.defaultProgressStyle().suffix("%"));

            probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER))
                    .text(TextFormatting.WHITE + "{*top.exastris.transforming*}" + " ")
                    .item(new ItemStack(Item.getItemFromBlock(Blocks.SNOW), 1, 0));
        }
    }
}