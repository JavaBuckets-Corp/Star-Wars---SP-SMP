package javabuckets.mods.starwars.generator;

import java.util.Calendar;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class SWWorldGenerator implements IWorldGenerator 
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch (world.provider.dimensionId)
		{
		case 0:
			generateOverworld(world, random, chunkX * 16, chunkZ * 16);
			break;
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	public void generateOverworld(World world, Random random, int chunkX, int chunkZ)
	{
		Random randomGenerator = random;
		
		/*for (int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + randomGenerator.nextInt(16);
			int randPosY = random.nextInt(12);
			int randPosZ = chunkZ + randomGenerator.nextInt(16);
			(new WorldGenMinable(ModBlocks.crystalOre, 2)).generate(world, random, randPosX, randPosY, randPosZ);
		}*/
		
		
		/*Calendar calendar = Calendar.getInstance();
		
		if ((calendar.get(2) + 1 == 3 && calendar.get(5) >= 15) || (calendar.get(2) + 1 == 4 && calendar.get(5) <= 15))
		{
	        if (new Random().nextInt(16) == 1)
	        {
	            int x = chunkX + randomGenerator.nextInt(16) + 8;
	            int y = random.nextInt(128);
	            int z = chunkZ + randomGenerator.nextInt(16) + 8;
	            (new WorldGenEasterEgg(ModBlocks.easterEgg)).generate(world, random, x, y, z);
	        }
		}*/
	}
	
	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{
		Random randomGenerator = random;
		
		/*for (int i = 0; i < 10; i++)
		{
			int randPosX = chunkX + randomGenerator.nextInt(16);
			int randPosY = random.nextInt(55);
			int randPosZ = chunkZ + randomGenerator.nextInt(16);
			(new WorldGenNetherMinable(ModBlocks.crystalOreNether, 3)).generate(world, random, randPosX, randPosY, randPosZ);
		}*/
	}
}