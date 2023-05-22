package net.thep2wking.exastris.modules.vanilla.content;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.thep2wking.exastris.config.ExAstrisConfig;

public class TileFrostyDirt extends TileEntity implements ITickable {
    private int timer;
    private int volume;
    private static final int UPDATE_INTERVAL = ExAstrisConfig.GENEREL.BLOCK_TRANSFORMATION_TIME / 5;

    public TileFrostyDirt() {
        super();
        timer = 0;
    }

    @Override
    public void update() {
        if (ExAstrisConfig.MODULE_VANILLA.BLOCK_TRANSFORMATION.SNOW_FROM_FROSTY_DIRT) {
            timer++;
            if (timer > UPDATE_INTERVAL) {
                timer = 0;
                volume += 1;
                world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), UPDATE_INTERVAL);
            }

            if (volume > 100) {
                world.setBlockState(pos, Blocks.SNOW.getDefaultState());
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.volume = compound.getInteger("volume");
        this.timer = compound.getInteger("timer");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("volume", this.volume);
        compound.setInteger("timer", this.timer);
        return compound;
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound tag = pkt.getNbtCompound();
        this.readFromNBT(tag);
    }

    public int getVolume() {
        return this.volume;
    }

    public int getTimer() {
        return this.timer;
    }
}