package net.thep2wking.exastris.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.modules.ChiselModuleConfig;
import net.thep2wking.exastris.config.modules.ExAstrisModuleConfig;
import net.thep2wking.exastris.config.modules.RedstoneArsenalModuleConfig;

@Config(modid = ExAstris.MODID, name = ExAstris.MODID, category = ExAstris.MODID)
public class ExAstrisConfig {
    @Config.Name("generel")
    @Config.Comment("Configure Generel")
    public static final GenerelConfig GENEREL = new GenerelConfig();

    @Config.Name("modules")
    @Config.Comment("Configure Modules")
    public static final ModulesConfig MODULES = new ModulesConfig();

    @Config.Name("exastris")
    @Config.Comment("Configure Ex Astris Module")
    public static final ExAstrisModuleConfig MODULE_EX_ASTRIS = new ExAstrisModuleConfig();

    @Config.Name("chisel")
    @Config.Comment("Configure Ex Astris Module")
    public static final ChiselModuleConfig MODULE_CHISEL = new ChiselModuleConfig();

    @Config.Name("redstonearsenal")
    @Config.Comment("Configure Redstone Arsenal Module")
    public static final RedstoneArsenalModuleConfig MODULE_REDSTONE_ARSENAL = new RedstoneArsenalModuleConfig();

    @Mod.EventBusSubscriber
    public static class ConfigHolder {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(ExAstris.MODID)) {
                ConfigManager.sync(ExAstris.MODID, Config.Type.INSTANCE);
            }
        }
    }
}