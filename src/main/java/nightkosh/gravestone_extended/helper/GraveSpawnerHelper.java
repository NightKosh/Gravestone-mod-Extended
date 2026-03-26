package nightkosh.gravestone_extended.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import nightkosh.gravestone.block_entity.GraveStoneBlockEntity;
import nightkosh.gravestone_extended.block_entity.GraveStoneSpawn;
import nightkosh.gravestone_extended.core.GSEConfigs;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveSpawnerHelper extends nightkosh.gravestone.helper.GraveSpawnerHelper {

    public static void setGraveSpawnerHelper() {
        GraveStoneBlockEntity.graveSpawnerHelper = new GraveSpawnerHelper();
    }

    public BaseSpawner getSpawner(GraveStoneBlockEntity blockEntity) {
        return new GraveStoneSpawn(blockEntity);
    }

    public void spawnMobAtGraveDestruction(Level level, BlockPos pos) {
        if (GSEConfigs.SPAWN_MOB_AT_GRAVE_DESTRUCTION.get() && level.getRandom().nextInt(10) == 0) {
            if (level.getBlockEntity(pos) instanceof GraveStoneBlockEntity grave) {
                var entityType = GraveStoneSpawn.getMobTypeToSpawn(grave, level);
                var mob = (LivingEntity) entityType.create(level, EntitySpawnReason.EVENT);
                mob.snapTo(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
                level.addFreshEntity(mob);
            }
        }
    }

}
