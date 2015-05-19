package javabuckets.mods.starwars.renderer;

import javabuckets.mods.starwars.model.item.ModelHandBlaster;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderDC17HandBlaster implements IItemRenderer
{
	protected ModelHandBlaster model;

	public RenderDC17HandBlaster()
	{
		model = new ModelHandBlaster();
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
		default: 
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		if (item.getItemDamage() == 1)
		{
			if (type == ItemRenderType.EQUIPPED)
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/dc-17_hand_blaster.png"));
				GL11.glRotatef(0, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(10, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(190, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.45F, -0.2F, -0.2F);
				
				float f = 1.75F;
				GL11.glScalef(f, f, f);
				
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/dc-17_hand_blaster.png"));
				GL11.glRotatef(0, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(10, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(190, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-1.75F, -0.3F, -0.25F);
				
				GL11.glScalef(f, f, f);
				
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/dc-17_hand_blaster.png"));
				GL11.glRotatef(210, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-30, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-0.45F, -0.42F, 0.2F);
				
				float f = 1.0F;
				GL11.glScalef(f, f, f);
				
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/dc-17_hand_blaster.png"));
				GL11.glRotatef(210, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-30, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-1.45F, -0.42F, 0.25F);
				
				GL11.glScalef(f, f, f);
				
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
		}
		else
		{
			if (type == ItemRenderType.EQUIPPED)
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/dc-17_hand_blaster.png"));
				GL11.glRotatef(0, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(10, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(190, 0.0F, 0.0F, 1.0F);
				GL11.glTranslatef(-0.45F, -0.2F, -0.2F);
				
				float f = 1.75F;
				GL11.glScalef(f, f, f);
				
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
			else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
			{
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/dc-17_hand_blaster.png"));
				GL11.glRotatef(210, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(-30, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(30, 1.0F, 0.0F, 0.0F);
				GL11.glTranslatef(-0.45F, -0.42F, 0.2F);
				
				float f = 1.0F;
				GL11.glScalef(f, f, f);
				
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
		}
	}
}