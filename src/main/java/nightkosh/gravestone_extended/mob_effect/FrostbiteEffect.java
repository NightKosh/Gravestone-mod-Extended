package nightkosh.gravestone_extended.mob_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FrostbiteEffect extends InstantenousMobEffect {

    public FrostbiteEffect() {
        super(MobEffectCategory.HARMFUL, 0x77BBD9);
    }

    @Override
    public boolean applyEffectTick(@Nonnull ServerLevel level, @Nonnull LivingEntity entity, int amplifier) {
        if (!level.isClientSide()) {
            entity.setTicksFrozen(entity.getTicksFrozen() + 1200);
        }

        return true;
    }

}
