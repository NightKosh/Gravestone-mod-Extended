package nightkosh.gravestone_extended.block_entity;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ProblemReporter;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.SpawnData;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import nightkosh.gravestone_extended.block_entity.spawner.ASpawnerBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.Nullable;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MobSpawner extends BaseSpawner {

    protected static final int BASE_DELAY = 60;
    protected static final int MIN_DELAY = 500;
    protected static final int MAX_DELAY = 800;
    protected static final int PLAYER_RANGE = 16;
    protected static final int MAX_NEARBY_ENTITIES = 10;
    protected static final int SPAWN_EFFECTS_DELAY = 20;

    protected final WeightedList<EntityType<?>> mobList;
    protected final ASpawnerBlockEntity blockEntity;

    public MobSpawner(ASpawnerBlockEntity blockEntity, WeightedList<EntityType<?>> mobList) {
        super();
        this.mobList = mobList;
        this.blockEntity = blockEntity;
        this.spawnDelay = BASE_DELAY;
        this.minSpawnDelay = MIN_DELAY;
        this.maxSpawnDelay = MAX_DELAY;
        this.maxNearbyEntities = MAX_NEARBY_ENTITIES;
        this.requiredPlayerRange = PLAYER_RANGE;
    }

    protected void doBeforeSpawn(@Nonnull ServerLevel level, @Nonnull BlockPos pos, @NotNull Entity entity) {

    }

    protected void doAfterSpawn(@Nonnull ServerLevel level, @Nonnull BlockPos pos) {

    }

    @Override
    public void serverTick(@Nonnull ServerLevel serverLevel, @Nonnull BlockPos pos) {
        // almost the same as parent
        if (this.isNearPlayer(serverLevel, pos) && serverLevel.isSpawnerBlockEnabled()) {
            if (this.spawnDelay == -1) {
                this.delay(serverLevel, pos);
            }

            if (this.spawnDelay > 0) {
                this.spawnDelay--;
            } else {
                // custom
                this.setEntityId(
                        mobList.getRandom(serverLevel.random).get(),
                        serverLevel, serverLevel.random, pos);

                boolean flag = false;
                var random = serverLevel.getRandom();
                var spawndata = this.getOrCreateNextSpawnData(serverLevel, random, pos);

                for (int i = 0; i < this.spawnCount; i++) {
                    try (var collector = new ProblemReporter.ScopedCollector(this::toString, LOGGER)) {
                        var input = TagValueInput.create(collector, serverLevel.registryAccess(), spawndata.getEntityToSpawn());
                        var optional = EntityType.by(input);
                        if (optional.isEmpty()) {
                            this.delay(serverLevel, pos);
                            return;
                        }

                        var vec3 = input.read("Pos", Vec3.CODEC)
                                .orElseGet(() -> new Vec3(
                                        pos.getX() + (random.nextDouble() - random.nextDouble()) * this.spawnRange + 0.5,
                                        pos.getY() + random.nextInt(3) - 1,
                                        pos.getZ() + (random.nextDouble() - random.nextDouble()) * this.spawnRange + 0.5));
                        if (serverLevel.noCollision(optional.get().getSpawnAABB(vec3.x, vec3.y, vec3.z))) {
                            var blockPos = BlockPos.containing(vec3);
                            if (spawndata.getCustomSpawnRules().isPresent()) {
                                if (!optional.get().getCategory().isFriendly() && serverLevel.getDifficulty() == Difficulty.PEACEFUL) {
                                    continue;
                                }

                                var spawnRules = spawndata.getCustomSpawnRules().get();
                                if (!spawnRules.isValidPosition(blockPos, serverLevel)) {
                                    continue;
                                }
                            } else if (!SpawnPlacements.checkSpawnRules(
                                    optional.get(), serverLevel, EntitySpawnReason.SPAWNER,
                                    blockPos, serverLevel.getRandom())) {
                                continue;
                            }

                            var entity = EntityType.loadEntityRecursive(input, serverLevel, EntitySpawnReason.SPAWNER, e -> {
                                e.snapTo(vec3.x, vec3.y, vec3.z, e.getYRot(), e.getXRot());
                                return e;
                            });
                            if (entity == null) {
                                this.delay(serverLevel, pos);
                                return;
                            }

                            int j = serverLevel.getEntities(
                                            EntityTypeTest.forExactClass(entity.getClass()),
                                            new AABB(
                                                    pos.getX(),
                                                    pos.getY(),
                                                    pos.getZ(),
                                                    pos.getX() + 1,
                                                    pos.getY() + 1,
                                                    pos.getZ() + 1)
                                                    .inflate(this.spawnRange),
                                            EntitySelector.NO_SPECTATORS)
                                    .size();
                            if (j >= this.maxNearbyEntities) {
                                this.delay(serverLevel, pos);
                                return;
                            }

                            entity.snapTo(entity.getX(), entity.getY(), entity.getZ(), random.nextFloat() * 360, 0);
                            if (entity instanceof Mob mob) {
                                if (!EventHooks.checkSpawnPositionSpawner(mob, serverLevel, EntitySpawnReason.SPAWNER, spawndata, this)) {
                                    continue;
                                }

                                boolean flag1 = spawndata.getEntityToSpawn().size() == 1 &&
                                        spawndata.getEntityToSpawn().getString("id").isPresent();
                                EventHooks.finalizeMobSpawnSpawner(mob, serverLevel, serverLevel.getCurrentDifficultyAt(entity.blockPosition()), EntitySpawnReason.SPAWNER, null, this, flag1);

                                spawndata.getEquipment().ifPresent(mob::equip);
                            }

                            if (!serverLevel.tryAddFreshEntityWithPassengers(entity)) {
                                this.delay(serverLevel, pos);
                                return;
                            }

                            // custom
                            doBeforeSpawn(serverLevel, pos, entity);

                            serverLevel.levelEvent(2004, pos, 0);
                            serverLevel.gameEvent(entity, GameEvent.ENTITY_PLACE, blockPos);
                            if (entity instanceof Mob) {
                                ((Mob) entity).spawnAnim();
                            }

                            flag = true;

                            // custom
                            doAfterSpawn(serverLevel, pos);
                        }
                    }
                }

                if (flag) {
                    this.delay(serverLevel, pos);
                }
            }
        }
    }

    @Override
    public void broadcastEvent(Level level, @Nonnull BlockPos pos, int eventId) {
        level.blockEvent(pos, Blocks.SPAWNER, eventId, 0);
    }

    @Override
    public void setNextSpawnData(@Nullable Level level, @Nonnull BlockPos pos, @Nonnull SpawnData spawnData) {
        super.setNextSpawnData(level, pos, spawnData);
        if (level != null) {
            var state = level.getBlockState(pos);
            level.sendBlockUpdated(pos, state, state, 260);
        }
    }

    @Override
    public Either<BlockEntity, Entity> getOwner() {
        return Either.left(blockEntity);
    }

    @Override
    public void clientTick(@Nonnull Level level, @Nonnull BlockPos pos) {
//        if (this.spawnDelay > 0) {
//            this.spawnDelay--;
//        }
//        if (spawnDelay <= SPAWN_EFFECTS_DELAY) {
//            double x = pos.getX() + level.getRandom().nextFloat();
//            double y = pos.getY() + level.getRandom().nextFloat();
//            double z = pos.getZ() + level.getRandom().nextFloat();
//            level.addParticle(ParticleTypes.LARGE_SMOKE, x, y, z, 0, 0, 0);
//            level.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
//            level.addParticle(ParticleTypes.PORTAL, x, y, z, 0, 0, 0);
//            level.addParticle(ParticleTypes.WITCH, x, y, z, 0, 0, 0);
//            level.addParticle(ParticleTypes.LAVA, x, y, z, 0, 0, 0);
//        }
    }

    @Override
    public @Nullable Entity getOrCreateDisplayEntity(@Nonnull Level level, @Nonnull BlockPos pos) {
        return null;
    }

}
