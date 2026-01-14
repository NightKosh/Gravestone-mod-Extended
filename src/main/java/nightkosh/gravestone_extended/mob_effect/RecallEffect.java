package nightkosh.gravestone_extended.mob_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.portal.TeleportTransition;
import nightkosh.gravestone_extended.core.GSEConfigs;

import javax.annotation.Nonnull;

import static net.minecraft.world.level.portal.TeleportTransition.DO_NOTHING;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RecallEffect extends InstantenousMobEffect {

    public RecallEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xc7fb);
    }

    @Override
    public boolean applyEffectTick(@Nonnull ServerLevel level, @Nonnull LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide() && entity instanceof Player player) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to teleport player {} back to home by RecallEffect", entity.getScoreboardName());
            }

            var minecraftServer = level.getServer();
            var serverPlayer = minecraftServer.getPlayerList().getPlayer(player.getUUID());
            var respConf = serverPlayer.getRespawnConfig();

            if (respConf != null) {
                var data = respConf.respawnData();
                var dimension = data.dimension();
                var pos = data.pos();

                level.playSound(null,
                        player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS,
                        1, 1);
                if (level.dimension().equals(dimension)) {
                    serverPlayer.connection.teleport(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
                } else {
                    var targetLevel = minecraftServer.getLevel(dimension);
                    if (targetLevel != null) {
                        player.teleport(new TeleportTransition(
                                targetLevel,
                                pos.getBottomCenter(),
                                player.getDeltaMovement(),
                                0,
                                0,
                                DO_NOTHING
                        ));
                    }
                }
                level.playSound(null,
                        player.getX(), player.getY(), player.getZ(),
                        SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS,
                        1, 1);
            }
        }

        return true;
    }

}
