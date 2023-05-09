package net.thep2wking.exastris.modules.vanilla;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.thep2wking.exastris.config.ExAstrisConfig;

@SuppressWarnings("null")
public class VanillaSmeltingRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_VANILLA.CRAFTING_RECIPES.DEAD_BUSH_FROM_SMELTING) {
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