package net.thep2wking.exastris.integration.jei.barrel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class FluidDollTransformWrapper implements IRecipeWrapper {
	public List<List<ItemStack>> in;
	public ItemStack outItem;
	public String info;
	public int transformTime = 100;

	private FluidDollTransformWrapper(ItemStack... input) {
		in = new ArrayList<>();
		for (ItemStack stack : input)
			in.add(Collections.singletonList(stack));
	}

	public FluidDollTransformWrapper(ItemStack out, ItemStack... input) {
		this(input);
		this.outItem = out;
	}
	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setOutput(VanillaTypes.ITEM, outItem);
		ingredients.setInputLists(VanillaTypes.ITEM, in);
	}

	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

	}

	@Override
	public List<String> getTooltipStrings(int mouseX, int mouseY) {
		//if (mouseX >= 47 && mouseX <= 95 && mouseY >= 7 && mouseY <= 24) {
		//	return Arrays.asList(I18n.format("jei." + ExAstris.MODID + ".transformation.desc1"));
		//} else if (mouseX >= 23 && mouseX <= 80 && mouseY >= 28 && mouseY <= 40) {
		//	return Arrays.asList(I18n.format("jei." + ExAstris.MODID + ".transformation.desc3"));
		//}
		return null;
	}

	@Override
	public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
		return false;
	}
}