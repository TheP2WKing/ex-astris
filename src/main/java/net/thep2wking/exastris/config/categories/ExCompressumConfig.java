package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.modules.excompressum.config.AutomaticSieveConfig;

public class ExCompressumConfig {
    @Config.Name("automatic_sieve")
    @Config.Comment("Configure Automatic Sieve")
    public AutomaticSieveConfig AUTOMATIC_SIEVE = new AutomaticSieveConfig();

    // @Config.Name("carving_recipes")
    // @Config.Comment("Configure Carving Recipes")
    // public CarvingRecipesConfig CARVING_RECIPES = new CarvingRecipesConfig();
    
    // @Config.Name("barrel_recipes")
    // @Config.Comment("Configure Barrel Recipes")
    // public BarrelRecipesConfig BARREL_RECIPES = new BarrelRecipesConfig();

    // @Config.Name("sieve_recipes")
    // @Config.Comment("Configure Sieve Recipes")
    // public SieveRecipesConfig SIEVE_RECIPES = new SieveRecipesConfig();
}