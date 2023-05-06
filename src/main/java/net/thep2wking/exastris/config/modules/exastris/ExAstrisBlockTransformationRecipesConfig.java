package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class ExAstrisBlockTransformationRecipesConfig {
    @Config.Name("Quadruple Hard Stone to Bedrock")
    @Config.Comment("Whether quadruple hard stone should convert to bedrock")
    public boolean BEDROCK = true;

    @Config.Name("Frosty Dirt to Snow")
    @Config.Comment("Whether frosty dirt should convert to snow")
    public boolean SNOW = true;
}