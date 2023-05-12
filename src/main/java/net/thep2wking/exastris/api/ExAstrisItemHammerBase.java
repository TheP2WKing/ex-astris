package net.thep2wking.exastris.api;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import exnihilocreatio.items.tools.IHammer;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.IHasModel;

public class ExAstrisItemHammerBase extends ItemTool implements IHammer, IHasModel {
	private final String name;
	private final CreativeTabs tab;
	private final EnumRarity rarity;
	private final boolean hasEffect;
	private final ItemStack repairMaterial;
	private final int miningLevel;

	public ExAstrisItemHammerBase(String name, ToolMaterial material, ItemStack repairMaterial, int durability,
			float attackDamage,
			float attackSpeed, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(attackDamage, attackSpeed, material, Sets.newHashSet(new Block[] {}));
		this.name = name;
		this.tab = tab;
		this.rarity = rarity;
		this.hasEffect = hasEffect;
		this.repairMaterial = repairMaterial;
		setUnlocalizedName(ExAstris.PREFIX + this.name);
		setRegistryName(ExAstris.PREFIX + this.name);
		setCreativeTab(this.tab);
		setMaxDamage(durability);
		miningLevel = material.getHarvestLevel();
		ExAstrisItems.ITEMS.add(this);
	}

	@Override
	public boolean isHammer(ItemStack stack) {
		return true;
	}

	@Override
	public int getMiningLevel(ItemStack stack) {
		return miningLevel;
	}

	@Override
	public float getDestroySpeed(@Nullable ItemStack stack, IBlockState state) {
		if (stack == null || stack.isEmpty())
			return 1.0f;

		return stack.getItem().canHarvestBlock(state) ? this.efficiency : 1.0F;
	}

	@Override
	public boolean canHarvestBlock(IBlockState state) {
		return ExNihiloRegistryManager.HAMMER_REGISTRY.getRewards(state).stream()
				.anyMatch(it -> it.getMiningLevel() <= this.miningLevel);
	}

	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
		return stack2.isItemEqual(this.repairMaterial) || super.getIsRepairable(stack1, stack2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		ExAstris.PROXY.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack stack) {
		if (!stack.isItemEnchanted()) {
			return this.rarity;
		} else if (stack.isItemEnchanted()) {
			switch (this.rarity) {
				case COMMON:
				case UNCOMMON:
					return EnumRarity.RARE;
				case RARE:
					return EnumRarity.EPIC;
				case EPIC:
				default:
					return this.rarity;
			}
		}
		return EnumRarity.COMMON;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return this.hasEffect || stack.isItemEnchanted();
	}
}