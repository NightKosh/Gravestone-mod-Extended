package nightkosh.gravestone_extended.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.entity.monster.horse.EntityUndeadHorse;
import nightkosh.gravestone_extended.entity.monster.horse.EntityZombieHorse;
import nightkosh.gravestone_extended.helper.MobsHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityZombieRaider extends EntityZombie {

    public EntityZombieRaider(World worldIn) {
        super(worldIn);
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        this.setChild(false);

        EntityUndeadHorse horse = new EntityZombieHorse(this.getEntityWorld());
        ((PathNavigateGround) horse.getNavigator()).setCanSwim(true);
        horse.copyLocationAndAnglesFrom(this);
        horse.onInitialSpawn(difficulty, null);

        this.getEntityWorld().spawnEntity(horse);
        this.startRiding(horse);

        return super.onInitialSpawn(difficulty, data);
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
