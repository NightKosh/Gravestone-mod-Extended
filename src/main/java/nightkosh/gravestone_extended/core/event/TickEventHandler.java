package nightkosh.gravestone_extended.core.event;

import net.minecraft.client.Minecraft;
import nightkosh.gravestone_extended.helper.TimeHelper;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TickEventHandler {

    private static short ticCount = 0;

    private static short fogTicCount = 0;
    public static final short MAX_FOG_TICK_COUNT = 100;

    public static short getFogTicCount() {
        return fogTicCount;
    }
//TODO
//    @SubscribeEvent
//    public void worldTick(TickEvent.WorldTickEvent event) {
//        if (event.phase == TickEvent.Phase.END) {
//            ticCount++;
//
//            if (ticCount >= 500) {
//                TimeHelper.updateIsGraveSpawnTime(event.world);
//                ticCount = 0;
//            }
//        }
//    }
//
//
//
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
