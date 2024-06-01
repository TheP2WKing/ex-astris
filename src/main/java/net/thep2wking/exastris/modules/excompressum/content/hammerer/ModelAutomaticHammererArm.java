package net.thep2wking.exastris.modules.excompressum.content.hammerer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

public class ModelAutomaticHammererArm  extends ModelBase {
    private ModelRenderer part1;
    private ModelRenderer part2;

    public ModelAutomaticHammererArm() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.part1 = new ModelRenderer(this, 0, 0);
        this.part1.setRotationPoint(1F, 3F, 1F);
        this.part1.addBox(0F, 0F, 0F, 14, 2, 14);

        // Second element
        this.part2 = new ModelRenderer(this, 0, 16);
        this.part2.setRotationPoint(5F, 2F, 5F);
        this.part2.addBox(0F, 0F, 0F, 4, 6, 4);
		part1.addChild(part2);
    }

    @Override
    public void render(Entity entity, float brightness, float invRender, float f2, float f3, float f4, float f5) {
        GlStateManager.rotate(90, 1, 0, 0);
        this.part1.render(f5);
        // this.BasePlate.render(f5);
        //this.coreSupports.render(f5);

        float lastBrightnessX = OpenGlHelper.lastBrightnessX;
        float lastBrightnessY = OpenGlHelper.lastBrightnessY;

        float b = brightness * 200F;
        float colour = Math.min(2F, (brightness * 2F) + 0.5F);

        if (brightness > 0F && invRender == 0) {
            GL11.glDisable(GL11.GL_LIGHTING);
        }

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, Math.min(200F, lastBrightnessX + b), Math.min(200F, lastBrightnessY + b));
        GL11.glColor4f(colour, colour, colour, 1F);
        // this.part1.render(f5);
        GL11.glColor4f(1F, 1F, 1F, 1F);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lastBrightnessX, lastBrightnessY);

        if (brightness > 0F && invRender == 0) {
            GL11.glEnable(GL11.GL_LIGHTING);
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}