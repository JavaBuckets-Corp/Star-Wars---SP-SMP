package javabuckets.mods.starwars.gui.hud;

import javabuckets.mods.starwars.force.ForceReference;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class HUDForce extends Gui
{
	private Minecraft mc;
	private RenderItem itemRenderer;
	public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/mod_icons.png");

	protected final ResourceLocation forceDisplay = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_display.png");
	protected final ResourceLocation forcePowers = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_display_powers.png");

	protected final ResourceLocation forcePositive4 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_4.png");
	protected final ResourceLocation forcePositive3 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_3.png");
	protected final ResourceLocation forcePositive2 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_2.png");
	protected final ResourceLocation forcePositive1 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_1.png");
	protected final ResourceLocation forceNeutral0 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_0.png");
	protected final ResourceLocation forceNegative1 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_-1.png");
	protected final ResourceLocation forceNegative2 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_-2.png");
	protected final ResourceLocation forceNegative3 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_-3.png");
	protected final ResourceLocation forceNegative4 = new ResourceLocation(Reference.MOD_ID, "textures/gui/force/force_level_-4.png");

	public HUDForce(Minecraft mc)
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
		renderForce(event, width, height);
	}

	public void renderForce(RenderGameOverlayEvent event, int width, int height)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		String ff = StarWars.instance.force.getForceFaction();
		
		//this.drawString(this.mc.fontRenderer, ff.replace('_', ' '), 35, 35, 0xFFFFFF);
		
		this.mc.fontRenderer.drawString(EnumChatFormatting.ITALIC + ff.replace('_', ' ') + EnumChatFormatting.RESET, 35, 35, 0xFFFFFF, false);

		if (StarWars.instance.force.getCanPlayerUseForce())
		{
			mc.renderEngine.bindTexture(forceDisplay);
			this.drawTexturedModalRect(10, 10, 0, 0, 256, 256);

			int startPoint = 13;

			mc.renderEngine.bindTexture(forcePowers);
			this.drawTexturedModalRect(10 + startPoint, 10, startPoint, 0, (int)StarWars.instance.force.getForcePowers(), 256);

			//this.drawCenteredString(mc.fontRenderer, "" + ff, width / 2, 10, 0xFFFFFF);
			//this.drawCenteredString(mc.fontRenderer, "" + StarWars.instance.force.getForcePowers(), width / 2, 10, 0xFFFFFF);

			if (ff == ForceReference.FF_JediMaster) { mc.renderEngine.bindTexture(forcePositive4); }
			else if (ff == ForceReference.FF_Jedi) { mc.renderEngine.bindTexture(forcePositive3); }
			else if (ff == ForceReference.FF_JediKnight) { mc.renderEngine.bindTexture(forcePositive2); }
			else if (ff == ForceReference.FF_Padawan) { mc.renderEngine.bindTexture(forcePositive1); }
			else if (ff == ForceReference.Newbie) { mc.renderEngine.bindTexture(forceNeutral0); }
			else if (ff == ForceReference.SF_SithSpawn) { mc.renderEngine.bindTexture(forceNegative1); }
			else if (ff == ForceReference.SF_SithTrainee) { mc.renderEngine.bindTexture(forceNegative2); }
			else if (ff == ForceReference.SF_Sith) { mc.renderEngine.bindTexture(forceNegative3); }
			else if (ff == ForceReference.SF_SithLord) { mc.renderEngine.bindTexture(forceNegative4); }

			this.drawTexturedModalRect(10, 10, 0, 0, 256, 256);
		}
	}
}