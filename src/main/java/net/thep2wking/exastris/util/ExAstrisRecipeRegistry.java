package net.thep2wking.exastris.util;

import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.modules.chisel.ChiselBarrelRecipes;
import net.thep2wking.exastris.modules.chisel.ChiselCarvingRecipes;
import net.thep2wking.exastris.modules.chisel.ChiselCraftingRecipes;
import net.thep2wking.exastris.modules.chisel.ChiselOreDict;
import net.thep2wking.exastris.modules.chisel.ChiselSieveRecipes;
import net.thep2wking.exastris.modules.exnihilo.ExNihiloCraftingRecipes;
import net.thep2wking.exastris.modules.exnihilo.ExNihiloSmeltingRecipes;
import net.thep2wking.exastris.modules.redstonearsenal.RedstoneArsenalCraftingRecipes;
import net.thep2wking.exastris.modules.thaumcraft.ExAstrisResearchCategory;
import net.thep2wking.exastris.modules.thaumcraft.ThaumcraftArcaneWorkbenchRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaBarrelRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaCraftingRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaCrookRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaCrucibleRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaFluidTransformRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaHammerRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaHeatSources;
import net.thep2wking.exastris.modules.vanilla.VanillaOreDict;
import net.thep2wking.exastris.modules.vanilla.VanillaSieveRecipes;
import net.thep2wking.exastris.modules.vanilla.VanillaSmeltingRecipes;

public class ExAstrisRecipeRegistry {
    public static void registerVanillaRecipes() {
        VanillaBarrelRecipes.register();
        VanillaCraftingRecipes.register();
        VanillaCrookRecipes.register();
        VanillaCrucibleRecipes.register();
        VanillaFluidTransformRecipes.register();
        VanillaHammerRecipes.register();
        VanillaHeatSources.register();
        VanillaOreDict.register();
        VanillaSieveRecipes.register();
        VanillaSmeltingRecipes.register();
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_MINECRAFT);
        }
    }

    public static void registerExNihiloRecipes() {
        ExNihiloCraftingRecipes.register();
        ExNihiloSmeltingRecipes.register();
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_EX_NIHILO);
        }
    }

    public static void registerChiselRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_CHISEL)) {
            ChiselBarrelRecipes.register();
            ChiselCarvingRecipes.register();
            ChiselCraftingRecipes.register();
            ChiselOreDict.register();
            ChiselSieveRecipes.register();
            if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
                ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_CHISEL);
            }
        } else if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info(
                    "Skipped registering Recipes for " + ExAstrisConstants.MODID_CHISEL + " because mod was not found");
        }
    }

    public static void registerRedstoneArsenalRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_REDSTONE_ARSENAL)) {
            RedstoneArsenalCraftingRecipes.register();
            if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
                ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_REDSTONE_ARSENAL);
            }
        } else if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info(
                    "Skipped registering Recipes for " + ExAstrisConstants.MODID_CHISEL + " because mod was not found");
        }
    }

    public static void registerThaumcraftRecipes() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            ThaumcraftArcaneWorkbenchRecipes.register();
            ExAstrisResearchCategory.init();
            if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
                ExAstris.LOGGER.info("Registered Recipes for " + ExAstrisConstants.MODID_THAUMCRAFT);
            }
        } else if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info(
                    "Skipped registering Recipes for " + ExAstrisConstants.MODID_THAUMCRAFT + " because mod was not found");
        }
    }
}