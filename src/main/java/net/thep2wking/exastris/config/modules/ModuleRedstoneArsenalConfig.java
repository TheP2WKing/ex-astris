package net.thep2wking.exastris.config.modules;

import net.minecraftforge.common.config.Config;
import net.thep2wking.exastris.config.modules.redstonearsenal.RedstoneArsenalTools;

public class ModuleRedstoneArsenalConfig {
    @Config.Name("tools")
    @Config.Comment("Configure Tools")
    public RedstoneArsenalTools TOOLS = new RedstoneArsenalTools();
}
