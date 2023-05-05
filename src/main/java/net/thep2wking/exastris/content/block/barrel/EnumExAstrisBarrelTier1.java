package net.thep2wking.exastris.content.block.barrel;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.IStringSerializable;
import net.thep2wking.exastris.util.ExAstrisConstants;

public enum EnumExAstrisBarrelTier1 implements IStringSerializable {
    STONE(0, "stone", ExAstrisConstants.MODID_MINECRAFT),
    COBBLESTONE(1, "cobblestone", ExAstrisConstants.MODID_MINECRAFT),
    STONE_BRICKS(2, "stone_bricks", ExAstrisConstants.MODID_MINECRAFT),
    SANDSTONE(3, "sandstone", ExAstrisConstants.MODID_MINECRAFT),
    BRICKS(4, "bricks", ExAstrisConstants.MODID_MINECRAFT),
    NETHER_BRICK(5, "nether_brick", ExAstrisConstants.MODID_MINECRAFT),
    QUARTZ(6, "quartz", ExAstrisConstants.MODID_MINECRAFT),
    PURPUR(7, "purpur", ExAstrisConstants.MODID_MINECRAFT),
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