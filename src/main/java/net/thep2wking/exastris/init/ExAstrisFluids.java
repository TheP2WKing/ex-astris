package net.thep2wking.exastris.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.fluids.Fluid;
import net.thep2wking.exastris.api.ExAstrisFluidBase;
import net.thep2wking.exastris.util.ExAstrisConstants;
import net.thep2wking.exastris.util.handler.RarityHandler;

public class ExAstrisFluids {
    public static final List<Fluid> FLUIDS = new ArrayList<Fluid>();

    public static final Fluid PEACEWATER = new ExAstrisFluidBase("peacewater", ExAstrisConstants.FLUID_STILL_BASE,
            ExAstrisConstants.FLUID_FLOW_BASE, 65527, 300, RarityHandler.WHITE);
    public static final Fluid FROSTWATER = new ExAstrisFluidBase("frostwater", ExAstrisConstants.FLUID_STILL_BASE,
            ExAstrisConstants.FLUID_FLOW_BASE, 8045055, 250, RarityHandler.WHITE);
    public static final Fluid SLIME = new ExAstrisFluidBase("slime", ExAstrisConstants.FLUID_STILL_BASE,
            ExAstrisConstants.FLUID_FLOW_BASE, 10154118, 300, RarityHandler.WHITE);
}