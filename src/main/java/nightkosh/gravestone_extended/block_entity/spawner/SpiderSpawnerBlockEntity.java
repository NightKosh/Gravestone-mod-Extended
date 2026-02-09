package nightkosh.gravestone_extended.block_entity.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.core.GSEBlockEntities;

import java.util.List;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SpiderSpawnerBlockEntity extends ASpawnerBlockEntity {

    private static final List<EntityType> MOBS = List.of(
            EntityType.SPIDER, EntityType.SPIDER, EntityType.SPIDER, EntityType.SPIDER,
            EntityType.CAVE_SPIDER);

    public SpiderSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER_SPIDER.get(), pos, blockState);
    }

    @Override
    protected List<EntityType> getMobs() {
        return MOBS;
    }

}
