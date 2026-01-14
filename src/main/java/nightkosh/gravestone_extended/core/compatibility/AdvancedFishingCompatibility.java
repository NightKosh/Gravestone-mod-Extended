package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AdvancedFishingCompatibility extends ACompatibility {

    public static final String ADVANCED_FISHING_ID = "advanced_fishing";

    public static final Item BLUE_JELLYFISH = getFish("blue_jellyfish");
    public static final Item MAGMA_JELLYFISH = getFish("magma_jellyfish");
    public static final Item PIRANHA = getFish("piranha");
    public static final Item ANGLER_FISH = getFish("angler_fish");
    public static final Item CAVE_TROUT = getFish("cave_trout");
    public static final Item GOLDEN_KOI = getFish("golden_koi");
    public static final Item FLAREFIN_KOI = getFish("flarefin_koi");
    public static final Item CHORUS_KOI = getFish("chorus_koi");
    public static final Item WITHERED_CRUCIAN = getFish("withered_crucian");
    public static final Item BONE_FISH = getFish("bone_fish");
    public static final Item SPOOKYFIN = getFish("spookyfin");
    public static final Item SPECULAR_SNAPPER = getFish("specular_snapper");
    public static final Item SNOWY_WALLEYE = getFish("snowy_walleye");
    public static final Item GLACIER_ANCHOVY = getFish("glacier_anchovy");

    private static Item getFish(String id) {
        var holder = BuiltInRegistries.ITEM.get(fromNamespaceAndPath(ADVANCED_FISHING_ID, id));
        return holder.isPresent() ?
                holder.get().value() :
                Items.NETHER_STAR;
    }

    public static boolean loaded() {
        return loaded(ADVANCED_FISHING_ID);
    }

//TODO
//    public static Item getBoneFishingPole() {
//        return new ItemBoneFishingPole();
//    }
//    public static boolean isBoneHook(Entity entity) {
//        return entity instanceof EntityBoneFishHook;
//    }
}
