package net.thep2wking.exastris.modules.exastris;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.thep2wking.exastris.init.ExAstrisBlocks;

@SuppressWarnings("null")
public class SmeltingRecipesExAstris {
    public static void register() {
        GameRegistry.addSmelting(new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 1),
                new ItemStack(ExAstrisBlocks.BLOCK_BARREL_T1, 1, 0), 0.1f);

                
        for (ItemStack inputOre : OreDictionary.getOres("treeSapling")) {
            GameRegistry.addSmelting(inputOre, new ItemStack(Item.getItemFromBlock(Blocks.DEADBUSH), 1, 0),
                    0.1f);
        }
        for (ItemStack inputOre : OreDictionary.getOres("flower")) {
            GameRegistry.addSmelting(inputOre, new ItemStack(Item.getItemFromBlock(Blocks.DEADBUSH), 1, 0),
                    0.1f);
        }
    }
}
