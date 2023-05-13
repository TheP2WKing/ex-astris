package net.thep2wking.exastris.content.block.crucible;

import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.IStringSerializable;
import net.thep2wking.exastris.util.ExAstrisConstants;

public enum EnumExAstrisWoodCricible implements IStringSerializable {
    OAK(0, "oak_wood", ExAstrisConstants.MODID_MINECRAFT),
    SPRUCE(1, "spruce_wood", ExAstrisConstants.MODID_MINECRAFT),
    BIRCH(2, "birch_wood", ExAstrisConstants.MODID_MINECRAFT),
    JUNGLE(3, "jungle_wood", ExAstrisConstants.MODID_MINECRAFT),
    ACACIA(4, "acacia_wood", ExAstrisConstants.MODID_MINECRAFT),
    DARK_OAK(5, "dark_oak_wood", ExAstrisConstants.MODID_MINECRAFT),
    GREATWOOD(6, "greatwood", ExAstrisConstants.MODID_THAUMCRAFT),
    SILVERWOOD(7, "silverwood", ExAstrisConstants.MODID_THAUMCRAFT),
    ;

    private static final Int2ObjectMap<EnumExAstrisWoodCricible> ALL_TYPES = new Int2ObjectArrayMap<>();

    static {
        for (EnumExAstrisWoodCricible variant : values()) {
            ALL_TYPES.put(variant.meta, variant);
        }
    }

    public final int meta;
    public final String variant;
    public final String modid;

    EnumExAstrisWoodCricible(int meta, String variant, String modid) {
        this.meta = meta;
        this.variant = variant;
        this.modid = modid;
    }

    public static EnumExAstrisWoodCricible getByMeta(int meta) {
        return ALL_TYPES.get(meta);
    }

    @Override
    public String getName() {
        return this.variant;
    }
}