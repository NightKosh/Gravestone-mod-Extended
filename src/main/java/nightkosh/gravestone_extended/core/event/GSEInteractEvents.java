package nightkosh.gravestone_extended.core.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEInteractEvents {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        var level = event.getLevel();
        if (!level.isClientSide()) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("RightClickBlock event triggered by player {}", event.getEntity().getScoreboardName());
            }

            var stack = event.getItemStack();
            if (!stack.nextDamageWillBreak()) {
                GSEEnchantmentHelper.applyBoneRain(level, stack, event);
            }
        }
    }

}
