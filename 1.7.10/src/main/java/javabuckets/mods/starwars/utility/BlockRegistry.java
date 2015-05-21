package javabuckets.mods.starwars.utility;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class BlockRegistry
{
	public static List<Block> blockList = new ArrayList<Block>();
	
	public static void registerBlock(Block block, String name)
	{
		block.setBlockName(name.toLowerCase().replace(' ', '_').replace("'", ""));
		block.setBlockTextureName(name.toLowerCase().replace(' ', '_').replace("'", ""));
		GameRegistry.registerBlock(block, name);
		blockList.add(block);
	}
	
	public static void registerOre(Block block, String name, String oreDictName)
	{
		registerBlock(block, name);
		OreDictionary.registerOre(oreDictName, block);
	}
}