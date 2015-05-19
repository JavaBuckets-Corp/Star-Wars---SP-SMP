package javabuckets.mods.starwars.entity.item;

import java.util.List;

import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityLightsaber extends EntityThrowable
{
	private ItemStack lightsaber;
	private int soundTick;
	
	public EntityLightsaber(World world, EntityLivingBase entity, ItemStack itemstack)
	{
		super(world, entity);
		this.lightsaber = itemstack;
		this.soundTick = 5;
		this.setSize(1.2F, 0.0625F);
	}
	
	public ItemStack getLightsaber()
	{
		return lightsaber;
	}
	
    protected float getGravityVelocity()
    {
        return 0.01F;
    }
    
    protected float func_70182_d()
    {
        return 2.0F;
    }
    
    public void onUpdate()
    {
        super.onUpdate();

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
                
        if (this.soundTick > 0)
        {
        	--this.soundTick;
        }
        else
        {
        	this.soundTick = 5;
        	this.worldObj.playSound(posX, posY, posZ, Reference.MOD_ID + ":" + "lightsaber_swing", 1.0F, 1.0F, true);
        }
        
        EntityLivingBase target = getEntityNear(worldObj, posX, posY, posZ, 10, false);
        double d0 = 8.0D;

        if (!this.isDead)
        {
            if (ticksExisted > 50 && !getThrower().isDead)
            {
            	this.motionX = (getThrower().posX - this.posX) / 4;
            	this.motionY = (getThrower().posY - this.posY - getThrower().height / 2) / 4;
            	this.motionZ = (getThrower().posZ - this.posZ) / 4;
            	
            	if (getEntityNear(worldObj, posX, posY, posZ, 2, true) != null)
            	{
                    if (!this.worldObj.isRemote)
                    {
                    	EntityItem entityitem = new EntityItem(getThrower().worldObj);
                        entityitem.setLocationAndAngles(getThrower().posX, getThrower().posY, getThrower().posZ, 0.0F, 0.0F);
                        entityitem.setEntityItemStack(this.lightsaber);
                        this.worldObj.spawnEntityInWorld(entityitem);
                    }
                    this.setDead();
            	}
            }
        }
    }
    
	public EntityLivingBase getEntityNear(World par0World, double par1, double par3, double par4, int par5, boolean par6)
    {
        List list = par0World.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(par1, par3, par4, par1 + 1.0D, par3 + 1.0D, par4 + 1.0D).expand(par5, par5, par5));
		EntityLivingBase entity = null;
		EntityPlayer player = null;
        
		if (par6)
		{
	        for (int i = 0; i < list.size(); ++i)
	        {
	        	if (list.get(i) != null)
	        	{
	        		if (((EntityLivingBase)list.get(i)).getUniqueID() == this.getThrower().getUniqueID())
	        		{
	        			player = (EntityPlayer)list.get(i);
	        		}
	        	}
	        }
		}
		else
		{
	        for (int i = 0; i < list.size(); ++i)
	        {
	        	if (list.get(i) != null)
	        	{
	        		if (((EntityLivingBase)list.get(i)).getUniqueID() != this.getThrower().getUniqueID())
	        		{
	        			entity = (EntityLivingBase)list.get(i);
	        		}
	        	}
	        }
		}
        return par6 ? player : entity;
    }
	
	protected void onImpact(MovingObjectPosition mop)
	{
        if (mop.entityHit != null)
        {
        	float damage = ticksExisted > 10 ? 14.0F : ticksExisted * 1.4F;
        	float sharpnessDamage = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, lightsaber) * 1.25F;
            mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), damage + sharpnessDamage);
            mop.entityHit.setFire(EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, lightsaber) * 4);
        }
        
        this.motionY += 0.2D;
	}
}