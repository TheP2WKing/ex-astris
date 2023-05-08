package net.thep2wking.exastris.integration.jei;

import java.util.ArrayList;
import java.util.List;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.compatibility.jei.barrel.compost.CompostRecipeCategory;
import exnihilocreatio.compatibility.jei.barrel.fluiditemtransform.FluidItemTransformRecipeCategory;
import exnihilocreatio.compatibility.jei.barrel.fluidontop.FluidOnTopRecipeCategory;
import exnihilocreatio.compatibility.jei.barrel.fluidtransform.FluidTransformRecipeCategory;
import exnihilocreatio.compatibility.jei.crook.CrookRecipeCategory;
import exnihilocreatio.compatibility.jei.hammer.HammerRecipeCategory;
import exnihilocreatio.compatibility.jei.sieve.SieveRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisRAItems;
import net.thep2wking.exastris.integration.jei.blocktransformation.BlockTransformationCategory;
import net.thep2wking.exastris.integration.jei.blocktransformation.BlockTransformationCompat;
import net.thep2wking.exastris.integration.jei.blocktransformation.BlockTransformationRecipes;
import net.thep2wking.exastris.integration.jei.blocktransformation.BlockTransformationWrapper;
import net.thep2wking.exastris.integration.jei.fluiddolltransform.FluidDollTransformCategory;
import net.thep2wking.exastris.integration.jei.fluiddolltransform.FluidDollTransformCompat;
import net.thep2wking.exastris.integration.jei.fluiddolltransform.FluidDollTransformRecipes;
import net.thep2wking.exastris.integration.jei.fluiddolltransform.FluidDollTransformWrapper;

@JEIPlugin
public class ExAstrisJEIPlugin implements IModPlugin {
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		if (ExAstrisConfig.INTEGRATION_JEI.TRANSFORMATION_RECIPE_CATEGORY) {
			registry.addRecipeCategories(new BlockTransformationCategory(registry.getJeiHelpers().getGuiHelper()));
		}
		if (ExAstrisConfig.INTEGRATION_JEI.DOLL_RECIPE_CATEGORY) {
			registry.addRecipeCategories(new FluidDollTransformCategory(registry.getJeiHelpers().getGuiHelper()));
		}
	}

	public static void addBarrelToRelevantCategories(IModRegistry registry, ItemStack stack) {
		registry.addRecipeCatalyst(stack, FluidDollTransformCategory.UID, FluidOnTopRecipeCategory.UID,
				FluidTransformRecipeCategory.UID, FluidItemTransformRecipeCategory.UID, CompostRecipeCategory.UID);
	}

	public static void addSieveToRelevantCategories(IModRegistry registry, ItemStack stack) {
		registry.addRecipeCatalyst(stack, SieveRecipeCategory.UID);
	}

	public static void hideFromJEI(IModRegistry registry, ItemStack stack) {
		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(stack);
	}

	@Override
	public void register(IModRegistry registry) {
		if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("JEI Integration loaded");
        }
		
		if (ExAstrisConfig.INTEGRATION_JEI.TRANSFORMATION_RECIPE_CATEGORY) {
			List<BlockTransformationWrapper> listBlockTransform = new ArrayList<>();
			List<BlockTransformationCompat> blockTransform = new ArrayList<>();
			blockTransform.add(new BlockTransformationRecipes());
			for (BlockTransformationCompat bt : blockTransform)
				if (bt.shouldLoad())
					bt.addRecipes(listBlockTransform);
			registry.addRecipes(listBlockTransform, BlockTransformationCategory.UID);
		}

		if (ExAstrisConfig.INTEGRATION_JEI.DOLL_RECIPE_CATEGORY) {
			List<FluidDollTransformWrapper> listMobDoll = new ArrayList<>();
			List<FluidDollTransformCompat> mobDoll = new ArrayList<>();
			mobDoll.add(new FluidDollTransformRecipes());
			for (FluidDollTransformCompat mb : mobDoll)
				if (mb.shouldLoad())
					mb.addRecipes(listMobDoll);
			registry.addRecipes(listMobDoll, FluidDollTransformCategory.UID);
		}

		if (ExAstrisConfig.MODULE_EX_ASTRIS.BLOCK_TRANSFORMATION.BEDROCK_FROM_QUADRUPLE_HARD_STONE) {
			registry.addRecipeCatalyst(
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE), 1, 0),
					BlockTransformationCategory.UID);
		}
		if (ExAstrisConfig.MODULE_EX_ASTRIS.BLOCK_TRANSFORMATION.SNOW_FROM_FROSTY_DIRT) {
			registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_FROSTY_DIRT), 1, 0),
					BlockTransformationCategory.UID);
		}

		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.REPLACE_EX_NIHILO_BARRELS) {
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 0));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 1));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 2));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 3));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 4));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 5));

			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 0));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 1));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 2));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 3));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 4));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 5));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 6));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 7));

			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 0));
			addBarrelToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 1));
		}

		registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ModBlocks.barrelWood), 1, 0),
				FluidDollTransformCategory.UID);
		registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ModBlocks.barrelStone), 1, 0),
				FluidDollTransformCategory.UID);

		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.REPLACE_EX_NIHILO_SIEVES) {
			addSieveToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 0));
			addSieveToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 1));
			addSieveToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 2));
			addSieveToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 3));
			addSieveToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 4));
			addSieveToRelevantCategories(registry,
					new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_SIEVE), 1, 5));
		}

		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.REPLACE_EX_NIHILO_BARRELS) {
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.barrelWood), 1, 0));
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.barrelStone), 1, 0));
		}
		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.REPLACE_EX_NIHILO_SIEVES) {
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.sieve), 1, 0));
		}
		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.REPLACE_EX_NIHILO_END_CAKE) {
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.endCake), 1, 0));
		}
		if (ExAstrisConfig.INTEGRATION_JEI.HIDE_UNUSED) {
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.infestingLeaves), 1, 0));
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.grinder), 1, 0));
		}
		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.REMOVE_EX_NIHILO_AUTO_SIFTER) {
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.watermill), 1, 0));
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.axle_stone), 1, 0));
			hideFromJEI(registry, new ItemStack(Item.getItemFromBlock(ModBlocks.autoSifter), 1, 0));
			hideFromJEI(registry, new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 6));
			hideFromJEI(registry, new ItemStack(Item.getByNameOrId("exnihilocreatio:item_material"), 1, 7));
		}

		if (Loader.isModLoaded("redstonearsenal")) {
			registry.addRecipeCatalyst(new ItemStack(ExAstrisRAItems.HAMMER_FLUX, 1, 0), HammerRecipeCategory.UID);
			registry.addRecipeCatalyst(new ItemStack(ExAstrisRAItems.CROOK_FLUX, 1, 0), CrookRecipeCategory.UID);
		}
	}
}