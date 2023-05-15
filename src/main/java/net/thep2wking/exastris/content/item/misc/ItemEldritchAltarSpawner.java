package net.thep2wking.exastris.content.item.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.thep2wking.exastris.api.ExAstrisItemBase;
import net.thep2wking.exastris.util.world.WorldGeneratorExAstris;
import thaumcraft.api.items.IWarpingGear;

public class ItemEldritchAltarSpawner extends ExAstrisItemBase implements IWarpingGear {
	public ItemEldritchAltarSpawner(String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(name, tab, rarity, hasEffect);
		setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,
			float hitY, float hitZ, EnumHand hand) {
		if (!world.isRemote) {
			WorldGeneratorExAstris gen = new WorldGeneratorExAstris("eldritch_altar");
			BlockPos spawnPos = new BlockPos(pos.getX() + -3, pos.getY() + 1, pos.getZ() - 3);

			if (!world.isRemote && Loader.isModLoaded("thaumicaugmentation")) {
				if (gen.generate(world, world.rand, spawnPos)) {
					ItemStack stack = player.getHeldItem(hand);
					if (!player.capabilities.isCreativeMode) {
						stack.setCount(0);
					}
				}
				return EnumActionResult.FAIL;
			} else {
				player.sendMessage(new TextComponentString(TextFormatting.RED
						+ "The Eldritch Content is not properly implemented in Thaumcraft 6. Install Thaumic Augmentation by TheCodex6824 to function properly."));
			}
		}
		return EnumActionResult.SUCCESS;
	}

	@Override
	public int getWarp(ItemStack arg0, EntityPlayer arg1) {
		return 1;
	}
}