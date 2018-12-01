package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import nightkosh.advanced_fishing.api.AdvancedFishingAPI;
import nightkosh.advanced_fishing.api.EnumFishType;
import nightkosh.gravestone_extended.core.GSPotion;
import nightkosh.gravestone_extended.entity.projectile.EntityBoneFishHook;
import nightkosh.gravestone_extended.item.tools.ItemBoneFishingPole;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CompatibilityAdvancedFishing {

    public static Item getBoneFishingPole() {
        return new ItemBoneFishingPole();
    }

    public static void addPotionsRecipes() {
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.BONE_FISH.ordinal())), GSPotion.BONE_SKIN_TYPE);
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.GOLDEN_KOI.ordinal())), GSPotion.PURIFICATION_TYPE);
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.MAGMA_JELLYFISH.ordinal())), GSPotion.BURNING_TYPE);
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.PIRANHA.ordinal())), GSPotion.BLEEDING_TYPE);
        PotionHelper.addMix(GSPotion.BURNING_TYPE, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.FLAREFIN_KOI.ordinal())), GSPotion.INFERNO_TYPE);

        BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.AWKWARD),
                new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.SPECULAR_SNAPPER.ordinal()),
                PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), GSPotion.RECALL_TYPE));

        // vanilla potions
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.SPOOKYFIN.ordinal())), GSPotion.BLINDNESS_TYPE);

        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.BLUE_JELLYFISH.ordinal())), GSPotion.NAUSEA_TYPE);
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.CAVE_TROUT.ordinal())), GSPotion.RESISTANCE_TYPE);
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.CHORUS_KOI.ordinal())), GSPotion.LEVITATION_TYPE);
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(AdvancedFishingAPI.FISH_ITEM, 1, EnumFishType.WITHERED_CRUCIAN.ordinal())), GSPotion.WITHER_TYPE);
    }

    public static boolean isBoneHook(Entity entity) {
        return entity instanceof EntityBoneFishHook;
    }
}
