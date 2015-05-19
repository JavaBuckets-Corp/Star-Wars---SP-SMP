package javabuckets.mods.starwars.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHandBlaster extends ModelBase
{
	ModelRenderer main;
	ModelRenderer upperMain;
	ModelRenderer barrel;
	ModelRenderer handle;

	public ModelHandBlaster()
	{
		textureWidth = 64;
		textureHeight = 32;

		main = new ModelRenderer(this, 0, 0);
		main.addBox(-1F, 0F, 0F, 2, 1, 8);
		main.setRotationPoint(0F, 0F, 0F);
		main.setTextureSize(64, 32);
		main.mirror = true;
		setRotation(main, 0F, 0F, 0F);
		upperMain = new ModelRenderer(this, 20, 0);
		upperMain.addBox(-0.5F, -1F, 0F, 1, 2, 7);
		upperMain.setRotationPoint(0F, -0.6F, 0.5F);
		upperMain.setTextureSize(64, 32);
		upperMain.mirror = true;
		setRotation(upperMain, 0F, 0F, 0F);
		barrel = new ModelRenderer(this, 0, 0);
		barrel.addBox(-0.5F, 0F, 0F, 1, 1, 1);
		barrel.setRotationPoint(0F, -1F, 7.5F);
		barrel.setTextureSize(64, 32);
		barrel.mirror = true;
		setRotation(barrel, 0F, 0F, 0F);
		handle = new ModelRenderer(this, 16, 0);
		handle.addBox(-0.5F, 0F, -1F, 1, 3, 2);
		handle.setRotationPoint(0F, 0.5F, 2.5F);
		handle.setTextureSize(64, 32);
		handle.mirror = true;
		setRotation(handle, -0.3490659F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		main.render(f5);
		upperMain.render(f5);
		barrel.render(f5);
		handle.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}
}