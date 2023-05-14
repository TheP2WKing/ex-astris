package net.thep2wking.exastris.content.item.hammer;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.thep2wking.exastris.api.ExAstrisItemHammerBase;
import thaumcraft.api.items.IArchitect;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.lib.enchantment.EnumInfusionEnchantment;
import thaumcraft.common.lib.utils.InventoryUtils;
import thaumcraft.common.lib.utils.Utils;

public class ItemElementalHammer extends ExAstrisItemHammerBase implements IArchitect {
	public ItemElementalHammer(String name, ToolMaterial material, ItemStack repairMaterial, int durability,
			float attackDamage, float attackSpeed, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(name, material, repairMaterial, durability, attackDamage, attackSpeed, tab, rarity, hasEffect);
	}

	@Deprecated
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side,
			float par8, float par9, float par10) {
		IBlockState bs = world.getBlockState(pos);
		TileEntity te = world.getTileEntity(pos);
		if (te == null) {
			block0: for (int aa = -1; aa <= 1; ++aa) {
				for (int bb = -1; bb <= 1; ++bb) {
					int xx = 0;
					int yy = 0;
					int zz = 0;
					byte o = ItemElementalHammer.getOrientation(player.getHeldItem(hand));
					if (o == 1) {
						yy = bb;
						if (side.ordinal() <= 1) {
							int l = MathHelper.floor((double) ((double) (player.rotationYaw * 4.0f / 360.0f) + 0.5))
									& 3;
							if (l == 0 || l == 2) {
								xx = aa;
							} else {
								zz = aa;
							}
						} else if (side.ordinal() <= 3) {
							zz = aa;
						} else {
							xx = aa;
						}
					} else if (o == 2) {
						if (side.ordinal() <= 1) {
							int l = MathHelper.floor((double) ((double) (player.rotationYaw * 4.0f / 360.0f) + 0.5))
									& 3;
							yy = bb;
							if (l == 0 || l == 2) {
								xx = aa;
							} else {
								zz = aa;
							}
						} else {
							zz = bb;
							xx = aa;
						}
					} else if (side.ordinal() <= 1) {
						xx = aa;
						zz = bb;
					} else if (side.ordinal() <= 3) {
						xx = aa;
						yy = bb;
					} else {
						zz = aa;
						yy = bb;
					}
					BlockPos p2 = pos.offset(side).add(xx, yy, zz);
					if (!bs.getBlock().canPlaceBlockAt(world, p2))
						continue;
					if (player.capabilities.isCreativeMode || InventoryUtils.consumePlayerItem((EntityPlayer) player,
							(Item) Item.getItemFromBlock((Block) bs.getBlock()),
							(int) bs.getBlock().getMetaFromState(bs))) {
						world.playSound((double) p2.getX(), (double) p2.getY(), (double) p2.getZ(),
								bs.getBlock().getSoundType().getBreakSound(), SoundCategory.BLOCKS, 0.6f,
								0.9f + world.rand.nextFloat() * 0.2f, false);
						world.setBlockState(p2, bs);
						player.getHeldItem(hand).damageItem(1, (EntityLivingBase) player);
						if (world.isRemote) {
							FXDispatcher.INSTANCE.drawBamf(p2, 8401408, false, false, side);
						}
						player.swingArm(hand);
						continue;
					}
					if (bs.getBlock() != Blocks.GRASS || !player.capabilities.isCreativeMode
							&& !InventoryUtils.consumePlayerItem((EntityPlayer) player,
									(Item) Item.getItemFromBlock((Block) Blocks.DIRT), (int) 0))
						continue;
					world.playSound((double) p2.getX(), (double) p2.getY(), (double) p2.getZ(),
							bs.getBlock().getSoundType().getBreakSound(), SoundCategory.BLOCKS, 0.6f,
							0.9f + world.rand.nextFloat() * 0.2f, false);
					world.setBlockState(p2, Blocks.DIRT.getDefaultState());
					player.getHeldItem(hand).damageItem(1, (EntityLivingBase) player);
					if (world.isRemote) {
						FXDispatcher.INSTANCE.drawBamf(p2, 8401408, false, false, side);
					}
					player.swingArm(hand);
					if (player.getHeldItem(hand).isEmpty() || player.getHeldItem(hand).getCount() < 1)
						continue block0;
				}
			}
		}
		return EnumActionResult.FAIL;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (tab == this.getCreativeTab() || tab == CreativeTabs.SEARCH) {
			ItemStack w1 = new ItemStack((Item) this);
			EnumInfusionEnchantment.addInfusionEnchantment((ItemStack) w1,
					(EnumInfusionEnchantment) EnumInfusionEnchantment.DESTRUCTIVE, (int) 1);
			items.add((ItemStack) w1);
		} else {
			super.getSubItems(tab, items);
		}
	}

	public ArrayList<BlockPos> getArchitectBlocks(ItemStack focusstack, World world, BlockPos pos, EnumFacing side,
			EntityPlayer player) {
		ArrayList<BlockPos> b = new ArrayList<BlockPos>();
		if (!player.isSneaking()) {
			return b;
		}
		IBlockState bs = world.getBlockState(pos);
		for (int aa = -1; aa <= 1; ++aa) {
			for (int bb = -1; bb <= 1; ++bb) {
				int xx = 0;
				int yy = 0;
				int zz = 0;
				byte o = ItemElementalHammer.getOrientation(focusstack);
				if (o == 1) {
					yy = bb;
					if (side.ordinal() <= 1) {
						int l = MathHelper.floor((double) ((double) (player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
						if (l == 0 || l == 2) {
							xx = aa;
						} else {
							zz = aa;
						}
					} else if (side.ordinal() <= 3) {
						zz = aa;
					} else {
						xx = aa;
					}
				} else if (o == 2) {
					if (side.ordinal() <= 1) {
						int l = MathHelper.floor((double) ((double) (player.rotationYaw * 4.0f / 360.0f) + 0.5)) & 3;
						yy = bb;
						if (l == 0 || l == 2) {
							xx = aa;
						} else {
							zz = aa;
						}
					} else {
						zz = bb;
						xx = aa;
					}
				} else if (side.ordinal() <= 1) {
					xx = aa;
					zz = bb;
				} else if (side.ordinal() <= 3) {
					xx = aa;
					yy = bb;
				} else {
					zz = aa;
					yy = bb;
				}
				BlockPos p2 = pos.offset(side).add(xx, yy, zz);
				if (!bs.getBlock().canPlaceBlockAt(world, p2))
					continue;
				b.add(p2);
			}
		}
		return b;
	}

	public boolean showAxis(ItemStack stack, World world, EntityPlayer player, EnumFacing side,
			IArchitect.EnumAxis axis) {
		return false;
	}

	@SuppressWarnings("null")
	public static byte getOrientation(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("or")) {
			return stack.getTagCompound().getByte("or");
		}
		return 0;
	}

	@SuppressWarnings("null")
	public static void setOrientation(ItemStack stack, byte o) {
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}
		if (stack.hasTagCompound()) {
			stack.getTagCompound().setByte("or", (byte) (o % 3));
		}
	}

	public RayTraceResult getArchitectMOP(ItemStack stack, World world, EntityLivingBase player) {
		return Utils.rayTrace((World) world, (Entity) player, (boolean) false);
	}

	public boolean useBlockHighlight(ItemStack stack) {
		return true;
	}
}