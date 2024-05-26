package net.thep2wking.exastris.util.handler;

import javax.annotation.Nullable;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.thep2wking.exastris.modules.excompressum.sieve.ContainerAutomaticSieve;
import net.thep2wking.exastris.modules.excompressum.sieve.GuiAutomaticSieve;
import net.thep2wking.exastris.modules.excompressum.sieve.TileAutomaticSieve;

public class GuiHandler implements IGuiHandler {
    public static final int EX_ASTRIS_AUTOMATIC_SIEVE_GUI = 0;

    @Nullable
    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == EX_ASTRIS_AUTOMATIC_SIEVE_GUI) {
            TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
            if (tileEntity instanceof TileAutomaticSieve) {
                return new ContainerAutomaticSieve(player.inventory, (TileAutomaticSieve) tileEntity);
            }
        }
        return null;
    }

    @Nullable
    @Override
    public GuiContainer getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == EX_ASTRIS_AUTOMATIC_SIEVE_GUI) {
            TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
            if (tileEntity instanceof TileAutomaticSieve) {
                return new GuiAutomaticSieve(player.inventory, (TileAutomaticSieve) tileEntity);
            }
        }
        return null;
    }
}