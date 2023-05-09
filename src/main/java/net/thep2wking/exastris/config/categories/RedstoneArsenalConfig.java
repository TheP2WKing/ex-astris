package net.thep2wking.exastris.config.categories;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.config.modules.redstonearsenal.CrooksConfig;
import net.thep2wking.exastris.config.modules.redstonearsenal.HammerConfig;

public class RedstoneArsenalConfig {
    @Config.Name("crooks")
    @Config.Comment("Configure Crooks")
    public CrooksConfig CROOKS = new CrooksConfig();

    @Config.Name("hammer")
    @Config.Comment("Configure Hammer")
    public HammerConfig HAMMER = new HammerConfig();
}