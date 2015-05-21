package javabuckets.mods.starwars.item;

import java.util.List;

import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMetaBasic extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	private final String[] itemNames;
	
	public ItemMetaBasic(String... itemNames)
	{
		super();
		this.itemNames = itemNames;
		this.setHasSubtypes(true);
	}
	
	public ItemMetaBasic(CreativeTabs tab, String... itemNames)
	{
		this(itemNames);
		this.setCreativeTab(tab);
	}
	
	public void getSubItems(CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < itemNames.length; ++i)
		{
			par3List.add(new ItemStack(this, 1, i));
		}
	}
	
	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		return itemNames[par1ItemStack.getItemDamage()];
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
	{
		return icons[par1];
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		icons = new IIcon[itemNames.length];
		
		for (int i = 0; i < itemNames.length; ++i)
		{
			icons[i] = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + itemNames[i]);
		}
	}
}