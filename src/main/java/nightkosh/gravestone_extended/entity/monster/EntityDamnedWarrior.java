package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSLootTables;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityDamnedWarrior extends EntityMob {

    public EntityDamnedWarrior(World world) {
        super(world);


//        this.tasks.addTask(2, new EntityAIRestrictSun(this));
//        this.tasks.addTask(5, new EntityAIWander(this, 1));
//        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10));
//        this.tasks.addTask(7, new EntityAILookIdle(this));
//
//
//        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
//
        if (world != null && !world.isRemote) {
            this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.2D, false));
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
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
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_SKELETON_STEP, 0.15F, 1);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    //TODO REMOVE!!!
    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        int l = this.rand.nextInt(3 + lootingModifier);

        for (int j1 = 0; j1 < l; ++j1) {
            this.dropItem(Items.BONE, 1);
        }
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.DAMNED_WARRIOR;
    }
//
//    @Override
//    protected void addRandomDrop() {
//        this.entityDropItem(new ItemStack(Items.SKULL, 1, 1), 0.0F);
//    }

    @Override
    public float getEyeHeight() {
        return 2.74F;
    }

    @Override
    protected boolean canDespawn() {
        return !this.hasCustomName();
    }
}
