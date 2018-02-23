package nightkosh.gravestone_extended.core;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.dimension.catacombs.WorldProviderCatacombs;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSDimensions {
    public static final int CATACOMBS_DEFAULT_DIMENSION_ID = 1486248640;

    public static final DimensionType CATACOMBS = DimensionType.register("CATACOMBS", "_catacombs", ExtendedConfig.catacombsDimensionId, WorldProviderCatacombs.class, false);

    private static WorldProvider PROVIDER_CATACOMBS;

    public static void registration() {
        DimensionManager.registerDimension(ExtendedConfig.catacombsDimensionId, CATACOMBS);
    }

    public static WorldProvider getCatacombsProvider() {
        if (PROVIDER_CATACOMBS == null) {
            PROVIDER_CATACOMBS = CATACOMBS.createDimension();
        }
        return PROVIDER_CATACOMBS;
    }
}
