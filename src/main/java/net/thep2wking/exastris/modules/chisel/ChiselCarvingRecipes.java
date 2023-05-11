package net.thep2wking.exastris.modules.chisel;

import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import team.chisel.api.carving.CarvingUtils;

@SuppressWarnings("null")
public class ChiselCarvingRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_CHISEL.CARVING_RECIPES.CONVERT_BETWEEN_BARRELS && ExAstrisConfig.MODULE_EX_NIHILO.OVERRIDES.REPLACE_EX_NIHILO_BARRELS) {
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 0), 0));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 1), 1));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 2), 2));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 3), 3));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 4), 4));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 5), 5));
		}

		if (ExAstrisConfig.MODULE_CHISEL.CARVING_RECIPES.CONVERT_BETWEEN_SIEVES && ExAstrisConfig.MODULE_EX_NIHILO.OVERRIDES.REPLACE_EX_NIHILO_SIEVES) {
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "sieve",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 0), 0));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "sieve",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 1), 1));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "sieve",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 2), 2));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "sieve",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 3), 3));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "sieve",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 4), 4));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "sieve",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 5), 5));
		}

		if (ExAstrisConfig.MODULE_CHISEL.CARVING_RECIPES.CONVERT_BETWEEN_WOODEN_CRUCIBLES && ExAstrisConfig.MODULE_EX_NIHILO.OVERRIDES.REPLACE_EX_NIHILO_WOODEN_CRUCIBLES) {
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "crucible",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, 0), 0));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "crucible",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, 1), 1));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "crucible",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, 2), 2));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "crucible",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, 3), 3));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "crucible",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, 4), 4));
			CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "crucible",
					CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, 5), 5));
		}
	}
}