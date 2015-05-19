package javabuckets.mods.starwars.renderer;

import javabuckets.mods.starwars.entity.item.EntityLightsaber;
import javabuckets.mods.starwars.init.ModWeapons;
import javabuckets.mods.starwars.model.item.ModelLightsaber;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLightsaberEntity extends Render
{
	private static final ResourceLocation textures = new ResourceLocation(Reference.MOD_ID, "textures/entitys/laserBolt.png");
    private ModelLightsaber model;
    
    public RenderLightsaberEntity()
    {
    	model = new ModelLightsaber();
	}
    
    public void renderSaber(EntityLightsaber par1EntityLightsaber, double d, double d1, double d2, float d3, float f)
    {
        this.bindEntityTexture(par1EntityLightsaber);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0F, (float)d1, (float)d2 + 0.0F);

        ItemStack item = par1EntityLightsaber.getLightsaber();
        
        float f1 = par1EntityLightsaber.ticksExisted * 36;
        GL11.glRotatef(90, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(f1, 1.0F, 0.0F, 0.0F);
        
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/lightsaber.png"));


		float scale = 0.525F;
		GL11.glScalef(scale, scale, scale);
		model.render(par1EntityLightsaber, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		
		if (item.hasTagCompound() && item.getTagCompound().getBoolean("active"))
		{
			float[] afloat = new float[3];
			if (item.getItem() == ModWeapons.blueLightsaber) {afloat[0] = 0.0F; afloat[1] = 0.5F; afloat[2] = 1F;}
			if (item.getItem() == ModWeapons.redLightsaber) {afloat[0] = 1.0F; afloat[1] = 0.0F; afloat[2] = 0.0F;}
			if (item.getItem() == ModWeapons.greenLightsaber) {afloat[0] = 0.0F; afloat[1] = 1.0F; afloat[2] = 0.0F;}
			if (item.getItem() == ModWeapons.purpleLightsaber) {afloat[0] = 1.0F; afloat[1] = 0.0F; afloat[2] = 1.0F;}

			
			Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("null"));
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        GL11.glColor3f(1.0F, 1.0F, 1.0F);
			model.renderInner(par1EntityLightsaber, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

			GL11.glColor4f(afloat[0], afloat[1], afloat[2], 0.75F);
			model.renderOuter(par1EntityLightsaber, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return textures;
    }
    
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderSaber((EntityLightsaber)par1Entity, par2, par4, par6, par8, par9);
    }
}