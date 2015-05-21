package javabuckets.mods.starwars.block;

import java.util.Random;

import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.tileentity.TileEntityCharger;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import scala.tools.nsc.MainClass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCharger extends Block implements ITileEntityProvider
{
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;
	
	public BlockCharger()
	{
		super(Material.iron);
		this.setCreativeTab(StarWars.swTab);
	}

	public TileEntity createNewTileEntity(World par1World, int par2)
	{
		return new TileEntityCharger();
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (!par5EntityPlayer.isSneaking())
		{
			par5EntityPlayer.openGui(StarWars.instance, 0, par1World, par2, par3, par4);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
	{
		Random rand = new Random();
		TileEntityCharger tileentitycharger = (TileEntityCharger)par1World.getTileEntity(par2, par3, par4);

		if (tileentitycharger != null)
		{
			for (int j1 = 0; j1 < tileentitycharger.getSizeInventory(); ++j1)
			{
				ItemStack itemstack = tileentitycharger.getStackInSlot(j1);

				if (itemstack != null)
				{
					float f = rand.nextFloat() * 0.8F + 0.1F;
					float f1 = rand.nextFloat() * 0.8F + 0.1F;
					float f2 = rand.nextFloat() * 0.8F + 0.1F;

					while (itemstack.stackSize > 0)
					{
						int k1 = rand.nextInt(21) + 10;

						if (k1 > itemstack.stackSize)
						{
							k1 = itemstack.stackSize;
						}

						itemstack.stackSize -= k1;
						EntityItem entityitem = new EntityItem(par1World, (double)((float)par2 + f), (double)((float)par3 + f1), (double)((float)par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

						if (itemstack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
						}

						float f3 = 0.05F;
						entityitem.motionX = (double)((float)rand.nextGaussian() * f3);
						entityitem.motionY = (double)((float)rand.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double)((float)rand.nextGaussian() * f3);
						par1World.spawnEntityInWorld(entityitem);
					}
				}
			}

			par1World.func_147453_f(par2, par3, par4, par5);
		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
	{
		int rotation = MathHelper.floor_double((double)((par5EntityLivingBase.rotationYaw * 4F) / 360F) + 2.5D) & 3;
		par1World.setBlockMetadataWithNotify(par2, par3, par4, rotation, 2);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? top : (par1 == 0 ? blockIcon : side);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) 
	{
		blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_bottom");
		side = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_side");
		top = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_top");
	}
}