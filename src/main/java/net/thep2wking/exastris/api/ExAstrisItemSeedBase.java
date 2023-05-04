package net.thep2wking.exastris.api;

import javax.annotation.Nonnull;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ExAstrisItemSeedBase extends ExAstrisItemBase implements IPlantable {
    private final IBlockState plant;
    private EnumPlantType plantType;

    public ExAstrisItemSeedBase(String name, IBlockState plant, EnumPlantType plantType, CreativeTabs tab,
            EnumRarity rarity, boolean hasEffect) {
        super(name, tab, rarity, hasEffect);
        this.plantType = plantType;
        this.plant = plant;
    }

    public ExAstrisItemSeedBase setPlantType(EnumPlantType plantType) {
        this.plantType = plantType;
        return this;
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return plantType;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return plant;
    }

    @Override
    @Nonnull
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing,
            float hitX, float hitY, float hitZ) {
        if (!facing.equals(EnumFacing.UP))
            return EnumActionResult.PASS;

        ItemStack stack = player.getHeldItem(hand);

        if (player.canPlayerEdit(pos, facing, stack) && player.canPlayerEdit(pos.add(0, 1, 0), facing, stack)) {
            IBlockState soil = world.getBlockState(pos);

            if (soil.getBlock().canSustainPlant(soil, world, pos, EnumFacing.UP, this)
                    && world.isAirBlock(pos.add(0, 1, 0))
                    && this.getPlant(world, pos) != null) {
                world.setBlockState(pos.add(0, 1, 0), this.getPlant(world, pos));
                if (!player.isCreative())
                    stack.shrink(1);

                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }
}