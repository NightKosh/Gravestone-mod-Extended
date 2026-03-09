package nightkosh.gravestone_extended.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import nightkosh.gravestone.block_entity.GraveStoneBlockEntity;
import nightkosh.gravestone_extended.core.GSEConfigs;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FogHandler {

    private static final int GRAVES_RANGE = 30;
    private static final int GRAVES_RANGE_SQ = GRAVES_RANGE * GRAVES_RANGE;

    public static final int MIN_FOG_DISTANCE = 12;
    public static final int MAX_FOG_DISTANCE = 120;

    private static final float MAX_DENSITY = 1;
    private static final float FOG_DENSITY_CHANGE_SPEED = 0.003F;
    private static final float FOG_DENSITY_PER_GRAVE = 0.05F;

    private static float targetFog = 0;
    private static short fogTicCount = 0;

    public static float currentFog = 0;

    public static void update(Player player) {
        if (GSEConfigs.GRAVES_FOG_ENABLED.get()) {
            fogTicCount++;
            if (fogTicCount % TimeHelper.SECONDS_3 == 0) {
                fogTicCount = 0;
                //TODO world.provider.getDimension() == GSDimensions.CATACOMBS.getId()
                if (player.equals(Minecraft.getInstance().player) && TimeHelper.isFogTime(player.level())) {
                    targetFog = Mth.clamp(
                            countNearbyGraves(player.level(), player.blockPosition()) * FOG_DENSITY_PER_GRAVE,
                            0,
                            MAX_DENSITY
                    );
                }
            }

            if (currentFog < targetFog) {
                currentFog = Math.min(
                        FogHandler.currentFog + FOG_DENSITY_CHANGE_SPEED,
                        targetFog);
            } else if (currentFog > targetFog) {
                currentFog = Math.max(
                        currentFog - FOG_DENSITY_CHANGE_SPEED,
                        targetFog);
            }
        }
    }

    private static int countNearbyGraves(Level level, BlockPos center) {
        int count = 0;

        int minChunkX = SectionPos.blockToSectionCoord(center.getX() - GRAVES_RANGE);
        int maxChunkX = SectionPos.blockToSectionCoord(center.getX() + GRAVES_RANGE);
        int minChunkZ = SectionPos.blockToSectionCoord(center.getZ() - GRAVES_RANGE);
        int maxChunkZ = SectionPos.blockToSectionCoord(center.getZ() + GRAVES_RANGE);

        for (int chunkX = minChunkX; chunkX <= maxChunkX; chunkX++) {
            for (int chunkZ = minChunkZ; chunkZ <= maxChunkZ; chunkZ++) {
                for (var blockEntity : level.getChunk(chunkX, chunkZ).getBlockEntities().values()) {
                    if (blockEntity instanceof GraveStoneBlockEntity grave &&
                            grave.isSpawner() &&
                            grave.getBlockPos().distSqr(center) <= GRAVES_RANGE_SQ) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
