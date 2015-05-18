package javabuckets.mods.starwars.init;

import cpw.mods.fml.common.registry.LanguageRegistry;
import javabuckets.mods.starwars.enchantment.EnchantmentBlasterBurst;
import javabuckets.mods.starwars.enchantment.EnchantmentSaberThrow;
import net.minecraft.enchantment.Enchantment;

public class ModEnchantments 
{
	public static Enchantment enchantmentLightsaberThrow = new EnchantmentSaberThrow(59, 10, "saberThrow");
	public static Enchantment enchantmentBlasterBurst = new EnchantmentBlasterBurst(60, 10, "blasterBurst");

	public static void init()
	{
		LanguageRegistry.instance().addStringLocalization("enchantment.saberThrow", "Throw");
		LanguageRegistry.instance().addStringLocalization("enchantment.blasterBurst", "Burst");
	}
}