package net.thep2wking.exastris.modules.thaumcraft.config;

import net.minecraftforge.common.config.Config;

public class HeatSourcesConfig {
	@Config.Name("Cinderpearl")
    public boolean CINDERPEARL = true;

    @Config.Name("Cinderpearl Heat Value")
    public int CINDERPEARL_HEAT_VALUE = 1;

	@Config.Name("Amber Block")
    public boolean AMBER_BLOCK = true;

    @Config.Name("Amber Block Heat Value")
    public int AMBER_BLOCK_HEAT_VALUE = 3;

	@Config.Name("Arcane Lamp")
    public boolean ARCANE_LAMP = true;

    @Config.Name("Arcane Lamp Heat Value")
    public int ARCANE_LAMP_HEAT_VALUE = 4;

	@Config.Name("Nitor")
    public boolean NITOR = true;

    @Config.Name("Nitor Heat Value")
    public int NITOR_HEAT_VALUE = 6;

	@Config.Name("Tallow Candle")
    public boolean TALLOW_CANDLE = true;

    @Config.Name("Tallow Candle Heat Value")
    public int TALLOW_CANDLE_HEAT_VALUE = 2;
}