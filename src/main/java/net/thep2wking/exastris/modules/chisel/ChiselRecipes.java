package net.thep2wking.exastris.modules.chisel;

import exnihilocreatio.util.ItemInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.api.recipe.ExAstrisApiHelper;
import net.thep2wking.exastris.api.recipe.ExAstrisModHelper;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisItems;
import team.chisel.common.init.ChiselBlocks;

public class ChiselRecipes {
	public static void registerCraftingRecipes() {
		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.MARBLE_PEBBLES_FROM_STONE) {
			ExAstrisApiHelper.addPebbleToBlockRecipe("marble", 2, new ItemStack(ChiselBlocks.marble2, 1, 7));
		}

		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.LIMESTONE_PEBBLES_FROM_STONE) {
			ExAstrisApiHelper.addPebbleToBlockRecipe("limestone", 3, new ItemStack(ChiselBlocks.limestone2, 1, 7));
		}
	}

	public static void registerSivetingRecipes() {
		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.MARBLE_PEBBLES_FROM_STONE) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.50f, "stone", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.25f, "stone", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.1f, "stone", 4);
		}

		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.LIMESTONE_PEBBLES_FROM_STONE) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.50f, "stone", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.25f, "stone", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.1f, "stone", 4);
		}
	}

	public static void registerBarrelRecipes() {
		if (ExAstrisConfig.MODULE_CHISEL.BARREL_RECIPES.BASALT_FROM_LAVA) {
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(ChiselBlocks.basalt2, 7), "stone",
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
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 0);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 1);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 2);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 3);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 4);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 5);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 6);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 7);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 8);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 9);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 10);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 11);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 12);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 13);
		ExAstrisApiHelper.addOreDict("plankWoodOak", Item.getByNameOrId("chisel:planks-oak"), 14);

		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 0);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 1);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 2);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 3);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 4);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 5);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 6);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 7);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 8);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 9);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 10);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 11);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 12);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 13);
		ExAstrisApiHelper.addOreDict("plankWoodSpruce", Item.getByNameOrId("chisel:planks-spruce"), 14);

		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 0);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 1);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 2);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 3);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 4);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 5);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 6);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 7);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 8);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 9);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 10);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 11);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 12);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 13);
		ExAstrisApiHelper.addOreDict("plankWoodBirch", Item.getByNameOrId("chisel:planks-birch"), 14);

		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 0);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 1);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 2);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 3);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 4);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 5);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 6);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 7);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 8);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 9);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 10);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 11);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 12);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 13);
		ExAstrisApiHelper.addOreDict("plankWoodJungle", Item.getByNameOrId("chisel:planks-jungle"), 14);

		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 0);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 1);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 2);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 3);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 4);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 5);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 6);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 7);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 8);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 9);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 10);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 11);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 12);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 13);
		ExAstrisApiHelper.addOreDict("plankWoodAcacia", Item.getByNameOrId("chisel:planks-acacia"), 14);

		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 0);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 1);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 2);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 3);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 4);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 5);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 6);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 7);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 8);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 9);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 10);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 11);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 12);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 13);
		ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Item.getByNameOrId("chisel:planks-dark-oak"), 14);

		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 0);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 1);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 2);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 3);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 4);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 5);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 6);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 7);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 8);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 9);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 10);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 11);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 12);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 13);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 14);
		ExAstrisApiHelper.addOreDict("netherBrick", Item.getByNameOrId("chisel:netherbrick"), 15);
	}
}
