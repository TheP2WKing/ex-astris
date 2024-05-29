package net.thep2wking.exastris.modules.excompressum;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.thep2wking.exastris.init.ExAstrisTabs;
import net.thep2wking.exastris.modules.excompressum.content.sieve.BlockAutomaticSieve;
import net.thep2wking.exastris.util.handler.EnumToolType;

public class ExAstrisExCompressumBlocks {
	public static final Block AUTOMATIC_SIEVE = new BlockAutomaticSieve("automatic_sieve", ExAstrisTabs.EXASTRIS_TAB, Material.IRON, SoundType.METAL, 0, EnumToolType.PICKAXE, 5.0F, 5.0F, 0.0F);
}
