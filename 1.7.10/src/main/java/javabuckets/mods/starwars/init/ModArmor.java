package javabuckets.mods.starwars.init;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.starwars.item.armor.ItemJetpack;
import javabuckets.mods.starwars.item.armor.ItemMandalorianArmor;
import javabuckets.mods.starwars.item.armor.ItemMandalorianChestplate;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.item.Item;

public class ModArmor 
{
	public static Item mandalorianHelmet;
	public static Item mandalorianChestplate;
	public static Item mandalorianLeggings;

	public static Item bobaFettMandalorianHelmet;
	public static Item bobaFettMandalorianChestplate;
	public static Item bobaFettMandalorianLeggings;

	public static Item bobaFettJetpack;
	public static Item jetpack;
	public static Item mandalorianArmorMolds;
	
	public static void init()
	{
		/*mandalorianHelmet = (new ItemMandalorianArmor(0).setUnlocalizedName("mandalorian_helmet"));
		GameRegistry.registerItem(mandalorianHelmet, "mandalorian_helmet", Reference.MOD_ID);
		
		mandalorianChestplate = (new ItemMandalorianChestplate(1).setUnlocalizedName("mandalorian_chestplate"));
		GameRegistry.registerItem(mandalorianChestplate, "mandalorian_chestplate", Reference.MOD_ID);
		
		mandalorianLeggings = (new ItemMandalorianArmor(2).setUnlocalizedName("mandalorian_leggings"));
		GameRegistry.registerItem(mandalorianLeggings, "mandalorian_leggings", Reference.MOD_ID);
		
		bobaFettMandalorianHelmet = (new ItemMandalorianArmor(0).setUnlocalizedName("boba_fetts_mandalorian_helmet"));
		GameRegistry.registerItem(bobaFettMandalorianHelmet, "boba_fetts_mandalorian_helmet", Reference.MOD_ID);
		
		bobaFettMandalorianChestplate = (new ItemMandalorianChestplate(1).setUnlocalizedName("boba_fetts_mandalorian_chestplate"));
		GameRegistry.registerItem(bobaFettMandalorianChestplate, "boba_fetts_mandalorian_chestplate", Reference.MOD_ID);
		
		bobaFettMandalorianLeggings = (new ItemMandalorianArmor(2).setUnlocalizedName("boba_fetts_mandalorian_leggings"));
		GameRegistry.registerItem(bobaFettMandalorianLeggings, "boba_fetts_mandalorian_leggings", Reference.MOD_ID);
		
		jetpack = (new ItemJetpack().setUnlocalizedName("jetpack"));
		bobaFettJetpack = (new ItemJetpack().setUnlocalizedName("boba_fetts_jetpack"));*/
		//mandalorianArmorMolds = (new ItemMetaBasic(config.mandalorianArmorMoldsID, new String[]{"Mandalorian Helmet Mold", "Mandalorian Chestplate Mold", "Mandalorian Leggings Mold"}));

		
	}
}