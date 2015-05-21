package javabuckets.mods.starwars.block;

import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;

import javax.swing.Icon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockWeaponForge extends BlockBasic
{
	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon side;
	
	public BlockWeaponForge()
	{
		super(Material.iron);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		if (!par5EntityPlayer.isSneaking())
		{
			par5EntityPlayer.openGui(StarWars.instance, 1, par1World, par2, par3, par4);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par1 == 1 ? top : (par1 == 0 ? blockIcon : side);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) 
	{
		blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getTextureName());
		side = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_side");
		top = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_top");
	}
}