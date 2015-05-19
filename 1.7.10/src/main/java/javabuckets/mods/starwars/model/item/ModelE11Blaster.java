package javabuckets.mods.starwars.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelE11Blaster extends ModelBase
{
	ModelRenderer handle;
	ModelRenderer barrel;
	ModelRenderer thing;
	ModelRenderer top;
	ModelRenderer backThing;
	ModelRenderer bottom;
	ModelRenderer scope;
	ModelRenderer reloadGrip;

	public ModelE11Blaster()
	{
		textureWidth = 64;
		textureHeight = 64;

		handle = new ModelRenderer(this, 0, 2);
		handle.addBox(-0.5F, 0F, -1F, 1, 4, 2);
		handle.setRotationPoint(0F, -0.5F, 0F);
		handle.setTextureSize(64, 64);
		handle.mirror = true;
		setRotation(handle, 0.5235988F, 0F, 0F);
		barrel = new ModelRenderer(this, 0, 0);
		barrel.addBox(-1F, -2F, -9F, 2, 2, 15);
		barrel.setRotationPoint(0F, 0F, 0F);
		barrel.setTextureSize(64, 64);
		barrel.mirror = true;
		setRotation(barrel, 0F, 0F, 0F);
		thing = new ModelRenderer(this, 14, 17);
		thing.addBox(-1F, -1F, -0.5F, 2, 1, 1);
		thing.setRotationPoint(0F, -2F, -8F);
		thing.setTextureSize(64, 64);
		thing.mirror = true;
		setRotation(thing, 0F, 0F, 0F);
		top = new ModelRenderer(this, 0, 17);
		top.addBox(-1F, -0.5F, -2F, 2, 1, 5);
		top.setRotationPoint(0F, -2F, -5F);
		top.setTextureSize(64, 64);
		top.mirror = true;
		setRotation(top, 0F, 0F, 0F);
		backThing = new ModelRenderer(this, 0, 0);
		backThing.addBox(-1F, -0.5F, -1F, 2, 1, 1);
		backThing.setRotationPoint(0F, -2F, 5F);
		backThing.setTextureSize(64, 64);
		backThing.mirror = true;
		setRotation(backThing, 0F, 0F, 0F);
		bottom = new ModelRenderer(this, 0, 23);
		bottom.addBox(-1F, -0.5F, -3F, 2, 1, 8);
		bottom.setRotationPoint(0F, 0F, -6.25F);
		bottom.setTextureSize(64, 64);
		bottom.mirror = true;
		setRotation(bottom, 0F, 0F, 0F);
		scope = new ModelRenderer(this, 20, 17);
		scope.addBox(-1F, -2F, -3F, 2, 2, 5);
		scope.setRotationPoint(0F, -2F, 1F);
		scope.setTextureSize(64, 64);
		scope.mirror = true;
		setRotation(scope, 0F, 0F, 0F);
		reloadGrip = new ModelRenderer(this, 20, 24);
		reloadGrip.addBox(0F, -1F, -1F, 3, 1, 2);
		reloadGrip.setRotationPoint(1F, -1F, 0F);
		reloadGrip.setTextureSize(64, 64);
		reloadGrip.mirror = true;
		setRotation(reloadGrip, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		handle.render(f5);
		barrel.render(f5);
		thing.render(f5);
		top.render(f5);
		backThing.render(f5);
		bottom.render(f5);
		scope.render(f5);
		reloadGrip.render(f5);
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