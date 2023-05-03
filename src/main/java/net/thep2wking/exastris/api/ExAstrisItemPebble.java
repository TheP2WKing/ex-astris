package net.thep2wking.exastris.api;

import javax.annotation.Nonnull;

import exnihilocreatio.entities.ProjectileStone;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ExAstrisItemPebble extends ExAstrisItemBase {
    public ExAstrisItemPebble(String groupName, CreativeTabs tab, EnumRarity rarity, boolean hasEffect,
            int tooltipLines) {
        super(groupName, tab, rarity, hasEffect, tooltipLines);
    }

    @Override
    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);
        stack.shrink(1);
        world.playSound(player, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW,
                SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote) {
            ItemStack thrown = stack.copy();
            thrown.setCount(1);

            ProjectileStone projectile = new ProjectileStone(world, player);
            projectile.setStack(thrown);
            projectile.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 0.5F);
            world.spawnEntity(projectile);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
    }
}