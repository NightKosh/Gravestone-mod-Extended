package nightkosh.gravestone_extended.models.armor.bone;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;


public class ModelBoneChestplate extends ModelBiped {

    public ModelRenderer skullRight;
    public ModelRenderer teethRight;
    public ModelRenderer horn11;
    public ModelRenderer horn21;
    public ModelRenderer horn12;
    public ModelRenderer horn22;
    public ModelRenderer horn13;
    public ModelRenderer horn23;
    public ModelRenderer armRight;
    public ModelRenderer claw1;
    public ModelRenderer claw12;
    public ModelRenderer claw2;
    public ModelRenderer claw22;

    public ModelRenderer armLeft;
    public ModelRenderer armPlate11;
    public ModelRenderer armPlate12;
    public ModelRenderer armPlate13;
    public ModelRenderer armPlate21;
    public ModelRenderer armPlate22;
    public ModelRenderer armPlate23;

    public ModelBoneChestplate() {
        super(0, 0, 64, 32);

        this.skullRight = new ModelRenderer(this, 0, 0);
        this.skullRight.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.skullRight.addBox(-4.3F, -2.8F, -3.0F, 6, 4, 6, 0.0F);

        this.teethRight = new ModelRenderer(this, 19, 0);
        this.teethRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.teethRight.addBox(-4.2F, 1.1F, -1.4F, 1, 1, 3, 0.0F);

        this.horn11 = new ModelRenderer(this, 28, 0);
        this.horn11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.horn11.addBox(-3.4F, -5.0F, 0.6F, 2, 2, 2, 0.0F);
        this.setRotateAngle(horn11, 0.0F, 0.0F, -0.385F);

        this.horn12 = new ModelRenderer(this, 37, 0);
        this.horn12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.horn12.addBox(-4.7F, -5.3F, 1.1F, 1, 2, 1, 0.0F);

        this.horn13 = new ModelRenderer(this, 37, 0);
        this.horn13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.horn13.addBox(-5.9F, -5.8F, 1.1F, 1, 2, 1, 0.0F);
        this.setRotateAngle(horn13, 0.0F, 0.0F, 0.273F);

        this.horn21 = new ModelRenderer(this, 28, 0);
        this.horn21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.horn21.addBox(-3.4F, -5.0F, -2.7F, 2, 2, 2, 0.0F);
        this.setRotateAngle(horn21, 0.0F, 0.0F, -0.385F);

        this.horn22 = new ModelRenderer(this, 37, 0);
        this.horn22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.horn22.addBox(-4.7F, -5.3F, -2.2F, 1, 2, 1, 0.0F);

        this.horn23 = new ModelRenderer(this, 37, 0);
        this.horn23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.horn23.addBox(-5.9F, -5.8F, -2.2F, 1, 2, 1, 0.0F);
        this.setRotateAngle(horn23, 0.0F, 0.0F, 0.273F);

        this.armRight = new ModelRenderer(this, 48, 0);
        this.armRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armRight.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.15F);

        this.claw1 = new ModelRenderer(this, 25, 5);
        this.claw1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw1.addBox(-4.2F, 6.5F, -1.5F, 1, 2, 1, 0.0F);

        this.claw12 = new ModelRenderer(this, 39, 3);
        this.claw12.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.claw12.addBox(-5.1F, 7.2F, -2.5F, 1, 6, 1, 0.0F);

        this.claw2 = new ModelRenderer(this, 25, 5);
        this.claw2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.claw2.addBox(-4.2F, 6.5F, 0.5F, 1, 2, 1, 0.0F);

        this.claw22 = new ModelRenderer(this, 39, 3);
        this.claw22.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.claw22.addBox(-5.1F, 7.2F, 1.5F, 1, 6, 1, 0.0F);

        this.skullRight.addChild(this.horn11);
        this.skullRight.addChild(this.horn12);
        this.skullRight.addChild(this.claw2);
        this.skullRight.addChild(this.teethRight);
        this.skullRight.addChild(this.horn23);
        this.skullRight.addChild(this.horn21);
        this.skullRight.addChild(this.horn22);
        this.skullRight.addChild(this.horn13);
        this.skullRight.addChild(this.armRight);
        this.skullRight.addChild(this.claw1);


        this.armLeft = new ModelRenderer(this, 48, 0);
        this.armLeft.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.armLeft.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.15F);

        this.armPlate11 = new ModelRenderer(this, 0, 12);
        this.armPlate11.mirror = true;
        this.armPlate11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armPlate11.addBox(-0.9F, -3.8F, -2.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(armPlate11, -0.5585053606381855F, 0.0F, 0.0F);

        this.armPlate12 = new ModelRenderer(this, 0, 18);
        this.armPlate12.mirror = true;
        this.armPlate12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armPlate12.addBox(0.6F, -3.6F, -2.2F, 2, 1, 4, 0.0F);
        this.setRotateAngle(armPlate12, -0.5585053606381855F, 0.0F, 0.3490658503988659F);

        this.armPlate13 = new ModelRenderer(this, 0, 18);
        this.armPlate13.mirror = true;
        this.armPlate13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armPlate13.addBox(1.0F, -3.6F, -2.3F, 2, 1, 4, 0.0F);
        this.setRotateAngle(armPlate13, -0.5585053606381855F, 0.0F, 0.6981317007977318F);

        this.armPlate21 = new ModelRenderer(this, 0, 12);
        this.armPlate21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armPlate21.addBox(-0.9F, -4.0F, -2.2F, 3, 1, 4, 0.0F);
        this.setRotateAngle(armPlate21, 0.5585053606381855F, 0.0F, 0.0F);

        this.armPlate22 = new ModelRenderer(this, 0, 18);
        this.armPlate22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armPlate22.addBox(0.6F, -3.7F, -2.0F, 2, 1, 4, 0.0F);
        this.setRotateAngle(armPlate22, 0.5585053606381855F, 0.0F, 0.3490658503988659F);

        this.armPlate23 = new ModelRenderer(this, 0, 18);
        this.armPlate23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armPlate23.addBox(1.0F, -3.7F, -1.9F, 2, 1, 4, 0.0F);
        this.setRotateAngle(armPlate23, 0.5585053606381855F, 0.0F, 0.6981317007977318F);

        this.armLeft.addChild(this.armPlate11);
        this.armLeft.addChild(this.armPlate12);
        this.armLeft.addChild(this.armPlate13);
        this.armLeft.addChild(this.armPlate21);
        this.armLeft.addChild(this.armPlate22);
        this.armLeft.addChild(this.armPlate23);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        GlStateManager.pushMatrix();
        if (entity.isSneaking()) {
            GlStateManager.translate(0, 0.2F, 0);
        }

        GlStateManager.translate(this.claw12.offsetX, this.claw12.offsetY, this.claw12.offsetZ);
        GlStateManager.translate(this.claw12.rotationPointX * f5, this.claw12.rotationPointY * f5, this.claw12.rotationPointZ * f5);
        GlStateManager.scale(1, 1, 0.5);
        GlStateManager.translate(-this.claw12.offsetX, -this.claw12.offsetY, -this.claw12.offsetZ);
        GlStateManager.translate(-this.claw12.rotationPointX * f5, -this.claw12.rotationPointY * f5, -this.claw12.rotationPointZ * f5);
        this.claw12.render(f5);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate(this.claw22.offsetX, this.claw22.offsetY, this.claw22.offsetZ);
        GlStateManager.translate(this.claw22.rotationPointX * f5, this.claw22.rotationPointY * f5, this.claw22.rotationPointZ * f5);
        GlStateManager.scale(1, 1, 0.5);
        GlStateManager.translate(-this.claw22.offsetX, -this.claw22.offsetY, -this.claw22.offsetZ);
        GlStateManager.translate(-this.claw22.rotationPointX * f5, -this.claw22.rotationPointY * f5, -this.claw22.rotationPointZ * f5);
        this.claw22.render(f5);
        GlStateManager.popMatrix();

        this.skullRight.render(f5);
        this.armLeft.render(f5);
//        this.bipedBody.render(f5);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        skullRight.rotateAngleY = bipedRightArm.rotateAngleY;
        skullRight.rotateAngleX = bipedRightArm.rotateAngleX;
        skullRight.rotateAngleZ = bipedRightArm.rotateAngleZ;

        claw12.rotateAngleY = bipedRightArm.rotateAngleY;
        claw12.rotateAngleX = bipedRightArm.rotateAngleX;
        claw12.rotateAngleZ = bipedRightArm.rotateAngleZ;

        claw22.rotateAngleY = bipedRightArm.rotateAngleY;
        claw22.rotateAngleX = bipedRightArm.rotateAngleX;
        claw22.rotateAngleZ = bipedRightArm.rotateAngleZ;

        armLeft.rotateAngleY = bipedLeftArm.rotateAngleY;
        armLeft.rotateAngleX = bipedLeftArm.rotateAngleX;
        armLeft.rotateAngleZ = bipedLeftArm.rotateAngleZ;

//        bipedBody.rotateAngleY = bipedBody.rotateAngleY;
//        bipedBody.rotateAngleX = bipedBody.rotateAngleX;
//        bipedBody.rotateAngleZ = bipedBody.rotateAngleZ;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
