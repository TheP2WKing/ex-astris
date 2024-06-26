package net.thep2wking.exastris.util.handler;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;

@Mod.EventBusSubscriber
public class FluidRenderHandler {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void registerModel(ModelRegistryEvent event) {
        ExAstrisUtils.addRenderForFluid("peacewater", ExAstrisBlocks.BLOCK_PEACEWATER);
        ExAstrisUtils.addRenderForFluid("frostwater", ExAstrisBlocks.BLOCK_FROSTWATER);
        ExAstrisUtils.addRenderForFluid("slime", ExAstrisBlocks.BLOCK_SLIME);

        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Registered fluid models");
        }
    }
}