package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.block_entity.spawner.*;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES_REGISTER =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ModInfo.ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_SKELETON =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_skeleton_block_entity",
                    () -> new BlockEntityType<>(
                            SkeletonSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_SKELETON.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_STRAY =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_stray_block_entity",
                    () -> new BlockEntityType<>(
                            StraySpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_STRAY.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_BOGGED =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_bogged_block_entity",
                    () -> new BlockEntityType<>(
                            BoggedSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_BOGGED.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_PARCHED =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_parched_block_entity",
                    () -> new BlockEntityType<>(
                            ParchedSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_PARCHED.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_WITHER =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_wither_block_entity",
                    () -> new BlockEntityType<>(
                            WitherSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_WITHER.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_ZOMBIE =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_zombie_block_entity",
                    () -> new BlockEntityType<>(
                            ZombieSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_ZOMBIE.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_HUSK =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_husk_block_entity",
                    () -> new BlockEntityType<>(
                            HuskSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_HUSK.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_DROWNED =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_drowned_block_entity",
                    () -> new BlockEntityType<>(
                            DrownedSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_DROWNED.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ASpawnerBlockEntity>> SPAWNER_PIGLIN =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_piglin_block_entity",
                    () -> new BlockEntityType<>(
                            PiglinSpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_PIGLIN.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarBlockEntity>> ALTAR =
            BLOCK_ENTITIES_REGISTER.register(
                    "altar_block_entity",
                    () -> new BlockEntityType<>(
                            AltarBlockEntity::new,
                            GSEBlocks.ALTAR.get()));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES_REGISTER.register(eventBus);
    }

}
