package net.thep2wking.exastris.util.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.thep2wking.exastris.modules.excompressum.base.TileAutomaticHammererBase;
import net.thep2wking.exastris.modules.excompressum.base.TileAutomaticSieveBase;
import net.thep2wking.exastris.modules.excompressum.content.hammerer.ContainerAutomaticHammerer;
import net.thep2wking.exastris.modules.excompressum.content.hammerer.GuiAutomaticHammerer;
import net.thep2wking.exastris.modules.excompressum.content.sieve.ContainerAutomaticSieve;
import net.thep2wking.exastris.modules.excompressum.content.sieve.GuiAutomaticSieve;

public class GuiHandler implements IGuiHandler {
    public static final int EX_ASTRIS_AUTOMATIC_SIEVE_GUI = 0;
    public static final int EX_ASTRIS_AUTOMATIC_HAMMERER_GUI = 1;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        switch (id) {
            case EX_ASTRIS_AUTOMATIC_SIEVE_GUI:
                if (tileEntity instanceof TileAutomaticSieveBase) {
                    return new ContainerAutomaticSieve(player.inventory, (TileAutomaticSieveBase) tileEntity);
                }
                break;
            case EX_ASTRIS_AUTOMATIC_HAMMERER_GUI:
                if (tileEntity instanceof TileAutomaticHammererBase) {
                    return new ContainerAutomaticHammerer(player.inventory, (TileAutomaticHammererBase) tileEntity);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        switch (id) {
            case EX_ASTRIS_AUTOMATIC_SIEVE_GUI:
                if (tileEntity instanceof TileAutomaticSieveBase) {
                    return new GuiAutomaticSieve(player.inventory, (TileAutomaticSieveBase) tileEntity);
                }
                break;
            case EX_ASTRIS_AUTOMATIC_HAMMERER_GUI:
                if (tileEntity instanceof TileAutomaticHammererBase) {
                    return new GuiAutomaticHammerer(player.inventory, (TileAutomaticHammererBase) tileEntity);
                }
                break;
        }
        return null;
    }
}