package net.thep2wking.exastris.modules.exastris;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CrookRecipesExAstris {
    public static void register() {
        ExNihiloRegistryManager.CROOK_REGISTRY.register(ModBlocks.infestedLeaves, 0,
                new ItemStack(Items.STRING, 1, 0), 1f, 1.25f);
    }
}
