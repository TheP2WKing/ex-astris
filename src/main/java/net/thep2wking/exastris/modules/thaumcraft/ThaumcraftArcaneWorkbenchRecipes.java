package net.thep2wking.exastris.modules.thaumcraft;

import net.minecraft.util.ResourceLocation;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisThaumcraftItems;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.crafting.ShapedArcaneRecipe;

public class ThaumcraftArcaneWorkbenchRecipes {
	public static void register() {
		ThaumcraftApi.addArcaneCraftingRecipe(new ResourceLocation(ExAstris.MODID, "hammer_thaumium"),
				new ShapedArcaneRecipe(null, "HAMMER_THAUMIUM", 20,
						new AspectList().add(Aspect.MAGIC, 1).add(Aspect.EARTH, 1).add(Aspect.ENTROPY, 1),
						ExAstrisThaumcraftItems.HAMMER_THAUMIUM, " A ", " BA", "B  ", 'A', "ingotThaumium", 'B',
						"stickWood"));
	}
}