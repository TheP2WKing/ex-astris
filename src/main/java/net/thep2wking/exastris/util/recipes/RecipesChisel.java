package net.thep2wking.exastris.util.recipes;

import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisItems;
import team.chisel.api.carving.CarvingUtils;
import team.chisel.common.init.ChiselBlocks;

@SuppressWarnings("null")
public class RecipesChisel {
    public static void register() {
        if (ExAstrisConfig.MODULES.CHISEL.MARBLE_PEBBLE_SIEVING) {
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_MARBLE, 0), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_MARBLE, 0), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_MARBLE, 0), 0.04f, BlockSieve.MeshType.DIAMOND.getID());
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_MARBLE, 0), 0.16f, BlockSieve.MeshType.DIAMOND.getID());
        }

        if (ExAstrisConfig.MODULES.CHISEL.LIMESTONE_PEBBLE_SIEVING) {
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_LIMESTONE, 0), 0.01f, BlockSieve.MeshType.DIAMOND.getID());
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_LIMESTONE, 0), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_LIMESTONE, 0), 0.04f, BlockSieve.MeshType.DIAMOND.getID());
            ExNihiloRegistryManager.SIEVE_REGISTRY.register("stone",
                    new ItemInfo(ExAstrisItems.PEBBLE_LIMESTONE, 0), 0.16f, BlockSieve.MeshType.DIAMOND.getID());
        }

        if (ExAstrisConfig.MODULES.CHISEL.BASALT_FLUID_ITEM_TRANSFORM) {
            ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(FluidRegistry.LAVA,
                    "stone", new BlockInfo(ChiselBlocks.basalt2, 7));
        }

        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "marble_block_from_pebble"), null,
                new ItemStack(ChiselBlocks.marble2, 1, 7),
                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLE_MARBLE, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "limestone_block_from_pebble"), null,
                new ItemStack(ChiselBlocks.limestone2, 1, 7),
                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLE_LIMESTONE, 1, 0));

        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 0));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 1));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 2));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 3));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 4));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 5));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 6));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 7));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 8));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 9));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 10));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 11));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 12));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 13));
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Item.getByNameOrId("chisel:planks-oak"), 1, 14));

        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 0));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 1));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 2));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 3));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 4));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 5));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 6));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 7));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 8));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 9));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 10));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 11));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 12));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 13));
        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Item.getByNameOrId("chisel:planks-spruce"), 1, 14));

        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 0));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 1));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 2));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 3));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 4));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 5));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 6));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 7));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 8));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 9));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 10));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 11));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 12));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 13));
        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Item.getByNameOrId("chisel:planks-birch"), 1, 14));

        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 0));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 1));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 2));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 3));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 4));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 5));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 6));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 7));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 8));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 9));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 10));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 11));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 12));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 13));
        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Item.getByNameOrId("chisel:planks-jungle"), 1, 14));

        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 0));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 1));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 2));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 3));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 4));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 5));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 6));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 7));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 8));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 9));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 10));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 11));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 12));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 13));
        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Item.getByNameOrId("chisel:planks-acacia"), 1, 14));

        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 0));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 1));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 2));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 3));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 4));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 5));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 6));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 7));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 8));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 9));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 10));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 11));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 12));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 13));
        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Item.getByNameOrId("chisel:planks-dark-oak"), 1, 14));

        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 0));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 1));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 2));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 3));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 4));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 5));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 6));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 7));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 8));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 9));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 10));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 11));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 12));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 13));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 14));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks"), 1, 15));

        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 0));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 1));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 2));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 3));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 4));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 5));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 6));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 7));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 8));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks1"), 1, 9));

        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks2"), 1, 0));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks2"), 1, 1));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks2"), 1, 2));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks2"), 1, 3));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks2"), 1, 4));
        OreDictionary.registerOre("bricks", new ItemStack(Item.getByNameOrId("chisel:bricks2"), 1, 5));

        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 0));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 1));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 2));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 3));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 4));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 5));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 6));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 7));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 8));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 9));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 10));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 11));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 12));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 13));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 14));
        OreDictionary.registerOre("netherBrick", new ItemStack(Item.getByNameOrId("chisel:netherbrick"), 1, 15));

        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 0));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 1));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 2));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 3));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 4));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 5));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 6));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 7));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 8));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 9));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 10));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 11));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 12));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 13));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 14));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur"), 1, 15));

        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 0));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 1));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 2));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 3));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 4));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 5));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 6));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 7));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 8));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur1"), 1, 9));

        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur2"), 1, 0));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur2"), 1, 1));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur2"), 1, 2));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur2"), 1, 3));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Item.getByNameOrId("chisel:purpur2"), 1, 4));

        CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel", CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 0), 0));
        CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel", CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 1), 1));
        CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel", CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 2), 2));
        CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel", CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 3), 3));
        CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel", CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 4), 4));
        CarvingUtils.getChiselRegistry().addVariation(ExAstris.PREFIX + "barrel", CarvingUtils.variationFor(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 5), 5));
    }
}
