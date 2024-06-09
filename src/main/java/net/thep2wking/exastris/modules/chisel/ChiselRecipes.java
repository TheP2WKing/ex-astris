package net.thep2wking.exastris.modules.chisel;

import exnihilocreatio.util.ItemInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.api.recipe.ExAstrisRecipeHelper;
import net.thep2wking.exastris.api.recipe.ExAstrisModHelper;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisItems;
import team.chisel.common.init.ChiselBlocks;

public class ChiselRecipes {
	public static void registerCraftingRecipes() {
		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.MARBLE_PEBBLES_FROM_STONE) {
			ExAstrisRecipeHelper.addPebbleToBlockRecipe("marble", 2, new ItemStack(ChiselBlocks.marble2, 1, 7));
		}

		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.LIMESTONE_PEBBLES_FROM_STONE) {
			ExAstrisRecipeHelper.addPebbleToBlockRecipe("limestone", 3, new ItemStack(ChiselBlocks.limestone2, 1, 7));
		}
	}

	public static void registerSivetingRecipes() {
		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.MARBLE_PEBBLES_FROM_STONE) {
			ExAstrisRecipeHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.50f, "stone", 4);
			ExAstrisRecipeHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.25f, "stone", 4);
			ExAstrisRecipeHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.1f, "stone", 4);
		}

		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.LIMESTONE_PEBBLES_FROM_STONE) {
			ExAstrisRecipeHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.50f, "stone", 4);
			ExAstrisRecipeHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.25f, "stone", 4);
			ExAstrisRecipeHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.1f, "stone", 4);
		}
	}

	public static void registerBarrelRecipes() {
		if (ExAstrisConfig.MODULE_CHISEL.BARREL_RECIPES.BASALT_FROM_LAVA) {
			ExAstrisRecipeHelper.addFluidItemItemRecipe(new ItemInfo(ChiselBlocks.basalt2, 7), "stone",
					FluidRegistry.LAVA);
		}
	}

	public static void registerCarvingRecipes() {
		if (ExAstrisConfig.MODULE_CHISEL.CARVING_RECIPES.CONVERT_BETWEEN_BARRELS) {
			ExAstrisModHelper.addWoodBarrelCarvingRecipe(0, 0);
			ExAstrisModHelper.addWoodBarrelCarvingRecipe(1, 1);
			ExAstrisModHelper.addWoodBarrelCarvingRecipe(2, 2);
			ExAstrisModHelper.addWoodBarrelCarvingRecipe(3, 3);
			ExAstrisModHelper.addWoodBarrelCarvingRecipe(4, 4);
			ExAstrisModHelper.addWoodBarrelCarvingRecipe(5, 5);
		}

		if (ExAstrisConfig.MODULE_CHISEL.CARVING_RECIPES.CONVERT_BETWEEN_SIEVES) {
			ExAstrisModHelper.addSieveCarvingRecipe(0, 0);
			ExAstrisModHelper.addSieveCarvingRecipe(1, 1);
			ExAstrisModHelper.addSieveCarvingRecipe(2, 2);
			ExAstrisModHelper.addSieveCarvingRecipe(3, 3);
			ExAstrisModHelper.addSieveCarvingRecipe(4, 4);
			ExAstrisModHelper.addSieveCarvingRecipe(5, 5);
		}

		if (ExAstrisConfig.MODULE_CHISEL.CARVING_RECIPES.CONVERT_BETWEEN_WOODEN_CRUCIBLES) {
			ExAstrisModHelper.addCrucibleCarvingRecipe(0, 0);
			ExAstrisModHelper.addCrucibleCarvingRecipe(1, 1);
			ExAstrisModHelper.addCrucibleCarvingRecipe(2, 2);
			ExAstrisModHelper.addCrucibleCarvingRecipe(3, 3);
			ExAstrisModHelper.addCrucibleCarvingRecipe(4, 4);
			ExAstrisModHelper.addCrucibleCarvingRecipe(5, 5);
		}
	}

	public static void registerOreDict() {
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 0);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 1);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 2);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 3);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 4);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 5);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 6);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 7);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 8);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 9);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 10);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 11);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 12);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 13);
		ExAstrisRecipeHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 14);

		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 0);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 1);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 2);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 3);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 4);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 5);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 6);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 7);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 8);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 9);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 10);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 11);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 12);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 13);
		ExAstrisRecipeHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 14);

		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 0);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 1);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 2);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 3);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 4);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 5);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 6);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 7);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 8);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 9);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 10);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 11);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 12);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 13);
		ExAstrisRecipeHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 14);

		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 0);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 1);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 2);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 3);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 4);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 5);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 6);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 7);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 8);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 9);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 10);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 11);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 12);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 13);
		ExAstrisRecipeHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 14);

		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 0);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 1);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 2);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 3);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 4);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 5);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 6);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 7);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 8);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 9);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 10);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 11);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 12);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 13);
		ExAstrisRecipeHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 14);

		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 0);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 1);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 2);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 3);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 4);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 5);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 6);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 7);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 8);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 9);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 10);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 11);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 12);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 13);
		ExAstrisRecipeHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 14);

		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 0);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 1);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 2);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 3);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 4);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 5);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 6);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 7);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 8);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 9);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 10);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 11);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 12);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 13);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 14);
		ExAstrisRecipeHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 15);
	}
}
