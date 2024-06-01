package net.thep2wking.exastris.modules.excompressum.content.hammerer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;

public class RenderAutomaticHammererArm extends TileEntitySpecialRenderer<TileAutomaticHammerer> {
	private static final ModelAutomaticHammererArm arm = new ModelAutomaticHammererArm();
	private static final ResourceLocation TEXTURE = new ResourceLocation(ExAstris.MODID,
			"textures/blocks/automatic_hammerer_arm.png");

	@Override
	public void render(TileAutomaticHammerer tileEntity, double x, double y, double z, float partialTicks,
			int destroyStage, float alpha) {
		if (!tileEntity.hasWorld()) {
			return;
		}

		ItemStack currentStack = tileEntity.getCurrentStack();
		float progress = tileEntity.getProgress();
		float percMaxRaise = 0.90f;

		if (progress > percMaxRaise) {
			percMaxRaise = 1 - percMaxRaise;
			progress = 1 - progress;
		}

		float translate = Math.max(0, 0.31f * (progress / percMaxRaise));
		GlStateManager.pushMatrix();

		if (!currentStack.isEmpty()
				|| !ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.RENDER_HAMMERER_CONTENTS) {
			GlStateManager.translate(x, y + translate, z);
		} else {
			GlStateManager.translate(x, y, z);
		}

		GlStateManager.rotate(-90, 1, 0, 0);
		Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
		GlStateManager.pushMatrix();
		arm.render(null, 0, 0, 0, 0, 0, 0.0625F);
		GlStateManager.popMatrix();
		GlStateManager.popMatrix();
	}
}