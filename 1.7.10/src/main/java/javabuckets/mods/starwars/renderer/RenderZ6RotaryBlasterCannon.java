package javabuckets.mods.starwars.renderer;

import javabuckets.mods.starwars.model.item.ModelMinigun;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderZ6RotaryBlasterCannon implements IItemRenderer
{
	protected ModelMinigun model;

	public RenderZ6RotaryBlasterCannon()
	{
		model = new ModelMinigun();
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
		if (type == ItemRenderType.EQUIPPED)
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/z-6_rotary_blaster_cannon.png"));
			GL11.glRotatef(190, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(10, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(170, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(0.3F, 0.5F, -0.8F);
			
			float f = 1.75F;
			GL11.glScalef(f, f, f);
			
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/z-6_rotary_blaster_cannon.png"));
			GL11.glRotatef(110, 0.2F, 6.0F, 4.0F);
			GL11.glRotatef(165, -2.35F, 0.8F, 0.2F);
			GL11.glRotatef(0, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-10, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.6F, -0.0F, -0.55F);
			
			float f = 1.0F;
			GL11.glScalef(f, f, f);
			
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}
}