package javabuckets.mods.starwars.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSniper extends ModelBase
{
	ModelRenderer barrel;
	ModelRenderer middlePiece;
	ModelRenderer handle;
	ModelRenderer backPiece1;
	ModelRenderer backPiece2;
	ModelRenderer scope;
	ModelRenderer scopeExtension;
	ModelRenderer middleThing;
	ModelRenderer backThing;
	ModelRenderer frontThing;

	public ModelSniper()
	{
		textureWidth = 64;
		textureHeight = 64;

		barrel = new ModelRenderer(this, 0, 0);
		barrel.addBox(0F, 0F, -14F, 1, 1, 17);
		barrel.setRotationPoint(0F, 0F, 0F);
		barrel.setTextureSize(64, 64);
		barrel.mirror = true;
		setRotation(barrel, 0F, 0F, 0F);
		middlePiece = new ModelRenderer(this, 0, 0);
		middlePiece.addBox(-0.5F, -1F, -2F, 2, 2, 4);
		middlePiece.setRotationPoint(0F, 1F, 5F);
		middlePiece.setTextureSize(64, 64);
		middlePiece.mirror = true;
		setRotation(middlePiece, 0F, 0F, 0F);
		handle = new ModelRenderer(this, 18, 18);
		handle.addBox(0F, 0F, -1F, 1, 3, 2);
		handle.setRotationPoint(0F, 1.5F, 5F);
		handle.setTextureSize(64, 64);
		handle.mirror = true;
		setRotation(handle, 0.5235988F, 0F, 0F);
		backPiece1 = new ModelRenderer(this, 0, 13);
		backPiece1.addBox(0F, 0F, 0F, 1, 1, 3);
		backPiece1.setRotationPoint(0F, 0F, 7F);
		backPiece1.setTextureSize(64, 64);
		backPiece1.mirror = true;
		setRotation(backPiece1, 0F, 0F, 0F);
		backPiece2 = new ModelRenderer(this, 24, 18);
		backPiece2.addBox(0F, 0F, 0F, 1, 3, 2);
		backPiece2.setRotationPoint(0F, -0.3F, 10F);
		backPiece2.setTextureSize(64, 64);
		backPiece2.mirror = true;
		setRotation(backPiece2, 0F, 0F, 0F);
		scope = new ModelRenderer(this, 0, 6);
		scope.addBox(-1F, -2F, -3F, 2, 2, 5);
		scope.setRotationPoint(0.5F, 0F, 3F);
		scope.setTextureSize(64, 64);
		scope.mirror = true;
		setRotation(scope, 0F, 0F, 0F);
		scopeExtension = new ModelRenderer(this, 1, 1);
		scopeExtension.addBox(0F, -0.5F, -14F, 1, 1, 16);
		scopeExtension.setRotationPoint(0F, -1F, 5F);
		scopeExtension.setTextureSize(64, 64);
		scopeExtension.mirror = true;
		setRotation(scopeExtension, 0F, 0F, 0F);
		middleThing = new ModelRenderer(this, 0, 18);
		middleThing.addBox(-0.5F, -0.5F, -4F, 1, 0, 8);
		middleThing.setRotationPoint(0.5F, 2.5F, -4F);
		middleThing.setTextureSize(64, 64);
		middleThing.mirror = true;
		setRotation(middleThing, 0F, 0F, 0F);
		backThing = new ModelRenderer(this, 6, 24);
		backThing.addBox(-0.5F, -0.5F, 0F, 1, 0, 2);
		backThing.setRotationPoint(0.5F, 2.4F, 0.2F);
		backThing.setTextureSize(64, 64);
		backThing.mirror = true;
		setRotation(backThing, 0.6108652F, 0F, 0F);
		frontThing = new ModelRenderer(this, 6, 24);
		frontThing.addBox(-0.5F, -0.5F, 0F, 1, 0, 2);
		frontThing.setRotationPoint(0.5F, 1.6F, -7.6F);
		frontThing.setTextureSize(64, 64);
		frontThing.mirror = true;
		setRotation(frontThing, 2.443461F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		barrel.render(f5);
		middlePiece.render(f5);
		handle.render(f5);
		backPiece1.render(f5);
		backPiece2.render(f5);
		scope.render(f5);
		scopeExtension.render(f5);
		middleThing.render(f5);
		backThing.render(f5);
		frontThing.render(f5);
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