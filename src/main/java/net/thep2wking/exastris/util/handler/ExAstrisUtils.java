package net.thep2wking.exastris.util.handler;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.ExAstris;

public class ExAstrisUtils {
    public static void registerBlock(RegistryEvent.Register<Block> event, Block block) {
        event.getRegistry().register(block);
    }

    public static void registerItem(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
    }

    public static void registerItemBlock(RegistryEvent.Register<Item> event, Item itemBlock) {
        event.getRegistry().register(itemBlock);
    }

    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }

    public static void addRenderForFluid(String fluidName, Block block) {
        Item fluidItem = Item.getItemFromBlock(block);
        final ModelResourceLocation modelLocation = new ModelResourceLocation(ExAstris.PREFIX + fluidName,
                "fluid");

        ModelLoader.setCustomMeshDefinition(fluidItem, new ItemMeshDefinition() {
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                return modelLocation;
            }
        });

        ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
            protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
                return modelLocation;
            }
        });
    }

    public static int randomNumberRange(int minNumber, int maxNumber) {
        Random rand = new Random();
        int min = minNumber;
        int max = maxNumber;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}