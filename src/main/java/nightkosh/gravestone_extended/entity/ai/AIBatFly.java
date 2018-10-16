package nightkosh.gravestone_extended.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import nightkosh.gravestone_extended.entity.monster.bat.EntityHostileBat;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AIBatFly extends EntityAIBase {

    private final EntityHostileBat bat;
    private Random rand;

    public AIBatFly(EntityHostileBat bat) {
        this.bat = bat;
        rand = bat.getRNG();
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return true;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }

    @Override
    public void updateTask() {
        BlockPos pos = new BlockPos(bat);
        BlockPos upPos = pos.up();
        if (bat.getIsBatHanging()) {
            if (bat.world.getBlockState(upPos).isNormalCube()) {
                if (this.rand.nextInt(200) == 0) {
                    bat.rotationYawHead = this.rand.nextInt(360);
                }

                if (bat.getAttackTarget() != null) {
                    bat.setIsBatHanging(false);
                    bat.world.playEvent(null, 1025, pos, 0);
                }
            } else {
                bat.setIsBatHanging(false);
                bat.world.playEvent(null, 1025, pos, 0);
            }
        } else {
            if (bat.getSpawnPosition() != null && (!bat.world.isAirBlock(bat.getSpawnPosition()) || bat.getSpawnPosition().getY() < 1)) {
                bat.setSpawnPosition(null);
            }

            if (bat.getAttackTarget() != null) {
                bat.setSpawnPosition(bat.getAttackTarget().getPosition().up());
            } else if (bat.getSpawnPosition() == null || this.rand.nextInt(30) == 0 || bat.getSpawnPosition().distanceSq(bat.posX, bat.posY, bat.posZ) < 4) {
                bat.setSpawnPosition(new BlockPos(bat.posX + this.rand.nextInt(7) - this.rand.nextInt(7), bat.posY + this.rand.nextInt(6) - 2, bat.posZ + this.rand.nextInt(7) - this.rand.nextInt(7)));
            }

            double d0 = bat.getSpawnPosition().getX() + 0.5 - bat.posX;
            double d1 = bat.getSpawnPosition().getY() + 0.1 - bat.posY;
            double d2 = bat.getSpawnPosition().getZ() + 0.5 - bat.posZ;
            bat.motionX += (Math.signum(d0) * 0.5 - bat.motionX) * 0.1;
            bat.motionY += (Math.signum(d1) * 0.7 - bat.motionY) * 0.1;
            bat.motionZ += (Math.signum(d2) * 0.5 - bat.motionZ) * 0.1;
            float f = (float) (MathHelper.atan2(bat.motionZ, bat.motionX) * (180 / Math.PI)) - 90;
            float f1 = MathHelper.wrapDegrees(f - bat.rotationYaw);
            bat.moveForward = 0.5F;
            bat.rotationYaw += f1;

            if (this.rand.nextInt(100) == 0 && bat.world.getBlockState(upPos).isNormalCube()) {
                bat.setIsBatHanging(true);
            }
        }

        super.updateTask();
    }
}
