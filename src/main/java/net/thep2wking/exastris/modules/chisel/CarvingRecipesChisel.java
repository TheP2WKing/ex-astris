package net.thep2wking.exastris.modules.chisel;

import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import team.chisel.api.carving.CarvingUtils;

@SuppressWarnings("null")
public class CarvingRecipesChisel {
    public static void register() {
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
}