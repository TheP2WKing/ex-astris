package net.thep2wking.exastris.content.block.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.thep2wking.exastris.api.ExAstrisFluidBlockBase;

public class BlockPeacewater extends ExAstrisFluidBlockBase {
	public BlockPeacewater(String name, Fluid fluid, Material material) {
		super(name, fluid, material);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		if (entityIn instanceof EntityLivingBase) {
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 400, 0));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 2));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 0));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SPEED, 200, 0));

			((EntityLivingBase) entityIn).removePotionEffect(MobEffects.BLINDNESS);
			((EntityLivingBase) entityIn).removePotionEffect(MobEffects.SLOWNESS);
			((EntityLivingBase) entityIn).removePotionEffect(MobEffects.WITHER);
			((EntityLivingBase) entityIn).removePotionEffect(MobEffects.WEAKNESS);
		}
	}
}