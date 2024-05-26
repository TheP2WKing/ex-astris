package net.thep2wking.exastris.modules.excompressum.base;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.util.handler.EnumToolType;
import net.thep2wking.exastris.util.handler.GuiHandler;
import net.thep2wking.exastris.util.handler.IHasModel;

public abstract class BlockAutomaticSieveBase extends BlockContainer implements IHasModel {
    private final String name;
    private final CreativeTabs tab;
    private final SoundType sound;
    private final int harvestLevel;
    private final EnumToolType toolType;
    private final float hardness;
    private final float resistance;
    private final float lightLevel;

    private static final AxisAlignedBB POLE1 = new AxisAlignedBB(0.062, 0, 0.062, 0.125, 0.688, 0.125);
    private static final AxisAlignedBB POLE2 = new AxisAlignedBB(0.875, 0, 0.062, 0.938, 0.688, 0.125);
    private static final AxisAlignedBB POLE3 = new AxisAlignedBB(0.875, 0, 0.875, 0.938, 0.688, 0.938);
    private static final AxisAlignedBB POLE4 = new AxisAlignedBB(0.062, 0, 0.875, 0.125, 0.688, 0.938);
    private static final AxisAlignedBB SIEVE = new AxisAlignedBB(0, 0.625, 0, 1, 1, 1);

    private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(POLE1, POLE2, POLE3, POLE4, SIEVE);
    private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1);

    public BlockAutomaticSieveBase(String name, CreativeTabs tab, Material material, SoundType sound, int harvestLevel,
            EnumToolType toolType, float hardness, float resistance, float lightLevel) {
        super(material);
        this.name = name;
        this.tab = tab;
        this.sound = sound;
        this.harvestLevel = harvestLevel;
        this.toolType = toolType;
        this.hardness = hardness;
        this.resistance = resistance;
        this.lightLevel = lightLevel;
        setUnlocalizedName(ExAstris.PREFIX + this.name);
        setRegistryName(ExAstris.PREFIX + this.name);
        setSoundType(this.sound);
        setHarvestLevel(this.toolType.getToolType(), this.harvestLevel);
        setHardness(this.hardness);
        setResistance(this.resistance);
        setLightLevel(this.lightLevel);
        setCreativeTab(this.tab);
        ExAstrisBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {
        ExAstris.PROXY.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDING_BOX;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World world, BlockPos pos, AxisAlignedBB entityBox,
            List<AxisAlignedBB> collidingBoxes, @Nullable Entity entity, boolean isActualState) {
        entityBox = entityBox.offset(-pos.getX(), -pos.getY(), -pos.getZ());
        for (AxisAlignedBB box : COLLISION_BOXES) {
            if (entityBox.intersects(box))
                collidingBoxes.add(box.offset(pos));
        }
    }

    @Override
    @Nullable
    public RayTraceResult collisionRayTrace(IBlockState state, World world, BlockPos pos, Vec3d start, Vec3d end) {
        double distanceSq;
        double distanceSqShortest = Double.POSITIVE_INFINITY;
        RayTraceResult resultClosest = null;
        RayTraceResult result;
        start = start.subtract(pos.getX(), pos.getY(), pos.getZ());
        end = end.subtract(pos.getX(), pos.getY(), pos.getZ());
        for (AxisAlignedBB box : COLLISION_BOXES) {
            result = box.calculateIntercept(start, end);
            if (result == null)
                continue;
            distanceSq = result.hitVec.squareDistanceTo(start);
            if (distanceSq < distanceSqShortest) {
                distanceSqShortest = distanceSq;
                resultClosest = result;
            }
        }
        return resultClosest == null ? null
                : new RayTraceResult(RayTraceResult.Type.BLOCK,
                        resultClosest.hitVec.addVector(pos.getX(), pos.getY(), pos.getZ()), resultClosest.sideHit, pos);
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (!player.isSneaking()) {
                player.openGui(ExAstris.INSTANCE, GuiHandler.EX_ASTRIS_AUTOMATIC_SIEVE_GUI, world, pos.getX(), pos.getY(),
                        pos.getZ());
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntity tileEntity = world.getTileEntity(pos);
        if (tileEntity != null) {
            IItemHandler itemHandler = ((TileAutomaticSieveBase) tileEntity).getItemHandler();
            for (int i = 0; i < itemHandler.getSlots(); i++) {
                ItemStack itemStack = itemHandler.getStackInSlot(i);
                if (!itemStack.isEmpty()) {
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), itemStack);
                    double motion = 0.05;
                    entityItem.motionX = world.rand.nextGaussian() * motion;
                    entityItem.motionY = 0.2;
                    entityItem.motionZ = world.rand.nextGaussian() * motion;
                    world.spawnEntity(entityItem);
                }
            }
            ItemStack currentStack = ((TileAutomaticSieveBase) tileEntity).getCurrentStack();
            if (!currentStack.isEmpty()) {
                EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), currentStack);
                double motion = 0.05;
                entityItem.motionX = world.rand.nextGaussian() * motion;
                entityItem.motionY = 0.2;
                entityItem.motionZ = world.rand.nextGaussian() * motion;
                world.spawnEntity(entityItem);
            }
        }
        super.breakBlock(world, pos, state);
    }

    @Override
    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World world, BlockPos pos) {
        TileEntity tileEntity = world.getTileEntity(pos);
        return tileEntity != null ? ItemHandlerHelper.calcRedstoneFromInventory(
                tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) : 0;
    }
}