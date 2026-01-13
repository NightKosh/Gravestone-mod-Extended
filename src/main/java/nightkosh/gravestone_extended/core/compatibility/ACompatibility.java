package nightkosh.gravestone_extended.core.compatibility;

import net.neoforged.fml.ModList;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class ACompatibility {

    protected static boolean loaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

}
