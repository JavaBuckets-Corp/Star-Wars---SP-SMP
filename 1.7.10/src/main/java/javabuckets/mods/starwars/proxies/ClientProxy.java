package javabuckets.mods.starwars.proxies;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends ServerProxy
{
	@Override
	@SideOnly(Side.CLIENT)
	public void registerProxyInformation()
	{
		
	}
}