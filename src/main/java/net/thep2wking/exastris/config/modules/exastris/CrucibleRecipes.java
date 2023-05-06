package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class CrucibleRecipes {
    @Config.Name("Liquid Slime from Slime Block")
    @Config.Comment("Whether to get slime from melting slime blocks")
    public boolean SLIME_FROM_SLIME_BLOCK = true;

    @Config.Name("Water from Ice")
    @Config.Comment("Whether to get water from melting ice")
    public boolean WATER_FROM_ICE = true;

    @Config.Name("Lava from Stone Bricks")
    @Config.Comment("Whether to get lava from melting stone bricks")
    public boolean LAVA_FROM_STONE_BRICKS = true;

    @Config.Name("Lava from Hard Stone")
    @Config.Comment("Whether to get lava from melting hard stone")
    public boolean LAVA_FROM_HRAD_STONE = true;
}