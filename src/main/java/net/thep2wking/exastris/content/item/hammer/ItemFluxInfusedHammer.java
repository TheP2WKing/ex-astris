package net.thep2wking.exastris.content.item.hammer;

import cofh.redstonearsenal.init.RAEquipment;
import exnihilocreatio.items.tools.IHammer;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.api.ExAstrisItemFluxBase;

public class ItemFluxInfusedHammer extends ExAstrisItemFluxBase implements IHammer {
    public ItemFluxInfusedHammer(String name, CreativeTabs tab, int totalEnergy,
            int totalTransfer, int rfPerUseBase, int rfPerUseCharged, int attackDamageBase, int attackDamageCharged,
            float baseEfficiency) {
        super(name, tab, RAEquipment.toolMaterialFlux, totalEnergy, totalTransfer, rfPerUseBase, rfPerUseCharged, attackDamageBase,
                attackDamageCharged, baseEfficiency);
    }

    @Override
    public boolean isHammer(ItemStack stack) {
        if (isEmpowered(stack) && getEnergyStored(stack) >= energyPerUseCharged) {
            return true;
        } else if (getEnergyStored(stack) >= energyPerUse) {
            return true;
        }
        return false;
    }

    @Override
    public int getMiningLevel(ItemStack stack) {
        return toolMaterial.getHarvestLevel();
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if (isEmpowered(stack) && getEnergyStored(stack) >= energyPerUseCharged
                && ExNihiloRegistryManager.HAMMER_REGISTRY.isRegistered(state.getBlock())) {
            return efficiency;
        } else if (!isEmpowered(stack) && getEnergyStored(stack) >= energyPerUse
                && ExNihiloRegistryManager.HAMMER_REGISTRY.isRegistered(state.getBlock())) {
            return efficiency / 2;
        } else if (ExNihiloRegistryManager.HAMMER_REGISTRY.isRegistered(state.getBlock())) {
            return 1f;
        }
        return super.getDestroySpeed(stack, state);
    }

    @Override
    public boolean canHarvestBlock(IBlockState state) {
        return ExNihiloRegistryManager.HAMMER_REGISTRY.isRegistered(state);
    }
}