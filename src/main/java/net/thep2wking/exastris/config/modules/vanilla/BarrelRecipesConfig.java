package net.thep2wking.exastris.config.modules.vanilla;

import net.minecraftforge.common.config.Config;

public class BarrelRecipesConfig {
    @Config.Name("Sponge from Liquid Slime")
    @Config.Comment("Whether to get spongees from liquid slime")
    public boolean SPONGE_FROM_SLIME = true;

    @Config.Name("Witchwater from Stews")
    @Config.Comment("Whether to get witchwater from strews")
    public boolean WITCHWATER_FROM_STEWS = true;

    @Config.Name("Dark Oak Sapling from Oak Sapling")
    @Config.Comment("Whether to get dark oak saplings from oak saplings")
    public boolean DARK_OAK_SAPLING_FROM_OAK_SAPLING = true;

    @Config.Name("Tall Grass and Flowers from Witchwater")
    @Config.Comment("Whether to get tall grass and flowers from witchwater")
    public boolean TALL_GRASS_AND_FLOWERS_FROM_WITCHWATER = true;

    @Config.Name("Frosty Dirt from Frostwater")
    @Config.Comment("Whether to get frosty dirt from frostwater")
    public boolean FROSTY_DIRT_FROM_FROSTWATER = true;

    @Config.Name("Chorus Fruit Composting")
    @Config.Comment("Whether chorus fruits can be composted")
    public boolean CHORUS_FRUIT_COMPOSTING = true;

    @Config.Name("Cocoa Beans Composting")
    @Config.Comment("Whether cocoa beans can be composted")
    public boolean COCOA_BEANS_COMPOSTING = true;

    @Config.Name("Dead Bush Composting")
    @Config.Comment("Whether dead bushes can be composted")
    public boolean DEAD_BUSH_COMPOSTING = true;

    @Config.Name("Fern Composting")
    @Config.Comment("Whether fern can be composted")
    public boolean FERN_COMPOSTING = true;

    @Config.Name("Hay Bale Composting")
    @Config.Comment("Whether hay bales can be composted")
    public boolean HAY_BALES_COMPOSTING = true;
}