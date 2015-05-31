package javabuckets.mods.starwars.handler;

import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerDisconnectionFromClientEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SWConnectionEventHandler 
{
	@SubscribeEvent
	public void onClientConnectToServer(ServerConnectionFromClientEvent event)
	{
		
	}
	
	@SubscribeEvent
	public void onClientDisconnectFromServer(ServerDisconnectionFromClientEvent event)
	{
		
	}
	
	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void onPlayerLoggedIn(PlayerLoggedInEvent event)
	{
		LogHelper.info("Player '" + event.player.getDisplayName() + "' has joined the server with UUID: " + event.player.getUniqueID().toString());
	}
	
	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void onPlayerLoggedOut(PlayerLoggedOutEvent event)
	{
		LogHelper.info("Player '" + event.player.getDisplayName() + "' has left the server with UUID: " + event.player.getUniqueID().toString());
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		
	}
}