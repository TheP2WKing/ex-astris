package net.thep2wking.exastris.integration.jei.blocktransformation;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fluids.FluidStack;
import net.thep2wking.exastris.ExAstris;

@SuppressWarnings("unused")
public class BlockTransformationCategory implements IRecipeCategory<BlockTransformationWrapper> {
	public static final String UID = ExAstris.MODID + ".transformation";
	public static final String MOD = ExAstris.NAME;

	public static final ResourceLocation BACKGROUND = new ResourceLocation(ExAstris.MODID,
			"textures/gui/jei_transformation.png");

	public static final ResourceLocation ICON = new ResourceLocation(ExAstris.MODID,
			"textures/gui/jei_transformation_icon.png");

	private IDrawable background;
	private IGuiHelper guiHelper;
	private IDrawable icon;
	private IDrawable text;
	private IDrawableAnimated progress;
	public int transformTime = 100;

	public BlockTransformationCategory(IGuiHelper guiHelper) {
		background = guiHelper.drawableBuilder(BACKGROUND, 0, 0, 150, 30).addPadding(0, 14, 0, 0).build();
		this.guiHelper = guiHelper;
		icon = guiHelper.createDrawableIngredient(new ItemStack(Items.CLOCK));
		IDrawableStatic progressDrawable = guiHelper.createDrawable(BACKGROUND, 151, 7, 49, 17);
		this.progress = guiHelper.createAnimatedDrawable(progressDrawable, (transformTime * 20) / 2, IDrawableAnimated.StartDirection.LEFT,
				false);
	}

	@Override
	public String getUid() {
		return UID;
	}

	@Override
	public String getTitle() {
		return I18n.format("jei." + ExAstris.MODID + ".transformation.category");
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
	public void drawExtras(Minecraft minecraft) {
		this.progress.draw(minecraft, 47, 7);
		minecraft.fontRenderer.drawString(
				I18n.format("jei." + ExAstris.MODID + ".transformation.desc2") + " " + transformTime + "s", 23, 31,
				0xFF808080, false);
	}

	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		return new ArrayList<>();
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, BlockTransformationWrapper recipeWrapper, IIngredients ingredients) {
		List<List<ItemStack>> inputs = ingredients.getInputs(VanillaTypes.ITEM);
		List<List<FluidStack>> outputFluid = ingredients.getOutputs(VanillaTypes.FLUID);
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		IGuiFluidStackGroup guiFluidStacks = recipeLayout.getFluidStacks();

		if (outputFluid.size() > 0)
			guiFluidStacks.init(1, false, 123, 7, 16, 16, 1000, false, null);
		guiItemStacks.init(0, false, 106, 7);

		int offset = inputs.size() - 1;
		for (int i = 0; i <= offset; i++)
			guiItemStacks.init(i + 12, true, 23 + (offset - i) * 18, 7);

		guiItemStacks.set(ingredients);
		guiFluidStacks.set(ingredients);
	}
}