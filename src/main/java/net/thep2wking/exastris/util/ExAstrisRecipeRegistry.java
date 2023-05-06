package net.thep2wking.exastris.util;

import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.modules.chisel.BarrelRecipesChisel;
import net.thep2wking.exastris.modules.chisel.CarvingRecipesChisel;
import net.thep2wking.exastris.modules.chisel.CraftingRecipesChisel;
import net.thep2wking.exastris.modules.chisel.OreDictChisel;
import net.thep2wking.exastris.modules.chisel.SieveRecipesChisel;
import net.thep2wking.exastris.modules.exastris.BarrelRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.CraftingRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.CrookRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.CrucibleRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.FluidTransformRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.HammerRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.HeatRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.OreDictExAstris;
import net.thep2wking.exastris.modules.exastris.SieveRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.SmeltingRecipesExAstris;

public class ExAstrisRecipeRegistry {
    public static void registerExAstrisRecipes() {
        BarrelRecipesExAstris.register();
        CraftingRecipesExAstris.register();
        CrookRecipesExAstris.register();
        CrucibleRecipesExAstris.register();
        FluidTransformRecipesExAstris.register();
        HammerRecipesExAstris.register();
        HeatRecipesExAstris.register();
        OreDictExAstris.register();
        SieveRecipesExAstris.register();
        SmeltingRecipesExAstris.register();
        ExAstris.LOGGER.info("Registered Recipes for " + ExAstris.MODID);
    }

    public static void registerChiselRecipes() {
        if(Loader.isModLoaded(ExAstrisConstants.MODID_CHISEL)) {
            BarrelRecipesChisel.register();
            CarvingRecipesChisel.register();
            CraftingRecipesChisel.register();
            OreDictChisel.register();
            SieveRecipesChisel.register();
            ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_CHISEL);
        } else {
            ExAstris.LOGGER.info("Skipped registering of Recipes because " + ExAstrisConstants.MODID_CHISEL + " is not installed");
        }
    }

    public static void registerRedstoneArsenalRecipes() {
        if(Loader.isModLoaded(ExAstrisConstants.MODID_REDSTONE_ARSENAL)) {

            ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_REDSTONE_ARSENAL);
        } else {
            ExAstris.LOGGER.info("Skipped registering of Recipes because " + ExAstrisConstants.MODID_REDSTONE_ARSENAL + " is not installed");
        }
    }
}