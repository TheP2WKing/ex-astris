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
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisRAItems;
import net.thep2wking.exastris.integration.jei.barrel.FluidDollTransformCategory;
import net.thep2wking.exastris.integration.jei.barrel.FluidDollTransformCompat;
import net.thep2wking.exastris.integration.jei.barrel.FluidDollTransformRecipes;
import net.thep2wking.exastris.integration.jei.barrel.FluidDollTransformWrapper;
import net.thep2wking.exastris.integration.jei.categories.TransformationCategory;
import net.thep2wking.exastris.integration.jei.categories.TransformationCompat;
import net.thep2wking.exastris.integration.jei.categories.TransformationRecipes;
import net.thep2wking.exastris.integration.jei.categories.TransformationWrapper;

@JEIPlugin
public class ExAstrisJEIPlugin implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new TransformationCategory(registry.getJeiHelpers().getGuiHelper()));
        registry.addRecipeCategories(new FluidDollTransformCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void register(IModRegistry registry) {
        
        List<TransformationWrapper> list = new ArrayList<>();
        List<TransformationCompat> charger = new ArrayList<>();
        charger.add(new TransformationRecipes());
        for (TransformationCompat cha : charger) if (cha.shouldLoad()) cha.addRecipes(list);
        registry.addRecipes(list, TransformationCategory.UID);

        List<FluidDollTransformWrapper> list2 = new ArrayList<>();
        List<FluidDollTransformCompat> charger2 = new ArrayList<>();
        charger2.add(new FluidDollTransformRecipes());
        for (FluidDollTransformCompat cha2 : charger2) if (cha2.shouldLoad()) cha2.addRecipes(list2);
        registry.addRecipes(list2, FluidDollTransformCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE), 1, 0),
                TransformationCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ModBlocks.barrelWood), 1, 0),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ModBlocks.barrelStone), 1, 0),
                FluidDollTransformCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 0),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 1),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 2),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 3),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 4),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 5),
                FluidDollTransformCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 0),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 1),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 2),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 3),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 4),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 5),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 6),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 7),
                FluidDollTransformCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 0),
                FluidDollTransformCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 1),
                FluidDollTransformCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 0),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 1),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 2),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 3),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 4),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 5),
                FluidOnTopRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 0),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 1),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 2),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 3),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 4),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 5),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 6),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 7),
                FluidOnTopRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 0),
                FluidOnTopRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 1),
                FluidOnTopRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 0),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 1),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 2),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 3),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 4),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 5),
                FluidTransformRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 0),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 1),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 2),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 3),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 4),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 5),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 6),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 7),
                FluidTransformRecipeCategory.UID);
        
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 0),
                FluidTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 1),
                FluidTransformRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 0),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 1),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 2),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 3),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 4),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 5),
                FluidItemTransformRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 0),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 1),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 2),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 3),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 4),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 5),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 6),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 7),
                FluidItemTransformRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 0),
                FluidItemTransformRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 1),
                FluidItemTransformRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 0),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 1),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 2),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 3),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 4),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T0), 1, 5),
                CompostRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 0),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 1),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 2),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 3),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 4),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 5),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 6),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T1), 1, 7),
                CompostRecipeCategory.UID);

        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 0),
                CompostRecipeCategory.UID);
        registry.addRecipeCatalyst(new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_BARREL_T2), 1, 1),
                CompostRecipeCategory.UID);

        registry.getJeiHelpers().getIngredientBlacklist()
                .addIngredientToBlacklist(new ItemStack(Item.getItemFromBlock(ModBlocks.barrelWood), 1, 0));
        registry.getJeiHelpers().getIngredientBlacklist()
                .addIngredientToBlacklist(new ItemStack(Item.getItemFromBlock(ModBlocks.barrelStone), 1, 0));
        
        registry.getJeiHelpers().getIngredientBlacklist()
                .addIngredientToBlacklist(new ItemStack(Item.getItemFromBlock(ModBlocks.endCake), 1, 0));

        registry.getJeiHelpers().getIngredientBlacklist()
                .addIngredientToBlacklist(new ItemStack(Item.getItemFromBlock(ModBlocks.infestingLeaves), 1, 0));

        if (Loader.isModLoaded("redstonearsenal")) {
            registry.addRecipeCatalyst(new ItemStack(ExAstrisRAItems.HAMMER_FLUX, 1, 0), HammerRecipeCategory.UID);
            registry.addRecipeCatalyst(new ItemStack(ExAstrisRAItems.CROOK_FLUX, 1, 0), CrookRecipeCategory.UID);
        }
    }
}