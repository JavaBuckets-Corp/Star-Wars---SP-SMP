package javabuckets.mods.starwars.player;

import java.util.HashMap;
import java.util.Map;

import javabuckets.mods.starwars.force.ForceServerUtil;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties
{
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	private final EntityPlayer player;

	public ExtendedPlayer(EntityPlayer player)
	{
		this.player = player;
	}

	/**
	 * Used to register these extended properties for the player during EntityConstructing event
	 */
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}

	/**
	 * Returns ExtendedPlayer properties for player
	 */
	public static final ExtendedPlayer get(EntityPlayer player)
	{
		return (ExtendedPlayer)player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();
		StarWars.instance.force.writeToNBT(properties);
		
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound)compound.getTag(EXT_PROP_NAME);	
		StarWars.instance.force.readFromNBT(properties);
	}

	@Override
	public void init(Entity entity, World world)
	{
		if (entity instanceof EntityPlayer)
		{	
			StarWars.instance.force.init(this.player, world);
		}	
	}	
}