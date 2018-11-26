package nightkosh.gravestone_extended.core;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.gravestone_extended.core.compatibility.Compatibility;
import nightkosh.gravestone_extended.core.compatibility.CompatibilityAdvancedFishing;
import nightkosh.gravestone_extended.potion.*;
import nightkosh.gravestone_extended.potion.potion_type.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@GameRegistry.ObjectHolder(ModInfo.ID)
@Mod.EventBusSubscriber
public class GSPotion {

    public static final Potion CURSE = new PotionCurse();
    public static final Potion PURIFICATION = new PotionPurification();
    public static final Potion RUST = new PotionRust();
    public static final Potion BONE_SKIN = new PotionBoneSkin();
    public static final Potion RECALL = new PotionRecall();
    public static final Potion BURNING = new PotionBurning();
    public static final Potion BLEEDING = new PotionBleeding();
    public static final Potion CHOKE = new PotionChoke();
    public static final Potion INFERNO = new PotionInferno();

    public static final PotionType PURIFICATION_TYPE = new PotionTypePurification();
    public static final PotionType RUST_TYPE = new PotionTypeRust();
    public static final PotionType BONE_SKIN_TYPE = new PotionTypeBoneSkin();
    public static final PotionType RECALL_TYPE = new PotionTypeRecall();
    public static final PotionType BURNING_TYPE = new PotionTypeBurning();
    public static final PotionType BLEEDING_TYPE = new PotionTypeBleeding();
    public static final PotionType INFERNO_TYPE = new PotionTypeInferno();
    public static final PotionType CHOKE_TYPE = new PotionTypeChoke();
    //vanilla
    public static final PotionType HUNGER_TYPE = new PotionTypeHunger();
    public static final PotionType BLINDNESS_TYPE = new PotionTypeBlindness();
    public static final PotionType NAUSEA_TYPE = new PotionTypeNausea();
    public static final PotionType RESISTANCE_TYPE = new PotionTypeResistance();
    public static final PotionType LEVITATION_TYPE = new PotionTypeLevitation();
    public static final PotionType WITHER_TYPE = new PotionTypeWither();

    @SubscribeEvent
    public static void registerPotions(final RegistryEvent.Register<Potion> event) {
        event.getRegistry().registerAll(CURSE, PURIFICATION, RUST, BONE_SKIN, RECALL, BURNING, BLEEDING, CHOKE, INFERNO);
    }

    @SubscribeEvent
    public static void registerPotionTypes(final RegistryEvent.Register<PotionType> event) {
        event.getRegistry().registerAll(PURIFICATION_TYPE, RUST_TYPE, BONE_SKIN_TYPE, RECALL_TYPE, BURNING_TYPE, BLEEDING_TYPE,
                INFERNO_TYPE, CHOKE_TYPE);
        event.getRegistry().registerAll(HUNGER_TYPE, BLINDNESS_TYPE, NAUSEA_TYPE, RESISTANCE_TYPE, LEVITATION_TYPE, WITHER_TYPE);

        PotionHelper.addMix(PotionTypes.AWKWARD, GSItem.TOXIC_SLIME, RUST_TYPE);

        PotionHelper.addMix(PotionTypes.WATER_BREATHING, Ingredient.fromStacks(new ItemStack(GSItem.PIECE_OF_DIVING_SUIT, 1)), CHOKE_TYPE);

        // vanilla potions
        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(Items.ROTTEN_FLESH, 1)), GSPotion.HUNGER_TYPE);

        if (Compatibility.isModLoaded(Compatibility.ADVANCED_FISHING_ID)) {
            CompatibilityAdvancedFishing.addPotionsRecipes();
        }
    }
}
