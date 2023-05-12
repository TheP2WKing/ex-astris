package net.thep2wking.exastris.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.api.ExAstrisItemHammerBase;
import net.thep2wking.exastris.util.handler.RarityHandler;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.items.ItemsTC;

public class ExAstrisThaumcraftItems {
	public static final List<Item> ITEMS_THAUMCRAFT = new ArrayList<Item>();

	public static final Item HAMMER_THAUMIUM = new ExAstrisItemHammerBase("hammer_thaumium",
			ThaumcraftMaterials.TOOLMAT_THAUMIUM, new ItemStack(ItemsTC.ingots, 1, 0), 2048, 0, 0,
			ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
}
