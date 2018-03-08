package nightkosh.gravestone_extended.helper;

import net.minecraft.world.World;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSDimensions;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MobsHelper {

    public static boolean isDimensionAllowedForSpawn(World world) {
        return GSDimensions.CATACOMBS.getId() == world.provider.getDimension() || ExtendedConfig.mobsDimensionWhiteList.contains(world.provider.getDimension());
    }
}
