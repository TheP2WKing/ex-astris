package net.thep2wking.exastris.content.block.barrel;

import net.minecraft.util.IStringSerializable;

public enum EnumExAstrisBarrelTier0 implements IStringSerializable {
    OAK("oak_wood", 0),
    SPRUCE("spruce_wood", 1),
    BIRCH("birch_wood", 2),
    JUNGLE("jungle_wood", 3),
    ACACIA("acacia_wood", 4),
    DARK_OAK("dark_oak_wood", 5),
    ;

    private String materialType;
    private int meta;

    EnumExAstrisBarrelTier0(String materialType, int meta) {
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