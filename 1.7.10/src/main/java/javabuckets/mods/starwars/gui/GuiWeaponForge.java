package javabuckets.mods.starwars.gui;

import javabuckets.mods.starwars.container.ContainerWeaponForge;
import javabuckets.mods.starwars.utility.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiWeaponForge extends GuiContainer
{
	private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/weaponForge.png");    

	public GuiWeaponForge(InventoryPlayer par1InventoryPlayer, World par2World, int par3, int par4, int par5)
	{
		super(new ContainerWeaponForge(par1InventoryPlayer, par2World, par3, par4, par5));
		this.ySize = 202;
	}

	public void onGuiClosed()
	{
		super.onGuiClosed();
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		String s = "Weapon Forge";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj.drawString("container.inventory", 8, this.ySize - 96 + 3, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(texture);
		int l = (width - xSize) / 2;
		int i1 = (height - ySize) / 2;
		drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
	}
}