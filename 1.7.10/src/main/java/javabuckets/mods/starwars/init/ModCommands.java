package javabuckets.mods.starwars.init;

import javabuckets.mods.starwars.command.*;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class ModCommands 
{
	public static void init(FMLServerStartingEvent event)
	{
		/**
		 * Force Faction commands
		 */
		event.registerServerCommand(new CommandSetForceFaction());
		event.registerServerCommand(new CommandGetForceFaction());
	}
}