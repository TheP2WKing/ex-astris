package net.thep2wking.exastris.modules.vanilla.config;

import net.minecraftforge.common.config.Config;

public class FluidTransformRecipesConfig {
    @Config.Name("Peacewater from Water")
    @Config.Comment("Whether to get peacewater from water")
    public boolean PEACEWATER_FROM_WATER = true;

    @Config.Name("Peacewater spawns Flowers")
    @Config.Comment("Whether peacewater transformation should spawn flowers")
    public boolean PEACEWATER_SPAWNS_FLOWERS = true;
    
	@Config.Name("Peacewater Transform Time")
	@Config.Comment("Set the time for water to convert to peacewater in ticks")
	public int PEACEWATER_TRANSFORM_TIME = 12000;

    @Config.Name("Frostwater from Water")
    @Config.Comment("Whether to get frostwater from water")
    public boolean FROSTWATER_FROM_WATER = true;

    @Config.Name("Frostwater Transform Time")
	@Config.Comment("Set the time for water to convert to frostwater in ticks")
	public int FROSTWATER_TRANSFORM_TIME = 12000;
}