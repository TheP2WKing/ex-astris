package net.thep2wking.exastris.modules.thaumcraft.config;

import net.minecraftforge.common.config.Config;

public class HammerRecipesConfig {
	@Config.Name("Aer Crystal from Sandstone")
    @Config.Comment("Whether to get aer crystals from hammering sandstone")
    public boolean AER_CRYSTALS_FROM_SANDSTONE = true;

	@Config.Name("Terra Crystal from Gras")
    @Config.Comment("Whether to get terra crystals from hammering grass")
    public boolean TERRA_CRYSTALS_FROM_GRASS = true;

	@Config.Name("Ignis Crystal from Netherbrick")
    @Config.Comment("Whether to get ignis crystals from hammering netherbrick")
    public boolean IGNIS_CRYSTALS_FROM_NETHERBRICK = true;

	@Config.Name("Aqua Crystal from Ice")
    @Config.Comment("Whether to get aqua crystals from hammering ice")
    public boolean AQUA_CRYSTALS_FROM_ICE = true;

	@Config.Name("Ordo Crystal from Stone")
    @Config.Comment("Whether to get ordo crystals from hammering stone")
    public boolean ORDO_CRYSTALS_FROM_STONE = true;

	@Config.Name("Perdotio Crystal from Tnt")
    @Config.Comment("Whether to get ignis crystals from hammering tnt")
    public boolean PERDITIO_CRYSTALS_FROM_TNT = true;
}