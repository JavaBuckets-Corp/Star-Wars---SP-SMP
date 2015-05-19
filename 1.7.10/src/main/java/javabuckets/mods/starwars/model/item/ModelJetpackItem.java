package javabuckets.mods.starwars.model.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelJetpackItem extends ModelBase
{
	ModelRenderer pack;
	ModelRenderer tankleft;
	ModelRenderer tankmiddle;
	ModelRenderer tankright;
	ModelRenderer toptankleft;
	ModelRenderer toptankright;
	ModelRenderer toptankmiddle;
	ModelRenderer engineright;
	ModelRenderer engineleft;
	ModelRenderer tankmiddle_part;

	public ModelJetpackItem()
	{
		textureWidth = 64;
		textureHeight = 64;

		pack = new ModelRenderer(this, 0, 32);
		pack.addBox(-3F, 1F, 2F, 6, 8, 3);
		pack.setRotationPoint(0F, 0F, 0F);
		pack.setTextureSize(64, 64);
		pack.mirror = true;
		setRotation(pack, 0F, 0F, 0F);
		tankleft = new ModelRenderer(this, 8, 43);
		tankleft.addBox(1.5F, 2F, 3.5F, 2, 6, 2);
		tankleft.setRotationPoint(0F, 0F, 0F);
		tankleft.setTextureSize(64, 64);
		tankleft.mirror = true;
		setRotation(tankleft, 0F, 0F, 0F);
		tankmiddle = new ModelRenderer(this, 0, 43);
		tankmiddle.addBox(-1F, 0F, 4.3F, 2, 8, 2);
		tankmiddle.setRotationPoint(0F, 0F, 0F);
		tankmiddle.setTextureSize(64, 64);
		tankmiddle.mirror = true;
		setRotation(tankmiddle, 0F, 0F, 0F);
		tankright = new ModelRenderer(this, 8, 51);
		tankright.addBox(-3.5F, 2F, 3.5F, 2, 6, 2);
		tankright.setRotationPoint(0F, 0F, 0F);
		tankright.setTextureSize(64, 64);
		tankright.mirror = true;
		setRotation(tankright, 0F, 0F, 0F);
		toptankleft = new ModelRenderer(this, 18, 32);
		toptankleft.addBox(2.1F, 0F, 4.1F, 1, 2, 1);
		toptankleft.setRotationPoint(0F, 0F, 0F);
		toptankleft.setTextureSize(64, 64);
		toptankleft.mirror = true;
		setRotation(toptankleft, 0F, 0F, 0F);
		toptankright = new ModelRenderer(this, 18, 32);
		toptankright.addBox(-3.1F, -1F, 4.1F, 1, 2, 1);
		toptankright.setRotationPoint(0F, 1F, 0F);
		toptankright.setTextureSize(64, 64);
		toptankright.mirror = true;
		setRotation(toptankright, 0F, 0F, 0F);
		toptankmiddle = new ModelRenderer(this, 18, 32);
		toptankmiddle.addBox(-0.5F, -2F, 4.8F, 1, 2, 1);
		toptankmiddle.setRotationPoint(0F, 0F, 0F);
		toptankmiddle.setTextureSize(64, 64);
		toptankmiddle.mirror = true;
		setRotation(toptankmiddle, 0F, 0F, 0F);
		engineright = new ModelRenderer(this, 18, 35);
		engineright.addBox(0F, 0F, -1F, 1, 2, 1);
		engineright.setRotationPoint(-3F, 8F, 5F);
		engineright.setTextureSize(64, 64);
		engineright.mirror = true;
		setRotation(engineright, 0.3490659F, 0F, 0.1745329F);
		engineleft = new ModelRenderer(this, 18, 35);
		engineleft.addBox(0F, 0F, -1F, 1, 2, 1);
		engineleft.setRotationPoint(2F, 8F, 5F);
		engineleft.setTextureSize(64, 64);
		engineleft.mirror = true;
		setRotation(engineleft, 0.3490659F, 0F, -0.1745329F);
		tankmiddle_part = new ModelRenderer(this, 18, 43);
		tankmiddle_part.addBox(-0.5F, 0.5F, 5.5F, 1, 7, 1);
		tankmiddle_part.setRotationPoint(0F, 0F, 0F);
		tankmiddle_part.setTextureSize(64, 64);
		tankmiddle_part.mirror = true;
		setRotation(tankmiddle_part, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		pack.render(f5);
		tankleft.render(f5);
		tankmiddle.render(f5);
		tankright.render(f5);
		toptankleft.render(f5);
		toptankmiddle.render(f5);
		toptankright.render(f5);
		engineleft.render(f5);
		engineright.render(f5);
		tankmiddle_part.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}