package net.thep2wking.exastris.integration.jei.blocktransformation;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;

public class BlockTransformationRecipes extends BlockTransformationCompat {
	public BlockTransformationRecipes() {
		super(ExAstris.MODID);
	}

	@Override
	public void addRecipes(List<BlockTransformationWrapper> list) {
		list.add(new BlockTransformationWrapper(new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK), 1, 0),
				new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE), 1, 0)));

		list.add(new BlockTransformationWrapper(new ItemStack(Item.getItemFromBlock(Blocks.SNOW), 1, 0),
				new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_FROSTY_DIRT), 1, 0)));
	}
}