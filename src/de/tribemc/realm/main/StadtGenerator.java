package de.tribemc.realm.main;

import java.util.Random;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class StadtGenerator extends ChunkGenerator {

	static byte[][][] te = new byte[][][] {};

	// 0 0 - 0
	// 1 0 - 1
	// 2 0 - 2
	// 0 1 - 50

	@Override
	public byte[][] generateBlockSections(World world, Random random, int x,
			int z, BiomeGrid biomes) {
		return te[((z % 50) * 50) + (x % 50)];
	}
}
