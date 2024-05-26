package net.thep2wking.exastris.modules.excompressum.content;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thep2wking.exastris.api.ExAstrisItemBase;

public class ItemUpgradeSpeed extends ExAstrisItemBase {
	public ItemUpgradeSpeed(String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(name, tab, rarity, hasEffect);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Upgrade for Automatic Sieve");
	}
}