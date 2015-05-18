package javabuckets.mods.starwars.init;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModMisc 
{
	public static void init()
	{
		LanguageRegistry.instance().addStringLocalization("death.attack.laserBolt", "%1$s was shot by %2$s");
		LanguageRegistry.instance().addStringLocalization("death.attack.laserBolt.item", "%1$s was shot by %2$s using %3$s");
	}
}