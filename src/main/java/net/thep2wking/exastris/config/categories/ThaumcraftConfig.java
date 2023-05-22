package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.modules.thaumcraft.config.ArcaneRecipesConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.BarrelRecipesConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.CrooksConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.CrucibleRecipes;
import net.thep2wking.exastris.modules.thaumcraft.config.HammerConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.HammerRecipesConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.HeatSourcesConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.InfusionRecipes;
import net.thep2wking.exastris.modules.thaumcraft.config.MiscConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.MobDollsConfig;
import net.thep2wking.exastris.modules.thaumcraft.config.SieveRecipesConfig;

public class ThaumcraftConfig {	
	@Config.Name("misc")
    @Config.Comment("Configure Misc")
    public MiscConfig MISC = new MiscConfig();

	@Config.Name("crooks")
    @Config.Comment("Configure Crooks")
    public CrooksConfig CROOKS = new CrooksConfig();

	@Config.Name("hammer")
    @Config.Comment("Configure Hammer")
    public HammerConfig HAMMER = new HammerConfig();

	@Config.Name("mob_dolls")
    @Config.Comment("Configure Mob Dolls")
    public MobDollsConfig MOB_DOLLS = new MobDollsConfig();

	@Config.Name("crucible_recipes")
    @Config.Comment("Configure Crucible Recipes")
    public CrucibleRecipes CRUCIBLE_RECIPES = new CrucibleRecipes();

	@Config.Name("infusion_recipes")
    @Config.Comment("Configure Infusion Recipes")
    public InfusionRecipes INFUSION_RECIPES = new InfusionRecipes();

	@Config.Name("arcane_recipes")
    @Config.Comment("Configure Arcane Recipes")
    public ArcaneRecipesConfig ARCANE_RECIPES = new ArcaneRecipesConfig();
	
	@Config.Name("sieve_recipes")
    @Config.Comment("Configure Sieve Recipes")
    public SieveRecipesConfig SIEVE_RECIPES = new SieveRecipesConfig();

	@Config.Name("hammer_recipes")
    @Config.Comment("Configure Hammer Recipes")
    public HammerRecipesConfig HAMMER_RECIPES = new HammerRecipesConfig();

	@Config.Name("barrel_recipes")
    @Config.Comment("Configure Barrel Recipes")
    public BarrelRecipesConfig BARREL_RECIPES = new BarrelRecipesConfig();

	@Config.Name("heat_sources")
    @Config.Comment("Configure Heat Sources")
    public HeatSourcesConfig HEAT_SOURCES = new HeatSourcesConfig();
}