package net.thep2wking.exastris.util;

import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
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
import net.thep2wking.exastris.modules.exastris.HeatSourcesExAstris;
import net.thep2wking.exastris.modules.exastris.OreDictExAstris;
import net.thep2wking.exastris.modules.exastris.SieveRecipesExAstris;
import net.thep2wking.exastris.modules.exastris.SmeltingRecipesExAstris;
import net.thep2wking.exastris.modules.redstonearsenal.RecipesRedstoneArsenal;

public class ExAstrisRecipeRegistry {
    public static void registerExAstrisRecipes() {
        if (ExAstrisConfig.MODULES.DEFAULT_INTEGRATION) {
            BarrelRecipesExAstris.register();
            CraftingRecipesExAstris.register();
            CrookRecipesExAstris.register();
            CrucibleRecipesExAstris.register();
            FluidTransformRecipesExAstris.register();
            HammerRecipesExAstris.register();
            HeatSourcesExAstris.register();
            OreDictExAstris.register();
            SieveRecipesExAstris.register();
            SmeltingRecipesExAstris.register();
            if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
                ExAstris.LOGGER.info("Registered Recipes for " + ExAstris.MODID);
            }
        } else if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Skipped registering of Recipes because " + ExAstrisConstants.MODID_CHISEL
                    + " Integration was disabled");
        }
    }

    public static void registerChiselRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_CHISEL) && ExAstrisConfig.MODULES.CHISEL_INTEGRATION) {
            BarrelRecipesChisel.register();
            CarvingRecipesChisel.register();
            CraftingRecipesChisel.register();
            OreDictChisel.register();
            SieveRecipesChisel.register();
            if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
                ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_CHISEL);
            }
        } else if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Skipped registering of Recipes because " + ExAstrisConstants.MODID_CHISEL
                    + " is not installed or Integration was disabled");
        }
    }

    public static void registerRedstoneArsenalRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_REDSTONE_ARSENAL)
                && ExAstrisConfig.MODULES.REDSTONE_ARSENAL_INTEGRATION) {
            RecipesRedstoneArsenal.register();
            if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
                ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_REDSTONE_ARSENAL);
            }
        } else if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Skipped registering of Recipes because " + ExAstrisConstants.MODID_REDSTONE_ARSENAL
                    + " is not installed or Integration was disabled");
        }
    }
}