package net.thep2wking.exastris.common.pebble;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import exnihilocreatio.items.ItemPebble;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.ExAstrisConstants;
import net.thep2wking.exastris.util.handler.IHasModel;

public class ItemExAstrisPebble extends ItemPebble implements IHasModel {
    private final String groupName;
    private final CreativeTabs tab;
    private final EnumRarity rarity;
    private final boolean hasEffect;

    private static final Int2ObjectMap<EnumExAstrisPebbleType> EXASTRIS_PEBBLE_TYPES = new Int2ObjectArrayMap<>();

    public ItemExAstrisPebble(String groupName, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
        this.groupName = groupName;
        this.tab = tab;
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        setUnlocalizedName(ExAstris.PREFIX + this.groupName);
        setCreativeTab(this.tab);
        setHasSubtypes(true);
        ExAstrisItems.ITEMS.add(this);

        EXASTRIS_PEBBLE_TYPES.put(EnumExAstrisPebbleType.NETHERRACK.meta, EnumExAstrisPebbleType.NETHERRACK);
        EXASTRIS_PEBBLE_TYPES.put(EnumExAstrisPebbleType.ENDSTONE.meta, EnumExAstrisPebbleType.ENDSTONE);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_CHISEL)) {
            EXASTRIS_PEBBLE_TYPES.put(EnumExAstrisPebbleType.MARBLE.meta, EnumExAstrisPebbleType.MARBLE);
            EXASTRIS_PEBBLE_TYPES.put(EnumExAstrisPebbleType.LIMESTONE.meta, EnumExAstrisPebbleType.LIMESTONE);
        }
    }

    @Override
    @SuppressWarnings("all")
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + ExAstris.PREFIX + groupName + "_" + EnumExAstrisPebbleType.getByMeta(stack.getMetadata()).name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nullable CreativeTabs tab, @Nonnull NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab))
            for (EnumExAstrisPebbleType type : EXASTRIS_PEBBLE_TYPES.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (EnumExAstrisPebbleType type : EnumExAstrisPebbleType.values()) {
            ModelLoader.setCustomModelResourceLocation(this, type.meta,
                    new ModelResourceLocation(ExAstris.PREFIX + groupName + "_" + type.name,
                            "inventory"));
        }
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
}