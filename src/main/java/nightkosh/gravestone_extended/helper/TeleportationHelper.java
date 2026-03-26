package nightkosh.gravestone_extended.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
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

    public static void teleportToGrave(@Nonnull ServerLevel level, @Nonnull Player player) {
        var minecraftServer = level.getServer();
        var serverPlayer = minecraftServer.getPlayerList().getPlayer(player.getUUID());

        if (serverPlayer.getLastDeathLocation().isPresent()) {
            var deathLocation = serverPlayer.getLastDeathLocation().get();

            teleport(level, serverPlayer, deathLocation.dimension(), deathLocation.pos());
        }
    }

    public static void teleportToSpawn(@Nonnull ServerLevel level, @Nonnull Player player) {
        var minecraftServer = level.getServer();
        var serverPlayer = minecraftServer.getPlayerList().getPlayer(player.getUUID());
        var respConf = serverPlayer.getRespawnConfig();

        if (respConf != null) {
            var data = respConf.respawnData();
            var dimension = data.dimension();
            var pos = data.pos();
            teleport(level, serverPlayer, dimension, pos);
        }
    }

    public static void teleport(@Nonnull ServerLevel level, @Nonnull ServerPlayer player,
                                ResourceKey<Level> dimension, BlockPos pos) {
        level.playSound(null,
                player.getX(), player.getY(), player.getZ(),
                SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS,
                1, 1);
        if (level.dimension().equals(dimension)) {
            player.connection.teleport(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
        } else {
            var targetLevel = level.getServer().getLevel(dimension);
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
