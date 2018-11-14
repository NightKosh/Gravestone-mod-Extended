package nightkosh.gravestone_extended.models.armor.bone;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;


public class ModelBoneBoots extends ModelBiped {
    public ModelRenderer bootLeft;
    public ModelRenderer bootRight;
    public ModelRenderer plateLeft11;
    public ModelRenderer plateLeft21;
    public ModelRenderer plateLeft12;
    public ModelRenderer plateLeft22;
    public ModelRenderer plateLeft13;
    public ModelRenderer plateLeft23;
    public ModelRenderer feetLeft;
    public ModelRenderer plateRight11;
    public ModelRenderer plateRight21;
    public ModelRenderer plateRight12;
    public ModelRenderer plateRight22;
    public ModelRenderer plateRight13;
    public ModelRenderer plateRight23;
    public ModelRenderer feetRight;

    public ModelBoneBoots() {
        super(0, 0, 64, 32);

        this.bootLeft = new ModelRenderer(this, 20, 0);
        this.bootLeft.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bootLeft.addBox(-2.3F, 6.1F, -2.5F, 5, 6, 5, 0.0F);

        this.bootRight = new ModelRenderer(this, 20, 0);
        this.bootRight.mirror = true;
        this.bootRight.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.bootRight.addBox(-2.6F, 6.1F, -2.5F, 5, 6, 5, 0.0F);

        this.plateLeft11 = new ModelRenderer(this, 0, 0);
        this.plateLeft11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateLeft11.addBox(-0.8F, 7.0F, -5.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateLeft11, 0.2617993877991494F, 0.5235987755982988F, 0.0F);

        this.plateLeft12 = new ModelRenderer(this, 0, 0);
        this.plateLeft12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateLeft12.addBox(-1.0F, 5.9F, -5.1F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateLeft12, 0.2617993877991494F, 0.5235987755982988F, 0.0F);

        this.plateLeft13 = new ModelRenderer(this, 0, 0);
        this.plateLeft13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateLeft13.addBox(-1.2F, 4.8F, -4.7F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateLeft13, 0.2617993877991494F, 0.5235987755982988F, 0.0F);

        this.plateLeft21 = new ModelRenderer(this, 9, 0);
        this.plateLeft21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateLeft21.addBox(-1.4F, 7.0F, -5.9F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateLeft21, 0.2617993877991494F, -0.5235987755982988F, 0.0F);

        this.plateLeft22 = new ModelRenderer(this, 9, 0);
        this.plateLeft22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateLeft22.addBox(-1.2F, 5.9F, -5.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateLeft22, 0.2617993877991494F, -0.5235987755982988F, 0.0F);

        this.plateLeft23 = new ModelRenderer(this, 9, 0);
        this.plateLeft23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateLeft23.addBox(-1.0F, 4.8F, -5.1F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateLeft23, 0.2617993877991494F, -0.5235987755982988F, 0.0F);

        this.plateRight11 = new ModelRenderer(this, 9, 0);
        this.plateRight11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateRight11.addBox(-1.5F, 7.0F, -5.8F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateRight11, 0.2617993877991494F, 0.5235987755982988F, 0.0F);

        this.plateRight12 = new ModelRenderer(this, 9, 0);
        this.plateRight12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateRight12.addBox(-1.7F, 5.9F, -5.4F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateRight12, 0.2617993877991494F, 0.5235987755982988F, 0.0F);

        this.plateRight13 = new ModelRenderer(this, 9, 0);
        this.plateRight13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateRight13.addBox(-1.9F, 4.8F, -5.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateRight13, 0.2617993877991494F, 0.5235987755982988F, 0.0F);

        this.plateRight21 = new ModelRenderer(this, 9, 0);
        this.plateRight21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateRight21.addBox(-2.0F, 7.0F, -5.5F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateRight21, 0.2617993877991494F, -0.5235987755982988F, 0.0F);

        this.plateRight22 = new ModelRenderer(this, 9, 0);
        this.plateRight22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateRight22.addBox(-1.8F, 5.9F, -5.1F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateRight22, 0.2617993877991494F, -0.5235987755982988F, 0.0F);

        this.plateRight23 = new ModelRenderer(this, 9, 0);
        this.plateRight23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.plateRight23.addBox(-1.6F, 4.8F, -4.7F, 3, 3, 1, 0.0F);
        this.setRotateAngle(plateRight23, 0.2617993877991494F, -0.5235987755982988F, 0.0F);

        this.feetLeft = new ModelRenderer(this, 0, 5);
        this.feetLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.feetLeft.addBox(-1.7F, 10.1F, -4.0F, 4, 2, 2, 0.0F);

        this.feetRight = new ModelRenderer(this, 0, 5);
        this.feetRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.feetRight.addBox(-2.2F, 10.1F, -4.0F, 4, 2, 2, 0.0F);



        this.bootLeft.addChild(this.feetLeft);
        this.bootLeft.addChild(this.plateLeft11);
        this.bootLeft.addChild(this.plateLeft12);
        this.bootLeft.addChild(this.plateLeft13);
        this.bootLeft.addChild(this.plateLeft21);
        this.bootLeft.addChild(this.plateLeft22);
        this.bootLeft.addChild(this.plateLeft23);

        this.bootRight.addChild(this.feetRight);
        this.bootRight.addChild(this.plateRight11);
        this.bootRight.addChild(this.plateRight12);
        this.bootRight.addChild(this.plateRight13);
        this.bootRight.addChild(this.plateRight21);
        this.bootRight.addChild(this.plateRight22);
        this.bootRight.addChild(this.plateRight23);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        GlStateManager.pushMatrix();
        if (entity.isSneaking()) {
            GlStateManager.translate(0, 0.2F, 0);
        }

        this.bootLeft.render(f5);
        this.bootRight.render(f5);
        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        bootLeft.rotateAngleY = bipedLeftLeg.rotateAngleY;
        bootLeft.rotateAngleX = bipedLeftLeg.rotateAngleX;
        bootLeft.rotateAngleZ = bipedLeftLeg.rotateAngleZ;
        bootLeft.rotationPointZ = bipedLeftLeg.rotationPointZ;
        bootLeft.rotationPointY = bipedLeftLeg.rotationPointY;

        bootRight.rotateAngleY = bipedRightLeg.rotateAngleY;
        bootRight.rotateAngleX = bipedRightLeg.rotateAngleX;
        bootRight.rotateAngleZ = bipedRightLeg.rotateAngleZ;
        bootRight.rotationPointZ = bipedRightLeg.rotationPointZ;
        bootRight.rotationPointY = bipedRightLeg.rotationPointY;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
