package net.thep2wking.exastris.modules.thaumcraft;

import exnihilocreatio.ModFluids;
import exnihilocreatio.ModItems;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.texturing.Color;
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
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.init.ExAstrisThaumcraftItems;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.blocks.BlocksTC;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.items.ItemsTC;
import thaumcraft.common.config.ConfigItems;
import thaumcraft.common.lib.enchantment.EnumInfusionEnchantment;

@SuppressWarnings("null")
public class ThaumcraftArcaneWorkbenchRecipes {
	public static void register() {
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

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "quartz"),
				new CrucibleRecipe("EXASTRIS_QUARTZ", new ItemStack(Items.QUARTZ, 2, 0),
						new ItemStack(Items.QUARTZ, 1, 0),
						new AspectList().merge(Aspect.CRYSTAL, 5)));

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
						new AspectList().add(Aspect.PLANT, 128).add(Aspect.EXCHANGE, 64).add(Aspect.MAGIC, 64)
								.add(Aspect.CRYSTAL, 64),
						new ItemStack(BlocksTC.saplingGreatwood),
						new ItemStack(BlocksTC.crystalWater),
						"blockDiamond",
						new ItemStack(BlocksTC.crystalEarth),
						new ItemStack(ItemsTC.salisMundus),
						new ItemStack(BlocksTC.crystalWater),
						"blockDiamond",
						new ItemStack(BlocksTC.crystalEarth),
						new ItemStack(ItemsTC.salisMundus)));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "essentia_filter"),
				new ShapedArcaneRecipe(null, "EXASTRIS_ESSENTIA_FILTER", 25,
						new AspectList().add(Aspect.WATER, 1).add(Aspect.ORDER, 1),
						new ItemStack(ItemsTC.filter, 1, 0), "AAA", "BCB",
						"AAA",
						'A', "string", 'B', "ingotGold", 'C', new ItemStack(ModItems.mesh, 1, 1)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vis_crystal_balance1"),
				new CrucibleRecipe("EXASTRIS_VIS_CRYSTAL_BALANCE",
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE, 1, 0),
						ThaumcraftApiHelper.makeCrystal(Aspect.AIR),
						new AspectList().merge(Aspect.EARTH, 1).merge(Aspect.FIRE, 1).merge(Aspect.WATER, 1)
								.merge(Aspect.ORDER, 1).merge(Aspect.ENTROPY, 1)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vis_crystal_balance2"),
				new CrucibleRecipe("EXASTRIS_VIS_CRYSTAL_BALANCE",
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE, 1, 0),
						ThaumcraftApiHelper.makeCrystal(Aspect.EARTH),
						new AspectList().merge(Aspect.AIR, 1).merge(Aspect.FIRE, 1).merge(Aspect.WATER, 1)
								.merge(Aspect.ORDER, 1).merge(Aspect.ENTROPY, 1)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vis_crystal_balance3"),
				new CrucibleRecipe("EXASTRIS_VIS_CRYSTAL_BALANCE",
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE, 1, 0),
						ThaumcraftApiHelper.makeCrystal(Aspect.FIRE),
						new AspectList().merge(Aspect.AIR, 1).merge(Aspect.EARTH, 1).merge(Aspect.WATER, 1)
								.merge(Aspect.ORDER, 1).merge(Aspect.ENTROPY, 1)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vis_crystal_balance4"),
				new CrucibleRecipe("EXASTRIS_VIS_CRYSTAL_BALANCE",
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE, 1, 0),
						ThaumcraftApiHelper.makeCrystal(Aspect.WATER),
						new AspectList().merge(Aspect.AIR, 1).merge(Aspect.EARTH, 1).merge(Aspect.FIRE, 1)
								.merge(Aspect.ORDER, 1).merge(Aspect.ENTROPY, 1)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vis_crystal_balance5"),
				new CrucibleRecipe("EXASTRIS_VIS_CRYSTAL_BALANCE",
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE, 1, 0),
						ThaumcraftApiHelper.makeCrystal(Aspect.ORDER),
						new AspectList().merge(Aspect.AIR, 1).merge(Aspect.EARTH, 1).merge(Aspect.FIRE, 1)
								.merge(Aspect.WATER, 1).merge(Aspect.ENTROPY, 1)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vis_crystal_balance6"),
				new CrucibleRecipe("EXASTRIS_VIS_CRYSTAL_BALANCE",
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE, 1, 0),
						ThaumcraftApiHelper.makeCrystal(Aspect.ENTROPY),
						new AspectList().merge(Aspect.AIR, 1).merge(Aspect.EARTH, 1).merge(Aspect.FIRE, 1)
								.merge(Aspect.WATER, 1).merge(Aspect.ORDER, 1)));

		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "runic_matrix"),
				new ShapedArcaneRecipe(null, "EXASTRIS_RUNIC_MATRIX", 50,
						new AspectList(),
						new ItemStack(BlocksTC.infusionMatrix, 1, 0), "ABA", "BCB", "ABA",
						'A', new ItemStack(Item.getItemFromBlock(BlocksTC.stoneArcaneBrick)), 'B',
						new ItemStack(ExAstrisItems.VIS_CRYSTAL_BALANCE), 'C', "nitor"));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vishroom1"),
				new CrucibleRecipe("EXASTRIS_VISHROOM",
						new ItemStack(BlocksTC.vishroom),
						new ItemStack(Blocks.RED_MUSHROOM),
						new AspectList().merge(Aspect.PLANT, 4).merge(Aspect.MAGIC, 4).merge(Aspect.UNDEAD, 4)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "vishroom2"),
				new CrucibleRecipe("EXASTRIS_VISHROOM",
						new ItemStack(BlocksTC.vishroom),
						new ItemStack(Blocks.BROWN_MUSHROOM),
						new AspectList().merge(Aspect.PLANT, 4).merge(Aspect.MAGIC, 4).merge(Aspect.UNDEAD, 4)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "shimmerleaf"),
				new CrucibleRecipe("EXASTRIS_SHIMMERLEAF",
						new ItemStack(BlocksTC.shimmerleaf),
						new ItemStack(Item.getItemFromBlock(Blocks.RED_FLOWER)),
						new AspectList().merge(Aspect.PLANT, 4).merge(Aspect.EXCHANGE, 4).merge(Aspect.MAGIC, 4)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "cinderpearl"),
				new CrucibleRecipe("EXASTRIS_CINDERPEARL",
						new ItemStack(BlocksTC.cinderpearl),
						new ItemStack(Item.getItemFromBlock(Blocks.YELLOW_FLOWER)),
						new AspectList().merge(Aspect.PLANT, 4).merge(Aspect.FIRE, 4).merge(Aspect.MAGIC, 4)));

		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + "eldritch_altar_spawner"),
				new InfusionRecipe("EXASTRIS_ELDRITCH_ALTAR", new ItemStack(ExAstrisItems.ELDRITCH_ALTAR_SPAWNER, 1, 0),
						0,
						new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.AVERSION, 64).add(Aspect.MAGIC, 64)
								.add(Aspect.VOID, 64),
						new ItemStack(ItemsTC.mirroredGlass),
						new ItemStack(BlocksTC.stoneEldritchTile),
						new ItemStack(Items.ENDER_EYE),
						new ItemStack(BlocksTC.stoneEldritchTile),
						"ingotVoid",
						new ItemStack(BlocksTC.stoneEldritchTile),
						new ItemStack(Items.ENDER_EYE),
						new ItemStack(BlocksTC.stoneEldritchTile),
						"ingotVoid"));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "eldritch_stone"),
				new CrucibleRecipe("EXASTRIS_ELDRITCH_STONE",
						new ItemStack(BlocksTC.stoneEldritchTile),
						new ItemStack(Item.getItemFromBlock(Blocks.OBSIDIAN)),
						new AspectList().merge(Aspect.ELDRITCH, 5).merge(Aspect.EARTH, 5)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "ancient_stone"),
				new CrucibleRecipe("EXASTRIS_ANCIENT_STONE",
						new ItemStack(BlocksTC.stoneAncient),
						new ItemStack(Item.getItemFromBlock(BlocksTC.stoneArcane)),
						new AspectList().merge(Aspect.ELDRITCH, 5).merge(Aspect.EARTH, 5)));

		ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemStack(Item.getItemFromBlock(BlocksTC.stoneAncient)),
				new ItemInfo(ItemsTC.primordialPearl, 0), 0.001f, BlockSieve.MeshType.DIAMOND.getID());

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "doll_pech_forager"),
				new CrucibleRecipe("EXASTRIS_DOLL_PECH_FORAGER",
						new ItemStack(ExAstrisItems.DOLLS, 1, 2),
						new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5),
						new AspectList().merge(Aspect.DESIRE, 8).merge(Aspect.MAGIC, 8).merge(Aspect.SOUL, 8)));

		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + "doll_crimson_cleric"),
				new CrucibleRecipe("EXASTRIS_DOLL_CRIMSON_CLERIC",
						new ItemStack(ExAstrisItems.DOLLS, 1, 3),
						new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 5),
						new AspectList().merge(Aspect.ELDRITCH, 8).merge(Aspect.MAGIC, 8).merge(Aspect.SOUL, 8)));

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

		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(BlocksTC.cinderpearl), 1);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(BlocksTC.lampArcane), 4);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(BlocksTC.amberBlock), 3);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(BlocksTC.amberBrick), 3);

		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_white")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_orange")), 2);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_magenta")), 2);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_lightblue")), 2);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_yellow")), 2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_lime")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_pink")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_gray")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_silver")), 2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_cyan")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_purple")), 2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_blue")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_brown")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_green")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_red")),
				2);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:candle_black")),
				2);

		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_white")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_orange")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_magenta")), 6);
		ExNihiloRegistryManager.HEAT_REGISTRY
				.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_lightblue")), 6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_yellow")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_lime")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_pink")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_gray")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_silver")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_cyan")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_purple")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_blue")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_brown")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_green")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_red")),
				6);
		ExNihiloRegistryManager.HEAT_REGISTRY.register(new BlockInfo(Block.getBlockFromName("thaumcraft:nitor_black")),
				6);

		ExNihiloRegistryManager.COMPOST_REGISTRY.register(new ItemInfo(BlocksTC.cinderpearl, 0), 0.25f,
				new BlockInfo(Blocks.DIRT), new Color("ffb650"));

		ExNihiloRegistryManager.COMPOST_REGISTRY.register(new ItemInfo(BlocksTC.shimmerleaf, 0), 0.25f,
				new BlockInfo(Blocks.DIRT), new Color("a0c0ba"));

		ExNihiloRegistryManager.COMPOST_REGISTRY.register(new ItemInfo(BlocksTC.vishroom, 0), 0.25f,
				new BlockInfo(Blocks.DIRT), new Color("cc7bcf"));

		ExNihiloRegistryManager.COMPOST_REGISTRY.register(new ItemInfo(ItemsTC.brain, 0), 0.15f,
				new BlockInfo(Blocks.DIRT), new Color("ecc9aa"));

		ExNihiloRegistryManager.COMPOST_REGISTRY.register(new ItemInfo(BlocksTC.fleshBlock, 0), 01f,
				new BlockInfo(Blocks.DIRT), new Color("C45631"));

		ExNihiloRegistryManager.COMPOST_REGISTRY.register("nuggetMeat", 0.05f,
				new BlockInfo(Blocks.DIRT));

		ExNihiloRegistryManager.COMPOST_REGISTRY.register(new ItemInfo(ItemsTC.tripleMeatTreat, 0), 0.25f,
				new BlockInfo(Blocks.DIRT), new Color("ba6f40"));

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

		ExNihiloRegistryManager.SIEVE_REGISTRY.register("sand",
				new ItemInfo(ItemsTC.amber, 0), 0.02f, BlockSieve.MeshType.IRON.getID());
		ExNihiloRegistryManager.SIEVE_REGISTRY.register("sand",
				new ItemInfo(ItemsTC.nuggets, 5), 0.02f, BlockSieve.MeshType.IRON.getID());

		ExNihiloRegistryManager.SIEVE_REGISTRY.register("sand",
				new ItemInfo(ItemsTC.amber, 0), 0.04f, BlockSieve.MeshType.DIAMOND.getID());
		ExNihiloRegistryManager.SIEVE_REGISTRY.register("sand",
				new ItemInfo(ItemsTC.nuggets, 5), 0.04f, BlockSieve.MeshType.DIAMOND.getID());
	}
}