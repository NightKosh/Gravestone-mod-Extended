package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.world.entity.EntityType;
import nightkosh.gravestone_extended.core.GSEConfigs;
import sophisticated_wolves.api.ModInfo;
import sophisticated_wolves.api.SophisticatedWolvesAPI;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SophisticatedWolvesCompatibility extends ACompatibility {

    public static EntityType getEntityType() {
        return SophisticatedWolvesAPI.SOPHISTICATED_WOLF_TYPE;
    }

    public static boolean loaded() {
        return GSEConfigs.SOPHISTICATED_WOLVES_COMPATIBILITY.get() && loaded(ModInfo.ID);
    }

}
