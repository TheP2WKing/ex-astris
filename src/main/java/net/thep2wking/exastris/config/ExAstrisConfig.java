package net.thep2wking.exastris.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.modules.ModuleChiselConfig;
import net.thep2wking.exastris.config.modules.ModuleExAstrisConfig;
import net.thep2wking.exastris.config.modules.ModuleRedstoneArsenalConfig;

@Config(modid = ExAstris.MODID, name = ExAstris.MODID, category = ExAstris.MODID)
public class ExAstrisConfig {
    @Config.Name("generel")
    @Config.Comment("Configure Generel")
    public static final Generel GENEREL = new Generel();

    public static class Generel {
        @Config.Name("Logging")
        @Config.Comment("Enable or Disable Logging of this mod")
        public boolean LOGGING = true;
    }

    @Config.Name("exastris")
    @Config.Comment("Configure Ex Astris Modules")
    public static final ModuleExAstrisConfig MODULE_EX_ASTRIS = new ModuleExAstrisConfig();

    @Config.Name("chisel")
    @Config.Comment("Configure Ex Astris Modules")
    public static final ModuleChiselConfig MODULE_CHISEL = new ModuleChiselConfig();

    @Config.Name("redstonearsenal")
    @Config.Comment("Configure Redstone Arsenal Modules")
    public static final ModuleRedstoneArsenalConfig MODULE_REDSTONE_ARSENAL = new ModuleRedstoneArsenalConfig();

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