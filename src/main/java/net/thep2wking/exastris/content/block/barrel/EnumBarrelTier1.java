package net.thep2wking.exastris.content.block.barrel;

import net.minecraft.util.IStringSerializable;

public enum EnumBarrelTier1 implements IStringSerializable {
    STONE("stone", 0),
    COBBLESTONE("cobblestone", 1),
    STONE_BRICKS("stone_bricks", 2),
    SANDSTONE("sandstone", 3),
    BRICKS("bricks", 4),
    NETHER_BRICK("nether_brick", 5),
    QUARTZ("quartz", 6),
    PURPUR("purpur", 7),
    ;

    private String materialType;
    public int meta;

    EnumBarrelTier1(String materialType, int meta) {
        this.materialType = materialType;
        this.meta = meta;
    }

    public String getMaterialType() {
        return materialType;
    }

    public int getMeta() {
        return meta;
    }

    public static int count() {
        return values().length;
    }

    @Override
    public String getName() {
        return this.materialType;
    }
}