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

public class ItemBlockExAstrisBarrelTier0 extends ExAstrisMetaItemBlockBase {
    private static final Int2ObjectMap<EnumExAstrisBarrelTier0> EXASTRIS_BARREL_T0_TYPES = new Int2ObjectArrayMap<>();

    public ItemBlockExAstrisBarrelTier0(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block, rarity, hasEffect);

        EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.OAK.meta, EnumExAstrisBarrelTier0.OAK);
        EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.SPRUCE.meta, EnumExAstrisBarrelTier0.SPRUCE);
        EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.BIRCH.meta, EnumExAstrisBarrelTier0.BIRCH);
        EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.JUNGLE.meta, EnumExAstrisBarrelTier0.JUNGLE);
        EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.ACACIA.meta, EnumExAstrisBarrelTier0.ACACIA);
        EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.DARK_OAK.meta, EnumExAstrisBarrelTier0.DARK_OAK);

        if(Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.GREATWOOD.meta, EnumExAstrisBarrelTier0.GREATWOOD);
            EXASTRIS_BARREL_T0_TYPES.put(EnumExAstrisBarrelTier0.SILVERWOOD.meta, EnumExAstrisBarrelTier0.SILVERWOOD);
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int meta = stack.getItemDamage();
        EnumExAstrisBarrelTier0 type = EnumExAstrisBarrelTier0.values()[meta];
        return "tile." + ExAstris.PREFIX + "barrel" + "_" + type.getName();
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            for (EnumExAstrisBarrelTier0 type : EXASTRIS_BARREL_T0_TYPES.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
        }
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}