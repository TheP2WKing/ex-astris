package net.thep2wking.exastris;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.util.ExAstrisRecipeRegistry;
import net.thep2wking.exastris.util.ExAstrisRegistry;
import net.thep2wking.exastris.util.proxy.CommonProxy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExAstris.MODID, name = ExAstris.NAME, version = ExAstris.VERSION, dependencies = ExAstris.DEPENDENCIES)
public class ExAstris {
    public static final String MODID = "exastris";
    public static final String PREFIX = MODID + ":";
    public static final String MC_VERSION = "1.12.2";
    public static final String NAME = "Ex Astris";
    public static final String VERSION = MC_VERSION + "-" + "1.0.0";
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2847,);required-after:exnihilocreatio@[1.12.2-0.4.7,);after:chisel@[MC1.12.2-1.0.1,);after:redstonearsenal@[2.6.6,);after:thaumcraft@[6,);";
    public static final String CLIENT_PROXY_CLASS = "net.thep2wking.exastris.util.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.thep2wking.exastris.util.proxy.ServerProxy";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
    public static CommonProxy PROXY;

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            LOGGER.info("Starting FML Pre-Initialization");
        }

        PROXY.preInit(event);
        ExAstrisRegistry.preInitRegistries(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            LOGGER.info("Starting FML Initialization");
        }
        PROXY.Init(event);
        ExAstrisRecipeRegistry.registerVanillaRecipes();
        ExAstrisRecipeRegistry.registerExNihiloRecipes();
        ExAstrisRecipeRegistry.registerChiselRecipes();
        ExAstrisRecipeRegistry.registerRedstoneArsenalRecipes();
        ExAstrisRecipeRegistry.registerThaumcraftRecipes();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            LOGGER.info("Starting FML Post-Initialization");
        }
        PROXY.postInit(event);
    }

    @Mod.EventHandler
    public void loadComplete(FMLLoadCompleteEvent event) {
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            LOGGER.info(MODID + " " + VERSION + " " + "loaded!");
        }
    }
}