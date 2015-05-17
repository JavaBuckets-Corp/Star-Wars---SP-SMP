package javabuckets.mods.starwars.gui.hud;

import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import scala.tools.nsc.MainClass;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HUDMandalorian extends Gui
{
	private Minecraft mc;
	private RenderItem itemRenderer;
	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/mod_icons.png");

	public HUDMandalorian(Minecraft mc)
	{
		super();
		this.mc = mc;
		this.itemRenderer = new RenderItem();
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event)
	{
		int width = event.resolution.getScaledWidth();
		int height = event.resolution.getScaledHeight();
		//renderMandalorianHelmet(event, width, height);
	}

	/*public void renderMandalorianHelmet(RenderGameOverlayEvent event, int width, int height)
	{			
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		if (this.mc.thePlayer.getCurrentArmor(4) != null && (this.mc.thePlayer.getCurrentArmor(4).getItem() == ModArmor.mandalorianHelmet || this.mc.thePlayer.getCurrentArmor(4).getItem() == ModArmor.bobaFettMandalorianHelmet))
		{
			mc.renderEngine.bindTexture(new ResourceLocation("null"));
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(0F, 0F, 0F, 0.3F);
			drawTexturedModalRect(5, 5, 0, 0, 20, 20);
			GL11.glColor4f(0F, 0F, 0F, 0.35F);
			drawTexturedModalRect(6, 6, 0, 0, 18, 18);
			GL11.glEnable(GL11.GL_TEXTURE_2D);

			RenderHelper.enableGUIStandardItemLighting();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glEnable(GL11.GL_COLOR_MATERIAL);
			GL11.glEnable(GL11.GL_LIGHTING);
			this.itemRenderer.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.getTextureManager(), new ItemStack(ModArmor.mandalorianHelmet), 7, 8);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDepthMask(true);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			//			if (!BountySystem.hasLBeenPressed)
			//			{
			//				this.drawString(fontrenderer, EnumChatFormatting.ITALIC + "Press 'L' to open up", 27, 6, 893874);
			//				this.drawString(fontrenderer, EnumChatFormatting.ITALIC + "the Bounty Menu.", 27, 16, 893874);
			//			}
		}
	}*/
}