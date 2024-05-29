package net.thep2wking.exastris.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisFluids;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.modules.excompressum.ExAstrisExCompressumBlocks;
import net.thep2wking.exastris.modules.excompressum.ExAstrisExCompressumItems;
import net.thep2wking.exastris.modules.redstonearsenal.ExAstrisRedstoneArsenalItems;
import net.thep2wking.exastris.modules.thaumcraft.ExAstrisThaumcraftItems;
import net.thep2wking.exastris.util.handler.ExAstrisUtils;
import net.thep2wking.exastris.util.handler.IHasModel;
import net.thep2wking.exastris.util.world.WorldGenExAstris;

@Mod.EventBusSubscriber
public class ExAstrisRegistry {
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_BARREL_T0);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_BARREL_T1);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_BARREL_T2);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_SIEVE);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_HARD_STONE);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_FROSTY_DIRT);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_EX_COMPRESSUM)) {
            ExAstrisUtils.registerBlock(event, ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE);
        }

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_END_CAKE);

        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_PEACEWATER);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_FROSTWATER);
        ExAstrisUtils.registerBlock(event, ExAstrisBlocks.BLOCK_SLIME);

        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Registered blocks");
        }
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.BARREL_T0);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.BARREL_T1);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.BARREL_T2);

        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.SIEVE);

        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.WOOD_CRUCIBLE);

        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.HARD_STONE);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.DOUBLE_HARD_STONE);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.TRIPLE_HARD_STONE);
        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.QUADRUPLE_HARD_STONE);

        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.FROSTY_DIRT);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_EX_COMPRESSUM)) {
            ExAstrisUtils.registerItemBlock(event, ExAstrisExCompressumItems.AUTOMATIC_SIEVE);
        }

        ExAstrisUtils.registerItemBlock(event, ExAstrisItems.END_CAKE);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_REDSTONE_ARSENAL)) {
            ExAstrisUtils.registerItem(event, ExAstrisRedstoneArsenalItems.HAMMER_FLUX);
            ExAstrisUtils.registerItem(event, ExAstrisRedstoneArsenalItems.CROOK_FLUX);
        }

        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            ExAstrisUtils.registerItem(event, ExAstrisThaumcraftItems.HAMMER_THAUMIUM);
            ExAstrisUtils.registerItem(event, ExAstrisThaumcraftItems.CROOK_THAUMIUM);
            ExAstrisUtils.registerItem(event, ExAstrisThaumcraftItems.HAMMER_VOID);
            ExAstrisUtils.registerItem(event, ExAstrisThaumcraftItems.CROOK_VOID);
            ExAstrisUtils.registerItem(event, ExAstrisThaumcraftItems.HAMMER_ELEMENTAL);
            ExAstrisUtils.registerItem(event, ExAstrisThaumcraftItems.CROOK_ELEMENTAL);
        }

        ExAstrisUtils.registerItem(event, ExAstrisItems.PEBBLES);
        ExAstrisUtils.registerItem(event, ExAstrisItems.DOLLS);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            ExAstrisUtils.registerItemBlock(event, ExAstrisItems.ELDRITCH_ALTAR_SPAWNER);
        }

        ExAstrisUtils.registerItem(event, ExAstrisItems.SHARD_ICE);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            ExAstrisUtils.registerItem(event, ExAstrisItems.VIS_CRYSTAL_BASE);
            ExAstrisUtils.registerItem(event, ExAstrisItems.VIS_CRYSTAL_BALANCE);
        }

        ExAstrisUtils.registerItem(event, ExAstrisItems.SEEDS_PODZOL);
        ExAstrisUtils.registerItem(event, ExAstrisItems.SEEDS_FERN);
        ExAstrisUtils.registerItem(event, ExAstrisItems.SEEDS_CHORUS);

        ExAstrisUtils.registerItem(event, ExAstrisExCompressumItems.UPGRADE_SPEED);
        ExAstrisUtils.registerItem(event, ExAstrisExCompressumItems.UPGRADE_FORTUNE);
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Registered items");
        }
    }

    public static void preInitRegistries(FMLPreInitializationEvent event) {
        ExAstrisUtils.registerFluid(ExAstrisFluids.PEACEWATER);
        ExAstrisUtils.registerFluid(ExAstrisFluids.FROSTWATER);
        ExAstrisUtils.registerFluid(ExAstrisFluids.SLIME);

        if(Loader.isModLoaded("thauicaugmentation")) {
            GameRegistry.registerWorldGenerator(new WorldGenExAstris(), 0);
        }
        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Registered world generator");
        }

        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info("Registered fluids");
        }
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
    }
}