
package javabuckets.mods.starwars.model.armor;

import javabuckets.mods.starwars.model.entity.ModelCustomPlayer;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMandalorian extends ModelCustomPlayer
{
	public ModelRenderer helmet;
	public ModelRenderer chest;
	public ModelRenderer rightArm;
	public ModelRenderer leftArm;
	public ModelRenderer rightLeg;
	public ModelRenderer leftLeg;
	public ModelRenderer bottomHelmetPiece;
	public ModelRenderer upperHelmetPiece;
	public ModelRenderer rightShoulder;
	public ModelRenderer leftShoulder;
	public ModelRenderer rightChestPiece;
	public ModelRenderer leftChestPiece;
	public ModelRenderer middleChestPiece;
	public ModelRenderer rightKnee;
	public ModelRenderer leftKnee;

	public ModelRenderer pack;
	public ModelRenderer tankleft;
	public ModelRenderer tankmiddle;
	public ModelRenderer tankright;
	public ModelRenderer toptankleft;
	public ModelRenderer toptankright;
	public ModelRenderer toptankmiddle;
	public ModelRenderer engineright;
	public ModelRenderer engineleft;
	public ModelRenderer tankmiddlepart;



	public ModelMandalorian(float f)
	{
		super(f, 0, 64, 96);
		textureWidth = 64;
		textureHeight = 96;

		helmet = new ModelRenderer(this, 0, 32);
		helmet.addBox(-4F, -8F, -4F, 8, 8, 8);
		helmet.setRotationPoint(0F, 0F, 0F);
		helmet.setTextureSize(64, 64);
		setRotation(helmet, 0F, 0F, 0F);
		chest = new ModelRenderer(this, 16, 48);
		chest.addBox(-4F, 0F, -2F, 8, 12, 4);
		chest.setRotationPoint(0F, 0F, 0F);
		chest.setTextureSize(64, 64);
		setRotation(chest, 0F, 0F, 0F);
		rightArm = new ModelRenderer(this, 40, 48);
		rightArm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightArm.setRotationPoint(0F, 0F, 0F);
		rightArm.setTextureSize(64, 64);
		setRotation(rightArm, 0F, 0F, 0F);
		leftArm = new ModelRenderer(this, 40, 48);
		leftArm.mirror = true;
		leftArm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftArm.setRotationPoint(0F, 0F, 0F);
		leftArm.setTextureSize(64, 64);
		setRotation(leftArm, 0F, 0F, 0F);
		rightLeg = new ModelRenderer(this, 0, 48);
		rightLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightLeg.setRotationPoint(0F, 0F, 0F);
		rightLeg.setTextureSize(64, 64);
		setRotation(rightLeg, 0F, 0F, 0F);
		leftLeg = new ModelRenderer(this, 0, 48);
		leftLeg.mirror = true;
		leftLeg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftLeg.setRotationPoint(0F, 0F, 0F);
		leftLeg.setTextureSize(64, 64);
		setRotation(leftLeg, 0F, 0F, 0F);
		bottomHelmetPiece = new ModelRenderer(this, 32, 42);
		bottomHelmetPiece.addBox(-5F, -10F, -1F, 1, 5, 1);
		bottomHelmetPiece.setRotationPoint(0F, 0F, 0F);
		bottomHelmetPiece.setTextureSize(64, 64);
		setRotation(bottomHelmetPiece, 0F, 0F, 0F);
		upperHelmetPiece = new ModelRenderer(this, 36, 45);
		upperHelmetPiece.addBox(-5F, -11F, -1.5F, 3, 1, 2);
		upperHelmetPiece.setRotationPoint(0F, 0F, 0F);
		upperHelmetPiece.setTextureSize(64, 64);
		setRotation(upperHelmetPiece, 0F, 0F, 0F);
		rightShoulder = new ModelRenderer(this, 40, 32);
		rightShoulder.addBox(-3.5F, -2.5F, -2.5F, 5, 5, 5);
		rightShoulder.setRotationPoint(0F, 0F, 0F);
		rightShoulder.setTextureSize(64, 64);
		setRotation(rightShoulder, 0F, 0F, -0.1745329F);
		leftShoulder = new ModelRenderer(this, 40, 32);
		leftShoulder.mirror = true;
		leftShoulder.addBox(-1.5F, -2.5F, -2.5F, 5, 5, 5);
		leftShoulder.setRotationPoint(0F, 0F, 0F);
		leftShoulder.setTextureSize(64, 64);
		setRotation(leftShoulder, 0F, 0F, 0.1745329F);
		rightChestPiece = new ModelRenderer(this, 32, 32);
		rightChestPiece.addBox(-4.3F, 1.5F, -2.2F, 4, 6, 0);
		rightChestPiece.setRotationPoint(0F, 0F, 0F);
		rightChestPiece.setTextureSize(64, 64);
		setRotation(rightChestPiece, 0F, 0F, 0F);
		leftChestPiece = new ModelRenderer(this, 32, 32);
		leftChestPiece.mirror = true;
		leftChestPiece.addBox(0.3F, 1.5F, -2.2F, 4, 6, 0);
		leftChestPiece.setRotationPoint(0F, 0F, 0F);
		leftChestPiece.setTextureSize(64, 64);
		setRotation(leftChestPiece, 0F, 0F, 0F);
		middleChestPiece = new ModelRenderer(this, 28, 32);
		middleChestPiece.addBox(-0.5F, 3F, -2.3F, 1, 2, 0);
		middleChestPiece.setRotationPoint(0F, 0F, 0F);
		middleChestPiece.setTextureSize(64, 64);
		setRotation(middleChestPiece, 0F, 0F, 0F);
		rightKnee = new ModelRenderer(this, 0, 32);
		rightKnee.addBox(-1.5F, 4.5F, -2.1F, 3, 1, 0);
		rightKnee.setRotationPoint(0F, 0F, 0F);
		rightKnee.setTextureSize(64, 64);
		setRotation(rightKnee, 0F, 0F, 0F);
		leftKnee = new ModelRenderer(this, 0, 32);
		leftKnee.mirror = true;
		leftKnee.addBox(-1.5F, 4.5F, -2.1F, 3, 1, 0);
		leftKnee.setRotationPoint(0F, 0F, 0F);
		leftKnee.setTextureSize(64, 64);
		setRotation(leftKnee, 0F, 0F, 0F);

		pack = new ModelRenderer(this, 0, 64);
		pack.addBox(-3F, 1F, 2F, 6, 8, 3);
		pack.setRotationPoint(0F, 0F, 0F);
		pack.setTextureSize(64, 96);
		pack.mirror = true;
		setRotation(pack, 0F, 0F, 0F);
		tankleft = new ModelRenderer(this, 8, 75);
		tankleft.addBox(1.5F, 2F, 3.5F, 2, 6, 2);
		tankleft.setRotationPoint(0F, 0F, 0F);
		tankleft.setTextureSize(64, 96);
		tankleft.mirror = true;
		setRotation(tankleft, 0F, 0F, 0F);
		tankmiddle = new ModelRenderer(this, 0, 75);
		tankmiddle.addBox(-1F, 0F, 4.3F, 2, 8, 2);
		tankmiddle.setRotationPoint(0F, 0F, 0F);
		tankmiddle.setTextureSize(64, 96);
		tankmiddle.mirror = true;
		setRotation(tankmiddle, 0F, 0F, 0F);
		tankright = new ModelRenderer(this, 8, 83);
		tankright.addBox(-3.5F, 2F, 3.5F, 2, 6, 2);
		tankright.setRotationPoint(0F, 0F, 0F);
		tankright.setTextureSize(64, 96);
		tankright.mirror = true;
		setRotation(tankright, 0F, 0F, 0F);
		toptankleft = new ModelRenderer(this, 18, 64);
		toptankleft.addBox(2.1F, 0F, 4.1F, 1, 2, 1);
		toptankleft.setRotationPoint(0F, 0F, 0F);
		toptankleft.setTextureSize(64, 96);
		toptankleft.mirror = true;
		setRotation(toptankleft, 0F, 0F, 0F);
		toptankright = new ModelRenderer(this, 18, 64);
		toptankright.addBox(-3.1F, -1F, 4.1F, 1, 2, 1);
		toptankright.setRotationPoint(0F, 1F, 0F);
		toptankright.setTextureSize(64, 96);
		toptankright.mirror = true;
		setRotation(toptankright, 0F, 0F, 0F);
		toptankmiddle = new ModelRenderer(this, 18, 64);
		toptankmiddle.addBox(-0.5F, -2F, 4.8F, 1, 2, 1);
		toptankmiddle.setRotationPoint(0F, 0F, 0F);
		toptankmiddle.setTextureSize(64, 96);
		toptankmiddle.mirror = true;
		setRotation(toptankmiddle, 0F, 0F, 0F);
		engineright = new ModelRenderer(this, 18, 67);
		engineright.addBox(0F, 0F, -1F, 1, 2, 1);
		engineright.setRotationPoint(-3F, 8F, 5F);
		engineright.setTextureSize(64, 96);
		engineright.mirror = true;
		setRotation(engineright, 0.3490659F, 0F, 0.1745329F);
		engineleft = new ModelRenderer(this, 18, 67);
		engineleft.addBox(0F, 0F, -1F, 1, 2, 1);
		engineleft.setRotationPoint(2F, 8F, 5F);
		engineleft.setTextureSize(64, 96);
		engineleft.mirror = true;
		setRotation(engineleft, 0.3490659F, 0F, -0.1745329F);
		tankmiddlepart = new ModelRenderer(this, 18, 75);
		tankmiddlepart.addBox(-0.5F, 0.5F, 5.5F, 1, 7, 1);
		tankmiddlepart.setRotationPoint(0F, 0F, 0F);
		tankmiddlepart.setTextureSize(64, 96);
		tankmiddlepart.mirror = true;
		
		
		
		bipedHead.addChild(helmet);
		bipedBody.addChild(chest);
		bipedRightArm.addChild(rightArm);
		bipedLeftArm.addChild(leftArm);
		bipedRightLeg.addChild(rightLeg);
		bipedLeftLeg.addChild(leftLeg);
		bipedHead.addChild(bottomHelmetPiece);
		bipedHead.addChild(upperHelmetPiece);
		bipedRightArm.addChild(rightShoulder);
		bipedLeftArm.addChild(leftShoulder);
		bipedBody.addChild(rightChestPiece);
		bipedBody.addChild(middleChestPiece);
		bipedBody.addChild(leftChestPiece);
		bipedRightLeg.addChild(rightKnee);
		bipedLeftLeg.addChild(leftKnee);

		bipedBody.addChild(pack);
		bipedBody.addChild(tankleft);
		bipedBody.addChild(tankmiddle);
		bipedBody.addChild(tankright);
		bipedBody.addChild(toptankleft);
		bipedBody.addChild(toptankmiddle);
		bipedBody.addChild(toptankright);
		bipedBody.addChild(engineleft);
		bipedBody.addChild(engineright);
		bipedBody.addChild(tankmiddlepart);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
    {
    	super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    }
}