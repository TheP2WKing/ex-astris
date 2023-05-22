package net.thep2wking.exastris.modules.redstonearsenal.config;

import net.minecraftforge.common.config.Config;

public class HammerConfig {
    @Config.Name("Flux Infused Hammer")
    @Config.Comment("Whether the flux infused hammer is enabled")
    public boolean FLUX_HAMMER = true;

    @Config.Name("Flux Infused Hammer max Energy")
    @Config.Comment("Set the max energy of flux infused hammer")
    public int FLUX_HAMMER_MAX_ENERGY = 320000;

    @Config.Name("Flux Infused Hammer max Transfer")
    @Config.Comment("Set the max energy transfer of flux infused hammer")
    public int FLUX_HAMMER_MAX_TRANSFER = 4000;

    @Config.Name("Flux Infused Hammer Energy use")
    @Config.Comment("Set the energy used by flux infused hammer")
    public int FLUX_HAMMER_ENERGY_USE = 400;

    @Config.Name("Flux Infused Hammer Energy use Empowered")
    @Config.Comment("Set the energy used by flux infused hammer if empowered")
    public int FLUX_HAMMER_ENERGY_USE_EMPOWERED = 800;

    @Config.Name("Flux Infused Hammer base Efficiency")
    @Config.Comment("Set the base efficiency of flux infused hammer")
    public float FLUX_HAMMER_BASE_EFFICIENCY = 16.0f;
}