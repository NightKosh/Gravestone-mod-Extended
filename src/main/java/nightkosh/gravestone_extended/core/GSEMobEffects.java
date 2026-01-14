package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.mob_effect.*;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEMobEffects {

    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, ModInfo.ID);

    public static final DeferredHolder<MobEffect, MobEffect> PURIFICATION =
            EFFECTS.register("purification", PurificationEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> RECALL =
            EFFECTS.register("recall", RecallEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> FLAMES =
            EFFECTS.register("flames", FlamesEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> INFERNO =
            EFFECTS.register("inferno", InfernoEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> RUST =
            EFFECTS.register("rust", RustEffect::new);

    public static final DeferredHolder<MobEffect, MobEffect> BONE_SKIN =
            EFFECTS.register("bone_skin", BoneSkinEffect::new);

    public static void register(IEventBus eventBus) {
        EFFECTS.register(eventBus);
    }

}
