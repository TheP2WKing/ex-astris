package net.thep2wking.exastris.config.modules.exnihilo;

import net.minecraftforge.common.config.Config;

public class OverridesConfig {
	@Config.Name("Replace Ex Nihilo Barrels")
    @Config.Comment("Whether to compleatly remove and replace Ex Nihilos barrels")
    public boolean REPLACE_EX_NIHILO_BARRELS = true;

    @Config.Name("Replace Ex Nihilo Sieves")
    @Config.Comment("Whether to compleatly remove and replace Ex Nihilos sieves")
    public boolean REPLACE_EX_NIHILO_SIEVES = true;

    @Config.Name("Remove Ex Nihilo Auto Sifter and Subcomponents")
    @Config.Comment("Whether to compleatly remove Ex Nihilos auto sifter and subcomponents")
    public boolean REMOVE_EX_NIHILO_AUTO_SIFTER = true;

	@Config.Name("Replace Ex Nihilo End Cake")
    @Config.Comment("Whether to replace and remove Ex Nihilos end cake")
    public boolean REPLACE_EX_NIHILO_END_CAKE = true;
}
