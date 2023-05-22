package net.thep2wking.exastris.common.barrel;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.IStringSerializable;
import net.thep2wking.exastris.util.ExAstrisConstants;

public enum EnumExAstrisBarrelTier1 implements IStringSerializable {
    STONE(0, "stone", ExAstrisConstants.MODID_MINECRAFT),
    COBBLESTONE(1, "cobblestone", ExAstrisConstants.MODID_MINECRAFT),
    ;

    private static final Int2ObjectMap<EnumExAstrisBarrelTier1> ALL_TYPES = new Int2ObjectArrayMap<>();

    static {
        for (EnumExAstrisBarrelTier1 variant : values()) {
            ALL_TYPES.put(variant.meta, variant);
        }
    }

    public final int meta;
    public final String variant;
    public final String modid;

    EnumExAstrisBarrelTier1(int meta, String variant, String modid) {
        this.meta = meta;
        this.variant = variant;
        this.modid = modid;
    }

    public static EnumExAstrisBarrelTier1 getByMeta(int meta) {
        return ALL_TYPES.get(meta);
    }

    @Override
    public String getName() {
        return this.variant;
    }
}