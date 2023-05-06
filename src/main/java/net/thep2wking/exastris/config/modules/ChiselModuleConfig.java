package net.thep2wking.exastris.config.modules;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.config.modules.chisel.BarrelRecipesConfig;
import net.thep2wking.exastris.config.modules.chisel.CarvingRecipesConfig;
import net.thep2wking.exastris.config.modules.chisel.SieveRecipesConfig;

public class ChiselModuleConfig {
    @Config.Name("barrel_recipes")
    @Config.Comment("Configure Barrel Recipes")
    public BarrelRecipesConfig BARREL_RECIPES = new BarrelRecipesConfig();

    @Config.Name("carving_recipes")
    @Config.Comment("Configure Carving Recipes")
    public CarvingRecipesConfig CARVING_RECIPES = new CarvingRecipesConfig();

    @Config.Name("sieve_recipes")
    @Config.Comment("Configure Sieve Recipes")
    public SieveRecipesConfig SIEVE_RECIPES = new SieveRecipesConfig();
}