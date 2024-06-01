package net.thep2wking.exastris.util.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thep2wking.exastris.modules.excompressum.content.hammerer.RenderAutomaticHammerer;
import net.thep2wking.exastris.modules.excompressum.content.hammerer.TileAutomaticHammerer;
import net.thep2wking.exastris.modules.excompressum.content.sieve.RenderAutomaticSieve;
import net.thep2wking.exastris.modules.excompressum.content.sieve.TileAutomaticSieve;
import net.thep2wking.exastris.util.ExAstrisConstants;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
    }

    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    public void Init(FMLInitializationEvent event) {
        super.Init(event);
        if (Loader.isModLoaded(ExAstrisConstants.MODID_EX_COMPRESSUM)) {
            ClientRegistry.bindTileEntitySpecialRenderer(TileAutomaticSieve.class, new RenderAutomaticSieve());
            ClientRegistry.bindTileEntitySpecialRenderer(TileAutomaticHammerer.class, new RenderAutomaticHammerer());
        }
    }

    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}