package nightkosh.gravestone_extended.core;

import net.minecraft.resources.Identifier;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEResources {//TODO extends nightkosh.gravestone.core.Resources{

    protected static final String ENTITY_LOCATION = ":textures/entity/";
    protected static final String PROJECTILE_LOCATION = "projectile/";
    protected static final String MEMORIALS_LOCATION = ":textures/blocks/memorials/";
    protected static final String EXECUTIONS_LOCATION = ":textures/blocks/execution/";
    protected static final String ARMOR_LOCATION = ":textures/blocks/memorials/armor/";
    protected static final String PEDESTALS_LOCATION = ":textures/blocks/memorials/pedestal/";

    // entities
    public static final Identifier EMPTY = fromNamespaceAndPath(ModInfo.ID, "textures/entity/empty.png");
    public static final Identifier STEVE = fromNamespaceAndPath(ModInfo.ID, "textures/entity/steve.png");
    public static final Identifier ZOMBIE = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie/zombie.png");
    public static final Identifier HUSK_ZOMBIE = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie/husk.png");
    public static final Identifier ZOMBIE_VILLAGER = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie_villager/zombie_villager.png");
    public static final Identifier ZOMBIE_BUTCHER = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie_villager/zombie_butcher.png");
    public static final Identifier ZOMBIE_FARMER = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie_villager/zombie_farmer.png");
    public static final Identifier ZOMBIE_LIBRARIAN = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie_villager/zombie_librarian.png");
    public static final Identifier ZOMBIE_PRIEST = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie_villager/zombie_priest.png");
    public static final Identifier ZOMBIE_SMITH = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie_villager/zombie_smith.png");
    public static final Identifier ZOMBIE_PIGMAN = fromNamespaceAndPath(ModInfo.ID, "textures/entity/zombie_pigman.png");
    public static final Identifier SKELETON = fromNamespaceAndPath(ModInfo.ID, "textures/entity/skeleton/skeleton.png");
    public static final Identifier STRAY_SKELETON = fromNamespaceAndPath(ModInfo.ID, "textures/entity/skeleton/stray.png");
    public static final Identifier STRAY_SKELETON_OVERLAY = fromNamespaceAndPath(ModInfo.ID, "textures/entity/skeleton/stray_overlay.png");
    public static final Identifier WITHER_SKELETON = fromNamespaceAndPath(ModInfo.ID, "textures/entity/skeleton/wither_skeleton.png");
    public static final Identifier WITCH = fromNamespaceAndPath(ModInfo.ID, "textures/entity/witch.png");

    public static final String UNDERTAKER = ENTITY_LOCATION + "villagers/undertaker.png";
    public static final String UNDERTAKER_ZOMBIE = ENTITY_LOCATION + "villagers/zombie_undertaker.png";
    public static final Identifier RAVEN = fromNamespaceAndPath(ModInfo.ID, ENTITY_LOCATION + "raven.png");
    public static final Identifier DAMNED_WARRIOR = fromNamespaceAndPath(ModInfo.ID, ENTITY_LOCATION + "damnedwarrior.png");

    public static final Identifier VILLAGER = fromNamespaceAndPath(ModInfo.ID, "textures/entity/villager/villager.png");
    public static final Identifier VILLAGER_FARMER = fromNamespaceAndPath(ModInfo.ID, "textures/entity/villager/farmer.png");
    public static final Identifier VILLAGER_LIBRARIAN = fromNamespaceAndPath(ModInfo.ID, "textures/entity/villager/librarian.png");
    public static final Identifier VILLAGER_PRIEST = fromNamespaceAndPath(ModInfo.ID, "textures/entity/villager/priest.png");
    public static final Identifier VILLAGER_SMITH = fromNamespaceAndPath(ModInfo.ID, "textures/entity/villager/smith.png");
    public static final Identifier VILLAGER_BUTCHER = fromNamespaceAndPath(ModInfo.ID, "textures/entity/villager/butcher.png");

    public static final Identifier WOLF = fromNamespaceAndPath(ModInfo.ID, "textures/entity/wolf/wolf.png");
    public static final Identifier OCELOT = fromNamespaceAndPath(ModInfo.ID, "textures/entity/cat/ocelot.png");
    public static final Identifier BLACK_CAT = fromNamespaceAndPath(ModInfo.ID, "textures/entity/cat/black.png");
    public static final Identifier RED_CAT = fromNamespaceAndPath(ModInfo.ID, "textures/entity/cat/red.png");
    public static final Identifier SIAMESE_CAT = fromNamespaceAndPath(ModInfo.ID, "textures/entity/cat/siamese.png");
    public static final Identifier DONKEY = fromNamespaceAndPath(ModInfo.ID, "textures/entity/horse/donkey.png");
    public static final Identifier MULE = fromNamespaceAndPath(ModInfo.ID, "textures/entity/horse/mule.png");

    // models - memorials
    // cross
    public static final Identifier MEMORIAL_WOODEN_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/wooden.png");
    public static final Identifier MEMORIAL_SANDSTONE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/sandstone.png");
    public static final Identifier MEMORIAL_RED_SANDSTONE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/redsandstone.png");
    public static final Identifier MEMORIAL_STONE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/stone.png");
    public static final Identifier MEMORIAL_DIORITE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/diorite.png");
    public static final Identifier MEMORIAL_ANDESITE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/andesite.png");
    public static final Identifier MEMORIAL_GRANITE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/granite.png");
    public static final Identifier MEMORIAL_IRON_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/iron.png");
    public static final Identifier MEMORIAL_GOLDEN_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/golden.png");
    public static final Identifier MEMORIAL_DIAMOND_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/diamond.png");
    public static final Identifier MEMORIAL_EMERALD_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/emerald.png");
    public static final Identifier MEMORIAL_LAPIS_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/lapis.png");
    public static final Identifier MEMORIAL_REDSTONE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/redstone.png");
    public static final Identifier MEMORIAL_OBSIDIAN_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/obsidian.png");
    public static final Identifier MEMORIAL_QUARTZ_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/quartz.png");
    public static final Identifier MEMORIAL_PRIZMARINE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/prizmarine.png");
    public static final Identifier MEMORIAL_ICE_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/ice.png");
    public static final Identifier MEMORIAL_MOSSY_CROSS = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "cross/mossy.png");
    // steve memorials
    public static final Identifier MEMORIAL_WOODEN_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/wooden.png");
    public static final Identifier MEMORIAL_SANDSTONE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/sandstone.png");
    public static final Identifier MEMORIAL_RED_SANDSTONE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/redsandstone.png");
    public static final Identifier MEMORIAL_STONE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/stone.png");
    public static final Identifier MEMORIAL_DIORITE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/diorite.png");
    public static final Identifier MEMORIAL_ANDESITE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/andesite.png");
    public static final Identifier MEMORIAL_GRANITE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/granite.png");
    public static final Identifier MEMORIAL_IRON_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/iron.png");
    public static final Identifier MEMORIAL_GOLDEN_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/golden.png");
    public static final Identifier MEMORIAL_DIAMOND_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/diamond.png");
    public static final Identifier MEMORIAL_EMERALD_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/emerald.png");
    public static final Identifier MEMORIAL_LAPIS_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/lapis.png");
    public static final Identifier MEMORIAL_REDSTONE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/redstone.png");
    public static final Identifier MEMORIAL_OBSIDIAN_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/obsidian.png");
    public static final Identifier MEMORIAL_QUARTZ_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/quartz.png");
    public static final Identifier MEMORIAL_PRIZMARINE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/prizmarine.png");
    public static final Identifier MEMORIAL_ICE_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/ice.png");
    public static final Identifier MEMORIAL_MOSSY_STEVE_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "stevestatue/mossy.png");
    // angels memorials
    public static final Identifier MEMORIAL_WOODEN_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/wooden.png");
    public static final Identifier MEMORIAL_SANDSTONE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/sandstone.png");
    public static final Identifier MEMORIAL_RED_SANDSTONE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/redsandstone.png");
    public static final Identifier MEMORIAL_STONE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/stone.png");
    public static final Identifier MEMORIAL_DIORITE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/diorite.png");
    public static final Identifier MEMORIAL_ANDESITE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/andesite.png");
    public static final Identifier MEMORIAL_GRANITE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/granite.png");
    public static final Identifier MEMORIAL_IRON_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/iron.png");
    public static final Identifier MEMORIAL_GOLDEN_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/golden.png");
    public static final Identifier MEMORIAL_DIAMOND_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/diamond.png");
    public static final Identifier MEMORIAL_EMERALD_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/emerald.png");
    public static final Identifier MEMORIAL_LAPIS_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/lapis.png");
    public static final Identifier MEMORIAL_REDSTONE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/redstone.png");
    public static final Identifier MEMORIAL_OBSIDIAN_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/obsidian.png");
    public static final Identifier MEMORIAL_QUARTZ_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/quartz.png");
    public static final Identifier MEMORIAL_PRIZMARINE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/prizmarine.png");
    public static final Identifier MEMORIAL_ICE_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/ice.png");
    public static final Identifier MEMORIAL_MOSSY_ANGEL_STATUE = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "angelstatue/mossy.png");

    // models - txecution
    public static final Identifier GALLOWS = fromNamespaceAndPath(ModInfo.ID, EXECUTIONS_LOCATION + "gallows.png");
    public static final Identifier GIBBET = fromNamespaceAndPath(ModInfo.ID, EXECUTIONS_LOCATION + "gibbet.png");
    public static final Identifier STOCKS = fromNamespaceAndPath(ModInfo.ID, EXECUTIONS_LOCATION + "stocks.png");
    public static final Identifier BURNING_STAKE = fromNamespaceAndPath(ModInfo.ID, EXECUTIONS_LOCATION + "burningstake.png");

    // models - parts
    public static final Identifier CREEPER_AURA = fromNamespaceAndPath(ModInfo.ID, "textures/entity/creeper/creeper_armor.png");
    // armor
    public static final Identifier WOODEN_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "wooden.png");
    public static final Identifier SANDSTONE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "sandstone.png");
    public static final Identifier RED_SANDSTONE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "redsandstone.png");
    public static final Identifier STONE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "stone.png");
    public static final Identifier DIORITE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "diorite.png");
    public static final Identifier ANDESITE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "andesite.png");
    public static final Identifier GRANITE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "granite.png");
    public static final Identifier IRON_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "iron.png");
    public static final Identifier GOLDEN_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "golden.png");
    public static final Identifier DIAMOND_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "diamond.png");
    public static final Identifier EMERALD_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "emerald.png");
    public static final Identifier LAPIS_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "lapis.png");
    public static final Identifier REDSTONE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "redstone.png");
    public static final Identifier OBSIDIAN_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "obsidian.png");
    public static final Identifier QUARTZ_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "quartz.png");
    public static final Identifier PRIZMARINE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "prizmarine.png");
    public static final Identifier ICE_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "ice.png");
    public static final Identifier MOSSY_ARMOR = fromNamespaceAndPath(ModInfo.ID, ARMOR_LOCATION + "mossy.png");
    // small pedestal
    public static final Identifier SMALL_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, MEMORIALS_LOCATION + "modelsmallpedestal.png");
    // big pedestals
    public static final Identifier MEMORIAL_WOODEN_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "wooden.png");
    public static final Identifier MEMORIAL_SANDSTONE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "sandstone.png");
    public static final Identifier MEMORIAL_RED_SANDSTONE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "redsandstone.png");
    public static final Identifier MEMORIAL_STONE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "stone.png");
    public static final Identifier MEMORIAL_DIORITE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "diorite.png");
    public static final Identifier MEMORIAL_ANDESITE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "andesite.png");
    public static final Identifier MEMORIAL_GRANITE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "granite.png");
    public static final Identifier MEMORIAL_IRON_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "iron.png");
    public static final Identifier MEMORIAL_GOLDEN_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "golden.png");
    public static final Identifier MEMORIAL_DIAMOND_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "diamond.png");
    public static final Identifier MEMORIAL_EMERALD_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "emerald.png");
    public static final Identifier MEMORIAL_LAPIS_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "lapis.png");
    public static final Identifier MEMORIAL_REDSTONE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "redstone.png");
    public static final Identifier MEMORIAL_OBSIDIAN_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "obsidian.png");
    public static final Identifier MEMORIAL_QUARTZ_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "quartz.png");
    public static final Identifier MEMORIAL_PRIZMARINE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "prizmarine.png");
    public static final Identifier MEMORIAL_ICE_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "ice.png");
    public static final Identifier MEMORIAL_MOSSY_BIG_PEDESTAL = fromNamespaceAndPath(ModInfo.ID, PEDESTALS_LOCATION + "mossy.png");

    // haunted chest
    public static final Identifier CHRISTMAS_CHEST = fromNamespaceAndPath(ModInfo.ID, "textures/entity/chest/christmas.png");
    public static final Identifier DEFAULT_CHEST = fromNamespaceAndPath(ModInfo.ID, "textures/entity/chest/normal.png");

    // bone hook
    public static final Identifier BONE_HOOK = fromNamespaceAndPath(ModInfo.ID, PROJECTILE_LOCATION + "bone_hook.png");
    public static final Identifier WITHERED_HOOK = fromNamespaceAndPath(ModInfo.ID, PROJECTILE_LOCATION + "wither_hook.png");

}
