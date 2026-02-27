package nightkosh.gravestone_extended.block_entity.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.core.GSEBlockEntities;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.*;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DrownedSpawnerBlockEntity extends ASpawnerBlockEntity {

    private static final WeightedList<EntityType<?>> MOBS = WeightedList.<EntityType<?>>builder()
            .add(EntityType.DROWNED, 21)
            .add(BuiltInRegistries.ENTITY_TYPE.get(DROWNED_SAILOR).get().value(), 4)
            .add(BuiltInRegistries.ENTITY_TYPE.get(PHANTOM_DIVER).get().value(), 2)
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_DOG).get().value(), 3)
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_CAT).get().value(), 3)
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_HORSE).get().value(), 2)
            .add(BuiltInRegistries.ENTITY_TYPE.get(DROWNED_CRAWLER).get().value(), 1)
            .build();

    public DrownedSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER_DROWNED.get(), pos, blockState);
    }

    @Override
    protected WeightedList<EntityType<?>> getMobs() {
        return MOBS;
    }

}
