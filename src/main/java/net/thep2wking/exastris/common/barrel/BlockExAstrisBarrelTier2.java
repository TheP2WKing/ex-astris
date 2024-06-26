package net.thep2wking.exastris.common.barrel;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import org.apache.commons.lang3.StringUtils;

import exnihilocreatio.barrel.IBarrelMode;
import exnihilocreatio.blocks.BlockBarrel;
import exnihilocreatio.tiles.TileBarrel;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;
import net.thep2wking.exastris.init.ExAstrisBlocks;
import net.thep2wking.exastris.util.ExAstrisConstants;
import net.thep2wking.exastris.util.handler.EnumToolType;
import net.thep2wking.exastris.util.handler.IHasModel;

public class BlockExAstrisBarrelTier2 extends BlockBarrel implements IHasModel {
    private final String groupName;
    private final CreativeTabs tab;
    private final SoundType sound;
    private final int harvestLevel;
    private final EnumToolType toolType;
    private final float hardness;
    private final float resistance;
    private final float lightLevel;

    private static final Int2ObjectMap<EnumExAstrisBarrelTier2> EXASTRIS_BARREL_T2_TYPES = new Int2ObjectArrayMap<>();

    public static final PropertyEnum<EnumExAstrisBarrelTier2> VARIANT = PropertyEnum.create("variant",
            EnumExAstrisBarrelTier2.class);

    public BlockExAstrisBarrelTier2(String groupName, CreativeTabs tab, Material material, SoundType sound,
            int harvestLevel,
            EnumToolType toolType, float hardness, float resistance, float lightLevel) {
        super(2, material);
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
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumExAstrisBarrelTier2.IRON));
        ExAstrisBlocks.BLOCKS.add(this);

        if (ExAstrisConfig.GENEREL.ENABLE_LOGGING) {
            ExAstris.LOGGER.info(BlockExAstrisBarrelTier2.class.getName()
                    + " is an intended overwrite, overwriting the default Ex Nihilo Barrel");
        }

        EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.IRON.meta, EnumExAstrisBarrelTier2.IRON);
        EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.GOLD.meta, EnumExAstrisBarrelTier2.GOLD);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.ALCHEMICAL_BRASS.meta, EnumExAstrisBarrelTier2.ALCHEMICAL_BRASS);
            EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.THAUMIUM.meta, EnumExAstrisBarrelTier2.THAUMIUM);
            EXASTRIS_BARREL_T2_TYPES.put(EnumExAstrisBarrelTier2.VOID_METAL.meta, EnumExAstrisBarrelTier2.VOID_METAL);
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
        for (EnumExAstrisBarrelTier2 type : EXASTRIS_BARREL_T2_TYPES.values()) {
            items.add(new ItemStack(this, 1, type.meta));
        }
    }

    @Override
    @Nonnull
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { VARIANT });
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        EnumExAstrisBarrelTier2 type = (EnumExAstrisBarrelTier2) state.getValue(VARIANT);
        return type.meta;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, EnumExAstrisBarrelTier2.values()[meta]);
    }

    @Override
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
        for (EnumExAstrisBarrelTier2 type : EnumExAstrisBarrelTier2.values()) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), type.meta,
                    new ModelResourceLocation(ExAstris.PREFIX + this.groupName + "_" + type.getName(),
                            "inventory"));
            ModelLoader.setCustomStateMapper(this, new DefaultStateMapper());
        }
    }

    public String getGroupName() {
        return this.groupName;
    }

    @Override
    public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world,
            IBlockState blockState, IProbeHitData data) {
        TileBarrel barrel = (TileBarrel) world.getTileEntity(data.getPos());
        if (barrel == null)
            return;

        probeInfo.text(TextFormatting.GREEN + "Tier: Stone");

        IBarrelMode barrelMode = barrel.getMode();
        if (barrelMode != null) {
            probeInfo.text(TextFormatting.GREEN + "Mode: " + StringUtils.capitalize(barrel.getMode().getName()));
            List<String> tooltips = barrelMode.getWailaTooltip(barrel, new ArrayList<>());
            for (String tooltip : tooltips) {
                probeInfo.text(tooltip);
            }
        }
    }
}