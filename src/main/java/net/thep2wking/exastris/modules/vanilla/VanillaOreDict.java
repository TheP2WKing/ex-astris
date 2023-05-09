package net.thep2wking.exastris.modules.vanilla;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.thep2wking.exastris.init.ExAstrisItems;

public class VanillaOreDict {
    public static void register() {
        OreDictionary.registerOre("plankWoodOak", new ItemStack(Blocks.PLANKS, 1, 0));
        OreDictionary.registerOre("slabWoodOak", new ItemStack(Blocks.WOODEN_SLAB, 1, 0));

        OreDictionary.registerOre("plankWoodSpruce", new ItemStack(Blocks.PLANKS, 1, 1));
        OreDictionary.registerOre("slabWoodSpruce", new ItemStack(Blocks.WOODEN_SLAB, 1, 1));

        OreDictionary.registerOre("plankWoodBirch", new ItemStack(Blocks.PLANKS, 1, 2));
        OreDictionary.registerOre("slabWoodBirch", new ItemStack(Blocks.WOODEN_SLAB, 1, 2));

        OreDictionary.registerOre("plankWoodJungle", new ItemStack(Blocks.PLANKS, 1, 3));
        OreDictionary.registerOre("slabWoodJungle", new ItemStack(Blocks.WOODEN_SLAB, 1, 3));

        OreDictionary.registerOre("plankWoodAcacia", new ItemStack(Blocks.PLANKS, 1, 4));
        OreDictionary.registerOre("slabWoodAcacia", new ItemStack(Blocks.WOODEN_SLAB, 1, 4));

        OreDictionary.registerOre("plankWoodDarkOak", new ItemStack(Blocks.PLANKS, 1, 5));
        OreDictionary.registerOre("slabWoodDarkOak", new ItemStack(Blocks.WOODEN_SLAB, 1, 5));

        OreDictionary.registerOre("slabStone", new ItemStack(Blocks.STONE_SLAB, 1, 0));
        OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 0));
        OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 1));
        OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 3));
        OreDictionary.registerOre("stone", new ItemStack(Blocks.STONE, 1, 5));

        OreDictionary.registerOre("cobblestone", new ItemStack(Blocks.COBBLESTONE, 1, 0));
        OreDictionary.registerOre("slabCobblestone", new ItemStack(Blocks.STONE_SLAB, 1, 3));

        OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 0));
        OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 1));
        OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 2));
        OreDictionary.registerOre("stoneBricks", new ItemStack(Blocks.STONEBRICK, 1, 3));
        OreDictionary.registerOre("slabStoneBricks", new ItemStack(Blocks.STONE_SLAB, 1, 5));

        OreDictionary.registerOre("sandstone", new ItemStack(Blocks.SANDSTONE, 1, 0));
        OreDictionary.registerOre("sandstone", new ItemStack(Blocks.SANDSTONE, 1, 1));
        OreDictionary.registerOre("sandstone", new ItemStack(Blocks.SANDSTONE, 1, 2));
        OreDictionary.registerOre("slabSandstone", new ItemStack(Blocks.STONE_SLAB, 1, 1));

        OreDictionary.registerOre("sandstone", new ItemStack(Blocks.RED_SANDSTONE, 1, 0));
        OreDictionary.registerOre("sandstone", new ItemStack(Blocks.RED_SANDSTONE, 1, 1));
        OreDictionary.registerOre("sandstone", new ItemStack(Blocks.RED_SANDSTONE, 1, 2));
        OreDictionary.registerOre("slabSandstone", new ItemStack(Blocks.STONE_SLAB2, 1, 0));

        OreDictionary.registerOre("bricks", new ItemStack(Blocks.BRICK_BLOCK, 1, 0));
        OreDictionary.registerOre("slabBricks", new ItemStack(Blocks.STONE_SLAB, 1, 4));

        OreDictionary.registerOre("netherBrick", new ItemStack(Blocks.NETHER_BRICK, 1, 0));
        OreDictionary.registerOre("slabNetherBrick", new ItemStack(Blocks.STONE_SLAB, 1, 6));

        OreDictionary.registerOre("blockQuartz", new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0));
        OreDictionary.registerOre("blockQuartz", new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1));
        OreDictionary.registerOre("blockQuartz", new ItemStack(Blocks.QUARTZ_BLOCK, 1, 2));
        OreDictionary.registerOre("slabQuartz", new ItemStack(Blocks.STONE_SLAB, 1, 7));

        OreDictionary.registerOre("blockPurpur", new ItemStack(Blocks.PURPUR_BLOCK, 1, 0));
        OreDictionary.registerOre("blockPurpur", new ItemStack(Blocks.PURPUR_PILLAR, 1, 0));
        OreDictionary.registerOre("slabPurpur", new ItemStack(Blocks.PURPUR_SLAB, 1, 0));

        OreDictionary.registerOre("prismarine", new ItemStack(Blocks.PRISMARINE, 1, 0));
        OreDictionary.registerOre("prismarine", new ItemStack(Blocks.PRISMARINE, 1, 1));
        OreDictionary.registerOre("prismarine", new ItemStack(Blocks.PRISMARINE, 1, 2));

        OreDictionary.registerOre("dirt", new ItemStack(Item.getItemFromBlock(Blocks.DIRT), 1, 1));

        OreDictionary.registerOre("blockIce", new ItemStack(Item.getItemFromBlock(Blocks.ICE), 1, 0));
        OreDictionary.registerOre("blockIce", new ItemStack(Item.getItemFromBlock(Blocks.PACKED_ICE), 1, 0));

        OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 0));
        OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 1));
        OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 2));
        OreDictionary.registerOre("fish", new ItemStack(Items.FISH, 1, 3));

        OreDictionary.registerOre("listAllseed", new ItemStack(Items.WHEAT_SEEDS, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(Items.PUMPKIN_SEEDS, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(Items.MELON_SEEDS, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(Items.BEETROOT_SEEDS, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(ExAstrisItems.SEEDS_FERN, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(ExAstrisItems.SEEDS_CHORUS, 1, 0));
        OreDictionary.registerOre("listAllseed", new ItemStack(ExAstrisItems.SEEDS_PODZOL, 1, 0));
    }
}