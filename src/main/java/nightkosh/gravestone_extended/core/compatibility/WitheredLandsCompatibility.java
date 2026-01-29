package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class WitheredLandsCompatibility extends ACompatibility {

    public static final String WITHERED_LANDS_ID = "withered_lands";

    public static final String PHANTOM_DIVER_LOOT_TABLE = "withered_lands:entities/phantom_diver";

    // mobs
    public static final Identifier SKELETON_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "skeleton_skull_crawler");
    public static final Identifier STRAY_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "stray_skull_crawler");
    public static final Identifier BOGGED_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "bogged_skull_crawler");
    public static final Identifier PARCHED_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "parched_skull_crawler");
    public static final Identifier WITHER_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "wither_skull_crawler");
    public static final Identifier ZOMBIE_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "zombie_skull_crawler");
    public static final Identifier HUSK_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "husk_skull_crawler");
    public static final Identifier DROWNED_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "drowned_skull_crawler");
    public static final Identifier PIGLIN_CRAWLER = fromNamespaceAndPath(WITHERED_LANDS_ID, "piglin_skull_crawler");

    // effects
    public static final Identifier BLEEDING_EFFECT = fromNamespaceAndPath(WITHERED_LANDS_ID, "bleeding");
    public static final Identifier CALL_OF_THE_ABYSS_EFFECT = fromNamespaceAndPath(WITHERED_LANDS_ID, "call_of_the_abyss");
    public static final Identifier RUST_EFFECT = fromNamespaceAndPath(WITHERED_LANDS_ID, "rust");

    // items
    public static final Item SLIME_GEL = getItem("slime_gel");
    public static final Item BAT_WING = getItem("bat_wing");

    private static Item getItem(String id) {
        var holder = BuiltInRegistries.ITEM.get(fromNamespaceAndPath(WITHERED_LANDS_ID, id));
        return holder.isPresent() ?
                holder.get().value() :
                Items.NETHER_STAR;
    }

    public static Holder.Reference<MobEffect> getRustEffect() {
        var effect = BuiltInRegistries.MOB_EFFECT.get(RUST_EFFECT);
        if (!effect.isPresent()) {
            LOGGER.info("Missing effect: " + RUST_EFFECT);
            return null;
        }
        return effect.get();
    }

    public static boolean loaded() {
        return loaded(WITHERED_LANDS_ID);
    }

}
