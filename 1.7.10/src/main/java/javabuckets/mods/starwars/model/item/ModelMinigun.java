package javabuckets.mods.starwars.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMinigun extends ModelBase
{
	ModelRenderer barrel1;
	ModelRenderer barrel2;
	ModelRenderer barrel3;
	ModelRenderer barrel4;
	ModelRenderer barrel5;
	ModelRenderer barrel6;
	ModelRenderer ring1;
	ModelRenderer ring2;
	ModelRenderer part1;
	ModelRenderer part2;
	ModelRenderer main;
	ModelRenderer handle1;
	ModelRenderer handle2;
	ModelRenderer handle3;
	ModelRenderer secondHandle1;
	ModelRenderer secondHandle2;

	public ModelMinigun()
	{
		textureWidth = 64;
		textureHeight = 32;

		barrel1 = new ModelRenderer(this, 0, 9);
		barrel1.addBox(-0.5F, -0.5F, -10F, 1, 1, 10);
		barrel1.setRotationPoint(-0.8F, 0F, 0F);
		barrel1.setTextureSize(64, 32);
		barrel1.mirror = true;
		setRotation(barrel1, 0F, 0F, 0F);
		barrel2 = new ModelRenderer(this, 0, 9);
		barrel2.addBox(-0.5F, -0.5F, -10F, 1, 1, 10);
		barrel2.setRotationPoint(0.8F, 0F, 0F);
		barrel2.setTextureSize(64, 32);
		barrel2.mirror = true;
		setRotation(barrel2, 0F, 0F, 0F);
		barrel3 = new ModelRenderer(this, 0, 9);
		barrel3.addBox(-0.5F, -0.5F, -10F, 1, 1, 10);
		barrel3.setRotationPoint(1.5F, -1.5F, 0F);
		barrel3.setTextureSize(64, 32);
		barrel3.mirror = true;
		setRotation(barrel3, 0F, 0F, 0F);
		barrel4 = new ModelRenderer(this, 0, 9);
		barrel4.addBox(-0.5F, -0.5F, -10F, 1, 1, 10);
		barrel4.setRotationPoint(0.8F, -3F, 0F);
		barrel4.setTextureSize(64, 32);
		barrel4.mirror = true;
		setRotation(barrel4, 0F, 0F, 0F);
		barrel5 = new ModelRenderer(this, 0, 9);
		barrel5.addBox(-0.5F, -0.5F, -10F, 1, 1, 10);
		barrel5.setRotationPoint(-0.8F, -3F, 0F);
		barrel5.setTextureSize(64, 32);
		barrel5.mirror = true;
		setRotation(barrel5, 0F, 0F, 0F);
		barrel6 = new ModelRenderer(this, 0, 9);
		barrel6.addBox(-0.5F, -0.5F, -10F, 1, 1, 10);
		barrel6.setRotationPoint(-1.5F, -1.5F, 0F);
		barrel6.setTextureSize(64, 32);
		barrel6.mirror = true;
		setRotation(barrel6, 0F, 0F, 0F);
		ring1 = new ModelRenderer(this, 22, 14);
		ring1.addBox(-2F, -2F, -1F, 4, 4, 1);
		ring1.setRotationPoint(0F, -1.5F, 1F);
		ring1.setTextureSize(64, 32);
		ring1.mirror = true;
		setRotation(ring1, 0F, 0F, 0F);
		ring2 = new ModelRenderer(this, 22, 9);
		ring2.addBox(-2F, -2F, -1F, 4, 4, 1);
		ring2.setRotationPoint(0F, -1.5F, -6F);
		ring2.setTextureSize(64, 32);
		ring2.mirror = true;
		setRotation(ring2, 0F, 0F, 0F);
		part1 = new ModelRenderer(this, 0, 20);
		part1.addBox(-1.5F, -1.5F, -3F, 3, 3, 3);
		part1.setRotationPoint(0F, -1.5F, 4F);
		part1.setTextureSize(64, 32);
		part1.mirror = true;
		setRotation(part1, 0F, 0F, 0F);
		part2 = new ModelRenderer(this, 18, 0);
		part2.addBox(-1.5F, -1.5F, -6F, 3, 3, 6);
		part2.setRotationPoint(0F, -1.5F, 0F);
		part2.setTextureSize(64, 32);
		part2.mirror = true;
		setRotation(part2, 0F, 0F, 0F);
		main = new ModelRenderer(this, 0, 0);
		main.addBox(-2F, -2F, -5F, 4, 4, 5);
		main.setRotationPoint(0F, -1.5F, 9F);
		main.setTextureSize(64, 32);
		main.mirror = true;
		setRotation(main, 0F, 0F, 0F);
		handle1 = new ModelRenderer(this, 36, 0);
		handle1.addBox(-0.5F, -4F, -0.5F, 1, 4, 1);
		handle1.setRotationPoint(-1.5F, -2F, 2F);
		handle1.setTextureSize(64, 32);
		handle1.mirror = true;
		setRotation(handle1, 0F, 0F, 0F);
		handle2 = new ModelRenderer(this, 40, 0);
		handle2.addBox(-1F, -1F, -0.5F, 2, 1, 1);
		handle2.setRotationPoint(0F, -5F, 2F);
		handle2.setTextureSize(64, 32);
		handle2.mirror = true;
		setRotation(handle2, 0F, 0F, 0F);
		handle3 = new ModelRenderer(this, 36, 0);
		handle3.addBox(-0.5F, -4F, -0.5F, 1, 4, 1);
		handle3.setRotationPoint(1.5F, -2F, 2F);
		handle3.setTextureSize(64, 32);
		handle3.mirror = true;
		setRotation(handle3, 0F, 0F, 0F);
		secondHandle1 = new ModelRenderer(this, 36, 9);
		secondHandle1.addBox(-1F, -0.5F, 0F, 2, 1, 2);
		secondHandle1.setRotationPoint(0F, 0F, 8.8F);
		secondHandle1.setTextureSize(64, 32);
		secondHandle1.mirror = true;
		setRotation(secondHandle1, 0.2268928F, 0F, 0F);
		secondHandle2 = new ModelRenderer(this, 36, 12);
		secondHandle2.addBox(-0.5F, -0.5F, 0F, 1, 1, 4);
		secondHandle2.setRotationPoint(0F, 0F, 10.4F);
		secondHandle2.setTextureSize(64, 32);
		secondHandle2.mirror = true;
		setRotation(secondHandle2, 1.570796F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		barrel1.render(f5);
		barrel2.render(f5);
		barrel3.render(f5);
		barrel4.render(f5);
		barrel5.render(f5);
		barrel6.render(f5);
		ring1.render(f5);
		ring2.render(f5);
		part1.render(f5);
		part2.render(f5);
		main.render(f5);
		handle1.render(f5);
		handle2.render(f5);
		handle3.render(f5);
		secondHandle1.render(f5);
		secondHandle2.render(f5);
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