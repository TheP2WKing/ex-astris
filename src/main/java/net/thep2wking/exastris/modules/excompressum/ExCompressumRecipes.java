package net.thep2wking.exastris.modules.excompressum;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.api.recipe.ExAstrisRecipeHelper;
import net.thep2wking.exastris.config.ExAstrisConfig;

public class ExCompressumRecipes {
	public static void registerCraftingRecipes() {
		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.AUTOMATIC_SIEVE) {
			ExAstrisRecipeHelper.addShapedRecipe("automatic_sieve_thermalexpansion",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0), "A A", "ABA", "C C", 'A',
					"ingotInvar", 'B', "gearElectrum", 'C', "nuggetInvar");
			ExAstrisRecipeHelper.addShapedRecipe("automatic_sieve_enderio",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0), "A A", "ABA", "C C", 'A',
					"ingotElectricalSteel", 'B', "gearEnergized", 'C', "nuggetElectricalSteel");

			ExAstrisRecipeHelper.addShapelessRecipe("automatic_sieve_clear",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0),
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0));
		}

		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.AUTOMATIC_HAMMERER) {
			ExAstrisRecipeHelper.addShapedRecipe("automatic_hammerer_thermalexpansion",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_HAMMERER, 1, 0), "ABA", "ACA", "ADA", 'A',
					"ingotInvar", 'B', "craftingPiston", 'C', new ItemStack(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE), 'D',
					"anvil");
			ExAstrisRecipeHelper.addShapedRecipe("automatic_hammerer_enderio",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_HAMMERER, 1, 0), "ABA", "ACA", "ADA", 'A',
					"ingotDarkSteel", 'B', "craftingPiston", 'C', new ItemStack(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE),
					'D', "anvil");

			ExAstrisRecipeHelper.addShapelessRecipe("automatic_hammerer_clear",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_HAMMERER, 1, 0),
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_HAMMERER, 1, 0));
		}

		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.SPEED_UPGRADE) {
			ExAstrisRecipeHelper.addShapedRecipe("speed_upgrade_thermalexpansion",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_SPEED, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetElectrum", 'B', "ingotInvar", 'C', "dustPyrotheum");
			ExAstrisRecipeHelper.addShapedRecipe("speed_upgrade_enderio",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_SPEED, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetVibrantAlloy", 'B', "ingotRedstoneAlloy", 'C', "ballDarkSteel");
		}

		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.FORTUNE_UPGRADE) {
			ExAstrisRecipeHelper.addShapedRecipe("fortune_upgrade_thermalexpansion",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_FORTUNE, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetElectrum", 'B', "ingotInvar", 'C', "gemCrystalFlux");
			ExAstrisRecipeHelper.addShapedRecipe("fortune_upgrade_enderio",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_FORTUNE, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetVibrantAlloy", 'B', "ingotRedstoneAlloy", 'C', "itemPulsatingCrystal");
		}
	}

	public static void registerOreDict() {
		ExAstrisRecipeHelper.addOreDict("craftingPiston", Blocks.PISTON, 0);
		ExAstrisRecipeHelper.addOreDict("craftingPiston", Blocks.STICKY_PISTON, 0);

		ExAstrisRecipeHelper.addOreDict("anvil", Blocks.ANVIL, 0);
		ExAstrisRecipeHelper.addOreDict("anvil", Blocks.ANVIL, 1);
		ExAstrisRecipeHelper.addOreDict("anvil", Blocks.ANVIL, 2);

		if (Loader.isModLoaded("enderio")) {
			ExAstrisRecipeHelper.addOreDict("anvil", Block.getBlockFromName("enderio:block_dark_steel_anvil"), 0);
			ExAstrisRecipeHelper.addOreDict("anvil", Block.getBlockFromName("enderio:block_dark_steel_anvil"), 1);
			ExAstrisRecipeHelper.addOreDict("anvil", Block.getBlockFromName("enderio:block_dark_steel_anvil"), 2);
		}
	}
}