package nightkosh.gravestone_extended.mob_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import nightkosh.gravestone_extended.core.GSEConfigs;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlizzardEffect extends MobEffect {

    public BlizzardEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xA3C1F6);
    }

    @Override
    public boolean applyEffectTick(@Nonnull ServerLevel level, @Nonnull LivingEntity entity, int amplifier) {
        if (!level.isClientSide()) {
            var mobsList = level.getEntitiesOfClass(LivingEntity.class,
                    new AABB(entity.getX() - 3, entity.getY() - 3, entity.getZ() - 3,
                            entity.getX() + 3, entity.getY() + 3, entity.getZ() + 3));

            for (var mob : mobsList) {
                if (!mob.equals(entity) && // ignore self
                        !(mob instanceof TamableAnimal animal && animal.isTame() || // ignore tamed pets
                                (mob instanceof Player && // ignore other players
                                        (!GSEConfigs.BLIZZARD_DEALS_DAMAGE_TO_PLAYERS.get() || !level.isPvpAllowed())))) {
                    mob.setTicksFrozen(entity.getTicksFrozen() + 200);
                }
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 10 == 0;
    }

}
