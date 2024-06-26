package net.thep2wking.exastris.integration.jei.fluiddolltransform;

import java.util.ArrayList;
import java.util.List;

import exnihilocreatio.ExNihiloCreatio;
import exnihilocreatio.ModBlocks;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.thep2wking.exastris.ExAstris;

@SuppressWarnings("unused")
public class FluidDollTransformCategory implements IRecipeCategory<FluidDollTransformWrapper> {
	public static final String UID = ExAstris.MODID + ".fluid_doll_transform";
	public static final String MOD = "Ex Nihilo Creatio";

	public static final ResourceLocation BACKGROUND = new ResourceLocation(ExNihiloCreatio.MODID, "textures/gui/jei_fluid_block_transform.png");

	private IDrawable background;
	private IGuiHelper guiHelper;
	private IDrawable icon;

	public FluidDollTransformCategory(IGuiHelper guiHelper) {
		background = guiHelper.drawableBuilder(BACKGROUND, 0, 0, 166, 63).build();
		icon = guiHelper.createDrawableIngredient(new ItemStack(Item.getByNameOrId("exnihilocreatio:block_barrel0"), 1, 0));
	}

	@Override
	public String getUid() {
		return UID;
	}

	@Override
	public String getTitle() {
		return I18n.format("jei." + ExAstris.MODID + ".fluid_doll_transform.category");
	}

	@Override
	public String getModName() {
		return MOD;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public IDrawable getIcon() {
		return icon;
	}
	
	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		return new ArrayList<>();
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, FluidDollTransformWrapper recipeWrapper, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0, true, 74, 36);
        recipeLayout.getItemStacks().init(1, true, 47, 36);
        recipeLayout.getItemStacks().init(2, true, 74, 9);
        recipeLayout.getItemStacks().init(3, false, 101, 36);

        recipeLayout.getItemStacks().set(0, new ItemStack(ModBlocks.barrelStone, 1, 0));
        recipeLayout.getItemStacks().set(1, recipeWrapper.in.get(0));
        recipeLayout.getItemStacks().set(2, recipeWrapper.in.get(1));
        recipeLayout.getItemStacks().set(3, recipeWrapper.outItem);
    }
}