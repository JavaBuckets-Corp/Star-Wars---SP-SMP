package javabuckets.mods.starwars.gui.hud;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class HUDOverlay 
{
	public static void init()
	{
		Minecraft mc = Minecraft.getMinecraft();
		
		MinecraftForge.EVENT_BUS.register(new HUDForce(mc));
		MinecraftForge.EVENT_BUS.register(new HUDMandalorian(mc));
		MinecraftForge.EVENT_BUS.register(new HUDReloadRendering(mc));
		MinecraftForge.EVENT_BUS.register(new HUDSniperZoomRendering(mc));
	}
}