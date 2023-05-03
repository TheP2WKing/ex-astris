package net.thep2wking.exastris.util.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisFluids;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.init.ExAstrisRAItems;

@Mod.EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(ExAstrisBlocks.BLOCK_BARREL_T0);
        event.getRegistry().register(ExAstrisBlocks.BLOCK_BARREL_T1);
        event.getRegistry().register(ExAstrisBlocks.BLOCK_BARREL_T2);

        event.getRegistry().register(ExAstrisBlocks.BLOCK_HARD_STONE);
        event.getRegistry().register(ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE);
        event.getRegistry().register(ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE);
        event.getRegistry().register(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE);
    
        event.getRegistry().register(ExAstrisBlocks.BLOCK_END_CAKE);

        event.getRegistry().register(ExAstrisBlocks.BLOCK_PEACEWATER);
        event.getRegistry().register(ExAstrisBlocks.BLOCK_SLIME);
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(ExAstrisItems.BARREL_T0);
        event.getRegistry().register(ExAstrisItems.BARREL_T1);
        event.getRegistry().register(ExAstrisItems.BARREL_T2);

        event.getRegistry().register(ExAstrisItems.HARD_STONE);
        event.getRegistry().register(ExAstrisItems.DOUBLE_HARD_STONE);
        event.getRegistry().register(ExAstrisItems.TRIPLE_HARD_STONE);
        event.getRegistry().register(ExAstrisItems.QUADRUPLE_HARD_STONE);

        event.getRegistry().register(ExAstrisItems.END_CAKE);

        if(Loader.isModLoaded("redstonearsenal")) {
            event.getRegistry().register(ExAstrisRAItems.HAMMER_FLUX);
            event.getRegistry().register(ExAstrisRAItems.CROOK_FLUX);
        }

        if(Loader.isModLoaded("chisel")) {
            //event.getRegistry().register(ExAstrisItems.PEBBLE_MARBLE);
            //event.getRegistry().register(ExAstrisItems.PEBBLE_LIMESTONE);
        }

        event.getRegistry().register(ExAstrisItems.PEBBLES);
        event.getRegistry().register(ExAstrisItems.DOLLS);

        event.getRegistry().register(ExAstrisItems.SHARD_ICE);

        event.getRegistry().register(ExAstrisItems.SEEDS_PODZOL);
        event.getRegistry().register(ExAstrisItems.SEEDS_FERN);
        event.getRegistry().register(ExAstrisItems.SEEDS_CHORUS);
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Block block : ExAstrisBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }

        for (Item item : ExAstrisItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }
        if(Loader.isModLoaded("redstonearsenal")) {
            for (Item item : ExAstrisRAItems.ITEMS_RA) {
                if (item instanceof IHasModel) {
                    ((IHasModel) item).registerModels();
                }
            }
        }
    }

    public static void preInitRegistries(FMLPreInitializationEvent event) {
        ExAstrisFluids.registerFluids();
    }
}