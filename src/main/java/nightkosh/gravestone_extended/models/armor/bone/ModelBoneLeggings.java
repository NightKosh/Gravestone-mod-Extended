package nightkosh.gravestone_extended.models.armor.bone;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;


public class ModelBoneLeggings extends ModelBiped {

    public ModelRenderer legLeft;
    public ModelRenderer legRight;

    public ModelRenderer belt;
    public ModelRenderer belt10;
    public ModelRenderer belt11;
    public ModelRenderer belt12;
    public ModelRenderer belt13;
    public ModelRenderer belt21;
    public ModelRenderer belt22;
    public ModelRenderer belt23;
    public ModelRenderer belt31;
    public ModelRenderer belt32;
    public ModelRenderer belt33;
    public ModelRenderer belt41;
    public ModelRenderer belt42;
    public ModelRenderer belt43;

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

        this.belt10 = new ModelRenderer(this, 16, 12);
        this.belt10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt10.addBox(5.8F, 5.8F, -3.4F, 3, 3, 1, 0.0F);
        this.setRotateAngle(belt10, 0.0F, 0.0F, 0.7853981633974483F);

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

        this.belt21 = new ModelRenderer(this, 9, 17);
        this.belt21.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt21.addBox(1.9F, 7.2F, -10.2F, 1, 3, 3, 0.0F);
        this.setRotateAngle(belt21, 0.7853981633974483F, 0.0F, -0.17453292519943295F);

        this.belt22 = new ModelRenderer(this, 9, 17);
        this.belt22.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt22.addBox(1.4F, 8.1F, -11.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(belt22, 0.7853981633974483F, 0.0F, -0.17453292519943295F);

        this.belt23 = new ModelRenderer(this, 9, 17);
        this.belt23.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt23.addBox(0.9F, 9.0F, -11.8F, 1, 3, 3, 0.0F);
        this.setRotateAngle(belt23, 0.7853981633974483F, 0.0F, -0.17453292519943295F);

        this.belt31 = new ModelRenderer(this, 9, 17);
        this.belt31.mirror = true;
        this.belt31.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt31.addBox(-2.9F, 7.2F, -10.2F, 1, 3, 3, 0.0F);
        this.setRotateAngle(belt31, 0.7853981633974483F, 0.0F, 0.17453292519943295F);

        this.belt32 = new ModelRenderer(this, 9, 17);
        this.belt32.mirror = true;
        this.belt32.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt32.addBox(-2.4F, 8.1F, -11.0F, 1, 3, 3, 0.0F);
        this.setRotateAngle(belt32, 0.7853981633974483F, 0.0F, 0.17453292519943295F);

        this.belt33 = new ModelRenderer(this, 9, 17);
        this.belt33.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt33.addBox(-1.9F, 9.0F, -11.8F, 1, 3, 3, 0.0F);
        this.setRotateAngle(belt33, 0.7853981633974483F, 0.0F, 0.17453292519943295F);

        this.belt41 = new ModelRenderer(this, 25, 12);
        this.belt41.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt41.addBox(-3.5F, 12.0F, -1.4F, 7, 2, 1, 0.0F);
        this.setRotateAngle(belt41, 0.2617993877991494F, 0.0F, 0.0F);

        this.belt42 = new ModelRenderer(this, 25, 12);
        this.belt42.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt42.addBox(-3.5F, 13.0F, -1.7F, 7, 2, 1, -0.1F);
        this.setRotateAngle(belt42, 0.2617993877991494F, 0.0F, 0.0F);

        this.belt43 = new ModelRenderer(this, 25, 12);
        this.belt43.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt43.addBox(-3.5F, 14.0F, -2.1F, 7, 2, 1, -0.2F);
        this.setRotateAngle(belt43, 0.2617993877991494F, 0.0F, 0.0F);


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

        this.belt.addChild(this.belt10);
        this.belt.addChild(this.belt11);
        this.belt.addChild(this.belt12);
        this.belt.addChild(this.belt13);
        this.belt.addChild(this.belt21);
        this.belt.addChild(this.belt22);
        this.belt.addChild(this.belt23);
        this.belt.addChild(this.belt31);
        this.belt.addChild(this.belt32);
        this.belt.addChild(this.belt33);
        this.belt.addChild(this.belt41);
        this.belt.addChild(this.belt42);
        this.belt.addChild(this.belt43);

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
