package nightkosh.gravestone_extended.core.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.crafting.DataComponentIngredient;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.GSEPotions;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.compatibility.AdvancedFishingCompatibility;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;
import static nightkosh.gravestone_extended.core.compatibility.AdvancedFishingCompatibility.*;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEBrewingRecipes {

    @SubscribeEvent
    public static void onCommonSetup(RegisterBrewingRecipesEvent event) {
        if (GSEConfigs.DEBUG_MODE.get()) {
            LOGGER.info("BrewingRecipes event registration triggered");
        }

        event.getBuilder().addRecipe(
                DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                        .getCustomIngredient().toVanilla(),
                Ingredient.of(Items.ROTTEN_FLESH),
                PotionContents.createItemStack(Items.POTION, GSEPotions.HUNGER_POTION));

        if (AdvancedFishingCompatibility.loaded()) {
            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(BLUE_JELLYFISH),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.NAUSEA_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(SPOOKYFIN),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.BLINDNESS_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(CAVE_TROUT),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.RESISTANCE_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(CHORUS_KOI),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.LEVITATION_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(WITHERED_CRUCIAN),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.WITHER_POTION));

            // potions with custom effects
            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(PIRANHA),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.BLEEDING_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(ANGLER_FISH),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.CALL_OF_THE_ABYSS_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(GOLDEN_KOI),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.PURIFICATION_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(SPECULAR_SNAPPER),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.RECALL_POTION));

            event.getBuilder().addRecipe(
                    DataComponentIngredient.of(false, PotionContents.createItemStack(Items.POTION, Potions.AWKWARD))
                            .getCustomIngredient().toVanilla(),
                    Ingredient.of(MAGMA_JELLYFISH),
                    PotionContents.createItemStack(Items.POTION, GSEPotions.FLAMES_POTION));
        }

    }

}
