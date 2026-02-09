package nightkosh.gravestone_extended.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import nightkosh.gravestone_extended.block_entity.spawner.ASpawnerBlockEntity;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WitherMobSpawner extends MobSpawner {

    protected static final int PLAYER_RANGE = 8;

    public WitherMobSpawner(ASpawnerBlockEntity blockEntity, List<EntityType> mobList) {
        super(blockEntity, mobList);
        this.requiredPlayerRange = PLAYER_RANGE;
    }

    @Override
    protected void doAfterSpawn(@Nonnull ServerLevel level, @Nonnull BlockPos pos) {
        level.destroyBlock(pos, false);
    }

}
