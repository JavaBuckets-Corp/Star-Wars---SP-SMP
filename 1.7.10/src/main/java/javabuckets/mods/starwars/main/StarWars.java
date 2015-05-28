package javabuckets.mods.starwars.main;

import javabuckets.mods.starwars.command.CommandSetForceFaction;
import javabuckets.mods.starwars.force.Force;
import javabuckets.mods.starwars.force.ForceHandler;
import javabuckets.mods.starwars.generator.SWWorldGenerator;
import javabuckets.mods.starwars.gui.GUIHandler;
import javabuckets.mods.starwars.gui.hud.HUDOverlay;
import javabuckets.mods.starwars.handler.SWEventHandler;
import javabuckets.mods.starwars.init.ModBlocks;
import javabuckets.mods.starwars.init.ModEnchantments;
import javabuckets.mods.starwars.init.ModEntities;
import javabuckets.mods.starwars.init.ModItems;
import javabuckets.mods.starwars.init.ModMisc;
import javabuckets.mods.starwars.init.ModRecipes;
import javabuckets.mods.starwars.proxies.ServerProxy;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = "required-after:llibrary@[0.1.0-1.7.10,)")

public class StarWars 
{
	@SidedProxy(clientSide = "javabuckets.mods.starwars.proxies.ClientProxy", serverSide = "javabuckets.mods.starwars.proxies.ServerProxy")
	public static ServerProxy proxy;

	@Instance(Reference.MOD_ID)
	public static StarWars instance;
	
	public Force force = new Force();
	public ForceHandler forceHandler = new ForceHandler();
	
	public static CreativeTabs swTab = new CreativeTabs("starwars")
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.swTabIcon;
		}
	};
	
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
		ModMisc.init();
		ModRecipes.init();
		ModEnchantments.init();
		
		GameRegistry.registerWorldGenerator(new SWWorldGenerator(), 1);
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
		
		MinecraftForge.EVENT_BUS.register(new SWEventHandler());
		
		proxy.registerProxyInformation();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		HUDOverlay.init();
	}
	
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandSetForceFaction());
	}
}