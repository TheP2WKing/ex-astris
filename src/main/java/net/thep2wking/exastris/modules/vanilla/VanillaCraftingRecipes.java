package net.thep2wking.exastris.modules.vanilla;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisItems;

public class VanillaCraftingRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.HARD_STONE) {
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
		}

		if (ExAstrisConfig.MODULE_VANILLA.MOB_DOLLS.VILLAGER_DOLL) {
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "doll_villager"), null,
					new ItemStack(ExAstrisItems.DOLLS, 1, 0),
					"ABA", "CDC", "AEA", 'A', "gemEmerald", 'B', "ingotIron", 'C', "dustGlowstone", 'D',
					new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5), 'E',
					new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER), 1, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.MOB_DOLLS.EVOKER_DOLL) {
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "doll_evoker"), null,
					new ItemStack(ExAstrisItems.DOLLS, 1, 1),
					"ABA", "CDC", "AEA", 'A', "dyeGray", 'B', "gemEmerald", 'C', "dustGlowstone", 'D',
					new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5), 'E',
					new ItemStack(Item.getItemFromBlock(Blocks.SAPLING), 1, 5));
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.SEEDS_TO_SOIl) {
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
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.ICE_BLOCKS_FROM_ICE_SHARDS) {
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "ice_from_shard"), null,
					new ItemStack(Item.getItemFromBlock(Blocks.ICE), 1, 0),
					"AA", "AA", 'A', new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0));
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "packaed_ice_from_shard"), null,
					new ItemStack(Item.getItemFromBlock(Blocks.PACKED_ICE), 1, 0),
					" A ", "ABA", " A ", 'A', new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0), 'B', "sand");
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.NETHERRACK_PEBBLES_FROM_DIRT) {
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "netherrack_from_pebble"), null,
					new ItemStack(Blocks.NETHERRACK, 1, 0),
					"AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENDSTONE_PEBBLES_FROM_DIRT) {
			GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "end_stone_from_pebble"), null,
					new ItemStack(Blocks.END_STONE, 1, 0),
					"AA", "AA", 'A', new ItemStack(ExAstrisItems.PEBBLES, 1, 1));
		}
	}
}