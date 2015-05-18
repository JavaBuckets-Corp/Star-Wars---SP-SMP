package javabuckets.mods.starwars.init;

import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModEnums 
{
	public static Item.ToolMaterial enumToolMaterialLightsaber = EnumHelper.addToolMaterial("lightsaber", 2, 4, 2.0F, 10.0F, 10);
	public static Item.ToolMaterial enumToolMaterialDoubleLightsaber = EnumHelper.addToolMaterial("lightsaberDouble", 2, 4, 2.0F, 24.0F, 10);

	public static ItemArmor.ArmorMaterial enumArmorMaterialMandalorian = EnumHelper.addArmorMaterial("mandalorian", 26, new int[]{3, 8, 6, 3}, 10);
	
	public static EnumAction enumActionReload;
}