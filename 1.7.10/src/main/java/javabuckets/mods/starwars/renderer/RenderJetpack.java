package javabuckets.mods.starwars.renderer;

import javabuckets.mods.starwars.init.ModArmor;
import javabuckets.mods.starwars.model.item.ModelJetpackItem;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderJetpack extends RenderItem implements IItemRenderer
{
	protected ModelJetpackItem model;

	public RenderJetpack()
	{
		model = new ModelJetpackItem();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return type == type.INVENTORY || type == type.ENTITY;
	}
	
    protected ResourceLocation func_110796_a(EntityItem par1EntityItem)
    {
        return new ResourceLocation(Reference.MOD_ID, "textures/models/armor/jetpack" + (par1EntityItem.getEntityItem().getItem() == ModArmor.bobaFettJetpack ? "_boba" : "") + ".png");
    }

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		if (type == type.EQUIPPED || type == type.EQUIPPED_FIRST_PERSON || type == type.FIRST_PERSON_MAP)
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/armor/jetpack" + (item.getItem() == ModArmor.bobaFettJetpack ? "_boba" : "") + ".png"));
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(180, 0.0F, 0.5F, 0.0F);
			GL11.glTranslatef(-0.45F, -0.4F, -0.23F);

			float scale = 1.5F;
			GL11.glScalef(scale, scale, scale);
			model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		if (type == type.INVENTORY)
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/armor/jetpack" + (item.getItem() == ModArmor.bobaFettJetpack ? "_boba" : "") + ".png"));
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(180, 0.0F, 0.5F, 0.0F);
			GL11.glTranslatef(-0.3F, -0.75F, -0.23F);

			float scale = 1.8F;
			GL11.glScalef(scale, scale, scale);
			model.render(Minecraft.getMinecraft().thePlayer, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		if (type == type.ENTITY)
		{
			GL11.glPushMatrix();
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/armor/jetpack" + (item.getItem() == ModArmor.bobaFettJetpack ? "_boba" : "") + ".png"));
			GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(180, 0.0F, 0.5F, 0.0F);
			GL11.glTranslatef(-0.0F, -0.6F, -0.25F);

			float scale = 1.0F;
			GL11.glScalef(scale, scale, scale);
			model.render(Minecraft.getMinecraft().thePlayer, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
	}
}