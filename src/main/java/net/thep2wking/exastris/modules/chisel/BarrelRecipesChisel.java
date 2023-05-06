package net.thep2wking.exastris.modules.chisel;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.config.ExAstrisConfig;
import team.chisel.common.init.ChiselBlocks;

@SuppressWarnings("null")
public class BarrelRecipesChisel {
	public static void register() {
		if (ExAstrisConfig.MODULE_CHISEL.BARREL_RECIPES.BASALT_FROM_LAVA) {
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(FluidRegistry.LAVA, "stone",
					new BlockInfo(ChiselBlocks.basalt2, 7));
		}
	}
}