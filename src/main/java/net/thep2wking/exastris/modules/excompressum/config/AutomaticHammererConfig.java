package net.thep2wking.exastris.modules.excompressum.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;

public class AutomaticHammererConfig {
	@Config.Name("Automatic Hammerer")
	@Config.Comment("Whether automatic hammerers are enabled")
	public boolean AUTOMATIC_HAMMERER = true;

	@Config.Name("Speed Upgrade")
	@Config.Comment("Whether speed upgrades are enabled")
	public boolean SPEED_UPGRADE = true;

	@Config.Name("Fortune Upgrade")
	@Config.Comment("Whether fortune upgrades are enabled")
	public boolean FORTUNE_UPGRADE = true;

	@Config.Name("Ex Compressum Compressed Hammer Recipes")
	@Config.Comment("Whether compressed hammer recipes can also be used in the automatic hammerer")
	public boolean EX_COMPRESSUM_COMPRESSED_HAMMER_RECIPES = false;

	@Config.Name("Save Inventory Contents")
	@Config.Comment("Whether the contents of the automatic hammerer should be saved when broken (only upgrades, hammers, and energy will be saved)")
	public boolean SAVE_INVENTORY_CONTENTS = true;

	@Config.Name("Energy Storage")
	@Config.Comment("Set the max energy storage for the automatic hammerer")
	@RangeInt(min = 0, max = 1000000)
	public int ENERGY_STORAGE = 64000;

	@Config.Name("Energy Usage per Tick")
	@RangeInt(min = 0, max = 1000000)
	@Config.Comment("Set the energy usage per tick for the automatic hammerer (0 equals no energy usage)")
	public int ENERGY_USAGE_PER_TICK = 80;

	@Config.Name("Default Hammering Speed")
	@RangeDouble(min = 0, max = 1)
	@Config.Comment("Set the default hammering speed for the automatic hammerer")
	public double DEFAULT_HAMMERING_SPEED = 0.01;

	@Config.Name("Speed Upgrade Modifier")
	@RangeDouble(min = 0, max = 1)
	@Config.Comment("Set the speed upgrade modifier for the automatic hammerer")
	public double SPEED_UPGRADE_MODIFIER = 0.06;

	@Config.Name("Speed Upgrade Energy Multiplier")
	@Config.Comment("Set the speed upgrade energy multiplier for the automatic hammerer (the energy usage will be multiplied by this value when a speed upgrade is installed)")
	@RangeDouble(min = 0, max = 1)
	public double SPEED_UPGRADE_ENERGY_MULTIPLIER = 0.1;

	@Config.Name("Fortune Upgrade Modifier")
	@RangeDouble(min = 0, max = 1)
	@Config.Comment("Set the fortune upgrade modifier for the automatic hammerer")
	public double FORTUNE_UPGRADE_MODIFIER = 0.1;

	@Config.Name("Fortune Upgrade Energy Multiplier")
	@Config.Comment("Set the fortune upgrade energy multiplier for the automatic hammerer (the energy usage will be multiplied by this value when a fortune upgrade is installed)")
	@RangeDouble(min = 0, max = 1)
	public double FORTUNE_UPGRADE_ENERGY_MULTIPLIER = 0.2;

	@Config.Name("Render Hammerer Contents")
	@Config.Comment("Whether the contents of the automatic hammerer should be rendered")
	public boolean RENDER_HAMMERER_CONTENTS = true;
}
