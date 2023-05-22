package net.thep2wking.exastris.content.item.doll;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import exnihilocreatio.ModFluids;
import exnihilocreatio.items.ItemDoll;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.ExAstrisConstants;
import net.thep2wking.exastris.util.handler.ExAstrisUtils;
import net.thep2wking.exastris.util.handler.IHasModel;

public class ItemExAstrisDoll extends ItemDoll implements IHasModel {
    private final String groupName;
    private final CreativeTabs tab;
    private final EnumRarity rarity;
    private final boolean hasEffect;

    private static final Int2ObjectMap<EnumExAstrisDollType> EXASTRIS_DOLL_TYPES = new Int2ObjectArrayMap<>();

    public ItemExAstrisDoll(String groupName, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
        this.groupName = groupName;
        this.tab = tab;
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        setUnlocalizedName(ExAstris.PREFIX + this.groupName);
        setCreativeTab(this.tab);
        setHasSubtypes(true);
        ExAstrisItems.ITEMS.add(this);

        EXASTRIS_DOLL_TYPES.put(EnumExAstrisDollType.VILLAGER.meta, EnumExAstrisDollType.VILLAGER);
        EXASTRIS_DOLL_TYPES.put(EnumExAstrisDollType.EVOKER.meta, EnumExAstrisDollType.EVOKER);

        if (Loader.isModLoaded(ExAstrisConstants.MODID_THAUMCRAFT)) {
            EXASTRIS_DOLL_TYPES.put(EnumExAstrisDollType.PECH_FORAGER.meta, EnumExAstrisDollType.PECH_FORAGER);
            EXASTRIS_DOLL_TYPES.put(EnumExAstrisDollType.CRIMSON_CLERIC.meta, EnumExAstrisDollType.CRIMSON_CLERIC);
        }
    }

    @Override
    public Fluid getSpawnFluid(ItemStack stack) {
        Fluid fluid = FluidRegistry.getFluid(EXASTRIS_DOLL_TYPES.get(stack.getMetadata()).fluidName);
        if (fluid != null)
            return fluid;
        else
            return ModFluids.fluidWitchwater;
    }

    @Override
    @SuppressWarnings("all")
    public boolean spawnMob(ItemStack stack, World world, BlockPos pos) {
        EnumExAstrisDollType type = EXASTRIS_DOLL_TYPES.get(stack.getMetadata());
        if (type == null)
            return false;
        if (type.name == type.VILLAGER.name) {
            Entity spawnee = new EntityVillager(world, ExAstrisUtils.randomNumberRange(0, 5));
            if (spawnee != null) {
                spawnee.setPosition(pos.getX(), pos.getY() + type.posYCorrection, pos.getZ());
                return world.spawnEntity(spawnee);
            }
        }
        Entity spawnee = EntityList.createEntityByIDFromName(new ResourceLocation(type.entityName), world);
        if (spawnee != null) {
            spawnee.setPosition(pos.getX(), pos.getY() + type.posYCorrection, pos.getZ());
            return world.spawnEntity(spawnee);
        } else {
            return false;
        }
    }

    @Override
    @SuppressWarnings("all")
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + ExAstris.PREFIX + groupName + "_" + EnumExAstrisDollType.getByMeta(stack.getMetadata()).name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nullable CreativeTabs tab, @Nonnull NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab))
            for (EnumExAstrisDollType type : EXASTRIS_DOLL_TYPES.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (EnumExAstrisDollType type : EnumExAstrisDollType.values()) {
            ModelLoader.setCustomModelResourceLocation(this, type.meta,
                    new ModelResourceLocation(ExAstris.PREFIX + groupName + "_" + type.name,
                            "inventory"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        if (!stack.isItemEnchanted()) {
            return this.rarity;
        } else if (stack.isItemEnchanted()) {
            switch (this.rarity) {
                case COMMON:
                case UNCOMMON:
                    return EnumRarity.RARE;
                case RARE:
                    return EnumRarity.EPIC;
                case EPIC:
                default:
                    return this.rarity;
            }
        }
        return EnumRarity.COMMON;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack) {
        return this.hasEffect || stack.isItemEnchanted();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (EXASTRIS_DOLL_TYPES.containsKey(stack.getMetadata())) {
            tooltip.add(I18n.format("item." + ExAstris.PREFIX + groupName + "_"
                    + EnumExAstrisDollType.getByMeta(stack.getMetadata()).name + ".tip"));
        } else {
            tooltip.add(I18n.format("debug.mod_not_installed.desc", DollType.getByMeta(stack.getMetadata()).modid));
        }
    }
}
