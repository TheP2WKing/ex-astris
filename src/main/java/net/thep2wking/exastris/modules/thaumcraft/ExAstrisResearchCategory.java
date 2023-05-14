package net.thep2wking.exastris.modules.thaumcraft;

import net.minecraft.util.ResourceLocation;
import net.thep2wking.exastris.ExAstris;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;

public class ExAstrisResearchCategory {
	public static ResearchCategory RES_CAT;

	public static void register() {
		RES_CAT = ResearchCategories.registerCategory("EXASTRIS", "FIRSTSTEPS",
				new AspectList().add(Aspect.PLANT, 10).add(Aspect.AIR, 10).add(Aspect.ORDER, 10).add(Aspect.WATER, 5)
						.add(Aspect.ENTROPY, 5),
				new ResourceLocation(ExAstris.MODID, "textures/items/hammer_thaumium.png"),
				new ResourceLocation(ExAstris.MODID, "textures/gui/thaumonomicon_background.jpg"),
				new ResourceLocation(ExAstris.MODID, "textures/gui/thaumonomicon_background_overlay.png"));

		ThaumcraftApi.registerResearchLocation(new ResourceLocation(ExAstris.MODID, "research/" + "exastris"));
	}
}