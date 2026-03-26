package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSESounds {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS_REGISTER =
            DeferredRegister.create(Registries.SOUND_EVENT, ModInfo.ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> BLIGHTWATER_BUBBLING =
            registerSoundEvent("blightwater_bubbling", "blightwater.bubbling");

    public static final DeferredHolder<SoundEvent, SoundEvent> BLIGHTWATER_DROP_OF_ACID =
            registerSoundEvent("blightwater_drop_of_acid", "blightwater.drop_of_acid");

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name, String path) {
        return registerSoundEvent(name, fromNamespaceAndPath(ModInfo.ID, path));
    }

    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name, Identifier identifier) {
        return SOUND_EVENTS_REGISTER.register(name, () -> SoundEvent.createVariableRangeEvent(identifier));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS_REGISTER.register(eventBus);
    }

}
