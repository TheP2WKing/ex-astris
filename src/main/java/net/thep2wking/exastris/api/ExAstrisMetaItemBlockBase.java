package net.thep2wking.exastris.api;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.init.ExAstrisItems;

public class ExAstrisMetaItemBlockBase extends ItemBlock {
    private final EnumRarity rarity;
    private final boolean hasEffect;

    public ExAstrisMetaItemBlockBase(Block block, EnumRarity rarity, boolean hasEffect) {
        super(block);
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        setUnlocalizedName(block.getUnlocalizedName());
        setRegistryName(block.getRegistryName());
        setCreativeTab(block.getCreativeTabToDisplayOn());
        setHasSubtypes(true);
        setMaxDamage(0);
        ExAstrisItems.ITEMS.add(this);
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