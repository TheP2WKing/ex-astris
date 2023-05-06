package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class ExAstrisMiscConfig {
    @Config.Name("Seeds to Soil Recipe")
    @Config.Comment("Whether to add recipes to craft soils like grass and podzol with dirt and seed directly")
    public boolean SEEDS_TO_SOIl = true;

    @Config.Name("Replace Ex Nihilo End Cake")
    @Config.Comment("Whether to replace and remove Ex Nihilos end cake")
    public boolean REPLACE_EX_NIHILO_END_CAKE = true;

    @Config.Name("Ice Blocks from Ice Shards Recipe")
    @Config.Comment("Whether to add recipes to craft ice and packaed ice from ice shards")
    public boolean ICE_BLOCKS_FROM_ICE_SHARDS = true;

    @Config.Name("Dead Bushes from Smelting")
    @Config.Comment("Whether to get dead bushes from smelting saplings and flowers")
    public boolean DEAD_BUSH_FROM_SMELTING = true;

    @Config.Name("String Crook Recipe in JEI")
    @Config.Comment("Whether to add an crooking recipe for string just to show recupe in JEI (however this adds additional chance of getting strings to function)")
    public boolean STRING_CROOK_RECIPE_IN_JEI = true;

    @Config.Name("Hard Stone Recipes")
    @Config.Comment("Whether to add recipes to craft all variants of hard stone")
    public boolean HARD_STONE = true;

    @Config.Name("Replace Ex Nihilo Barrels")
    @Config.Comment("Whether to compleatly remove and replace Ex Nihilos barrels")
    public boolean REPLACE_EX_NIHILO_BARRELS = true;

    @Config.Name("Replace Ex Nihilo Sieves")
    @Config.Comment("Whether to compleatly remove and replace Ex Nihilos sieves")
    public boolean REPLACE_EX_NIHILO_SIEVES = true;
}