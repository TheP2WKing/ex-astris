package net.thep2wking.exastris.util.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.integration.top.MainCompatHandler;
import net.thep2wking.exastris.util.ExAstrisConstants;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id) {

    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

    }

    public void preInit(FMLPreInitializationEvent event) {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_TOP)) {
            MainCompatHandler.registerTOP();

            if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
                ExAstris.LOGGER.info("TOP Integration loaded");
            }
        }
    }

    public void Init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}