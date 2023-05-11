package net.thep2wking.exastris.content.block.crucible;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisMetaItemBlockBase;

public class ItemBlockExAstrisWoodCrucuble extends ExAstrisMetaItemBlockBase {
    private static final Int2ObjectMap<EnumExAstrisWoodCricible> EXASTRIS_WOOD_CRUCIBLE_TYPES = new Int2ObjectArrayMap<>();
    
    public ItemBlockExAstrisWoodCrucuble(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);

        EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.OAK.meta, EnumExAstrisWoodCricible.OAK);
        EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.SPRUCE.meta, EnumExAstrisWoodCricible.SPRUCE);
        EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.BIRCH.meta, EnumExAstrisWoodCricible.BIRCH);
        EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.JUNGLE.meta, EnumExAstrisWoodCricible.JUNGLE);
        EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.ACACIA.meta, EnumExAstrisWoodCricible.ACACIA);
        EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.DARK_OAK.meta, EnumExAstrisWoodCricible.DARK_OAK);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumExAstrisWoodCricible type = EnumExAstrisWoodCricible.values()[meta];
        return "tile." + ExAstris.PREFIX + "crucible" + "_" + type.getName();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumExAstrisWoodCricible type : EXASTRIS_WOOD_CRUCIBLE_TYPES.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}