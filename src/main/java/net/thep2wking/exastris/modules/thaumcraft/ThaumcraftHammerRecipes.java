package net.thep2wking.exastris.modules.thaumcraft;

import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.init.Blocks;
import thaumcraft.api.ThaumcraftApiHelper;
import thaumcraft.api.aspects.Aspect;

public class ThaumcraftHammerRecipes {
	public static void register() {
		ExNihiloRegistryManager.HAMMER_REGISTRY.register("sandstone", ThaumcraftApiHelper.makeCrystal(Aspect.AIR),
				0, 1f, 1.1f);
		ExNihiloRegistryManager.HAMMER_REGISTRY.register("grass", ThaumcraftApiHelper.makeCrystal(Aspect.EARTH),
				0, 1f, 1.1f);
		ExNihiloRegistryManager.HAMMER_REGISTRY.register("netherBrick", ThaumcraftApiHelper.makeCrystal(Aspect.FIRE),
				0, 1f, 1.1f);
		ExNihiloRegistryManager.HAMMER_REGISTRY.register("blockIce", ThaumcraftApiHelper.makeCrystal(Aspect.WATER),
				0, 1f, 1.1f);
		ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.STONE, 0, ThaumcraftApiHelper.makeCrystal(Aspect.ORDER),
				0, 1f, 1.1f);
		ExNihiloRegistryManager.HAMMER_REGISTRY.register(Blocks.TNT, 0, ThaumcraftApiHelper.makeCrystal(Aspect.ENTROPY),
				0, 1f, 1.1f);
	}
}