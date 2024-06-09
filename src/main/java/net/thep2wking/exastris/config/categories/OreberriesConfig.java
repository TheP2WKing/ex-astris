package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.modules.oreberries.config.BarrelRecipesConfig;
import net.thep2wking.exastris.modules.oreberries.config.SieveRecipesConfig;

public class OreberriesConfig {
	@Config.Name("sieve_recipes")
    @Config.Comment("Configure Sieve Recipes")
    public SieveRecipesConfig SIEVE_RECIPES = new SieveRecipesConfig();

	@Config.Name("barrel_recipes")
    @Config.Comment("Configure Barrel Recipes")
    public BarrelRecipesConfig BARREL_RECIPES = new BarrelRecipesConfig();
}