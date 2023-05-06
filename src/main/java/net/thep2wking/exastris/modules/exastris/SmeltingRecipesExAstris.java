package net.thep2wking.exastris.modules.exastris;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;

@SuppressWarnings("null")
public class SmeltingRecipesExAstris {
	public static void register() {
		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.REPLACE_EX_NIHILO_BARRELS) {
			GameRegistry.addSmelting(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 1),
					new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 0), 0.1f);
		}

		if (ExAstrisConfig.MODULE_EX_ASTRIS.MISC.DEAD_BUSH_FROM_SMELTING) {
			for (ItemStack inputSapling : OreDictionary.getOres("treeSapling")) {
				GameRegistry.addSmelting(inputSapling, new ItemStack(Item.getItemFromBlock(Blocks.DEADBUSH), 1, 0),
						0.1f);
			}
			for (ItemStack inputFlower : OreDictionary.getOres("flower")) {
				GameRegistry.addSmelting(inputFlower, new ItemStack(Item.getItemFromBlock(Blocks.DEADBUSH), 1, 0),
						0.1f);
			}
		}
	}
}