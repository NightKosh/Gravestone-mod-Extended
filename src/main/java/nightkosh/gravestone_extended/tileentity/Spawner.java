package nightkosh.gravestone_extended.tileentity;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class Spawner {//TODOimplements ISpawner {
//
//    protected ISpawnerEntity spawnerEntity;
//    protected int delay;
//    protected Entity spawnedMob;
//    protected AxisAlignedBB bb;
//
//    public Spawner(ISpawnerEntity tileEntity, int delay) {
//        this.spawnerEntity = tileEntity;
//        this.delay = delay;
//        this.bb = new AxisAlignedBB(spawnerEntity.getIPos().getX(), spawnerEntity.getIPos().getY(), spawnerEntity.getIPos().getZ(),
//                spawnerEntity.getIPos().getX() + 1, spawnerEntity.getIPos().getY() + 1, spawnerEntity.getIPos().getZ() + 1).expand(1, 4, getSpawnRange() * 2);
//    }
//
//    /**
//     * Update entity state.
//     */
//    public void update() {
//        if (!spawnerEntity.getIWorld().getDifficulty().equals(EnumDifficulty.PEACEFUL)) {
//            if (spawnerEntity.getIWorld().isRemote) {
////                clientUpdateLogic(); TODO
//            } else {
//                serverUpdateLogic();
//            }
//        }
//    }
//
//    /**
//     * Sets the delay before a new spawn.
//     */
//    public void updateDelay() {
//        delay = getMinDelay() + spawnerEntity.getIWorld().rand.nextInt(getMaxDelay() - getMinDelay());
//    }
//
//    public void setMinDelay() {
//        delay = getMinDelay();
//    }
//
//    protected int getNearbyMobsCount() {
//        return spawnerEntity.getIWorld().getEntitiesWithinAABB(this.spawnedMob.getClass(), bb).size();
//    }
//
//    protected boolean anyPlayerInRange() {
//        return spawnerEntity.getIWorld().getClosestPlayer(spawnerEntity.getIPos().getX() + 0.5D, spawnerEntity.getIPos().getY() + 0.5D, spawnerEntity.getIPos().getZ() + 0.5D, getPlayerRange(), false) != null;
//    }
//
//    abstract protected boolean canSpawnMobs(World world);
//
//    abstract protected int getPlayerRange();
//
//    abstract protected int getSpawnRange();
//
//    abstract protected int getMinDelay();
//
//    abstract protected int getMaxDelay();
//
//    abstract protected Entity getMob();
//
//    abstract protected void clientUpdateLogic();
//
//    abstract protected void serverUpdateLogic();
}
