package nightkosh.gravestone_extended.entity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.passive.EntityShoulderRiding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import nightkosh.gravestone_extended.core.GSLootTables;
import nightkosh.gravestone_extended.core.GSSound;

import javax.annotation.Nullable;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityRaven extends EntityShoulderRiding implements EntityFlying {

    public EntityRaven(World worldIn) {
        super(worldIn);
        this.setSize(0.5F, 0.9F);

        this.moveHelper = new EntityFlyHelper(this);
//        ((PathNavigateGround) this.getNavigator()).setCanSwim(true);
//        this.moveHelper = new EntityRavenMoveHelper(this);//TODO !!!
    }

    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);

        this.tasks.addTask(0, new EntityAISwimming(this));

        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 20));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityPlayer.class, 6, 1, 1.2));
//        this.tasks.addTask(1, new EntityAIAvoidEntityNotTamed(this, EntityPlayer.class, 6, 1, 1.2));
        this.tasks.addTask(2, this.aiSit);
//        this.tasks.addTask(2, new EntityAITempt(this, 0.9, Items.ROTTEN_FLESH, true));//TODO !!!

        this.tasks.addTask(2, new EntityAIFollowOwnerFlying(this, 1, 5, 1));
        this.tasks.addTask(2, new EntityAIWanderAvoidWaterFlying(this, 1));
//        this.tasks.addTask(3, new EntityAILandOnOwnersShoulder(this));//TODO !!!
        this.tasks.addTask(3, new EntityAIFollow(this, 1, 3, 7));
        this.tasks.addTask(5, new EntityAIWander(this, 1));
        this.tasks.addTask(7, new EntityAILookIdle(this));

//        this.tasks.addTask(8, new AIRavenFly(this));//TODO !!!

        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[]{EntityRaven.class}));
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        PathNavigateFlying path = new PathNavigateFlying(this, worldIn);
        path.setCanOpenDoors(false);
        path.setCanFloat(true);
        path.setCanEnterDoors(true);

        return path;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.6);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.5);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (!this.isTamed() && Items.ROTTEN_FLESH == stack.getItem()) {
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }

            if (!this.isSilent()) {
                this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PARROT_EAT, this.getSoundCategory(), 1, 1 + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(10) == 0 && !ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }

            return true;
        } else {
            if (!this.world.isRemote && !this.isFlying() && this.isTamed() && this.isOwner(player)) {
                this.aiSit.setSitting(!this.isSitting());
            }

            return super.processInteract(player, hand);
        }
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    protected float getSoundPitch() {
        return super.getSoundPitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return GSSound.ENTITY_RAVEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return GSSound.ENTITY_RAVEN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PARROT_DEATH;
    }

    @Override
    protected float playFlySound(float p_191954_1_) {
        this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.15F, 1);
        return p_191954_1_;
    }

    @Override
    protected boolean makeFlySound() {
        return isFlying();
    }

    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    public boolean getCanSpawnHere() {
        return new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ).getY() > 60 && super.getCanSpawnHere();
    }

    @Override
    public float getEyeHeight() {
        return this.height / 2F;
    }

    public boolean isFlying() {
        return !this.onGround;
    }

    @Nullable
    protected ResourceLocation getLootTable() {
        return GSLootTables.RAVEN;
    }
}
