package net.thep2wking.exastris.modules.chisel.config;

import net.minecraftforge.common.config.Config;

public class CarvingRecipesConfig {
    @Config.Name("Convert between Wood Barrels")
    @Config.Comment("Whether to let the chisel carve between all available barrel wood variants")
    public boolean CONVERT_BETWEEN_BARRELS = true;

    @Config.Name("Convert between Sieves")
    @Config.Comment("Whether to let the chisel carve between all available sieve wood variants")
    public boolean CONVERT_BETWEEN_SIEVES = true;

    @Config.Name("Convert between Wooden Crucibles")
    @Config.Comment("Whether to let the chisel carve between all available wooden crucible wood variants")
    public boolean CONVERT_BETWEEN_WOODEN_CRUCIBLES = true;
}