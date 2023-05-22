package net.thep2wking.exastris.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.categories.ChiselConfig;
import net.thep2wking.exastris.config.categories.GenerelConfig;
import net.thep2wking.exastris.config.categories.JEIConfig;
import net.thep2wking.exastris.config.categories.RedstoneArsenalConfig;
import net.thep2wking.exastris.config.categories.ThaumcraftConfig;
import net.thep2wking.exastris.config.categories.VanillaConfig;

@Config(modid = ExAstris.MODID, name = ExAstris.MODID, category = ExAstris.MODID)
public class ExAstrisConfig {
    @Config.Name("generel")
    @Config.Comment("Configure Generel")
    public static final GenerelConfig GENEREL = new GenerelConfig();

    @Config.Name("jei")
    @Config.Comment("Configure JEI integration")
    public static final JEIConfig INTEGRATION_JEI = new JEIConfig();

    @Config.Name("vanilla")
    @Config.Comment("Configure Vanilla Module")
    public static final VanillaConfig MODULE_VANILLA= new VanillaConfig();

    @Config.Name("chisel")
    @Config.Comment("Configure Ex Astris Module")
    public static final ChiselConfig MODULE_CHISEL = new ChiselConfig();

    @Config.Name("redstonearsenal")
    @Config.Comment("Configure Redstone Arsenal Module")
    public static final RedstoneArsenalConfig MODULE_REDSTONE_ARSENAL = new RedstoneArsenalConfig();

    @Config.Name("thaumcraft")
    @Config.Comment("Configure Thaumcraft Module")
    public static final ThaumcraftConfig MODULE_THAUMCRAFT = new ThaumcraftConfig();

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