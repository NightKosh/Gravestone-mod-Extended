package nightkosh.gravestone_extended.mob_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.helper.TeleportationHelper;

import javax.annotation.Nonnull;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveyardRecallEffect extends InstantenousMobEffect {

    public GraveyardRecallEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x796152);
    }

    @Override
    public boolean applyEffectTick(@Nonnull ServerLevel level, @Nonnull LivingEntity entity, int amplifier) {
        if (!level.isClientSide() && entity instanceof Player player) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to teleport player {} back to home by RecallEffect", player.getScoreboardName());
            }
            TeleportationHelper.teleportToGrave(level, player);
        }

        return true;
    }

}
