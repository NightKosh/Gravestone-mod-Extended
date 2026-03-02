package nightkosh.gravestone_extended.block_entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import nightkosh.gravestone.block_entity.GraveStoneBlockEntity;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.helper.TimeHelper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.*;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveStoneSpawn extends MobSpawner {


    private static final WeightedList<EntityType<?>> HUMAN_GRAVE_MOBS = WeightedList.<EntityType<?>>builder()
            .add(EntityType.ZOMBIE, 10)
            .add(EntityType.SKELETON, 10)
            .build();

    private static final WeightedList<EntityType<?>> DOG_GRAVE_MOBS = WeightedList.<EntityType<?>>builder()
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_DOG).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(), 10)

            .build();

    private static final WeightedList<EntityType<?>> CAT_GRAVE_MOBS = WeightedList.<EntityType<?>>builder()
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_CAT).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(), 10)
            .build();

    private static final WeightedList<EntityType<?>> HORSE_GRAVE_MOBS = WeightedList.<EntityType<?>>builder()
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_HORSE).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(SKELETON_HORSE).get().value(), 10)
            .build();

    private static final WeightedList<EntityType<?>> PETS_GRAVE_MOBS = WeightedList.<EntityType<?>>builder()
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_DOG).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(SKELETON_DOG).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_CAT).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(SKELETON_CAT).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(ZOMBIE_HORSE).get().value(), 10)
            .add(BuiltInRegistries.ENTITY_TYPE.get(SKELETON_HORSE).get().value(), 10)
            .build();

    private final GraveStoneBlockEntity grave;

    private static final int MIN_DELAY = 500;
    public static final int MAX_DELAY = 1000;
    private static final int BASE_DELAY = 600;
    private static final int PLAYER_RANGE = 35;
    private static final int MAX_NEARBY_ENTITIES = 3;

    public GraveStoneSpawn(GraveStoneBlockEntity grave) {
        super(grave, null);
        this.grave = grave;
    }

    @Override
    public void serverTick(@NotNull ServerLevel serverLevel, @NotNull BlockPos pos) {
        if (this.grave == null || !this.grave.isPurified()) {
            //TODO
//            if (spawnerEntity.haveSpawnerHelper()) {
//                if (((EntityGroupOfGravesMobSpawnerHelper) spawnerEntity.getSpawnerHelper()).canMobsBeSpawned()) {
//                    getAndSpawnMob();
//                }
//            } else
            if (GSEConfigs.SPAWN_MOBS_BY_GRAVES.get() &&
                    //TODO
//                    (this.grave.getLevel().dimension().equals(GSDimensions.CATACOMBS) || TimeHelper.isGraveSpawnTime())) {
                    TimeHelper.isGraveSpawnTime()) {
                super.serverTick(serverLevel, pos);
            }
        }
    }

    @Override
    protected EntityType<?> getMobTypeToSpawn(@Nonnull Level level) {
        return getMobTypeToSpawn(this.grave, level);
    }

    public static EntityType<?> getMobTypeToSpawn(@Nonnull GraveStoneBlockEntity grave, @Nonnull Level level) {
        var mobs = switch (grave.getGraveType()) {
            case GRAVE_STONE, GRAVE_PLATE, CROSS, OBELISK, CELTIC_CROSS, VILLAGER_GRAVE_STONE, SWORD ->
                    HUMAN_GRAVE_MOBS;
//            case PET_GRAVE_STONE -> DOG_GRAVE_MOBS;
//            case PET_GRAVE_STONE -> CAT_GRAVE_MOBS;
//            case PET_GRAVE_STONE -> HORSE_GRAVE_MOBS;
            case PET_GRAVE_STONE -> PETS_GRAVE_MOBS;
            default -> HUMAN_GRAVE_MOBS;
        };
        return mobs.getRandom(level.random).get();
    }

    @Override
    protected int getBaseDelay() {
        return BASE_DELAY;
    }

    protected int getMinDelay() {
        return MIN_DELAY;
    }

    @Override
    protected int getMaxDelay() {
        return GSEConfigs.GRAVE_MAX_SPAWN_DELAY.get();
    }

    @Override
    protected int getSpawnRange() {
        return 0;
    }

    @Override
    protected int getPlayerRange() {
        return PLAYER_RANGE;
    }

    protected int getMaxNearbyEntities() {
        return MAX_NEARBY_ENTITIES;
    }


    @Override
    public void clientTick(@Nonnull Level level, @Nonnull BlockPos pos) {

    }

}
