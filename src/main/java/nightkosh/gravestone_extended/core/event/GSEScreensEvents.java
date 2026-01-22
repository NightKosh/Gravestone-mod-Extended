package nightkosh.gravestone_extended.core.event;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import nightkosh.gravestone_extended.core.GSEMenus;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.gui.DisenchantmentScreen;
import nightkosh.gravestone_extended.gui.EnchantmentScreen;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID, value = Dist.CLIENT)
public class GSEScreensEvents {

    @SubscribeEvent
    public static void clientSetup(RegisterMenuScreensEvent event) {
        event.register(GSEMenus.ALTAR_DISENCHANTMENT.get(), DisenchantmentScreen::new);
        event.register(GSEMenus.ALTAR_ENCHANTMENT.get(), EnchantmentScreen::new);
    }

}
