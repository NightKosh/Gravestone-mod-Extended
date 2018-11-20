package nightkosh.gravestone_extended.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.monster.EntityPossessedArmor;
import nightkosh.gravestone_extended.particle.ParticleGreenFlameFX;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RendererPossessedArmor extends RenderBiped<EntityPossessedArmor> {

    private int ticks = 0;
//    protected ModelBiped model;

    public RendererPossessedArmor(RenderManager renderManager) {
        super(renderManager, new ModelBiped(), 0.5F);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this);
        this.addLayer(layerbipedarmor);
//        model = (ModelBiped) this.getMainModel();
    }

    private static double ddz = 0.5;//.45;
    private static double ddx = 0.5;//0.45;


    private static double ddd = 0.3;



    @Override
    public void doRender(EntityPossessedArmor entity, double x, double y, double z, float yaw, float partialTicks) {
        super.doRender(entity, x, y, z, yaw, partialTicks);

        if (ticks > 20) {
            //TODO !!!!!!
//            double dz = 0.3 * Math.cos(Math.toRadians(45) + model.bipedHead.rotateAngleX);
            double rz = Math.sin(Math.toRadians(entity.getRotationYawHead() + entity.rotationYaw + 90));
            double rx = Math.cos(Math.toRadians(entity.getRotationYawHead() + entity.rotationYaw + 90));

            double dz =  -ddz * rz;
            double dz1 = (ddd - ddz) * rz;
            double dz2 = (-ddd - ddz) * rz;
            double dy = 0;//Math.sin(model.bipedHead.rotateAngleY);//TODO !!!
            double dx = -ddx * rx;
            double dx1 = (ddd - ddx) * rx;
            double dx2 = (- ddd - ddx) * rx;
//            double dx = ddx * Math.cos(Math.toRadians(entity.getRotationYawHead()) + entity.rotationYaw);//Math.toRadians

            Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleGreenFlameFX(entity.world, entity.posX + dx1, entity.posY + entity.getEyeHeight() + dy, entity.posZ + dz2, 0, 0, 0));
            Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleGreenFlameFX(entity.world, entity.posX + dx2, entity.posY + entity.getEyeHeight() + dy, entity.posZ + dz1, 0, 0, 0));

            ticks = 0;
        } else {
            ticks++;
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPossessedArmor entity) {
        return Resources.POSSESSED_ARMOR;
    }
}
