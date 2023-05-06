package net.thep2wking.exastris.modules.exastris;

import exnihilocreatio.ModItems;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.init.ExAstrisItems;

public class HammerRecipesExAstris {
    public static void register() {
        ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.STONE, 0, new ItemStack(ModItems.pebbles, 1, 0),
                0, 1f, 1.1f);
        ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.STONE, 0, new ItemStack(ModItems.pebbles, 2, 0),
                0, 0.75f, 0.8f);
        ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.STONE, 0, new ItemStack(ModItems.pebbles, 1, 0),
                0, 0.5f, 0.6f);

        ExNihiloRegistryManager.HAMMER_REGISTRY.register("prismarine",
                new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 1, 1f, 1.1f);
        ExNihiloRegistryManager.HAMMER_REGISTRY.register("prismarine",
                new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 1, 0.5f, 0.3f);

        ExNihiloRegistryManager.HAMMER_REGISTRY.register("sandstone",
                new ItemStack(Item.getItemFromBlock(Blocks.SAND), 1, 0), 0, 1f, 1f);

        ExNihiloRegistryManager.HAMMER_REGISTRY.register("stoneBricks",
                new ItemStack(Item.getItemFromBlock(Blocks.STONEBRICK), 1, 2), 0, 1f, 1f);

                
        ExNihiloRegistryManager.HAMMER_REGISTRY.register("blockIce",
                new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0),
                0, 1f, 1.1f);
        ExNihiloRegistryManager.HAMMER_REGISTRY.register("blockIce",
                new ItemStack(ExAstrisItems.SHARD_ICE, 2, 0),
                0, 0.75f, 0.8f);
        ExNihiloRegistryManager.HAMMER_REGISTRY.register("blockIce",
                new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0),
                0, 0.50f, 0.6f);
    }
}
