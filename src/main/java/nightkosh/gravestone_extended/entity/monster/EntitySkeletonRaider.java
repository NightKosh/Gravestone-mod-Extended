package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.entity.monster.horse.EntitySkeletonHorse;
import nightkosh.gravestone_extended.helper.MobsHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntitySkeletonRaider extends EntityGSSkeleton {

    public EntitySkeletonRaider(World worldIn) {
        super(worldIn);
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        EntitySkeletonHorse horse = new EntitySkeletonHorse(this.getEntityWorld());
        horse.copyLocationAndAnglesFrom(this);
        horse.onInitialSpawn(difficulty, null);

        this.getEntityWorld().spawnEntity(horse);
        this.startRiding(horse);

        data = super.onInitialSpawn(difficulty, data);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW, 1, 0));

        return data;
    }

    @Override
    public boolean shouldDismountInWater(Entity rider) {
        return false;
    }

    @Override
    public void onLivingUpdate() {
//        if (this.isRiding() && this.getAttackTarget() != null && this.ridingEntity instanceof EntityUndeadHorse) {
//            ((EntityLiving) this.ridingEntity).getNavigator().setPath(this.getNavigator().getPath(), 1.5D);
//        }

        super.onLivingUpdate();
    }

    @Override
    protected boolean canDespawn() {
        return !this.hasCustomName();
    }

    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && MobsHelper.isDimensionAllowedForSpawn(this.world);
    }
}
