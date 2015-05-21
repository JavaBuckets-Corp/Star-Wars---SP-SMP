package javabuckets.mods.starwars.init;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.starwars.block.BlockCharger;
import javabuckets.mods.starwars.block.BlockWeaponForge;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.tileentity.TileEntityCharger;
import javabuckets.mods.starwars.utility.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks 
{
	public static Block crystalCharger;
	public static Block weaponForge;
	
	public static void init()
	{
		crystalCharger = new BlockCharger().setStepSound(Block.soundTypeMetal).setHardness(5.0F).setResistance(20F).setCreativeTab(StarWars.swTab);
		BlockRegistry.registerBlock(crystalCharger, "Charger"); GameRegistry.registerTileEntity(TileEntityCharger.class, "Charger");
		
		weaponForge = new BlockWeaponForge().setStepSound(Block.soundTypeMetal).setHardness(5.0F).setResistance(20F).setCreativeTab(StarWars.swTab);
		BlockRegistry.registerBlock(weaponForge, "Weapon Forge");
	}
}