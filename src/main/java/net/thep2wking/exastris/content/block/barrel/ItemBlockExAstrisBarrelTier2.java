package net.thep2wking.exastris.content.block.barrel;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisMetaItemBlockBase;
import net.thep2wking.exastris.util.ExAstrisConstants;

public class ItemBlockExAstrisBarrelTier2 extends ExAstrisMetaItemBlockBase {
    private static final Int2ObjectMap<EnumExAstrisBarrelTier2> EXASTRIS_BARREL_T2_TYPES = new Int2ObjectArrayMap<>();

    public ItemBlockExAstrisBarrelTier2(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);

        EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.IRON.meta, EnumExAstrisBarrelTier2.IRON);
        EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.GOLD.meta, EnumExAstrisBarrelTier2.GOLD);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.ALCHEMICAL_BRASS.meta, EnumExAstrisBarrelTier2.ALCHEMICAL_BRASS);
            EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.THAUMIUM.meta, EnumExAstrisBarrelTier2.THAUMIUM);
            EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.VOID_METAL.meta, EnumExAstrisBarrelTier2.VOID_METAL);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumExAstrisBarrelTier2 type = EnumExAstrisBarrelTier2.values()[meta];
        return "tile." + ExAstris.PREFIX + "barrel" + "_" + type.getName();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumExAstrisBarrelTier2 type : EXASTRIS_BARREL_T2_TYPES.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}