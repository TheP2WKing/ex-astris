package net.thep2wking.exastris.util.handler;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.thep2wking.exastris.init.ExAstrisBlocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class FluidRenderHandler {
    @SubscribeEvent
    public static void registerModel(ModelRegistryEvent event) {
        ExAstrisUtils.addRenderForFluid("peacewater", ExAstrisBlocks.BLOCK_PEACEWATER);
        ExAstrisUtils.addRenderForFluid("slime", ExAstrisBlocks.BLOCK_SLIME);
    }
}