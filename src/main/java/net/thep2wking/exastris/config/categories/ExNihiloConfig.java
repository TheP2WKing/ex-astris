package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.config.modules.exnihilo.OverridesConfig;

public class ExNihiloConfig {
    @Config.Name("overrides")
    @Config.Comment("Configure Overrides")
    public OverridesConfig OVERRIDES = new OverridesConfig();
}