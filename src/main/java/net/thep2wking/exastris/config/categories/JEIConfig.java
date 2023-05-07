package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;

public class JEIConfig {
	@Config.Name("Block Transformation Recipe Category")
    @Config.Comment("Whether to show block transformation recipes in JEI")
    public boolean TRANSFORMATION_RECIPE_CATEGORY = true;

	@Config.Name("Doll Mob Spawning Recipe Category")
    @Config.Comment("Whether to show doll mob spawning recipes in JEI")
    public boolean DOLL_RECIPE_CATEGORY = true;

	@Config.Name("Hide Unused")
    @Config.Comment("Whether to hide unused stuff from JEI")
    public boolean HIDE_UNUSED = true;
}
