package net.thep2wking.exastris.content.item.crook;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.thep2wking.exastris.api.ExAstrisItemCrookBase;
import thaumcraft.api.items.IWarpingGear;

public class ItemVoidCrook extends ExAstrisItemCrookBase implements IWarpingGear {
	public ItemVoidCrook(String name, ToolMaterial material, ItemStack repairMaterial, int durability,
			float attackDamage, float attackSpeed, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(name, material, repairMaterial, durability, attackDamage, attackSpeed, tab, rarity, hasEffect);
	}

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, world, entity, itemSlot, isSelected);
		if (stack.isItemDamaged() && entity != null && entity.ticksExisted % 20 == 0
				&& entity instanceof EntityLivingBase) {
			stack.damageItem(-1, (EntityLivingBase) entity);
		}
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (!player.world.isRemote && entity instanceof EntityLivingBase) {
			if (!(entity instanceof EntityPlayer)
					|| FMLCommonHandler.instance().getMinecraftServerInstance().isPVPEnabled()) {
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 80));
			}
		}
		return super.onLeftClickEntity(stack, player, entity);
	}

	@Override
	public int getWarp(ItemStack arg0, EntityPlayer arg1) {
		return 1;
	}
}