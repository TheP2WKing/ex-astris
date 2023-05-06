package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class HammerRecipesConfig {
    @Config.Name("Stone Pebbles from Stone")
    @Config.Comment("Whether to get stone pebbles from hammering stone")
    public boolean STONE_PEBBLES_FROM_STONE = true;

    @Config.Name("Prismarine Crystals from Prismarine")
    @Config.Comment("Whether to get prismarine crystals from hammering prismarine")
    public boolean PRISMARINE_CRYSTALS_FROM_PRISMARINE = true;

    @Config.Name("Sand from Sandstone")
    @Config.Comment("Whether to get sand from hammering sandstone")
    public boolean SAND_FROM_SANDSTONE = true;

    @Config.Name("Cracked Stone Bricks from Stone Bricks")
    @Config.Comment("Whether to get cracked stone bricks from hammering stone sticks")
    public boolean CRACKED_STONE_BRICKS_FROM_STONE_BRICKS = true;

    @Config.Name("Ice Shards from Ice")
    @Config.Comment("Whether to get ice shards from hammering ice")
    public boolean ICE_SHARDS_FROM_ICE = true;
}
