package net.thep2wking.exastris.modules.chisel;

import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.ItemInfo;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisItems;

@SuppressWarnings("null")
public class SieveRecipesChisel {
	public static void register() {
		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.MARBLE_PEBBLES_FROM_STONE) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone", new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.05f,
					BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone", new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.10f,
					BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone", new ItemInfo(ExAstrisItems.PEBBLES, 2), 0.25f,
					BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_CHISEL.SIEVE_RECIPES.LIMESTONE_PEBBLES_FROM_STONE) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone", new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.05f,
					BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone", new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.10f,
					BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone", new ItemInfo(ExAstrisItems.PEBBLES, 3), 0.25f,
					BlockSieve.MeshType.DIAMOND.getID());
		}
	}
}