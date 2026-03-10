package nightkosh.gravestone_extended.core;

import net.neoforged.neoforge.common.ModConfigSpec;
import nightkosh.gravestone_extended.block_entity.GraveStoneSpawn;

import java.util.List;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEConfigs {

    public static final ModConfigSpec SPEC;
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static ModConfigSpec.ConfigValue<Boolean> CREATE_VILLAGERS_CORPSES;
    public static ModConfigSpec.ConfigValue<Boolean> CREATE_DOGS_CORPSES;
    public static ModConfigSpec.ConfigValue<Boolean> CREATE_CATS_CORPSES;
    public static ModConfigSpec.ConfigValue<Boolean> CREATE_HORSES_CORPSES;

    public static ModConfigSpec.ConfigValue<Boolean> SPAWN_CRAWLERS_AT_BLOCK_DESTRUCTION;
    public static ModConfigSpec.ConfigValue<Boolean> SPAWN_CRAWLERS_AT_PILES_DESTRUCTION;

    public static ModConfigSpec.ConfigValue<Boolean> INFERNO_DEALS_DAMAGE_TO_PLAYERS;
    public static ModConfigSpec.ConfigValue<Boolean> BLIZZARD_DEALS_DAMAGE_TO_PLAYERS;

    // graves
    public static ModConfigSpec.ConfigValue<Boolean> GRAVES_FOG_ENABLED;
    public static ModConfigSpec.ConfigValue<Boolean> SPAWN_MOBS_BY_GRAVES;
    public static ModConfigSpec.ConfigValue<Integer> GRAVE_MAX_SPAWN_DELAY;
    public static ModConfigSpec.ConfigValue<Boolean> SPAWN_MOB_AT_GRAVE_DESTRUCTION;

    // village
    public static ModConfigSpec.ConfigValue<Boolean> GENERATE_UNDERTAKER_HOUSE;

    // fluid
    public static ModConfigSpec.ConfigValue<Boolean> BLIGHTWATER_CONVERT_BLOCKS;
    public static ModConfigSpec.ConfigValue<Boolean> BLIGHTWATER_SPREAD;
    public static ModConfigSpec.ConfigValue<Boolean> BLIGHTWATER_AUTO_REMOVE;

    // compatibility
    public static ModConfigSpec.ConfigValue<Boolean> SOPHISTICATED_WOLVES_COMPATIBILITY;

    public static ModConfigSpec.ConfigValue<Boolean> DEBUG_MODE;

    static {
        BUILDER.push("Configs for Gravestone mod - Extended");

        // corpses
        CREATE_VILLAGERS_CORPSES = BUILDER.comment("Generate villager corpse item at villager death")
                .define("CREATE_VILLAGERS_CORPSES", true);
        CREATE_DOGS_CORPSES = BUILDER.comment("Generate dog corpse item at tamed dog death")
                .define("CREATE_DOGS_CORPSES", true);
        CREATE_CATS_CORPSES = BUILDER.comment("Generate cat corpse item at tamed cat death")
                .define("CREATE_CATS_CORPSES", true);
        CREATE_HORSES_CORPSES = BUILDER.comment("Generate horse corpse item at tamed horse death")
                .define("CREATE_HORSES_CORPSES", true);

        // mobs
        SPAWN_CRAWLERS_AT_BLOCK_DESTRUCTION = BUILDER.comment("Spawn skull crawlers at bone block destruction")
                .define("SPAWN_CRAWLERS_AT_BLOCK_DESTRUCTION", true);
        SPAWN_CRAWLERS_AT_PILES_DESTRUCTION = BUILDER.comment("Spawn skull crawlers at pile of bones destruction")
                .define("SPAWN_CRAWLERS_AT_PILES_DESTRUCTION", true);

        // potions
        INFERNO_DEALS_DAMAGE_TO_PLAYERS = BUILDER.comment("Should Inferno potion ignite other players")
                .define("INFERNO_DEALS_DAMAGE_TO_PLAYERS", true);

        BLIZZARD_DEALS_DAMAGE_TO_PLAYERS = BUILDER.comment("Should Blizzard potion freeze other players")
                .define("BLIZZARD_DEALS_DAMAGE_TO_PLAYERS", true);

        // graves
        GRAVES_FOG_ENABLED = BUILDER.define("GRAVES_FOG_ENABLED", true);
        SPAWN_MOBS_BY_GRAVES = BUILDER.define("GRAVES_SPAWN_MOBS", true);
        GRAVE_MAX_SPAWN_DELAY = BUILDER.defineInRange("GRAVE_MAX_SPAWN_DELAY", GraveStoneSpawn.MAX_DELAY, 600, 10000);
        SPAWN_MOB_AT_GRAVE_DESTRUCTION = BUILDER.define("SPAWN_MOB_AT_GRAVE_DESTRUCTION", true);

        // village
        GENERATE_UNDERTAKER_HOUSE = BUILDER.define("GENERATE_UNDERTAKER_HOUSE", true);

        // fluid
        BLIGHTWATER_CONVERT_BLOCKS = BUILDER.define("BLIGHTWATER_CONVERT_BLOCKS", true);
        BLIGHTWATER_SPREAD = BUILDER.define("BLIGHTWATER_SPREAD", true);
        BLIGHTWATER_AUTO_REMOVE = BUILDER.comment("This option can be used to replace blightwater by water.")
                .define("BLIGHTWATER_AUTO_REMOVE", false);

        // compatibility
        SOPHISTICATED_WOLVES_COMPATIBILITY = BUILDER.comment("Enable sophisticated wolves mod compatibility")
                .define("SOPHISTICATED_WOLVES_COMPATIBILITY", true);

        DEBUG_MODE = BUILDER.comment("Enable additional dev logs")
                .define("Debug Mode", false);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }

    //TODO
    // catacombs
    public static List<Integer> structuresDimensionIds;
    public static boolean generateCatacombs;
    public static int maxCatacombsHeight;
    public static double catacombsGenerationChance;
    public static boolean generateCatacombsGraveyard;
    public static int catacombsMinRoomsCountAt1Level;
    public static int catacombsMaxRoomsCountAt1Level;
    public static int catacombsMinRoomsCountAt2Level;
    public static int catacombsMaxRoomsCountAt2Level;
    public static int catacombsMinRoomsCountAt3Level;
    public static int catacombsMaxRoomsCountAt3Level;
    public static int catacombsMinRoomsCountAt4Level;
    public static int catacombsMaxRoomsCountAt4Level;
    public static boolean generatePilesOfBones;
    public static int catacombsDimensionId;
    // other structures
    public static double gravesGenerationChance;
    public static double memorialsGenerationChance;
    public static boolean generateGravesInMushroomBiomes;
    public static boolean generateSingleGraves;
    public static boolean generateMemorials;
    // village
    public static boolean generateCemeteries;
    public static boolean generateVillageMemorials;
//
//    private static void structures() {
//        // catacombs
//        structuresDimensionIds = ConfigsHelper.getDimensionList(config, CATEGORY_STRUCTURES_CATACOMBS, "StructuresDimensionIds", GraveStoneWorldGenerator.DEFAULT_DIMENSION_ID,
//                "List of dimension id in which structures generation is allowed. \"dimension_id_1;dimension_id_2;.....\".");
//
//        generateCatacombs = config.get(CATEGORY_STRUCTURES_CATACOMBS, "GenerateCatacombs", true).getBoolean();
//        maxCatacombsHeight = config.get(CATEGORY_STRUCTURES_CATACOMBS, "MaximumCatacombsGenerationHeight", 75).getInt();
//        catacombsGenerationChance = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsGenerationChance", CatacombsGenerator.DEFAULT_GENERATION_CHANCE).getDouble();
//        generateCatacombsGraveyard = config.get(CATEGORY_STRUCTURES_CATACOMBS, "GenerateCatacombsGraveyard", true).getBoolean();
//        generatePilesOfBones = config.get(CATEGORY_STRUCTURES_CATACOMBS, "GeneratePilesOfBones", true).getBoolean();
//
//        catacombsDimensionId = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsDimensionId", GSDimensions.CATACOMBS_DEFAULT_DIMENSION_ID).getInt();
//
//        catacombsMinRoomsCountAt1Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt1Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_1_LEVEL).getInt();
//        catacombsMaxRoomsCountAt1Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt1Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_1_LEVEL).getInt();
//
//        catacombsMinRoomsCountAt2Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt2Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_2_LEVEL).getInt();
//        catacombsMaxRoomsCountAt2Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt2Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_2_LEVEL).getInt();
//
//        catacombsMinRoomsCountAt3Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt3Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_3_LEVEL).getInt();
//        catacombsMaxRoomsCountAt3Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt3Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_3_LEVEL).getInt();
//
//        catacombsMinRoomsCountAt4Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt4Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_4_LEVEL).getInt();
//        catacombsMaxRoomsCountAt4Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt4Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_4_LEVEL).getInt();
//
//        // other
//        gravesGenerationChance = config.get(CATEGORY_STRUCTURES_OTHER, "GravesGenerationChance", SingleGraveGenerator.DEFAULT_GENERATION_CHANCE).getDouble();
//        memorialsGenerationChance = config.get(CATEGORY_STRUCTURES_OTHER, "MemorialsGenerationChance", MemorialGenerator.DEFAULT_GENERATION_CHANCE).getDouble();
//
//        generateGravesInMushroomBiomes = config.get(CATEGORY_STRUCTURES_OTHER, "GenerateGravesInMushroomBiomes", true).getBoolean();
//        generateMemorials = config.get(CATEGORY_STRUCTURES_OTHER, "GenerateMemorials", true).getBoolean();
//        generateSingleGraves = config.get(CATEGORY_STRUCTURES_OTHER, "GenerateSingleGraves", true).getBoolean();
//        // village
//        generateCemeteries = config.get(CATEGORY_STRUCTURES_VILLAGE, "GenerateCemeteries", false).getBoolean();
//        generateVillageMemorials = config.get(CATEGORY_STRUCTURES_VILLAGE, "GenerateVillageMemorials", true).getBoolean();
//    }

    // disable/enable time changing by night stone
    public static boolean enableNightStone;
    public static boolean enableThunderStone;
    public static boolean showNightStoneMessage;
    // haunted chest
    public static boolean replaceHauntedChest;
    //
//    private static void otherConfigs() {
//        // trap blocks
//        enableNightStone = config.get(Configuration.CATEGORY_GENERAL, "EnableNightStone", true).getBoolean();
//        enableThunderStone = config.get(Configuration.CATEGORY_GENERAL, "EnableThunderStone", true).getBoolean();
//        showNightStoneMessage = config.get(Configuration.CATEGORY_GENERAL, "ShowNightStoneMessage", true).getBoolean();
//
//        // haunted chest
//        replaceHauntedChest = config.get(Configuration.CATEGORY_GENERAL, "ReplaceHauntedChest", false).getBoolean();
//    }
//
    // recipes
    public static boolean craftableNightStone;
    public static boolean craftableThunderStone;
    //
//    private static void recipesConfigs() {
//        craftableNightStone = config.get(CATEGORY_RECIPES, "CraftableNightStone", true).getBoolean();
//        craftableThunderStone = config.get(CATEGORY_RECIPES, "CraftableThunderStone", true).getBoolean();
//    }
//
    // COMPATIBILITY
    public static boolean enableAntiqueAtlasDeathMarkers;//TODO ????
//
//    private static void compatibilityConfigs() {
//        enableAntiqueAtlasDeathMarkers = config.get(Config.CATEGORY_COMPATIBILITY, "EnableAntiqueAtlasDeathMarkers", true).getBoolean();
//    }
//

}