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

    public static final ResourceKey<Enchantment> SHADOW_OF_DEATH =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "shadow_of_death"));

    public static final ResourceKey<Enchantment> TRUE_STRIKE =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "true_strike"));

    public static final ResourceKey<Enchantment> WEB_CRAWLER =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "web_crawler"));

    public static final ResourceKey<Enchantment> FROZEN_NETHER =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "frozen_nether"));

    public static final ResourceKey<Enchantment> MIRROR_OF_PAIN =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "mirror_of_pain"));

    public static final ResourceKey<Enchantment> GILDED_SHEEN =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "gilded_sheen"));

    public static final ResourceKey<Enchantment> CURSE_OF_AWKWARDNESS =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "curse_of_awkwardness"));

    public static final ResourceKey<Enchantment> CURSE_OF_FRAGILITY =
            ResourceKey.create(Registries.ENCHANTMENT, fromNamespaceAndPath(ModInfo.ID, "curse_of_fragility"));

//TODO
//    @Mod.EventBusSubscriber(modid = ModInfo.ID)
//    public static class RegistrationHandler {
//
//        @SubscribeEvent
//        public static void registerBlocks(final RegistryEvent.Register<Enchantment> event) {
//            final IForgeRegistry<Enchantment> registry = event.getRegistry();
//            registry.registerAll(BLOODY_REPLICATION);
//        }
//    }
}
