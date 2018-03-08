package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSSound;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.ai.AIBarghestInvisible;
import nightkosh.gravestone_extended.entity.monster.pet.EntityUndeadDog;
import nightkosh.gravestone_extended.entity.monster.pet.EnumUndeadMobType;
import nightkosh.gravestone_extended.helper.MobsHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityBarghest extends EntityUndeadDog {

    protected boolean isBarghestInvisible;
    private static final DataParameter<Boolean> INVISIBLE_ID = EntityDataManager.createKey(EntityBarghest.class, DataSerializers.BOOLEAN);

    public EntityBarghest(World world) {
        super(world);
        this.setSize(1.2F, 1.7F);
        this.setMobType(EnumUndeadMobType.GHOST);
    }

    @Override
    public ResourceLocation getTexture() {
        if (this.isBarghestInvisible()) {
            return Resources.BARGHEST_INVISIBLE;
        } else {
            return Resources.BARGHEST;
        }
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new AIBarghestInvisible(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1));
    }

    @Override
    protected void updateAITasks() {
        this.dataManager.set(INVISIBLE_ID, isBarghestInvisible);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(INVISIBLE_ID, isBarghestInvisible);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    public void onLivingUpdate() {
        if (this.world.isRemote) {
            int count = this.isBarghestInvisible() ? 5 : 10;
            for (int i = 0; i < count; i++) {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL,
                        this.posX + 1.5 - this.rand.nextDouble() * 3,
                        this.posY + 0.5 + this.rand.nextDouble() * 1.5,
                        this.posZ + 1.5 - this.rand.nextDouble() * 3,
                        0, 0, 0);
            }
        }

        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (entity instanceof EntityPlayer) {
                ((EntityPlayer) entity).addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 200));
            }
            return true;
        } else {
            return false;
        }
    }

    public void setBarghestInvisible(boolean isInvisible) {
        this.isBarghestInvisible = isInvisible;
    }

    public boolean isBarghestInvisible() {
        return this.dataManager.get(INVISIBLE_ID).booleanValue();
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GSSound.ENTITY_BARGHEST_GROWL;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && MobsHelper.isDimensionAllowedForSpawn(this.world);
    }
}
