package javabuckets.mods.starwars.handler;

import javabuckets.mods.starwars.init.ModWeapons;
import javabuckets.mods.starwars.interfaces.IZoomingItem;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.player.ExtendedPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SWEventHandler
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)event.entity) == null)
		{
			ExtendedPlayer.register((EntityPlayer)event.entity);
		}

		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
		{
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer)event.entity));
		}
	}
	
//	@SubscribeEvent
//	public void onWorldLoad(WorldEvent.Load event)
//	{
//		World world = event.world;
//
//		if (world.provider.dimensionId == 0)
//		{
//
//		}
//	}
//	
//	@SubscribeEvent
//	public void onPlayerFall(LivingFallEvent event)
//	{
//		if (event.entityLiving instanceof EntityPlayer)
//		{
//			EntityPlayer player = (EntityPlayer)event.entityLiving;
//			
//			/*if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem() instanceof IJetpack)
//			{
//				if (player.motionY > -0.7F)
//				{
//					event.setCanceled(true);
//				}
//			}*/
//		}
//	}
//	
//	@SubscribeEvent
//	public void onDrawItemTooltip(ItemTooltipEvent event)
//	{
//		/*if (event.itemStack.getItem() != null && StarWars.valueList[event.itemStack.itemID] != 0)
//		{
//			String s = String.valueOf(StarWars.stringValueList[event.itemStack.itemID]);
//			event.toolTip.add("" + s);
//		}*/
//	}

	@SubscribeEvent
	public void onFOVUpdate(FOVUpdateEvent event)
	{
		if (event.entity.getHeldItem() != null && event.entity.getHeldItem().getItem() == ModWeapons.scoutSniperRifle)
		{
			if (event.entity.getHeldItem().hasTagCompound() && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)
			{
				event.newfov -= StarWars.proxy.getZoom() / 10;
			}
		}
	}
	
	@SubscribeEvent
	public void onUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			
			/*if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && Keyboard.isKeyDown(Keyboard.KEY_F))
			{
				player.addChatMessage(new ChatComponentText("Current Force Faction for player with UUID " + "9e789110-2189-488e-a609-5adf9eb96bb4" + ": " + StarWars.instance.forceServerUtil.getForceFactionFromUUID(player.getUniqueID().toString())));
				//player.addChatMessage(new ChatComponentText("Current Force Faction for player with UUID " + "KingOfAmager's UUID Here!" + ": " + StarWars.instance.forceHandler.getForceFactionFromUUID(player.getUniqueID().toString())));
			}*/
			
			if (player.getHeldItem() != null && player.getHeldItem().getItem() instanceof IZoomingItem)
			{
				IZoomingItem zoomItem = (IZoomingItem)player.getHeldItem().getItem();
				
				if (Keyboard.isKeyDown(zoomItem.getZoomKey()) && Minecraft.getMinecraft().currentScreen == null)
				{
					if (StarWars.proxy.getZoom() < 10)
					{
						StarWars.proxy.setZoom(StarWars.proxy.getZoom() + 1.0F);
					}
				}
				else
				{
					if (StarWars.proxy.getZoom() > 0)
					{
						StarWars.proxy.setZoom(StarWars.proxy.getZoom() - 1.0F);
					}
				}
			}
			
			StarWars.instance.force.update(player, player.worldObj);
		}
	}
}