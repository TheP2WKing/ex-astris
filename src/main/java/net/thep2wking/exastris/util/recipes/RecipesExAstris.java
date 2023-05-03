package net.thep2wking.exastris.util.recipes;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.ModFluids;
import exnihilocreatio.ModItems;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.items.ItemResource;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import exnihilocreatio.util.StackInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisFluids;
import net.thep2wking.exastris.init.ExAstrisItems;

@SuppressWarnings("all")
public class RecipesExAstris {
        public static void register() {
                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "hard_stone"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_HARD_STONE, 1, 0),
                                "ABA", "BAB", "ABA", 'A', "obsidian", 'B', "stone");
                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "double_hard_stone"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE, 1, 0),
                                "AAA", "AAA", "AAA", 'A', Item.getItemFromBlock(ExAstrisBlocks.BLOCK_HARD_STONE));
                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "triple_hard_stone"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE, 1, 0),
                                "AAA", "AAA", "AAA", 'A',
                                Item.getItemFromBlock(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE));
                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "quadruple_hard_stone"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE, 1, 0),
                                "AAA", "AAA", "AAA", 'A',
                                Item.getItemFromBlock(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE));
                GameRegistry.addShapelessRecipe(new ResourceLocation(ExAstris.MODID, "hard_stone_from_double"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_HARD_STONE, 9, 0),
                                Ingredient.fromItem(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE)));
                GameRegistry.addShapelessRecipe(new ResourceLocation(ExAstris.MODID, "double_hard_stone_from_triple"),
                                null,
                                new ItemStack(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE, 9, 0),
                                Ingredient.fromItem(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE)));
                GameRegistry.addShapelessRecipe(
                                new ResourceLocation(ExAstris.MODID, "triple_hard_stone_from_quadruple"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE, 9, 0),
                                Ingredient.fromItem(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE)));

                OreDictionary.registerOre("plankWoodOak", new ItemStack(Blocks.PLANKS, 1, 0));
                OreDictionary.registerOre("slabWoodOak", new ItemStack(Blocks.WOODEN_SLAB, 1, 0));

                OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Blocks.PLANKS, 1, 1));
                OreDictionary.registerOre("slabWoodSpruce", new ItemStack(Blocks.WOODEN_SLAB, 1, 1));

                OreDictionary.registerOre("plankWoodBirch", new ItemStack(Blocks.PLANKS, 1, 2));
                OreDictionary.registerOre("slabWoodBirch", new ItemStack(Blocks.WOODEN_SLAB, 1, 2));

                OreDictionary.registerOre("plankWoodJungle", new ItemStack(Blocks.PLANKS, 1, 3));
                OreDictionary.registerOre("slabWoodJungle", new ItemStack(Blocks.WOODEN_SLAB, 1, 3));

                OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Blocks.PLANKS, 1, 4));
                OreDictionary.registerOre("slabWoodAcacia", new ItemStack(Blocks.WOODEN_SLAB, 1, 4));

                OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Blocks.PLANKS, 1, 5));
                OreDictionary.registerOre("slabWoodDarkOak", new ItemStack(Blocks.WOODEN_SLAB, 1, 5));

                OreDictionary.registerOre("slabStone", new ItemStack(Blocks.STONE_SLAB, 1, 0));
                OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 0));
                OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 1));
                OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 3));
                OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 5));

                OreDictionary.registerOre("cobblestone", new ItemStack(Blocks.COBBLESTONE, 1, 0));
                OreDictionary.registerOre("slabCobblestone", new ItemStack(Blocks.STONE_SLAB, 1, 3));

                OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 0));
                OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 1));
                OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 2));
                OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 3));
                OreDictionary.registerOre("slabStoneBricks", new ItemStack(Blocks.STONE_SLAB, 1, 5));

                OreDictionary.registerOre("sandstone", new ItemStack(Blocks.SANDSTONE, 1, 0));
                OreDictionary.registerOre("sandstone", new ItemStack(Blocks.SANDSTONE, 1, 1));
                OreDictionary.registerOre("sandstone", new ItemStack(Blocks.SANDSTONE, 1, 2));
                OreDictionary.registerOre("slabSandstone", new ItemStack(Blocks.STONE_SLAB, 1, 1));

                OreDictionary.registerOre("sandstone", new ItemStack(Blocks.RED_SANDSTONE, 1, 0));
                OreDictionary.registerOre("sandstone", new ItemStack(Blocks.RED_SANDSTONE, 1, 1));
                OreDictionary.registerOre("sandstone", new ItemStack(Blocks.RED_SANDSTONE, 1, 2));
                OreDictionary.registerOre("slabSandstone", new ItemStack(Blocks.STONE_SLAB2, 1, 0));

                OreDictionary.registerOre("bricks", new ItemStack(Blocks.BRICK_BLOCK, 1, 0));
                OreDictionary.registerOre("slabBricks", new ItemStack(Blocks.STONE_SLAB, 1, 4));

                OreDictionary.registerOre("netherBrick", new ItemStack(Blocks.NETHER_BRICK, 1, 0));
                OreDictionary.registerOre("slabNetherBrick", new ItemStack(Blocks.STONE_SLAB, 1, 6));

                OreDictionary.registerOre("blockQuartz", new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0));
                OreDictionary.registerOre("blockQuartz", new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1));
                OreDictionary.registerOre("blockQuartz", new ItemStack(Blocks.QUARTZ_BLOCK, 1, 2));
                OreDictionary.registerOre("slabQuartz", new ItemStack(Blocks.STONE_SLAB, 1, 7));

                OreDictionary.registerOre("blockPurpur", new ItemStack(Blocks.PURPUR_BLOCK, 1, 0));
                OreDictionary.registerOre("blockPurpur", new ItemStack(Blocks.PURPUR_PILLAR, 1, 0));
                OreDictionary.registerOre("slabPurpur", new ItemStack(Blocks.PURPUR_SLAB, 1, 0));

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "oak_wood_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 0),
                                "A A", "A A", "ABA", 'A', "plankWoodOak", 'B', "slabWoodOak");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "spruce_wood_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 1),
                                "A A", "A A", "ABA", 'A', "plankWoodSpruce", 'B', "slabWoodSpruce");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "birch_wood_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 2),
                                "A A", "A A", "ABA", 'A', "plankWoodBirch", 'B', "slabWoodBirch");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "jungle_wood_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 3),
                                "A A", "A A", "ABA", 'A', "plankWoodJungle", 'B', "slabWoodJungle");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "acacia_wood_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 4),
                                "A A", "A A", "ABA", 'A', "plankWoodAcacia", 'B', "slabWoodAcacia");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "dark_oak_wood_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, 5),
                                "A A", "A A", "ABA", 'A', "plankWoodDarkOak", 'B', "slabWoodDarkOak");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "stone_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 0),
                                "A A", "A A", "ABA", 'A', "stone", 'B', "slabStone");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "cobblestone_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 1),
                                "A A", "A A", "ABA", 'A', "cobblestone", 'B', "slabCobblestone");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "stone_bricks_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 2),
                                "A A", "A A", "ABA", 'A', "stoneBricks", 'B', "slabStoneBricks");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "sandstone_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 3),
                                "A A", "A A", "ABA", 'A', "sandstone", 'B', "slabSandstone");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "bricks_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 4),
                                "A A", "A A", "ABA", 'A', "bricks", 'B', "slabBricks");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "nether_brick_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 5),
                                "A A", "A A", "ABA", 'A', "netherBrick", 'B', "slabNetherBrick");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "quartz_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 6),
                                "A A", "A A", "ABA", 'A', "blockQuartz", 'B', "slabQuartz");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "purpur_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 7),
                                "A A", "A A", "ABA", 'A', "blockPurpur", 'B', "slabPurpur");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "iron_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T2, 1, 0),
                                "A A", "A A", "ABA", 'A', "ingotIron", 'B', "nuggetIron");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "gold_barrel"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T2, 1, 1),
                                "A A", "A A", "ABA", 'A', "ingotGold", 'B', "nuggetGold");

                GameRegistry.addSmelting(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 1),
                                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 0), 0.1f);

                GameRegistry.addShapedRecipe(new ResourceLocation("exnihilocreatio:block_barrel0"),
                                new ResourceLocation("removed"), new ItemStack(Item.getByNameOrId("null")),
                                new Object[] { "A", 'A', "null" });

                GameRegistry.addShapedRecipe(new ResourceLocation("exnihilocreatio:block_barrel1"),
                                new ResourceLocation("removed"), new ItemStack(Item.getByNameOrId("null")),
                                new Object[] { "A", 'A', "null" });

                ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.LIT_REDSTONE_LAMP), 2);
                ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.SEA_LANTERN), 1);
                ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.REDSTONE_TORCH), 1);
                ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Blocks.BEACON), 10);

                for (ItemStack inputOre : OreDictionary.getOres("treeSapling")) {
                        GameRegistry.addSmelting(inputOre, new ItemStack(Item.getItemFromBlock(Blocks.DEADBUSH), 1, 0),
                                        0.1f);
                }
                for (ItemStack inputOre : OreDictionary.getOres("flower")) {
                        GameRegistry.addSmelting(inputOre, new ItemStack(Item.getItemFromBlock(Blocks.DEADBUSH), 1, 0),
                                        0.1f);
                }

                OreDictionary.registerOre("listAllseed", new ItemStack(Items.WHEAT_SEEDS, 1, 0));
                OreDictionary.registerOre("listAllseed", new ItemStack(Items.PUMPKIN_SEEDS, 1, 0));
                OreDictionary.registerOre("listAllseed", new ItemStack(Items.MELON_SEEDS, 1, 0));
                OreDictionary.registerOre("listAllseed", new ItemStack(Items.BEETROOT_SEEDS, 1, 0));

                OreDictionary.registerOre("listAllseed", new ItemStack(ExAstrisItems.SEEDS_FERN, 1, 0));

                ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
                                new ItemInfo(ExAstrisItems.SEEDS_FERN, 0), 0.05f, BlockSieve.MeshType.STRING.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(
                                new ItemInfo(Item.getItemFromBlock(ModBlocks.infestedLeaves), 0),
                                new ItemInfo(Items.STRING, 0), 1f, BlockSieve.MeshType.STRING.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register(
                                new ItemInfo(Item.getItemFromBlock(ModBlocks.infestedLeaves), 0),
                                new ItemInfo(Items.STRING, 0), 0.75f, BlockSieve.MeshType.STRING.getID());

                ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.STONE, 0, new ItemStack(ModItems.pebbles, 1, 0),
                                0, 1f, 1.1f);
                ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.STONE, 0, new ItemStack(ModItems.pebbles, 2, 0),
                                0, 0.75f, 0.8f);
                ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.STONE, 0, new ItemStack(ModItems.pebbles, 1, 0),
                                0, 0.5f, 0.6f);

                ExNihiloRegistryManager.CROOK_REGISTRY.register(ModBlocks.infestedLeaves, 0,
                                new ItemStack(Items.STRING, 1, 0), 1f, 1.25f);

                ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
                                new ItemInfo(Items.DYE, 15), 0.03f, BlockSieve.MeshType.FLINT.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
                                new ItemInfo(Items.GUNPOWDER, 0), 0.14f, BlockSieve.MeshType.FLINT.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
                                new ItemInfo(Items.GLOWSTONE_DUST, 0), 0.125f, BlockSieve.MeshType.DIAMOND.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
                                new ItemInfo(Items.BLAZE_POWDER, 0), 0.1f, BlockSieve.MeshType.DIAMOND.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register("sand",
                                new ItemInfo(Items.PRISMARINE_CRYSTALS, 0), 0.02f, BlockSieve.MeshType.DIAMOND.getID());

                OreDictionary.registerOre("prismarine", new ItemStack(Blocks.PRISMARINE, 1, 0));
                OreDictionary.registerOre("prismarine", new ItemStack(Blocks.PRISMARINE, 1, 1));
                OreDictionary.registerOre("prismarine", new ItemStack(Blocks.PRISMARINE, 1, 2));

                ExNihiloRegistryManager.HAMMER_REGISTRY.register("prismarine",
                                new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 1, 1f, 1.1f);
                ExNihiloRegistryManager.HAMMER_REGISTRY.register("prismarine",
                                new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 1, 0.5f, 0.3f);

                ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
                                new ItemInfo(Items.FLINT, 0), 0.5f, BlockSieve.MeshType.IRON.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
                                new ItemInfo(Items.COAL, 0), 0.25f, BlockSieve.MeshType.IRON.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
                                new ItemInfo(Items.DYE, 4), 0.1f, BlockSieve.MeshType.IRON.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
                                new ItemInfo(Items.FLINT, 0), 0.75f, BlockSieve.MeshType.DIAMOND.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
                                new ItemInfo(Items.COAL, 0), 0.5f, BlockSieve.MeshType.DIAMOND.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
                                new ItemInfo(Items.DYE, 4), 0.2f, BlockSieve.MeshType.DIAMOND.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(
                                new ItemInfo(Item.getItemFromBlock(ModBlocks.endstoneCrushed), 0),
                                new ItemInfo(Items.ENDER_PEARL, 0), 0.04f, BlockSieve.MeshType.DIAMOND.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register(
                                new ItemInfo(Item.getItemFromBlock(ModBlocks.endstoneCrushed), 0),
                                new ItemInfo(Items.CHORUS_FRUIT, 0), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register(
                                new ItemInfo(Item.getItemFromBlock(ModBlocks.endstoneCrushed), 0),
                                new ItemInfo(ExAstrisItems.SEEDS_CHORUS, 0), 0.01f,
                                BlockSieve.MeshType.DIAMOND.getID());

                OreDictionary.registerOre("listAllseed", new ItemStack(ExAstrisItems.SEEDS_CHORUS, 1, 0));

                ExNihiloRegistryManager.HAMMER_REGISTRY.register("sandstone",
                                new ItemStack(Item.getItemFromBlock(Blocks.SAND), 1, 0), 0, 1f, 1f);

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "doll_villager"), null,
                                new ItemStack(ExAstrisItems.DOLLS, 1, 0),
                                "ABA", "CDC", "AEA", 'A', "gemEmerald", 'B', "ingotIron", 'C', "dustGlowstone", 'D',
                                new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5), 'E',
                                new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 0));

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "doll_evoker"), null,
                                new ItemStack(ExAstrisItems.DOLLS, 1, 1),
                                "ABA", "CDC", "AEA", 'A', "dyeGray", 'B', "gemEmerald", 'C', "dustGlowstone", 'D',
                                new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5), 'E',
                                new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 5));

                OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 0));
                OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 1));
                OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 2));
                OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 3));

                final BlockInfo[] transformingBlocks = { new BlockInfo(Blocks.DIRT, 2) };
                final BlockInfo[] blocksToSpawn = { new BlockInfo(Blocks.RED_FLOWER, 0),
                                new BlockInfo(Blocks.YELLOW_FLOWER, 0), new BlockInfo(Blocks.RED_FLOWER, 1),
                                new BlockInfo(Blocks.RED_FLOWER, 2), new BlockInfo(Blocks.RED_FLOWER, 3),
                                new BlockInfo(Blocks.RED_FLOWER, 4), new BlockInfo(Blocks.RED_FLOWER, 5),
                                new BlockInfo(Blocks.RED_FLOWER, 6), new BlockInfo(Blocks.RED_FLOWER, 7),
                                new BlockInfo(Blocks.RED_FLOWER, 8) };

                ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register("water", "peacewater", 12000,
                                transformingBlocks, blocksToSpawn);

                ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
                                new ItemInfo(ExAstrisItems.SEEDS_PODZOL, 0), 0.05f, BlockSieve.MeshType.STRING.getID());

                OreDictionary.registerOre("listAllseed", new ItemStack(ExAstrisItems.SEEDS_PODZOL, 1, 0));

                OreDictionary.registerOre("dirt", new ItemStack(Item.getItemFromBlock(Blocks.DIRT), 1, 1));

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "grass_block_with_seeds"), null,
                                new ItemStack(Blocks.GRASS, 1, 0),
                                "A", "B", 'A', new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 4),
                                'B', "dirt");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "mycelium_block_with_seeds"), null,
                                new ItemStack(Blocks.MYCELIUM, 1, 0),
                                "A", "B", 'A', new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 3),
                                'B', "dirt");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "podzol_block_with_seeds"), null,
                                new ItemStack(Blocks.DIRT, 1, 2),
                                "A", "B", 'A', new ItemStack(ExAstrisItems.SEEDS_PODZOL, 1, 0), 'B', "dirt");

                ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("blockSlime", ExAstrisFluids.SLIME, 500);
                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ExAstrisFluids.SLIME,
                                "blockWool", new BlockInfo(Blocks.SPONGE, 0));

                GameRegistry.addShapedRecipe(new ResourceLocation("exnihilocreatio:end_cake"),
                                new ResourceLocation("removed"), new ItemStack(Item.getByNameOrId("null")),
                                "A", 'A', "null");

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "end_cake"), null,
                                new ItemStack(ExAstrisBlocks.BLOCK_END_CAKE, 1, 0),
                                "AAA", "BCB", "AAA", 'A', new ItemStack(Items.ENDER_EYE, 1, 0), 'B',
                                new ItemStack(Items.END_CRYSTAL, 1, 0), 'C', new ItemStack(Items.CAKE, 1, 0));

                ExNihiloRegistryManager.HAMMER_REGISTRY.register("stoneBricks",
                                new ItemStack(Item.getItemFromBlock(Blocks.STONEBRICK), 1, 2), 0, 1f, 1f);

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "ice_from_shard"), null,
                                new ItemStack(Item.getItemFromBlock(Blocks.ICE), 1, 0),
                                "AA", "AA", 'A', new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0));

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "packaed_ice_from_shard"), null,
                                new ItemStack(Item.getItemFromBlock(Blocks.PACKED_ICE), 1, 0),
                                " A ", "ABA", " A ", 'A', new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0), 'B', "sand");

                OreDictionary.registerOre("blockIce", new ItemStack(Item.getItemFromBlock(Blocks.ICE), 1, 0));
                OreDictionary.registerOre("blockIce", new ItemStack(Item.getItemFromBlock(Blocks.PACKED_ICE), 1, 0));

                ExNihiloRegistryManager.HAMMER_REGISTRY.register("blockIce",
                                new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0),
                                0, 1f, 1.1f);
                ExNihiloRegistryManager.HAMMER_REGISTRY.register("blockIce",
                                new ItemStack(ExAstrisItems.SHARD_ICE, 2, 0),
                                0, 0.75f, 0.8f);
                ExNihiloRegistryManager.HAMMER_REGISTRY.register("blockIce",
                                new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0),
                                0, 0.50f, 0.6f);

                ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("blockIce", FluidRegistry.WATER, 1000);
                ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register(
                                new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_HARD_STONE)),
                                FluidRegistry.LAVA, 4000);
                ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register("stoneBricks", FluidRegistry.LAVA, 250);

                ExNihiloRegistryManager.FLUID_ITEM_FLUID_REGISTRY.register("water",
                                new ItemInfo(Items.MUSHROOM_STEW, 0), "witchwater");
                ExNihiloRegistryManager.FLUID_ITEM_FLUID_REGISTRY.register("water", new ItemInfo(Items.RABBIT_STEW, 0),
                                "witchwater");

                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
                                new ItemInfo(Item.getItemFromBlock(Blocks.SAPLING), 0),
                                new ItemInfo(Item.getItemFromBlock(Blocks.SAPLING), 5));

                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
                                new ItemInfo(Item.getItemFromBlock(Blocks.TALLGRASS), 1),
                                new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 2));

                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
                                new ItemInfo(Item.getItemFromBlock(Blocks.TALLGRASS), 2),
                                new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 3));

                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
                                new ItemInfo(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), 0),
                                new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 0));

                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
                                new ItemInfo(Item.getItemFromBlock(Blocks.RED_FLOWER), 2),
                                new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1));

                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
                                new ItemInfo(Item.getItemFromBlock(Blocks.RED_FLOWER), 0),
                                new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 4));

                ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
                                new ItemInfo(Item.getItemFromBlock(Blocks.RED_FLOWER), 3),
                                new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 5));

                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "netherrack_from_pebble"), null,
                                new ItemStack(Blocks.NETHERRACK, 1, 0),
                                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 0));
                GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "end_stone_from_pebble"), null,
                                new ItemStack(Blocks.END_STONE, 1, 0),
                                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 1));

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.netherrackCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.75f, BlockSieve.MeshType.STRING.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.netherrackCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.5f, BlockSieve.MeshType.STRING.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.netherrackCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.75f, BlockSieve.MeshType.FLINT.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.netherrackCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.5f, BlockSieve.MeshType.IRON.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.netherrackCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.25f, BlockSieve.MeshType.DIAMOND.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.endstoneCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.75f, BlockSieve.MeshType.STRING.getID());
                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.endstoneCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.5f, BlockSieve.MeshType.STRING.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.endstoneCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.75f, BlockSieve.MeshType.FLINT.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.endstoneCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.5f, BlockSieve.MeshType.IRON.getID());

                ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(ModBlocks.endstoneCrushed)),
                                new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.25f, BlockSieve.MeshType.DIAMOND.getID());
        }
}