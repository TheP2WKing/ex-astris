package net.thep2wking.exastris.integration.jei.fluiddolltransform;

import java.util.List;

import exnihilocreatio.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.ExAstrisUtils;

public class FluidDollTransformRecipes extends FluidDollTransformCompat {
	public FluidDollTransformRecipes() {
		super(ExAstris.MODID);
	}

	@SuppressWarnings("null")
	public ItemStack addNBTItem(String entityId) {
		ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
		NBTTagCompound nbttagcompound = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound() : new NBTTagCompound();
		NBTTagCompound nbttagcompound1 = new NBTTagCompound();
		nbttagcompound1.setString("id", entityId.toString());
		nbttagcompound.setTag("EntityTag", nbttagcompound1);
		spawnEgg.setTagCompound(nbttagcompound);
		return spawnEgg;
	}

	@Override
	public void addRecipes(List<FluidDollTransformWrapper> list) {
		list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:blaze"), ExAstrisUtils.addFluidItem("lava"),
				new ItemStack(ModItems.dolls, 1, 0)));

		list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:enderman"),
				ExAstrisUtils.addFluidItem("witchwater"), new ItemStack(ModItems.dolls, 1, 1)));

		list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:shulker"),
				ExAstrisUtils.addFluidItem("witchwater"), new ItemStack(ModItems.dolls, 1, 2)));

		list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:guardian"), ExAstrisUtils.addFluidItem("water"),
				new ItemStack(ModItems.dolls, 1, 3)));

		list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:villager"),
				ExAstrisUtils.addFluidItem("peacewater"),
				new ItemStack(ExAstrisItems.DOLLS, 1, 0)));

		list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:evocation_illager"),
				ExAstrisUtils.addFluidItem("witchwater"),
				new ItemStack(ExAstrisItems.DOLLS, 1, 1)));

		if (Loader.isModLoaded("thermalfoundation")) {
			list.add(new FluidDollTransformWrapper(addNBTItem("thermalfoundation:blizz"),
					ExAstrisUtils.addFluidItem("pyrotheum"),
					new ItemStack(ModItems.dolls, 1, 4)));
		}

		if (Loader.isModLoaded("thermalfoundation")) {
			list.add(new FluidDollTransformWrapper(addNBTItem("thermalfoundation:blitz"),
					ExAstrisUtils.addFluidItem("pyrotheum"),
					new ItemStack(ModItems.dolls, 1, 5)));
		}

		if (Loader.isModLoaded("thermalfoundation")) {
			list.add(new FluidDollTransformWrapper(addNBTItem("thermalfoundation:basalz"),
					ExAstrisUtils.addFluidItem("pyrotheum"),
					new ItemStack(ModItems.dolls, 1, 6)));
		}

		if (Loader.isModLoaded("tconstruct")) {
			list.add(new FluidDollTransformWrapper(addNBTItem("tconstruct:blueslime"),
					ExAstrisUtils.addFluidItem("milk"),
					new ItemStack(ModItems.dolls, 1, 7)));
		}
	}
}