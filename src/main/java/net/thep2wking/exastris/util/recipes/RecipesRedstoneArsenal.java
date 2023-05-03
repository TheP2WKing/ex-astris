package net.thep2wking.exastris.util.recipes;

import cofh.redstonearsenal.init.RAItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisRAItems;

public class RecipesRedstoneArsenal {
    public static void register() {
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "hammer_flux"), null,
                new ItemStack(ExAstrisRAItems.HAMMER_FLUX, 1, 0),
                " A ", " BA", "B  ", 'A', new ItemStack(RAItems.itemMaterial, 1, 32), 'B',
                new ItemStack(RAItems.itemMaterial, 1, 193));

        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "crook_flux"), null,
                new ItemStack(ExAstrisRAItems.CROOK_FLUX, 1, 0),
                "AAB", " B ", "B  ", 'A', new ItemStack(RAItems.itemMaterial, 1, 32), 'B',
                new ItemStack(RAItems.itemMaterial, 1, 193));
    }
}