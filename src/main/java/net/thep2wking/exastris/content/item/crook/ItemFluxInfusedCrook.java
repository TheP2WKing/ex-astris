package net.thep2wking.exastris.content.item.crook;

import cofh.redstonearsenal.init.RAEquipment;
import exnihilocreatio.items.tools.ICrook;
import exnihilocreatio.registries.manager.ExNihiloRegistryManager;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.api.ExAstrisItemToolFluxBase;

public class ItemFluxInfusedCrook extends ExAstrisItemToolFluxBase implements ICrook {
    public ItemFluxInfusedCrook(String name, CreativeTabs tab, int totalEnergy,
            int totalTransfer, int rfPerUseBase, int rfPerUseCharged, int attackDamageBase, int attackDamageCharged,
            float baseEfficiency) {
        super(name, tab, RAEquipment.toolMaterialFlux, totalEnergy, totalTransfer, rfPerUseBase, rfPerUseCharged, attackDamageBase,
                attackDamageCharged, baseEfficiency);
                this.setHarvestLevel("crook", RAEquipment.toolMaterialFlux.getHarvestLevel());
    }

    @Override
    public boolean isCrook(ItemStack stack) {
        if (isEmpowered(stack) && getEnergyStored(stack) >= energyPerUseCharged) {
            return true;
        } else if (getEnergyStored(stack) >= energyPerUse) {
            return true;
        }
        return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if (isEmpowered(stack) && getEnergyStored(stack) >= energyPerUseCharged
                && ExNihiloRegistryManager.CROOK_REGISTRY.isRegistered(state.getBlock())) {
            return efficiency;
        } else if (!isEmpowered(stack) && getEnergyStored(stack) >= energyPerUse
                && ExNihiloRegistryManager.CROOK_REGISTRY.isRegistered(state.getBlock())) {
            return efficiency / 2;
        } else if (ExNihiloRegistryManager.CROOK_REGISTRY.isRegistered(state.getBlock())) {
            return 1f;
        }
        return super.getDestroySpeed(stack, state);
    }
}