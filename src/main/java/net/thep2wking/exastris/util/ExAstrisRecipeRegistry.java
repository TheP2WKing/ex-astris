package net.thep2wking.exastris.util;

import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.modules.chisel.ChiselRecipes;
import net.thep2wking.exastris.modules.excompressum.ExCompressumRecipes;
import net.thep2wking.exastris.modules.redstonearsenal.RedstoneArsenalRecipes;
import net.thep2wking.exastris.modules.thaumcraft.ResearchCategoryExAstris;
import net.thep2wking.exastris.modules.thaumcraft.ThaumcraftRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaRecipes;
import net.thep2wking.exastris.util.handler.ExAstrisUtils;

public class ExAstrisRecipeRegistry {
    public static void registerVanillaRecipes() {
        VanillaRecipes.registerBarrelRecipes();
        VanillaRecipes.registerCraftingRecipes();
        VanillaRecipes.registerCrookingRecipes();
        VanillaRecipes.registerCrucibleRecipes();
        VanillaRecipes.registerHammeringRecipes();
        VanillaRecipes.registerHeatSources();
        VanillaRecipes.registerOreDict();
        VanillaRecipes.registerSivetingRecipes();
        ExAstrisUtils.recipesLoadedMessage(ExAstrisConstants.MODID_MINECRAFT);
    }

    public static void registerChiselRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_CHISEL)) {
            ChiselRecipes.registerBarrelRecipes();
            ChiselRecipes.registerCarvingRecipes();
            ChiselRecipes.registerCraftingRecipes();
            ChiselRecipes.registerOreDict();
            ChiselRecipes.registerSivetingRecipes();
        }
        ExAstrisUtils.recipesLoadedMessage(ExAstrisConstants.MODID_CHISEL);
    }

    public static void registerRedstoneArsenalRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_REDSTONE_ARSENAL)) {
            RedstoneArsenalRecipes.registerCraftingRecipes();
            RedstoneArsenalRecipes.registerOreDict();
        }
        ExAstrisUtils.recipesLoadedMessage(ExAstrisConstants.MODID_REDSTONE_ARSENAL);
    }

    public static void registerThaumcraftRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            ThaumcraftRecipes.registerArcaneCraftingRecipes();
            ThaumcraftRecipes.registerBarrelRecipes();
            ThaumcraftRecipes.registerCraftingRecipes();
            ThaumcraftRecipes.registerCrucibleRecipes();
            ThaumcraftRecipes.registerHammeringRecipes();
            ThaumcraftRecipes.registerHeatSources();
            ThaumcraftRecipes.registerInfusionRecipes();
            ThaumcraftRecipes.registerSivetingRecipes();
            ResearchCategoryExAstris.register();
        }
        ExAstrisUtils.recipesLoadedMessage(ExAstrisConstants.MODID_THAUMCRAFT);
    }

    public static void registerExCompressumRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_EX_COMPRESSUM)) {
            ExCompressumRecipes.registerCraftingRecipes();
        }
        ExAstrisUtils.recipesLoadedMessage(ExAstrisConstants.MODID_EX_COMPRESSUM);
    }
}