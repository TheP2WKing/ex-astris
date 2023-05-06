package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class ExAstrisBarrelRecipesConfig {
    @Config.Name("Sponge from Liquid Slime")
    @Config.Comment("Whether to get spongees from liquid slime")
    public boolean SPONGE = true;

    @Config.Name("Witchwater from Stews")
    @Config.Comment("Whether to get witchwater from strews")
    public boolean WITCHWATER_FROM_STEWS = true;

    @Config.Name("Dark Oak Sapling from Oak Sapling")
    @Config.Comment("Whether to get dark oak saplings from oak saplings")
    public boolean DARK_OAK_SAPLINGS = true;

    @Config.Name("Tall Grass and Flowers from Witchwater")
    @Config.Comment("Whether to get tall grass and flowers from witchwater")
    public boolean TALL_GRASS_AND_FLOWERS = true;

    @Config.Name("Frosty Dirt from Frostwater")
    @Config.Comment("Whether to get frosty dirt from frostwater")
    public boolean FROSTY_DIRT = true;
}
