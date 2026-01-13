package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.resources.Identifier;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WitheredLandsCompatibility extends ACompatibility {

    public static final String WITHERED_LANDS_ID = "withered_lands";

    public static final Identifier SKELETON_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "skeleton_skull_crawler");
    public static final Identifier STRAY_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "stray_skull_crawler");
    public static final Identifier BOGGED_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "bogged_skull_crawler");
    public static final Identifier PARCHED_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "parched_skull_crawler");
    public static final Identifier WITHER_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "wither_skull_crawler");
    public static final Identifier ZOMBIE_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "zombie_skull_crawler");
    public static final Identifier HUSK_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "husk_skull_crawler");
    public static final Identifier DROWNED_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "drowned_skull_crawler");
    public static final Identifier PIGLIN_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "piglin_skull_crawler");

    public static boolean loaded() {
        return loaded(WITHERED_LANDS_ID);
    }

}
