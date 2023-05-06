package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class HeatSourcesConfig {
    @Config.Name("Lit Redstone Lamp")
    @Config.Comment("Whether lit redstone lamps can be used as crucible heat source")
    public boolean LIT_REDSTONE_LAMP = true;

    @Config.Name("Lit Redstone Lamp Heat Value")
    @Config.Comment("Set the crucible heat value for lit redstone lamps")
    public int LIT_REDSTONE_LAMP_HEAT_VALUE = 2;

    @Config.Name("Sea Lantern")
    @Config.Comment("Whether sea lanterns can be used as crucible heat source")
    public boolean SEA_LANTERN = true;

    @Config.Name("Sea Lantern Heat Value")
    @Config.Comment("Set the crucible heat value for sea lanterns")
    public int SEA_LANTERN_HEAT_VALUE = 2;

    @Config.Name("Redstone Torch")
    @Config.Comment("Whether redstone torches can be used as crucible heat source")
    public boolean REDSTONE_TORCH = true;

    @Config.Name("Redstone Torch Heat Value")
    @Config.Comment("Set the crucible heat value for redstone torches")
    public int REDSTONE_TORCH_HEAT_VALUE = 1;

    @Config.Name("Beacon")
    @Config.Comment("Whether beacons can be used as crucible heat source")
    public boolean BEACON = true;
    
    @Config.Name("Beacon Heat Value")
    @Config.Comment("Set the crucible heat value for beacons")
    public int BEACON_HEAT_VALUE = 20;
}