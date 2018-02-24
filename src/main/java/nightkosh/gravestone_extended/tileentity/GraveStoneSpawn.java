package nightkosh.gravestone_extended.tileentity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import nightkosh.gravestone.block.enums.EnumGraves;
import nightkosh.gravestone.tileentity.ISpawnerEntity;
import nightkosh.gravestone.tileentity.TileEntityGraveStone;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSDimensions;
import nightkosh.gravestone_extended.core.MobSpawn;
import nightkosh.gravestone_extended.helper.TimeHelper;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveStoneSpawn extends Spawner {

    private TileEntityGraveStone tileEntity;
    private static final int BASE_DELAY = 600;
    private static final int PLAYER_RANGE = 35;
    private static final int MIN_DELAY = 500;
    private boolean newMobRequired = true;
    /**
     * Maximum number of entities for limiting mob spawning
     */
    private static final int MAX_NEARBY_ENTITIES = 3;
    /**
     * Range for spawning new entities with gravestone
     */
    private static final int SPAWN_RANGE = 1;

    public GraveStoneSpawn(TileEntityGraveStone tileEntity) {
        super(tileEntity, BASE_DELAY);
        this.tileEntity = tileEntity;
    }

    public GraveStoneSpawn(ISpawnerEntity tileEntity) {
        super(tileEntity, BASE_DELAY);
    }

    @Override
    protected void clientUpdateLogic() {
        //TODO do not used. Do not forget about GSConfig.spawnMobsByGraves
    }

    @Override
    protected void serverUpdateLogic() {
        if (this.tileEntity == null || !this.tileEntity.isPurified()) {
            if (spawnerEntity.haveSpawnerHelper()) {
                if (((EntityGroupOfGravesMobSpawnerHelper) spawnerEntity.getSpawnerHelper()).canMobsBeSpawned()) {
                    getAndSpawnMob();
                }
            } else if (isMobSpawnAllowed()) {
                getAndSpawnMob();

                this.updateDelay();
            }
        }
    }

    public boolean isMobSpawnAllowed() {
        if (ExtendedConfig.spawnMobsByGraves) {
            if (this.delay < 0) {
                this.updateDelay();
            }

            if (this.delay > 0) {
                this.delay--;
            } else if (canSpawnMobs(spawnerEntity.getIWorld()) && anyPlayerInRange()) {
                return true;
            }
        }
        return false;
    }

    private void getAndSpawnMob() {
        if (this.newMobRequired) {
            this.spawnedMob = MobSpawn.getMobEntity(this.spawnerEntity.getIWorld(), EnumGraves.getById(((TileEntityGraveStone) this.spawnerEntity).getGraveType().ordinal()),
                    this.spawnerEntity.getIPos().getX(), this.spawnerEntity.getIPos().getY(), this.spawnerEntity.getIPos().getZ());

            if (this.spawnedMob == null) {
                return;
            }

            this.newMobRequired = false;
        }
        //TODO !!!!
        AxisAlignedBB bb = new AxisAlignedBB(spawnerEntity.getIPos().getX(), spawnerEntity.getIPos().getY(), spawnerEntity.getIPos().getZ(),
                spawnerEntity.getIPos().getX() + 1, spawnerEntity.getIPos().getY() + 1, spawnerEntity.getIPos().getZ() + 1).expand(1.0D, 4.0D, SPAWN_RANGE * 2);
        int nearbyEntitiesCount = spawnerEntity.getIWorld().getEntitiesWithinAABB(this.spawnedMob.getClass(), bb).size();

        if (nearbyEntitiesCount >= MAX_NEARBY_ENTITIES) {
            this.updateDelay();
            return;
        }

        if (MobSpawn.checkChance(this.spawnerEntity.getIWorld().rand) && MobSpawn.spawnMob(this.spawnerEntity.getIWorld(), this.spawnedMob,
                this.spawnerEntity.getIPos().getX(), this.spawnerEntity.getIPos().getY(), this.spawnerEntity.getIPos().getZ(), true)) {
            this.newMobRequired = true;
        }
    }


    /*
     * Check time and weather
     */
    @Override
    protected boolean canSpawnMobs(World world) {
        return world.provider.getDimension() == GSDimensions.CATACOMBS.getId() || TimeHelper.isGraveSpawnTime();
    }

    @Override
    protected int getPlayerRange() {
        return PLAYER_RANGE;
    }

    @Override
    protected int getSpawnRange() {
        return SPAWN_RANGE;
    }

    @Override
    protected int getMinDelay() {
        return MIN_DELAY;
    }

    @Override
    protected int getMaxDelay() {
        return ExtendedConfig.graveSpawnRate;
    }

    @Override
    protected Entity getMob() {
        return MobSpawn.getMobEntity(this.spawnerEntity.getIWorld(), EnumGraves.getById(((TileEntityGraveStone) this.spawnerEntity).getGraveType().ordinal()),
                this.spawnerEntity.getIPos().getX(), this.spawnerEntity.getIPos().getY(), this.spawnerEntity.getIPos().getZ());
    }
}
