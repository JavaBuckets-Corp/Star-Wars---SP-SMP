package javabuckets.mods.starwars.renderer;

import javabuckets.mods.starwars.init.ModWeapons;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.model.item.ModelSniper;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderScout extends ItemRenderer implements IItemRenderer
{
	protected ModelSniper model;

	public RenderScout()
	{
		super(Minecraft.getMinecraft());
		model = new ModelSniper();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		return type != type.INVENTORY && type != type.ENTITY;
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
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/sniper_rifle.png"));
			GL11.glRotatef(100, 0.5F, 5.0F, 5.0F);
			GL11.glRotatef(190, -5.0F, 4.5F, -5.2F);
			GL11.glTranslatef(0.45F, -0.3F, -0.5F);
			
			float f = 1.5F;
			GL11.glScalef(f, f, f);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			if (item != null && item.getItem() == ModWeapons.scoutSniperRifle)
			{
				Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/sniper_rifle.png"));
				GL11.glPushMatrix();
				float zoom = StarWars.proxy.getZoom();

				if (zoom <= 0)
				{
					GL11.glRotatef(110, 0.2F, 6.0F, 4.0F);
					GL11.glRotatef(165, -2.35F, 0.8F, 0.2F);
					GL11.glTranslatef(0.3F, -0.4F, -0.9F);
				}
				else if (zoom <= 1)
				{
					GL11.glRotatef(110, -0.6F, 6.0F, 4.0F);
					GL11.glRotatef(165, -2.35F, 0.8F, 0.2F);
					GL11.glTranslatef(0.45F, -0.4F, -1.05F);
				}
				else if (zoom <= 2)
				{
					GL11.glRotatef(100, -0.6F, 6.5F, 5.0F);
					GL11.glRotatef(165, -2.25F, 1.0F, 0.35F);
					GL11.glTranslatef(0.625F, -0.7F, -0.9F);
				}
				else if (zoom <= 3)
				{
					GL11.glRotatef(105, -0.6F, 6.5F, 5.0F);
					GL11.glRotatef(170, -2.45F, 1.0F, 0.35F);
					GL11.glTranslatef(0.7F, -0.6F, -1.0F);
				}
				else if (zoom <= 4)
				{
					GL11.glRotatef(110, 0.0F, 15.0F, 7.5F);
					GL11.glRotatef(180, -8.0F, 2.5F, -0.75F);
					GL11.glTranslatef(0.9575F, -0.65F, -0.7F);
				}
				else if (zoom <= 5)
				{
					GL11.glRotatef(110, 0.0F, 15.0F, 7.5F);
					GL11.glRotatef(180, -8.0F, 2.5F, -0.75F);
					GL11.glTranslatef(0.9575F, -0.65F, -0.5F);
				}
				else
				{
					GL11.glRotatef(110, 0.0F, 15.0F, 7.5F);
					GL11.glRotatef(180, -8.0F, 2.5F, -0.75F);
					GL11.glTranslatef(0.9575F, -100.65F, -0.5F);
				}
				
				float f = 1.1F;
				GL11.glScalef(f, f, f);
				model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
			}
		}
	}
}