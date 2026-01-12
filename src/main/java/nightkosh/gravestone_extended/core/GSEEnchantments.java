package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEEnchantments {

    public static final ResourceKey<Enchantment> BONE_RAIN =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "bone_rain"));

//TODO
//    public static final Enchantment VAMPIRIC_TOUCH = new EnchantmentVampiricTouch();
//    public static final Enchantment POISONED_BLADE = new EnchantmentPoisonedBlade();
//    public static final Enchantment WITHERED_BLADE = new EnchantmentWitheredBlade();
//    public static final Enchantment SHADOW_OF_DEATH = new EnchantmentShadowOfDeath();
//    public static final Enchantment NECROTIC_CORROSION = new EnchantmentNecroticCorrosion();
//    public static final Enchantment PAIN_MIRROR = new EnchantmentPainMirror();
//    public static final Enchantment BLOODY_REPLICATION = new EnchantmentBloodyReplication();
//
//    //armor
//    public static final Enchantment WEB_CRAWLER = new EnchantmentWebCrawler();
//    public static final Enchantment FROZEN_NETHER = new EnchantmentFrozenNether();
//
//    // CURSES
//    public static final Enchantment CURSE_AWKWARD = new EnchantmentAwkwardCurse();
//    public static final Enchantment CURSE_FRAGILITY = new EnchantmentFragilityCurse();
//
//    @Mod.EventBusSubscriber(modid = ModInfo.ID)
//    public static class RegistrationHandler {
//
//        @SubscribeEvent
//        public static void registerBlocks(final RegistryEvent.Register<Enchantment> event) {
//            final IForgeRegistry<Enchantment> registry = event.getRegistry();
//            registry.registerAll(VAMPIRIC_TOUCH, POISONED_BLADE, WITHERED_BLADE, SHADOW_OF_DEATH, NECROTIC_CORROSION);
//            registry.registerAll(PAIN_MIRROR);
//            registry.registerAll(WEB_CRAWLER, FROZEN_NETHER);
//            registry.registerAll(BLOODY_REPLICATION);
//        }
//    }
}
