package javabuckets.mods.starwars.force;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class Force 
{
	private String forceFaction = ForceReference.Newbie;
	private float forcePowers = 100F;
	
	public void init(EntityPlayer player, World world)
	{
		
	}
	
	public void update(EntityPlayer player, World world)
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
	
	public boolean getCanPlayerUseForce()
	{
		if (this.forceFaction == ForceReference.F_Private || this.forceFaction == ForceReference.F_Soldier || this.forceFaction == ForceReference.F_Sergeant || this.forceFaction == ForceReference.F_Commander || this.forceFaction == ForceReference.F_Elite || this.forceFaction == ForceReference.F_SurpremeElite)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}