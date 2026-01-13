package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.BLEEDING_EFFECT;
import static nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility.CALL_OF_THE_ABYSS_EFFECT;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEPotions {

    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(Registries.POTION, ModInfo.ID);

    public static final DeferredHolder<Potion, Potion> BLEEDING_POTION =
            POTIONS.register("bleeding", () -> {
                var effect = BuiltInRegistries.MOB_EFFECT.get(BLEEDING_EFFECT);
                if (!effect.isPresent()) {
                    throw new IllegalStateException("Missing effect: " + BLEEDING_EFFECT);
                }
                return new Potion("bleeding", new MobEffectInstance(effect.get(), 1200, 0));
            });

    public static final DeferredHolder<Potion, Potion> CALL_OF_THE_ABYSS_POTION =
            POTIONS.register("call_of_the_abyss", () -> {
                var effect = BuiltInRegistries.MOB_EFFECT.get(CALL_OF_THE_ABYSS_EFFECT);
                if (!effect.isPresent()) {
                    throw new IllegalStateException("Missing effect: " + CALL_OF_THE_ABYSS_EFFECT);
                }
                return new Potion("call_of_the_abyss", new MobEffectInstance(effect.get(), 500, 0));
            });

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

//    public static final Potion CURSE = new PotionCurse();
//    public static final Potion RUST = new PotionRust();
//    public static final Potion BONE_SKIN = new PotionBoneSkin();
//    public static final Potion RECALL = new PotionRecall();
//    public static final Potion BURNING = new PotionBurning();
//    public static final Potion INFERNO = new PotionInferno();
//
//    public static final PotionType PURIFICATION_TYPE = new PotionTypePurification();
//    public static final PotionType RUST_TYPE = new PotionTypeRust();
//    public static final PotionType BONE_SKIN_TYPE = new PotionTypeBoneSkin();
//    public static final PotionType RECALL_TYPE = new PotionTypeRecall();
//    public static final PotionType BURNING_TYPE = new PotionTypeBurning();
//    public static final PotionType INFERNO_TYPE = new PotionTypeInferno();
//    //vanilla
//    public static final PotionType HUNGER_TYPE = new PotionTypeHunger();
//    public static final PotionType BLINDNESS_TYPE = new PotionTypeBlindness();
//    public static final PotionType NAUSEA_TYPE = new PotionTypeNausea();
//    public static final PotionType RESISTANCE_TYPE = new PotionTypeResistance();
//    public static final PotionType LEVITATION_TYPE = new PotionTypeLevitation();
//    public static final PotionType WITHER_TYPE = new PotionTypeWither();
//
//    @SubscribeEvent
//    public static void registerPotions(final RegistryEvent.Register<Potion> event) {
//        event.getRegistry().registerAll(CURSE, RUST, BONE_SKIN, RECALL, BURNING, INFERNO);
//    }
//
//    @SubscribeEvent
//    public static void registerPotionTypes(final RegistryEvent.Register<PotionType> event) {
//        event.getRegistry().registerAll(RUST_TYPE, BONE_SKIN_TYPE, RECALL_TYPE, BURNING_TYPE, INFERNO_TYPE);
//        event.getRegistry().registerAll(HUNGER_TYPE, BLINDNESS_TYPE, NAUSEA_TYPE, RESISTANCE_TYPE, LEVITATION_TYPE, WITHER_TYPE);
//
//        PotionHelper.addMix(PotionTypes.AWKWARD, GSItem.TOXIC_SLIME, RUST_TYPE);
//
//        PotionHelper.addMix(PotionTypes.WATER_BREATHING, Ingredient.fromStacks(new ItemStack(GSItem.PIECE_OF_DIVING_SUIT, 1)), CHOKE_TYPE);
//
//        // vanilla potions
//        PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(Items.ROTTEN_FLESH, 1)), GSPotion.HUNGER_TYPE);
//
//        if (Compatibility.isModLoaded(Compatibility.ADVANCED_FISHING_ID)) {
//            CompatibilityAdvancedFishing.addPotionsRecipes();
//        }
//    }
}
