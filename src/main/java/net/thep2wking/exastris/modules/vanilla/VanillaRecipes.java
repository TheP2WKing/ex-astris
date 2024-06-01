package net.thep2wking.exastris.modules.vanilla;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.ModFluids;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.api.recipe.ExAstrisApiHelper;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisFluids;
import net.thep2wking.exastris.init.ExAstrisItems;

public class VanillaRecipes {
	public static void registerCraftingRecipes() {
		ExAstrisApiHelper.addSmeltingRecipe(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 1),
				new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 0), 0.1f);

		ExAstrisApiHelper.addSieveBarrelAndCrucibleCraftingRecipe("oak", 0, "plankWoodOak", "slabWoodOak",
				"logWoodOak");
		ExAstrisApiHelper.addSieveBarrelAndCrucibleCraftingRecipe("spruce", 1, "plankWoodSpruce", "slabWoodSpruce",
				"logWoodSpruce");
		ExAstrisApiHelper.addSieveBarrelAndCrucibleCraftingRecipe("birch", 2, "plankWoodBirch", "slabWoodBirch",
				"logWoodBirch");
		ExAstrisApiHelper.addSieveBarrelAndCrucibleCraftingRecipe("jungle", 3, "plankWoodJungle", "slabWoodJungle",
				"logWoodJungle");
		ExAstrisApiHelper.addSieveBarrelAndCrucibleCraftingRecipe("acacia", 4, "plankWoodAcacia", "slabWoodAcacia",
				"logWoodAcacia");
		ExAstrisApiHelper.addSieveBarrelAndCrucibleCraftingRecipe("dark_oak", 5, "plankWoodDarkOak", "slabWoodDarkOak",
				"logWoodDarkOak");

		ExAstrisApiHelper.addStoneBarrelCraftingRecipe("stone", 0, "stone", "slabStone");
		ExAstrisApiHelper.addStoneBarrelCraftingRecipe("cobblestone", 1, "cobblestone", "slabCobblestone");

		ExAstrisApiHelper.addMetalBarrelCraftingRecipe("iron", 0, "ingotIron", "nuggetIron");
		ExAstrisApiHelper.addMetalBarrelCraftingRecipe("gold", 1, "ingotGold", "nuggetGold");

		ExAstrisApiHelper.removeRecipe("exnihilocreatio:block_barrel0");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:block_barrel1");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:sieve");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:crucible_wood");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:end_cake");

		ExAstrisApiHelper.removeRecipe("exnihilocreatio:stick_stone");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:gear_stone");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:whaterwheel");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:axle_stone");
		ExAstrisApiHelper.removeRecipe("exnihilocreatio:auto_sifter");

		ExAstrisApiHelper.addShapedRecipe("end_cake", new ItemStack(ExAstrisBlocks.BLOCK_END_CAKE, 1, 0), "AAA", "BCB",
				"AAA", 'A', new ItemStack(Items.ENDER_EYE, 1, 0), 'B', new ItemStack(Items.END_CRYSTAL, 1, 0), 'C',
				new ItemStack(Items.CAKE, 1, 0));

		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.HARD_STONE) {
			ExAstrisApiHelper.addShapedRecipe("hard_stone", new ItemStack(ExAstrisBlocks.BLOCK_HARD_STONE, 1, 0), "ABA",
					"BAB", "ABA", 'A', "obsidian", 'B', "stone");
			ExAstrisApiHelper.add9xCompressRecipe("double_hard_stone",
					new ItemStack(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE, 1, 0),
					new ItemStack(ExAstrisBlocks.BLOCK_HARD_STONE, 1, 0));
			ExAstrisApiHelper.add9xCompressRecipe("triple_hard_stone",
					new ItemStack(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE, 1, 0),
					new ItemStack(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE, 1, 0));
			ExAstrisApiHelper.add9xCompressRecipe("quadruple_hard_stone",
					new ItemStack(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE, 1, 0),
					new ItemStack(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE, 1, 0));
			ExAstrisApiHelper.add9xUncompressRecipe("hard_stone_from_double", ExAstrisBlocks.BLOCK_HARD_STONE, 0,
					new ItemStack(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE, 1, 0));
			ExAstrisApiHelper.add9xUncompressRecipe("double_hard_stone_from_triple",
					ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE, 0,
					new ItemStack(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE, 1, 0));
			ExAstrisApiHelper.add9xUncompressRecipe("triple_hard_stone_from_quadruple",
					ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE, 0,
					new ItemStack(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE, 1, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.MOB_DOLLS.VILLAGER_DOLL) {
			ExAstrisApiHelper.addShapedRecipe("doll_villager", new ItemStack(ExAstrisItems.DOLLS, 1, 0),
					"ABA", "CDC", "AEA", 'A', "gemEmerald", 'B', "ingotIron", 'C', "dustGlowstone", 'D',
					new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5), 'E',
					new ItemStack(Blocks.RED_FLOWER, 1, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.MOB_DOLLS.EVOKER_DOLL) {
			ExAstrisApiHelper.addShapedRecipe("doll_evoker", new ItemStack(ExAstrisItems.DOLLS, 1, 1),
					"ABA", "CDC", "AEA", 'A', "dyeGray", 'B', "gemEmerald", 'C', "dustGlowstone", 'D',
					new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5), 'E',
					new ItemStack(Blocks.SAPLING, 1, 5));
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.SEEDS_TO_SOIl) {
			ExAstrisApiHelper.addShapedRecipe("grass_block_with_seeds", new ItemStack(Blocks.GRASS, 1, 0),
					"A", "B", 'A', new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 4), 'B',
					"dirt");
			ExAstrisApiHelper.addShapedRecipe("mycelium_block_with_seeds", new ItemStack(Blocks.MYCELIUM, 1, 0),
					"A", "B", 'A', new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 3), 'B',
					"dirt");
			ExAstrisApiHelper.addShapedRecipe("podzol_block_with_seeds", new ItemStack(Blocks.DIRT, 1, 2),
					"A", "B", 'A', new ItemStack(ExAstrisItems.SEEDS_PODZOL, 1, 0), 'B', "dirt");
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.ICE_BLOCKS_FROM_ICE_SHARDS) {
			ExAstrisApiHelper.add4xCompressRecipe("ice_from_shard", new ItemStack(Blocks.ICE, 1, 0),
					new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0));
			ExAstrisApiHelper.addShapedRecipe("packaed_ice_from_shard",
					new ItemStack(Item.getItemFromBlock(Blocks.PACKED_ICE), 1, 0), " A ", "ABA", " A ", 'A',
					new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0), 'B', "sand");
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.NETHERRACK_PEBBLES_FROM_DIRT) {
			ExAstrisApiHelper.addPebbleToBlockRecipe("netherrack", 0, new ItemStack(Blocks.NETHERRACK, 1, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENDSTONE_PEBBLES_FROM_DIRT) {
			ExAstrisApiHelper.addPebbleToBlockRecipe("endstone", 1, new ItemStack(Blocks.END_STONE, 1, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.DEAD_BUSH_FROM_SMELTING) {
			ExAstrisApiHelper.addOreDictSmeltingRecipe(new ItemStack(Blocks.DEADBUSH, 1, 0), "treeSapling", 0.1f);
			ExAstrisApiHelper.addOreDictSmeltingRecipe(new ItemStack(Blocks.DEADBUSH, 1, 0), "flower", 0.1f);
		}
	}

	public static void registerBarrelRecipes() {
		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.SPONGE_FROM_SLIME) {
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.SPONGE, 0), "blockWool", ExAstrisFluids.SLIME);
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.WITCHWATER_FROM_STEWS) {
			ExAstrisApiHelper.addFluidItemFluidRecipe("witchwater", new ItemInfo(Items.MUSHROOM_STEW, 0), "water");
			ExAstrisApiHelper.addFluidItemFluidRecipe("witchwater", new ItemInfo(Items.RABBIT_STEW, 0), "water");
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.DARK_OAK_SAPLING_FROM_OAK_SAPLING) {
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.SAPLING, 5), new ItemInfo(Blocks.SAPLING, 0),
					ModFluids.fluidWitchwater);
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.TALL_GRASS_AND_FLOWERS_FROM_WITCHWATER) {
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.DOUBLE_PLANT, 2),
					new ItemInfo(Blocks.TALLGRASS, 1), ModFluids.fluidWitchwater);
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.DOUBLE_PLANT, 3),
					new ItemInfo(Blocks.TALLGRASS, 2), ModFluids.fluidWitchwater);
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.DOUBLE_PLANT, 0),
					new ItemInfo(Blocks.YELLOW_FLOWER, 0), ModFluids.fluidWitchwater);
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.DOUBLE_PLANT, 1),
					new ItemInfo(Blocks.RED_FLOWER, 2), ModFluids.fluidWitchwater);
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.DOUBLE_PLANT, 4),
					new ItemInfo(Blocks.RED_FLOWER, 0), ModFluids.fluidWitchwater);
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(Blocks.DOUBLE_PLANT, 5),
					new ItemInfo(Blocks.RED_FLOWER, 3), ModFluids.fluidWitchwater);
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.FROSTY_DIRT_FROM_FROSTWATER) {
			ExAstrisApiHelper.addFluidItemItemRecipe(new ItemInfo(ExAstrisBlocks.BLOCK_FROSTY_DIRT, 0), "dirt",
					ExAstrisFluids.FROSTWATER);
		}

		if (ExAstrisConfig.MODULE_VANILLA.FLUID_TRANSFORM_RECIPES.FROSTWATER_FROM_WATER) {
			ExAstrisApiHelper.addFluidTransformRecipe("frostwater", "water", new BlockInfo(Blocks.STONE, 0),
					ExAstrisConfig.MODULE_VANILLA.FLUID_TRANSFORM_RECIPES.FROSTWATER_TRANSFORM_TIME);
		}

		if (ExAstrisConfig.MODULE_VANILLA.FLUID_TRANSFORM_RECIPES.PEACEWATER_FROM_WATER) {
			final BlockInfo[] blocksToSpawnPeacewaterFlowersEnabled = { new BlockInfo(Blocks.RED_FLOWER, 0),
					new BlockInfo(Blocks.YELLOW_FLOWER, 0), new BlockInfo(Blocks.RED_FLOWER, 1),
					new BlockInfo(Blocks.RED_FLOWER, 2), new BlockInfo(Blocks.RED_FLOWER, 3),
					new BlockInfo(Blocks.RED_FLOWER, 4), new BlockInfo(Blocks.RED_FLOWER, 5),
					new BlockInfo(Blocks.RED_FLOWER, 6), new BlockInfo(Blocks.RED_FLOWER, 7),
					new BlockInfo(Blocks.RED_FLOWER, 8) };
			final BlockInfo[] blocksToSpawnFrostwaterFlowersDisabled = {};

			if (ExAstrisConfig.MODULE_VANILLA.FLUID_TRANSFORM_RECIPES.PEACEWATER_SPAWNS_FLOWERS) {
				ExAstrisApiHelper.addFluidTransformRecipe("peacewater", "water", new BlockInfo(Blocks.DIRT, 2),
						ExAstrisConfig.MODULE_VANILLA.FLUID_TRANSFORM_RECIPES.PEACEWATER_TRANSFORM_TIME,
						blocksToSpawnPeacewaterFlowersEnabled);
			} else {
				ExAstrisApiHelper.addFluidTransformRecipe("peacewater", "water", new BlockInfo(Blocks.DIRT, 2),
						ExAstrisConfig.MODULE_VANILLA.FLUID_TRANSFORM_RECIPES.PEACEWATER_TRANSFORM_TIME,
						blocksToSpawnFrostwaterFlowersDisabled);
			}
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.CHORUS_FRUIT_COMPOSTING) {
			ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(Items.CHORUS_FRUIT, 0),
					0.125f, "963e7d");
		}
		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.COCOA_BEANS_COMPOSTING) {
			ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(Items.DYE, 3),
					0.1f, "523a2c");
		}
		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.DEAD_BUSH_COMPOSTING) {
			ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(Blocks.DEADBUSH, 0),
					0.05f, "523a2c");
		}
		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.FERN_COMPOSTING) {
			ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(Blocks.TALLGRASS, 2),
					0.08f, "23630e");
		}
		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.HAY_BALES_COMPOSTING) {
			ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(Blocks.HAY_BLOCK, 0),
					1f, "e3e162");
		}
		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.BONE_MEAL_COMPOSTING) {
			ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(Items.DYE, 15),
					0.03f, "d5d5df");
		}
	}

	public static void registerCrookingRecipes() {
		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.FAKE_STRING_CROOK_RECIPE_IN_JEI) {
			ExAstrisApiHelper.addCrookingRecipe(new ItemStack(Items.STRING, 1, 0), 0f, ModBlocks.infestedLeaves, 0);
		}
	}

	public static void registerCrucibleRecipes() {
		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.SLIME_FROM_SLIME_BLOCK) {
			ExAstrisApiHelper.addStoneCrucibleRecipe(ExAstrisFluids.SLIME,
					ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.SLIME_PER_SLIME_BLOCK, "blockSlime");
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.WATER_FROM_ICE) {
			ExAstrisApiHelper.addStoneCrucibleRecipe(FluidRegistry.WATER,
					ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.WATER_PER_ICE, "blockIce");
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_FROM_HRAD_STONE) {
			ExAstrisApiHelper.addStoneCrucibleRecipe(FluidRegistry.LAVA,
					ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_PER_HARD_STONE,
					new ItemStack(ExAstrisBlocks.BLOCK_HARD_STONE, 1, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_FROM_STONE_BRICKS) {
			ExAstrisApiHelper.addStoneCrucibleRecipe(FluidRegistry.LAVA,
					ExAstrisConfig.MODULE_VANILLA.CRUCIBLE_RECIPES.LAVA_PER_STONE_BRICKS, "stoneBricks");
		}
	}

	public static void registerHammeringRecipes() {
		if (ExAstrisConfig.MODULE_VANILLA.HAMMER_RECIPES.PRISMARINE_CRYSTALS_FROM_PRISMARINE) {
			ExAstrisApiHelper.addHammeringRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 1f, "prismarine", 0);
			ExAstrisApiHelper.addHammeringRecipe(new ItemStack(Items.PRISMARINE_CRYSTALS, 1, 0), 0.5f, "prismarine", 0);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HAMMER_RECIPES.SAND_FROM_SANDSTONE) {
			ExAstrisApiHelper.addHammeringRecipe(new ItemStack(Blocks.SAND, 1, 0), 1f, "sandstone", 0);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HAMMER_RECIPES.CRACKED_STONE_BRICKS_FROM_STONE_BRICKS) {
			ExAstrisApiHelper.addHammeringRecipe(new ItemStack(Blocks.STONEBRICK, 1, 2), 1f, "stoneBricks", 0);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HAMMER_RECIPES.ICE_SHARDS_FROM_ICE) {
			ExAstrisApiHelper.addHammeringRecipe(new ItemStack(ExAstrisItems.SHARD_ICE, 2, 0), 1f, "blockIce", 0);
			ExAstrisApiHelper.addHammeringRecipe(new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0), 0.75f, "blockIce", 0);
			ExAstrisApiHelper.addHammeringRecipe(new ItemStack(ExAstrisItems.SHARD_ICE, 1, 0), 0.5f, "blockIce", 0);
		}
	}

	public static void registerHeatSources() {
		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.LIT_REDSTONE_LAMP) {
			ExAstrisApiHelper.addHeatSource(new BlockInfo(Blocks.LIT_REDSTONE_LAMP, 0),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.LIT_REDSTONE_LAMP_HEAT_VALUE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.SEA_LANTERN) {
			ExAstrisApiHelper.addHeatSource(new BlockInfo(Blocks.SEA_LANTERN, 0),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.SEA_LANTERN_HEAT_VALUE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.BEACON) {
			ExAstrisApiHelper.addHeatSource(new BlockInfo(Blocks.BEACON, 0),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.BEACON_HEAT_VALUE);
		}

		if (ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.REDSTONE_TORCH) {
			ExAstrisApiHelper.addHeatSource(new BlockInfo(Blocks.REDSTONE_TORCH, 0),
					ExAstrisConfig.MODULE_VANILLA.HEAT_SOURCES.REDSTONE_TORCH_HEAT_VALUE);
		}
	}

	public static void registerSivetingRecipes() {
		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.STRINGS_FROM_INFESTED_LEAVES) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.STRING, 0), 1f, "treeLeavesInfested", 1);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.STRING, 0), 0.75f, "treeLeavesInfested", 1);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.STRING, 0), 0.5f, "treeLeavesInfested", 1);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.FERN_SEEDS_FROM_DIRT) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.SEEDS_FERN, 0), 0.05f, "dirt", 1);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.PODZOL_SEEDS_FROM_DIRT) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.SEEDS_PODZOL, 0), 0.05f, "dirt", 1);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.PRISMARINE_CRYSTALS_FROM_SAND) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.PRISMARINE_CRYSTALS, 0), 0.02f, "sand", 4);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.VANILLA_DROPS_FROM_HIGHER_MESH_TIERS) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.DYE, 15), 0.4f, "dust", 2);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.GUNPOWDER, 0), 0.14f, "dust", 2);

			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.DYE, 15), 0.5f, "dust", 3);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.GUNPOWDER, 0), 0.21f, "dust", 3);

			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.DYE, 15), 0.65f, "dust", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.GUNPOWDER, 0), 0.26f, "dust", 4);

			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.GLOWSTONE_DUST, 0), 0.125f, "dust", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.BLAZE_POWDER, 0), 0.1f, "dust", 4);

			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.FLINT, 0), 0.5f, "gravel", 3);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.COAL, 0), 0.25f, "gravel", 3);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.DYE, 4), 0.1f, "gravel", 3);

			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.FLINT, 0), 0.75f, "gravel", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.COAL, 0), 0.5f, "gravel", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.DYE, 4), 0.2f, "gravel", 4);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENDER_PEARLS_FROM_CRUSHED_ENDSTONE) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.ENDER_PEARL, 0), 0.04f,
					new ItemInfo(ModBlocks.endstoneCrushed, 0), 4);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.CHORUS_FRUITS_FROM_CRUSHED_ENDSTONE) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.CHORUS_FRUIT, 0), 0.02f,
					new ItemInfo(ModBlocks.endstoneCrushed, 0), 4);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.CHORUS_SEEDS_FROM_CRUSHED_ENDSTONE) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.SEEDS_CHORUS, 0), 0.01f,
					new ItemInfo(ModBlocks.endstoneCrushed, 0), 4);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.NETHERRACK_PEBBLES_FROM_DIRT) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.5f, "dirt", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.25f, "dirt", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.1f, "dirt", 4);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENDSTONE_PEBBLES_FROM_DIRT) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.35f, "dirt", 4);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.15f, "dirt", 4);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ICE_SHARDS_FROM_SNOW) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.SHARD_ICE, 0), 1f, "blockSnow", 1);
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ExAstrisItems.SHARD_ICE, 0), 0.5f, "blockSnow", 1);
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENCHANTED_GOLDEN_APPLES_FROM_LEAVES) {
			ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(Items.GOLDEN_APPLE, 1), 0.001f, "treeLeaves", 4);
		}
	}

	public static void registerOreDict() {
        ExAstrisApiHelper.addOreDict("plankWoodOak", Blocks.PLANKS, 0);
        ExAstrisApiHelper.addOreDict("slabWoodOak", Blocks.WOODEN_SLAB, 0);
        ExAstrisApiHelper.addOreDict("logWoodOak", Blocks.LOG, 0);

        ExAstrisApiHelper.addOreDict("plankWoodSpruce", Blocks.PLANKS, 1);
        ExAstrisApiHelper.addOreDict("slabWoodSpruce", Blocks.WOODEN_SLAB, 1);
        ExAstrisApiHelper.addOreDict("logWoodSpruce", Blocks.LOG, 1);

        ExAstrisApiHelper.addOreDict("plankWoodBirch", Blocks.PLANKS, 2);
        ExAstrisApiHelper.addOreDict("slabWoodBirch", Blocks.WOODEN_SLAB, 2);
        ExAstrisApiHelper.addOreDict("logWoodBirch", Blocks.LOG, 2);

        ExAstrisApiHelper.addOreDict("plankWoodJungle", Blocks.PLANKS, 3);
        ExAstrisApiHelper.addOreDict("slabWoodJungle", Blocks.WOODEN_SLAB, 3);
        ExAstrisApiHelper.addOreDict("logWoodJungle", Blocks.LOG, 3);

        ExAstrisApiHelper.addOreDict("plankWoodAcacia", Blocks.PLANKS, 4);
        ExAstrisApiHelper.addOreDict("slabWoodAcacia", Blocks.WOODEN_SLAB, 4);
        ExAstrisApiHelper.addOreDict("logWoodAcacia", Blocks.LOG2, 0);

        ExAstrisApiHelper.addOreDict("plankWoodDarkOak", Blocks.PLANKS, 5);
        ExAstrisApiHelper.addOreDict("slabWoodDarkOak", Blocks.WOODEN_SLAB, 5);
        ExAstrisApiHelper.addOreDict("logWoodDarkOak", Blocks.LOG2, 1);

        ExAstrisApiHelper.addOreDict("slabStone", Blocks.STONE_SLAB, 0);
        ExAstrisApiHelper.addOreDict("stone", Blocks.STONE, 0);
        ExAstrisApiHelper.addOreDict("stone", Blocks.STONE, 1);
        ExAstrisApiHelper.addOreDict("stone", Blocks.STONE, 3);
        ExAstrisApiHelper.addOreDict("stone", Blocks.STONE, 5);

        ExAstrisApiHelper.addOreDict("cobblestone", Blocks.COBBLESTONE, 0);
        ExAstrisApiHelper.addOreDict("slabCobblestone", Blocks.STONE_SLAB, 3);

        ExAstrisApiHelper.addOreDict("stoneBricks", Blocks.STONEBRICK, 0);
        ExAstrisApiHelper.addOreDict("stoneBricks", Blocks.STONEBRICK, 1);
        ExAstrisApiHelper.addOreDict("stoneBricks", Blocks.STONEBRICK, 2);
        ExAstrisApiHelper.addOreDict("stoneBricks", Blocks.STONEBRICK, 3);

        ExAstrisApiHelper.addOreDict("sandstone", Blocks.SANDSTONE, 0);
        ExAstrisApiHelper.addOreDict("sandstone", Blocks.SANDSTONE, 1);
        ExAstrisApiHelper.addOreDict("sandstone", Blocks.SANDSTONE, 2);
        ExAstrisApiHelper.addOreDict("sandstone", Blocks.RED_SANDSTONE, 0);
        ExAstrisApiHelper.addOreDict("sandstone", Blocks.RED_SANDSTONE, 1);
        ExAstrisApiHelper.addOreDict("sandstone", Blocks.RED_SANDSTONE, 2);

        ExAstrisApiHelper.addOreDict("blockQuartz", Blocks.QUARTZ_BLOCK, 0);
        ExAstrisApiHelper.addOreDict("blockQuartz", Blocks.QUARTZ_BLOCK, 1);
        ExAstrisApiHelper.addOreDict("blockQuartz", Blocks.QUARTZ_BLOCK, 2);

        ExAstrisApiHelper.addOreDict("blockPurpur", Blocks.PURPUR_BLOCK, 0);
        ExAstrisApiHelper.addOreDict("blockPurpur", Blocks.PURPUR_PILLAR, 0);
        ExAstrisApiHelper.addOreDict("slabPurpur", Blocks.PURPUR_SLAB, 0);

        ExAstrisApiHelper.addOreDict("prismarine", Blocks.PRISMARINE, 0);
        ExAstrisApiHelper.addOreDict("prismarine", Blocks.PRISMARINE, 1);
        ExAstrisApiHelper.addOreDict("prismarine", Blocks.PRISMARINE, 2);

        ExAstrisApiHelper.addOreDict("dirt", Blocks.DIRT, 1);

        ExAstrisApiHelper.addOreDict("blockIce", Blocks.ICE, 0);
        ExAstrisApiHelper.addOreDict("blockIce", Blocks.PACKED_ICE, 0);

        ExAstrisApiHelper.addOreDict("fish", Items.FISH, 0);
        ExAstrisApiHelper.addOreDict("fish", Items.FISH, 1);
        ExAstrisApiHelper.addOreDict("fish", Items.FISH, 2);
        ExAstrisApiHelper.addOreDict("fish", Items.FISH, 3);

        ExAstrisApiHelper.addOreDict("listAllseed", Items.WHEAT_SEEDS, 0);
        ExAstrisApiHelper.addOreDict("listAllseed", Items.PUMPKIN_SEEDS, 0);
        ExAstrisApiHelper.addOreDict("listAllseed", Items.MELON_SEEDS, 0);
        ExAstrisApiHelper.addOreDict("listAllseed", Items.BEETROOT_SEEDS, 0);
        ExAstrisApiHelper.addOreDict("listAllseed", ExAstrisItems.SEEDS_FERN, 0);
        ExAstrisApiHelper.addOreDict("listAllseed", ExAstrisItems.SEEDS_CHORUS, 0);
        ExAstrisApiHelper.addOreDict("listAllseed", ExAstrisItems.SEEDS_PODZOL, 0);

        ExAstrisApiHelper.addOreDict("treeLeavesInfested", ModBlocks.infestedLeaves, 0);
        ExAstrisApiHelper.addOreDict("treeLeavesInfested", ModBlocks.infestingLeaves, 0);

        ExAstrisApiHelper.addOreDict("blockSnow", Blocks.SNOW, 0);

		ExAstrisApiHelper.addOreDict("netherBrick", Blocks.NETHER_BRICK, 0);
		ExAstrisApiHelper.addOreDict("netherBrick", Blocks.RED_NETHER_BRICK, 0);

		ExAstrisApiHelper.addOreDict("tnt", Blocks.TNT, 0);
    }
}