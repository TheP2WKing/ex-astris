package net.thep2wking.exastris.modules.excompressum.sieve;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Lists;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.modules.excompressum.base.TileAutomaticSieveBase;

public class GuiAutomaticSieve extends GuiContainer {
    private static final ResourceLocation texture = new ResourceLocation(ExAstris.MODID,
            "textures/gui/automatic_sieve.png");
    private TileAutomaticSieveBase tileEntity;

    public GuiAutomaticSieve(InventoryPlayer inventoryPlayer, TileAutomaticSieveBase tileEntity) {
        super(new ContainerAutomaticSieve(inventoryPlayer, tileEntity));
        this.tileEntity = tileEntity;
        xSize = 176;
        ySize = 166;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1f, 1f, 1f, 1f);
        mc.getTextureManager().bindTexture(getBackgroundTexture());
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        if (tileEntity.isProcessing()) {
            drawTexturedModalRect(guiLeft + 32, guiTop + 27, 176, 0, (int) (tileEntity.getProgress() * 15f), 14); // 36
        }
        if (tileEntity.isDisabledByRedstone()) {
            drawTexturedModalRect(guiLeft + 34, guiTop + 43, 176, 14, 15, 16);
        }
        renderEnergyBar();
    }

    private static final List<String> tmpLines = Lists.newArrayList();

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        if (tileEntity.getMeshStack().isEmpty()) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0, 0, 300);
            drawRect(58, 16, 144, 71, 0x99000000);
            drawCenteredString(fontRenderer, I18n.format("gui.excompressum:autoSieve.noMesh"), 101,
                    43 - fontRenderer.FONT_HEIGHT / 2, 0xFFFFFFFF);
            GlStateManager.popMatrix();
        } else if (!tileEntity.isCorrectSieveMesh()) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0, 0, 300);
            drawRect(58, 16, 144, 71, 0x99000000);
            drawCenteredString(fontRenderer, I18n.format("gui.excompressum:autoSieve.incorrectMesh"), 101,
                    43 - fontRenderer.FONT_HEIGHT / 2, 0xFFFFFFFF);
            GlStateManager.popMatrix();
        }
        renderPowerTooltip(mouseX, mouseY);
    }

    protected ResourceLocation getBackgroundTexture() {
        return texture;
    }

    protected void renderEnergyBar() {
        float energyPercentage = tileEntity.getEnergyPercentage();
        drawTexturedModalRect(guiLeft + 152, guiTop + 8 + (70 - (int) (energyPercentage * 70)), 176 + 15, 0, 16,
                (int) (energyPercentage * 70));
    }

    protected void renderPowerTooltip(int mouseX, int mouseY) {
        if (mouseX >= guiLeft + 152 && mouseX <= guiLeft + 167 && mouseY >= guiTop + 8 && mouseY <= guiTop + 77) {
            tmpLines.clear();
            tmpLines.add(tileEntity.getEnergyStored(null) + " FE");
            tmpLines.add(I18n.format("tooltip.excompressum:consumingEnergy", tileEntity.getEffectiveEnergy()));
            drawHoveringText(tmpLines, mouseX - guiLeft, mouseY - guiTop);
        }
    }
}