package net.thep2wking.exastris.content.block.barrel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisMetaItemBlockBase;

public class ItemBlockExAstrisBarrelTier0 extends ExAstrisMetaItemBlockBase {
    public ItemBlockExAstrisBarrelTier0(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumBarrelTier0 type = EnumBarrelTier0.values()[meta];
        return "tile." + ExAstris.PREFIX + "barrel" + "_" + type.getMaterialType();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumBarrelTier0 type : EnumBarrelTier0.values()) {
                list.add(new ItemStack(this, 1, type.getMeta()));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}