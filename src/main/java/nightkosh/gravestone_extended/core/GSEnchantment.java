package nightkosh.gravestone_extended.core;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import nightkosh.gravestone_extended.enchantment.*;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentAwkwardCurse;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentBrokenHookCurse;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentFragilityCurse;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentStarvationCurse;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@GameRegistry.ObjectHolder(ModInfo.ID)
public class GSEnchantment {

    public static final Enchantment VAMPIRIC_TOUCH = new EnchantmentVampiricTouch();
    public static final Enchantment POISONED_BLADE = new EnchantmentPoisonedBlade();
    public static final Enchantment WITHERED_BLADE = new EnchantmentWitheredBlade();
    public static final Enchantment SHADOW_OF_DEATH = new EnchantmentShadowOfDeath();
    public static final Enchantment NECROTIC_CORROSION = new EnchantmentNecroticCorrosion();
    public static final Enchantment PAIN_MIRROR = new EnchantmentPainMirror();
    public static final Enchantment BONE_RAIN = new EnchantmentBoneRain();
    public static final Enchantment HELLISH_ANGLING = new EnchantmentHellishAngling();
    public static final Enchantment BLOODY_REPLICATION = new EnchantmentBloodyReplication();

    //armor
    public static final Enchantment FROZEN_NETHER = new EnchantmentFrozenNether();

    // CURSES
    public static final Enchantment CURSE_STARVATION = new EnchantmentStarvationCurse();
    public static final Enchantment CURSE_AWKWARD = new EnchantmentAwkwardCurse();
    public static final Enchantment CURSE_FRAGILITY = new EnchantmentFragilityCurse();
    public static final Enchantment CURSE_BROKEN_HOOK = new EnchantmentBrokenHookCurse();

    @Mod.EventBusSubscriber(modid = ModInfo.ID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Enchantment> event) {
            final IForgeRegistry<Enchantment> registry = event.getRegistry();
            registry.registerAll(VAMPIRIC_TOUCH, POISONED_BLADE, WITHERED_BLADE, SHADOW_OF_DEATH, NECROTIC_CORROSION);
            registry.registerAll(PAIN_MIRROR);
            registry.registerAll(FROZEN_NETHER);
            registry.registerAll(BONE_RAIN, HELLISH_ANGLING, BLOODY_REPLICATION);
            registry.registerAll(CURSE_STARVATION, CURSE_AWKWARD, CURSE_BROKEN_HOOK);
        }
    }
}
