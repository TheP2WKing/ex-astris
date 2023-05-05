package net.thep2wking.exastris.content.block.barrel;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.IStringSerializable;
import net.thep2wking.exastris.util.ExAstrisConstants;

public enum EnumExAstrisBarrelTier2 implements IStringSerializable {
    IRON(0, "iron", ExAstrisConstants.MODID_MINECRAFT),
    GOLD(1, "gold", ExAstrisConstants.MODID_MINECRAFT),
    ;

    private static final Int2ObjectMap<EnumExAstrisBarrelTier2> ALL_TYPES = new Int2ObjectArrayMap<>();

    static {
        for (EnumExAstrisBarrelTier2 variant : values()) {
            ALL_TYPES.put(variant.meta, variant);
        }
    }

    public final int meta;
    public final String variant;
    public final String modid;

    EnumExAstrisBarrelTier2(int meta, String variant, String modid) {
        this.meta = meta;
        this.variant = variant;
        this.modid = modid;
    }

    public static EnumExAstrisBarrelTier2 getByMeta(int meta) {
        return ALL_TYPES.get(meta);
    }

    @Override
    public String getName() {
        return this.variant;
    }
}