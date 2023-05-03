package net.thep2wking.exastris.util.handler;

public enum EnumToolType {
    PICKAXE("pickaxe"),
    AXE("axe"),
    SHOVEL("shovel"),
    HOE("hoe"),
    ;

    private String toolType;

    EnumToolType(String toolType) {
        this.toolType = toolType;
    }

    public String getToolType() {
        return toolType;
    }
}