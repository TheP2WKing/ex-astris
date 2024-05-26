package net.thep2wking.exastris.modules.thaumcraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.api.ExAstrisItemCrookBase;
import net.thep2wking.exastris.api.ExAstrisItemHammerBase;
import net.thep2wking.exastris.init.ExAstrisTabs;
import net.thep2wking.exastris.modules.thaumcraft.content.ItemElementalCrook;
import net.thep2wking.exastris.modules.thaumcraft.content.ItemElementalHammer;
import net.thep2wking.exastris.modules.thaumcraft.content.ItemVoidCrook;
import net.thep2wking.exastris.modules.thaumcraft.content.ItemVoidHammer;
import net.thep2wking.exastris.util.handler.RarityHandler;
import thaumcraft.api.ThaumcraftMaterials;
import thaumcraft.api.items.ItemsTC;

public class ExAstrisThaumcraftItems {
	public static final List<Item> ITEMS_THAUMCRAFT = new ArrayList<Item>();

	public static final Item HAMMER_THAUMIUM = new ExAstrisItemHammerBase("hammer_thaumium",
			ThaumcraftMaterials.TOOLMAT_THAUMIUM, new ItemStack(ItemsTC.ingots, 1, 0), 4096, 0, 0,
			ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
	public static final Item CROOK_THAUMIUM = new ExAstrisItemCrookBase("crook_thaumium",
			ThaumcraftMaterials.TOOLMAT_THAUMIUM, new ItemStack(ItemsTC.ingots, 1, 0), 1024, -2.5f, 0,
			ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);

	public static final Item HAMMER_VOID = new ItemVoidHammer("hammer_void",
			ThaumcraftMaterials.TOOLMAT_VOID, new ItemStack(ItemsTC.ingots, 1, 1), 2048, 0, 0,
			ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
	public static final Item CROOK_VOID = new ItemVoidCrook("crook_void",
			ThaumcraftMaterials.TOOLMAT_VOID, new ItemStack(ItemsTC.ingots, 1, 1), 512, -3f, 0,
			ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);

	public static final Item HAMMER_ELEMENTAL = new ItemElementalHammer("hammer_elemental",
			ThaumcraftMaterials.TOOLMAT_ELEMENTAL, new ItemStack(ItemsTC.ingots, 1, 0), 6000, 0, 0,
			ExAstrisTabs.EXASTRIS_TAB, RarityHandler.AQUA, false);
	public static final Item CROOK_ELEMENTAL = new ItemElementalCrook("crook_elemental",
			ThaumcraftMaterials.TOOLMAT_ELEMENTAL, new ItemStack(ItemsTC.ingots, 1, 0), 3000, -3, 0,
			ExAstrisTabs.EXASTRIS_TAB, RarityHandler.AQUA, false);
}
