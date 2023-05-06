package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class ExAstrisSieveRecipesConfig {
    @Config.Name("Fern Seeds from Dirt")
    @Config.Comment("Whether to get fern seeds from siveting dirt")
    public boolean FERN_SEEDS = true;

    @Config.Name("Strings from Infested Leaves")
    @Config.Comment("Whether to get strings from siveting infested leaves")
    public boolean STRINGS = true;

    @Config.Name("Prismarine Crystals from Sand")
    @Config.Comment("Whether to get prismarine crystals from siveting sand")
    public boolean PRISMARINE_CRYSTALS = true;

    @Config.Name("Vanilla Drops from higher Mesh Tiers")
    @Config.Comment("Whether to add some vanilla resources as a possible drop for higher mesh tiers so higher tier meshes can also aquire resources from prevoious tiers")
    public boolean VANILLA_DROPS_FROM_HIGHER_MESH_TIERS = true;

    @Config.Name("Chorus Seeds from Crushed Endstone")
    @Config.Comment("Whether to get chorus seeds from siveting crushed endstone")
    public boolean CHORUS_SEEDS = true;

    @Config.Name("Ender Pearls from Crushed Endstone")
    @Config.Comment("Whether to get ender pearls from siveting crushed endstone")
    public boolean ENDER_PEARLS = true;

    @Config.Name("Chorus Fruits from Crushed Endstone")
    @Config.Comment("Whether to get chorus fruits from siveting crushed endstone")
    public boolean CHORUS_FRUITS = true;

    @Config.Name("Podzol Seeds from Dirt")
    @Config.Comment("Whether to get podzol seeds from siveting dirt")
    public boolean PODZOL_SEEDS = true;

    @Config.Name("Netherrack Pebbles from Dirt")
    @Config.Comment("Whether to get netherrack pebbles from siveting dirt")
    public boolean NETHERRACK_PEBBLES = true;

    @Config.Name("Endstone Pebbles from Dirt")
    @Config.Comment("Whether to get endstone pebbles from siveting dirt")
    public boolean ENDSTONE_PEBBLES = true;

    @Config.Name("Ice Shards from Snow")
    @Config.Comment("Whether to get ice shards from siveting snow")
    public boolean ICE_SHARDS = true;
}