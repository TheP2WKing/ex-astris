package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class ExAstrisHeatSourcesConfig {
    @Config.Name("Lit Redstone Lamp")
    @Config.Comment("Whether lit redstone lamps can be used as crucible heat source")
    public boolean LIT_REDSTONE = true;

    @Config.Name("Sea Lantern")
    @Config.Comment("Whether sea lanterns can be used as crucible heat source")
    public boolean SEA_LANTERN = true;

    @Config.Name("Redstone Torch")
    @Config.Comment("Whether redstone torches can be used as crucible heat source")
    public boolean REDSTONE_TORCH = true;

    @Config.Name("Beacon")
    @Config.Comment("Whether beacons can be used as crucible heat source")
    public boolean BEACON = true;
}