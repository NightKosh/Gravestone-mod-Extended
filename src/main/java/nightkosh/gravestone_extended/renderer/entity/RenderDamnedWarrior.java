package nightkosh.gravestone_extended.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.models.entity.ModelDamnedWarrior;
import nightkosh.gravestone_extended.particle.ParticleBigFlameFX;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RenderDamnedWarrior {//TODO extends RenderLiving {

//    private int ticks = 0;
//    private final ModelDamnedWarrior model;
//
//    public RenderDamnedWarrior(RenderManager renderManager, ModelDamnedWarrior model) {
//        super(renderManager, model, 0.5F);
//        this.model = model;
//    }
//
//    @Override
//    protected ResourceLocation getEntityTexture(Entity entity) {
//        return Resources.DAMNED_WARRIOR;
//    }
//
//    @Override
//    public void doRender(EntityLiving entity, double x, double y, double z, float entityYaw, float partialTicks) {
//        super.doRender(entity, x, y, z, entityYaw, partialTicks);
//
//        if (ticks > 40) {
//            Particle chestFlame = new ParticleBigFlameFX(entity.getEntityWorld(), entity.posX, entity.posY + 2.1, entity.posZ, 3, 0.1F, 0.85F, 0.1F);
//            Minecraft.getMinecraft().effectRenderer.addEffect(chestFlame);
//
//
//            double dz = 0.3 * Math.cos(Math.toRadians(45) + model.getSkull().rotateAngleZ);
//            double dy = Math.sin(model.getSkull().rotateAngleY);
//            double dx = 0.65 * Math.cos(Math.toRadians(45) + model.getSkull().rotateAngleX) * dy;
//
//            Particle leftEyeFlame = new ParticleBigFlameFX(entity.getEntityWorld(), entity.posX - dx, entity.posY + 2.82 - dy, entity.posZ + dz, 0.9F, 0.1F, 0.85F, 0.1F);
//            Minecraft.getMinecraft().effectRenderer.addEffect(leftEyeFlame);
//
//            Particle rightEyeFlame = new ParticleBigFlameFX(entity.getEntityWorld(), entity.posX + dx, entity.posY + 2.82 - dy, entity.posZ + dz, 0.9F, 0.1F, 0.85F, 0.1F);
//            Minecraft.getMinecraft().effectRenderer.addEffect(rightEyeFlame);
//            ticks = 0;
//        } else {
//            ticks++;
//        }
//    }
}