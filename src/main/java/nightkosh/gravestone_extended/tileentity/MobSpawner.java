package nightkosh.gravestone_extended.tileentity;

import nightkosh.gravestone_extended.block.BlockSpawner;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.core.MobSpawn;
import nightkosh.gravestone_extended.core.logger.GSLogger;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MobSpawner extends Spawner {

    private static final int BASE_DELAY = 60;
    private static final int MIN_DELAY = 600;
    private static final int MAX_DELAY = 800;
    private static final int BOSS_PLAYER_RANGE = 8;
    private static final int MOB_PLAYER_RANGE = 16;
    private static final int SPAWN_EFFECTS_DELAY = 20;
    private static final float MAX_LIGHT_VALUE = 0.46F;
    private EnumSpawner spawnerType = null;
//
//    public MobSpawner(ISpawnerEntity tileEntity) {
//        super(tileEntity, BASE_DELAY);
//    }
//
//    @Override
//    protected void clientUpdateLogic() {
////        delay--;
////        if (delay <= SPAWN_EFFECTS_DELAY) {
////            double x = tileEntity.xCoord + tileEntity.getEntityWorld().rand.nextFloat();
////            double y = tileEntity.yCoord + tileEntity.getEntityWorld().rand.nextFloat();
////            double z = tileEntity.zCoord + tileEntity.getEntityWorld().rand.nextFloat();
////            tileEntity.worldObj.spawnParticle("largesmoke", x, y, z, 0.0D, 0.0D, 0.0D);
////            tileEntity.worldObj.spawnParticle("portal", x, y, z, 0.0D, 0.0D, 0.0D);
////            tileEntity.worldObj.spawnParticle("spell", x, y, z, 0.0D, 0.0D, 0.0D);
////            tileEntity.worldObj.spawnParticle("witchMagic", x, y, z, 0.0D, 0.0D, 0.0D);
////            tileEntity.worldObj.spawnParticle("lava", x, y, z, 0.0D, 0.0D, 0.0D);
////            tileEntity.worldObj.spawnParticle("flame", x, y, z, 0.0D, 0.0D, 0.0D);
////        }
//    }
//
//    @Override
//    protected void serverUpdateLogic() {
//        delay--;
//        if (delay <= 0) {
//            if (canSpawnMobs(spawnerEntity.getIWorld()) && anyPlayerInRange()) {
//                EntityLiving entity = (EntityLiving) getMob();
//                if (entity == null) {
//                    GSLogger.logError("Spanwer mob get 'null' as mob!!!");
//                } else {
//                    double x = spawnerEntity.getIPos().getX() + 0.5;
//                    double y = spawnerEntity.getIPos().getY();
//                    double z = spawnerEntity.getIPos().getZ() + 0.5;
//                    entity.setLocationAndAngles(x, y, z, spawnerEntity.getIWorld().rand.nextFloat() * 360, 0);
//                    if (isBossSpawner()) {
//                        spawnerEntity.getIWorld().removeTileEntity(spawnerEntity.getIPos());
//                        spawnerEntity.getIWorld().setBlockToAir(spawnerEntity.getIPos());
//                        spawnerEntity.getIWorld().spawnEntity(entity);
//                    } else if (spawnerEntity.getIWorld().getLightBrightness(spawnerEntity.getIPos()) <= MAX_LIGHT_VALUE) {
//                        spawnerEntity.getIWorld().spawnEntity(entity);
//                    }
//                }
//            }
//            this.updateDelay();
//        }
//    }
//
//    private boolean isBossSpawner() {
//        return BlockSpawner.BOSS_SPAWNERS.contains(getSpawnerType());
//    }
//
//    private EnumSpawner getSpawnerType() {
//        if (spawnerType == null) {
//            if (spawnerEntity.getIWorld() == null) {
//                GSLogger.logError("Spawner tileentity's world obj is null !!!!!");
//                return EnumSpawner.ZOMBIE_SPAWNER;
//            } else {
//                spawnerType = EnumSpawner.getById((byte) ((TileEntity) spawnerEntity).getBlockMetadata());
//                return spawnerType;
//            }
//        }
//        return spawnerType;
//    }
//
//    @Override
//    protected boolean canSpawnMobs(World world) {
//        return true;
//    }
//
//    @Override
//    protected int getPlayerRange() {
//        return isBossSpawner() ? BOSS_PLAYER_RANGE : MOB_PLAYER_RANGE;
//    }
//
//    @Override
//    protected Entity getMob() {
//        return MobSpawn.getMobEntityForSpawner(this.spawnerEntity.getIWorld(), getSpawnerType(),
//                this.spawnerEntity.getIPos().getX(), this.spawnerEntity.getIPos().getY(), this.spawnerEntity.getIPos().getZ());
//    }
//
//    @Override
//    protected int getSpawnRange() {
//        return 0;
//    }
//
//    @Override
//    protected int getMinDelay() {
//        return MIN_DELAY;
//    }
//
//    @Override
//    protected int getMaxDelay() {
//        return MAX_DELAY;
//    }
}
