package javabuckets.mods.starwars.item.weapons;

import java.util.List;
import java.util.Random;

import javabuckets.mods.starwars.entity.EntityBlasterBolt;
import javabuckets.mods.starwars.init.ModEnchantments;
import javabuckets.mods.starwars.interfaces.IBlaster;
import javabuckets.mods.starwars.interfaces.IZoomingItem;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSniper extends ItemBlasterBase implements IZoomingItem, IBlaster
{
	public ItemSniper()
	{
		super();
		this.setMaxStackSize(1);
		this.setCreativeTab(StarWars.swTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.hasTagCompound())
		{
			par3List.add("Ammo: " + (10 - par1ItemStack.getTagCompound().getInteger("ammoUsed")) + "/10");
		}
		else
		{
			par3List.add("Ammo: 10/10");
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getZoomKey()
	{
		return Keyboard.KEY_UP;
	}
	
	@SideOnly(Side.CLIENT)
	public ResourceLocation getZoomOverlay()
	{
		return new ResourceLocation(Reference.MOD_ID, "textures/misc/sniperScope.png");
	}
	
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if (entityLiving instanceof EntityPlayer)
		{
			if (stack.getTagCompound().getInteger("ammoUsed") < 10)
			{
				Random rand = new Random();
				entityLiving.worldObj.spawnEntityInWorld(new EntityBlasterBolt(entityLiving.worldObj, (EntityPlayer)entityLiving, 30.0F, 20.0F, false));
				entityLiving.playSound(Reference.MOD_ID + ":" + "weapons_blaster", 1.0F, 0.8F / (rand.nextFloat() * 0.2F + 0.9F));

				int k = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.enchantmentBlasterBurst.effectId, stack);
				
				for (int i = 0; i < k * 3; ++i)
				{
					EntityBlasterBolt bolt = new EntityBlasterBolt(entityLiving.worldObj, (EntityPlayer)entityLiving, 30.0F, 20.0F, true);
					
					bolt.motionX += i == 0 ? 0 : (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
					bolt.motionZ += i == 0 ? 0 : (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
					entityLiving.worldObj.spawnEntityInWorld(bolt);
				}
				
				stack.getTagCompound().setInteger("ammoUsed", stack.getTagCompound().getInteger("ammoUsed") + 1);
			}
		}
		return true;
	}
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 50;
    }
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{		
		if (par1ItemStack.hasTagCompound())
		{
			if (par1ItemStack.getTagCompound().getInteger("ammoUsed") >= 10 && par3EntityPlayer.inventory.hasItem(Item.getItemFromBlock(Blocks.redstone_block)))
			{
				par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
			}
		}
		return par1ItemStack;
	}
}