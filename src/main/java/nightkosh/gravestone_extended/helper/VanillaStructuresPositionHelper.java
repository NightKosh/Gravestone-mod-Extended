package nightkosh.gravestone_extended.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import nightkosh.gravestone.helper.AdvancementsHelper;
import nightkosh.gravestone_extended.core.GSEAdvancements;
import nightkosh.gravestone_extended.core.GSEConfigs;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class VanillaStructuresPositionHelper {

    private static final Map<UUID, BlockPos> NETHER_FORTRESS = new HashMap<>();
    private static final Map<UUID, BlockPos> STRONGHOLD = new HashMap<>();

    private static final Map<UUID, ChunkPos> LAST_CHUNK = new HashMap<>();

    public static BlockPos getNetherFortress(Player player) {
        if (isChunkChanged(player)) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to find nearest Nether Bridge to the player {}", player.getScoreboardName());
            }

            if (player instanceof ServerPlayer sp) {
                try {
                    var level = sp.level();
                    if (level.getServer().getWorldGenSettings().options().generateStructures()) {
                        var x = level.registryAccess()
                                .lookupOrThrow(Registries.STRUCTURE)
                                .get(BuiltinStructures.FORTRESS);

                        var pair = level.getChunkSource()
                                .getGenerator()
                                .findNearestMapStructure(level, HolderSet.direct(x.get()),
                                        player.blockPosition(), 100, false);

                        if (pair != null) {
                            var pos = pair.getFirst();
                            if (GSEConfigs.DEBUG_MODE.get()) {
                                LOGGER.info("Nearest Nether Bridge to player {} at {} ",
                                        player.getScoreboardName(), pos.toShortString());
                            }
                            setNetherFortress(
                                    player.getUUID(),
                                    new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
                            AdvancementsHelper.giveAdvancement(player, level, GSEAdvancements.IMP_SKULL);
                        }
                    }
                } catch (Exception e) {
                    if (GSEConfigs.DEBUG_MODE.get()) {
                        LOGGER.info("Got error while looking for Nether Bridge location", e);
                    }
                }
            }
        }
        return NETHER_FORTRESS.getOrDefault(player.getUUID(), null);
    }

    public static BlockPos getStrongHold(Player player) {
        if (isChunkChanged(player)) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to find nearest StrongHold to the player {}", player.getScoreboardName());
            }
            if (player instanceof ServerPlayer sp) {
                var pos = sp.level().findNearestMapStructure(
                        StructureTags.EYE_OF_ENDER_LOCATED,
                        player.blockPosition(),
                        200,
                        false);
                if (pos != null) {
                    if (GSEConfigs.DEBUG_MODE.get()) {
                        LOGGER.info("Nearest Stronghold to player {} at {} ",
                                player.getScoreboardName(), pos.toShortString());
                    }
                    setStronghold(
                            player.getUUID(),
                            new BlockPos(pos.getX(), pos.getY(), pos.getZ()));
                    AdvancementsHelper.giveAdvancement(player, player.level(), GSEAdvancements.ENDER_SKULL);
                }
            }
        }
        return STRONGHOLD.getOrDefault(player.getUUID(), null);
    }

    public static void setNetherFortress(UUID uuid, BlockPos pos) {
        NETHER_FORTRESS.put(uuid, pos);
    }

    public static void setStronghold(UUID uuid, BlockPos pos) {
        STRONGHOLD.put(uuid, pos);
    }

    private static boolean isChunkChanged(Player player) {
        var now = new ChunkPos(player.getBlockX(), player.getBlockZ());
        return !now.equals(LAST_CHUNK.put(player.getUUID(), now));
    }

}
