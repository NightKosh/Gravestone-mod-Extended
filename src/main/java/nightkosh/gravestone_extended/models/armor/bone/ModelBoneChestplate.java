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
    public ModelRenderer gloveRight;

    public ModelRenderer armLeft;
    public ModelRenderer armPlate11;
    public ModelRenderer armPlate12;
    public ModelRenderer armPlate13;
    public ModelRenderer armPlate21;
    public ModelRenderer armPlate22;
    public ModelRenderer armPlate23;
    public ModelRenderer gloveLeft;


    public ModelRenderer body;
    public ModelRenderer rib0;
    public ModelRenderer rib11;
    public ModelRenderer rib12;
    public ModelRenderer rib13;
    public ModelRenderer rib14;
    public ModelRenderer rib15;
    public ModelRenderer rib21;
    public ModelRenderer rib22;
    public ModelRenderer rib23;
    public ModelRenderer rib24;
    public ModelRenderer rib25;
    public ModelRenderer rib31;
    public ModelRenderer rib32;
    public ModelRenderer rib33;
    public ModelRenderer rib34;
    public ModelRenderer rib35;
    public ModelRenderer rib41;
    public ModelRenderer rib42;
    public ModelRenderer rib43;
    public ModelRenderer rib44;
    public ModelRenderer rib45;
    public ModelRenderer rib51;
    public ModelRenderer rib52;
    public ModelRenderer rib53;
    public ModelRenderer rib54;
    public ModelRenderer rib55;
    public ModelRenderer rib61;
    public ModelRenderer rib62;
    public ModelRenderer rib63;
    public ModelRenderer rib64;
    public ModelRenderer rib65;
    public ModelRenderer spine0;
    public ModelRenderer spine1;
    public ModelRenderer spine2;
    public ModelRenderer spine3;
    public ModelRenderer spine4;
    public ModelRenderer spine5;
    public ModelRenderer spine6;
    public ModelRenderer spine7;
    public ModelRenderer spine8;
    public ModelRenderer spine9;
    public ModelRenderer spine10;
    public ModelRenderer spine11;
    public ModelRenderer spine12;

    public ModelBoneChestplate() {
        super(0, 0, 64, 32);

        this.skullRight = new ModelRenderer(this, 0, 0);
        this.skullRight.setRotationPoint(-5.0F, 2.0F, 0);
        this.skullRight.addBox(-4.3F, -2.8F, -3.0F, 6, 4, 6, 0);

        this.teethRight = new ModelRenderer(this, 19, 0);
        this.teethRight.setRotationPoint(0, 0, 0);
        this.teethRight.addBox(-4.2F, 1.1F, -1.4F, 1, 1, 3, 0);

        this.horn11 = new ModelRenderer(this, 28, 0);
        this.horn11.setRotationPoint(0, 0, 0);
        this.horn11.addBox(-3.4F, -5.0F, 0.6F, 2, 2, 2, 0);
        this.setRotateAngle(horn11, 0, 0, -0.385F);

        this.horn12 = new ModelRenderer(this, 37, 0);
        this.horn12.setRotationPoint(0, 0, 0);
        this.horn12.addBox(-4.7F, -5.3F, 1.1F, 1, 2, 1, 0);

        this.horn13 = new ModelRenderer(this, 37, 0);
        this.horn13.setRotationPoint(0, 0, 0);
        this.horn13.addBox(-5.9F, -5.8F, 1.1F, 1, 2, 1, 0);
        this.setRotateAngle(horn13, 0, 0, 0.273F);

        this.horn21 = new ModelRenderer(this, 28, 0);
        this.horn21.setRotationPoint(0, 0, 0);
        this.horn21.addBox(-3.4F, -5.0F, -2.7F, 2, 2, 2, 0);
        this.setRotateAngle(horn21, 0, 0, -0.385F);

        this.horn22 = new ModelRenderer(this, 37, 0);
        this.horn22.setRotationPoint(0, 0, 0);
        this.horn22.addBox(-4.7F, -5.3F, -2.2F, 1, 2, 1, 0);

        this.horn23 = new ModelRenderer(this, 37, 0);
        this.horn23.setRotationPoint(0, 0, 0);
        this.horn23.addBox(-5.9F, -5.8F, -2.2F, 1, 2, 1, 0);
        this.setRotateAngle(horn23, 0, 0, 0.273F);

        this.armRight = new ModelRenderer(this, 48, 0);
        this.armRight.setRotationPoint(0, 0, 0);
        this.armRight.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.2F);

        this.gloveRight = new ModelRenderer(this, 22, 9);
        this.gloveRight.mirror = true;
        this.gloveRight.setRotationPoint(0, 0, 0);
        this.gloveRight.addBox(-3.6F, 6.0F, -2.5F, 5, 5, 5, 0);

        this.skullRight.addChild(this.horn11);
        this.skullRight.addChild(this.horn12);
        this.skullRight.addChild(this.teethRight);
        this.skullRight.addChild(this.horn23);
        this.skullRight.addChild(this.horn21);
        this.skullRight.addChild(this.horn22);
        this.skullRight.addChild(this.horn13);
        this.skullRight.addChild(this.armRight);
        this.skullRight.addChild(this.gloveRight);


        this.armLeft = new ModelRenderer(this, 48, 0);
        this.armLeft.setRotationPoint(5.0F, 2.0F, 0);
        this.armLeft.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.20F);

        this.armPlate11 = new ModelRenderer(this, 0, 12);
        this.armPlate11.mirror = true;
        this.armPlate11.setRotationPoint(0, 0, 0);
        this.armPlate11.addBox(-0.9F, -3.8F, -2.0F, 3, 1, 4, 0);
        this.setRotateAngle(armPlate11, -0.558F, 0, 0);

        this.armPlate12 = new ModelRenderer(this, 0, 18);
        this.armPlate12.mirror = true;
        this.armPlate12.setRotationPoint(0, 0, 0);
        this.armPlate12.addBox(0.7F, -3.8F, -2.2F, 2, 1, 4, 0);
        this.setRotateAngle(armPlate12, -0.558F, 0, 0.349F);

        this.armPlate13 = new ModelRenderer(this, 0, 18);
        this.armPlate13.mirror = true;
        this.armPlate13.setRotationPoint(0, 0, 0);
        this.armPlate13.addBox(1.1F, -3.7F, -2.3F, 2, 1, 4, 0);
        this.setRotateAngle(armPlate13, -0.558F, 0, 0.698F);

        this.armPlate21 = new ModelRenderer(this, 0, 12);
        this.armPlate21.setRotationPoint(0, 0, 0);
        this.armPlate21.addBox(-0.9F, -4.0F, -2.2F, 3, 1, 4, 0);
        this.setRotateAngle(armPlate21, 0.558F, 0, 0);

        this.armPlate22 = new ModelRenderer(this, 0, 18);
        this.armPlate22.setRotationPoint(0, 0, 0);
        this.armPlate22.addBox(0.7F, -3.9F, -2.0F, 2, 1, 4, 0);
        this.setRotateAngle(armPlate22, 0.558F, 0, 0.349F);

        this.armPlate23 = new ModelRenderer(this, 0, 18);
        this.armPlate23.setRotationPoint(0, 0, 0);
        this.armPlate23.addBox(1.1F, -3.8F, -1.9F, 2, 1, 4, 0);
        this.setRotateAngle(armPlate23, 0.558F, 0, 0.698F);

        this.gloveLeft = new ModelRenderer(this, 22, 9);
        this.gloveLeft.setRotationPoint(0, 0, 0);
        this.gloveLeft.addBox(-1.4F, 6.0F, -2.5F, 5, 5, 5, 0);

        this.armLeft.addChild(this.armPlate11);
        this.armLeft.addChild(this.armPlate12);
        this.armLeft.addChild(this.armPlate13);
        this.armLeft.addChild(this.armPlate21);
        this.armLeft.addChild(this.armPlate22);
        this.armLeft.addChild(this.armPlate23);
        this.armLeft.addChild(this.gloveLeft);



        this.body = new ModelRenderer(this, 40, 16);
        this.body.setRotationPoint(0, 0, 0);
        this.body.addBox(-4.0F, 0, -2.0F, 8, 12, 4, 0.15F);

        this.rib0 = new ModelRenderer(this, 22, 20);
        this.rib0.setRotationPoint(0, 0, 0);
        this.rib0.addBox(1.4F, 0.2F, -2.4F, 1, 5, 1, 0);
        this.setRotateAngle(rib0, 0, 0.7853981633974483F, 0);

        this.rib11 = new ModelRenderer(this, 27, 20);
        this.rib11.setRotationPoint(0, 0, 0);
        this.rib11.addBox(0, 0.2F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib11, 0, 0, -0.09774593461356461F);

        this.rib12 = new ModelRenderer(this, 27, 20);
        this.rib12.setRotationPoint(0, 0, 0);
        this.rib12.addBox(-0.2F, 1.5F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib12, -0.008994344241520959F, 0, -0.08726646259971647F);

        this.rib13 = new ModelRenderer(this, 27, 20);
        this.rib13.setRotationPoint(0, 0, 0);
        this.rib13.addBox(-0.3F, 2.8F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib13, 0, 0, -0.08726646259971647F);

        this.rib14 = new ModelRenderer(this, 27, 20);
        this.rib14.setRotationPoint(0, 0, 0);
        this.rib14.addBox(-0.4F, 4.1F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib14, 0, 0, -0.08726646259971647F);

        this.rib15 = new ModelRenderer(this, 27, 20);
        this.rib15.setRotationPoint(0, 0, 0);
        this.rib15.addBox(1.4F, 5.4F, -3.0F, 3, 1, 1, 0);
        this.setRotateAngle(rib15, 0, 0, -0.08726646259971647F);

        this.rib21 = new ModelRenderer(this, 27, 20);
        this.rib21.mirror = true;
        this.rib21.setRotationPoint(0, 0, 0);
        this.rib21.addBox(-4.8F, 0.2F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib21, 0, 0, 0.08726646259971647F);

        this.rib22 = new ModelRenderer(this, 27, 20);
        this.rib22.mirror = true;
        this.rib22.setRotationPoint(0, 0, 0);
        this.rib22.addBox(-4.6F, 1.5F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib22, 0, 0, 0.08726646259971647F);

        this.rib23 = new ModelRenderer(this, 27, 20);
        this.rib23.mirror = true;
        this.rib23.setRotationPoint(0, 0, 0);
        this.rib23.addBox(-4.5F, 2.8F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib23, 0, 0, 0.08726646259971647F);

        this.rib24 = new ModelRenderer(this, 27, 20);
        this.rib24.mirror = true;
        this.rib24.setRotationPoint(0, 0, 0);
        this.rib24.addBox(-4.4F, 4.1F, -3.0F, 5, 1, 1, 0);
        this.setRotateAngle(rib24, 0, 0, 0.08726646259971647F);

        this.rib25 = new ModelRenderer(this, 27, 20);
        this.rib25.mirror = true;
        this.rib25.setRotationPoint(0, 0, 0);
        this.rib25.addBox(-4.2F, 5.4F, -3.0F, 3, 1, 1, 0);
        this.setRotateAngle(rib25, 0, 0, 0.08726646259971647F);

        this.rib31 = new ModelRenderer(this, 27, 20);
        this.rib31.setRotationPoint(0, 0, 0);
        this.rib31.addBox(0, 0.2F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib31, 0, 0, -0.08726646259971647F);

        this.rib32 = new ModelRenderer(this, 27, 20);
        this.rib32.setRotationPoint(0, 0, 0);
        this.rib32.addBox(-0.2F, 1.5F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib32, 0, 0, -0.08726646259971647F);

        this.rib33 = new ModelRenderer(this, 27, 20);
        this.rib33.setRotationPoint(0, 0, 0);
        this.rib33.addBox(-0.3F, 2.8F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib33, 0, 0, -0.08726646259971647F);

        this.rib34 = new ModelRenderer(this, 27, 20);
        this.rib34.setRotationPoint(0, 0, 0);
        this.rib34.addBox(-0.4F, 4.1F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib34, 0, 0, -0.08726646259971647F);

        this.rib35 = new ModelRenderer(this, 27, 20);
        this.rib35.setRotationPoint(0, 0, 0);
        this.rib35.addBox(-0.6F, 5.4F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib35, 0, 0, -0.08726646259971647F);

        this.rib41 = new ModelRenderer(this, 27, 20);
        this.rib41.mirror = true;
        this.rib41.setRotationPoint(0, 0, 0);
        this.rib41.addBox(-4.8F, 0.2F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib41, 0, 0, 0.08726646259971647F);

        this.rib42 = new ModelRenderer(this, 27, 20);
        this.rib42.mirror = true;
        this.rib42.setRotationPoint(0, 0, 0);
        this.rib42.addBox(-4.6F, 1.5F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib42, 0, 0, 0.08726646259971647F);

        this.rib43 = new ModelRenderer(this, 27, 20);
        this.rib43.mirror = true;
        this.rib43.setRotationPoint(0, 0, 0);
        this.rib43.addBox(-4.5F, 2.8F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib43, 0, 0, 0.08726646259971647F);

        this.rib44 = new ModelRenderer(this, 27, 20);
        this.rib44.mirror = true;
        this.rib44.setRotationPoint(0, 0, 0);
        this.rib44.addBox(-4.4F, 4.1F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib44, 0, 0, 0.08726646259971647F);

        this.rib45 = new ModelRenderer(this, 27, 20);
        this.rib45.mirror = true;
        this.rib45.setRotationPoint(0, 0, 0);
        this.rib45.addBox(-4.2F, 5.4F, 1.5F, 5, 1, 1, 0);
        this.setRotateAngle(rib45, 0, 0, 0.08726646259971647F);

        this.rib51 = new ModelRenderer(this, 29, 23);
        this.rib51.setRotationPoint(0, 0, 0);
        this.rib51.addBox(4.0F, 0.2F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib51, 0, 0, -0.08726646259971647F);

        this.rib52 = new ModelRenderer(this, 29, 23);
        this.rib52.setRotationPoint(0, 0, 0);
        this.rib52.addBox(3.8F, 1.5F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib52, 0, 0, -0.08726646259971647F);

        this.rib53 = new ModelRenderer(this, 29, 23);
        this.rib53.setRotationPoint(0, 0, 0);
        this.rib53.addBox(3.7F, 2.8F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib53, 0, 0, -0.08726646259971647F);

        this.rib54 = new ModelRenderer(this, 29, 23);
        this.rib54.setRotationPoint(0, 0, 0);
        this.rib54.addBox(3.6F, 4.1F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib54, 0, 0, -0.08726646259971647F);

        this.rib55 = new ModelRenderer(this, 29, 23);
        this.rib55.setRotationPoint(0, 0, 0);
        this.rib55.addBox(3.4F, 5.4F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib55, 0, 0, -0.08726646259971647F);

        this.rib61 = new ModelRenderer(this, 29, 23);
        this.rib61.mirror = true;
        this.rib61.setRotationPoint(0, 0, 0);
        this.rib61.addBox(-4.8F, 0.2F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib61, 0, 0, 0.08726646259971647F);

        this.rib62 = new ModelRenderer(this, 29, 23);
        this.rib62.mirror = true;
        this.rib62.setRotationPoint(0, 0, 0);
        this.rib62.addBox(-4.6F, 1.5F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib62, 0, 0, 0.08726646259971647F);

        this.rib63 = new ModelRenderer(this, 29, 23);
        this.rib63.mirror = true;
        this.rib63.setRotationPoint(0, 0, 0);
        this.rib63.addBox(-4.5F, 2.8F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib63, 0, 0, 0.08726646259971647F);

        this.rib64 = new ModelRenderer(this, 29, 23);
        this.rib64.mirror = true;
        this.rib64.setRotationPoint(0, 0, 0);
        this.rib64.addBox(-4.4F, 4.1F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib64, 0, 0, 0.08726646259971647F);

        this.rib65 = new ModelRenderer(this, 29, 23);
        this.rib65.mirror = true;
        this.rib65.setRotationPoint(0, 0, 0);
        this.rib65.addBox(-4.2F, 5.4F, -2.3F, 1, 1, 4, 0);
        this.setRotateAngle(rib65, 0, 0, 0.08726646259971647F);



        this.body.addChild(this.rib0);
        this.body.addChild(this.rib11);
        this.body.addChild(this.rib12);
        this.body.addChild(this.rib13);
        this.body.addChild(this.rib14);
        this.body.addChild(this.rib15);
        this.body.addChild(this.rib21);
        this.body.addChild(this.rib22);
        this.body.addChild(this.rib23);
        this.body.addChild(this.rib24);
        this.body.addChild(this.rib25);
        this.body.addChild(this.rib31);
        this.body.addChild(this.rib32);
        this.body.addChild(this.rib33);
        this.body.addChild(this.rib34);
        this.body.addChild(this.rib35);
        this.body.addChild(this.rib41);
        this.body.addChild(this.rib42);
        this.body.addChild(this.rib43);
        this.body.addChild(this.rib44);
        this.body.addChild(this.rib45);
        this.body.addChild(this.rib51);
        this.body.addChild(this.rib52);
        this.body.addChild(this.rib53);
        this.body.addChild(this.rib54);
        this.body.addChild(this.rib55);
        this.body.addChild(this.rib61);
        this.body.addChild(this.rib62);
        this.body.addChild(this.rib63);
        this.body.addChild(this.rib64);
        this.body.addChild(this.rib65);


        this.spine0 = new ModelRenderer(this, 22, 27);
        this.spine0.setRotationPoint(0, 0, 0);
        this.spine0.addBox(-2.2F, -2.6F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine0, 0, 0.7853981633974483F, 0);

        this.spine1 = new ModelRenderer(this, 22, 27);
        this.spine1.setRotationPoint(0, 0, 0);
        this.spine1.addBox(-2.2F, -1.5F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine1, 0, 0.7853981633974483F, 0);

        this.spine2 = new ModelRenderer(this, 22, 27);
        this.spine2.setRotationPoint(0, 0, 0);
        this.spine2.addBox(-2.2F, -0.4F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine2, 0, 0.7853981633974483F, 0);

        this.spine3 = new ModelRenderer(this, 22, 27);
        this.spine3.setRotationPoint(0, 0, 0);
        this.spine3.addBox(-2.2F, 0.7F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine3, 0, 0.7853981633974483F, 0);

        this.spine4 = new ModelRenderer(this, 22, 27);
        this.spine4.setRotationPoint(0, 0, 0);
        this.spine4.addBox(-2.2F, 1.8F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine4, 0, 0.7853981633974483F, 0);

        this.spine5 = new ModelRenderer(this, 22, 27);
        this.spine5.setRotationPoint(0, 0, 0);
        this.spine5.addBox(-2.2F, 2.9F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine5, 0, 0.7853981633974483F, 0);

        this.spine6 = new ModelRenderer(this, 22, 27);
        this.spine6.setRotationPoint(0, 0, 0);
        this.spine6.addBox(-2.2F, 4.0F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine6, 0, 0.7853981633974483F, 0);

        this.spine7 = new ModelRenderer(this, 22, 27);
        this.spine7.setRotationPoint(0, 0, 0);
        this.spine7.addBox(-2.2F, 5.1F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine7, 0, 0.7853981633974483F, 0);

        this.spine8 = new ModelRenderer(this, 22, 27);
        this.spine8.setRotationPoint(0, 0, 0);
        this.spine8.addBox(-2.2F, 6.2F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine8, 0, 0.7853981633974483F, 0);

        this.spine9 = new ModelRenderer(this, 22, 27);
        this.spine9.setRotationPoint(0, 0, 0);
        this.spine9.addBox(-2.2F, 7.3F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine9, 0, 0.7853981633974483F, 0);

        this.spine10 = new ModelRenderer(this, 22, 27);
        this.spine10.setRotationPoint(0, 0, 0);
        this.spine10.addBox(-2.2F, 8.4F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine10, 0, 0.7853981633974483F, 0);

        this.spine11 = new ModelRenderer(this, 22, 27);
        this.spine11.setRotationPoint(0, 0, 0);
        this.spine11.addBox(-2.2F, 9.5F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine11, 0, 0.7853981633974483F, 0);

        this.spine12 = new ModelRenderer(this, 22, 27);
        this.spine12.setRotationPoint(0, 0, 0);
        this.spine12.addBox(-2.2F, 10.6F, 1.2F, 1, 1, 1, 0);
        this.setRotateAngle(spine12, 0, 0.7853981633974483F, 0);

        this.body.addChild(this.spine0);
        this.body.addChild(this.spine1);
        this.body.addChild(this.spine2);
        this.body.addChild(this.spine3);
        this.body.addChild(this.spine4);
        this.body.addChild(this.spine5);
        this.body.addChild(this.spine6);
        this.body.addChild(this.spine7);
        this.body.addChild(this.spine8);
        this.body.addChild(this.spine9);
        this.body.addChild(this.spine10);
        this.body.addChild(this.spine11);
        this.body.addChild(this.spine12);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        GlStateManager.pushMatrix();
        if (entity.isSneaking()) {
            GlStateManager.translate(0, 0.2F, 0);
        }

        this.skullRight.render(f5);
        this.armLeft.render(f5);
        this.body.render(f5);

        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        skullRight.rotateAngleY = bipedRightArm.rotateAngleY;
        skullRight.rotateAngleX = bipedRightArm.rotateAngleX;
        skullRight.rotateAngleZ = bipedRightArm.rotateAngleZ;

        armLeft.rotateAngleY = bipedLeftArm.rotateAngleY;
        armLeft.rotateAngleX = bipedLeftArm.rotateAngleX;
        armLeft.rotateAngleZ = bipedLeftArm.rotateAngleZ;

        body.rotateAngleY = bipedBody.rotateAngleY;
        body.rotateAngleX = bipedBody.rotateAngleX;
        body.rotateAngleZ = bipedBody.rotateAngleZ;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
