package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.modules.vanilla.config.BarrelRecipesConfig;
import net.thep2wking.exastris.modules.vanilla.config.BlockTransformationRecipesConfig;
import net.thep2wking.exastris.modules.vanilla.config.CraftingRecipesConfig;
import net.thep2wking.exastris.modules.vanilla.config.CrucibleRecipes;
import net.thep2wking.exastris.modules.vanilla.config.FluidTransformRecipesConfig;
import net.thep2wking.exastris.modules.vanilla.config.HammerRecipesConfig;
import net.thep2wking.exastris.modules.vanilla.config.HeatSourcesConfig;
import net.thep2wking.exastris.modules.vanilla.config.MobDollsConfig;
import net.thep2wking.exastris.modules.vanilla.config.SieveRecipesConfig;

public class VanillaConfig {
    @Config.Name("mob_dolls")
    @Config.Comment("Configure Mob Dolls")
    public MobDollsConfig MOB_DOLLS = new MobDollsConfig();


    @Config.Name("block_transformation")
    @Config.Comment("Configure Block Transformation")
    public BlockTransformationRecipesConfig BLOCK_TRANSFORMATION = new BlockTransformationRecipesConfig();

    @Config.Name("barrel_recipes")
    @Config.Comment("Configure Barrel Recipes")
    public BarrelRecipesConfig BARREL_RECIPES = new BarrelRecipesConfig();

    @Config.Name("crucible_recipes")
    @Config.Comment("Configure Crucible Recipes")
    public CrucibleRecipes CRUCIBLE_RECIPES = new CrucibleRecipes();

    @Config.Name("fluid_transform_recipes")
    @Config.Comment("Configure Fluid Transform Recipes")
    public FluidTransformRecipesConfig FLUID_TRANSFORM_RECIPES = new FluidTransformRecipesConfig();

    @Config.Name("hammer_recipes")
    @Config.Comment("Configure Hammer Recipes")
    public HammerRecipesConfig HAMMER_RECIPES = new HammerRecipesConfig();

    @Config.Name("crafting_recipes")
    @Config.Comment("Configure Crafting Recipes")
    public CraftingRecipesConfig CRAFTING_RECIPES = new CraftingRecipesConfig();

    @Config.Name("sieve_recipes")
    @Config.Comment("Configure Sieve Recipes")
    public SieveRecipesConfig SIEVE_RECIPES = new SieveRecipesConfig();

    @Config.Name("heat_sources")
    @Config.Comment("Configure Heat Sources")
    public HeatSourcesConfig HEAT_SOURCES = new HeatSourcesConfig();
}