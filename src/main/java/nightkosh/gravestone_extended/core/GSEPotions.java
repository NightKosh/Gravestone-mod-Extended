package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.helper.TimeHelper;

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
                    new Potion("hunger", new MobEffectInstance(MobEffects.HUNGER, TimeHelper.SECONDS_60, 0)));

    public static final DeferredHolder<Potion, Potion> NAUSEA_POTION =
            POTIONS.register("nausea", () ->
                    new Potion("nausea", new MobEffectInstance(MobEffects.NAUSEA, TimeHelper.SECONDS_60, 0)));

    public static final DeferredHolder<Potion, Potion> BLINDNESS_POTION =
            POTIONS.register("blindness", () ->
                    new Potion("blindness", new MobEffectInstance(MobEffects.BLINDNESS, TimeHelper.SECONDS_30, 0)));

    public static final DeferredHolder<Potion, Potion> RESISTANCE_POTION =
            POTIONS.register("resistance", () ->
                    new Potion("resistance", new MobEffectInstance(MobEffects.RESISTANCE, TimeHelper.SECONDS_180, 0)));

    public static final DeferredHolder<Potion, Potion> LEVITATION_POTION =
            POTIONS.register("levitation", () ->
                    new Potion("levitation", new MobEffectInstance(MobEffects.LEVITATION, TimeHelper.SECONDS_45, 0)));

    public static final DeferredHolder<Potion, Potion> WITHER_POTION =
            POTIONS.register("wither", () ->
                    new Potion("wither", new MobEffectInstance(MobEffects.WITHER, TimeHelper.SECONDS_30, 0)));

    public static final DeferredHolder<Potion, Potion> BLEEDING_POTION =
            POTIONS.register("bleeding", () -> {
                var effect = BuiltInRegistries.MOB_EFFECT.get(BLEEDING_EFFECT);
                if (!effect.isPresent()) {
                    throw new IllegalStateException("Missing effect: " + BLEEDING_EFFECT);
                }
                return new Potion("bleeding", new MobEffectInstance(effect.get(), TimeHelper.SECONDS_60, 0));
            });

    public static final DeferredHolder<Potion, Potion> CALL_OF_THE_ABYSS_POTION =
            POTIONS.register("call_of_the_abyss", () -> {
                var effect = BuiltInRegistries.MOB_EFFECT.get(CALL_OF_THE_ABYSS_EFFECT);
                if (!effect.isPresent()) {
                    throw new IllegalStateException("Missing effect: " + CALL_OF_THE_ABYSS_EFFECT);
                }
                return new Potion("call_of_the_abyss", new MobEffectInstance(effect.get(), TimeHelper.SECONDS_25, 0));
            });

    public static final DeferredHolder<Potion, Potion> PURIFICATION_POTION =
            POTIONS.register("purification", () ->
                    new Potion("purification", new MobEffectInstance(GSEMobEffects.PURIFICATION, TimeHelper.SECONDS_10, 0)));

    public static final DeferredHolder<Potion, Potion> RECALL_POTION =
            POTIONS.register("recall", () ->
                    new Potion("recall", new MobEffectInstance(GSEMobEffects.RECALL, TimeHelper.SECONDS_10, 0)));

    public static final DeferredHolder<Potion, Potion> FLAMES_POTION =
            POTIONS.register("flames", () ->
                    new Potion("flames", new MobEffectInstance(GSEMobEffects.FLAMES, TimeHelper.SECONDS_30, 0)));

    public static final DeferredHolder<Potion, Potion> INFERNO_POTION =
            POTIONS.register("inferno", () ->
                    new Potion("inferno", new MobEffectInstance(GSEMobEffects.INFERNO, TimeHelper.SECONDS_90, 0)));

    public static final DeferredHolder<Potion, Potion> FROSTBITE_POTION =
            POTIONS.register("frostbite", () ->
                    new Potion("frostbite", new MobEffectInstance(GSEMobEffects.FROSTBITE, TimeHelper.SECONDS_30, 0)));

    public static final DeferredHolder<Potion, Potion> BLIZZARD_POTION =
            POTIONS.register("blizzard", () ->
                    new Potion("blizzard", new MobEffectInstance(GSEMobEffects.BLIZZARD, TimeHelper.SECONDS_90, 0)));

    public static final DeferredHolder<Potion, Potion> RUST_POTION =
            POTIONS.register("rust", () ->
                    new Potion("rust", new MobEffectInstance(GSEMobEffects.RUST, TimeHelper.SECONDS_30, 0)));

    public static final DeferredHolder<Potion, Potion> BONE_SKIN_POTION =
            POTIONS.register("bone_skin", () ->
                    new Potion("bone_skin", new MobEffectInstance(GSEMobEffects.BONE_SKIN, TimeHelper.SECONDS_600, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
