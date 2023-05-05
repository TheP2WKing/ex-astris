package net.thep2wking.exastris.content.block.sieve;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisMetaItemBlockBase;

public class ItemBlockExAstrisSieve extends ExAstrisMetaItemBlockBase {
    public ItemBlockExAstrisSieve(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumExAstrisSieve type = EnumExAstrisSieve.values()[meta];
        return "tile." + ExAstris.PREFIX + "sieve" + "_" + type.getMaterialType();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumExAstrisSieve type : EnumExAstrisSieve.values()) {
                list.add(new ItemStack(this, 1, type.getMeta()));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}