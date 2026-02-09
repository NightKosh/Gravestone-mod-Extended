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
public class StraySpawnerBlockEntity extends ASpawnerBlockEntity {

    private static final List<EntityType> MOBS = List.of(
            EntityType.STRAY, EntityType.STRAY, EntityType.STRAY,
            EntityType.STRAY, EntityType.STRAY, EntityType.STRAY,
            EntityType.STRAY, EntityType.STRAY, EntityType.STRAY,
            EntityType.STRAY, EntityType.STRAY, EntityType.STRAY,
            EntityType.STRAY, EntityType.STRAY, EntityType.STRAY,
            EntityType.STRAY, EntityType.STRAY, EntityType.STRAY,
            EntityType.STRAY, EntityType.STRAY, EntityType.STRAY,
            BuiltInRegistries.ENTITY_TYPE.get(SHIELD_SKELETON).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SHIELD_SKELETON).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SHIELD_SKELETON).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SHIELD_SKELETON).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SHIELD_SKELETON).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SHIELD_SKELETON).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_HORSE).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(SKELETON_HORSE).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(STRAY_CRAWLER).get().value());

    public StraySpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER_STRAY.get(), pos, blockState);
    }

    @Override
    protected List<EntityType> getMobs() {
        return MOBS;
    }

}
