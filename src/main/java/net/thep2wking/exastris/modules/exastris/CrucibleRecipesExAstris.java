package net.thep2wking.exastris.modules.exastris;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisFluids;

public class CrucibleRecipesExAstris {
    public static void register() {
        ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("blockSlime", ExAstrisFluids.SLIME, 500);
        ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("blockIce", FluidRegistry.WATER, 1000);
        ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register(
                new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_HARD_STONE)),
                FluidRegistry.LAVA, 4000);
        ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("stoneBricks", FluidRegistry.LAVA, 250);
    }
}