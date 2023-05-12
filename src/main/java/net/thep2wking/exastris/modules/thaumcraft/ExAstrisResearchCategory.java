package net.thep2wking.exastris.modules.thaumcraft;

import net.minecraft.util.ResourceLocation;
import net.thep2wking.exastris.ExAstris;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.api.research.ResearchEntry;

public class ExAstrisResearchCategory {

	public static ResearchCategory RES_CAT;
	public static ResearchEntry RES_ENTRY;

	// public static final Aspect SKy = Aspect.getAspect("sol") != null ?
	// Aspect.getAspect("sol") : new Aspect("sol", 0xFFB600, new Aspect[] {
	// Aspect.LIGHT, Aspect.LIFE }, new ResourceLocation(InfoSF.MOD_ID,
	// "textures/gui/aspect_sol.png"), 1);


	public static void init() {
		RES_CAT = ResearchCategories.registerCategory("EXASTRIS", null,
				new AspectList().add(Aspect.ALCHEMY, 10).add(Aspect.LIGHT, 2).add(Aspect.MAGIC, 10).add(Aspect.LIFE, 5)
						.add(Aspect.AVERSION, 5).add(Aspect.DESIRE, 5).add(Aspect.WATER, 5),
				new ResourceLocation(ExAstris.MODID, "textures/items/hammer_thaumium.png"),
				new ResourceLocation(ExAstris.MODID, "textures/gui/thaumonomicon_background.jpg"),
				new ResourceLocation(ExAstris.MODID, "textures/gui/thaumonomicon_background_overlay.png"));

				ThaumcraftApi.registerResearchLocation(new ResourceLocation(ExAstris.MODID, "research/" + "exastris"));
	}
}
