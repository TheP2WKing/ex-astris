package net.thep2wking.exastris.modules.exastris;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import net.minecraft.init.Blocks;
import net.thep2wking.exastris.config.ExAstrisConfig;

@SuppressWarnings("null")
public class FluidTransformRecipesExAstris {
	public static void register() {
		if (ExAstrisConfig.MODULE_EX_ASTRIS.FLUID_TRANSFORM_RECIPES.PEACEWATER_FROM_WATER) {
			final BlockInfo[] transformingBlocksPeacewater = { new BlockInfo(Blocks.DIRT, 2) };
			final BlockInfo[] blocksToSpawnPeacewater = { new BlockInfo(Blocks.RED_FLOWER, 0),
					new BlockInfo(Blocks.YELLOW_FLOWER, 0), new BlockInfo(Blocks.RED_FLOWER, 1),
					new BlockInfo(Blocks.RED_FLOWER, 2), new BlockInfo(Blocks.RED_FLOWER, 3),
					new BlockInfo(Blocks.RED_FLOWER, 4), new BlockInfo(Blocks.RED_FLOWER, 5),
					new BlockInfo(Blocks.RED_FLOWER, 6), new BlockInfo(Blocks.RED_FLOWER, 7),
					new BlockInfo(Blocks.RED_FLOWER, 8) };
			final BlockInfo[] blocksToSpawnFrostwaterFlowersDisabled = {};

			if (ExAstrisConfig.MODULE_EX_ASTRIS.FLUID_TRANSFORM_RECIPES.PEACEWATER_SPAWNS_FLOWERS) {
				ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register("water", "peacewater",
						ExAstrisConfig.MODULE_EX_ASTRIS.FLUID_TRANSFORM_RECIPES.PEACEWATER_TRANSFORM_TIME,
						transformingBlocksPeacewater, blocksToSpawnPeacewater);
			} else {
				ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register("water", "peacewater",
						ExAstrisConfig.MODULE_EX_ASTRIS.FLUID_TRANSFORM_RECIPES.PEACEWATER_TRANSFORM_TIME,
						transformingBlocksPeacewater, blocksToSpawnFrostwaterFlowersDisabled);
			}

		}

		if (ExAstrisConfig.MODULE_EX_ASTRIS.FLUID_TRANSFORM_RECIPES.FROSTWATER_FROM_WATER) {
			final BlockInfo[] transformingBlocksFrostwater = { new BlockInfo(Blocks.STONE, 0) };
			final BlockInfo[] blocksToSpawnFrostwater = {};
			ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register("water", "frostwater",
					ExAstrisConfig.MODULE_EX_ASTRIS.FLUID_TRANSFORM_RECIPES.FROSTWATER_TRANSFORM_TIME,
					transformingBlocksFrostwater, blocksToSpawnFrostwater);
		}
	}
}