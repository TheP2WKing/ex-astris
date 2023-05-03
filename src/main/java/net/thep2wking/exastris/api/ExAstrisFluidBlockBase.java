package net.thep2wking.exastris.api;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;

public class ExAstrisFluidBlockBase extends BlockFluidClassic {
    public ExAstrisFluidBlockBase(String name, Fluid fluid, Material material) {
        super(fluid, material);
        setUnlocalizedName(ExAstris.PREFIX + name);
        setRegistryName(ExAstris.PREFIX + name);
        ExAstrisBlocks.BLOCKS.add(this);
    }
}