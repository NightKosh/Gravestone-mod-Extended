package nightkosh.gravestone_extended.models.armor.bone;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;


public class ModelBoneHelmet extends ModelBiped {
    public ModelRenderer skull;
    public ModelRenderer teeth;
    public ModelRenderer hornLeft11;
    public ModelRenderer hornLeft12;
    public ModelRenderer hornLeft13;
    public ModelRenderer hornRight11;
    public ModelRenderer hornRight12;
    public ModelRenderer hornRight13;
    public ModelRenderer hornLeft21;
    public ModelRenderer hornLeft22;
    public ModelRenderer hornLeft23;
    public ModelRenderer hornRight21;
    public ModelRenderer hornRight22;
    public ModelRenderer hornRight23;

    public ModelBoneHelmet() {
        super(0, 0, 64, 32);

        this.skull = new ModelRenderer(this, 0, 0);
        this.skull.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.skull.addBox(-4.5F, -9.0F, -4.5F, 9, 7, 9, 0.0F);

//        this.skullBottom = new ModelRenderer(this, 0, 18);
//        this.skullBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
//        this.skullBottom.addBox(-4.5F, -2.5F, -4.5F, 9, 3, 9, 0.0F);

        this.teeth = new ModelRenderer(this, 31, 0);
        this.teeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.teeth.addBox(-2.5F, -2.0F, -4.5F, 5, 2, 1, 0.0F);

        this.hornLeft11 = new ModelRenderer(this, 40, 17);
        this.hornLeft11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornLeft11.addBox(4.4F, -7.1F, 2.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(hornLeft11, 0.2617993877991494F, 0.0F, 0.0F);

        this.hornLeft12 = new ModelRenderer(this, 50, 15);
        this.hornLeft12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornLeft12.addBox(1.5F, -6.6F, 6.9F, 5, 2, 2, 0.0F);
        this.setRotateAngle(hornLeft12, 0.36425021489121656F, 0.7285004297824331F, 0.24609142453120048F);

        this.hornLeft13 = new ModelRenderer(this, 54, 19);
        this.hornLeft13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornLeft13.addBox(9.8F, -6.1F, -2.1F, 1, 1, 4, 0.0F);
        this.setRotateAngle(hornLeft13, 0.2617993877991494F, 0.0F, 0.0F);

        this.hornRight11 = new ModelRenderer(this, 40, 17);
        this.hornRight11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornRight11.addBox(-7.5F, -7.1F, 2.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(hornRight11, 0.2617993877991494F, 0.0F, 0.0F);

        this.hornRight12 = new ModelRenderer(this, 50, 15);
        this.hornRight12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornRight12.addBox(-6.8F, -6.5F, 6.9F, 5, 2, 2, 0.0F);
        this.setRotateAngle(hornRight12, 0.36425021489121656F, -0.7285004297824331F, -0.24609142453120048F);

        this.hornRight13 = new ModelRenderer(this, 54, 19);
        this.hornRight13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornRight13.addBox(-11.0F, -6.1F, -2.3F, 1, 1, 4, 0.0F);
        this.setRotateAngle(hornRight13, 0.2617993877991494F, 0.0F, 0.0F);

        this.hornLeft21 = new ModelRenderer(this, 52, 0);
        this.hornLeft21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornLeft21.addBox(0.9F, -11.3F, 1.8F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hornLeft21, 0.7853981633974483F, 0.0F, 0.0F);

        this.hornLeft22 = new ModelRenderer(this, 43, 0);
        this.hornLeft22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornLeft22.addBox(1.4F, -13.55F, -6.6F, 2, 4, 2, 0.0F);

        this.hornLeft23 = new ModelRenderer(this, 32, 4);
        this.hornLeft23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornLeft23.addBox(1.9F, -12.6F, -11.3F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hornLeft23, -0.4363323129985824F, 0.0F, 0.0F);

        this.hornRight21 = new ModelRenderer(this, 52, 0);
        this.hornRight21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornRight21.addBox(-3.8F, -11.3F, 1.8F, 3, 4, 3, 0.0F);
        this.setRotateAngle(hornRight21, 0.7853981633974483F, 0.0F, 0.0F);

        this.hornRight22 = new ModelRenderer(this, 43, 0);
        this.hornRight22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornRight22.addBox(-3.3F, -13.55F, -6.6F, 2, 4, 2, 0.0F);

        this.hornRight23 = new ModelRenderer(this, 32, 4);
        this.hornRight23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.hornRight23.addBox(-2.8F, -12.6F, -11.3F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hornRight23, -0.4363323129985824F, 0.0F, 0.0F);

        this.skull.addChild(this.teeth);
        this.skull.addChild(this.hornLeft11);
        this.skull.addChild(this.hornLeft12);
        this.skull.addChild(this.hornLeft13);
        this.skull.addChild(this.hornRight11);
        this.skull.addChild(this.hornRight12);
        this.skull.addChild(this.hornRight13);
        this.skull.addChild(this.hornLeft21);
        this.skull.addChild(this.hornLeft22);
        this.skull.addChild(this.hornLeft23);
        this.skull.addChild(this.hornRight21);
        this.skull.addChild(this.hornRight22);
        this.skull.addChild(this.hornRight23);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        GlStateManager.pushMatrix();
        if (entity.isSneaking()) {
            GlStateManager.translate(0, 0.2F, 0);
        }

        this.skull.render(f5);
        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        skull.rotateAngleY = bipedHead.rotateAngleY;
        skull.rotateAngleX = bipedHead.rotateAngleX;
        skull.rotateAngleZ = bipedHead.rotateAngleZ;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
