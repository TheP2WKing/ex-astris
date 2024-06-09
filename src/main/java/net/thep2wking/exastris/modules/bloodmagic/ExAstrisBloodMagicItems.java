package net.thep2wking.exastris.modules.bloodmagic;

import net.minecraft.item.Item;
import net.thep2wking.exastris.api.ExAstrisItemBase;
import net.thep2wking.exastris.init.ExAstrisTabs;
import net.thep2wking.exastris.modules.bloodmagic.content.ItemBoundCrook;
import net.thep2wking.exastris.modules.bloodmagic.content.ItemBoundHammer;
import net.thep2wking.exastris.util.handler.RarityHandler;

public class ExAstrisBloodMagicItems {
	public static final Item UNCHARGED_NETHER_STAR = new ExAstrisItemBase("uncharged_nether_star", ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);

	public static final Item HAMMER_BOUND = new ItemBoundHammer("hammer_bound", ExAstrisTabs.EXASTRIS_TAB);
	public static final Item CROOK_BOUND = new ItemBoundCrook("crook_bound", ExAstrisTabs.EXASTRIS_TAB);
}