package net.thep2wking.exastris.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ForgeModContainer;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.util.ExAstrisConstants;

public class ExAstrisTabs {
    public static final CreativeTabs EXASTRIS_TAB = new CreativeTabs(ExAstris.MODID + ".name") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ExAstrisItems.END_CAKE, 1, 0);
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public ResourceLocation getBackgroundImage() {
            return ExAstrisConstants.CREATIVE_TAB_SEARCH;
        }

        @Override
        @SuppressWarnings("all")
        public void displayAllRelevantItems(NonNullList<ItemStack> itemList) {
            super.displayAllRelevantItems(itemList);
            for (Fluid bucketFluid : FluidRegistry.getBucketFluids()) {
                if (bucketFluid.getBlock() != null
                        && bucketFluid.getBlock().getRegistryName().getResourceDomain().equals(ExAstris.MODID)) {
                    ItemStack itemstack = UniversalBucket
                            .getFilledBucket(ForgeModContainer.getInstance().universalBucket, bucketFluid);
                    itemList.add(itemstack);
                }
            }
        }
    };
}
