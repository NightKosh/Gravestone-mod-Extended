package nightkosh.gravestone_extended.helper;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.portal.TeleportTransition;

import javax.annotation.Nonnull;

import static net.minecraft.world.level.portal.TeleportTransition.DO_NOTHING;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public final class TeleportationHelper {

    public static void teleportToSpawn(@Nonnull ServerLevel level, @Nonnull Player player) {
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

}
