package net.thep2wking.exastris;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.util.ExAstrisConstants;
import net.thep2wking.exastris.util.ExAstrisRecipeRegistry;
import net.thep2wking.exastris.util.ExAstrisRegistry;
import net.thep2wking.exastris.util.handler.GuiHandler;
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
    public static final String DEPENDENCIES = "required-after:forge@[14.23.5.2847,);required-after:exnihilocreatio;after:chisel;after:redstonearsenal;after:thaumcraft;after:thaumicaugmentation;after:excompressum;after:enderio;after:thermalexpansion;after:bloodmagic";
    public static final String CLIENT_PROXY_CLASS = "net.thep2wking.exastris.util.proxy.ClientProxy";
    public static final String SERVER_PROXY_CLASS = "net.thep2wking.exastris.util.proxy.ServerProxy";
    public static final Logger LOGGER = LogManager.getLogger(NAME);

    @Instance
    public static ExAstris INSTANCE;

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
        if (Loader.isModLoaded(ExAstrisConstants.MODID_EX_COMPRESSUM)) {
            NetworkRegistry.INSTANCE.registerGuiHandler(ExAstris.INSTANCE, new GuiHandler());
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
        ExAstrisRecipeRegistry.registerChiselRecipes();
        ExAstrisRecipeRegistry.registerRedstoneArsenalRecipes();
        ExAstrisRecipeRegistry.registerThaumcraftRecipes();
        ExAstrisRecipeRegistry.registerExCompressumRecipes();
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