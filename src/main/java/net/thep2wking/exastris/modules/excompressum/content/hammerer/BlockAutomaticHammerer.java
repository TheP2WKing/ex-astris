package net.thep2wking.exastris.modules.excompressum.content.hammerer;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import exnihilocreatio.compatibility.ITOPInfoProvider;
import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.modules.excompressum.base.BlockAutomaticHammererBase;
import net.thep2wking.exastris.util.handler.EnumToolType;

public class BlockAutomaticHammerer extends BlockAutomaticHammererBase implements ITOPInfoProvider {
	public BlockAutomaticHammerer(String name, CreativeTabs tab, Material material, SoundType sound, int harvestLevel,
			EnumToolType toolType, float hardness, float resistance, float lightLevel) {
		super(name, tab, material, sound, harvestLevel, toolType, hardness, resistance, lightLevel);
		GameRegistry.registerTileEntity(TileAutomaticHammerer.class, new ResourceLocation(name));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata) {
		return new TileAutomaticHammerer();
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		updateRedstoneState(world, pos);
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
		updateRedstoneState(world, pos);
	}

	private void updateRedstoneState(World world, BlockPos pos) {
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileAutomaticHammerer) {
			((TileAutomaticHammerer) tileEntity).setDisabledByRedstone(world.isBlockPowered(pos));
		}
	}

	@Override
	public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
			IBlockState blockState, IProbeHitData data) {
		TileAutomaticHammerer hammerer = (TileAutomaticHammerer) world.getTileEntity(data.getPos());
		if (hammerer == null)
			return;

		if (hammerer.isDisabledByRedstone()) {
			probeInfo.text(TextFormatting.RED + "{*top.exastris.disabled*}");
			return;
		}

		if (!hammerer.isDisabledByRedstone()) {
			// if (sieve.getUpgradeStack().isEmpty()) {
			// probeInfo.text(TextFormatting.RED + "{*top.exastris.nomesh*}");
			// return;
			// }

			probeInfo.progress(Math.round(hammerer.getProgress() * 100), 100,
					probeInfo.defaultProgressStyle().suffix("%"));

			if (player.isSneaking()) {
				probeInfo.text(
						TextFormatting.GOLD + "{*top.exastris.energy*}" + " " + hammerer.getEffectiveEnergy() + " FE");
				probeInfo.text(TextFormatting.GOLD + "{*top.exastris.speed*}" + " "
						+ String.format("%.3f", hammerer.getEffectiveSpeed()));
				probeInfo.text(TextFormatting.GOLD + "{*top.exastris.luck*}" + " "
						+ String.format("%.3f", hammerer.getEffectiveLuck()));
			}

			if (!hammerer.getHammerStack().isEmpty()) {
				probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER))
						.item(hammerer.getHammerStack())
						.text(TextFormatting.GREEN + " " + IProbeInfo.STARTLOC
								+ hammerer.getHammerStack().getUnlocalizedName()
								+ ".name"
								+ IProbeInfo.ENDLOC);
			}

			if (mode == ProbeMode.EXTENDED) {
				Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(hammerer.getHammerStack());
				for (Map.Entry<Enchantment, Integer> enchantment : enchantments.entrySet()) {
					probeInfo
							.text(TextFormatting.BLUE + enchantment.getKey().getTranslatedName(enchantment.getValue()));
				}
			}
		}
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(world, pos, state, placer, stack);
		TileAutomaticHammerer tileEntity = (TileAutomaticHammerer) world.getTileEntity(pos);
		if (tileEntity instanceof TileAutomaticHammerer) {
			NBTTagCompound tagCompound = stack.getTagCompound();
			if (tagCompound != null) {
				if (tagCompound.hasKey("EnergyStored")) {
					tileEntity.getEnergyStorage().setEnergyStored(tagCompound.getInteger("EnergyStored"));
				}
				if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SAVE_INVENTORY_CONTENTS) {
					((TileAutomaticHammerer) tileEntity).readRestorableFromNBT(tagCompound);
				}
			}
		}
	}

	@Override
	public void getDrops(NonNullList<ItemStack> result, IBlockAccess world, BlockPos pos, IBlockState metadata,
			int fortune) {
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileAutomaticHammerer
				&& ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.SAVE_INVENTORY_CONTENTS) {
			ItemStack stack = new ItemStack(Item.getItemFromBlock(this));
			NBTTagCompound tagCompound = new NBTTagCompound();
			((TileAutomaticHammerer) tileEntity).writeRestorableToNBT(tagCompound);
			stack.setTagCompound(tagCompound);
			result.add(stack);
		} else {
			super.getDrops(result, world, pos, metadata, fortune);
		}
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player,
			boolean willHarvest) {
		if (willHarvest) {
			return true;
		}
		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te,
			ItemStack stack) {
		super.harvestBlock(world, player, pos, state, te, stack);
		world.setBlockToAir(pos);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		super.addInformation(stack, worldIn, tooltip, flagIn);
		NBTTagCompound nbt = stack.getTagCompound();
		if (GuiScreen.isShiftKeyDown()) {
			if (nbt != null) {
				if (nbt.hasKey("HammerStack")) {
					ItemStack HammerStack = new ItemStack(nbt.getCompoundTag("HammerStack"));
					if (HammerStack.getItem() == Items.AIR) {
						tooltip.add("Hammer: " + TextFormatting.RED + "No Hammer");
					} else {
						String displayName = HammerStack.getItem().getItemStackDisplayName(HammerStack);
						if (HammerStack.isItemEnchanted()) {
							displayName += " (Enchanted)";
						}
						tooltip.add("Hammer: " + TextFormatting.GREEN + displayName);
					}
				}
				if (nbt.hasKey("UpgradeSpeedStack")) {
					ItemStack upgradeSpeedStack = new ItemStack(nbt.getCompoundTag("UpgradeSpeedStack"));
					if (upgradeSpeedStack.getCount() == 0) {
						tooltip.add("Speed Upgrades: " + TextFormatting.YELLOW + "None");
					} else {
						tooltip.add("Speed Upgrades: " + TextFormatting.YELLOW + upgradeSpeedStack.getCount());
					}
				}
				if (nbt.hasKey("UpgradeFortuneStack")) {
					ItemStack upgradeFortuneStack = new ItemStack(nbt.getCompoundTag("UpgradeFortuneStack"));
					if (upgradeFortuneStack.getCount() == 0) {
						tooltip.add("Fortune Upgrades: " + TextFormatting.YELLOW + "None");
					} else {
						tooltip.add("Fortune Upgrades: " + TextFormatting.YELLOW + upgradeFortuneStack.getCount());
					}
				}
				if (nbt.hasKey("EnergyStorage")) {
					tooltip.add("Energy: " + TextFormatting.RED + nbt.getInteger("EnergyStorage") + " FE");
				}
			}
		} else if (nbt != null) {
			tooltip.add(TextFormatting.GRAY + "Hold " + TextFormatting.YELLOW + "" + TextFormatting.ITALIC + "Shift"
					+ TextFormatting.GRAY + " for Contents");
		}
	}
}