package net.thep2wking.exastris.modules.thaumcraft.config;

import net.minecraftforge.common.config.Config;

public class SieveRecipesConfig {
	@Config.Name("Amber from Sand")
    @Config.Comment("Whether to get amber from siveting sand")
    public boolean AMBER_FROM_SAND = true;

	@Config.Name("Quicksilver Drop from Sand")
    @Config.Comment("Whether to get quicksilver drop from siveting sand")
    public boolean QUICKSILVER_DROP_FROM_SAND = true;

	@Config.Name("Primordial Pearl from Ancient Stone")
    @Config.Comment("Whether to get primordial pearls from siveting ancient stone")
    public boolean PRIMORDIAL_PEARL_FROM_ANCIENT_STONE = true;
}