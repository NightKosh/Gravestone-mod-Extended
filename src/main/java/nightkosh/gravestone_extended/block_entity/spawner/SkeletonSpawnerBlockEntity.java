package nightkosh.gravestone_extended.block_entity.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.core.GSEBlockEntities;

import java.util.List;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.*;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SkeletonSpawnerBlockEntity extends ASpawnerBlockEntity {

    private static final List<EntityType> MOBS = List.of(
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            EntityType.SKELETON, EntityType.SKELETON, EntityType.SKELETON,
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_HORSE).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_HORSE).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CRAWLER).get().value());

    public SkeletonSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER_SKELETON.get(), pos, blockState);
    }

    @Override
    protected List<EntityType> getMobs() {
        return MOBS;
    }

}
