package net.thep2wking.exastris.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.thep2wking.exastris.content.item.crook.ItemFluxInfusedCrook;
import net.thep2wking.exastris.content.item.hammer.ItemFluxInfusedHammer;

public class ExAstrisRAItems {
    public static final List<Item> ITEMS_RA = new ArrayList<Item>();

        public static final Item HAMMER_FLUX = new ItemFluxInfusedHammer("hammer_flux", ExAstrisTabs.EXASTRIS_TAB,
                       320000, 4000, 400, 800, 4, 6, 16f);
        public static final Item CROOK_FLUX = new ItemFluxInfusedCrook("crook_flux", ExAstrisTabs.EXASTRIS_TAB, 320000,
                        4000, 200, 400, 2, 4, 6f);
}
