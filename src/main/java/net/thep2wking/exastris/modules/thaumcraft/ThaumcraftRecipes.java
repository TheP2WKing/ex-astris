package net.thep2wking.exastris.modules.thaumcraft;

import net.thep2wking.exastris.util.handler.ExAstrisApiHelper;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;

@SuppressWarnings("null")
public class ThaumcraftRecipes {
	public static void registerCraftingRecipes() {

	}

	public static void registerArcaneCraftingRecipes() {
		
	}

	public static void registerCrucibleRecipes() {
		
	}

	public static void registerInfusionRecipes() {
		
	}

	public static void registerHammeringRecipes() {
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.AIR), 1f, "sandstone", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.EARTH), 1f, "grass", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.FIRE), 1f, "netherBrick", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.WATER), 1f, "blockIce", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.ORDER), 1f, "stone", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.ENTROPY), 1f, "tnt", 0);
	}

	public static void registerSivetingRecipes() {
		
	}
}
