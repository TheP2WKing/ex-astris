package net.thep2wking.exastris.integration.jei.barrel;

import java.util.List;

import exnihilocreatio.ModItems;
import exnihilocreatio.util.Util;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;

public class FluidDollTransformRecipes extends FluidDollTransformCompat {
    public FluidDollTransformRecipes() {
        super(ExAstris.MODID);
    }

    @SuppressWarnings("null")
    public ItemStack addNBTItem(String entityId) {
        ItemStack spawnEgg = new ItemStack(Items.SPAWN_EGG);
        NBTTagCompound nbttagcompound = spawnEgg.hasTagCompound() ? spawnEgg.getTagCompound()
                : new NBTTagCompound();
        NBTTagCompound nbttagcompound1 = new NBTTagCompound();
        nbttagcompound1.setString("id", entityId.toString());
        nbttagcompound.setTag("EntityTag", nbttagcompound1);
        spawnEgg.setTagCompound(nbttagcompound);
        return spawnEgg;
    }

        public ItemStack addFluidItem(String fluid) {
            FluidStack inputFluid = new FluidStack(FluidRegistry.getFluid(fluid), 1000);
            ItemStack inputBucket = Util.getBucketStack(inputFluid.getFluid());
            return inputBucket;
        }

    @Override
    public void addRecipes(List<FluidDollTransformWrapper> list) {
        list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:blaze"),
            addFluidItem("lava"),
                new ItemStack(ModItems.dolls, 1, 0)));

        list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:enderman"),
                Util.getBucketStack(
                        new FluidStack(FluidRegistry.getFluid("witchwater"), Fluid.BUCKET_VOLUME).getFluid()),
                new ItemStack(ModItems.dolls, 1, 1)));

        list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:shulker"),
                Util.getBucketStack(
                        new FluidStack(FluidRegistry.getFluid("witchwater"), Fluid.BUCKET_VOLUME).getFluid()),
                new ItemStack(ModItems.dolls, 1, 2)));

        list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:guardian"),
                Util.getBucketStack(
                        new FluidStack(FluidRegistry.getFluid("water"), Fluid.BUCKET_VOLUME).getFluid()),
                new ItemStack(ModItems.dolls, 1, 3)));

        list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:villager"),
                Util.getBucketStack(
                        new FluidStack(FluidRegistry.getFluid("peacewater"), Fluid.BUCKET_VOLUME).getFluid()),
                new ItemStack(ExAstrisItems.DOLLS, 1, 0)));

        list.add(new FluidDollTransformWrapper(addNBTItem("minecraft:evocation_illager"),
                Util.getBucketStack(
                        new FluidStack(FluidRegistry.getFluid("witchwater"), Fluid.BUCKET_VOLUME).getFluid()),
                new ItemStack(ExAstrisItems.DOLLS, 1, 1)));

        if (Loader.isModLoaded("thermalfoundation")) {
            list.add(new FluidDollTransformWrapper(addNBTItem("thermalfoundation:blizz"),
                    Util.getBucketStack(
                            new FluidStack(FluidRegistry.getFluid("pyrotheum"), Fluid.BUCKET_VOLUME).getFluid()),
                    new ItemStack(ModItems.dolls, 1, 4)));
        }

        if (Loader.isModLoaded("thermalfoundation")) {
            list.add(new FluidDollTransformWrapper(addNBTItem("thermalfoundation:blitz"),
                    Util.getBucketStack(
                            new FluidStack(FluidRegistry.getFluid("pyrotheum"), Fluid.BUCKET_VOLUME).getFluid()),
                    new ItemStack(ModItems.dolls, 1, 5)));
        }

        if (Loader.isModLoaded("thermalfoundation")) {
            list.add(new FluidDollTransformWrapper(addNBTItem("thermalfoundation:basalz"),
                    Util.getBucketStack(
                            new FluidStack(FluidRegistry.getFluid("pyrotheum"), Fluid.BUCKET_VOLUME).getFluid()),
                    new ItemStack(ModItems.dolls, 1, 6)));
        }

        if (Loader.isModLoaded("tconstruct")) {
            list.add(new FluidDollTransformWrapper(addNBTItem("tconstruct:blueslime"),
                    Util.getBucketStack(
                            new FluidStack(FluidRegistry.getFluid("milk"), Fluid.BUCKET_VOLUME).getFluid()),
                    new ItemStack(ModItems.dolls, 1, 7)));
        }
    }
}