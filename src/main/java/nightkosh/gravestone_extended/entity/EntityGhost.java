package nightkosh.gravestone_extended.entity;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityGhost {//TODO extends EntityFlying implements IMob {
//
//    public EntityGhost(World world) {
//        super(world);
//    }
//
//    /**
//     * Returns the texture's file path as a String.
//     */
//    /*@SideOnly(Side.CLIENT)
//    public ResourceLocation getTexture() {
//        return texture;
//    }*/
//
//    /**
//     * Determines if an entity can be despawned, used on idle far away entities
//     */
//    @Override
//    protected boolean canDespawn() {
//        return true;
//    }
//
//    @Override
//    public boolean attackEntityAsMob(Entity entity) {
//        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3);
//    }
//
//    /**
//     * Drop 0-2 items of this living's type.
//     *
//     * @param par1 - Whether this entity has recently been hit by a player.
//     * @param par2 - Level of Looting used to kill this mob.
//     */
//    @Override
//    protected void dropFewItems(boolean par1, int par2) {
//    }
//
//    /**
//     * Called frequently so the entity can update its state every tick as
//     * required. For example, zombies and skeletons use this to react to
//     * sunlight and start to burn.
//     */
//    @Override
//    public void onLivingUpdate() {
//        if (this.getEntityWorld().isDaytime() && !this.getEntityWorld().isRemote) {
//            float f = this.getBrightness();
//
//            if (f > 0.5F && this.rand.nextFloat() * 30 < (f - 0.4F) * 2 &&
//                    this.getEntityWorld().canBlockSeeSky(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY), MathHelper.floor(this.posZ)))) {
//                this.setFire(8);
//            }
//        }
//
//        super.onLivingUpdate();
//    }
//
//    /**
//     * Get this Entity's EnumCreatureAttribute
//     */
//    @Override
//    public EnumCreatureAttribute getCreatureAttribute() {
//        return EnumCreatureAttribute.UNDEAD;
//    }
//
//    /**
//     * Get random potion id
//     */
////    protected int getPotionId(Random random) {
////        switch (random.nextInt(3)) {
////            case 1:
////                return MobEffects.weakness.getId();
////            case 2:
////                return MobEffects.hunger.getId();
////            case 0:
////            default:
////                return MobEffects.moveSlowdown.getId();
////        }
////    }
}