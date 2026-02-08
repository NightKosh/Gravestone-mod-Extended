package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.block_entity.GSESpawnerBlockEntity;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES_REGISTER =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ModInfo.ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GSESpawnerBlockEntity>> SPAWNER =
            BLOCK_ENTITIES_REGISTER.register(
                    "spawner_block_entity",
                    () -> new BlockEntityType<>(
                            GSESpawnerBlockEntity::new,
                            GSEBlocks.SPAWNER_SKELETON.get()
                    ));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AltarBlockEntity>> ALTAR =
            BLOCK_ENTITIES_REGISTER.register(
                    "altar_block_entity",
                    () -> new BlockEntityType<>(
                            AltarBlockEntity::new,
                            GSEBlocks.ALTAR.get()
                    ));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES_REGISTER.register(eventBus);
    }

}
