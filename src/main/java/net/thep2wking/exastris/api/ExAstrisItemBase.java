package net.thep2wking.exastris.api;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.IHasModel;

public class ExAstrisItemBase extends Item implements IHasModel {
    private final String name;
    private final CreativeTabs tab;
    private final EnumRarity rarity;
    private final boolean hasEffect;

    public ExAstrisItemBase(String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
        this.name = name;
        this.tab = tab;
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        setUnlocalizedName(ExAstris.PREFIX + this.name);
        setRegistryName(ExAstris.PREFIX + this.name);
        setCreativeTab(this.tab);
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

    public String getName() {
		return this.name;
	}
}