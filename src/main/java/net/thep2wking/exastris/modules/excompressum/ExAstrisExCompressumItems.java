package net.thep2wking.exastris.modules.excompressum;

import net.minecraft.item.Item;
import net.thep2wking.exastris.api.ExAstrisItemBlockBase;
import net.thep2wking.exastris.init.ExAstrisTabs;
import net.thep2wking.exastris.modules.excompressum.content.ItemUpgradeFortune;
import net.thep2wking.exastris.modules.excompressum.content.ItemUpgradeSpeed;
import net.thep2wking.exastris.util.handler.RarityHandler;

public class ExAstrisExCompressumItems {
	public static final Item AUTOMATIC_SIEVE = new ExAstrisItemBlockBase(ExAstrisExCompressumBlocks.AUTOMATIC_SIEVE, RarityHandler.WHITE, false);
	public static final Item AUTOMATIC_HAMMERER = new ExAstrisItemBlockBase(ExAstrisExCompressumBlocks.AUTOMATIC_HAMMERER, RarityHandler.WHITE, false);

	public static final Item UPGRADE_SPEED = new ItemUpgradeSpeed("upgrade_speed", ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
	public static final Item UPGRADE_FORTUNE = new ItemUpgradeFortune("upgrade_fortune", ExAstrisTabs.EXASTRIS_TAB, RarityHandler.WHITE, false);
}