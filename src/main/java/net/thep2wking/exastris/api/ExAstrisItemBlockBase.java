package net.thep2wking.exastris.api;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.TooltipHandler;

public class ExAstrisItemBlockBase extends ItemBlock {
    private final EnumRarity rarity;
    private final boolean hasEffect;
    private final int tooltipLines;

    public ExAstrisItemBlockBase(Block block, EnumRarity rarity, boolean hasEffect, int tooltipLines) {
        super(block);
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        this.tooltipLines = tooltipLines;
        setUnlocalizedName(block.getUnlocalizedName());
        setRegistryName(block.getRegistryName());
        setCreativeTab(block.getCreativeTabToDisplayOn());
        ExAstrisItems.ITEMS.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        if (!stack.isItemEnchanted()) {
            return this.rarity;
        } else if (stack.isItemEnchanted()) {
            switch (this.rarity) {
                case COMMON:
                case UNCOMMON:
                    return EnumRarity.RARE;
                case RARE:
                    return EnumRarity.EPIC;
                case EPIC:
                default:
                    return this.rarity;
            }
        }
        return EnumRarity.COMMON;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return this.hasEffect || stack.isItemEnchanted();
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("null")
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (TooltipHandler.showShiftTip()) {
            for (int i = 1; i <= tooltipLines; ++i) {
                TooltipHandler.addShiftTooltip(tooltip, (block.getRegistryName().toString()), i);
            }
        } else if (!TooltipHandler.showShiftTip() && !(tooltipLines == 0)) {
            TooltipHandler.addShiftKey(tooltip);
        }
    }
}