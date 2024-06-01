package net.thep2wking.exastris.modules.excompressum.content.hammerer;

import org.lwjgl.opengl.GL11;

import net.blay09.mods.excompressum.client.render.RenderUtils;
import net.blay09.mods.excompressum.utils.StupidUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.thep2wking.exastris.config.ExAstrisConfig;

public class RenderAutomaticHammerer extends TileEntitySpecialRenderer<TileAutomaticHammerer> {
	private final RenderAutomaticHammererArm armRenderer = new RenderAutomaticHammererArm();

	public RenderAutomaticHammerer() {
	}

	@Override
	public void render(TileAutomaticHammerer tileEntity, double x, double y, double z, float partialTicks,
			int destroyStage, float alpha) {
		if (ExAstrisConfig.MODULE_EX_COMPRESSUM.AUTOMATIC_HAMMERER.RENDER_HAMMERER_CONTENTS) {
			Minecraft mc = Minecraft.getMinecraft();
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder renderer = tessellator.getBuffer();
			RenderHelper.disableStandardItemLighting();
			GlStateManager.pushMatrix();
			GlStateManager.color(1f, 1f, 1f, 1f);
			GlStateManager.translate((float) x + 0.5f, (float) y, (float) z + 0.5f);
			GlStateManager.pushMatrix();
			GlStateManager.rotate(180f, 0f, 1f, 0f);
			GlStateManager.translate(0f, 0.5f, 0f);
			GlStateManager.scale(0.5f, 0.5f, 0.5f);
			GlStateManager.popMatrix();
			RenderHelper.disableStandardItemLighting();
			ItemStack currentStack = tileEntity.getCurrentStack();
			float progress = tileEntity.getProgress();
			if (!currentStack.isEmpty() && progress > 0.5f) {
				IBlockState contentState = StupidUtils.getStateFromItemStack(currentStack);
				if (contentState != null) {
					renderer.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);
					mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
					GlStateManager.pushMatrix();
					GlStateManager.translate(-0.1, 0.1875f, -0.1);
					GlStateManager.scale(0.2, 0.2, 0.2);
					RenderUtils.renderBlockWithTranslate(mc, contentState, tileEntity.getWorld(), tileEntity.getPos(),
							renderer);
					tessellator.draw();
					GlStateManager.popMatrix();
				}
			}
			GlStateManager.popMatrix();
			RenderHelper.enableStandardItemLighting();
		}
		armRenderer.render(tileEntity, x, y, z, partialTicks, destroyStage, alpha);
	}
}