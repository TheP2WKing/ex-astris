package net.thep2wking.exastris.util.handler;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;

@Mod.EventBusSubscriber(Side.CLIENT)
public class FluidRenderHandler {
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

    @SubscribeEvent
    public static void registerModel(ModelRegistryEvent event) {
        addRenderForFluid("peacewater", ExAstrisBlocks.BLOCK_PEACEWATER);
        addRenderForFluid("slime", ExAstrisBlocks.BLOCK_SLIME);
    }
}