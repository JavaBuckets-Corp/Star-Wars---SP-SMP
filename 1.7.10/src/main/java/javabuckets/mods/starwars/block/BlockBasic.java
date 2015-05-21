package javabuckets.mods.starwars.block;

import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockBasic extends Block
{
	public BlockBasic(Material material) 
	{
		super(material);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f1, float f2, float f3) 
	{
		
		return true;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegistry) 
	{
		blockIcon = iconRegistry.registerIcon(Reference.MOD_ID + ":" + this.getTextureName());
	}
}