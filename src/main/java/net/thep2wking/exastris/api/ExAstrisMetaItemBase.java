package net.thep2wking.exastris.api;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.IHasModel;
import net.thep2wking.exastris.util.handler.TooltipHandler;

import javax.annotation.Nullable;
import java.util.List;

public class ExAstrisMetaItemBase extends Item implements IHasModel {
    private final String groupName;
    private final CreativeTabs tab;
    private final EnumRarity rarity;
    private final boolean hasEffect;
    private final int tooltipLines;

    public ExAstrisMetaItemBase(String groupName, CreativeTabs tab, EnumRarity rarity, boolean hasEffect, int tooltipLines) {
        this.groupName = groupName;
        this.tab = tab;
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        this.tooltipLines = tooltipLines;
        setUnlocalizedName(ExAstris.PREFIX + this.groupName);
        setRegistryName(ExAstris.PREFIX + this.groupName);
        setCreativeTab(this.tab);
        setHasSubtypes(true);
        setMaxDamage(0);
        ExAstrisItems.ITEMS.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        ExAstris.PROXY.registerItemRenderer(this, 0, "inventory");
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
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (TooltipHandler.showShiftTip()) {
            for (int i = 1; i <= tooltipLines; ++i) {
                TooltipHandler.addShiftTooltip(tooltip, (ExAstris.PREFIX + this.groupName), i);
            }
        } else if (!TooltipHandler.showShiftTip() && !(tooltipLines == 0)) {
            TooltipHandler.addShiftKey(tooltip);
        }
    }

    public String getGroupName() {
        return this.groupName;
    }
}