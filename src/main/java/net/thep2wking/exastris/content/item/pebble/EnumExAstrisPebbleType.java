package net.thep2wking.exastris.content.item.pebble;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

public enum EnumExAstrisPebbleType {
    NETHERRACK(0, "netherrack", "minecraft"),
    ENDSTONE(1, "endstone", "minecraft"),
    MARBLE(2, "marble", "chisel"),
    LIMESTONE(3, "limestone", "chisel"),
    ;

    private static final Int2ObjectMap<EnumExAstrisPebbleType> ALL_TYPES = new Int2ObjectArrayMap<>();

    static {
        for (EnumExAstrisPebbleType dollType : values()) {
            ALL_TYPES.put(dollType.meta, dollType);
        }
    }

    public final int meta;
    public final String name;
    public final String modid;

    EnumExAstrisPebbleType(int meta, String name, String modid) {
        this.meta = meta;
        this.name = name;
        this.modid = modid;
    }

    public static EnumExAstrisPebbleType getByMeta(int meta) {
        return ALL_TYPES.get(meta);
    }
}
