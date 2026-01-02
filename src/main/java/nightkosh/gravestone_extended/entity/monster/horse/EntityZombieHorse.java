package nightkosh.gravestone_extended.entity.monster.horse;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSEntity;
import nightkosh.gravestone_extended.entity.ai.EntityAINearestAttackableHorse;
import nightkosh.gravestone_extended.entity.ai.EntityUndeadHorseAINearestAttackableTarget;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityZombieHorse extends EntityUndeadHorse {
    public EntityZombieHorse(World worldIn) {
        super(worldIn);

        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1));
        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1, true));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1, false));

        this.targetTasks.addTask(2, new EntityUndeadHorseAINearestAttackableTarget(this, EntityVillager.class, false));
        if (ExtendedConfig.zombiePetsAttackPets) {
            this.targetTasks.addTask(2, new EntityUndeadHorseAINearestAttackableTarget(this, EntityWolf.class, false));
            this.targetTasks.addTask(2, new EntityUndeadHorseAINearestAttackableTarget(this, EntityOcelot.class, false));
        }
        this.targetTasks.addTask(4, new EntityAINearestAttackableHorse(this, false));
    }

    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundEvents.ENTITY_ZOMBIE_HORSE_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.ENTITY_ZOMBIE_HORSE_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        super.getHurtSound(damageSource);
        return SoundEvents.ENTITY_ZOMBIE_HORSE_HURT;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ZOMBIE_HORSE;
    }

    @Override
    public void onKillEntity(EntityLivingBase entityLiving) {
        super.onKillEntity(entityLiving);

        if (this.getEntityWorld().getDifficulty() == EnumDifficulty.NORMAL || this.getEntityWorld().getDifficulty() == EnumDifficulty.HARD) {
            spawnZombieMob(entityLiving);
        }
    }

    protected void spawnZombieMob(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof EntityLiving) {
            EntityLiving entity = (EntityLiving) entityLivingBase;
            EntityLiving zombie = null;
            if (entity instanceof EntityVillager) {
                EntityVillager villager = (EntityVillager) entityLivingBase;
                EntityZombieVillager entityZombie = new EntityZombieVillager(this.getEntityWorld());
                entityZombie.copyLocationAndAnglesFrom(entity);
                this.getEntityWorld().removeEntity(entity);
                entityZombie.onInitialSpawn(this.getEntityWorld().getDifficultyForLocation(new BlockPos(this)), null);

                entityZombie.setProfession(villager.getProfession());
                entityZombie.setChild(entityLivingBase.isChild());
                entityZombie.setNoAI(villager.isAIDisabled());

                if (villager.hasCustomName()) {
                    entityZombie.setCustomNameTag(villager.getCustomNameTag());
                    entityZombie.setAlwaysRenderNameTag(villager.getAlwaysRenderNameTag());
                }

                this.getEntityWorld().spawnEntity(entityZombie);
                this.getEntityWorld().playEvent(null, 1026, new BlockPos(this), 0);
                zombie = entityZombie;
            } else if (entity instanceof EntityWolf) {
                EntityZombieDog zombieDog = new EntityZombieDog(this.getEntityWorld(), false);
                zombieDog.copyLocationAndAnglesFrom(entity);

                this.getEntityWorld().removeEntity(entity);
                this.getEntityWorld().spawnEntity(zombieDog);
                this.getEntityWorld().playEvent(null, 1026, new BlockPos(this), 0);

                zombie = zombieDog;
            } else if (entity instanceof EntityOcelot) {
                EntityZombieCat zombieCat = new EntityZombieCat(this.getEntityWorld(), false);
                zombieCat.copyLocationAndAnglesFrom(entity);
                if (((EntityOcelot) entity).isTamed()) {
                    zombieCat.setSkin(((EntityOcelot) entity).getTameSkin());
                } else {
                    zombieCat.setSkin(0);
                }
                this.getEntityWorld().removeEntity(entity);

                zombieCat.onInitialSpawn(this.getEntityWorld().getDifficultyForLocation(new BlockPos(this)), null);
                this.getEntityWorld().spawnEntity(zombieCat);
                this.getEntityWorld().playEvent(null, 1026, new BlockPos(this), 0);

                zombie = zombieCat;
            } else if (entity instanceof EntityHorse) {
                EntityZombieHorse zombieHorse = new EntityZombieHorse(this.getEntityWorld());
                zombieHorse.copyLocationAndAnglesFrom(entity);
                zombieHorse.setGrowingAge(((EntityHorse) entity).getGrowingAge());

                this.getEntityWorld().removeEntity(entity);
                this.getEntityWorld().spawnEntity(zombieHorse);
                this.getEntityWorld().playEvent(null, 1026, new BlockPos(this), 0);

                zombie = zombieHorse;
            }
            if (zombie != null && entity.hasCustomName()) {
                zombie.setCustomNameTag(entity.getCustomNameTag());
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5);
    }

    @Override
    protected String getUndeadHorseTexture() {
        return "textures/entity/horse/horse_zombie.png";
    }

    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        } else {
            return I18n.translateToLocal("entity." + GSEntity.MINECRAFT_ZOMBIE_HORSE_NAME + ".name");
        }
    }
}
