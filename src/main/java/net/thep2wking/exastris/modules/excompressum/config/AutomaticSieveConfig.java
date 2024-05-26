package net.thep2wking.exastris.modules.excompressum.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;

public class AutomaticSieveConfig {
	@Config.Name("Automatic Sieve")
	@Config.Comment("Whether automatic sieves are enabled")
	public boolean AUTOMATIC_SIEVE = true;

	@Config.Name("Speed Upgrade")
	@Config.Comment("Whether speed upgrades are enabled")
	public boolean SPEED_UPGRADE = true;

	@Config.Name("Fortune Upgrade")
	@Config.Comment("Whether fortune upgrades are enabled")
	public boolean FORTUNE_UPGRADE = true;

	@Config.Name("Energy Storage")
	@Config.Comment("Set the max energy storage for the automatic sieve")
	@RangeInt(min = 0, max = 1000000)
    public int ENERGY_STORAGE = 64000;

	@Config.Name("Energy Usage per Tick")
	@RangeInt(min = 0, max = 1000000)
	@Config.Comment("Set the energy usage per tick for the automatic sieve (0 equals no energy usage)")
    public int ENERGY_USAGE_PER_TICK = 80;

	@Config.Name("Default Sifting Speed")
	@RangeDouble(min = 0, max = 1)
	@Config.Comment("Set the default sifting speed for the automatic sieve")
    public double DEFAULT_SIFTEING_SPEED = 0.01;

	@Config.Name("Speed Upgrade Modifier")
	@RangeDouble(min = 0, max = 1)
	@Config.Comment("Set the speed upgrade modifier for the automatic sieve")
	public double SPEED_UPGRADE_MODIFIER = 0.05;

	@Config.Name("Speed Upgrade Energy Multiplier")
	@Config.Comment("Set the speed upgrade energy multiplier for the automatic sieve (the energy usage will be multiplied by this value when a speed upgrade is installed)")
	@RangeDouble(min = 0, max = 1)
	public double SPEED_UPGRADE_ENERGY_MULTIPLIER = 0.15;

	@Config.Name("Fortune Upgrade Modifier")
	@RangeDouble(min = 0, max = 1)
	@Config.Comment("Set the fortune upgrade modifier for the automatic sieve")
	public double FORTUNE_UPGRADE_MODIFIER = 0.1;

	@Config.Name("Fortune Upgrade Energy Multiplier")
	@Config.Comment("Set the fortune upgrade energy multiplier for the automatic sieve (the energy usage will be multiplied by this value when a fortune upgrade is installed)")
	@RangeDouble(min = 0, max = 1)
	public double FORTUNE_UPGRADE_ENERGY_MULTIPLIER = 0.25;
}