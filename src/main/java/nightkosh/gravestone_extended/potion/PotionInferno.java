package nightkosh.gravestone_extended.potion;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PotionInferno extends PotionBase {

//    public PotionInferno() {
//        super(false, 0xd63f16);
//        this.setIconIndex(5, 0);
//        this.setRegistryName(ModInfo.ID, "gs_inferno_potion");
//        this.setPotionName("potion.inferno.title");
//    }
//
//    @Override
//    public void performEffect(EntityLivingBase entity, int amplifier) {
//        if (entity != null) {
//            List<EntityLivingBase> mobsList = entity.world.getEntitiesWithinAABB(EntityLivingBase.class,
//                    new AxisAlignedBB(entity.posX - 3, entity.posY - 3, entity.posZ - 3,
//                            entity.posX + 3, entity.posY + 3, entity.posZ + 3));
//
//            for (EntityLivingBase mob : mobsList) {
//                if (!(mob instanceof EntityTameable && ((EntityTameable) mob).isTamed() || !ExtendedConfig.infernoDealsDamageToPlayers && mob instanceof EntityPlayer)) {
//                    mob.setFire(10);
//                }
//            }
//            entity.world.spawnParticle(EnumParticleTypes.FLAME, entity.posX + 1, entity.posY + 1, entity.posZ, 0, 0, 0);
//            entity.world.spawnParticle(EnumParticleTypes.FLAME, entity.posX - 1, entity.posY + 1, entity.posZ, 0, 0, 0);
//            entity.world.spawnParticle(EnumParticleTypes.FLAME, entity.posX, entity.posY + 1, entity.posZ + 1, 0, 0, 0);
//            entity.world.spawnParticle(EnumParticleTypes.FLAME, entity.posX, entity.posY + 1, entity.posZ - 1, 0, 0, 0);
//        }
//    }
//
//    @Override
//    public boolean isReady(int duration, int amplifier) {
//        int j = 25 >> amplifier;
//        return j <= 0 || duration % j == 0;
//    }
}
