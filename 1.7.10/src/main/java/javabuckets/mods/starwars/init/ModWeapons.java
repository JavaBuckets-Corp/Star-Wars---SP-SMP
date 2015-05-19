package javabuckets.mods.starwars.init;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.starwars.item.*;
import javabuckets.mods.starwars.item.weapons.ItemBlaster;
import javabuckets.mods.starwars.item.weapons.ItemDoubleLightsaber;
import javabuckets.mods.starwars.item.weapons.ItemHandBlaster;
import javabuckets.mods.starwars.item.weapons.ItemLightsaber;
import javabuckets.mods.starwars.item.weapons.ItemMinigun;
import javabuckets.mods.starwars.item.weapons.ItemSniper;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.item.Item;

public class ModWeapons 
{
	/**
	 * Lightsabers (Blue, Green, Red & Purple, double bladed are also available)
	 */
	public static Item blueLightsaber;
	public static Item greenLightsaber;
	public static Item redLightsaber;
	public static Item purpleLightsaber;

	public static Item blueDoubleLightsaber;
	public static Item greenDoubleLightsaber;
	public static Item redDoubleLightsaber;
	public static Item purpleDoubleLightsaber;

	/** 
	 *	Blasters (Incl. Pistols, Rifles, Snipers, Shotguns, LMG's & SMG's) 
	 */
	public static Item e_11BlasterRifle;
	public static Item dc_17HandBlaster;
	public static Item scoutSniperRifle;
	public static Item z_6RotaryBlasterCannon;

	public static void init()
	{
		/**
		 * Lightsabers (Blue, Green, Red & Purple, double bladed are also available)
		 */
		blueLightsaber = new ItemLightsaber().setUnlocalizedName("blue_lightsaber").setFull3D();
		GameRegistry.registerItem(blueLightsaber, "blue_lightsaber", Reference.MOD_ID);
		
		redLightsaber = new ItemLightsaber().setUnlocalizedName("red_lightsaber").setFull3D();
		GameRegistry.registerItem(redLightsaber, "red_lightsaber", Reference.MOD_ID);
		
		greenLightsaber = new ItemLightsaber().setUnlocalizedName("green_lightsaber").setFull3D();
		GameRegistry.registerItem(greenLightsaber, "green_lightsaber", Reference.MOD_ID);
		
		purpleLightsaber = new ItemLightsaber().setUnlocalizedName("purple_lightsaber").setFull3D();
		GameRegistry.registerItem(purpleLightsaber, "purple_lightsaber", Reference.MOD_ID);
		
		blueDoubleLightsaber = new ItemDoubleLightsaber().setUnlocalizedName("blue_double_lightsaber").setFull3D();
		GameRegistry.registerItem(blueDoubleLightsaber, "blue_double_lightsaber", Reference.MOD_ID);
		
		redDoubleLightsaber = new ItemDoubleLightsaber().setUnlocalizedName("red_double_lightsaber").setFull3D();
		GameRegistry.registerItem(redDoubleLightsaber, "red_double_lightsaber", Reference.MOD_ID);
		
		greenDoubleLightsaber = new ItemDoubleLightsaber().setUnlocalizedName("green_double_lightsaber").setFull3D();
		GameRegistry.registerItem(greenDoubleLightsaber, "green_double_lightsaber", Reference.MOD_ID);
		
		purpleDoubleLightsaber = new ItemDoubleLightsaber().setUnlocalizedName("purple_double_lightsaber").setFull3D();
		GameRegistry.registerItem(purpleDoubleLightsaber, "purple_double_lightsaber", Reference.MOD_ID);
		
		/** 
		 *	Blasters (Incl. Pistols, Rifles, Snipers, Shotguns, LMG's & SMG's) 
		 */
		e_11BlasterRifle = new ItemBlaster().setUnlocalizedName("e-11_blaster_rifle");
		GameRegistry.registerItem(e_11BlasterRifle, "e-11_blaster_rifle", Reference.MOD_ID);

		dc_17HandBlaster = new ItemHandBlaster(false).setUnlocalizedName("dc-17_hand_blaster");
		GameRegistry.registerItem(dc_17HandBlaster, "dc-17_hand_blaster", Reference.MOD_ID);

		scoutSniperRifle = (new ItemSniper()).setUnlocalizedName("sniper_rifle");
		GameRegistry.registerItem(scoutSniperRifle, "sniper_rifle", Reference.MOD_ID);

		z_6RotaryBlasterCannon = (new ItemMinigun()).setUnlocalizedName("z-6_rotary_blaster_cannon");
		GameRegistry.registerItem(z_6RotaryBlasterCannon, "z-6_rotary_blaster_cannon", Reference.MOD_ID);
	}
}