package nightkosh.gravestone_extended.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import nightkosh.gravestone_extended.helper.GameRuleHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityAIBreakBlock extends EntityAIBlockInteract {

    private boolean isBlockBroken = false;

    public EntityAIBreakBlock(EntityLiving entity, Block block) {
        super(entity, block);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        return super.shouldExecute() && GameRuleHelper.checkMobGriefing(this.theEntity.getEntityWorld());
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean shouldContinueExecuting() {
        double d0 = this.theEntity.getDistanceSq((double) this.entityPosX, (double) this.entityPosY, (double) this.entityPosZ);
        return d0 < 4.0D;
    }

    /**
     * Resets the task
     */
    @Override
    public void resetTask() {
        super.resetTask();
        //this.theEntity.getEntityWorld().destroyBlockInWorldPartially(this.theEntity.entityId, this.entityPosX, this.entityPosY, this.entityPosZ, -1);
    }

    /**
     * Updates the task
     */
    @Override
    public void updateTask() {
        super.updateTask();

        if (!isBlockBroken && this.theEntity.getEntityWorld().getDifficulty() == EnumDifficulty.NORMAL ||
                this.theEntity.getEntityWorld().getDifficulty() == EnumDifficulty.HARD) {
            isBlockBroken = true;
            BlockPos pos = new BlockPos(this.theEntity);
            //TODO
//            this.targetBlock.dropBlockAsItem(this.theEntity.getEntityWorld(), pos, 0, 0);
            this.theEntity.getEntityWorld().setBlockToAir(pos);
//            this.theEntity.getEntityWorld().playAuxSFX(1012, pos, 0);
//            this.theEntity.getEntityWorld().playAuxSFX(2001, pos, 0);
        }
    }
}
