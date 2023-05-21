package net.thep2wking.exastris.modules.redstonearsenal;

import cofh.redstonearsenal.init.RAItems;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisRedstoneArsenalItems;
import net.thep2wking.exastris.util.handler.ExAstrisApiHelper;

public class RedstoneArsenalRecipes {
	public static void registerCraftingRecipes() {
		if (ExAstrisConfig.MODULE_REDSTONE_ARSENAL.HAMMER.FLUX_HAMMER) {
			ExAstrisApiHelper.addHammerCraftingRecipe("flux",
					new ItemStack(ExAstrisRedstoneArsenalItems.HAMMER_FLUX, 1, 0), "ingotElectrumFlux",
					"stickFluxInfused");
		}

		if (ExAstrisConfig.MODULE_REDSTONE_ARSENAL.CROOKS.FLUX_CROOK) {
			ExAstrisApiHelper.addCrookCraftingRecipe("flux",
					new ItemStack(ExAstrisRedstoneArsenalItems.CROOK_FLUX, 1, 0), "ingotElectrumFlux",
					"stickFluxInfused");
		}
	}

	public static void registerOreDict() {
		ExAstrisApiHelper.addOreDict("stickFluxInfused", RAItems.itemMaterial, 193);
	}
}