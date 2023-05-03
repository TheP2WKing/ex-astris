package net.thep2wking.exastris.api;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.exastris.ExAstris;

public class ExAstrisFluidBase extends Fluid {
    public ExAstrisFluidBase(String name, ResourceLocation still, ResourceLocation flow, int color, int temperature,
            EnumRarity rarity) {
        super(name, still, flow, color);
        setUnlocalizedName(ExAstris.PREFIX + name);
        setColor(this.color);
        setTemperature(this.temperature);
        setRarity(this.rarity);

        if (((color >> 24) & 0xFF) == 0) {
            color |= 0xFF << 24;
        }
        this.color = color;
    }

    @Override
    public int getTemperature(World world, BlockPos pos) {
        return temperature;
    }

    @Override
    public EnumRarity getRarity(World world, BlockPos pos) {
        return rarity;
    }

    @Override
    public int getColor() {
        return color;
    }
}