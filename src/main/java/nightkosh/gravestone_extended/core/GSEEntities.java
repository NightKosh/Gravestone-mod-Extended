package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.entity.projectile.BoneFishHook;
import nightkosh.gravestone_extended.entity.projectile.WitheredFishHook;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES_REGISTER =
            DeferredRegister.create(Registries.ENTITY_TYPE, ModInfo.ID);

    public static final String BONE_FISH_HOOK_ID = "bone_fish_hook";
    public static final Identifier BONE_FISH_HOOK_NAME = fromNamespaceAndPath(ModInfo.ID, BONE_FISH_HOOK_ID);

    public static final String WITHERED_FISH_HOOK_ID = "withered_fish_hook";
    public static final Identifier WITHERED_FISH_HOOK_NAME = fromNamespaceAndPath(ModInfo.ID, WITHERED_FISH_HOOK_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<BoneFishHook>> BONE_FISH_HOOK =
            ENTITY_TYPES_REGISTER.register(BONE_FISH_HOOK_ID,
                    () -> EntityType.Builder.<BoneFishHook>of(BoneFishHook::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(5)
                            .noLootTable()
                            .noSummon()
                            .noSave()
                            .build(ResourceKey.create(Registries.ENTITY_TYPE, BONE_FISH_HOOK_NAME)));

    public static final DeferredHolder<EntityType<?>, EntityType<? extends WitheredFishHook>> WITHERED_FISH_HOOK =
            ENTITY_TYPES_REGISTER.register(WITHERED_FISH_HOOK_ID,
                    () -> EntityType.Builder.<WitheredFishHook>of(WitheredFishHook::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F)
                            .clientTrackingRange(4)
                            .updateInterval(5)
                            .noLootTable()
                            .fireImmune()
                            .noSummon()
                            .noSave()
                            .build(ResourceKey.create(Registries.ENTITY_TYPE, WITHERED_FISH_HOOK_NAME)));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES_REGISTER.register(eventBus);
    }

//    public static final String SPAWNER_HELPER_NAME = "GSSpawnerHelper";//
//    public static final ResourceLocation SPAWNER_HELPER_ID = new ResourceLocation(ModInfo.ID + ":spawner_helper");//
//    public static void registration() {
//        registerModEntity(SPAWNER_HELPER_ID, EntityGroupOfGravesMobSpawnerHelper.class, SPAWNER_HELPER_NAME);
//    }
}
