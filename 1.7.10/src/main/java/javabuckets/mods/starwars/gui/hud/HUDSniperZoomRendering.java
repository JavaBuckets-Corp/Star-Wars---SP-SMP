package javabuckets.mods.starwars.gui.hud;

import org.lwjgl.opengl.GL11;

import javabuckets.mods.starwars.interfaces.IZoomingItem;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HUDSniperZoomRendering extends Gui
{
	private Minecraft mc;
	private RenderItem itemRenderer;
	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/mod_icons.png");

	public HUDSniperZoomRendering(Minecraft mc)
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
		renderSniperZoom(event, width, height);
	}

	public void renderSniperZoom(RenderGameOverlayEvent event, int width, int height)
	{		
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}
		
		if (mc.thePlayer.getHeldItem() != null && mc.thePlayer.getHeldItem().getItem() instanceof IZoomingItem)
		{
			if (mc.thePlayer.getHeldItem().hasTagCompound() && StarWars.proxy.getZoom() > 5 && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0)
			{
				Tessellator tessellator = Tessellator.instance;
				Minecraft.getMinecraft().getTextureManager().bindTexture(((IZoomingItem)mc.thePlayer.getHeldItem().getItem()).getZoomOverlay());

				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDisable(GL11.GL_DEPTH_TEST);
				GL11.glDepthMask(false);
				GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GL11.glDisable(GL11.GL_ALPHA_TEST);
				tessellator.startDrawingQuads();
				tessellator.addVertexWithUV(0.0D, (double)height, -90.0D, 0.0D, 1.0D);
				tessellator.addVertexWithUV((double)width, (double)height, -90.0D, 1.0D, 1.0D);
				tessellator.addVertexWithUV((double)width, 0.0D, -90.0D, 1.0D, 0.0D);
				tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
				tessellator.draw();
				GL11.glDepthMask(true);
				GL11.glEnable(GL11.GL_DEPTH_TEST);
				GL11.glEnable(GL11.GL_ALPHA_TEST);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}