package javabuckets.mods.starwars.force;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Force 
{
	private String forceFaction = "Private";
	private float forcePowers;
	
	public void init(EntityPlayer player, World world)
	{
		
	}
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		par1NBTTagCompound.setString("forceFaction", this.forceFaction);
		par1NBTTagCompound.setFloat("forcePowers", this.forcePowers);
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		this.forceFaction = par1NBTTagCompound.getString("forceFaction");
		this.forcePowers = par1NBTTagCompound.getFloat("forcePowers");
	}
	
	public void setForceFaction(String forceFaction) 
	{
		this.forceFaction = forceFaction;
	}
	
	public String getForceFaction() 
	{
		return forceFaction;
	}
	
	public void setForcePowers(float forcePowers) 
	{
		this.forcePowers = forcePowers;
	}
	
	public float getForcePowers() 
	{
		return forcePowers;
	}
}