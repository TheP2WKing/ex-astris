package net.thep2wking.exastris.modules.excompressum.sieve;

import java.util.Map;

import mcjty.theoneprobe.api.ElementAlignment;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.thep2wking.exastris.integration.top.ITOPInfoProvider;
import net.thep2wking.exastris.modules.excompressum.base.BlockAutomaticSieveBase;
import net.thep2wking.exastris.modules.excompressum.base.TileAutomaticSieveBase;
import net.thep2wking.exastris.util.handler.EnumToolType;

public class BlockAutomaticSieve extends BlockAutomaticSieveBase implements ITOPInfoProvider {
    public BlockAutomaticSieve(String name, CreativeTabs tab, Material material, SoundType sound, int harvestLevel,
            EnumToolType toolType, float hardness, float resistance, float lightLevel) {
        super(name, tab, material, sound, harvestLevel, toolType, hardness, resistance, lightLevel);
        GameRegistry.registerTileEntity(TileAutomaticSieve.class, new ResourceLocation(name));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata) {
        return new TileAutomaticSieve();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer,
            ItemStack stack) {
        TileAutomaticSieve tileEntity = (TileAutomaticSieve) world.getTileEntity(pos);
        if (tileEntity != null) {
            NBTTagCompound tagCompound = stack.getTagCompound();
            if (tagCompound != null) {
                if (tagCompound.hasKey("EnergyStored")) {
                    tileEntity.getEnergyStorage().setEnergyStored(tagCompound.getInteger("EnergyStored"));
                }
            }
        }
        super.onBlockPlacedBy(world, pos, state, placer, stack);
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        updateRedstoneState(world, pos);
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
        updateRedstoneState(world, pos);
    }

    private void updateRedstoneState(World world, BlockPos pos) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity instanceof TileAutomaticSieve) {
            ((TileAutomaticSieveBase) tileEntity).setDisabledByRedstone(world.isBlockPowered(pos));
        }
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
            IBlockState blockState, IProbeHitData data) {
        TileAutomaticSieve sieve = (TileAutomaticSieve) world.getTileEntity(data.getPos());
        if (sieve == null)
            return;

        if (sieve.isDisabledByRedstone()) {
            probeInfo.text(TextFormatting.RED + "{*top.exastris.disabled*}");
            return;
        }

        if (!sieve.isDisabledByRedstone()) {
            if (sieve.getMeshStack().isEmpty()) {
                probeInfo.text(TextFormatting.RED + "{*top.exastris.nomesh*}");
                return;
            }

            probeInfo.progress(Math.round(sieve.getProgress() * 100), 100,
                    probeInfo.defaultProgressStyle().suffix("%"));

            if (player.isSneaking()) {
                probeInfo.text(TextFormatting.GOLD + "{*top.exastris.energy*}" + " " + sieve.getEffectiveEnergy() + " FE");
                probeInfo.text(TextFormatting.GOLD + "{*top.exastris.speed*}" + " " + String.format("%.3f", sieve.getEffectiveSpeed()));
                probeInfo.text(TextFormatting.GOLD + "{*top.exastris.luck*}" + " " + String.format("%.3f", sieve.getEffectiveLuck()));
            }

            if (!sieve.getMeshStack().isEmpty()) {
                probeInfo.horizontal(probeInfo.defaultLayoutStyle().alignment(ElementAlignment.ALIGN_CENTER))
                        .item(sieve.getMeshStack())
                        .text(TextFormatting.GREEN + " " + IProbeInfo.STARTLOC
                                + sieve.getMeshStack().getUnlocalizedName()
                                + ".name"
                                + IProbeInfo.ENDLOC);
            }

            if (mode == ProbeMode.EXTENDED) {
                Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(sieve.getMeshStack());
                for (Map.Entry<Enchantment, Integer> enchantment : enchantments.entrySet()) {
                    probeInfo
                            .text(TextFormatting.BLUE + enchantment.getKey().getTranslatedName(enchantment.getValue()));
                }
            }
        }
    }
}
