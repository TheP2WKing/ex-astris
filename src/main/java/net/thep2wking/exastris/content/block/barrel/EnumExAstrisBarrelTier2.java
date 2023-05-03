package net.thep2wking.exastris.content.block.barrel;

import net.minecraft.util.IStringSerializable;

public enum EnumExAstrisBarrelTier2 implements IStringSerializable {
    IRON("iron", 0),
    GOLD("gold", 1),

    ;

    private String materialType;
    public int meta;

    EnumExAstrisBarrelTier2(String materialType, int meta) {
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