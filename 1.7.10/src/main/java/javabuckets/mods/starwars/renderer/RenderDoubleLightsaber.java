package javabuckets.mods.starwars.renderer;

import javabuckets.mods.starwars.init.ModWeapons;
import javabuckets.mods.starwars.model.item.ModelDoubleLightsaber;
import javabuckets.mods.starwars.model.item.ModelLightsaber;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderDoubleLightsaber implements IItemRenderer
{
	protected ModelDoubleLightsaber model2;
	protected ModelLightsaber model;

	public RenderDoubleLightsaber()
	{
		model2 = new ModelDoubleLightsaber();
		model = new ModelLightsaber();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch(type)
		{
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case ENTITY:
			return true;
		default: 
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return type == type.ENTITY;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		if (type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			GL11.glPushMatrix();
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(-30, 0.0F, 0.0F, 1.0F);
			if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
			{
				GL11.glRotatef(-20, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(20, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(0.0F, -0.3F, -0.0F);
			}
			GL11.glTranslatef(0.7F, -0.575F, 0.0F);
			
			float scale = 0.525F;
			GL11.glScalef(scale, scale, scale);
			
			if (item.hasTagCompound() && item.getTagCompound().getBoolean("active"))
			{
				float[] afloat = new float[3];
				if (item.getItem() == ModWeapons.blueDoubleLightsaber) {afloat[0] = 0.0F; afloat[1] = 0.5F; afloat[2] = 1F;}
				if (item.getItem() == ModWeapons.redDoubleLightsaber) {afloat[0] = 1.0F; afloat[1] = 0.0F; afloat[2] = 0.0F;}
				if (item.getItem() == ModWeapons.greenDoubleLightsaber) {afloat[0] = 0.0F; afloat[1] = 1.0F; afloat[2] = 0.0F;}
				if (item.getItem() == ModWeapons.purpleDoubleLightsaber) {afloat[0] = 1.0F; afloat[1] = 0.0F; afloat[2] = 1.0F;}

				
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("null"));
				GL11.glEnable(GL11.GL_BLEND);
				GL11.glDisable(GL11.GL_TEXTURE_2D);
		        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		        GL11.glColor3f(1.0F, 1.0F, 1.0F);
				model.renderInner((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPushMatrix();
				GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.0F, -2.68F, 0.0F);
				model.renderInner((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				
				GL11.glColor4f(afloat[0], afloat[1], afloat[2], 0.75F);
				model.renderOuter((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPushMatrix();
				GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(0.0F, -2.68F, 0.0F);
				model.renderOuter((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				GL11.glEnable(GL11.GL_TEXTURE_2D);
			}
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/double_lightsaber.png"));

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glTranslatef(0.0F, 1.34F, 0.0F);

			float scale1 = 0.6F;
			GL11.glScalef(scale1, scale1, scale1);
			model2.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			model2.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		if (type == ItemRenderType.ENTITY)
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/double_lightsaber.png"));
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, -0.4F, 0.25F);
			
			float scale1 = 0.4F;
			GL11.glScalef(scale1, scale1, scale1);
			model2.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			model2.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}
}