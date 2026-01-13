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

    public static final ResourceKey<Enchantment> VAMPIRIC_TOUCH =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "vampiric_touch"));

    public static final ResourceKey<Enchantment> POISONED_BLADE =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "poisoned_blade"));

    public static final ResourceKey<Enchantment> WITHERED_BLADE =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "withered_blade"));

    public static final ResourceKey<Enchantment> TRUE_STRIKE =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "true_strike"));

    public static final ResourceKey<Enchantment> WEB_CRAWLER =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "web_crawler"));

    public static final ResourceKey<Enchantment> MIRROR_OF_PAIN =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "mirror_of_pain"));

    public static final ResourceKey<Enchantment> CURSE_OF_AWKWARDNESS =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "curse_of_awkwardness"));

    public static final ResourceKey<Enchantment> CURSE_OF_FRAGILITY =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "curse_of_fragility"));

//TODO
//    public static final Enchantment SHADOW_OF_DEATH = new EnchantmentShadowOfDeath();
//    public static final Enchantment BLOODY_REPLICATION = new EnchantmentBloodyReplication();
//
//    //armor
//    public static final Enchantment FROZEN_NETHER = new EnchantmentFrozenNether();
//
//    @Mod.EventBusSubscriber(modid = ModInfo.ID)
//    public static class RegistrationHandler {
//
//        @SubscribeEvent
//        public static void registerBlocks(final RegistryEvent.Register<Enchantment> event) {
//            final IForgeRegistry<Enchantment> registry = event.getRegistry();
//            registry.registerAll(SHADOW_OF_DEATH);
//            registry.registerAll(FROZEN_NETHER);
//            registry.registerAll(BLOODY_REPLICATION);
//        }
//    }
}
