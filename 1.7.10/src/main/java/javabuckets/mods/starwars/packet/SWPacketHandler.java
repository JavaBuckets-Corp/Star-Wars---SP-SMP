package javabuckets.mods.starwars.packet;

import java.io.IOException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import ibxm.Player;

public class SWPacketHandler
{
	protected String channelName = "STARWARSC";
	
	@SubscribeEvent
	public void onServerPacket(ServerCustomPacketEvent event) throws IOException
	{
		
	}

	@SubscribeEvent
	public void onClientPacket(ClientCustomPacketEvent event) throws IOException
	{	
		
	}
}