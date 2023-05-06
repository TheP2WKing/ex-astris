package net.thep2wking.exastris.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.content.item.crook.ItemFluxInfusedCrook;
import net.thep2wking.exastris.content.item.hammer.ItemFluxInfusedHammer;

public class ExAstrisRAItems {
    public static final List<Item> ITEMS_RA = new ArrayList<Item>();

    public static final Item HAMMER_FLUX = new ItemFluxInfusedHammer("hammer_flux", ExAstrisTabs.EXASTRIS_TAB,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.HAMMER.FLUX_HAMMER_MAX_ENERGY,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.HAMMER.FLUX_HAMMER_MAX_TRANSFER,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.HAMMER.FLUX_HAMMER_ENERGY_USE,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.HAMMER.FLUX_HAMMER_ENERGY_USE_EMPOWERED, 4, 6,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.HAMMER.FLUX_HAMMER_BASE_EFFICIENCY);
    public static final Item CROOK_FLUX = new ItemFluxInfusedCrook("crook_flux", ExAstrisTabs.EXASTRIS_TAB,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.CROOKS.FLUX_CROOK_MAX_ENERGY,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.CROOKS.FLUX_CROOK_MAX_TRANSFER,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.CROOKS.FLUX_CROOK_ENERGY_USE,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.CROOKS.FLUX_CROOK_ENERGY_USE_EMPOWERED, 2, 4,
            ExAstrisConfig.MODULE_REDSTONE_ARSENAL.CROOKS.FLUX_CROOK_BASE_EFFICIENCY);
}
