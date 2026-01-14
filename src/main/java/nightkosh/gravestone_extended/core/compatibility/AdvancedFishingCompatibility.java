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
    public static final Item PIRANHA = getFish("piranha");
    public static final Item ANGLER_FISH = getFish("angler_fish");
    public static final Item CAVE_TROUT = getFish("cave_trout");
    public static final Item GOLDEN_KOI = getFish("golden_koi");
    public static final Item CHORUS_KOI = getFish("chorus_koi");
    public static final Item WITHERED_CRUCIAN = getFish("withered_crucian");
    public static final Item SPOOKYFIN = getFish("spookyfin");

    private static Item getFish(String id) {
        var holder = BuiltInRegistries.ITEM.get(fromNamespaceAndPath(ADVANCED_FISHING_ID, id));
        return holder.isPresent() ?
                holder.get().value() :
                Items.AIR;
    }

    public static boolean loaded() {
        return loaded(ADVANCED_FISHING_ID);
    }
//    public static Item getBoneFishingPole() {
//        return new ItemBoneFishingPole();
//    }

    public static void addPotionsRecipes() {
        //TODO
//        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.BONE_FISH.ordinal())), GSPotion.BONE_SKIN_TYPE);
//        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.MAGMA_JELLYFISH.ordinal())), GSPotion.BURNING_TYPE);
//        PotionHelper.addMix(GSPotion.BURNING_TYPE, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.FLAREFIN_KOI.ordinal())), GSPotion.INFERNO_TYPE);
//
//        BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.AWKWARD),
//                new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.SPECULAR_SNAPPER.ordinal()),
//                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), GSPotion.RECALL_TYPE));
    }
//TODO
//    public static boolean isBoneHook(Entity entity) {
//        return entity instanceof EntityBoneFishHook;
//    }
}
