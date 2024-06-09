package net.thep2wking.exastris.modules.bloodmagic;

import WayofTime.bloodmagic.alchemyArray.AlchemyArrayEffectBinding;
import WayofTime.bloodmagic.altar.AltarTier;
import WayofTime.bloodmagic.api.IBloodMagicRecipeRegistrar;
import WayofTime.bloodmagic.core.registry.AlchemyArrayRecipeRegistry;
import WayofTime.bloodmagic.item.types.ComponentTypes;
import WayofTime.bloodmagic.util.Utils;
import exnihilocreatio.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.thep2wking.exastris.api.recipe.ExAstrisRecipeHelper;
import net.thep2wking.exastris.config.ExAstrisConfig;

public class BloodMagicRecipes {
	public static void registerAltarRecipes(IBloodMagicRecipeRegistrar registrar) {
		if (ExAstrisConfig.MODULE_BLOOD_MAGIC.ALTAR_RECIPES.NETHER_STAR_FROM_UNCHARGED_NETHER_STAR) {
			registrar.addBloodAltar(
					Ingredient.fromItem(new ItemStack(ExAstrisBloodMagicItems.UNCHARGED_NETHER_STAR, 1, 0).getItem()),
					new ItemStack(Items.NETHER_STAR, 1, 0), AltarTier.FOUR.ordinal(), 20000, 20, 20);
		}
	}

	public static void registerCraftingRecipes() {
		if (ExAstrisConfig.MODULE_BLOOD_MAGIC.ALTAR_RECIPES.NETHER_STAR_FROM_UNCHARGED_NETHER_STAR) {
			ExAstrisRecipeHelper.addShapedRecipe("uncharged_nether_star",
					new ItemStack(ExAstrisBloodMagicItems.UNCHARGED_NETHER_STAR, 1, 0), "AAA", "BCB", "DEF", 'A',
					new ItemStack(Items.SKULL, 1, 0), 'B', "soulSand", 'C', "gemQuartz", 'D',
					new ItemStack(Items.DIAMOND_AXE, 1, 0), 'E', new ItemStack(Items.DIAMOND_PICKAXE, 1, 0), 'F',
					new ItemStack(Items.DIAMOND_SWORD, 1, 0));
		}
	}

	public static void registerBindingRecipes() {
		if (ExAstrisConfig.MODULE_BLOOD_MAGIC.BINDING_RECIPES.BOUND_HAMMER_FROM_DIAMOND_HAMMER) {
			AlchemyArrayRecipeRegistry.registerRecipe(ComponentTypes.REAGENT_BINDING.getStack(),
					new ItemStack(ModItems.hammerDiamond), new AlchemyArrayEffectBinding("boundAxe",
							Utils.setUnbreakable(new ItemStack(ExAstrisBloodMagicItems.HAMMER_BOUND))));
		}

		if (ExAstrisConfig.MODULE_BLOOD_MAGIC.BINDING_RECIPES.BOUND_CROOK_FROM_DIAMOND_CROOK) {
			AlchemyArrayRecipeRegistry.registerRecipe(ComponentTypes.REAGENT_BINDING.getStack(),
					new ItemStack(Item.getByNameOrId("exnihilocreatio:crook_diamond")),
					new AlchemyArrayEffectBinding("boundAxe",
							Utils.setUnbreakable(new ItemStack(ExAstrisBloodMagicItems.CROOK_BOUND))));
		}
	}
}