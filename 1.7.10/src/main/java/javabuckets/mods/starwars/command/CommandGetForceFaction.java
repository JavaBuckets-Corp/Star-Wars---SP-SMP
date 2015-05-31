package javabuckets.mods.starwars.command;

import java.util.List;

import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.LogHelper;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class CommandGetForceFaction extends CommandBase
{
	public String getCommandName() 
	{
		return "getforcefaction";
	}

	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/getforcefaction <player>";
	}

	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if (icommandsender instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)icommandsender;

			if(astring.length == 0)
			{
				icommandsender.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "Usage: /getforcefaction <player>"));
				return;
			}

			icommandsender.addChatMessage(new ChatComponentText("Force Faction: " + StarWars.instance.force.getForceFaction()));
		}
	}
	
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
    {
        return astring.length >= 1 ? getListOfStringsMatchingLastWord(astring, MinecraftServer.getServer().getAllUsernames()) : null;
    }
}