package net.thep2wking.exastris.modules.excompressum;

import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.api.recipe.ExAstrisApiHelper;
import net.thep2wking.exastris.config.ExAstrisConfig;

public class ExCompressumRecipes {
	public static void registerCraftingRecipes() {
		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.AUTOMATIC_SIEVE) {
			ExAstrisApiHelper.addShapedRecipe("automatic_sieve_thermalexpansion",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0), "A A", "ABA", "C C", 'A',
					"ingotInvar", 'B', "gearElectrum", 'C', "nuggetInvar");
			ExAstrisApiHelper.addShapedRecipe("automatic_sieve_enderio",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0), "A A", "ABA", "C C", 'A',
					"ingotElectricalSteel", 'B', "gearEnergized", 'C', "nuggetElectricalSteel");

			ExAstrisApiHelper.addShapelessRecipe("automatic_sieve_clear",
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0),
					new ItemStack(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, 1, 0));
		}

		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.SPEED_UPGRADE) {
			ExAstrisApiHelper.addShapedRecipe("speed_upgrade_thermalexpansion",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_SPEED, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetElectrum", 'B', "ingotInvar", 'C', "dustPyrotheum");
			ExAstrisApiHelper.addShapedRecipe("speed_upgrade_enderio",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_SPEED, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetVibrantAlloy", 'B', "ingotRedstoneAlloy", 'C', "ballDarkSteel");
		}

		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_SIEVE.FORTUNE_UPGRADE) {
			ExAstrisApiHelper.addShapedRecipe("fortune_upgrade_thermalexpansion",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_FORTUNE, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetElectrum", 'B', "ingotInvar", 'C', "gemCrystalFlux");
			ExAstrisApiHelper.addShapedRecipe("fortune_upgrade_enderio",
					new ItemStack(ExAstrisExCompressumItems.UPGRADE_FORTUNE, 2, 0), "ABA", "BCB", "ABA", 'A',
					"nuggetVibrantAlloy", 'B', "ingotRedstoneAlloy", 'C', "itemPulsatingCrystal");
		}
	}
}