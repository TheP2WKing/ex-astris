package net.thep2wking.exastris.integration.jei.categories;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;

public class TransformationRecipes extends TransformationCompat {
	public TransformationRecipes() {
		super(ExAstris.MODID);
	}

	@Override
	public void addRecipes(List<TransformationWrapper> list) {
		list.add(new TransformationWrapper(new ItemStack(Item.getItemFromBlock(Blocks.BEDROCK), 1, 0),
				new ItemStack(Item.getItemFromBlock(ExAstrisBlocks.BLOCK_QUADRUPLE_HARD_STONE), 1, 0)));
	}
}