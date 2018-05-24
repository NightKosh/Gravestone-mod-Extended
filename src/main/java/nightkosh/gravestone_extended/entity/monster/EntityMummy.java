package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSSound;
import nightkosh.gravestone_extended.helper.MobsHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityMummy extends EntityMob {

    public EntityMummy(World world) {
        super(world);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8));
        this.tasks.addTask(8, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    @Override
    public void onLivingUpdate() {
        if (this.world.isDaytime() && !this.world.isRemote) {
            float f = this.getBrightness();

            if (f > 0.5 && this.rand.nextFloat() * 30 < (f - 0.4) * 2 && this.world.canSeeSky(new BlockPos(this.posX, this.posY + this.getEyeHeight(), this.posZ))) {
                this.setFire(8);
            }
        }

        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        if (super.attackEntityAsMob(entity)) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 300));
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getEyeHeight() {
        return 1.9F;
    }

    @Override
    protected Item getDropItem() {
        return Items.ROTTEN_FLESH;//PIECE_OF_MUMMY_CLOTH
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GSSound.ENTITY_MUMMY_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.ENTITY_HUSK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HUSK_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block block) {
        this.playSound(GSSound.ENTITY_MUMMY_STEP, 0.15F, 1);
    }

    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && MobsHelper.isDimensionAllowedForSpawn(this.world);
    }
}
