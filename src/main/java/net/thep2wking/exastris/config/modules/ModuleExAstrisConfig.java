package net.thep2wking.exastris.config.modules;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisBarrelRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisBlockTransformationRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisCrucibleRecipes;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisDollsConfig;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisFluidTransformRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisHammerRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisHeatSourcesConfig;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisMiscConfig;
import net.thep2wking.exastris.config.modules.exastris.ExAstrisSieveRecipesConfig;

public class ModuleExAstrisConfig {
    @Config.Name("barrel_recipes")
    @Config.Comment("Configure Barrel Recipes")
    public ExAstrisBarrelRecipesConfig BARREL_RECIPES = new ExAstrisBarrelRecipesConfig();

    @Config.Name("block_transformation")
    @Config.Comment("Configure Block Transformation")
    public ExAstrisBlockTransformationRecipesConfig BLOCK_TRANSFORMATION = new ExAstrisBlockTransformationRecipesConfig();

    @Config.Name("crucible_recipes")
    @Config.Comment("Configure Crucible Recipes")
    public ExAstrisCrucibleRecipes CRUCIBLE_RECIPES = new ExAstrisCrucibleRecipes();

    @Config.Name("mob_dolls")
    @Config.Comment("Configure Mob Dolls")
    public ExAstrisDollsConfig MOB_DOLLS = new ExAstrisDollsConfig();

    @Config.Name("fluid_transform_recipes")
    @Config.Comment("Configure Fluid Transform Recipes")
    public ExAstrisFluidTransformRecipesConfig FLUID_TRANSFORM_RECIPES = new ExAstrisFluidTransformRecipesConfig();

    @Config.Name("hammer_recipes")
    @Config.Comment("Configure Hammer Recipes")
    public ExAstrisHammerRecipesConfig HAMMER_RECIPES = new ExAstrisHammerRecipesConfig();

    @Config.Name("heat_sources")
    @Config.Comment("Configure Heat Sources")
    public ExAstrisHeatSourcesConfig HEAT_SOURCES = new ExAstrisHeatSourcesConfig();

    @Config.Name("misc")
    @Config.Comment("Configure Misc")
    public ExAstrisMiscConfig MISC = new ExAstrisMiscConfig();

    @Config.Name("sieve_recipes")
    @Config.Comment("Configure Sieve Recipes")
    public ExAstrisSieveRecipesConfig SIEVE_RECIPES = new ExAstrisSieveRecipesConfig();
}
