package net.thep2wking.exastris.content.item.doll;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.thep2wking.exastris.util.ExAstrisConstants;

public enum EnumExAstrisDollType {
    VILLAGER(0, "villager", ExAstrisConstants.MODID_MINECRAFT, "minecraft:villager", "peacewater", 2),
    EVOKER(1, "evoker", ExAstrisConstants.MODID_MINECRAFT, "minecraft:evocation_illager", "witchwater", 2),
    PECH_FORAGER(2, "pech_forager", ExAstrisConstants.MODID_THAUMCRAFT, "thaumcraft:pech", "peacewater", 1.5),
    CRIMSON_CLERIC(3, "crimson_cleric", ExAstrisConstants.MODID_THAUMCRAFT, "thaumcraft:cultistcleric", "witchwater", 2),
    ;

    private static final Int2ObjectMap<EnumExAstrisDollType> ALL_TYPES = new Int2ObjectArrayMap<>();

    static {
        for (EnumExAstrisDollType dollType : values()) {
            ALL_TYPES.put(dollType.meta, dollType);
        }
    }

    public final int meta;
    public final String name;
    public final String modid;
    public final String entityName;
    public final String fluidName;
    public final double posYCorrection;

    EnumExAstrisDollType(int meta, String name, String modid, String entityName, String fluidName,
            double posYCorrection) {
        this.meta = meta;
        this.name = name;
        this.modid = modid;
        this.entityName = entityName;
        this.fluidName = fluidName;
        this.posYCorrection = posYCorrection;
    }

    public static EnumExAstrisDollType getByMeta(int meta) {
        return ALL_TYPES.get(meta);
    }
}
