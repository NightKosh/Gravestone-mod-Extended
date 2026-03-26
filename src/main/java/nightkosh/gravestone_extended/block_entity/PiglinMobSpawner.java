package nightkosh.gravestone_extended.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import nightkosh.gravestone_extended.block_entity.spawner.ASpawnerBlockEntity;
import nightkosh.gravestone_extended.helper.TimeHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PiglinMobSpawner extends MobSpawner {

    private static final int ANGER_TIME = TimeHelper.MINUTES_10;

    protected static final int PLAYER_RANGE = 8;

    public PiglinMobSpawner(ASpawnerBlockEntity blockEntity, WeightedList<EntityType<?>> mobList) {
        super(blockEntity, mobList);
        this.requiredPlayerRange = PLAYER_RANGE;
    }

    @Override
    protected void doBeforeSpawn(@NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull Entity entity) {
        if (entity instanceof ZombifiedPiglin piglin) {
            var box = piglin.getBoundingBox().inflate(16);

            var player = level.getEntitiesOfClass(Player.class, box, p -> p.isAlive())
                    .stream()
                    .min(Comparator.comparingDouble(p -> p.distanceToSqr(piglin)))
                    .orElse(null);
            if (player != null) {
                piglin.setTarget(player);
            }
            piglin.setPersistentAngerEndTime(ANGER_TIME);
        }
    }

}
