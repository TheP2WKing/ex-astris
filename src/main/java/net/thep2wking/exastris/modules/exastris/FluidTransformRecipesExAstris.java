package net.thep2wking.exastris.modules.exastris;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import net.minecraft.init.Blocks;

@SuppressWarnings("null")
public class FluidTransformRecipesExAstris {
    public static void register() {
        final BlockInfo[] transformingBlocks = { new BlockInfo(Blocks.DIRT, 2) };
        final BlockInfo[] blocksToSpawn = { new BlockInfo(Blocks.RED_FLOWER, 0),
                new BlockInfo(Blocks.YELLOW_FLOWER, 0), new BlockInfo(Blocks.RED_FLOWER, 1),
                new BlockInfo(Blocks.RED_FLOWER, 2), new BlockInfo(Blocks.RED_FLOWER, 3),
                new BlockInfo(Blocks.RED_FLOWER, 4), new BlockInfo(Blocks.RED_FLOWER, 5),
                new BlockInfo(Blocks.RED_FLOWER, 6), new BlockInfo(Blocks.RED_FLOWER, 7),
                new BlockInfo(Blocks.RED_FLOWER, 8) };
        ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register("water", "peacewater", 12000,
                transformingBlocks, blocksToSpawn);

        final BlockInfo[] transformingBlocks2 = { new BlockInfo(Blocks.STONE, 0) };
        final BlockInfo[] blocksToSpawn2 = {};
        ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register("water", "frostwater", 12000,
                transformingBlocks2, blocksToSpawn2);
    }
}