package net.thep2wking.exastris.modules.thaumcraft.content;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thep2wking.exastris.api.ExAstrisItemBase;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.capabilities.IPlayerKnowledge.EnumKnowledgeType;
import thaumcraft.api.research.ResearchCategories;
import thaumcraft.api.research.ResearchCategory;
import thaumcraft.common.lib.SoundsTC;

@SuppressWarnings("deprecation")
public class ItemKnowledgeFragment extends ExAstrisItemBase {
	public ItemKnowledgeFragment(String name, CreativeTabs tab, EnumRarity rarity, boolean hasEffect) {
		super(name, tab, rarity, hasEffect);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(I18n.translateToLocal("item.curio.text"));
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
		worldIn.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, SoundsTC.learn,
				SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isRemote) {
			int oProg = EnumKnowledgeType.OBSERVATION.getProgression();
			int tProg = EnumKnowledgeType.THEORY.getProgression();

			List<String> researchCategories = Arrays.asList("BASICS", "AUROMANCY", "ALCHEMY", "GOLEMANCY", "INFUSION",
					"ARTIFICE");
			String randomCategory = researchCategories.get(new Random().nextInt(researchCategories.size()));
			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.OBSERVATION,
					ResearchCategories.getResearchCategory(randomCategory),
					MathHelper.getInt(player.getRNG(), oProg / 4, oProg));
			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.THEORY,
					ResearchCategories.getResearchCategory(randomCategory),
					MathHelper.getInt(player.getRNG(), tProg / 5, tProg / 4));

			ResearchCategory[] rc = (ResearchCategory[]) ResearchCategories.researchCategories.values()
					.toArray(new ResearchCategory[0]);
			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.OBSERVATION,
					rc[player.getRNG().nextInt(rc.length)], MathHelper.getInt(player.getRNG(), oProg / 3, oProg));
			ThaumcraftApi.internalMethods.addKnowledge(player, EnumKnowledgeType.THEORY,
					rc[player.getRNG().nextInt(rc.length)], MathHelper.getInt(player.getRNG(), tProg / 5, tProg / 3));
			if (!player.capabilities.isCreativeMode) {
				player.getHeldItem(hand).shrink(1);
			}
			player.sendMessage(
					new TextComponentString(TextFormatting.DARK_PURPLE + I18n.translateToLocal("tc.knowledge.gained")));
		}
		player.addStat(StatList.getObjectUseStats(this));
		return super.onItemRightClick(worldIn, player, hand);
	}
}