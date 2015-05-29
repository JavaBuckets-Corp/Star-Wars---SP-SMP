package javabuckets.mods.starwars.force;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.server.MinecraftServer;
import javabuckets.mods.starwars.utility.LogHelper;

public class ForceServerUtil 
{
	public Map force = new HashMap();
	
	public MinecraftServer server;
	
	public void serverHandling(MinecraftServer server)
	{
		this.server = server;
	}
	
	public String getForceFactionFromUUID(String UUID)
	{
		try
        {
            return !this.force.containsKey(UUID) ? "" : (this.force.get(UUID)).toString();
        }
        catch (ClassCastException classcastexception)
        {
            return "";
        }
	}
	
	public void setForceFactionToUUID(String UUID, String forceFaction)
	{
		if (force.containsKey(UUID))
		{
			LogHelper.warn("Overwriting old force faction from player with UUID: " + UUID);
		}
		else
		{
			LogHelper.info("Succesfuly set force faction for player with UUID: " + UUID + " to " + forceFaction);
		}
		force.put(UUID, forceFaction);
	}
	
	public boolean getCanPlayerUseForceFromUUID(String UUID)
	{
		String ff = getForceFactionFromUUID(UUID);
		
		if (ff != ForceReference.F_Private || ff != ForceReference.F_Soldier || ff != ForceReference.F_Sergeant || ff != ForceReference.F_Commander || ff != ForceReference.F_Elite || ff != ForceReference.F_SurpremeElite)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}