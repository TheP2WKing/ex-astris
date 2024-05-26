package net.thep2wking.exastris.modules.excompressum.sieve;

import net.blay09.mods.excompressum.api.sievemesh.SieveMeshRegistryEntry;
import net.blay09.mods.excompressum.client.render.RenderUtils;
import net.blay09.mods.excompressum.registry.sievemesh.SieveMeshRegistry;
import net.blay09.mods.excompressum.utils.StupidUtils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;

public class RenderAutomaticSieve extends TileEntitySpecialRenderer<TileAutomaticSieve> {
	public RenderAutomaticSieve() {
	}

	public void render(TileAutomaticSieve tileEntity, double x, double y, double z, float partialTicks,
			int destroyStage, float alpha) {
		Minecraft mc = Minecraft.getMinecraft();
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder renderer = tessellator.getBuffer();
		RenderHelper.disableStandardItemLighting();
		GlStateManager.pushMatrix();
		GlStateManager.translate(x, y, z);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		ItemStack meshStack = tileEntity.getMeshStack();
		float tt;
		if (!meshStack.isEmpty()) {
			SieveMeshRegistryEntry sieveMesh = SieveMeshRegistry.getEntry(meshStack);
			if (sieveMesh != null) {
				renderer.begin(7, DefaultVertexFormats.BLOCK);
				TextureAtlasSprite sprite = sieveMesh.getSpriteLocation() != null
						? mc.getTextureMapBlocks().getTextureExtry(sieveMesh.getSpriteLocation().toString())
						: null;
				if (sprite == null) {
					sprite = mc.getTextureMapBlocks().getMissingSprite();
				}
				int brightness = tileEntity.getWorld().getCombinedLight(tileEntity.getPos().up(), 0);
				tt = 0.0625F;
				float meshXZ2 = 1.0F - tt;
				float meshY = 0.6925F; // 86
				RenderUtils.renderQuadUp(renderer, tt, meshY, tt, meshXZ2, meshY, meshXZ2, -1, brightness, sprite);
				tessellator.draw();
			}
		}
		ItemStack currentStack = tileEntity.getCurrentStack();
		if (!currentStack.isEmpty()) {
			IBlockState state = StupidUtils.getStateFromItemStack(currentStack);
			if (state != null) {
				float progress = tileEntity.getProgress();
				renderer.begin(7, DefaultVertexFormats.BLOCK);
				mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
				GlStateManager.pushMatrix();
				GlStateManager.translate(0.0625F, 0.6975F, 0.0625F);
				tt = 0.29F; // 43
				GlStateManager.scale(0.88F, tt - progress * tt, 0.88F);
				RenderUtils.renderBlockWithTranslate(mc, state, tileEntity.getWorld(), tileEntity.getPos(), renderer);
				tessellator.draw();
				GlStateManager.popMatrix();
			}
		}
		GlStateManager.popMatrix();
		RenderHelper.enableStandardItemLighting();
	}
}