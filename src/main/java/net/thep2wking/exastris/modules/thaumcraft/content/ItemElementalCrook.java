package net.thep2wking.exastris.modules.thaumcraft.content;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.thep2wking.exastris.api.ExAstrisItemCrookBase;
import thaumcraft.client.fx.FXDispatcher;
import thaumcraft.common.lib.enchantment.EnumInfusionEnchantment;
import thaumcraft.common.lib.utils.EntityUtils;

public class ItemElementalCrook extends ExAstrisItemCrookBase {
	public ItemElementalCrook(String name, ToolMaterial material, ItemStack repairMaterial, int durability,
			float attackDamage, float attackSpeed, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(name, material, repairMaterial, durability, attackDamage, attackSpeed, tab, rarity, hasEffect);
	}

	@Override
	@SuppressWarnings("all")
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand) {
		playerIn.setActiveHand(hand);
		return (ActionResult<ItemStack>) new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.BOW;
    }
    
    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 72000;
    }
    
    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
        List<EntityItem> stuff = EntityUtils.getEntitiesInRange(player.world, player.posX, player.posY, player.posZ, player, EntityItem.class, 10.0);
        if (stuff != null && stuff.size() > 0) {
            for (EntityItem e : stuff) {
                if (!e.isDead) {
                    double d6 = e.posX - player.posX;
                    double d7 = e.posY - player.posY + player.height / 2.0f;
                    double d8 = e.posZ - player.posZ;
                    double d9 = MathHelper.sqrt(d6 * d6 + d7 * d7 + d8 * d8);
                    d6 /= d9;
                    d7 /= d9;
                    d8 /= d9;
                    double d10 = 0.3;
                    EntityItem entityItem = e;
                    entityItem.motionX -= d6 * d10;
                    EntityItem entityItem2 = e;
                    entityItem2.motionY -= d7 * d10 - 0.1;
                    EntityItem entityItem3 = e;
                    entityItem3.motionZ -= d8 * d10;
                    if (e.motionX > 0.25) {
                        e.motionX = 0.25;
                    }
                    if (e.motionX < -0.25) {
                        e.motionX = -0.25;
                    }
                    if (e.motionY > 0.25) {
                        e.motionY = 0.25;
                    }
                    if (e.motionY < -0.25) {
                        e.motionY = -0.25;
                    }
                    if (e.motionZ > 0.25) {
                        e.motionZ = 0.25;
                    }
                    if (e.motionZ < -0.25) {
                        e.motionZ = -0.25;
                    }
                    if (!player.world.isRemote) {
                        continue;
                    }
                    FXDispatcher.INSTANCE.crucibleBubble((float)e.posX + (player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.2f, (float)e.posY + e.height + (player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.2f, (float)e.posZ + (player.world.rand.nextFloat() - player.world.rand.nextFloat()) * 0.2f, 0.33f, 0.33f, 1.0f);
                }
            }
        }
    }

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (tab == this.getCreativeTab() || tab == CreativeTabs.SEARCH) {
			ItemStack w1 = new ItemStack(this);
			EnumInfusionEnchantment.addInfusionEnchantment(w1, EnumInfusionEnchantment.COLLECTOR, 1);
			items.add(w1);
		} else {
			super.getSubItems(tab, items);
		}
	}
}