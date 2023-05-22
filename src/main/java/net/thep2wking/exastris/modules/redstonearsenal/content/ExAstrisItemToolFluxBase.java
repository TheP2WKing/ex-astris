package net.thep2wking.exastris.modules.redstonearsenal.content;

import cofh.redstonearsenal.item.tool.ItemToolFlux;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.IHasModel;

public class ExAstrisItemToolFluxBase extends ItemToolFlux implements IHasModel {
    private final String name;
    private final CreativeTabs tab;

    public ExAstrisItemToolFluxBase(String name, CreativeTabs tab, ToolMaterial toolMaterial, int totalEnergy,
            int totalTransfer, int rfPerUseBase, int rfPerUseCharged, int attackDamageBase, int attackDamageCharged,
            float baseEfficiency) {
        super(0, toolMaterial);
        this.name = name;
        this.tab = tab;
        setUnlocalizedName(ExAstris.PREFIX + this.name);
        setRegistryName(ExAstris.PREFIX + this.name);
        setCreativeTab(this.tab);
        maxEnergy = totalEnergy;
        maxTransfer = totalTransfer;
        energyPerUse = rfPerUseBase;
        energyPerUseCharged = rfPerUseCharged;
        damage = attackDamageBase;
        damageCharged = attackDamageCharged;
        efficiency = baseEfficiency;
        ExAstrisItems.ITEMS.add(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        ExAstris.PROXY.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            useEnergy(stack, false);
        }
        return false;
    }

    @Override
    protected float getEfficiency(ItemStack stack) {
        if (isEmpowered(stack) && getEnergyStored(stack) >= energyPerUseCharged) {
            return efficiency * 1.5F;
        }
        return efficiency;
    }
}