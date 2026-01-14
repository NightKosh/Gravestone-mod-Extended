package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

    public static final DeferredHolder<Potion, Potion> HUNGER_POTION =
            POTIONS.register("hunger", () ->
                    new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, 1200, 0)));

    public static final DeferredHolder<Potion, Potion> NAUSEA_POTION =
            POTIONS.register("nausea", () ->
                    new Potion("nausea", new MobEffectInstance(MobEffects.NAUSEA, 1200, 0)));

    public static final DeferredHolder<Potion, Potion> BLINDNESS_POTION =
            POTIONS.register("blindness", () ->
                    new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, 600, 0)));

    public static final DeferredHolder<Potion, Potion> RESISTANCE_POTION =
            POTIONS.register("resistance", () ->
                    new Potion("resistance", new MobEffectInstance(MobEffects.RESISTANCE, 3600, 0)));

    public static final DeferredHolder<Potion, Potion> LEVITATION_POTION =
            POTIONS.register("levitation", () ->
                    new Potion("levitation", new MobEffectInstance(MobEffects.LEVITATION, 900, 0)));

    public static final DeferredHolder<Potion, Potion> WITHER_POTION =
            POTIONS.register("wither", () ->
                    new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 600, 0)));

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

    public static final DeferredHolder<Potion, Potion> PURIFICATION_POTION =
            POTIONS.register("purification", () ->
                    new Potion("purification", new MobEffectInstance(GSEMobEffects.PURIFICATION, 200, 0)));

    public static final DeferredHolder<Potion, Potion> RECALL_POTION =
            POTIONS.register("recall", () ->
                    new Potion("recall", new MobEffectInstance(GSEMobEffects.RECALL, 200, 0)));

    public static final DeferredHolder<Potion, Potion> FLAMES_POTION =
            POTIONS.register("flames", () ->
                    new Potion("flames", new MobEffectInstance(GSEMobEffects.FLAMES, 600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

//    public static final Potion CURSE = new PotionCurse();
//    public static final Potion RUST = new PotionRust();
//    public static final Potion BONE_SKIN = new PotionBoneSkin();
//    public static final Potion INFERNO = new PotionInferno();
//
//    public static final PotionType PURIFICATION_TYPE = new PotionTypePurification();
//    public static final PotionType RUST_TYPE = new PotionTypeRust();
//    public static final PotionType BONE_SKIN_TYPE = new PotionTypeBoneSkin();
//    public static final PotionType INFERNO_TYPE = new PotionTypeInferno();
//
//    @SubscribeEvent
//    public static void registerPotions(final RegistryEvent.Register<Potion> event) {
//        event.getRegistry().registerAll(CURSE, RUST, BONE_SKIN, BURNING, INFERNO);
//    }
//
//    @SubscribeEvent
//    public static void registerPotionTypes(final RegistryEvent.Register<PotionType> event) {
//        event.getRegistry().registerAll(RUST_TYPE, BONE_SKIN_TYPE, INFERNO_TYPE);
//
//        PotionHelper.addMix(PotionTypes.AWKWARD, GSItem.TOXIC_SLIME, RUST_TYPE);
//
//        if (Compatibility.isModLoaded(Compatibility.ADVANCED_FISHING_ID)) {
//            CompatibilityAdvancedFishing.addPotionsRecipes();
//        }
//    }
}
