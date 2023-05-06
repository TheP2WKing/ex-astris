package net.thep2wking.exastris.config.modules;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.config.modules.chisel.ChiselBarrelRecipesConfig;
import net.thep2wking.exastris.config.modules.chisel.ChiselCarvingRecipesConfig;
import net.thep2wking.exastris.config.modules.chisel.ChiselSieveRecipesConfig;

public class ModuleChiselConfig {
    @Config.Name("barrel_recipes")
    @Config.Comment("Configure Barrel Recipes")
    public ChiselBarrelRecipesConfig CHISEL_BARREL_RECIPES = new ChiselBarrelRecipesConfig();

    @Config.Name("carving_recipes")
    @Config.Comment("Configure Carving Recipes")
    public ChiselCarvingRecipesConfig CHISEL_CARVING_RECIPES = new ChiselCarvingRecipesConfig();

    @Config.Name("sieve_recipes")
    @Config.Comment("Configure Sieve Recipes")
    public ChiselSieveRecipesConfig CHISEL_SIEVE_RECIPES = new ChiselSieveRecipesConfig();
}
