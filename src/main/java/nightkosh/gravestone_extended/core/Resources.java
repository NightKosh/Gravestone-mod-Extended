package nightkosh.gravestone_extended.core;

import net.minecraft.util.ResourceLocation;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Resources extends nightkosh.gravestone.core.Resources{

    public static final String EXT_MOD_NAME = ModInfo.ID.toLowerCase();

    protected static final String BLOCK_LOCATION = EXT_MOD_NAME + ":textures/blocks/";
    protected static final String FLUID_LOCATION = EXT_MOD_NAME + ":blocks/fluids/";
    protected static final String GUI_LOCATION = EXT_MOD_NAME + ":textures/gui/";
    protected static final String POTIONS_LOCATION = EXT_MOD_NAME + ":textures/potions/";
    protected static final String PARTICLES_LOCATION = EXT_MOD_NAME + ":textures/particles/";
    protected static final String ENTITY_LOCATION = EXT_MOD_NAME + ":textures/entity/";
    protected static final String PROJECTILE_LOCATION = ENTITY_LOCATION + "projectile/";
    protected static final String MEMORIALS_LOCATION = EXT_MOD_NAME + ":textures/blocks/memorials/";
    protected static final String EXECUTIONS_LOCATION = EXT_MOD_NAME + ":textures/blocks/execution/";
    protected static final String ARMOR_LOCATION = EXT_MOD_NAME + ":textures/blocks/memorials/armor/";
    protected static final String PEDESTALS_LOCATION = EXT_MOD_NAME + ":textures/blocks/memorials/pedestal/";
    // blocks
    public static final ResourceLocation PENTAGRAM = new ResourceLocation(BLOCK_LOCATION + "pentagram.png");
    public static final ResourceLocation SPIDER_SPAWNER = new ResourceLocation(BLOCK_LOCATION + "spiderspawner.png");
    public static final ResourceLocation CANDLE = new ResourceLocation(BLOCK_LOCATION + "candle.png");
    public static final ResourceLocation PILE_OF_BONES = new ResourceLocation(BLOCK_LOCATION + "pileofbones.png");

    // armor
    public static final String DIVING_HELMET = EXT_MOD_NAME + ":textures/models/armor/phantom_diver_costume/helmet.png";
    public static final String PHANTOM_DIVER_CHESTPLATE = EXT_MOD_NAME + ":textures/models/armor/phantom_diver_costume/chestplate.png";
    public static final String PHANTOM_DIVER_LEGS = EXT_MOD_NAME + ":textures/models/armor/phantom_diver_costume/leggings.png";
    public static final String PHANTOM_DIVER_BOOTS = EXT_MOD_NAME + ":textures/models/armor/phantom_diver_costume/boots.png";

    public static final String SWAMP_THING_HELMET = EXT_MOD_NAME + ":textures/models/armor/swamp_thing_costume/helmet.png";
    public static final String SWAMP_THING_CHESTPLATE = EXT_MOD_NAME + ":textures/models/armor/swamp_thing_costume/chestplate.png";
    public static final String SWAMP_THING_LEGS = EXT_MOD_NAME + ":textures/models/armor/swamp_thing_costume/leggings.png";
    public static final String SWAMP_THING_BOOTS = EXT_MOD_NAME + ":textures/models/armor/swamp_thing_costume/boots.png";

    public static final String MUMMY_HELMET = EXT_MOD_NAME + ":textures/models/armor/mummy_costume/helmet.png";
    public static final String MUMMY_CHESTPLATE = EXT_MOD_NAME + ":textures/models/armor/mummy_costume/chestplate.png";
    public static final String MUMMY_LEGS = EXT_MOD_NAME + ":textures/models/armor/mummy_costume/leggings.png";
    public static final String MUMMY_BOOTS = EXT_MOD_NAME + ":textures/models/armor/mummy_costume/boots.png";

    // gui
    public static final ResourceLocation ALTAR_GUI = new ResourceLocation(GUI_LOCATION + "altar_gui.png");
    public static final ResourceLocation CHISEL_GUI = new ResourceLocation(GUI_LOCATION + "chisel_gui.png");

    //potions
    public static final ResourceLocation POTIONS = new ResourceLocation(POTIONS_LOCATION + "potions.png");

    //particles
    public static final ResourceLocation PARTICLES = new ResourceLocation(PARTICLES_LOCATION + "particles.png");

    // entities
    public static final ResourceLocation EMPTY = new ResourceLocation("textures/entity/empty.png");
    public static final ResourceLocation STEVE = new ResourceLocation("textures/entity/steve.png");
    public static final ResourceLocation ZOMBIE = new ResourceLocation("textures/entity/zombie/zombie.png");
    public static final ResourceLocation HUSK_ZOMBIE = new ResourceLocation("textures/entity/zombie/husk.png");
    public static final ResourceLocation ZOMBIE_VILLAGER = new ResourceLocation("textures/entity/zombie_villager/zombie_villager.png");
    public static final ResourceLocation ZOMBIE_BUTCHER = new ResourceLocation("textures/entity/zombie_villager/zombie_butcher.png");
    public static final ResourceLocation ZOMBIE_FARMER = new ResourceLocation("textures/entity/zombie_villager/zombie_farmer.png");
    public static final ResourceLocation ZOMBIE_LIBRARIAN = new ResourceLocation("textures/entity/zombie_villager/zombie_librarian.png");
    public static final ResourceLocation ZOMBIE_PRIEST = new ResourceLocation("textures/entity/zombie_villager/zombie_priest.png");
    public static final ResourceLocation ZOMBIE_SMITH = new ResourceLocation("textures/entity/zombie_villager/zombie_smith.png");
    public static final ResourceLocation ZOMBIE_PIGMAN = new ResourceLocation("textures/entity/zombie_pigman.png");
    public static final ResourceLocation SKELETON = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    public static final ResourceLocation STRAY_SKELETON = new ResourceLocation("textures/entity/skeleton/stray.png");
    public static final ResourceLocation STRAY_SKELETON_OVERLAY = new ResourceLocation("textures/entity/skeleton/stray_overlay.png");
    public static final ResourceLocation WITHER_SKELETON = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    public static final ResourceLocation WITCH = new ResourceLocation("textures/entity/witch.png");

    public static final String UNDERTAKER = ENTITY_LOCATION + "villagers/undertaker.png";
    public static final String UNDERTAKER_ZOMBIE = ENTITY_LOCATION + "villagers/zombie_undertaker.png";
    public static final ResourceLocation BARGHEST = new ResourceLocation(ENTITY_LOCATION + "barghest/barghest.png");
    public static final ResourceLocation BARGHEST_INVISIBLE = new ResourceLocation(ENTITY_LOCATION + "barghest/invisible.png");
    public static final ResourceLocation BARGHEST_EYES = new ResourceLocation(ENTITY_LOCATION + "barghest/eyes.png");
    public static final ResourceLocation ZOMBIE_DOG = new ResourceLocation(ENTITY_LOCATION + "undead_pets/dog/zombie.png");
    public static final ResourceLocation GREEN_ZOMBIE_DOG = new ResourceLocation(ENTITY_LOCATION + "undead_pets/dog/zombie_green.png");
    public static final ResourceLocation ZOMBIE_OZELOT = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_ozelot.png");
    public static final ResourceLocation ZOMBIE_CAT_BLACK = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_black.png");
    public static final ResourceLocation ZOMBIE_CAT_RED = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_red.png");
    public static final ResourceLocation ZOMBIE_CAT_SIAMESE = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_siamese.png");
    public static final ResourceLocation GREEN_ZOMBIE_OZELOT = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_green_ozelot.png");
    public static final ResourceLocation GREEN_ZOMBIE_CAT_BLACK = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_green_black.png");
    public static final ResourceLocation GREEN_ZOMBIE_CAT_RED = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_green_red.png");
    public static final ResourceLocation GREEN_ZOMBIE_CAT_SIAMESE = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/zombie_green_siamese.png");
    public static final ResourceLocation SKELETON_DOG = new ResourceLocation(ENTITY_LOCATION + "undead_pets/dog/skeleton.png");
    public static final ResourceLocation SKELETON_CAT = new ResourceLocation(ENTITY_LOCATION + "undead_pets/cat/skeleton.png");
    public static final ResourceLocation SKELETON_SKULL_CRAWLER = new ResourceLocation(ENTITY_LOCATION + "crawler/skeleton.png");
    public static final ResourceLocation STRAY_SKULL_CRAWLER = new ResourceLocation(ENTITY_LOCATION + "crawler/stray.png");
    public static final ResourceLocation WITHER_SKULL_CRAWLER = new ResourceLocation(ENTITY_LOCATION + "crawler/wither.png");
    public static final ResourceLocation ZOMBIE_SKULL_CRAWLER = new ResourceLocation(ENTITY_LOCATION + "crawler/zombie.png");
    public static final ResourceLocation PIGMAN_SKULL_CRAWLER = new ResourceLocation(ENTITY_LOCATION + "crawler/pigman.png");
    public static final ResourceLocation HUSK_SKULL_CRAWLER = new ResourceLocation(ENTITY_LOCATION + "crawler/husk.png");
    public static final ResourceLocation RAVEN = new ResourceLocation(ENTITY_LOCATION + "raven.png");
    public static final ResourceLocation DAMNED_WARRIOR = new ResourceLocation(ENTITY_LOCATION + "damnedwarrior.png");
    public static final ResourceLocation TOXIC_SLUDGE = new ResourceLocation(ENTITY_LOCATION + "toxic_sludge/toxic_sludge.png");
    public static final ResourceLocation POSSESSED_ARMOR = new ResourceLocation(ENTITY_LOCATION + "possessed_armor.png");
    public static final ResourceLocation MUMMY = new ResourceLocation(ENTITY_LOCATION + "mummy/mummy.png");
    public static final ResourceLocation MUMMY_OVERLAY = new ResourceLocation(ENTITY_LOCATION + "mummy/overlay.png");
    public static final ResourceLocation DROWNED = new ResourceLocation(ENTITY_LOCATION + "drowned.png");
    public static final ResourceLocation PHANTOM_DIVER = new ResourceLocation(ENTITY_LOCATION + "phantom_diver/phantom_diver.png");
    public static final ResourceLocation PHANTOM_DIVER_FACE = new ResourceLocation(ENTITY_LOCATION + "phantom_diver/face.png");
    public static final ResourceLocation VAMPIRE_BAT = new ResourceLocation(ENTITY_LOCATION + "vampire_bat.png");
    public static final ResourceLocation SWAMP_THING = new ResourceLocation(ENTITY_LOCATION + "swamp_thing/swamp_thing.png");
    public static final ResourceLocation SWAMP_THING_OVERLAY = new ResourceLocation(ENTITY_LOCATION + "swamp_thing/overlay.png");

    public static final ResourceLocation VILLAGER = new ResourceLocation("textures/entity/villager/villager.png");
    public static final ResourceLocation VILLAGER_FARMER = new ResourceLocation("textures/entity/villager/farmer.png");
    public static final ResourceLocation VILLAGER_LIBRARIAN = new ResourceLocation("textures/entity/villager/librarian.png");
    public static final ResourceLocation VILLAGER_PRIEST = new ResourceLocation("textures/entity/villager/priest.png");
    public static final ResourceLocation VILLAGER_SMITH = new ResourceLocation("textures/entity/villager/smith.png");
    public static final ResourceLocation VILLAGER_BUTCHER = new ResourceLocation("textures/entity/villager/butcher.png");

    public static final ResourceLocation WOLF = new ResourceLocation("textures/entity/wolf/wolf.png");
    public static final ResourceLocation OCELOT = new ResourceLocation("textures/entity/cat/ocelot.png");
    public static final ResourceLocation BLACK_CAT = new ResourceLocation("textures/entity/cat/black.png");
    public static final ResourceLocation RED_CAT = new ResourceLocation("textures/entity/cat/red.png");
    public static final ResourceLocation SIAMESE_CAT = new ResourceLocation("textures/entity/cat/siamese.png");
    public static final ResourceLocation DONKEY = new ResourceLocation("textures/entity/horse/donkey.png");
    public static final ResourceLocation MULE = new ResourceLocation("textures/entity/horse/mule.png");
    public static final ResourceLocation ZOMBIE_HORSE = new ResourceLocation("textures/entity/horse/horse_zombie.png");
    public static final ResourceLocation SKELETON_HORSE = new ResourceLocation("textures/entity/horse/horse_skeleton.png");

    // models - memorials
    // cross
    public static final ResourceLocation MEMORIAL_WOODEN_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/wooden.png");
    public static final ResourceLocation MEMORIAL_SANDSTONE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/sandstone.png");
    public static final ResourceLocation MEMORIAL_RED_SANDSTONE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/redsandstone.png");
    public static final ResourceLocation MEMORIAL_STONE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/stone.png");
    public static final ResourceLocation MEMORIAL_DIORITE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/diorite.png");
    public static final ResourceLocation MEMORIAL_ANDESITE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/andesite.png");
    public static final ResourceLocation MEMORIAL_GRANITE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/granite.png");
    public static final ResourceLocation MEMORIAL_IRON_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/iron.png");
    public static final ResourceLocation MEMORIAL_GOLDEN_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/golden.png");
    public static final ResourceLocation MEMORIAL_DIAMOND_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/diamond.png");
    public static final ResourceLocation MEMORIAL_EMERALD_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/emerald.png");
    public static final ResourceLocation MEMORIAL_LAPIS_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/lapis.png");
    public static final ResourceLocation MEMORIAL_REDSTONE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/redstone.png");
    public static final ResourceLocation MEMORIAL_OBSIDIAN_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/obsidian.png");
    public static final ResourceLocation MEMORIAL_QUARTZ_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/quartz.png");
    public static final ResourceLocation MEMORIAL_PRIZMARINE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/prizmarine.png");
    public static final ResourceLocation MEMORIAL_ICE_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/ice.png");
    public static final ResourceLocation MEMORIAL_MOSSY_CROSS = new ResourceLocation(MEMORIALS_LOCATION + "cross/mossy.png");
    // steve memorials
    public static final ResourceLocation MEMORIAL_WOODEN_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/wooden.png");
    public static final ResourceLocation MEMORIAL_SANDSTONE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/sandstone.png");
    public static final ResourceLocation MEMORIAL_RED_SANDSTONE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/redsandstone.png");
    public static final ResourceLocation MEMORIAL_STONE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/stone.png");
    public static final ResourceLocation MEMORIAL_DIORITE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/diorite.png");
    public static final ResourceLocation MEMORIAL_ANDESITE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/andesite.png");
    public static final ResourceLocation MEMORIAL_GRANITE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/granite.png");
    public static final ResourceLocation MEMORIAL_IRON_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/iron.png");
    public static final ResourceLocation MEMORIAL_GOLDEN_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/golden.png");
    public static final ResourceLocation MEMORIAL_DIAMOND_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/diamond.png");
    public static final ResourceLocation MEMORIAL_EMERALD_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/emerald.png");
    public static final ResourceLocation MEMORIAL_LAPIS_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/lapis.png");
    public static final ResourceLocation MEMORIAL_REDSTONE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/redstone.png");
    public static final ResourceLocation MEMORIAL_OBSIDIAN_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/obsidian.png");
    public static final ResourceLocation MEMORIAL_QUARTZ_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/quartz.png");
    public static final ResourceLocation MEMORIAL_PRIZMARINE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/prizmarine.png");
    public static final ResourceLocation MEMORIAL_ICE_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/ice.png");
    public static final ResourceLocation MEMORIAL_MOSSY_STEVE_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "stevestatue/mossy.png");
    // angels memorials
    public static final ResourceLocation MEMORIAL_WOODEN_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/wooden.png");
    public static final ResourceLocation MEMORIAL_SANDSTONE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/sandstone.png");
    public static final ResourceLocation MEMORIAL_RED_SANDSTONE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/redsandstone.png");
    public static final ResourceLocation MEMORIAL_STONE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/stone.png");
    public static final ResourceLocation MEMORIAL_DIORITE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/diorite.png");
    public static final ResourceLocation MEMORIAL_ANDESITE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/andesite.png");
    public static final ResourceLocation MEMORIAL_GRANITE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/granite.png");
    public static final ResourceLocation MEMORIAL_IRON_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/iron.png");
    public static final ResourceLocation MEMORIAL_GOLDEN_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/golden.png");
    public static final ResourceLocation MEMORIAL_DIAMOND_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/diamond.png");
    public static final ResourceLocation MEMORIAL_EMERALD_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/emerald.png");
    public static final ResourceLocation MEMORIAL_LAPIS_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/lapis.png");
    public static final ResourceLocation MEMORIAL_REDSTONE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/redstone.png");
    public static final ResourceLocation MEMORIAL_OBSIDIAN_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/obsidian.png");
    public static final ResourceLocation MEMORIAL_QUARTZ_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/quartz.png");
    public static final ResourceLocation MEMORIAL_PRIZMARINE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/prizmarine.png");
    public static final ResourceLocation MEMORIAL_ICE_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/ice.png");
    public static final ResourceLocation MEMORIAL_MOSSY_ANGEL_STATUE = new ResourceLocation(MEMORIALS_LOCATION + "angelstatue/mossy.png");

    // models - txecution
    public static final ResourceLocation GALLOWS = new ResourceLocation(EXECUTIONS_LOCATION + "gallows.png");
    public static final ResourceLocation GIBBET = new ResourceLocation(EXECUTIONS_LOCATION + "gibbet.png");
    public static final ResourceLocation STOCKS = new ResourceLocation(EXECUTIONS_LOCATION + "stocks.png");
    public static final ResourceLocation BURNING_STAKE = new ResourceLocation(EXECUTIONS_LOCATION + "burningstake.png");

    // models - parts
    public static final ResourceLocation CREEPER_AURA = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    // armor
    public static final ResourceLocation WOODEN_ARMOR = new ResourceLocation(ARMOR_LOCATION + "wooden.png");
    public static final ResourceLocation SANDSTONE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "sandstone.png");
    public static final ResourceLocation RED_SANDSTONE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "redsandstone.png");
    public static final ResourceLocation STONE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "stone.png");
    public static final ResourceLocation DIORITE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "diorite.png");
    public static final ResourceLocation ANDESITE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "andesite.png");
    public static final ResourceLocation GRANITE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "granite.png");
    public static final ResourceLocation IRON_ARMOR = new ResourceLocation(ARMOR_LOCATION + "iron.png");
    public static final ResourceLocation GOLDEN_ARMOR = new ResourceLocation(ARMOR_LOCATION + "golden.png");
    public static final ResourceLocation DIAMOND_ARMOR = new ResourceLocation(ARMOR_LOCATION + "diamond.png");
    public static final ResourceLocation EMERALD_ARMOR = new ResourceLocation(ARMOR_LOCATION + "emerald.png");
    public static final ResourceLocation LAPIS_ARMOR = new ResourceLocation(ARMOR_LOCATION + "lapis.png");
    public static final ResourceLocation REDSTONE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "redstone.png");
    public static final ResourceLocation OBSIDIAN_ARMOR = new ResourceLocation(ARMOR_LOCATION + "obsidian.png");
    public static final ResourceLocation QUARTZ_ARMOR = new ResourceLocation(ARMOR_LOCATION + "quartz.png");
    public static final ResourceLocation PRIZMARINE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "prizmarine.png");
    public static final ResourceLocation ICE_ARMOR = new ResourceLocation(ARMOR_LOCATION + "ice.png");
    public static final ResourceLocation MOSSY_ARMOR = new ResourceLocation(ARMOR_LOCATION + "mossy.png");
    // small pedestal
    public static final ResourceLocation SMALL_PEDESTAL = new ResourceLocation(MEMORIALS_LOCATION + "modelsmallpedestal.png");
    // big pedestals
    public static final ResourceLocation MEMORIAL_WOODEN_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "wooden.png");
    public static final ResourceLocation MEMORIAL_SANDSTONE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "sandstone.png");
    public static final ResourceLocation MEMORIAL_RED_SANDSTONE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "redsandstone.png");
    public static final ResourceLocation MEMORIAL_STONE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "stone.png");
    public static final ResourceLocation MEMORIAL_DIORITE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "diorite.png");
    public static final ResourceLocation MEMORIAL_ANDESITE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "andesite.png");
    public static final ResourceLocation MEMORIAL_GRANITE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "granite.png");
    public static final ResourceLocation MEMORIAL_IRON_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "iron.png");
    public static final ResourceLocation MEMORIAL_GOLDEN_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "golden.png");
    public static final ResourceLocation MEMORIAL_DIAMOND_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "diamond.png");
    public static final ResourceLocation MEMORIAL_EMERALD_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "emerald.png");
    public static final ResourceLocation MEMORIAL_LAPIS_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "lapis.png");
    public static final ResourceLocation MEMORIAL_REDSTONE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "redstone.png");
    public static final ResourceLocation MEMORIAL_OBSIDIAN_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "obsidian.png");
    public static final ResourceLocation MEMORIAL_QUARTZ_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "quartz.png");
    public static final ResourceLocation MEMORIAL_PRIZMARINE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "prizmarine.png");
    public static final ResourceLocation MEMORIAL_ICE_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "ice.png");
    public static final ResourceLocation MEMORIAL_MOSSY_BIG_PEDESTAL = new ResourceLocation(PEDESTALS_LOCATION + "mossy.png");

    // haunted chest
    public static final ResourceLocation CHRISTMAS_CHEST = new ResourceLocation("textures/entity/chest/christmas.png");
    public static final ResourceLocation DEFAULT_CHEST = new ResourceLocation("textures/entity/chest/normal.png");

    // bone hook
    public static final ResourceLocation BONE_HOOK = new ResourceLocation(PROJECTILE_LOCATION + "bone_hook.png");
    public static final ResourceLocation WITHERED_HOOK = new ResourceLocation(PROJECTILE_LOCATION + "wither_hook.png");

    // skull candle
    public static final ResourceLocation SKELETON_SKULL_CANDLE = new ResourceLocation(BLOCK_LOCATION + "skeletonskullcandle.png");
    public static final ResourceLocation WITHER_SKULL_CANDLE = new ResourceLocation(BLOCK_LOCATION + "witherskullcandle.png");
    public static final ResourceLocation ZOMBIE_SKULL_CANDLE = new ResourceLocation(BLOCK_LOCATION + "zombieskullcandle.png");

    // TOXIC WATER
    public static final ResourceLocation TOXIC_WATER_STILL =  new ResourceLocation(FLUID_LOCATION + "toxic_water_still");
    public static final ResourceLocation TOXIC_WATER_FLOW = new ResourceLocation(FLUID_LOCATION + "toxic_water_flow");
}
