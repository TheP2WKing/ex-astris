package net.thep2wking.exastris.api.recipe;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import team.chisel.api.carving.CarvingUtils;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.CrucibleRecipe;
import thaumcraft.api.crafting.InfusionRecipe;
import thaumcraft.api.crafting.ShapedArcaneRecipe;
import thaumcraft.api.crafting.ShapelessArcaneRecipe;

@SuppressWarnings("null")
public class ExAstrisModHelper {
	public static void addCarvingRecipe(String category, @Nonnull ItemStack variation, int index) {
		CarvingUtils.getChiselRegistry().addVariation(category, CarvingUtils.variationFor(variation, index));
	}

	public static void addSieveCarvingRecipe(int sieveMeta, int index) {
		addCarvingRecipe(ExAstris.MODID + "_sieve", new ItemStack(ExAstrisBlocks.BLOCK_SIEVE, 1, sieveMeta), index);
	}

	public static void addWoodBarrelCarvingRecipe(int barrelMeta, int index) {
		addCarvingRecipe(ExAstris.MODID + "_barrel", new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T0, 1, barrelMeta),
				index);
	}

	public static void addCrucibleCarvingRecipe(int crucibleMeta, int index) {
		addCarvingRecipe(ExAstris.MODID + "_crucible",
				new ItemStack(ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE, 1, crucibleMeta), index);
	}

	public static void addShapedArcaneCraftingRecipe(String recipeName, String researchRequired, int vis,
			AspectList aspects, ItemStack output, Object... inputs) {
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + recipeName),
				new ShapedArcaneRecipe(null, researchRequired, vis, aspects, output.getItem(), inputs));
	}

	public static void addShapelessArcaneCraftingRecipe(String recipeName, String researchRequired, int vis,
			AspectList aspects, ItemStack output, Object[] inputs) {
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + recipeName),
				new ShapelessArcaneRecipe(null, researchRequired, vis, aspects, output, inputs));
	}

	public static void addCrucibleRecipe(String recipeName, String researchRequired, AspectList aspects,
			ItemStack output, ItemStack input) {
		ThaumcraftApi.addCrucibleRecipe(new ResourceLocation(ExAstris.PREFIX + recipeName),
				new CrucibleRecipe(researchRequired, output, input, aspects));
	}

	public static void addInfusionRecipe(String recipeName, String researchRequired, ItemStack output, AspectList aspects, Object... inputs) {
		ThaumcraftApi.addInfusionCraftingRecipe(new ResourceLocation(ExAstris.PREFIX + recipeName),
				new InfusionRecipe(researchRequired, output, 0, aspects, inputs));
	}
}