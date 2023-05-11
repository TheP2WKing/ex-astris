package net.thep2wking.exastris.modules.vanilla;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import net.minecraft.init.Blocks;
import net.thep2wking.exastris.config.ExAstrisConfig;

@SuppressWarnings("null")
public class VanillaHeatSources {
	public static void register() {
		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.LIT_REDSTONE_LAMP) {
			ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.LIT_REDSTONE_LAMP),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.LIT_REDSTONE_LAMP_HEAT_VALUE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.SEA_LANTERN) {
			ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.SEA_LANTERN),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.SEA_LANTERN_HEAT_VALUE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.REDSTONE_TORCH) {
			ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.REDSTONE_TORCH),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.REDSTONE_TORCH_HEAT_VALUE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.BEACON) {
			ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.BEACON),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.BEACON_HEAT_VALUE);
		}
	}
}