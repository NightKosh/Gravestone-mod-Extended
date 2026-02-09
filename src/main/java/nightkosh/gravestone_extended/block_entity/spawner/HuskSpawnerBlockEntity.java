package nightkosh.gravestone_extended.block_entity.spawner;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockState;
import nightkosh.gravestone_extended.core.GSEBlockEntities;

import java.util.List;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.*;
import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.ZOMBIE_HORSE;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class HuskSpawnerBlockEntity extends ASpawnerBlockEntity {

    private static final List<EntityType> MOBS = List.of(
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            EntityType.HUSK, EntityType.HUSK, EntityType.HUSK,
            BuiltInRegistries.ENTITY_TYPE.get(MUMMY).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(MUMMY).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(MUMMY).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_DOG).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_CAT).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_HORSE).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_HORSE).get().value(),
            BuiltInRegistries.ENTITY_TYPE.get(HUSK_CRAWLER).get().value());

    public HuskSpawnerBlockEntity(BlockPos pos, BlockState blockState) {
        super(GSEBlockEntities.SPAWNER_HUSK.get(), pos, blockState);
    }

    @Override
    protected List<EntityType> getMobs() {
        return MOBS;
    }

}
