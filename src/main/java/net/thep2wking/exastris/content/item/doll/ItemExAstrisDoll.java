package net.thep2wking.exastris.content.item.doll;

import java.util.List;
import java.util.Locale;
import java.util.Random;

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
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.init.ExAstrisItems;
import net.thep2wking.exastris.util.handler.IHasModel;

public class ItemExAstrisDoll extends ItemDoll implements IHasModel {
    private final String groupName;
    private final CreativeTabs tab;
    private final EnumRarity rarity;
    private final boolean hasEffect;

    private static final Int2ObjectMap<DollTypeExAstris> exAstrisTypes = new Int2ObjectArrayMap<>();

    public ItemExAstrisDoll(String groupName, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
        this.groupName = groupName;
        this.tab = tab;
        this.rarity = rarity;
        this.hasEffect = hasEffect;
        setUnlocalizedName(ExAstris.PREFIX + this.groupName);
        // setRegistryName(ExAstris.PREFIX + this.name);
        setCreativeTab(this.tab);
        setHasSubtypes(true);

        exAstrisTypes.put(DollTypeExAstris.VILLAGER.meta, DollTypeExAstris.VILLAGER);
        exAstrisTypes.put(DollTypeExAstris.EVOKER.meta, DollTypeExAstris.EVOKER);

        ExAstrisItems.ITEMS.add(this);
    }

    @Override
    public Fluid getSpawnFluid(ItemStack stack) {
        Fluid fluid = FluidRegistry.getFluid(exAstrisTypes.get(stack.getMetadata()).fluidname);
        if (fluid != null)
            return fluid;
        else
            return ModFluids.fluidWitchwater;
    }

    @Override
    public boolean spawnMob(ItemStack stack, World world, BlockPos pos) {
        DollTypeExAstris type = exAstrisTypes.get(stack.getMetadata());
        if (type == null)
            return false;

        if (type.name == "villager") {
            Random rand = new Random();
            int min = 0;
            int max = 5;
            int randomNum = rand.nextInt((max - min) + 1) + min;
            Entity spawnee = new EntityVillager(world, randomNum);
            spawnee.setPosition(pos.getX(), pos.getY() + type.posYCorrection, pos.getZ());
            return world.spawnEntity(spawnee);
        } else if (type.name == "evoker"){
            Entity spawnee = new EntityEvoker(world);
            spawnee.setPosition(pos.getX(), pos.getY() + type.posYCorrection, pos.getZ());
            return world.spawnEntity(spawnee);
        } else {
            return false;
        }
    }

    @Override
    @SuppressWarnings("all")
    public String getUnlocalizedName(ItemStack stack) {
        return "item." + ExAstris.PREFIX + groupName + "_" + DollTypeExAstris.getByMeta(stack.getMetadata()).name;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(@Nullable CreativeTabs tab, @Nonnull NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab))
            for (DollTypeExAstris type : exAstrisTypes.values()) {
                list.add(new ItemStack(this, 1, type.meta));
            }
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void registerModels() {
        for (DollTypeExAstris type : DollTypeExAstris.values()) {
            ModelLoader.setCustomModelResourceLocation(this, type.meta,
                    new ModelResourceLocation(ExAstris.PREFIX + groupName + "_" + type.name.toLowerCase(Locale.ROOT), "inventory"));
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
        if (exAstrisTypes.containsKey(stack.getMetadata())) {
            tooltip.add(I18n.format("item." + ExAstris.PREFIX + groupName + "_"
                    + DollTypeExAstris.getByMeta(stack.getMetadata()).name + ".tip"));
        } else {
            tooltip.add(I18n.format("debug.mod_not_installed.desc", DollType.getByMeta(stack.getMetadata()).modid));
        }
    }

    public enum DollTypeExAstris {
        VILLAGER(0, "villager", "minecraft", "peacewater", 2),
        EVOKER(1, "evoker", "minecraft", "witchwater", 2),
        ;

        private static final Int2ObjectMap<DollTypeExAstris> ALL_TYPES = new Int2ObjectArrayMap<>();

        static {
            for (DollTypeExAstris dollType : values()) {
                ALL_TYPES.put(dollType.meta, dollType);
            }
        }

        public final int meta;
        public final String name;
        public final String modid;
        public final String fluidname;
        public final double posYCorrection;

        DollTypeExAstris(int meta, String name, String modid, String fluidname, double posYCorrection) {
            this.meta = meta;
            this.name = name;
            this.modid = modid;
            this.fluidname = fluidname;
            this.posYCorrection = posYCorrection;
        }

        public static DollTypeExAstris getByMeta(int meta) {
            return ALL_TYPES.get(meta);
        }
    }
}
