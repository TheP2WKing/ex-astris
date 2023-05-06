package net.thep2wking.exastris.modules.exastris;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisItems;

public class CraftingRecipesExAstris {
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

        GameRegistry.addShapedRecipe(new ResourceLocation("exnihilocreatio:block_barrel0"),
                new ResourceLocation("removed"), new ItemStack(Item.getByNameOrId("null")),
                new Object[] { "A", 'A', "null" });
        GameRegistry.addShapedRecipe(new ResourceLocation("exnihilocreatio:block_barrel1"),
                new ResourceLocation("removed"), new ItemStack(Item.getByNameOrId("null")),
                new Object[] { "A", 'A', "null" });

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

        GameRegistry.addShapedRecipe(new ResourceLocation("exnihilocreatio:end_cake"),
                new ResourceLocation("removed"), new ItemStack(Item.getByNameOrId("null")),
                "A", 'A', "null");
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "end_cake"), null,
                new ItemStack(ExAstrisBlocks.BLOCK_END_CAKE, 1, 0),
                "AAA", "BCB", "AAA", 'A', new ItemStack(Items.ENDER_EYE, 1, 0), 'B',
                new ItemStack(Items.END_CRYSTAL, 1, 0), 'C', new ItemStack(Items.CAKE, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "ice_from_shard"), null,
                new ItemStack(Item.getItemFromBlock(Blocks.ICE), 1, 0),
                "AA", "AA", 'A', new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0));
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "packaed_ice_from_shard"), null,
                new ItemStack(Item.getItemFromBlock(Blocks.PACKED_ICE), 1, 0),
                " A ", "ABA", " A ", 'A', new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0), 'B', "sand");

        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "netherrack_from_pebble"), null,
                new ItemStack(Blocks.NETHERRACK, 1, 0),
                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "end_stone_from_pebble"), null,
                new ItemStack(Blocks.END_STONE, 1, 0),
                "AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 1));

        GameRegistry.addShapedRecipe(new ResourceLocation("exnihilocreatio:sieve"),
                new ResourceLocation("removed"), new ItemStack(Item.getByNameOrId("null")),
                new Object[] { "A", 'A', "null" });
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "oak_wood_sieve"), null,
                new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 0),
                "A A", "ABA", "C C", 'A', "plankWoodOak", 'B', "slabWoodOak", 'C', "stickWood");
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "spruce_wood_sieve"), null,
                new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 1),
                "A A", "ABA", "C C", 'A', "plankWoodSpruce", 'B', "slabWoodSpruce", 'C', "stickWood");
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "birch_wood_sieve"), null,
                new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 2),
                "A A", "ABA", "C C", 'A', "plankWoodBirch", 'B', "slabWoodBirch", 'C', "stickWood");
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "jungle_wood_sieve"), null,
                new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 3),
                "A A", "ABA", "C C", 'A', "plankWoodJungle", 'B', "slabWoodJungle", 'C', "stickWood");
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "acacia_wood_sieve"), null,
                new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 4),
                "A A", "ABA", "C C", 'A', "plankWoodAcacia", 'B', "slabWoodAcacia", 'C', "stickWood");
        GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "dark_oak_wood_sieve"), null,
                new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, 5),
                "A A", "ABA", "C C", 'A', "plankWoodDarkOak", 'B', "slabWoodDarkOak", 'C', "stickWood");
    }
}