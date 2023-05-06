package net.thep2wking.exastris.config;

import net.minecraftforge.common.config.Config;

public class ModulesConfig {
    @Config.Name("Chisel Integration Enabled")
    @Config.Comment("Whether to enable the chisel integration")
    public boolean CHISEL_INTEGRATION = true;

    @Config.Name("Vanilla/ Ex Nihilo Integration Enabled")
    @Config.Comment("Whether to enable the vanilla and Ex Nihilo integration")
    public boolean DEFAULT_INTEGRATION = true;

    @Config.Name("Redstone Arsenal Integration Enabled")
    @Config.Comment("Whether to enable the redstone arsenal integration")
    public boolean REDSTONE_ARSENAL_INTEGRATION = true;
}