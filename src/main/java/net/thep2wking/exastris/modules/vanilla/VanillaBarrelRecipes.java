package net.thep2wking.exastris.modules.vanilla;

import exnihilocreatio.ModFluids;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.BlockInfo;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.init.ExAstrisFluids;

@SuppressWarnings("null")
public class VanillaBarrelRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.SPONGE_FROM_SLIME) {
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ExAstrisFluids.SLIME,
					"blockWool", new BlockInfo(Blocks.SPONGE, 0));
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.WITCHWATER_FROM_STEWS) {
			ExNihiloRegistryManager.FLUID_ITEM_FLUID_REGISTRY.register("water",
					new ItemInfo(Items.MUSHROOM_STEW, 0), "witchwater");
			ExNihiloRegistryManager.FLUID_ITEM_FLUID_REGISTRY.register("water", new ItemInfo(Items.RABBIT_STEW, 0),
					"witchwater");
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.DARK_OAK_SAPLING_FROM_OAK_SAPLING) {
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
					new ItemInfo(Item.getItemFromBlock(Blocks.SAPLING), 0),
					new ItemInfo(Item.getItemFromBlock(Blocks.SAPLING), 5));
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.TALL_GRASS_AND_FLOWERS_FROM_WITCHWATER) {
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
					new ItemInfo(Item.getItemFromBlock(Blocks.TALLGRASS), 1),
					new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 2));
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
					new ItemInfo(Item.getItemFromBlock(Blocks.TALLGRASS), 2),
					new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 3));
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
					new ItemInfo(Item.getItemFromBlock(Blocks.YELLOW_FLOWER), 0),
					new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 0));
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
					new ItemInfo(Item.getItemFromBlock(Blocks.RED_FLOWER), 2),
					new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 1));
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
					new ItemInfo(Item.getItemFromBlock(Blocks.RED_FLOWER), 0),
					new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 4));
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ModFluids.fluidWitchwater,
					new ItemInfo(Item.getItemFromBlock(Blocks.RED_FLOWER), 3),
					new ItemInfo(Item.getItemFromBlock(Blocks.DOUBLE_PLANT), 5));
		}

		if (ExAstrisConfig.MODULE_VANILLA.BARREL_RECIPES.FROSTY_DIRT_FROM_FROSTWATER) {
			ExNihiloRegistryManager.FLUID_BLOCK_TRANSFORMER_REGISTRY.register(ExAstrisFluids.FROSTWATER, "dirt",
					new BlockInfo(ExAstrisBlocks.BLOCK_FROSTY_DIRT));
		}
	}
}