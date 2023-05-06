package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class ExAstrisFluidTransformRecipesConfig {
    @Config.Name("Water to Peacewater")
    @Config.Comment("Whether water should convert to peacewater")
    public boolean PEACEWATER = true;

    @Config.Name("Water to Frostwater")
    @Config.Comment("Whether water should convert to frostwater")
    public boolean FROSTWATER = true;
}