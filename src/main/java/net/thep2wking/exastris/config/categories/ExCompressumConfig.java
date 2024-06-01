package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.modules.excompressum.config.AutomaticHammererConfig;
import net.thep2wking.exastris.modules.excompressum.config.AutomaticSieveConfig;

public class ExCompressumConfig {
    @Config.Name("automatic_sieve")
    @Config.Comment("Configure Automatic Sieve")
    public AutomaticSieveConfig AUTOMATIC_SIEVE = new AutomaticSieveConfig();

    @Config.Name("automatic_hammerer")
    @Config.Comment("Configure Automatic Hammerer")
    public AutomaticHammererConfig AUTOMATIC_HAMMERER = new AutomaticHammererConfig();
}