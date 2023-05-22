package net.thep2wking.exastris.modules.vanilla.content;

import javax.annotation.Nonnull;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDirt.DirtType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thep2wking.exastris.api.ExAstrisItemBase;

public class ItemPodzolSeed extends ExAstrisItemBase {

    public ItemPodzolSeed(String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
        super(name, tab, rarity, hasEffect);
    }

    @Override
    @Nonnull
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        ItemStack stack = player.getHeldItem(hand);
        IBlockState state = world.getBlockState(pos);
        if (state != Blocks.AIR.getDefaultState() && state.getBlock() != Blocks.AIR
                && state != Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.PODZOL)
                && state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS) {
            IBlockState transformTo = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, DirtType.PODZOL);
            world.setBlockState(pos, transformTo);
            stack.shrink(1);
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
}