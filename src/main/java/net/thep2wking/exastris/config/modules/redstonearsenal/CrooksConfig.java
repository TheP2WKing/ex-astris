package net.thep2wking.exastris.config.modules.redstonearsenal;

import net.minecraftforge.common.config.Config;

public class CrooksConfig {
    @Config.Name("Flux Infused Crook")
    @Config.Comment("Whether the flux infused crook is enabled")
    public boolean FLUX_CROOK = true;

    @Config.Name("Flux Infused Crook max Energy")
    @Config.Comment("Set the max energy of flux infused crook")
    public int FLUX_CROOK_MAX_ENERGY = 320000;

    @Config.Name("Flux Infused Crook max Transfer")
    @Config.Comment("Set the max energy transfer of flux infused crook")
    public int FLUX_CROOK_MAX_TRANSFER = 4000;

    @Config.Name("Flux Infused Crook Energy use")
    @Config.Comment("Set the energy used by flux infused crook")
    public int FLUX_CROOK_ENERGY_USE = 200;

    @Config.Name("Flux Infused Crook Energy use Empowered")
    @Config.Comment("Set the energy used by flux infused crook if empowered")
    public int FLUX_CROOK_ENERGY_USE_EMPOWERED = 400;

    @Config.Name("Flux Infused Crook base Efficiency")
    @Config.Comment("Set the base efficiency of flux infused crook")
    public float FLUX_CROOK_BASE_EFFICIENCY = 6.0f;
}