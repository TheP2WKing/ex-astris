package net.thep2wking.exastris.modules.vanilla;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisFluids;

public class VanillaCrucibleRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.SLIME_FROM_SLIME_BLOCK) {
			ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("blockSlime", ExAstrisFluids.SLIME,
					ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.SLIME_PER_SLIME_BLOCK);
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.WATER_FROM_ICE) {
			ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("blockIce", FluidRegistry.WATER,
					ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.WATER_PER_ICE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_FROM_HRAD_STONE) {
			ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register(
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_HARD_STONE)),
					FluidRegistry.LAVA, ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_PER_HARD_STONE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_FROM_STONE_BRICKS) {
			ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("stoneBricks", FluidRegistry.LAVA,
					ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_PER_STONE_BRICKS);
		}
	}
}