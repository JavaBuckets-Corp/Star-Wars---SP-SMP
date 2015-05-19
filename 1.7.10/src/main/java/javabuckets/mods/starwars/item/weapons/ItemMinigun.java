package javabuckets.mods.starwars.item.weapons;

import java.util.List;
import java.util.Random;

import javabuckets.mods.starwars.entity.EntityBlasterBolt;
import javabuckets.mods.starwars.init.ModEnchantments;
import javabuckets.mods.starwars.interfaces.IBlaster;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMinigun extends ItemBlasterBase implements IBlaster
{
	private int shotsFired;
	
	public ItemMinigun()
	{
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(StarWars.swTab);
	}
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
	{
		super.onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);
		EntityPlayer player = (EntityPlayer)par3Entity;
		
//		if (shotsFired > 0)
			
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.hasTagCompound())
		{
			par3List.add("Ammo: " + (250 - par1ItemStack.getTagCompound().getInteger("ammoUsed")) + "/250");
		}
		else
		{
			par3List.add("Ammo: 250/250");
		}
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if (par1ItemStack.getTagCompound().getInteger("ammoUsed") < 250)
		{
			Random rand = new Random();
			par3EntityPlayer.playSound(Reference.MOD_ID + ":" + "weapons_blaster", 1.0F, 0.8F / (rand.nextFloat() * 0.2F + 0.9F));			
			
			int k = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.enchantmentBlasterBurst.effectId, par1ItemStack);

			for (int i = 0; i < 1 + (k * 3); ++i)
			{
				EntityBlasterBolt bolt = new EntityBlasterBolt(par3EntityPlayer.worldObj, par3EntityPlayer, 2.0F, 5.0F, false, 0.0F, 0.6F, 0.0F);

				bolt.motionX += (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
				bolt.motionZ += (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
				par3EntityPlayer.worldObj.spawnEntityInWorld(bolt);
			}
			par1ItemStack.getTagCompound().setInteger("ammoUsed", par1ItemStack.getTagCompound().getInteger("ammoUsed") + 1);
		}
		else if (par3EntityPlayer.inventory.hasItem(Item.getItemFromBlock(Blocks.redstone_block)))
		{
			par3EntityPlayer.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.redstone_block));
			
			/*if (!par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(StarWarsObjectLoader.dechargedRedstoneBlock)))
            {
                par3EntityPlayer.dropPlayerItem(new ItemStack(StarWarsObjectLoader.dechargedRedstoneBlock.blockID, 1, 0));
            }*/
			
			par1ItemStack.getTagCompound().setInteger("ammoUsed", 0);
		}
		return par1ItemStack;
	}
}