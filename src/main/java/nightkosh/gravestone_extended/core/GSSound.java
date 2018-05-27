package nightkosh.gravestone_extended.core;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@GameRegistry.ObjectHolder(ModInfo.ID)
public class GSSound {

    @GameRegistry.ObjectHolder("blocks.fluid.bubbling")
    public static SoundEvent BUBBLING = createSoundEvent("blocks.fluid.bubbling");

    @GameRegistry.ObjectHolder("blocks.fluid.drop_of_acid")
    public static SoundEvent DROP_OF_ACID = createSoundEvent("blocks.fluid.drop_of_acid");

    // POSSESSED ARMOR
    @GameRegistry.ObjectHolder("entity.possessed_armor.step")
    public static SoundEvent ENTITY_POSSESSED_ARMOR_STEP = createSoundEvent("entity.possessed_armor.step");
    @GameRegistry.ObjectHolder("entity.possessed_armor.hurt")
    public static SoundEvent ENTITY_POSSESSED_ARMOR_HURT = createSoundEvent("entity.possessed_armor.hurt");

    // MUMMY
    @GameRegistry.ObjectHolder("entity.mummy.ambient")
    public static SoundEvent ENTITY_MUMMY_AMBIENT = createSoundEvent("entity.mummy.ambient");
    @GameRegistry.ObjectHolder("entity.mummy.step")
    public static SoundEvent ENTITY_MUMMY_STEP = createSoundEvent("entity.mummy.step");

    // DROWNED
    @GameRegistry.ObjectHolder("entity.drowned.ambient")
    public static SoundEvent ENTITY_DROWNED_AMBIENT = createSoundEvent("entity.drowned.ambient");
    @GameRegistry.ObjectHolder("entity.drowned.bubbles")
    public static SoundEvent ENTITY_DROWNED_BUBBLES = createSoundEvent("entity.drowned.bubbles");
    @GameRegistry.ObjectHolder("entity.drowned.step")
    public static SoundEvent ENTITY_DROWNED_STEP = createSoundEvent("entity.drowned.step");

    // BARGHEST
    @GameRegistry.ObjectHolder("entity.barghest.growl")
    public static SoundEvent ENTITY_BARGHEST_GROWL = createSoundEvent("entity.barghest.growl");

    // SWAMP THING
    @GameRegistry.ObjectHolder("entity.swamp_thing.growl")
    public static SoundEvent ENTITY_SWAMP_THING_GROWL = createSoundEvent("entity.swamp_thing.growl");

    // RAVEN
    @GameRegistry.ObjectHolder("entity.raven.ambient")
    public static SoundEvent ENTITY_RAVEN_AMBIENT = createSoundEvent("entity.raven.ambient");
    @GameRegistry.ObjectHolder("entity.raven.hurt")
    public static SoundEvent ENTITY_RAVEN_HURT = createSoundEvent("entity.raven.hurt");

    private static SoundEvent createSoundEvent(final String soundName) {
        final ResourceLocation soundID = new ResourceLocation(ModInfo.ID, soundName);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {
        @SubscribeEvent
        public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(BUBBLING, DROP_OF_ACID);

            event.getRegistry().registerAll(ENTITY_POSSESSED_ARMOR_STEP, ENTITY_POSSESSED_ARMOR_HURT,
                    ENTITY_MUMMY_AMBIENT, ENTITY_MUMMY_STEP,
                    ENTITY_DROWNED_AMBIENT, ENTITY_DROWNED_BUBBLES, ENTITY_DROWNED_STEP,
                    ENTITY_BARGHEST_GROWL,
                    ENTITY_SWAMP_THING_GROWL);
        }
    }
}
