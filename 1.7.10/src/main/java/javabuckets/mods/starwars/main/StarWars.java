package javabuckets.mods.starwars.main;

import javabuckets.mods.starwars.gui.hud.HUDOverlay;
import javabuckets.mods.starwars.init.ModBlocks;
import javabuckets.mods.starwars.init.ModEntities;
import javabuckets.mods.starwars.init.ModItems;
import javabuckets.mods.starwars.init.ModRecipes;
import javabuckets.mods.starwars.proxies.ServerProxy;
import javabuckets.mods.starwars.utility.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)

public class StarWars 
{
	@SidedProxy(clientSide = "javabuckets.mods.starwars.proxies.ClientProxy", serverSide = "javabuckets.mods.starwars.proxies.ServerProxy")
	public static ServerProxy proxy;

	@Instance(Reference.MOD_ID)
	public static StarWars instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModBlocks.init();
		ModItems.init();
		ModEntities.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
		
		proxy.registerProxyInformation();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		HUDOverlay.init();
	}
}