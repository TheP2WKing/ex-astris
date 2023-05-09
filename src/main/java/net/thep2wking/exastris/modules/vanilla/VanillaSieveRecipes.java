package net.thep2wking.exastris.modules.vanilla;

import exnihilocreatio.ModBlocks;
import exnihilocreatio.blocks.BlockSieve;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import exnihilocreatio.util.ItemInfo;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisItems;

@SuppressWarnings("null")
public class VanillaSieveRecipes {
	public static void register() {
		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.STRINGS_FROM_INFESTED_LEAVES) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register(
					new ItemInfo(Item.getItemFromBlock(ModBlocks.infestedLeaves), 0),
					new ItemInfo(Items.STRING, 0), 1f, BlockSieve.MeshType.STRING.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register(
					new ItemInfo(Item.getItemFromBlock(ModBlocks.infestedLeaves), 0),
					new ItemInfo(Items.STRING, 0), 0.75f, BlockSieve.MeshType.STRING.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.FERN_SEEDS_FROM_DIRT) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.SEEDS_FERN, 0), 0.05f, BlockSieve.MeshType.STRING.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.PODZOL_SEEDS_FROM_DIRT) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.SEEDS_PODZOL, 0), 0.05f, BlockSieve.MeshType.STRING.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.PRISMARINE_CRYSTALS_FROM_SAND) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("sand",
					new ItemInfo(Items.PRISMARINE_CRYSTALS, 0), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.VANILLA_DROPS_FROM_HIGHER_MESH_TIERS) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
					new ItemInfo(Items.DYE, 15), 0.03f, BlockSieve.MeshType.FLINT.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
					new ItemInfo(Items.GUNPOWDER, 0), 0.14f, BlockSieve.MeshType.FLINT.getID());

			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
					new ItemInfo(Items.GLOWSTONE_DUST, 0), 0.125f, BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dust",
					new ItemInfo(Items.BLAZE_POWDER, 0), 0.1f, BlockSieve.MeshType.DIAMOND.getID());

			ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
					new ItemInfo(Items.FLINT, 0), 0.5f, BlockSieve.MeshType.IRON.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
					new ItemInfo(Items.COAL, 0), 0.25f, BlockSieve.MeshType.IRON.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
					new ItemInfo(Items.DYE, 4), 0.1f, BlockSieve.MeshType.IRON.getID());

			ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
					new ItemInfo(Items.FLINT, 0), 0.75f, BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
					new ItemInfo(Items.COAL, 0), 0.5f, BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("gravel",
					new ItemInfo(Items.DYE, 4), 0.2f, BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENDER_PEARLS_FROM_CRUSHED_ENDSTONE) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register(
					new ItemInfo(Item.getItemFromBlock(ModBlocks.endstoneCrushed), 0),
					new ItemInfo(Items.ENDER_PEARL, 0), 0.04f, BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.CHORUS_FRUITS_FROM_CRUSHED_ENDSTONE) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register(
					new ItemInfo(Item.getItemFromBlock(ModBlocks.endstoneCrushed), 0),
					new ItemInfo(Items.CHORUS_FRUIT, 0), 0.02f, BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.CHORUS_SEEDS_FROM_CRUSHED_ENDSTONE) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register(
					new ItemInfo(Item.getItemFromBlock(ModBlocks.endstoneCrushed), 0),
					new ItemInfo(ExAstrisItems.SEEDS_CHORUS, 0), 0.01f,
					BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.NETHERRACK_PEBBLES_FROM_DIRT) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.5f, BlockSieve.MeshType.IRON.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.1f, BlockSieve.MeshType.IRON.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.75f, BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 0), 0.25f, BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENDSTONE_PEBBLES_FROM_DIRT) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.5f, BlockSieve.MeshType.IRON.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.1f, BlockSieve.MeshType.IRON.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.75f, BlockSieve.MeshType.DIAMOND.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("dirt",
					new ItemInfo(ExAstrisItems.PEBBLES, 1), 0.25f, BlockSieve.MeshType.DIAMOND.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ICE_SHARDS_FROM_SNOW) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemInfo(Item.getItemFromBlock(Blocks.SNOW)),
					new ItemInfo(ExAstrisItems.SHARD_ICE, 0), 1f, BlockSieve.MeshType.STRING.getID());
			ExNihiloRegistryManager.SIEVE_REGISTRY.register(new ItemInfo(Item.getItemFromBlock(Blocks.SNOW)),
					new ItemInfo(ExAstrisItems.SHARD_ICE, 0), 0.5f, BlockSieve.MeshType.STRING.getID());
		}

		if (ExAstrisConfig.MODULE_VANILLA.SIEVE_RECIPES.ENCHANTED_GOLDEN_APPLES_FROM_LEAVES) {
			ExNihiloRegistryManager.SIEVE_REGISTRY.register("treeLeaves",
					new ItemInfo(Items.GOLDEN_APPLE, 1), 0.001f, BlockSieve.MeshType.DIAMOND.getID());
		}
	}
}