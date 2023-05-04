package net.thep2wking.exastris.integration.jei.blocktransformation;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public abstract class BlockTransformationCompat implements Comparable<BlockTransformationCompat> {
	public String modid;

	public BlockTransformationCompat(String modid) {
		this.modid = modid;
	}

	public String getModID() {
		return modid;
	}

	public abstract void addRecipes(List<BlockTransformationWrapper> list);

	public final boolean shouldLoad() {
		return Loader.isModLoaded(modid);
	}

	@Override
	public int compareTo(BlockTransformationCompat compat) {
		return modid.compareTo(compat.modid);
	}

	public static ItemStack getModdedItem(String name) {
		return getModdedItem(name, 1, 0);
	}

	public static ItemStack getModdedItem(String name, int count) {
		return getModdedItem(name, count, 0);
	}

	public static ItemStack getModdedItem(String name, int count, int meta) {
		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(name));
		if (item == null)
			return ItemStack.EMPTY;
		else
			return new ItemStack(item, count, meta);
	}
}