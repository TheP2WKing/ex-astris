package net.thep2wking.exastris.modules.thaumcraft.config;

import net.minecraftforge.common.config.Config;

public class InfusionRecipes {
	@Config.Name("Eldritch Portal Spawner")
    @Config.Comment("Whether to enable the eldritch portal spawer from infsuion")
    public boolean ELDRITCH_PORTAL_SPAWNER = true;

    @Config.Name("Silverwood Sapling")
    @Config.Comment("Whether to enable the silverwood sapling from infusion")
    public boolean SILVERWOOD_SAPLING = true;

    @Config.Name("Greatwood Sapling")
    @Config.Comment("Whether to enable the greatwood sapling from infusion")
    public boolean GREATWOOD_SAPLING = true;

    @Config.Name("Knowledge Fragment")
    @Config.Comment("Whether to enable the knowledge fragment from infusion")
    public boolean KNOWLEDGE_FRAGMENT = true;
}