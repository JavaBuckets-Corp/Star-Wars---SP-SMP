package javabuckets.mods.starwars.renderer;

import static net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED;
import static net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D;
import javabuckets.mods.starwars.model.entity.ModelCustomPlayer;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCustomPlayer extends RenderPlayer
{
	private ModelCustomPlayer modelBipedMain;
	private ModelCustomPlayer modelArmorChestplate;
	private ModelCustomPlayer modelArmor;

	public RenderCustomPlayer()
	{
		this.modelBipedMain = new ModelCustomPlayer();
		this.modelArmorChestplate = new ModelCustomPlayer(1.0F);
		this.modelArmor = new ModelCustomPlayer(0.5F);
		this.mainModel = this.modelBipedMain;
	}

	public void func_130009_a(AbstractClientPlayer par1AbstractClientPlayer, double par2, double par4, double par6, float par8, float par9)
	{
		if (MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Pre(par1AbstractClientPlayer, this, par9))) return;
		float f2 = 1.0F;
		GL11.glColor3f(f2, f2, f2);
		ItemStack itemstack = par1AbstractClientPlayer.inventory.getCurrentItem();
		this.modelArmorChestplate.heldItemRight = this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight = itemstack != null ? 1 : 0;

		if (itemstack != null && par1AbstractClientPlayer.getItemInUseCount() > 0)
		{
			EnumAction enumaction = itemstack.getItemUseAction();

			if (enumaction == EnumAction.block)
			{
				this.modelArmorChestplate.heldItemRight = this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight = 3;
			}
			else if (enumaction == EnumAction.bow)
			{
				this.modelArmorChestplate.aimedBow = this.modelArmor.aimedBow = this.modelBipedMain.aimedBow = true;
			}
		}

		this.modelArmorChestplate.isSneak = this.modelArmor.isSneak = this.modelBipedMain.isSneak = par1AbstractClientPlayer.isSneaking();
		double d3 = par4 - (double)par1AbstractClientPlayer.yOffset;

		if ((par1AbstractClientPlayer instanceof EntityPlayerSP))
		{
			d3 += 1.6D;
		}
		
		if (par1AbstractClientPlayer.isSneaking() && !(par1AbstractClientPlayer instanceof EntityPlayerSP))
		{
			d3 -= 0.125D;
		}

		super.doRender(par1AbstractClientPlayer, par2, d3, par6, par8, par9);
		this.modelArmorChestplate.aimedBow = this.modelArmor.aimedBow = this.modelBipedMain.aimedBow = false;
		this.modelArmorChestplate.isSneak = this.modelArmor.isSneak = this.modelBipedMain.isSneak = false;
		this.modelArmorChestplate.heldItemRight = this.modelArmor.heldItemRight = this.modelBipedMain.heldItemRight = 0;
		MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Post(par1AbstractClientPlayer, this, par9));
	}

	protected void renderSpecials(AbstractClientPlayer par1AbstractClientPlayer, float par2)
	{
		RenderPlayerEvent.Specials.Pre event = new RenderPlayerEvent.Specials.Pre(par1AbstractClientPlayer, this, par2);
		if (MinecraftForge.EVENT_BUS.post(event))
		{
			return;
		}

		float f1 = 1.0F;
		GL11.glColor3f(f1, f1, f1);
		super.renderArrowsStuckInEntity(par1AbstractClientPlayer, par2);
		ItemStack itemstack = par1AbstractClientPlayer.inventory.armorItemInSlot(3);

		if (itemstack != null && event.renderHelmet)
		{
			GL11.glPushMatrix();
			this.modelBipedMain.bipedHead.postRender(0.0625F);
			float f2;

			if (itemstack != null && itemstack.getItem() instanceof ItemBlock)
			{
				IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, EQUIPPED);
				boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack, BLOCK_3D));

				if (is3D/* || RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType())*/)
				{
					f2 = 0.625F;
					GL11.glTranslatef(0.0F, -0.25F, 0.0F);
					GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
					GL11.glScalef(f2, -f2, -f2);
				}

				this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack, 0);
			}
			else if (itemstack.getItem() == Items.skull)
			{
				f2 = 1.0625F;
				GL11.glScalef(f2, -f2, -f2);
				String s = "";

				if (itemstack.hasTagCompound() && itemstack.getTagCompound().hasKey("SkullOwner"))
				{
					s = itemstack.getTagCompound().getString("SkullOwner");
				}

				TileEntitySkullRenderer.field_147536_b.func_152674_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack.getItemDamage(), par1AbstractClientPlayer.getGameProfile());
			}

			GL11.glPopMatrix();
		}
		
		float f6;

		ItemStack itemstack1 = par1AbstractClientPlayer.inventory.getCurrentItem();

		if (itemstack1 != null && event.renderItem)
		{
			GL11.glPushMatrix();
			this.modelBipedMain.bipedRightArm.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);

			if (par1AbstractClientPlayer.fishEntity != null)
			{
				itemstack1 = new ItemStack(Items.stick);
			}

			EnumAction enumaction = null;

			if (par1AbstractClientPlayer.getItemInUseCount() > 0)
			{
				enumaction = itemstack1.getItemUseAction();
			}

			float f11;

			IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, EQUIPPED);
			boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(EQUIPPED, itemstack1, BLOCK_3D));
			//boolean isBlock = itemstack1.itemID < Block.blocksList.length && itemstack1.getItemSpriteNumber() == 0;

			if (is3D/* || (isBlock && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack1.itemID].getRenderType()))*/)
			{
				f11 = 0.5F;
				GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
				f11 *= 0.75F;
				GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(-f11, -f11, f11);
			}
			else if (itemstack1.getItem() == Items.bow)
			{
				f11 = 0.625F;
				GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
				GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
				GL11.glScalef(f11, -f11, f11);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			/*else if (Item.itemsList[itemstack1.itemID].isFull3D())
			{
				f11 = 0.625F;

				if (Item.itemsList[itemstack1.itemID].shouldRotateAroundWhenRendering())
				{
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}

				if (par1AbstractClientPlayer.getItemInUseCount() > 0 && enumaction == EnumAction.block)
				{
					GL11.glTranslatef(0.05F, 0.0F, -0.1F);
					GL11.glRotatef(-50.0F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-10.0F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(-60.0F, 0.0F, 0.0F, 1.0F);
				}

				GL11.glTranslatef(0.0F, 0.1875F, 0.0F);
				GL11.glScalef(f11, -f11, f11);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}*/
			else
			{
				f11 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(f11, f11, f11);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}

			float f12;
			float f13;
			int j;

			if (itemstack1.getItem().requiresMultipleRenderPasses())
			{
				for (j = 0; j < itemstack1.getItem().getRenderPasses(itemstack1.getItemDamage()); ++j)
				{
					int k = itemstack1.getItem().getColorFromItemStack(itemstack1, j);
					f13 = (float)(k >> 16 & 255) / 255.0F;
					f12 = (float)(k >> 8 & 255) / 255.0F;
					f6 = (float)(k & 255) / 255.0F;
					GL11.glColor4f(f13, f12, f6, 1.0F);
					this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack1, j);
				}
			}
			else
			{
				j = itemstack1.getItem().getColorFromItemStack(itemstack1, 0);
				float f14 = (float)(j >> 16 & 255) / 255.0F;
				f13 = (float)(j >> 8 & 255) / 255.0F;
				f12 = (float)(j & 255) / 255.0F;
				GL11.glColor4f(f14, f13, f12, 1.0F);
				this.renderManager.itemRenderer.renderItem(par1AbstractClientPlayer, itemstack1, 0);
			}

			GL11.glPopMatrix();
		}
		MinecraftForge.EVENT_BUS.post(new RenderPlayerEvent.Specials.Post(par1AbstractClientPlayer, this, par2));
	}
}