package net.thep2wking.exastris.content.block.barrel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisMetaItemBlockBase;

public class ItemBlockExAstrisBarrelTier1 extends ExAstrisMetaItemBlockBase {
    public ItemBlockExAstrisBarrelTier1(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumBarrelTier1 type = EnumBarrelTier1.values()[meta];
        return "tile." + ExAstris.PREFIX + "barrel" + "_" + type.getMaterialType();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumBarrelTier1 type : EnumBarrelTier1.values()) {
                list.add(new ItemStack(this, 1, type.getMeta()));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}