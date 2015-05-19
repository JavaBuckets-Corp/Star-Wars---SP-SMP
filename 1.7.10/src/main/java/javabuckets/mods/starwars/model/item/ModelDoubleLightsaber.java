package javabuckets.mods.starwars.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDoubleLightsaber extends ModelBase
{
	ModelRenderer mainHandle1;
	ModelRenderer mainHandle2;
	ModelRenderer topPiece1;
	ModelRenderer topPiece2;
	ModelRenderer topPiece3;
	ModelRenderer topPiece4;
	ModelRenderer emitter;

	public ModelDoubleLightsaber()
	{
		textureWidth = 32;
		textureHeight = 32;

		mainHandle1 = new ModelRenderer(this, 0, 0);
		mainHandle1.addBox(-2F, -20F, -1F, 4, 20, 2);
		mainHandle1.setRotationPoint(0F, 0F, 0F);
		mainHandle1.setTextureSize(32, 32);
		mainHandle1.mirror = true;
		setRotation(mainHandle1, 0F, 0F, 0F);
		mainHandle2 = new ModelRenderer(this, 0, 0);
		mainHandle2.addBox(-2F, -20F, -1F, 4, 20, 2);
		mainHandle2.setRotationPoint(0F, 0F, 0F);
		mainHandle2.setTextureSize(32, 32);
		mainHandle2.mirror = true;
		setRotation(mainHandle2, 0F, 1.570796F, 0F);
		topPiece1 = new ModelRenderer(this, 12, 0);
		topPiece1.addBox(-1F, -4F, -0.5F, 2, 4, 1);
		topPiece1.setRotationPoint(0F, -19.9F, -1.5F);
		topPiece1.setTextureSize(32, 32);
		topPiece1.mirror = true;
		setRotation(topPiece1, -0.1745329F, 0F, 0F);
		topPiece2 = new ModelRenderer(this, 12, 0);
		topPiece2.addBox(-1F, -4F, -0.5F, 2, 4, 1);
		topPiece2.setRotationPoint(-1.5F, -19.9F, 0F);
		topPiece2.setTextureSize(32, 32);
		topPiece2.mirror = true;
		setRotation(topPiece2, -0.1745329F, 1.570796F, 0F);
		topPiece3 = new ModelRenderer(this, 12, 0);
		topPiece3.addBox(-1F, -4F, -0.5F, 2, 4, 1);
		topPiece3.setRotationPoint(0F, -19.9F, 1.5F);
		topPiece3.setTextureSize(32, 32);
		topPiece3.mirror = true;
		setRotation(topPiece3, 0.1745329F, 0F, 0F);
		topPiece4 = new ModelRenderer(this, 12, 0);
		topPiece4.addBox(-1F, -4F, -0.5F, 2, 4, 1);
		topPiece4.setRotationPoint(1.5F, -19.9F, 0F);
		topPiece4.setTextureSize(32, 32);
		topPiece4.mirror = true;
		setRotation(topPiece4, 0.1745329F, 1.570796F, 0F);
		emitter = new ModelRenderer(this, 0, 22);
		emitter.addBox(-2.5F, -2F, -2.5F, 5, 2, 5);
		emitter.setRotationPoint(0F, -23.8F, 0F);
		emitter.setTextureSize(32, 32);
		emitter.mirror = true;
		setRotation(emitter, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		mainHandle1.render(f5);
		mainHandle2.render(f5);
		topPiece1.render(f5);
		topPiece2.render(f5);
		topPiece3.render(f5);
		topPiece4.render(f5);
		emitter.render(f5);
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