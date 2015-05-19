package javabuckets.mods.starwars.item.weapons;

import java.util.List;
import java.util.Random;

import javabuckets.mods.starwars.entity.EntityBlasterBolt;
import javabuckets.mods.starwars.init.ModEnchantments;
import javabuckets.mods.starwars.interfaces.IBlaster;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHandBlaster extends ItemBlasterBase implements IBlaster
{
	private boolean isDual = false;

	public ItemHandBlaster(boolean flag)
	{
		super();
		this.isDual = flag;
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setCreativeTab(StarWars.swTab);
	}

	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(this, 1, 0));
		par3List.add(new ItemStack(this, 1, 1));
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		if (par1ItemStack.hasTagCompound())
		{
			par3List.add("Ammo: " + (48 - par1ItemStack.getTagCompound().getInteger("ammoUsed")) + "/48");
		}
		else
		{
			par3List.add("Ammo: 48/48");
		}
	}

	public String getItemDisplayName(ItemStack par1ItemStack)
	{
		return par1ItemStack.getItemDamage() == 1 ? "Dual DC-17 Hand Blasters" : super.getItemStackDisplayName(par1ItemStack); 
	}

	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
	{
		player.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		return par1ItemStack;
	}

	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 7480;
	}

	public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer player, int par4)
	{
		if (par1ItemStack.getTagCompound().getInteger("ammoUsed") < 48)
		{
			Random rand = new Random();
			player.playSound(Reference.MOD_ID + ":" + "weapons_blaster", 1.0F, 0.8F / (rand.nextFloat() * 0.2F + 0.9F));			
			
			int k = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.enchantmentBlasterBurst.effectId, par1ItemStack);

			for (int i = 0; i < 1 + (k * 3); ++i)
			{
				EntityBlasterBolt bolt = new EntityBlasterBolt(player.worldObj, player, 2.0F, 5.0F, false, 0.0F, 0.6F, 0.0F);

				bolt.motionX += (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
				bolt.motionZ += (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
				player.worldObj.spawnEntityInWorld(bolt);
			}

			par1ItemStack.getTagCompound().setInteger("ammoUsed", par1ItemStack.getTagCompound().getInteger("ammoUsed") + 1);
		}
		else if (player.inventory.hasItem(Item.getItemFromBlock(Blocks.redstone_block)))
		{
			player.inventory.consumeInventoryItem(Item.getItemFromBlock(Blocks.redstone_block));

			/*if (!player.inventory.addItemStackToInventory(new ItemStack(StarWarsObjectLoader.dechargedRedstoneBlock)))
			{
				player.dropPlayerItem(new ItemStack(StarWarsObjectLoader.dechargedRedstoneBlock.blockID, 1, 0));
			}*/

			par1ItemStack.getTagCompound().setInteger("ammoUsed", 0);
		}
	}

	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		if (entityLiving instanceof EntityPlayer)
		{
			if (stack.getItemDamage() == 1 && stack.getTagCompound().getInteger("ammoUsed") < 48)
			{
				Random rand = new Random();
				EntityPlayer player = (EntityPlayer)entityLiving;
				player.playSound(Reference.MOD_ID + ":" + "weapons_blaster", 1.0F, 0.8F / (rand.nextFloat() * 0.2F + 0.9F));			

				int k = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.enchantmentBlasterBurst.effectId, stack);

				for (int i = 0; i < 1 + (k * 3); ++i)
				{
					EntityBlasterBolt bolt = new EntityBlasterBolt(player.worldObj, player, 2.0F, 5.0F, false, 0.0F, 0.6F, 0.0F);

					bolt.motionX += (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
					bolt.motionZ += (rand.nextFloat()/4)-(rand.nextFloat()/4) + 0.05F;
					player.worldObj.spawnEntityInWorld(bolt);
				}
				
				stack.getTagCompound().setInteger("ammoUsed", stack.getTagCompound().getInteger("ammoUsed") + 1);
			}
		}
		return true;
	}
}