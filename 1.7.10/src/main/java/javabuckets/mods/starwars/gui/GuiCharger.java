package javabuckets.mods.starwars.gui;

import javabuckets.mods.starwars.container.ContainerCharger;
import javabuckets.mods.starwars.tileentity.TileEntityCharger;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCharger extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/charger.png");
    public TileEntityCharger theCharger;

	public GuiCharger(InventoryPlayer inventoryplayer, TileEntityCharger tileentitycharger)
	{
		super(new ContainerCharger(inventoryplayer, tileentitycharger));
		this.theCharger = tileentitycharger;
	}

	public void onGuiClosed()
	{
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRendererObj.drawString("Charger", this.xSize / 2 - this.fontRendererObj.getStringWidth("Charger") / 2, 6, 4210752);
		this.fontRendererObj.drawString("container.inventory", 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(texture);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
		
		if (this.theCharger.getChargerChargeTime() > 0 && this.theCharger.getStackInSlot(0) != null)
		{
			float[] afloat = new float[3];
			if (this.theCharger.getStackInSlot(0).getItemDamage() == 4) {afloat[0] = 0.0F; afloat[1] = 0.5F; afloat[2] = 1.0F;}
			if (this.theCharger.getStackInSlot(0).getItemDamage() == 1) {afloat[0] = 1.0F; afloat[1] = 0.0F; afloat[2] = 0.0F;}
			if (this.theCharger.getStackInSlot(0).getItemDamage() == 10) {afloat[0] = 0.0F; afloat[1] = 1.0F; afloat[2] = 0.0F;}
			if (this.theCharger.getStackInSlot(0).getItemDamage() == 5) {afloat[0] = 1.0F; afloat[1] = 0.0F; afloat[2] = 1.0F;}

			float f1 = 34F / this.theCharger.maxChargeTime;
        	int progress = (int) ((int)this.theCharger.getChargerChargeTime() * f1);
			
			GL11.glColor4f(afloat[0], afloat[1], afloat[2], 1.0F);
			drawTexturedModalRect(l + 71, i1 + 36, 176, 0, progress, 16);
		}
	}
}