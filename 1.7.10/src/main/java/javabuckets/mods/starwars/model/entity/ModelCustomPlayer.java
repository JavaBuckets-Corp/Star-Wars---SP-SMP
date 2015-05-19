package javabuckets.mods.starwars.model.entity;

import javabuckets.mods.starwars.init.ModWeapons;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCustomPlayer extends ModelBiped
{	
	public ModelCustomPlayer()
    {
        this(0.0F);
    }

    public ModelCustomPlayer(float par1)
    {
        this(par1, 0.0F, 64, 32);
    }

    public ModelCustomPlayer(float par1, float par2, int par3, int par4)
    {
    	super(par1, par2, par3, par4);
    }
    
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
    	super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    	EntityLivingBase entity = (EntityLivingBase)par7Entity;
    	
    	
    	
    	/*if (entity.getHeldItem() != null && entity.getHeldItem() == ModWeapons.handBlaster)
    	{
    		if (entity.getHeldItem().getItemDamage() == 1)
    		{
        		this.bipedLeftArm.rotateAngleX = -1.4F;
        		this.bipedLeftArm.rotateAngleY = 0.0F;
        		this.bipedLeftArm.rotateAngleZ = 0.0F;
        		this.bipedRightArm.rotateAngleX = -1.4F;
        		this.bipedRightArm.rotateAngleY = 0.0F;
        		this.bipedRightArm.rotateAngleZ = 0.0F;
        		this.bipedRightArm.rotateAngleX = -1.4F + (par5 / (180F / (float)Math.PI));
        		this.bipedLeftArm.rotateAngleX = -1.4F + (par5 / (180F / (float)Math.PI));
    		}
    		else
    		{
    			this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
    	        this.bipedRightArm.rotateAngleY = par4 / (180F / (float)Math.PI);
    	        this.bipedRightArm.rotateAngleX = -1.4F + (par5 / (180F / (float)Math.PI));
    		}
    	}
    	else if (entity.getHeldItem() != null && entity.getHeldItem() == ModWeapons.minigun)
    	{
    		this.bipedLeftArm.setRotationPoint(4.0F, 3.0F, -2.0F);
    		this.bipedRightArm.setRotationPoint(-4.0F, 2.3F, 0.0F);
    		this.bipedLeftArm.rotateAngleX = -1.1F;
    		this.bipedLeftArm.rotateAngleY = 0.35F;
    		this.bipedLeftArm.rotateAngleZ = 0.0F;
    		this.bipedRightArm.rotateAngleX = -1.0F;
    		this.bipedRightArm.rotateAngleY = -0.6F;
    	}*/
    	if (entity.getHeldItem() != null && entity.getHeldItem() == new ItemStack(ModWeapons.e_11BlasterRifle))
    	{
    		this.bipedLeftArm.setRotationPoint(4.0F, 3.0F, -2.0F);
    		this.bipedLeftArm.rotateAngleX = -1.1F;
    		this.bipedLeftArm.rotateAngleY = 0.35F;
    		this.bipedLeftArm.rotateAngleZ = 0.0F;
    		this.bipedRightArm.rotateAngleX = -1.0F;
    		this.bipedRightArm.rotateAngleY = -0.6F;
    	}
    	/*else if (entity.getHeldItem() != null && entity.getHeldItem() == ModWeapons.scoutSniperRifle)
    	{
    		this.bipedLeftArm.setRotationPoint(3.0F, 3.0F, -2.5F);
    		this.bipedLeftArm.rotateAngleX = -1.4F;
    		this.bipedLeftArm.rotateAngleY = 0.3F;
    		this.bipedLeftArm.rotateAngleZ = 0.0F;
    		this.bipedRightArm.rotateAngleX = -1.3F;
    		this.bipedRightArm.rotateAngleY = -0.6F;
    	}*/
    	else
    	{
    		this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
    		this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
    	}
    }
}