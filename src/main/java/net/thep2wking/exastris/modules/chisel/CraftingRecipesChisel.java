package net.thep2wking.exastris.modules.chisel;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import team.chisel.common.init.ChiselBlocks;

public class CraftingRecipesChisel {
    public static void register() {
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "marble_from_pebble"), null,
                new ItemStack(ChiselBlocks.marble2, 1, 7),
                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 2));

        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "limestone_from_pebble"), null,
                new ItemStack(ChiselBlocks.limestone2, 1, 7),
                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 3));
    }
}