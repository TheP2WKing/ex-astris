package net.thep2wking.exastris.init;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.api.ExAstrisFluidBase;
import net.thep2wking.exastris.util.handler.RarityHandler;

public class ExAstrisFluids {
    private static final ResourceLocation STILL = new ResourceLocation(ExAstris.MODID, "blocks/fluid_still");
    private static final ResourceLocation FLOW = new ResourceLocation(ExAstris.MODID, "blocks/fluid_flow");

    public static final Fluid PEACEWATER = new ExAstrisFluidBase("peacewater", STILL, FLOW, 65527, 300, RarityHandler.WHITE);
    public static final Fluid SLIME = new ExAstrisFluidBase("slime", STILL, FLOW, 10154118, 300, RarityHandler.GREEN);

    public static void registerFluids() {
        registerFluid(PEACEWATER);
        registerFluid(SLIME);
    }

    public static void registerFluid(Fluid fluid) {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }
}