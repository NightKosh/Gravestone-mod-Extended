package nightkosh.gravestone_extended.entity.monster;
import nightkosh.gravestone_extended.core.GSEntity;
import nightkosh.gravestone_extended.helper.MobsHelper;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityGSSkeleton {//TODO extends EntitySkeleton {

    public enum SkeletonType {
        SKELETON,
        WITHER,
        STRAY
    }

    public SkeletonType skeletonType = SkeletonType.SKELETON;
//
//    public EntityGSSkeleton(World worldIn) {
//        super(worldIn);
//    }
//
//    @Override
//    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingData) {
//        livingData = super.onInitialSpawn(difficulty, livingData);
//
//        if (this.rand.nextBoolean()) {
//            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD, 1, 0));
//        } else {
//            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW, 1, 0));
//        }
//
//        return livingData;
//    }
//
//    @Override
//    public String getName() {
//        if (this.hasCustomName()) {
//            return this.getCustomNameTag();
//        } else {
//            return I18n.translateToLocal("entity." + GSEntity.MINECRAFT_SKELETON_NAME + ".name");
//        }
//    }
//
//    public void setSkeletonType(SkeletonType type) {
//        this.skeletonType = type;
//    }
//
//    public SkeletonType getSkeletonType() {
//        return this.skeletonType;
//    }
//
//    @Override
//    protected boolean canDespawn() {
//        return !this.hasCustomName();
//    }
//
//    @Override
//    public boolean getCanSpawnHere() {
//        return super.getCanSpawnHere() && MobsHelper.isDimensionAllowedForSpawn(this.world);
//    }
}
