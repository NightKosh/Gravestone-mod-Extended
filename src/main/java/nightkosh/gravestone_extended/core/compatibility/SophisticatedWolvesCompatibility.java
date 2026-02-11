package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.resources.Identifier;
import nightkosh.gravestone_extended.core.GSEConfigs;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SophisticatedWolvesCompatibility extends ACompatibility {

    public static final String SOPHISTICATED_WOLVES_ID = "sophisticated_wolves";

    public static final Identifier SOPHISTICATED_WOLF = fromNamespaceAndPath(SOPHISTICATED_WOLVES_ID, "sophisticated_wolf");

    public static boolean loaded() {
        return GSEConfigs.SOPHISTICATED_WOLVES_COMPATIBILITY.get() && loaded(SOPHISTICATED_WOLVES_ID);
    }

}
