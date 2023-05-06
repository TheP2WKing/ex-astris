package net.thep2wking.exastris.modules.exastris;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import net.minecraft.init.Blocks;

@SuppressWarnings("null")
public class HeatRecipesExAstris {
    public static void register() {
        ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.LIT_REDSTONE_LAMP), 2);
        ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.SEA_LANTERN), 1);
        ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.REDSTONE_TORCH), 1);
        ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.BEACON), 10);
    }
}