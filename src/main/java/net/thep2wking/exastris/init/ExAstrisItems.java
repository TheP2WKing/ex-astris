package net.thep2wking.exastris.init;

import net.minecraft.block.BlockChorusFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.EnumPlantType;
import net.thep2wking.exastris.api.ExAstrisItemBase;
import net.thep2wking.exastris.api.ExAstrisItemBlockBase;
import net.thep2wking.exastris.api.ExAstrisItemSeedBase;
import net.thep2wking.exastris.content.block.barrel.ItemBlockExAstrisBarrelTier0;
import net.thep2wking.exastris.content.block.barrel.ItemBlockExAstrisBarrelTier1;
import net.thep2wking.exastris.content.block.barrel.ItemBlockExAstrisBarrelTier2;
import net.thep2wking.exastris.content.block.crucible.ItemBlockExAstrisWoodCrucuble;
import net.thep2wking.exastris.content.block.sieve.ItemBlockExAstrisSieve;
import net.thep2wking.exastris.content.item.doll.ItemExAstrisDoll;
import net.thep2wking.exastris.content.item.misc.ItemEldritchAltarSpawner;
import net.thep2wking.exastris.content.item.pebble.ItemExAstrisPebble;
import net.thep2wking.exastris.content.item.seed.ItemChorusSeed;
import net.thep2wking.exastris.content.item.seed.ItemPodzolSeed;
import net.thep2wking.exastris.util.handler.RarityHandler;

import java.util.ArrayList;
import java.util.List;

public class ExAstrisItems {
        public static final List<Item> ITEMS = new ArrayList<Item>();

        public static final ItemBlock BARREL_T0 = new ItemBlockExAstrisBarrelTier0(ExAstrisBlocks.BLOCK_BARREL_T0,
                        RarityHandler.WHITE, false);
        public static final ItemBlock BARREL_T1 = new ItemBlockExAstrisBarrelTier1(ExAstrisBlocks.BLOCK_BARREL_T1,
                        RarityHandler.WHITE, false);
        public static final ItemBlock BARREL_T2 = new ItemBlockExAstrisBarrelTier2(ExAstrisBlocks.BLOCK_BARREL_T2,
                        RarityHandler.WHITE, false);

        public static final ItemBlock SIEVE = new ItemBlockExAstrisSieve(ExAstrisBlocks.BLOCK_SIEVE,
                        RarityHandler.WHITE, false);

        public static final ItemBlock WOOD_CRUCIBLE = new ItemBlockExAstrisWoodCrucuble(
                        ExAstrisBlocks.BLOCK_WOOD_CRUCIBLE,
                        RarityHandler.WHITE, false);

        public static final ItemBlock HARD_STONE = new ExAstrisItemBlockBase(ExAstrisBlocks.BLOCK_HARD_STONE,
                        RarityHandler.WHITE, false);
        public static final ItemBlock DOUBLE_HARD_STONE = new ExAstrisItemBlockBase(
                        ExAstrisBlocks.BLOCK_DOUBLE_HARD_STONE,
                        RarityHandler.WHITE, false);
        public static final ItemBlock TRIPLE_HARD_STONE = new ExAstrisItemBlockBase(
                        ExAstrisBlocks.BLOCK_TRIPLE_HARD_STONE,
                        RarityHandler.WHITE, false);
        public static final ItemBlock QUADRUPLE_HARD_STONE = new ExAstrisItemBlockBase(
                        ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE,
                        RarityHandler.WHITE, false);

        public static final ItemBlock FROSTY_DIRT = new ExAstrisItemBlockBase(
                        ExAstrisBlocks.BLOCK_FROSTY_DIRT,
                        RarityHandler.WHITE, false);

        public static final ItemBlock END_CAKE = new ExAstrisItemBlockBase(
                        ExAstrisBlocks.BLOCK_END_CAKE,
                        RarityHandler.WHITE, false);

        public static final Item PEBBLES = new ItemExAstrisPebble("pebble", ExAstrisTabs.EXASTRIS_TAB,
                        RarityHandler.WHITE, false);
        public static final Item DOLLS = new ItemExAstrisDoll("doll", ExAstrisTabs.EXASTRIS_TAB,
                        RarityHandler.WHITE, false);

        public static final Item ELDRITCH_ALTAR_SPAWNER = new ItemEldritchAltarSpawner("eldritch_altar_spawner",
                        ExAstrisTabs.EXASTRIS_TAB, RarityHandler.YELLOW, false);

        public static final Item SHARD_ICE = new ExAstrisItemBase("shard_ice",
                        ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);

        public static final Item VIS_CRYSTAL_BALANCE = new ExAstrisItemBase("vis_crystal_balance",
                        ExAstrisTabs.EXASTRIS_TAB, RarityHandler.YELLOW, false);

        public static final Item SEEDS_PODZOL = new ItemPodzolSeed("seeds_podzol",
                        ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
        public static final Item SEEDS_FERN = new ExAstrisItemSeedBase("seeds_fern",
                        Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE,
                                        BlockTallGrass.EnumType.FERN),
                        EnumPlantType.Plains, ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
        public static final Item SEEDS_CHORUS = new ItemChorusSeed("seeds_chorus",
                        Blocks.CHORUS_FLOWER.getDefaultState().withProperty(BlockChorusFlower.AGE, 0),
                        ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
}