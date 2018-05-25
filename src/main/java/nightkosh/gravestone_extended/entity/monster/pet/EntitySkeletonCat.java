package nightkosh.gravestone_extended.entity.monster.pet;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.core.GSLootTables;
import nightkosh.gravestone_extended.core.Resources;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntitySkeletonCat extends EntityUndeadCat {

    public EntitySkeletonCat(World world) {
        super(world);
        this.setMobType(EnumUndeadMobType.SKELETON);

        this.tasks.addTask(1, new EntityAIRestrictSun(this));
        this.tasks.addTask(1, new EntityAIFleeSun(this, 1));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityWolf.class, 6, 1, 1.2));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1, false));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1));
        this.tasks.addTask(6, new EntityAIWander(this, 1));
        this.tasks.addTask(8, new EntityAIOcelotAttack(this));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ResourceLocation getTexture() {
        return Resources.SKELETON_CAT;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.7);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.SKELETON_CAT;
    }
}
