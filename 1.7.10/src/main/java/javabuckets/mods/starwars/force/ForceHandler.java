package javabuckets.mods.starwars.force;

import java.util.HashMap;
import java.util.Map;

import javabuckets.mods.starwars.utility.LogHelper;

public class ForceHandler 
{
	public Map force = new HashMap();
	
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
}