package nightkosh.gravestone_extended.block_entity.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.block_entity.WitherMobSpawner;
import nightkosh.gravestone_extended.core.GSEBlockEntities;

import java.util.List;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WitherSpawnerBlockEntity extends ASpawnerBlockEntity {

    public WitherSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER_WITHER.get(), pos, blockState);
    }

    @Override
    protected BaseSpawner getMobSpawner() {
        return new WitherMobSpawner(this, getMobs());
    }

    @Override
    protected List<EntityType> getMobs() {
        return List.of(EntityType.WITHER);
    }

}
