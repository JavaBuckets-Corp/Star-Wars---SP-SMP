package javabuckets.mods.starwars.init;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.starwars.item.ItemBasic;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.item.Item;

public class ModItems 
{
	public static Item swTabIcon;
	
	public static void init()
	{
		swTabIcon = new ItemBasic(1).setUnlocalizedName("sw_tab_icon");
		GameRegistry.registerItem(swTabIcon, "sw_tab_icon", Reference.MOD_ID);
		
		ModWeapons.init();
		ModMaterials.init();
	}
}