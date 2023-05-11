package net.thep2wking.exastris.content.block.crucible;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.collect.Lists;

import exnihilocreatio.blocks.BlockCrucibleBase;
import exnihilocreatio.blocks.BlockCrucibleWood;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.util.handler.EnumToolType;
import net.thep2wking.exastris.util.handler.IHasModel;

public class BlockExAstrisWoodCrucible extends BlockCrucibleWood implements IHasModel {
	private final String groupName;
	private final CreativeTabs tab;
	private final SoundType sound;
	private final int harvestLevel;
	private final EnumToolType toolType;
	private final float hardness;
	private final float resistance;
	private final float lightLevel;

	private static final AxisAlignedBB FEET1 = new AxisAlignedBB(0, 0, 0, 0.125, 0.188, 0.25);
	private static final AxisAlignedBB FEET2 = new AxisAlignedBB(0.125, 0, 0, 0.25, 0.188, 0.125);
	private static final AxisAlignedBB FEET3 = new AxisAlignedBB(0.875, 0, 0, 1, 0.188, 0.25);
	private static final AxisAlignedBB FEET4 = new AxisAlignedBB(0.75, 0, 0, 0.875, 0.188, 0.125);
	private static final AxisAlignedBB FEET5 = new AxisAlignedBB(0, 0, 0.75, 0.125, 0.188, 1);
	private static final AxisAlignedBB FEET6 = new AxisAlignedBB(0.125, 0, 0.875, 0.25, 0.188, 1);
	private static final AxisAlignedBB FEET7 = new AxisAlignedBB(0.875, 0, 0.75, 1, 0.188, 1);
	private static final AxisAlignedBB FEET8 = new AxisAlignedBB(0.75, 0, 0.875, 0.875, 0.188, 1);
	private static final AxisAlignedBB MAIN = new AxisAlignedBB(0, 0.188, 0, 1, 1, 1);

	private static final List<AxisAlignedBB> COLLISION_BOXES = Lists.newArrayList(FEET1, FEET2, FEET3, FEET4, FEET5,
			FEET6, FEET7, FEET8, MAIN);
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0, 0, 0, 1, 1, 1);

	private static final Int2ObjectMap<EnumExAstrisWoodCricible> EXASTRIS_WOOD_CRUCIBLE_TYPES = new Int2ObjectArrayMap<>();

	public static final PropertyEnum<EnumExAstrisWoodCricible> VARIANT = PropertyEnum.create("variant",
			EnumExAstrisWoodCricible.class);

	public BlockExAstrisWoodCrucible(String groupName, CreativeTabs tab, Material material, SoundType sound,
			int harvestLevel, EnumToolType toolType, float hardness, float resistance, float lightLevel) {
		this.groupName = groupName;
		this.tab = tab;
		this.sound = sound;
		this.harvestLevel = harvestLevel;
		this.toolType = toolType;
		this.hardness = hardness;
		this.resistance = resistance;
		this.lightLevel = lightLevel;
		setUnlocalizedName(ExAstris.PREFIX + this.groupName);
		setSoundType(this.sound);
		setHarvestLevel(this.toolType.getToolType(), this.harvestLevel);
		setHardness(this.hardness);
		setResistance(this.resistance);
		setLightLevel(this.lightLevel);
		setCreativeTab(this.tab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(THIN, false).withProperty(VARIANT,
				EnumExAstrisWoodCricible.OAK));
		ExAstrisBlocks.BLOCKS.add(this);

		if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
			ExAstris.LOGGER.info("This is an intended overwrite, overwriting the default Ex Nihilo Wooden Crucible");
		}

		EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.OAK.meta, EnumExAstrisWoodCricible.OAK);
		EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.SPRUCE.meta, EnumExAstrisWoodCricible.SPRUCE);
		EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.BIRCH.meta, EnumExAstrisWoodCricible.BIRCH);
		EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.JUNGLE.meta, EnumExAstrisWoodCricible.JUNGLE);
		EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.ACACIA.meta, EnumExAstrisWoodCricible.ACACIA);
		EXASTRIS_WOOD_CRUCIBLE_TYPES.put(EnumExAstrisWoodCricible.DARK_OAK.meta, EnumExAstrisWoodCricible.DARK_OAK);
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
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
		for (EnumExAstrisWoodCricible type : EXASTRIS_WOOD_CRUCIBLE_TYPES.values()) {
			items.add(new ItemStack(this, 1, type.meta));
		}
	}

	@Override
	@Nonnull
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { VARIANT, BlockCrucibleBase.THIN });
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		EnumExAstrisWoodCricible type = (EnumExAstrisWoodCricible) state.getValue(VARIANT);
		return type.meta;
	}

	@Override
	@SuppressWarnings("null")
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(VARIANT, EnumExAstrisWoodCricible.values()[meta]);
	}

	@Override
	@SuppressWarnings("null")
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		for (EnumExAstrisWoodCricible type : EnumExAstrisWoodCricible.values()) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.meta,
					new ModelResourceLocation(ExAstris.PREFIX + this.groupName + "_" + type.getName(),
							"inventory"));
			ModelLoader.setCustomStateMapper(this, new DefaultStateMapper());
		}
	}

	public String getGroupName() {
		return this.groupName;
	}
}
