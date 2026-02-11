package nightkosh.gravestone_extended.core.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GraveGenerationHelper;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEEventsCompatibility {

    @SubscribeEvent
    public static void onFMLLoadCompleteEvent(FMLLoadCompleteEvent event) {
        if (GSEConfigs.DEBUG_MODE.get()) {
            LOGGER.info("FMLLoadCompleteEvent event triggered");
        }

//        CemeteryHelper.addGravePositionHandlers();
//
        GraveGenerationHelper.addMobsItemsHandlers();
//
//        GraveSpawnerHelper.setGraveSpawnerHelper();
//
//        TileEntityGraveStone.fogHandler = new FogHandler();
    }

}
