package javabuckets.mods.starwars.item.armor;

import javabuckets.mods.starwars.init.ModArmor;
import javabuckets.mods.starwars.interfaces.IJetpack;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemJetpack extends ItemArmor implements IJetpack
{
	public ItemJetpack()
	{
		super(ItemArmor.ArmorMaterial.GOLD, 4, 1);
		this.setMaxDamage(0);
		this.setCreativeTab(StarWars.swTab);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return Reference.MOD_ID + ":textures/models/armor/jetpack" + (stack.getItem() == ModArmor.bobaFettJetpack ? "_boba" : "") + ".png";
	}

	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot) 
	{
		ModelBiped armorModel = null;

		if (itemstack != null)
		{
			if (itemstack.getItem() instanceof ItemJetpack)
			{
				int type = ((ItemArmor)itemstack.getItem()).armorType;

				armorModel = StarWars.proxy.getArmorModel("jetpack");
			}

			if (armorModel != null)
			{
				armorModel.bipedHead.showModel = armorSlot == 0;
				armorModel.bipedHeadwear.showModel = armorSlot == 0;
				armorModel.bipedBody.showModel = armorSlot == 1;
				armorModel.bipedRightArm.showModel = armorSlot == 1;
				armorModel.bipedLeftArm.showModel = armorSlot == 1;
				armorModel.bipedRightLeg.showModel = armorSlot == 2;
				armorModel.bipedLeftLeg.showModel = armorSlot == 2;

				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isRiding = entityLiving.isRiding();
				armorModel.isChild = entityLiving.isChild();
				if (entityLiving instanceof EntityPlayer)
				{
					ItemStack itemstack1 = entityLiving.getHeldItem();
					armorModel.aimedBow = ((EntityPlayer)entityLiving).getItemInUseDuration() > 0 && itemstack1 != null && itemstack1.getItemUseAction() == EnumAction.bow;
					armorModel.heldItemRight = ((EntityPlayer)entityLiving).getItemInUseDuration() > 0 && itemstack1 != null && itemstack1.getItemUseAction() == EnumAction.block ? 3 : (entityLiving.getEquipmentInSlot(0) != null ? 1 : 0);
				}
				return armorModel;
			}
		}
		return null;
	}
}