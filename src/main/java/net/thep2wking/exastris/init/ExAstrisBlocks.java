package net.thep2wking.exastris.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.thep2wking.exastris.api.ExAstrisBlockBase;
import net.thep2wking.exastris.api.ExAstrisFluidBlockBase;
import net.thep2wking.exastris.content.block.barrel.BlockExAstrisBarrelTier0;
import net.thep2wking.exastris.content.block.barrel.BlockExAstrisBarrelTier1;
import net.thep2wking.exastris.content.block.barrel.BlockExAstrisBarrelTier2;
import net.thep2wking.exastris.content.block.cake.BlockEndCake;
import net.thep2wking.exastris.content.block.fluid.BlockPeacewater;
import net.thep2wking.exastris.content.block.sieve.BlockExAstrisSieve;
import net.thep2wking.exastris.content.block.transformation.BlockFrostyDirt;
import net.thep2wking.exastris.content.block.transformation.BlockQuadrupleHardStone;
import net.thep2wking.exastris.util.handler.EnumToolType;

public class ExAstrisBlocks {
        public static final List<Block> BLOCKS = new ArrayList<Block>();

        public static final Block BLOCK_BARREL_T0 = new BlockExAstrisBarrelTier0("barrel",
                        ExAstrisTabs.EXASTRIS_TAB,
                        Material.WOOD, SoundType.WOOD, 0, EnumToolType.AXE, 2f, 3f, 0);
        public static final Block BLOCK_BARREL_T1 = new BlockExAstrisBarrelTier1("barrel",
                        ExAstrisTabs.EXASTRIS_TAB,
                        Material.ROCK, SoundType.STONE, 0, EnumToolType.PICKAXE, 1.5f, 6f, 0);
        public static final Block BLOCK_BARREL_T2 = new BlockExAstrisBarrelTier2("barrel",
                        ExAstrisTabs.EXASTRIS_TAB,
                        Material.IRON, SoundType.METAL, 1, EnumToolType.PICKAXE, 5f, 6f, 0);

        public static final Block BLOCK_SIEVE = new BlockExAstrisSieve("sieve",
                        ExAstrisTabs.EXASTRIS_TAB,
                        Material.WOOD, SoundType.WOOD, 0, EnumToolType.AXE, 2f, 3f, 0);

        public static final Block BLOCK_HARD_STONE = new ExAstrisBlockBase("hard_stone", ExAstrisTabs.EXASTRIS_TAB,
                        Material.ROCK, SoundType.STONE, 3, EnumToolType.PICKAXE, 50f, 6000f, 0);
        public static final Block BLOCK_DOUBLE_HARD_STONE = new ExAstrisBlockBase("double_hard_stone",
                        ExAstrisTabs.EXASTRIS_TAB,
                        Material.ROCK, SoundType.STONE, 3, EnumToolType.PICKAXE, 100f, 6000f, 0);
        public static final Block BLOCK_TRIPLE_HARD_STONE = new ExAstrisBlockBase("triple_hard_stone",
                        ExAstrisTabs.EXASTRIS_TAB,
                        Material.ROCK, SoundType.STONE, 3, EnumToolType.PICKAXE, 150f, 6000f, 0);
        public static final Block BLOCK_QUADRUPLE_HARD_STONE = new BlockQuadrupleHardStone("quadruple_hard_stone",
                        ExAstrisTabs.EXASTRIS_TAB, Material.ROCK, SoundType.STONE, 3, EnumToolType.PICKAXE, 200f, 6000f,
                        0);

        public static final Block BLOCK_FROSTY_DIRT = new BlockFrostyDirt("frosty_dirt",
                        ExAstrisTabs.EXASTRIS_TAB, Material.GROUND, SoundType.GROUND, 0, EnumToolType.SHOVEL, 1.5f, 1f,
                        0);

        public static final Block BLOCK_END_CAKE = new BlockEndCake("end_cake",
                        ExAstrisTabs.EXASTRIS_TAB,
                        Material.CAKE, SoundType.CLOTH, 0.5f, 0.5f, 0);

        public static final BlockFluidClassic BLOCK_PEACEWATER = new BlockPeacewater("peacewater",
                        ExAstrisFluids.PEACEWATER, Material.WATER);
        public static final BlockFluidClassic BLOCK_FROSTWATER = new ExAstrisFluidBlockBase("frostwater",
                        ExAstrisFluids.FROSTWATER, Material.WATER);
        public static final BlockFluidClassic BLOCK_SLIME = new ExAstrisFluidBlockBase("slime", ExAstrisFluids.SLIME,
                        Material.WATER);
}