package nightkosh.gravestone_extended.models.entity;

import net.minecraft.client.model.ModelBat;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import nightkosh.gravestone_extended.entity.monster.bat.EntityHostileBat;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelHostileBat extends ModelBat {

    protected final ModelRenderer batHead;
    protected final ModelRenderer batBody;
    protected final ModelRenderer batRightWing;
    protected final ModelRenderer batLeftWing;
    protected final ModelRenderer batOuterRightWing;
    protected final ModelRenderer batOuterLeftWing;

    public ModelHostileBat() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.batHead = new ModelRenderer(this, 0, 0);
        this.batHead.addBox(-3, -3, -3, 6, 6, 6);
        ModelRenderer modelrenderer = new ModelRenderer(this, 24, 0);
        modelrenderer.addBox(-4, -6, -2, 3, 4, 1);
        this.batHead.addChild(modelrenderer);
        ModelRenderer modelrenderer1 = new ModelRenderer(this, 24, 0);
        modelrenderer1.mirror = true;
        modelrenderer1.addBox(1, -6, -2, 3, 4, 1);
        this.batHead.addChild(modelrenderer1);
        this.batBody = new ModelRenderer(this, 0, 16);
        this.batBody.addBox(-3, 4, -3, 6, 12, 6);
        this.batBody.setTextureOffset(0, 34).addBox(-5, 16, 0, 10, 6, 1);
        this.batRightWing = new ModelRenderer(this, 42, 0);
        this.batRightWing.addBox(-12, 1, 1.5F, 10, 16, 1);
        this.batOuterRightWing = new ModelRenderer(this, 24, 16);
        this.batOuterRightWing.setRotationPoint(-12, 1, 1.5F);
        this.batOuterRightWing.addBox(-8, 1, 0, 8, 12, 1);
        this.batLeftWing = new ModelRenderer(this, 42, 0);
        this.batLeftWing.mirror = true;
        this.batLeftWing.addBox(2, 1, 1.5F, 10, 16, 1);
        this.batOuterLeftWing = new ModelRenderer(this, 24, 16);
        this.batOuterLeftWing.mirror = true;
        this.batOuterLeftWing.setRotationPoint(12, 1, 1.5F);
        this.batOuterLeftWing.addBox(0, 1, 0, 8, 12, 1);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.batHead.render(scale);
        this.batBody.render(scale);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        if (((EntityHostileBat) entityIn).getIsBatHanging()) {
            this.batHead.rotateAngleX = headPitch * 0.017453292F;
            this.batHead.rotateAngleY = (float) Math.PI - netHeadYaw * 0.017453292F;
            this.batHead.rotateAngleZ = (float) Math.PI;
            this.batHead.setRotationPoint(0, -2, 0);
            this.batRightWing.setRotationPoint(-3, 0, 3);
            this.batLeftWing.setRotationPoint(3, 0, 3);
            this.batBody.rotateAngleX = (float) Math.PI;
            this.batRightWing.rotateAngleX = -0.15707964F;
            this.batRightWing.rotateAngleY = -((float) Math.PI * 2 / 5F);
            this.batOuterRightWing.rotateAngleY = -1.7278761F;
            this.batLeftWing.rotateAngleX = this.batRightWing.rotateAngleX;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterLeftWing.rotateAngleY = -this.batOuterRightWing.rotateAngleY;
        } else {
            this.batHead.rotateAngleX = headPitch * 0.017453292F;
            this.batHead.rotateAngleY = netHeadYaw * 0.017453292F;
            this.batHead.rotateAngleZ = 0;
            this.batHead.setRotationPoint(0, 0, 0);
            this.batRightWing.setRotationPoint(0, 0, 0);
            this.batLeftWing.setRotationPoint(0, 0, 0);
            this.batBody.rotateAngleX = ((float) Math.PI / 4F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.batBody.rotateAngleY = 0;
            this.batRightWing.rotateAngleY = MathHelper.cos(ageInTicks * 1.3F) * (float) Math.PI * 0.25F;
            this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
            this.batOuterRightWing.rotateAngleY = this.batRightWing.rotateAngleY * 0.5F;
            this.batOuterLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY * 0.5F;
        }
    }
}
