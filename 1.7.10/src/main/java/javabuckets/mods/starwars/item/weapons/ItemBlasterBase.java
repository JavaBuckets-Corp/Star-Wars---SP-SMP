package javabuckets.mods.starwars.item.weapons;

import javabuckets.mods.starwars.init.ModEnums;
import javabuckets.mods.starwars.item.ItemBasic;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemBlasterBase extends ItemBasic
{
	public ItemBlasterBase()
	{
		super(1);
	}

	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
	{
		EntityPlayer player = (EntityPlayer)par3Entity;
		
		if (!par1ItemStack.hasTagCompound())
		{
			par1ItemStack.setTagCompound(new NBTTagCompound());
		}
	}
	
	public int getItemEnchantability()
    {
        return 10;
    }
	
	public boolean onLeftClickEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, Entity par3Entity)
    {
    	return true;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return ModEnums.enumActionReload;
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        return false;
    }
    
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
    	return 0.0F;
    }
    
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		return true;
	}
    
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
    	par3EntityPlayer.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.redstone_block));
		
		/*if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ModBlocks.dechargedRedstoneBlock)))
        {
            par3EntityPlayer.dropPlayerItem(new ItemStack(ModBlocks.dechargedRedstoneBlock, 1, 0));
        }*/
		
		par1ItemStack.getTagCompound().setInteger("ammoUsed", 0);
		
		return par1ItemStack;
	}
}