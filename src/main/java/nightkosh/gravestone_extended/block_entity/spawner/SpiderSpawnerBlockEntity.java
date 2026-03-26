package nightkosh.gravestone_extended.block_entity.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.core.GSEBlockEntities;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SpiderSpawnerBlockEntity extends ASpawnerBlockEntity {

    private static final WeightedList<EntityType<?>> MOBS = WeightedList.<EntityType<?>>builder()
            .add(EntityType.SPIDER, 4)
            .add(EntityType.CAVE_SPIDER, 1)
            .build();

    public SpiderSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER_SPIDER.get(), pos, blockState);
    }

    @Override
    protected WeightedList<EntityType<?>> getMobs() {
        return MOBS;
    }

}
