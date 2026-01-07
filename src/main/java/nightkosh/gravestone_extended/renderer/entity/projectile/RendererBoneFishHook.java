package nightkosh.gravestone_extended.renderer.entity.projectile;

import net.minecraft.client.Minecraft;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.projectile.EntityBoneFishHook;
import nightkosh.gravestone_extended.entity.projectile.EntityObsidianFishHook;
import nightkosh.gravestone_extended.item.tools.ItemBoneFishingPole;
import nightkosh.gravestone_extended.models.projectile.ModelBoneFishHook;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RendererBoneFishHook {//TODO extends Render<EntityBoneFishHook> {

    private ModelBoneFishHook hookModel;
//
//    public RendererBoneFishHook(RenderManager renderManager) {
//        super(renderManager);
//        hookModel = new ModelBoneFishHook();
//    }
//
//    //TODO remove !!
//    double xx = 0;
//    double yy = 0;
//    double zz = 0;
//
//    public void doRender(EntityBoneFishHook hook, double x, double y, double z, float yaw, float ticks) {
//        EntityPlayer player = hook.getAngler();
//
//        if (player != null && !this.renderOutlines) {
//            Tessellator tessellator = Tessellator.getInstance();
//            BufferBuilder bufferbuilder = tessellator.getBuffer();
//
//            GlStateManager.pushMatrix();
//            GlStateManager.translate(x, y, z);
//            GlStateManager.enableRescaleNormal();
//            GlStateManager.rotate(180, 0, 0, 1);
//            GlStateManager.rotate(135, 0, 1, 0);
//            GlStateManager.scale(0.5F, 0.5F, 0.5F);
//            GlStateManager.translate(0, -0.5F, 0);
//            this.bindEntityTexture(hook);
//            hookModel.render();
//            GlStateManager.disableRescaleNormal();
//            GlStateManager.popMatrix();
//
//
//            // Thread
//            int side = player.getPrimaryHand() == EnumHandSide.RIGHT ? 1 : -1;
//            if (!(player.getHeldItemMainhand().getItem() instanceof ItemBoneFishingPole)) {
//                side = -side;
//            }
//
//            double playerX = player.prevPosX + (player.posX - player.prevPosX) * ticks;
//            double playerY = player.prevPosY + player.getEyeHeight() + (player.posY - player.prevPosY) * ticks;
//            double playerZ = player.prevPosZ + (player.posZ - player.prevPosZ) * ticks;
//
//            if ((this.renderManager.options == null || this.renderManager.options.thirdPersonView <= 0) && player == Minecraft.getMinecraft().player) {
//                float f8 = MathHelper.sin(MathHelper.sqrt(player.getSwingProgress(ticks)) * (float) Math.PI);
//                float f10 = this.renderManager.options.fovSetting / 100F;
//                Vec3d vec = new Vec3d(side * -0.47 * f10, -0.045 * f10, 0.55)
//                        .rotatePitch(-(player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * ticks) * 0.017453292F)
//                        .rotateYaw(-(player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * ticks) * 0.017453292F)
//                        .rotateYaw(f8 * 0.5F)
//                        .rotatePitch(-f8 * 0.7F);
//                playerX += vec.x;//-0.11 0 0.15 -1.45
//                playerY += vec.y + player.getEyeHeight() - 1.45;
//                playerZ += vec.z;//0.1
//            } else {
//                float rendYaw = (player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * ticks) * 0.017453292F;
//                double yawSin = MathHelper.sin(rendYaw);
//                double yawCos = MathHelper.cos(rendYaw);
//                double d2 = side * 0.35;
//
//                //2.4 -0.1 -0.3
//                playerX -= yawCos * (d2 + 2.4 + xx) + yawSin * 0.8;//-0.8
//                playerY -= 0.45 + (player.isSneaking() ? -0.1875 : 0)  -0.1 + yy;
//                playerZ += yawCos * 0.8 - yawSin * (d2 + zz - 0.3);
//            }
//
//            double hookX = hook.prevPosX + (hook.posX - hook.prevPosX) * ticks;
//            double hookY = hook.prevPosY + (hook.posY - hook.prevPosY) * ticks + 0.25;
//            double hookZ = hook.prevPosZ + (hook.posZ - hook.prevPosZ) * ticks;
//            double dx = playerX - hookX;
//            double dy = playerY - hookY;
//            double dz = playerZ - hookZ;
//            GlStateManager.disableTexture2D();
//            GlStateManager.disableLighting();
//            bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);
//
//            for (int i = 0; i <= 16; i++) {
//                float f = i / 16F;
//                bufferbuilder.pos(x + dx * f, y + dy * (f * f + f) * 0.5 + 0.25, z + dz * f).color(255, 255, 255, 255).endVertex();
//            }
//
//            tessellator.draw();
//            GlStateManager.enableLighting();
//            GlStateManager.enableTexture2D();
//            super.doRender(hook, x, y, z, yaw, ticks);
//        }
//    }
//
//    @Nullable
//    @Override
//    protected ResourceLocation getEntityTexture(EntityBoneFishHook entity) {
//        if (entity instanceof EntityObsidianFishHook) {
//            return Resources.WITHERED_HOOK;
//        } else {
//            return Resources.BONE_HOOK;
//        }
//    }
}
