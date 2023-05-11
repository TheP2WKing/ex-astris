package net.thep2wking.exastris.modules.vanilla;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.config.ExAstrisConfig;

public class VanillaCrookRecipes {
    public static void register() {
        if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.FAKE_STRING_CROOK_RECIPE_IN_JEI) {
            ExNihiloRegistryManager.CROOK_REGISTRY.register(ModBlocks.infestedLeaves, 0,
                    new ItemStack(Items.STRING, 1, 0), 1f, 1.25f);
        }
    }
}