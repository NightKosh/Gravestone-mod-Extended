package nightkosh.gravestone_extended.entity.ai;

import nightkosh.gravestone_extended.entity.EntityRaven;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AIRavenFly {//TODO extends EntityAIBase {
//
//    private EntityRaven raven;
//
//    public AIRavenFly(EntityRaven raven) {
//        this.raven = raven;
//        this.setMutexBits(1);
//    }
//
//    public boolean shouldExecute() {
//        EntityMoveHelper moveHelper = this.raven.getMoveHelper();
//
//        if (!moveHelper.isUpdating()) {
//            return true;
//        } else {
//            double d0 = moveHelper.getX() - this.raven.posX;
//            double d1 = moveHelper.getY() - this.raven.posY;
//            double d2 = moveHelper.getZ() - this.raven.posZ;
//            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
//            return d3 < 1 || d3 > 3600;
//        }
//    }
//
//    public boolean shouldContinueExecuting() {
//        return false;
//    }
//
//    public void startExecuting() {
//        Random random = this.raven.getRNG();
//        double d0 = this.raven.posX + (double) ((random.nextFloat() * 2 - 1) * 16);
//        double d1 = this.raven.posY + (double) ((random.nextFloat() * 2 - 1) * 16);
//        double d2 = this.raven.posZ + (double) ((random.nextFloat() * 2 - 1) * 16);
//        this.raven.getMoveHelper().setMoveTo(d0, d1, d2, 1);
//    }
}
