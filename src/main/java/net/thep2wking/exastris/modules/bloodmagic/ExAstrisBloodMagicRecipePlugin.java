package net.thep2wking.exastris.modules.bloodmagic;

import WayofTime.bloodmagic.api.BloodMagicPlugin;
import WayofTime.bloodmagic.api.IBloodMagicPlugin;
import WayofTime.bloodmagic.api.IBloodMagicRecipeRegistrar;

@BloodMagicPlugin
public class ExAstrisBloodMagicRecipePlugin implements IBloodMagicPlugin {
	@Override
	public void registerRecipes(IBloodMagicRecipeRegistrar recipeRegistrar) {
		BloodMagicRecipes.registerAltarRecipes(recipeRegistrar);
	}
}