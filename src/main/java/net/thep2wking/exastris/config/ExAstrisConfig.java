package net.thep2wking.exastris.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.exastris.ExAstris;

@Config(modid = ExAstris.MODID, name = ExAstris.MODID, category = ExAstris.MODID)
public class ExAstrisConfig {
    @Config.Name("Generel")
    @Config.Comment("Configure Ex Astris")
    public static final Generel GENEREL = new Generel();

    public static class Generel {
        @Config.Name("Tooltips")
        @Config.Comment("Enable or Disable detailed tooltips if available")
        public boolean TOOLTIPS = true;

        @Config.Name("Logging")
        @Config.Comment("Enable or Disable Logging of this mod")
        public boolean LOGGING = true;
    }

    @Config.Name("Modules")
    @Config.Comment("Configure Modules")
    public static final Modules MODULES = new Modules();

    public static class Modules {
        @Config.Name("Chisel")
        @Config.Comment("Configure Chisel")
        public Chisel CHISEL = new Chisel();

        @Config.Name("ExAstris")
        @Config.Comment("Configure ExAstris")
        public BuildIn EXASTRIS = new BuildIn();

        @Config.Name("Disable all modules")
        @Config.Comment("Weather to disable all modules of this mod")
        public boolean MODULES_DISABLED = false;
    }

    public static class Chisel {
        @Config.Name("Marble Pebbles Sieving")
        @Config.Comment("Weather Marble Pebbles can be sieved")
        public boolean MARBLE_PEBBLE_SIEVING = true;

        @Config.Name("Limestone Pebbles Sieving")
        @Config.Comment("Weather Limestone Pebbles can be sieved")
        public boolean LIMESTONE_PEBBLE_SIEVING = true;

        @Config.Name("Basalt Fluid Item Transform")
        @Config.Comment("Weather Basalt can fluid item transformed")
        public boolean BASALT_FLUID_ITEM_TRANSFORM = true;
    }

    public static class BuildIn {
        @Config.Name("Stone Barrels")
        @Config.Comment("Weather are stone barrels enabled")
        public boolean STONE_BARRELS = true;
    }

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