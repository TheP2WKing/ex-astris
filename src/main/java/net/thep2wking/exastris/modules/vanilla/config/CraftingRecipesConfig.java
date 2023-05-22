package net.thep2wking.exastris.modules.vanilla.config;

import net.minecraftforge.common.config.Config;

public class CraftingRecipesConfig {
    @Config.Name("Seeds to Soil Recipe")
    @Config.Comment("Whether to add recipes to craft soils like grass and podzol with dirt and seed directly")
    public boolean SEEDS_TO_SOIl = true;

    @Config.Name("Ice Blocks from Ice Shards Recipe")
    @Config.Comment("Whether to add recipes to craft ice and packaed ice from ice shards")
    public boolean ICE_BLOCKS_FROM_ICE_SHARDS = true;

    @Config.Name("Dead Bushes from Smelting")
    @Config.Comment("Whether to get dead bushes from smelting saplings and flowers")
    public boolean DEAD_BUSH_FROM_SMELTING = true;

    @Config.Name("Fake String Crook Recipe in JEI")
    @Config.Comment("Whether to add a crooking recipe for string just to show in JEI (however this adds additional chance of getting strings to function properly)")
    public boolean FAKE_STRING_CROOK_RECIPE_IN_JEI = true;

    @Config.Name("Hard Stone Recipes")
    @Config.Comment("Whether to add recipes to craft all variants of hard stone")
    public boolean HARD_STONE = true;
}