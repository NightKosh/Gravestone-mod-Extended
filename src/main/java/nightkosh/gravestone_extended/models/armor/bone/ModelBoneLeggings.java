package nightkosh.gravestone_extended.models.armor.bone;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;


public class ModelBoneLeggings extends ModelBiped {

    public ModelRenderer legLeft;
    public ModelRenderer legRight;
    public ModelRenderer belt;
    public ModelRenderer belt11;
    public ModelRenderer belt12;
    public ModelRenderer belt13;
    public ModelRenderer bone11;
    public ModelRenderer bone12;
    public ModelRenderer bone21;
    public ModelRenderer bone22;
    public ModelRenderer bone20;
    public ModelRenderer bone31;
    public ModelRenderer bone32;
    public ModelRenderer bone41;
    public ModelRenderer bone42;

    public ModelBoneLeggings() {
        super(0, 0, 64, 32);
        this.legLeft = new ModelRenderer(this, 0, 0);
        this.legLeft.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.legLeft.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.15F);

        this.legRight = new ModelRenderer(this, 0, 0);
        this.legRight.mirror = true;
        this.legRight.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.legRight.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.15F);

        this.belt = new ModelRenderer(this, 18, 0);
        this.belt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt.addBox(-5.0F, 9.05F, -3.0F, 10, 3, 6, 0.0F);

        this.belt11 = new ModelRenderer(this, 0, 12);
        this.belt11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt11.addBox(-1.0F, 11.8F, 0.1F, 2, 2, 1, 0.0F);
        this.setRotateAngle(belt11, -0.2617993877991494F, 0.0F, 0.0F);

        this.belt12 = new ModelRenderer(this, 0, 12);
        this.belt12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt12.addBox(-1.0F, 12.8F, 0.7F, 2, 2, 1, -0.1F);
        this.setRotateAngle(belt12, -0.2617993877991494F, 0.0F, 0.0F);

        this.belt13 = new ModelRenderer(this, 0, 12);
        this.belt13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt13.addBox(-1.0F, 13.8F, 1.3F, 2, 2, 1, -0.2F);
        this.setRotateAngle(belt13, -0.2617993877991494F, 0.0F, 0.0F);


        this.bone11 = new ModelRenderer(this, 8, 12);
        this.bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone11.addBox(2.5F, 8.5F, -3.5F, 1, 4, 1, 0.0F);

        this.bone12 = new ModelRenderer(this, 8, 12);
        this.bone12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone12.addBox(-3.5F, 8.5F, -3.5F, 1, 4, 1, 0.0F);

        this.bone20 = new ModelRenderer(this, 8, 12);
        this.bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone20.addBox(-0.5F, 8.5F, 2.5F, 1, 4, 1, 0.0F);

        this.bone21 = new ModelRenderer(this, 8, 12);
        this.bone21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone21.addBox(2.5F, 8.5F, 2.5F, 1, 4, 1, 0.0F);

        this.bone22 = new ModelRenderer(this, 8, 12);
        this.bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone22.addBox(-3.5F, 8.5F, 2.5F, 1, 4, 1, 0.0F);

        this.bone31 = new ModelRenderer(this, 8, 12);
        this.bone31.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone31.addBox(4.5F, 8.5F, -2.0F, 1, 4, 1, 0.0F);

        this.bone32 = new ModelRenderer(this, 8, 12);
        this.bone32.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone32.addBox(4.5F, 8.5F, 1.0F, 1, 4, 1, 0.0F);

        this.bone41 = new ModelRenderer(this, 8, 12);
        this.bone41.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone41.addBox(-5.5F, 8.5F, -2.0F, 1, 4, 1, 0.0F);

        this.bone42 = new ModelRenderer(this, 8, 12);
        this.bone42.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bone42.addBox(-5.5F, 8.5F, 1.0F, 1, 4, 1, 0.0F);

        this.belt.addChild(this.belt11);
        this.belt.addChild(this.belt12);
        this.belt.addChild(this.belt13);
        this.belt.addChild(this.bone11);
        this.belt.addChild(this.bone12);
        this.belt.addChild(this.bone20);
        this.belt.addChild(this.bone22);
        this.belt.addChild(this.bone21);
        this.belt.addChild(this.bone31);
        this.belt.addChild(this.bone32);
        this.belt.addChild(this.bone41);
        this.belt.addChild(this.bone42);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        GlStateManager.pushMatrix();
        if (entity.isSneaking()) {
            GlStateManager.translate(0, 0.2F, 0);
        }
        this.legLeft.render(f5);
        this.legRight.render(f5);
        this.belt.render(f5);

        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        legLeft.rotateAngleY = bipedLeftLeg.rotateAngleY;
        legLeft.rotateAngleX = bipedLeftLeg.rotateAngleX;
        legLeft.rotateAngleZ = bipedLeftLeg.rotateAngleZ;

        legRight.rotateAngleY = bipedRightLeg.rotateAngleY;
        legRight.rotateAngleX = bipedRightLeg.rotateAngleX;
        legRight.rotateAngleZ = bipedRightLeg.rotateAngleZ;

        belt.rotateAngleY = bipedBody.rotateAngleY;
        belt.rotateAngleX = bipedBody.rotateAngleX;
        belt.rotateAngleZ = bipedBody.rotateAngleZ;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
