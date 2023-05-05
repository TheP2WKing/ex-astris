package net.thep2wking.exastris.content.block.sieve;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisMetaItemBlockBase;

public class ItemBlockExAstrisSieve extends ExAstrisMetaItemBlockBase {
    private static final Int2ObjectMap<EnumExAstrisSieve> EXASTRIS_SIEVE_TYPES = new Int2ObjectArrayMap<>();
    
    public ItemBlockExAstrisSieve(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);

        EXASTRIS_SIEVE_TYPES.put(EnumExAstrisSieve.OAK.meta, EnumExAstrisSieve.OAK);
        EXASTRIS_SIEVE_TYPES.put(EnumExAstrisSieve.SPRUCE.meta, EnumExAstrisSieve.SPRUCE);
        EXASTRIS_SIEVE_TYPES.put(EnumExAstrisSieve.BIRCH.meta, EnumExAstrisSieve.BIRCH);
        EXASTRIS_SIEVE_TYPES.put(EnumExAstrisSieve.JUNGLE.meta, EnumExAstrisSieve.JUNGLE);
        EXASTRIS_SIEVE_TYPES.put(EnumExAstrisSieve.ACACIA.meta, EnumExAstrisSieve.ACACIA);
        EXASTRIS_SIEVE_TYPES.put(EnumExAstrisSieve.DARK_OAK.meta, EnumExAstrisSieve.DARK_OAK);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumExAstrisSieve type = EnumExAstrisSieve.values()[meta];
        return "tile." + ExAstris.PREFIX + "sieve" + "_" + type.getName();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumExAstrisSieve type : EXASTRIS_SIEVE_TYPES.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}