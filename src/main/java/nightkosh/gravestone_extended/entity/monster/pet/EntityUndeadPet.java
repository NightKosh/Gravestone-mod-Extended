package nightkosh.gravestone_extended.entity.monster.pet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.entity.monster.horse.EntityZombieHorse;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class EntityUndeadPet extends EntityMob {

    protected static final DataParameter<Byte> MOB_TYPE = EntityDataManager.createKey(EntityUndeadPet.class, DataSerializers.BYTE);
    protected EnumUndeadMobType mobType;

    public EntityUndeadPet(World world) {
        super(world);
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(MOB_TYPE, (byte) this.getMobType().ordinal());
    }

    /**
     * Returns the texture's file path as a String.
     */
    @SideOnly(Side.CLIENT)
    public abstract ResourceLocation getTexture();

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    @Override
    protected boolean canDespawn() {
        return !this.hasCustomName();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (this.getMobType() == EnumUndeadMobType.WITHER && entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WITHER, 100));
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as
     * required. For example, zombies and skeletons use this to react to
     * sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        if (this.getEntityWorld().isDaytime() && !this.getEntityWorld().isRemote && !this.mobType.sunLightProtected()) {
            float f = this.getBrightness();

            if (f > 0.5F && this.rand.nextFloat() * 30 < (f - 0.4F) * 2 && this.getEntityWorld().canBlockSeeSky(
                    new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY), MathHelper.floor(this.posZ)))) {
                this.setFire(8);
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }

    public EnumUndeadMobType getMobType() {
        return mobType == null ? EnumUndeadMobType.OTHER : mobType;
    }

    public void setMobType(EnumUndeadMobType mobType) {
        this.mobType = mobType;
        this.isImmuneToFire = this.mobType.fireProtected();

        this.dataManager.set(MOB_TYPE, (byte) this.mobType.ordinal());
    }


    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.setMobType(EnumUndeadMobType.getById(nbt.getByte("Type")));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        nbt.setByte("Type", (byte) this.mobType.ordinal());
    }

    /**
     * This method gets called when the entity kills another one.
     */
    @Override
    public void onKillEntity(EntityLivingBase entityLiving) {
        super.onKillEntity(entityLiving);

        if (this.mobType == EnumUndeadMobType.ZOMBIE &&
                this.getEntityWorld().getDifficulty() == EnumDifficulty.NORMAL || this.getEntityWorld().getDifficulty() == EnumDifficulty.HARD) {
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
}
