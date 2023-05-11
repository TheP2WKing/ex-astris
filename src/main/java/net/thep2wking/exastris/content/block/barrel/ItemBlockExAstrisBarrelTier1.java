package net.thep2wking.exastris.content.block.barrel;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisMetaItemBlockBase;

public class ItemBlockExAstrisBarrelTier1 extends ExAstrisMetaItemBlockBase {
    private static final Int2ObjectMap<EnumExAstrisBarrelTier1> EXASTRIS_BARREL_T1_TYPES = new Int2ObjectArrayMap<>();

    public ItemBlockExAstrisBarrelTier1(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);

        EXASTRIS_BARREL_T1_TYPES.put(EnumExAstrisBarrelTier1.STONE.meta, EnumExAstrisBarrelTier1.STONE);
        EXASTRIS_BARREL_T1_TYPES.put(EnumExAstrisBarrelTier1.COBBLESTONE.meta, EnumExAstrisBarrelTier1.COBBLESTONE);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumExAstrisBarrelTier1 type = EnumExAstrisBarrelTier1.values()[meta];
        return "tile." + ExAstris.PREFIX + "barrel" + "_" + type.getName();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumExAstrisBarrelTier1 type : EXASTRIS_BARREL_T1_TYPES.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}