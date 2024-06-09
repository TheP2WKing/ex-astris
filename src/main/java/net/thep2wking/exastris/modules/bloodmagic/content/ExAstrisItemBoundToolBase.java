package net.thep2wking.exastris.modules.bloodmagic.content;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import WayofTime.bloodmagic.core.data.Binding;
import WayofTime.bloodmagic.item.ItemBoundTool;
import WayofTime.bloodmagic.util.helper.TextHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.IHasModel;

public class ExAstrisItemBoundToolBase extends ItemBoundTool implements IHasModel {
	private final String name;
	private final CreativeTabs tab;
	public static final Set<Block> EFFECTIVE = new HashSet<>();

	public ExAstrisItemBoundToolBase(String name, CreativeTabs tab) {
		super(name, 0, EFFECTIVE);
		this.tab = tab;
		this.name = name;
		setUnlocalizedName(ExAstris.PREFIX + this.name);
		setRegistryName(ExAstris.PREFIX + this.name);
		setCreativeTab(this.tab);
		this.addPropertyOverride(new ResourceLocation("active"), (stack, world, entity) -> {
			return this.getActivated(stack) ? 1.0F : 0.0F;
		});
		ExAstrisItems.ITEMS.add(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		ExAstris.PROXY.registerItemRenderer(this, 0, "inventory");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState block, BlockPos pos,
			EntityLivingBase entityLiving) {
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
		if (I18n.hasKey("tooltip." + ExAstris.MODID + "." + this.getName() + ".desc"))
			tooltip.add(TextFormatting.ITALIC
					+ TextHelper.localizeEffect("tooltip." + ExAstris.MODID + "." + this.getName() + ".desc"));
		tooltip.add(TextHelper.localize(
				"tooltip.bloodmagic." + (this.getActivated(stack) ? "activated" : "deactivated"), new Object[0]));
		if (stack.hasTagCompound()) {
			Binding binding = this.getBinding(stack);
			if (binding != null) {
				tooltip.add(TextHelper.localizeEffect("tooltip.bloodmagic.currentOwner",
						new Object[] { binding.getOwnerName() }));
			}
		}
	}
}