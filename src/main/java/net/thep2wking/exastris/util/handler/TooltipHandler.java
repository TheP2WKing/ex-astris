package net.thep2wking.exastris.util.handler;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TextFormatting;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.config.ExAstrisConfig;

import java.util.List;

public class TooltipHandler {
    public static final String SHIFT_INFO = "tooltip." + ExAstris.MODID + ".shift";
    public static final String CTRL_INFO = "tooltip." + ExAstris.MODID + ".ctrl";

    public static void addShiftKey(List<String> tooltip) {
        if(ExAstrisConfig.GENEREL.TOOLTIPS) {
            tooltip.add(TextFormatting.GRAY + I18n.format(SHIFT_INFO));
        }
    }

    public static void addCtrlKey(List<String> tooltip) {
        if(ExAstrisConfig.GENEREL.TOOLTIPS) {
            tooltip.add(TextFormatting.GRAY + I18n.format(CTRL_INFO));
        }
    }

    public static boolean showShiftTip() {
        return GuiScreen.isShiftKeyDown();
    }

    public static void addShiftTooltip(List<String> tooltip, String name, int count) {
        if(ExAstrisConfig.GENEREL.TOOLTIPS) {
            tooltip.add(TextFormatting.DARK_GREEN + I18n.format("item." + name + ".tip" + count));
        }
    }

    public static boolean showCtrlTip() {
        return GuiScreen.isShiftKeyDown();
    }

    public static void addCtrlTooltip(List<String> tooltip, String name, int count) {
        if(ExAstrisConfig.GENEREL.TOOLTIPS) {
            tooltip.add(TextFormatting.DARK_GREEN + I18n.format("item." + name + ".tip" + count));
        }
    }
}