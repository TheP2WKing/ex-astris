package net.thep2wking.exastris.api.recipe;

import javax.annotation.Nonnull;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.texturing.Color;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisItems;

public class ExAstrisRecipeHelper {
	public static void addShapedRecipe(String name, ItemStack output, Object... inputs) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, name), null, output, inputs);
	}

	public static void addShapelessRecipe(String name, ItemStack output, ItemStack... inputs) {
		Ingredient[] ingredients = new Ingredient[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			ingredients[i] = Ingredient.fromStacks(inputs[i]);
		}
		GameRegistry.addShapelessRecipe(new ResourceLocation(ExAstris.MODID, name), null, output, ingredients);
	}

	public static void addShapelessRecipe(String name, ItemStack output, Object... inputs) {
		ShapelessOreRecipe oreRecipe = new ShapelessOreRecipe(new ResourceLocation(ExAstris.MODID, name), output, inputs);
		oreRecipe.setRegistryName(new ResourceLocation(ExAstris.MODID, name));
		ForgeRegistries.RECIPES.register(oreRecipe);
	}

	public static void removeRecipe(String name) {
		GameRegistry.addShapedRecipe(new ResourceLocation(name), null,
				new ItemStack(Item.getByNameOrId("null")), "A", 'A', "null");
	}

	public static void addSmeltingRecipe(ItemStack output, ItemStack input, float xp) {
		GameRegistry.addSmelting(output, input, xp);
	}

	public static void addOreDictSmeltingRecipe(ItemStack output, String inputOreDict, float xp) {
		for (@Nonnull
		ItemStack inputs : OreDictionary.getOres(inputOreDict)) {
			GameRegistry.addSmelting(inputs, output, xp);
		}
	}

	public static void addOreDict(String name, Item input, int meta) {
		OreDictionary.registerOre(name, new ItemStack(input, 1, meta));
	}

	public static void addOreDict(String name, Block input, int meta) {
		OreDictionary.registerOre(name, new ItemStack(input, 1, meta));
	}

	public static void addOreDict(String name, ItemStack input) {
		OreDictionary.registerOre(name, input);
	}

	public static void add9xCompressRecipe(String recipeName, @Nonnull ItemStack output, @Nonnull ItemStack input) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, recipeName), null, output, "AAA", "AAA",
				"AAA", 'A', input);
	}

	public static void add4xCompressRecipe(String recipeName, @Nonnull ItemStack output, @Nonnull ItemStack input) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, recipeName), null, output, "AA", "AA", 'A',
				input);
	}

	public static void add9xUncompressRecipe(String recipeName, Item output, int meta, @Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(ExAstris.MODID, recipeName), null,
				new ItemStack(output, 9, meta), Ingredient.fromStacks(input));
	}

	public static void add9xUncompressRecipe(String recipeName, Block output, int meta, @Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(ExAstris.MODID, recipeName), null,
				new ItemStack(output, 9, meta), Ingredient.fromStacks(input));
	}

	public static void add4xUncompressRecipe(String recipeName, @Nonnull Item output, int meta,
			@Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(ExAstris.MODID, recipeName), null,
				new ItemStack(output, 4, meta), Ingredient.fromStacks(input));
	}

	public static void add4xUncompressRecipe(String recipeName, @Nonnull Block output, int meta,
			@Nonnull ItemStack input) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(ExAstris.MODID, recipeName), null,
				new ItemStack(output, 4, meta), Ingredient.fromStacks(input));
	}

	public static void addPebbleToBlockRecipe(String materialName, int pebbleMeta, @Nonnull ItemStack output) {
		add4xCompressRecipe(materialName + "_from_pebble", output, new ItemStack(ExAstrisItems.PEBBLES, 1, pebbleMeta));
	}

	public static void addWoodBarrelCraftingRecipe(String materialName, int barrelMeta, String plankOreDict,
			String slabOreDict) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "barrel_" + materialName), null,
				new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, barrelMeta),
				"A A", "A A", "ABA", 'A', plankOreDict, 'B', slabOreDict);
	}

	public static void addStoneBarrelCraftingRecipe(String materialName, int barrelMeta, String stoneOreDict,
			String slabOreDict) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "barrel_" + materialName), null,
				new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, barrelMeta),
				"A A", "A A", "ABA", 'A', stoneOreDict, 'B', slabOreDict);
	}

	public static void addMetalBarrelCraftingRecipe(String materialName, int barrelMeta, String ingotOreDict,
			String nuggetOreDict) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "barrel_" + materialName), null,
				new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T2, 1, barrelMeta),
				"A A", "A A", "ABA", 'A', ingotOreDict, 'B', nuggetOreDict);
	}

	public static void addSieveCraftingRecipe(String materialName, int sieveMeta, String plankOreDict,
			String slabOreDict) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "sieve_" + materialName), null,
				new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, sieveMeta),
				"A A", "ABA", "C C", 'A', plankOreDict, 'B', slabOreDict, 'C', "stickWood");
	}

	public static void addCrucibleCraftingRecipe(String materialName, int sieveMeta, String logOreDict,
			String slabOreDict) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "crucible_" + materialName), null,
				new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, sieveMeta),
				"A A", "ABA", "C C", 'A', logOreDict, 'B', slabOreDict, 'C', "stickWood");
	}

	public static void addSieveBarrelAndCrucibleCraftingRecipe(String materialName, int meta, String plankOreDict,
			String slabOreDict, String logOreDict) {
		addSieveCraftingRecipe(materialName, meta, plankOreDict, slabOreDict);
		addWoodBarrelCraftingRecipe(materialName, meta, plankOreDict, slabOreDict);
		addCrucibleCraftingRecipe(materialName, meta, logOreDict, slabOreDict);
	}

	public static void addHammerCraftingRecipe(String materialName, @Nonnull ItemStack output, String headMaterial,
			String handleMaterial) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "hammer_" + materialName), null, output, " A ",
				" BA", "B  ", 'A', headMaterial, 'B', handleMaterial);
	}

	public static void addHammerCraftingRecipe(String materialName, @Nonnull ItemStack output,
			@Nonnull ItemStack headMaterial, @Nonnull ItemStack handleMaterial) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "hammer_" + materialName), null, output, " A ",
				" BA", "B  ", 'A', headMaterial, 'B', handleMaterial);
	}

	public static void addCrookCraftingRecipe(String materialName, @Nonnull ItemStack output, String headMaterial,
			String handleMaterial) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "crook_" + materialName), null, output, "AAB",
				" B ", "B  ", 'A', headMaterial, 'B', handleMaterial);
	}

	public static void addCrookCraftingRecipe(String materialName, @Nonnull ItemStack output,
			@Nonnull ItemStack headMaterial, @Nonnull ItemStack handleMaterial) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ExAstris.MODID, "crook_" + materialName), null, output, "AAB",
				" B ", "B  ", 'A', headMaterial, 'B', handleMaterial);
	}

	public static void addFluidItemItemRecipe(ItemInfo output, String inputOreDict, Fluid inputFluid) {
		ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(inputFluid, inputOreDict, output);
	}

	public static void addFluidItemItemRecipe(ItemInfo output, ItemInfo input, Fluid inputFluid) {
		ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(inputFluid, input, output);
	}

	public static void addFluidItemFluidRecipe(String outputFluid, ItemInfo input, String inputFluid) {
		ExNihiloRegistryManager.FLUID_ITEM_FLUID_REGISTRY.register(inputFluid,
				input, outputFluid);
	}

	public static void addCompostingRecipe(BlockInfo output, ItemInfo input, float value, String hexColor) {
		ExNihiloRegistryManager.COMPOST_REGISTRY.register(input, value, output, new Color(hexColor));
	}

	public static void addCompostingRecipe(BlockInfo output, String input, float value, String hexColor) {
		ExNihiloRegistryManager.COMPOST_REGISTRY.register(input, value, output, new Color(hexColor));
	}

	public static void addCompostingRecipe(BlockInfo output, String input, float value) {
		ExNihiloRegistryManager.COMPOST_REGISTRY.register(input, value, output);
	}

	public static void addCrookingRecipe(ItemStack output, float chance, Block input, int meta) {
		ExNihiloRegistryManager.CROOK_REGISTRY.register(input, meta, output, chance, 0f);
	}

	public static void addStoneCrucibleRecipe(Fluid output, int amount, ItemStack input) {
		ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register(input, output, amount);
	}

	public static void addStoneCrucibleRecipe(Fluid output, int amount, String input) {
		ExNihiloRegistryManager.CRUCIBLE_STONE_REGISTRY.register(input, output, amount);
	}

	public static void addFluidTransformRecipe(String outputFluid, String inputFluid, BlockInfo block, int duration) {
		final BlockInfo[] transformingBlocks = { block };
		final BlockInfo[] spawnBlocks = {};
		ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register(inputFluid, outputFluid, duration, transformingBlocks,
				spawnBlocks);
	}

	public static void addFluidTransformRecipe(String outputFluid, String inputFluid, BlockInfo block, int duration,
			BlockInfo[] blocksToSpawn) {
		final BlockInfo[] transformingBlocks = { block };
		ExNihiloRegistryManager.FLUID_TRANSFORM_REGISTRY.register(inputFluid, outputFluid, duration, transformingBlocks,
				blocksToSpawn);
	}

	public static void addHammeringRecipe(ItemStack output, float chance, Block input, int meta, int harvestLevel) {
		ExNihiloRegistryManager.HAMMER_REGISTRY.register(input, meta, output, harvestLevel, chance, 0f);
	}

	public static void addHammeringRecipe(ItemStack output, float chance, String input, int harvestLevel) {
		ExNihiloRegistryManager.HAMMER_REGISTRY.register(input, output, harvestLevel, chance, 0f);
	}

	public static void addHeatSource(BlockInfo input, int value) {
		ExNihiloRegistryManager.HEAT_REGISTRY.register(input, value);
	}

	public static void addSivetingRecipe(ItemInfo output, float chance, ItemInfo input, int meshLevel) {
		ExNihiloRegistryManager.SIEVE_REGISTRY.register(input, output, chance, meshLevel);
	}

	public static void addSivetingRecipe(ItemInfo output, float chance, String input, int meshLevel) {
		ExNihiloRegistryManager.SIEVE_REGISTRY.register(input, output, chance, meshLevel);
	}
}