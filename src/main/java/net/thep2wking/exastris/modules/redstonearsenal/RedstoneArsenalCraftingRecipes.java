package net.thep2wking.exastris.modules.redstonearsenal;

import cofh.redstonearsenal.init.RAItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisRAItems;

public class RedstoneArsenalCraftingRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_REDSTONE_ARSENAL.HAMMER.FLUX_HAMMER) {
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "hammer_flux"), null,
					new ItemStack(ExAstrisRAItems.HAMMER_FLUX, 1, 0),
					" A ", " BA", "B  ", 'A', new ItemStack(RAItems.itemMaterial, 1, 32), 'B',
					new ItemStack(RAItems.itemMaterial, 1, 193));
		}

		if (ExAstrisConfig.MODULE_REDSTONE_ARSENAL.CROOKS.FLUX_CROOK) {
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "crook_flux"), null,
					new ItemStack(ExAstrisRAItems.CROOK_FLUX, 1, 0),
					"AAB", " B ", "B  ", 'A', new ItemStack(RAItems.itemMaterial, 1, 32), 'B',
					new ItemStack(RAItems.itemMaterial, 1, 193));
		}
	}
}