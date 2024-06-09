package net.thep2wking.exastris.modules.bloodmagic.content;

import com.google.common.collect.Multimap;

import WayofTime.bloodmagic.core.data.SoulTicket;
import WayofTime.bloodmagic.util.helper.NetworkHelper;
import exnihilocreatio.items.tools.ICrook;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBoundCrook extends ExAstrisItemBoundToolBase implements ICrook {
	public ItemBoundCrook(String name, CreativeTabs tab) {
		super(name, tab);
	}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		if (!this.getActivated(stack)) {
			return 1.0F;
		} else if (ExNihiloRegistryManager.CROOK_REGISTRY.isRegistered(state.getBlock())) {
			return this.efficiency;
		} else if (!ExNihiloRegistryManager.CROOK_REGISTRY.isRegistered(state.getBlock())) {
			return 1.0F;
		}
		return super.getDestroySpeed(stack, state);
	}

	@Override
	public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
		if (this.getActivated(stack)) {
			return ExNihiloRegistryManager.CROOK_REGISTRY.isRegistered(state);
		} else {
			return super.canHarvestBlock(state, stack);
		}
	}

	@SuppressWarnings("unused")
	@Override
	protected void onBoundRelease(ItemStack stack, World world, EntityPlayer player, int charge) {
		if (!world.isRemote) {
			int fortuneLvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
			boolean silkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0;
			int range = charge / 6;
			BlockPos playerPos = player.getPosition();
			for (int i = -range; i <= range; ++i) {
				for (int j = 0; j <= 2 * range; ++j) {
					for (int k = -range; k <= range; ++k) {
						BlockPos blockPos = playerPos.add(i, j, k);
						IBlockState blockState = world.getBlockState(blockPos);
						// if (!world.isAirBlock(blockPos) && (blockState.getMaterial() == Material.ROCK
						// 		|| ExNihiloRegistryManager.HAMMER_REGISTRY.isRegistered(blockState.getBlock()))) {
						// 	BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, blockPos, blockState,
						// 			player);
						// 	if (!MinecraftForge.EVENT_BUS.post(event) && event.getResult() != Result.DENY) {
						// 		this.sharedHarvest(stack, world, player, blockPos, blockState, silkTouch, fortuneLvl);
						// 	}
						// }
					}
				}
			}
			NetworkHelper.getSoulNetwork(player).syphonAndDamage(player,
					SoulTicket.item(stack, world, player, (int) ((double) (charge * charge * charge) / 2.7)));
			world.createExplosion(player, (double) playerPos.getX(), (double) playerPos.getY(),
					(double) playerPos.getZ(), 0.5F, false);
		}
	}

	@Override
	public boolean isCrook(ItemStack stack) {
		if (this.getActivated(stack)) {
			return true;
		}
		return false;
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot equipmentSlot,
			ItemStack stack) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER,
					"Weapon modifier", this.getActivated(stack) ? 3.0 : 1.0, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
					new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", 0, 0));
		}
		return multimap;
	}
}