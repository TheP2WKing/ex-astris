package net.thep2wking.exastris.util.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.thep2wking.exastris.modules.excompressum.content.hammerer.ContainerAutomaticHammerer;
import net.thep2wking.exastris.modules.excompressum.content.hammerer.GuiAutomaticHammerer;
import net.thep2wking.exastris.modules.excompressum.content.hammerer.TileAutomaticHammerer;
import net.thep2wking.exastris.modules.excompressum.content.sieve.ContainerAutomaticSieve;
import net.thep2wking.exastris.modules.excompressum.content.sieve.GuiAutomaticSieve;
import net.thep2wking.exastris.modules.excompressum.content.sieve.TileAutomaticSieve;

public class GuiHandler implements IGuiHandler {
    public static final int EX_ASTRIS_AUTOMATIC_SIEVE_GUI = 0;
    public static final int EX_ASTRIS_AUTOMATIC_HAMMERER_GUI = 1;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if (ID == EX_ASTRIS_AUTOMATIC_SIEVE_GUI) {
            if (tileEntity instanceof TileAutomaticSieve) {
                return new ContainerAutomaticSieve(player.inventory, (TileAutomaticSieve) tileEntity);
            }
        } else if (ID == EX_ASTRIS_AUTOMATIC_HAMMERER_GUI) {
            if (tileEntity instanceof TileAutomaticHammerer) {
                return new ContainerAutomaticHammerer(player.inventory, (TileAutomaticHammerer) tileEntity);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
        if (ID == EX_ASTRIS_AUTOMATIC_SIEVE_GUI) {
            if (tileEntity instanceof TileAutomaticSieve) {
                return new GuiAutomaticSieve(player.inventory, (TileAutomaticSieve) tileEntity);
            }
        } else if (ID == EX_ASTRIS_AUTOMATIC_HAMMERER_GUI) {
            if (tileEntity instanceof TileAutomaticHammerer) {
                return new GuiAutomaticHammerer(player.inventory, (TileAutomaticHammerer) tileEntity);
            }
        }
        return null;
    }
}