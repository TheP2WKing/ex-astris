package net.thep2wking.exastris.modules.thaumcraft;

import exnihilocreatio.ModFluids;
import exnihilocreatio.ModItems;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.recipe.ExAstrisApiHelper;
import net.thep2wking.exastris.api.recipe.ExAstrisModHelper;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisItems;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.enchantment.EnumInfusionEnchantment;

@SuppressWarnings("null")
public class ThaumcraftRecipes {
	public static void registerCraftingRecipes() {
		ExAstrisApiHelper.addSmeltingRecipe(new ItemStack(ItemsTC.crystalEssence, 1, 0),
				new ItemStack(ExAstrisItems.VIS_CRYSTAL_BASE, 1, 0), 0.1f);
	}

	public static void registerArcaneCraftingRecipes() {
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "hammer_thaumium"),
				new ShapedArcaneRecipe(null, "EXASTRIS_SKY_TOOLS", 15,
						new AspectList().add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1),
						ExAstrisThaumcraftItems.HAMMER_THAUMIUM, " A ", " BA", "B  ", 'A', "ingotThaumium", 'B',
						"stickWood"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "crook_thaumium"),
				new ShapedArcaneRecipe(null, "EXASTRIS_SKY_TOOLS", 15,
						new AspectList().add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1),
						ExAstrisThaumcraftItems.CROOK_THAUMIUM, "AAB", " B ", "B  ", 'A', "ingotThaumium", 'B',
						"stickWood"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "sieve_greatwood"),
				new ShapedArcaneRecipe(null, "EXASTRIS_GREATWOOD_BLOCKS", 10,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 6), "A A", "ABA", "C C",
						'A', BlocksTC.plankGreatwood, 'B', BlocksTC.slabGreatwood, 'C', "stickWood"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "sieve_silverwood"),
				new ShapedArcaneRecipe(null, "EXASTRIS_SILVERWOOD_BLOCKS", 10,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 7), "A A", "ABA", "C C",
						'A', BlocksTC.plankSilverwood, 'B', BlocksTC.slabSilverwood, 'C', "stickWood"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "barrel_greatwood"),
				new ShapedArcaneRecipe(null, "EXASTRIS_GREATWOOD_BLOCKS", 10,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 6), "A A", "A A", "ABA",
						'A', BlocksTC.plankGreatwood, 'B', BlocksTC.slabGreatwood));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "barrel_silverwood"),
				new ShapedArcaneRecipe(null, "EXASTRIS_SILVERWOOD_BLOCKS", 10,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 7), "A A", "A A", "ABA",
						'A', BlocksTC.plankSilverwood, 'B', BlocksTC.slabSilverwood));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "crucible_greatwood"),
				new ShapedArcaneRecipe(null, "EXASTRIS_GREATWOOD_BLOCKS", 10,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE), 1, 6), "A A", "ABA",
						"C C",
						'A', BlocksTC.logGreatwood, 'B', BlocksTC.slabGreatwood, 'C', "stickWood"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "crucible_silverwood"),
				new ShapedArcaneRecipe(null, "EXASTRIS_SILVERWOOD_BLOCKS", 10,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE), 1, 7), "A A", "ABA",
						"C C",
						'A', BlocksTC.logSilverwood, 'B', BlocksTC.slabSilverwood, 'C', "stickWood"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "essentia_filter"),
				new ShapedArcaneRecipe(null, "EXASTRIS_ESSENTIA_FILTER", 25,
						new AspectList().add(Aspect.WATER, 1).add(Aspect.ORDER, 1),
						new ItemStack(ItemsTC.filter, 1, 0), "AAA", "BCB",
						"AAA",
						'A', "string", 'B', "ingotGold", 'C', new ItemStack(ModItems.mesh, 1, 1)));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "runic_matrix"),
				new ShapedArcaneRecipe(null, "EXASTRIS_RUNIC_MATRIX", 50,
						new AspectList(),
						new ItemStack(BlocksTC.infusionMatrix, 1, 0), "ABA", "BCB", "ABA",
						'A', new ItemStack(Item.getItemFromBlock(BlocksTC.stoneArcaneBrick)), 'B',
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE), 'C', "nitor"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "barrel_alchemical_brass"),
				new ShapedArcaneRecipe(null, "EXASTRIS_METAL_BLOCKS", 20,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 2), "A A", "A A", "ABA",
						'A', "ingotBrass", 'B', "nuggetBrass"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "barrel_thaumium"),
				new ShapedArcaneRecipe(null, "EXASTRIS_METAL_BLOCKS", 20,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 3), "A A", "A A", "ABA",
						'A', "ingotThaumium", 'B', "nuggetThaumium"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "barrel_void_metal"),
				new ShapedArcaneRecipe(null, "EXASTRIS_METAL_BLOCKS", 20,
						new AspectList().add(Aspect.EARTH, 1),
						new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 4), "A A", "A A", "ABA",
						'A', "ingotVoid", 'B', "nuggetVoid"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "hammer_void"),
				new ShapedArcaneRecipe(null, "EXASTRIS_VOID_TOOLS", 25,
						new AspectList().add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1),
						ExAstrisThaumcraftItems.HAMMER_VOID, " A ", " BA", "B  ", 'A', "ingotVoid", 'B',
						"stickWood"));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "crook_void"),
				new ShapedArcaneRecipe(null, "EXASTRIS_VOID_TOOLS", 25,
						new AspectList().add(Aspect.AIR, 1).add(Aspect.ENTROPY, 1),
						ExAstrisThaumcraftItems.CROOK_VOID, "AAB", " B ", "B  ", 'A', "ingotVoid", 'B',
						"stickWood"));
	}

	public static void registerCrucibleRecipes() {
		ExAstrisModHelper.addCrucibleRecipe("quartz", "EXASTRIS_QUARTZ", new AspectList().add(Aspect.CRYSTAL, 5),
				new ItemStack(Items.QUARTZ, 2, 0), new ItemStack(Items.QUARTZ, 1, 0));

		ExAstrisModHelper.addCrucibleRecipe("vis_crystal_balance", "EXASTRIS_VIS_CRYSTAL_BALANCE",
				new AspectList().add(Aspect.AIR, 1).add(Aspect.EARTH, 1).add(Aspect.FIRE, 1).add(Aspect.WATER, 1)
						.add(Aspect.ORDER, 1).add(Aspect.ENTROPY, 1),
				new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE, 1, 0), new ItemStack(ExAstrisItems.VIS_CRYSTAL_BASE));

		ExAstrisModHelper.addCrucibleRecipe("vishroom", "EXASTRIS_VISHROOM",
				new AspectList().add(Aspect.PLANT, 4).add(Aspect.MAGIC, 4).add(Aspect.UNDEAD, 4),
				new ItemStack(BlocksTC.vishroom), new ItemStack(Blocks.BROWN_MUSHROOM, 1, 0));
		ExAstrisModHelper.addCrucibleRecipe("shimmerleaf", "EXASTRIS_SHIMMERLEAF",
				new AspectList().add(Aspect.PLANT, 4).add(Aspect.EXCHANGE, 4).add(Aspect.MAGIC, 4),
				new ItemStack(BlocksTC.shimmerleaf), new ItemStack(Blocks.RED_FLOWER, 1, 0));
		ExAstrisModHelper.addCrucibleRecipe("cinderpearl", "EXASTRIS_CINDERPEARL",
				new AspectList().add(Aspect.PLANT, 4).add(Aspect.FIRE, 4).add(Aspect.MAGIC, 4),
				new ItemStack(BlocksTC.cinderpearl), new ItemStack(Blocks.YELLOW_FLOWER, 1, 0));

		ExAstrisModHelper.addCrucibleRecipe("eldritch_stone", "EXASTRIS_ELDRITCH_STONE",
				new AspectList().add(Aspect.ELDRITCH, 5).add(Aspect.EARTH, 5),
				new ItemStack(BlocksTC.stoneEldritchTile, 1, 0), new ItemStack(Blocks.OBSIDIAN, 1, 0));
		ExAstrisModHelper.addCrucibleRecipe("ancient_stone", "EXASTRIS_ANCIENT_STONE",
				new AspectList().add(Aspect.ELDRITCH, 5).add(Aspect.EARTH, 5),
				new ItemStack(BlocksTC.stoneAncient, 1, 0), new ItemStack(BlocksTC.stoneArcane, 1, 0));
		ExAstrisModHelper.addCrucibleRecipe("doll_pech_forager", "EXASTRIS_DOLL_PECH_FORAGER",
				new AspectList().add(Aspect.DESIRE, 8).add(Aspect.MAGIC, 8).add(Aspect.SOUL, 8),
				new ItemStack(ExAstrisItems.DOLLS, 1, 2),
				new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5));
		ExAstrisModHelper.addCrucibleRecipe("doll_crimson_cleric", "EXASTRIS_DOLL_CRIMSON_CLERIC",
				new AspectList().add(Aspect.ELDRITCH, 8).add(Aspect.MAGIC, 8).add(Aspect.SOUL, 8),
				new ItemStack(ExAstrisItems.DOLLS, 1, 3),
				new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5));
	}

	public static void registerInfusionRecipes() {
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "sapling_greatwood"),
				new InfusionRecipe("EXASTRIS_GREATWOOD_SAPLING", new ItemStack(BlocksTC.saplingGreatwood, 1, 0), 0,
						new AspectList().add(Aspect.AIR, 64).add(Aspect.EARTH, 64).add(Aspect.FIRE, 64)
								.add(Aspect.WATER, 64).add(Aspect.ORDER, 64).add(Aspect.ENTROPY, 64)
								.add(Aspect.PLANT, 128),
						new ItemStack(Blocks.SAPLING, 1, 3),
						FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidWitchwater, 1000)),
						new ItemStack(BlocksTC.cinderpearl),
						FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidWitchwater, 1000)),
						FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidWitchwater, 1000)),
						FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidWitchwater, 1000)),
						new ItemStack(BlocksTC.shimmerleaf),
						FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidWitchwater, 1000)),
						FluidUtil.getFilledBucket(new FluidStack(ModFluids.fluidWitchwater, 1000))));

		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "sapling_silverwood"),
				new InfusionRecipe("EXASTRIS_SILVERWOOD_SAPLING", new ItemStack(BlocksTC.saplingSilverwood, 1, 0), 0,
						new AspectList().add(Aspect.PLANT, 128).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64),
						new ItemStack(BlocksTC.crystalEarth), new ItemStack(ItemsTC.salisMundus),
						new ItemStack(BlocksTC.crystalWater), "blockDiamond", new ItemStack(BlocksTC.crystalEarth),
						new ItemStack(ItemsTC.salisMundus)));

		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "eldritch_altar_spawner"),
				new InfusionRecipe("EXASTRIS_ELDRITCH_ALTAR", new ItemStack(ExAstrisItems.ELDRITCH_ALTAR_SPAWNER), 0,
						new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.AVERSION, 64).add(Aspect.MAGIC, 64)
								.add(Aspect.VOID, 64),
						new ItemStack(ItemsTC.mirroredGlass), new ItemStack(BlocksTC.stoneEldritchTile),
						new ItemStack(Items.ENDER_EYE), new ItemStack(BlocksTC.stoneEldritchTile), "ingotVoid",
						new ItemStack(BlocksTC.stoneEldritchTile), new ItemStack(Items.ENDER_EYE),
						new ItemStack(BlocksTC.stoneEldritchTile), "ingotVoid"));

		ItemStack isEH = new ItemStack(ExAstrisThaumcraftItems.HAMMER_ELEMENTAL);
		EnumInfusionEnchantment.addInfusionEnchantment(isEH, EnumInfusionEnchantment.DESTRUCTIVE, 1);
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "hammer_elemental"),
				new InfusionRecipe("EXASTRIS_ELEMENTAL_TOOLS", isEH, 1,
						new AspectList().add(Aspect.EARTH, 90).add(Aspect.CRAFT, 60),
						new ItemStack(ExAstrisThaumcraftItems.HAMMER_THAUMIUM, 1, 32767), ConfigItems.ENTROPY_CRYSTAL,
						ConfigItems.EARTH_CRYSTAL, new ItemStack(ItemsTC.nuggets, 1, 10),
						new ItemStack(BlocksTC.plankGreatwood)));

		ItemStack isEC = new ItemStack(ExAstrisThaumcraftItems.CROOK_ELEMENTAL);
		EnumInfusionEnchantment.addInfusionEnchantment(isEC, EnumInfusionEnchantment.COLLECTOR, 1);
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "crook_elemental"),
				new InfusionRecipe("EXASTRIS_ELEMENTAL_TOOLS", isEC, 1,
						new AspectList().add(Aspect.AIR, 30).add(Aspect.PLANT, 30).add(Aspect.WATER, 15),
						new ItemStack(ExAstrisThaumcraftItems.CROOK_THAUMIUM, 1, 32767), ConfigItems.ENTROPY_CRYSTAL,
						ConfigItems.AIR_CRYSTAL, new ItemStack(ItemsTC.nuggets, 1, 10),
						new ItemStack(BlocksTC.plankGreatwood)));
	}

	public static void registerHammeringRecipes() {
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.AIR), 1f, "sandstone", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.EARTH), 1f, "grass", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.FIRE), 1f, "netherBrick", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.WATER), 1f, "blockIce", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.ORDER), 1f, "stone", 0);
		ExAstrisApiHelper.addHammeringRecipe(ThaumcraftApiHelper.makeCrystal(Aspect.ENTROPY), 1f, "tnt", 0);
	}

	public static void registerSivetingRecipes() {
		ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ItemsTC.primordialPearl, 0), 0.001f,
				new ItemInfo(BlocksTC.stoneAncient, 0), 4);

		ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ItemsTC.amber, 0), 0.02f, "sand", 3);
		ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ItemsTC.nuggets, 5), 0.02f, "sand", 3);

		ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ItemsTC.amber, 0), 0.04f, "sand", 4);
		ExAstrisApiHelper.addSivetingRecipe(new ItemInfo(ItemsTC.nuggets, 5), 0.04f, "sand", 4);
	}

	public static void registerHeatSources() {
		ExAstrisApiHelper.addHeatSource(new BlockInfo(BlocksTC.cinderpearl), 1);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(BlocksTC.lampArcane), 4);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(BlocksTC.amberBlock), 3);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(BlocksTC.amberBrick), 3);

		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_white")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_orange")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_magenta")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_lightblue")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_yellow")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_lime")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_pink")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_gray")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_silver")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_cyan")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_purple")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_blue")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_brown")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_green")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_red")), 2);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_black")), 2);

		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_white")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_orange")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_magenta")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_lightblue")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_yellow")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_lime")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_pink")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_gray")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_silver")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_cyan")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_purple")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_blue")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_brown")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_green")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_red")), 6);
		ExAstrisApiHelper.addHeatSource(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_black")), 6);
	}

	public static void registerBarrelRecipes() {
		ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(BlocksTC.cinderpearl, 0), 0.25f,
				"ffb650");
		ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(BlocksTC.shimmerleaf, 0), 0.25f,
				"a0c0ba");
		ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(BlocksTC.vishroom, 0), 0.25f,
				"cc7bcf");
		ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(ItemsTC.brain, 0), 0.15f,
				"ecc9aa");
		ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(ItemsTC.tripleMeatTreat, 0),
				0.25f, "ffb650");
		ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), "nuggetMeat", 0.05f);
		ExAstrisApiHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(BlocksTC.fleshBlock, 0), 0.25f,
				"ba6f40");
	}
}