package net.thep2wking.exastris.config.modules;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.config.modules.exastris.BarrelRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.BlockTransformationRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.CrucibleRecipes;
import net.thep2wking.exastris.config.modules.exastris.MobDollsConfig;
import net.thep2wking.exastris.config.modules.exastris.FluidTransformRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.HammerRecipesConfig;
import net.thep2wking.exastris.config.modules.exastris.HeatSourcesConfig;
import net.thep2wking.exastris.config.modules.exastris.MiscConfig;
import net.thep2wking.exastris.config.modules.exastris.SieveRecipesConfig;

public class ExAstrisModuleConfig {
    @Config.Name("barrel_recipes")
    @Config.Comment("Configure Barrel Recipes")
    public BarrelRecipesConfig BARREL_RECIPES = new BarrelRecipesConfig();

    @Config.Name("block_transformation")
    @Config.Comment("Configure Block Transformation")
    public BlockTransformationRecipesConfig BLOCK_TRANSFORMATION = new BlockTransformationRecipesConfig();

    @Config.Name("crucible_recipes")
    @Config.Comment("Configure Crucible Recipes")
    public CrucibleRecipes CRUCIBLE_RECIPES = new CrucibleRecipes();

    @Config.Name("fluid_transform_recipes")
    @Config.Comment("Configure Fluid Transform Recipes")
    public FluidTransformRecipesConfig FLUID_TRANSFORM_RECIPES = new FluidTransformRecipesConfig();

    @Config.Name("hammer_recipes")
    @Config.Comment("Configure Hammer Recipes")
    public HammerRecipesConfig HAMMER_RECIPES = new HammerRecipesConfig();

    @Config.Name("heat_sources")
    @Config.Comment("Configure Heat Sources")
    public HeatSourcesConfig HEAT_SOURCES = new HeatSourcesConfig();

    @Config.Name("misc")
    @Config.Comment("Configure Misc")
    public MiscConfig MISC = new MiscConfig();

    @Config.Name("mob_dolls")
    @Config.Comment("Configure Mob Dolls")
    public MobDollsConfig MOB_DOLLS = new MobDollsConfig();

    @Config.Name("sieve_recipes")
    @Config.Comment("Configure Sieve Recipes")
    public SieveRecipesConfig SIEVE_RECIPES = new SieveRecipesConfig();
}