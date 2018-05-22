package nightkosh.gravestone_extended.models.armor.phantom_diver_costume;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ModelDivingHelmet extends ModelBiped {
    public ModelRenderer helmetBase;
    public ModelRenderer rim;

    public ModelDivingHelmet() {
        super(0, 0, 64, 32);

        helmetBase = new ModelRenderer(this, 0, 0);
        helmetBase.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9, 0);
        helmetBase.setRotationPoint(0, 0, 0);

        rim = new ModelRenderer(this, 0, 22);
        rim.addBox(-4, -8, -6, 8, 8, 2, 0);
        rim.setRotationPoint(0, 0, 0);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        GlStateManager.pushMatrix();
        if (entity.isSneaking()) {
            GlStateManager.translate(0, 0.2F, 0);
        }
        helmetBase.render(scale);
        rim.render(scale);

        GlStateManager.popMatrix();
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        helmetBase.rotateAngleY = bipedHead.rotateAngleY;
        helmetBase.rotateAngleX = bipedHead.rotateAngleX;
        rim.rotateAngleY = bipedHead.rotateAngleY;
        rim.rotateAngleX = bipedHead.rotateAngleX;
    }
}
