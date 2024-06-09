package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.modules.bloodmagic.config.AltarRecipes;
import net.thep2wking.exastris.modules.bloodmagic.config.BindingRecipes;

public class BloodMagicConfig {
	@Config.Name("altar_recipes")
    @Config.Comment("Configure Altar Recipes")
    public AltarRecipes ALTAR_RECIPES = new AltarRecipes();

	@Config.Name("binding_recipes")
    @Config.Comment("Configure Binding Recipes")
    public BindingRecipes BINDING_RECIPES = new BindingRecipes();
}