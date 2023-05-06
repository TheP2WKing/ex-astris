package net.thep2wking.exastris.config.modules.exastris;

import net.minecraftforge.common.config.Config;

public class MobDollsConfig {
    @Config.Name("Villager Doll")
    @Config.Comment("Whether to enable the villager doll and spawning of villagers")
    public boolean VILLAGER_DOLL = true;

    @Config.Name("Evoker Doll")
    @Config.Comment("Whether to enable the evoker doll and spawning of evokers")
    public boolean EVOKER_DOLL = true;
}
