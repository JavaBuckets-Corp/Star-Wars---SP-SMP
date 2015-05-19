package javabuckets.mods.starwars.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLightsaber extends ModelBase
{
	ModelRenderer Bottom1;
	ModelRenderer Bottom2;
	ModelRenderer HandleBottom;
	ModelRenderer HandleTop;
	ModelRenderer Circle1;
	ModelRenderer Circle2;
	ModelRenderer Circle3;
	ModelRenderer Circle4;
	ModelRenderer Top;
	ModelRenderer Deco1;
	ModelRenderer Deco2;
	ModelRenderer Deco3;
	ModelRenderer Deco4;
	ModelRenderer bladeInner;
	ModelRenderer bladeOuter;

	public ModelLightsaber()
	{
		textureWidth = 64;
		textureHeight = 64;

		Bottom1 = new ModelRenderer(this, 26, 60);
		Bottom1.addBox(-1.5F, 0F, -1.5F, 3, 1, 3);
		Bottom1.setRotationPoint(0F, 19F, 0F);
		Bottom1.setTextureSize(64, 64);
		Bottom1.mirror = true;
		setRotation(Bottom1, 0F, 0F, 0F);
		Bottom2 = new ModelRenderer(this, 26, 60);
		Bottom2.addBox(-1.5F, 0F, -1.5F, 3, 1, 3);
		Bottom2.setRotationPoint(0F, 19F, 0F);
		Bottom2.setTextureSize(64, 64);
		Bottom2.mirror = true;
		setRotation(Bottom2, 0F, 0.7853982F, 0F);
		HandleBottom = new ModelRenderer(this, 28, 52);
		HandleBottom.addBox(-1F, 0F, -1F, 2, 6, 2);
		HandleBottom.setRotationPoint(0F, 15F, 0F);
		HandleBottom.setTextureSize(64, 64);
		HandleBottom.mirror = true;
		setRotation(HandleBottom, 0F, 0F, 0F);
		HandleTop = new ModelRenderer(this, 30, 37);
		HandleTop.addBox(-0.5F, 0F, -0.5F, 1, 8, 1);
		HandleTop.setRotationPoint(0F, 7F, 0F);
		HandleTop.setTextureSize(64, 64);
		HandleTop.mirror = true;
		setRotation(HandleTop, 0F, 0F, 0F);
		Circle1 = new ModelRenderer(this, 28, 34);
		Circle1.addBox(-1F, 0F, -1F, 2, 1, 2);
		Circle1.setRotationPoint(0F, 14F, 0F);
		Circle1.setTextureSize(64, 64);
		Circle1.mirror = true;
		setRotation(Circle1, 0F, 0.7853982F, 0F);
		Circle2 = new ModelRenderer(this, 28, 34);
		Circle2.addBox(-1F, 0F, -1F, 2, 1, 2);
		Circle2.setRotationPoint(0F, 12.5F, 0F);
		Circle2.setTextureSize(64, 64);
		Circle2.mirror = true;
		setRotation(Circle2, 0F, 0.7853982F, 0F);
		Circle3 = new ModelRenderer(this, 28, 34);
		Circle3.addBox(-1F, 0F, -1F, 2, 1, 2);
		Circle3.setRotationPoint(0F, 11F, 0F);
		Circle3.setTextureSize(64, 64);
		Circle3.mirror = true;
		setRotation(Circle3, 0F, 0.7853982F, 0F);
		Circle4 = new ModelRenderer(this, 36, 34);
		Circle4.addBox(-1F, 0F, -1F, 2, 1, 2);
		Circle4.setRotationPoint(0F, 8.5F, 0F);
		Circle4.setTextureSize(64, 64);
		Circle4.mirror = true;
		setRotation(Circle4, 0F, 0.7853982F, 0F);
		Top = new ModelRenderer(this, 28, 31);
		Top.addBox(-1F, 0F, -1F, 2, 1, 2);
		Top.setRotationPoint(0F, 6F, 0F);
		Top.setTextureSize(64, 64);
		Top.mirror = true;
		setRotation(Top, 0F, 0F, 0F);
		Deco1 = new ModelRenderer(this, 30, 46);
		Deco1.addBox(-0.5F, 0F, -0.5F, 1, 5, 1);
		Deco1.setRotationPoint(0F, 16F, -0.75F);
		Deco1.setTextureSize(64, 64);
		Deco1.mirror = true;
		setRotation(Deco1, 0F, 0F, 0F);
		Deco2 = new ModelRenderer(this, 30, 46);
		Deco2.addBox(-0.5F, 0F, -0.5F, 1, 5, 1);
		Deco2.setRotationPoint(0F, 16F, 0.8F);
		Deco2.setTextureSize(64, 64);
		Deco2.mirror = true;
		setRotation(Deco2, 0F, 0F, 0F);
		Deco3 = new ModelRenderer(this, 30, 46);
		Deco3.addBox(-0.5F, 0F, -0.5F, 1, 5, 1);
		Deco3.setRotationPoint(-0.8F, 16F, 0F);
		Deco3.setTextureSize(64, 64);
		Deco3.mirror = true;
		setRotation(Deco3, 0F, 0F, 0F);
		Deco4 = new ModelRenderer(this, 30, 46);
		Deco4.addBox(-0.5F, 0F, -0.5F, 1, 5, 1);
		Deco4.setRotationPoint(0.8F, 16F, 0F);
		Deco4.setTextureSize(64, 64);
		Deco4.mirror = true;
		setRotation(Deco4, 0F, 0F, 0F);
		bladeInner = new ModelRenderer(this, 0, 0);
		bladeInner.addBox(-0.5F, -32F, -0.5F, 1, 32, 1);
		bladeInner.setRotationPoint(0F, 6F, 0F);
		bladeInner.setTextureSize(64, 64);
		bladeInner.mirror = true;
		setRotation(bladeInner, 0F, 0F, 0F);
		bladeOuter = new ModelRenderer(this, 0, 0);
		bladeOuter.addBox(-1.5F, -33F, -1.5F, 3, 33, 3);
		bladeOuter.setRotationPoint(0F, 6F, 0F);
		bladeOuter.setTextureSize(64, 64);
		bladeOuter.mirror = true;
		setRotation(bladeOuter, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Bottom1.render(f5);
		Bottom2.render(f5);
		HandleBottom.render(f5);
		HandleTop.render(f5);
		Circle1.render(f5);
		Circle2.render(f5);
		Circle3.render(f5);
		Circle4.render(f5);
		Top.render(f5);
		Deco1.render(f5);
		Deco2.render(f5);
		Deco3.render(f5);
		Deco4.render(f5);
	}
	
	public void renderInner(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bladeInner.render(f5);
	}
	
	public void renderOuter(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bladeOuter.render(f5);
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