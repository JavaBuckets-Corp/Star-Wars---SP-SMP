package javabuckets.mods.starwars.item.armor;

//import javabuckets.mods.starwars.model.armor.ModelMandalorianArmor;
import javabuckets.mods.starwars.init.ModArmor;
import javabuckets.mods.starwars.init.ModEnums;
import javabuckets.mods.starwars.main.StarWars;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMandalorianArmor extends ItemArmor
{
	public ItemMandalorianArmor(int par2)
	{
		super(ModEnums.enumArmorMaterialMandalorian, 4, par2);
        this.setCreativeTab(StarWars.swTab);
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return Reference.MOD_ID + ":textures/models/armor/mandalorian" + ((stack.getItem() == ModArmor.bobaFettMandalorianHelmet || stack.getItem() == ModArmor.bobaFettMandalorianChestplate || stack.getItem() == ModArmor.bobaFettMandalorianLeggings) ? "_boba" : "") + ".png";
	}
	
	public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (!itemStack.hasTagCompound())
		{
			itemStack.setTagCompound(new NBTTagCompound());
		}
		
//		if (player.getCurrentItemOrArmor(4) != null && player.getCurrentItemOrArmor(4).getItem() == this && Keyboard.isKeyDown(Keyboard.KEY_DOWN))
//		{
//			Minecraft.getMinecraft().displayGuiScreen(new GuiHelmetRadar());
//		}
	}
	
	public void renderHelmetOverlay(ItemStack stack, EntityPlayer player, ScaledResolution resolution, float partialTicks, boolean hasScreen, int mouseX, int mouseY)
    {
    	ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();
		
		if (res != null)
		{
	        Tessellator tessellator = Tessellator.instance;

			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.6F);
	        tessellator.startDrawingQuads();
	        tessellator.addVertexWithUV(0.0D, (double)height, -90.0D, 0.0D, 1.0D);
	        tessellator.addVertexWithUV((double)width, (double)height, -90.0D, 1.0D, 1.0D);
	        tessellator.addVertexWithUV((double)width, 0.0D, -90.0D, 1.0D, 0.0D);
	        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
	        tessellator.draw();
	        GL11.glEnable(GL11.GL_TEXTURE_2D);
	        
			GL11.glEnable(GL11.GL_BLEND);
	    	GL11.glDisable(GL11.GL_DEPTH_TEST);
	        GL11.glDepthMask(false);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        float f = 0.5F;
	        GL11.glColor4f(f, f, f, 1.0F);
	        GL11.glDisable(GL11.GL_ALPHA_TEST);
	        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/misc/mandalorianHelmetOverlay.png"));
	        tessellator.startDrawingQuads();
	        tessellator.addVertexWithUV(0.0D, (double)height, -90.0D, 0.0D, 1.0D);
	        tessellator.addVertexWithUV((double)width, (double)height, -90.0D, 1.0D, 1.0D);
	        tessellator.addVertexWithUV((double)width, 0.0D, -90.0D, 1.0D, 0.0D);
	        tessellator.addVertexWithUV(0.0D, 0.0D, -90.0D, 0.0D, 0.0D);
	        tessellator.draw();
	        GL11.glDepthMask(true);
	        GL11.glEnable(GL11.GL_DEPTH_TEST);
	        GL11.glEnable(GL11.GL_ALPHA_TEST);
	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);	        
		}
    }
	
    @SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot) 
	{
		ModelBiped armorModel = null;

		if (itemstack != null)
		{
			if (itemstack.getItem() instanceof ItemMandalorianArmor)
			{
				int type = ((ItemArmor)itemstack.getItem()).armorType;

				armorModel = StarWars.proxy.getArmorModel("mandalorian");
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
				armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 : 0;
				if (entityLiving instanceof EntityPlayer)
				{
					armorModel.aimedBow = ((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
				}
				return armorModel;
			}
		}
		return null;
	}
	
	public void registerIcons(IIconRegister par1IconRegister)
	{
		itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getUnlocalizedName().substring(5));
	}
}