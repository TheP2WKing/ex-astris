package net.thep2wking.exastris.integration.top;

import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.util.ExAstrisConstants;

public class MainCompatHandler {
    public static void registerTOP() {
        if (Loader.isModLoaded(ExAstrisConstants.MODID_TOP)) {
            TOPCompatibility.register();
        }
    }
}