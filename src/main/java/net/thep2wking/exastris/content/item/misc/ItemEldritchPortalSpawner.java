package net.thep2wking.exastris.content.item.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.thep2wking.exastris.api.ExAstrisItemBase;

public class ItemEldritchPortalSpawner extends ExAstrisItemBase {
	public ItemEldritchPortalSpawner(String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(name, tab, rarity, hasEffect);
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote) {
			playerIn.sendMessage(new TextComponentString(TextFormatting.RED
					+ "The Eldritch Dimension is not implemented in Thaumcraft 6. Install Thaumic Augmentation by TheCodex6824 to function properly."));
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
}