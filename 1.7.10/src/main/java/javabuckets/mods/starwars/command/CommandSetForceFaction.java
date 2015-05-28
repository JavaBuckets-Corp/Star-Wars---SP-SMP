package javabuckets.mods.starwars.command;

import java.util.List;

import javabuckets.mods.starwars.force.ForceHandler;
import javabuckets.mods.starwars.force.ForceReference;
import javabuckets.mods.starwars.main.StarWars;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class CommandSetForceFaction extends CommandBase
{
	public String getCommandName() 
	{
		return "setforcefaction";
	}

	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/setforcefaction <forceFaction>";
	}

	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if (icommandsender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)icommandsender;

			if (player.capabilities.isCreativeMode)
			{
				if(astring.length == 0)
				{
					icommandsender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: /setforcefaction <forceFaction>"));
					return;
				}

				setCommandSenderForceFaction(icommandsender, astring, ForceReference.Newbie);
				setCommandSenderForceFaction(icommandsender, astring, ForceReference.F_Private);
				setCommandSenderForceFaction(icommandsender, astring, ForceReference.F_Soldier);
				setCommandSenderForceFaction(icommandsender, astring, ForceReference.F_Sergeant);
				setCommandSenderForceFaction(icommandsender, astring, ForceReference.F_Commander);
				setCommandSenderForceFaction(icommandsender, astring, ForceReference.F_Elite.replace(' ', '_'));
				setCommandSenderForceFaction(icommandsender, astring, ForceReference.F_SurpremeElite.replace(' ', '_'));
			}
		}
	}

	public void setCommandSenderForceFaction(ICommandSender icommandsender, String[] astring, String forceFaction)
	{
		EntityPlayer player = (EntityPlayer)icommandsender;
		
		if (astring[0].equalsIgnoreCase(forceFaction))
		{
			StarWars.instance.forceHandler.setForceFactionToUUID(player.getUniqueID().toString(), forceFaction.replace('_', ' '));
			StarWars.instance.force.setForceFaction(forceFaction.replace('_', ' '));
			icommandsender.addChatMessage(new ChatComponentText(icommandsender.getCommandSenderName() + " have been added to the " + forceFaction.replace('_', ' ') + " force faction"));
		}	
	}

	public List addTabCompletionOptions(ICommandSender par1iCommandSender, String[] astring) 
	{
		if (astring.length == 1)
		{
			return getListOfStringsMatchingLastWord(astring, new String[] 
					{ 
						ForceReference.Newbie, 
						ForceReference.F_Private, 
						ForceReference.F_Soldier, 
						ForceReference.F_Sergeant, 
						ForceReference.F_Commander, 
						ForceReference.F_Elite.replace(' ', '_'), 
						ForceReference.F_SurpremeElite.replace(' ', '_') 
					});
		}
		return null;
	}
}