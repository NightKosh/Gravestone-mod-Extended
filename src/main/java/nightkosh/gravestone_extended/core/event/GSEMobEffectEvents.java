package nightkosh.gravestone_extended.core.event;

import net.minecraft.world.effect.MobEffects;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import nightkosh.gravestone_extended.core.GSEMobEffects;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEMobEffectEvents {

    @SubscribeEvent
    public static void onEffectApplicable(MobEffectEvent.Applicable event) {
        var incoming = event.getEffectInstance();
        var entity = event.getEntity();

        if (incoming != null) {
            if (entity.hasEffect(GSEMobEffects.BONE_SKIN)) {
                var effect = incoming.getEffect();

                if (effect.is(MobEffects.WITHER)) {
                    event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
                } else if (WitheredLandsCompatibility.loaded()) {
                    var rustEffect = WitheredLandsCompatibility.getRustEffect();
                    if (rustEffect != null && effect.is(rustEffect)) {
                        event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);
                    }
                }
            }
        }
    }

}
