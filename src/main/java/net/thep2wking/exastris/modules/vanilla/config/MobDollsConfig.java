package net.thep2wking.exastris.modules.vanilla.config;

import net.minecraftforge.common.config.Config;

public class MobDollsConfig {
    @Config.Name("Villager Doll")
    @Config.Comment("Whether to enable the villager doll")
    public boolean VILLAGER_DOLL = true;

    @Config.Name("Villager Profession ID max Value")
    @Config.Comment("Set the max id number of possible spawned villager profession ids (higher values may prevent game from starting because villager does not exist)")
    public int VILLAGER_PROFESSION_ID_MAX_VALUE = 5;

    @Config.Name("Evoker Doll")
    @Config.Comment("Whether to enable the evoker doll")
    public boolean EVOKER_DOLL = true;
}