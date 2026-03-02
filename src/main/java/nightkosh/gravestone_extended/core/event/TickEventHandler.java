package nightkosh.gravestone_extended.core.event;

import net.minecraft.server.level.ServerLevel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.TimeHelper;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class TickEventHandler {

    private static short ticCount = 0;

    private static final short fogTicCount = 0;
    public static final short MAX_FOG_TICK_COUNT = 100;

    public static short getFogTicCount() {
        return fogTicCount;
    }

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        if (event.getLevel() instanceof ServerLevel level) {
            ticCount++;

            if (ticCount >= TimeHelper.SECONDS_25) {
                TimeHelper.updateIsGraveSpawnTime(level);
                ticCount = 0;
            }
        }
    }

//TODO
//    @SubscribeEvent
//    @SideOnly(Side.CLIENT)
//    public void playerTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase == TickEvent.Phase.END) {
//            if (event.player.equals(Minecraft.getMinecraft().player)) {
//                fogTicCount++;
//                if (fogTicCount > MAX_FOG_TICK_COUNT) {
//                    fogTicCount = 0;
//                    RenderEventHandler.resetAmountOfFogSources(event.player.getEntityWorld());
//                }
//            }
//        }
//    }
}
