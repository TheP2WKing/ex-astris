package net.thep2wking.exastris.modules.exnihilo;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;

public class ExNihiloSmeltingRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_EX_NIHILO.OVERRIDES.REPLACE_EX_NIHILO_BARRELS) {
			GameRegistry.addSmelting(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 1),
					new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 0), 0.1f);
		}
	}
}