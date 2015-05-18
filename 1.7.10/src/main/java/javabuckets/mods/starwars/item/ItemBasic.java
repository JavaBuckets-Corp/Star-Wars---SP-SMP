package javabuckets.mods.starwars.item;

import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBasic extends Item
{
	public ItemBasic(int maxStackSize) 
	{
		super();
		this.setMaxStackSize(maxStackSize);
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegistry) 
	{
		itemIcon = iconRegistry.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
