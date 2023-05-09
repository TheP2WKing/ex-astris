package net.thep2wking.exastris.config.modules.vanilla;

import net.minecraftforge.common.config.Config;

public class BlockTransformationRecipesConfig {
    @Config.Name("Quadruple Hard Stone to Bedrock")
    @Config.Comment("Whether quadruple hard stone should convert to bedrock")
    public boolean BEDROCK_FROM_QUADRUPLE_HARD_STONE = true;

    @Config.Name("Frosty Dirt to Snow")
    @Config.Comment("Whether frosty dirt should convert to snow")
    public boolean SNOW_FROM_FROSTY_DIRT = true;
}