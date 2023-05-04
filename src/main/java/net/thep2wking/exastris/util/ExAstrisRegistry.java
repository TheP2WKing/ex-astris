package net.thep2wking.exastris.util;

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
import net.thep2wking.exastris.util.handler.ExAstrisUtils;
import net.thep2wking.exastris.util.handler.IHasModel;

@Mod.EventBusSubscriber
public class ExAstrisRegistry {
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_BARREL_T0);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_BARREL_T1);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_BARREL_T2);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_HARD_STONE);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_END_CAKE);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_PEACEWATER);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_SLIME);
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.BARREL_T0);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.BARREL_T1);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.BARREL_T2);

        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.HARD_STONE);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.DOUBLE_HARD_STONE);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.TRIPLE_HARD_STONE);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.QUADRUPLE_HARD_STONE);

        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.END_CAKE);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_REDSTONE_ARSENAL)) {
            ExAstrisUtils.registerItem(event, ExAstrisRAItems.HAMMER_FLUX);
            ExAstrisUtils.registerItem(event, ExAstrisRAItems.CROOK_FLUX);
        }

        ExAstrisUtils.registerItem(event, ExAstrisItems.PEBBLES);
        ExAstrisUtils.registerItem(event, ExAstrisItems.DOLLS);

        ExAstrisUtils.registerItem(event, ExAstrisItems.SHARD_ICE);

        ExAstrisUtils.registerItem(event, ExAstrisItems.SEEDS_PODZOL);
        ExAstrisUtils.registerItem(event, ExAstrisItems.SEEDS_FERN);
        ExAstrisUtils.registerItem(event, ExAstrisItems.SEEDS_CHORUS);
    }

    public static void preInitRegistries(FMLPreInitializationEvent event) {
        ExAstrisUtils.registerFluid(ExAstrisFluids.PEACEWATER);
        ExAstrisUtils.registerFluid(ExAstrisFluids.SLIME);
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

        if (Loader.isModLoaded("redstonearsenal")) {
            for (Item item : ExAstrisRAItems.ITEMS_RA) {
                if (item instanceof IHasModel) {
                    ((IHasModel) item).registerModels();
                }
            }
        }
    }
}