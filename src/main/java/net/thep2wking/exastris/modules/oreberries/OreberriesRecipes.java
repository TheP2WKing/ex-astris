package net.thep2wking.exastris.modules.oreberries;

import java.util.ArrayList;
import java.util.List;

import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import josephcsible.oreberries.BlockOreberryBush;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.thep2wking.exastris.api.recipe.ExAstrisRecipeHelper;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.util.ExAstrisConstants;

public class OreberriesRecipes {
	public static void registerSivetingRecipes() {
		if (ExAstrisConfig.MODULE_OREBERRIES.SIEVE_RECIPES.ESSENSE_BERRY_BUSH_FROM_STONE) {
			ExAstrisRecipeHelper.addSivetingRecipe(
					new ItemInfo(Item.getByNameOrId(ExAstrisConstants.MODID_OREBERRIES + ":" + "essence_oreberry_bush"),
							0),
					0.01f, "stone", 4);
		}

		if (ExAstrisConfig.MODULE_OREBERRIES.SIEVE_RECIPES.METAL_BERRY_BUSH_FROM_STONE) {
			for (BlockOreberryBush oreberry : getRegisteredOreberries()) {
				if (!oreberry.getRegistryName().getResourcePath().equals("essence_oreberry_bush")) {
					ExAstrisRecipeHelper.addSivetingRecipe(new ItemInfo(Item.getByNameOrId(
							ExAstrisConstants.MODID_OREBERRIES + ":" + oreberry.getRegistryName().getResourcePath()),
							0), 0.01f, "stone", 4);
				}
			}
		}
	}

	public static void registerBarrelRecipes() {
		if (ExAstrisConfig.MODULE_OREBERRIES.BARREL_RECIPES.BERRY_BUSG_COMPOSTING) {
			for (BlockOreberryBush oreberry : getRegisteredOreberries()) {
				ExAstrisRecipeHelper.addCompostingRecipe(new BlockInfo(Blocks.DIRT), new ItemInfo(Item.getByNameOrId(
						ExAstrisConstants.MODID_OREBERRIES + ":" + oreberry.getRegistryName().getResourcePath()), 0),
						0.5f, "636160");
			}
		}
	}

	public static List<BlockOreberryBush> getRegisteredOreberries() {
		List<BlockOreberryBush> oreberries = new ArrayList<>();
		for (Block block : ForgeRegistries.BLOCKS) {
			if (block instanceof BlockOreberryBush) {
				oreberries.add((BlockOreberryBush) block);
			}
		}
		return oreberries;
	}
}