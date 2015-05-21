package javabuckets.mods.starwars.init;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.starwars.item.ItemBasic;
import javabuckets.mods.starwars.item.ItemMetaBasic;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.item.Item;

public class ModMaterials 
{
	// Crystals
	public static Item unchargedCrystal;
	public static Item chargedCrystal;
	
	public static Item blueCrystal;
	public static Item greenCrystal;
	public static Item redCrystal;
	public static Item purpleCrystal;

	// Lightsaber Materials
	public static Item lightsaberParts;
	public static Item lightsaberHandle;
	
	public static Item quartzLens;
	public static Item bladeEmitter;
	public static Item powerCell;

	// Blaster Materials
	public static Item blasterBarrel;
	public static Item blasterBatteryChamber;

	// Basic Crafting Materials
	public static Item steelIngot;
	public static Item steelPlate;

	public static void init()
	{
		unchargedCrystal = new ItemBasic(64).setUnlocalizedName("uncharged_crystal").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(unchargedCrystal, "uncharged_crystal", Reference.MOD_ID);
		
		/*chargedCrystal = new ItemMetaBasic(StarWars.swTab, "blue_charged_crystal", "green_charged_crystal", "red_charged_crystal", "purple_charged_crystal");
		GameRegistry.registerItem(chargedCrystal, "charged_crystal", Reference.MOD_ID);*/
		
		blueCrystal = new ItemBasic(64).setUnlocalizedName("blue_charged_crystal").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(blueCrystal, "blue_charged_crystal", Reference.MOD_ID);
		
		greenCrystal = new ItemBasic(64).setUnlocalizedName("green_charged_crystal").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(greenCrystal, "green_charged_crystal", Reference.MOD_ID);
		
		redCrystal = new ItemBasic(64).setUnlocalizedName("red_charged_crystal").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(redCrystal, "red_charged_crystal", Reference.MOD_ID);
		
		purpleCrystal = new ItemBasic(64).setUnlocalizedName("purple_charged_crystal").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(purpleCrystal, "purple_charged_crystal", Reference.MOD_ID);
		
		
		
		/*lightsaberParts = new ItemMetaBasic(StarWars.swTab, "Quartz Lens", "Lightsaber Blade Emitter", "Power Cell");
		GameRegistry.registerItem(lightsaberParts, "lightsaber_parts", Reference.MOD_ID);*/
		
		quartzLens = new ItemBasic(64).setUnlocalizedName("quartz_lens").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(quartzLens, "quartz_lens", Reference.MOD_ID);
		
		bladeEmitter = new ItemBasic(64).setUnlocalizedName("lightsaber_blade_emitter").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(bladeEmitter, "lightsaber_blade_emitter", Reference.MOD_ID);
		
		powerCell = new ItemBasic(64).setUnlocalizedName("power_cell").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(powerCell, "power_cell", Reference.MOD_ID);
		
		
		
		blasterBarrel = new ItemBasic(64).setUnlocalizedName("blaster_barrel").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(blasterBarrel, "blaster_barrel", Reference.MOD_ID);
		
		blasterBatteryChamber = new ItemBasic(64).setUnlocalizedName("blaster_battery-chamber").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(blasterBatteryChamber, "blaster_battery-chamber", Reference.MOD_ID);
		
		
		
		steelIngot = new ItemBasic(64).setUnlocalizedName("steel_ingot").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(steelIngot, "steel_ingot", Reference.MOD_ID);
		
		steelPlate = new ItemBasic(64).setUnlocalizedName("steel_plate").setCreativeTab(StarWars.swTab);
		GameRegistry.registerItem(steelPlate, "steel_plate", Reference.MOD_ID);
	}
}