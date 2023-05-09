package net.thep2wking.exastris.modules.chisel;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisItems;
import team.chisel.common.init.ChiselBlocks;

public class ChiselCraftingRecipes {
    public static void register() {
        if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.MARBLE_PEBBLES_FROM_STONE) {
            GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "marble_from_pebble"), null,
                    new ItemStack(ChiselBlocks.marble2, 1, 7), "AA", "AA", 'A',
                    new ItemStack(ExAstrisItems.PEBBLES, 1, 2));
        }

        if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.LIMESTONE_PEBBLES_FROM_STONE) {
            GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "limestone_from_pebble"), null,
                    new ItemStack(ChiselBlocks.limestone2, 1, 7), "AA", "AA", 'A',
                    new ItemStack(ExAstrisItems.PEBBLES, 1, 3));
        }
    }
}