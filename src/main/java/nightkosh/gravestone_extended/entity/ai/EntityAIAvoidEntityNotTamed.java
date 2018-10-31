package nightkosh.gravestone_extended.entity.ai;

import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.passive.EntityTameable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityAIAvoidEntityNotTamed extends EntityAIAvoidEntity {
    public EntityAIAvoidEntityNotTamed(EntityTameable entity, Class classToAvoid, float avoidDistance, double farSpeed, double nearSpeed) {
        super(entity, classToAvoid, avoidDistance, farSpeed, nearSpeed);
    }

    @Override
    public boolean shouldExecute() {
        return !((EntityTameable) this.entity).isTamed() && super.shouldExecute();
    }

    @Override
    public boolean shouldContinueExecuting() {
        return !((EntityTameable) this.entity).isTamed() && super.shouldContinueExecuting();
    }
}
