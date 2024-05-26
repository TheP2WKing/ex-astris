package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;

public class GenerelConfig {
	@Config.Name("Enable Logging")
	@Config.Comment("Whether Ex Astris should enable logging (for debug)")
	public boolean ENABLE_LOGGING = true;

	@Config.Name("Block Transformation Time")
	@Config.Comment("Set the time every block in world transformation should take in seconds")
	public int BLOCK_TRANSFORMATION_TIME = 100;

	@Config.Name("Diet Sieve Bounding Boxes")
	@Config.Comment("Whether Ex Astris Sives should use the smaller bounding boxes for sieves")
	public boolean DIET_SIEVE_BOUNDING_BOXES = true;
}