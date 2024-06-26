package net.thep2wking.exastris.util.world;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.thep2wking.exastris.ExAstris;
import net.thep2wking.exastris.util.handler.IStructure;

public class WorldGeneratorExAstris extends WorldGenerator implements IStructure {
	public static String structureName;

	@SuppressWarnings("all")
	public WorldGeneratorExAstris(String name) {
		this.structureName = name;
	}

	@Override
	@SuppressWarnings("all")
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		this.generateStructure(worldIn, position);
		return true;
	}

	public static void generateStructure(World world, BlockPos pos) {
		MinecraftServer mcServer = world.getMinecraftServer();
		TemplateManager manager = worldServer.getStructureTemplateManager();
		ResourceLocation location = new ResourceLocation(ExAstris.MODID, structureName);
		Template template = manager.get(mcServer, location);

		if (template != null) {
			IBlockState state = world.getBlockState(pos);
			world.notifyBlockUpdate(pos, state, state, 3);
			template.addBlocksToWorld(world, pos, settings);
		}
	}
}