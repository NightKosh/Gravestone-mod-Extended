package nightkosh.gravestone_extended.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import nightkosh.gravestone.config.Config;
import nightkosh.gravestone_extended.core.GSDimensions;
import nightkosh.gravestone_extended.core.GSParticles;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.structures.GraveStoneWorldGenerator;
import nightkosh.gravestone_extended.structures.catacombs.CatacombsGenerator;
import nightkosh.gravestone_extended.structures.catacombs.CatacombsLevel;
import nightkosh.gravestone_extended.structures.graves.SingleGraveGenerator;
import nightkosh.gravestone_extended.structures.memorials.MemorialGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ExtendedConfig {

    private static Configuration config;
    private static ExtendedConfig instance;
    // CATEGORIES
    public static final String CATEGORY_STRUCTURES_CATACOMBS = "structures_catacombs";
    public static final String CATEGORY_STRUCTURES_VILLAGE = "structures_village";
    public static final String CATEGORY_STRUCTURES_OTHER = "structures_other";
    public static final String CATEGORY_POTIONS = "potions";
    public static final String CATEGORY_RECIPES = "recipes";
    public static final String CATEGORY_MOBS = "mobs";
    public static final String CATEGORY_PARTICLES = "particles";
    public static final String CATEGORY_DEBUG = "debug"; //TODO move to graves module

    private ExtendedConfig(String path, File configFile) {
        this.config = new Configuration(configFile);
        getConfigs();
    }

    public static ExtendedConfig getInstance(String path, String configFile) {
        if (instance == null) {
            return new ExtendedConfig(path, new File(path + configFile));
        } else {
            return instance;
        }
    }

    public final void getConfigs() {
        config.load();
        structures();
        gravesConfig();
        potionsConfigs();
        otherConfigs();
        recipesConfigs();
        entityConfig();
        compatibilityConfigs();
        particlesConfigs();
        debugConfigs();
        config.save();
    }

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
    public static boolean generateUndertaker;

    private static void structures() {
        // catacombs
        Property structuresDimensionIdProperty = config.get(CATEGORY_STRUCTURES_CATACOMBS, "StructuresDimensionIds", GraveStoneWorldGenerator.DEFAULT_DIMENSION_ID);
        structuresDimensionIdProperty.setComment("List of dimension id in which structures generation is allowed. \"dimension_id_1;dimension_id_2;.....\".");
        String ar = structuresDimensionIdProperty.getString();
        String[] ids = ar.split(";");
        structuresDimensionIds = new ArrayList<>(ids.length);
        for (String id : ids) {
            try {
                structuresDimensionIds.add(Integer.parseInt(id));
            } catch (NumberFormatException e) {
                GSLogger.logError("Can't parse StructuresDimensionIds!!!");
                e.printStackTrace();
            }
        }
        if (structuresDimensionIds.isEmpty()) {
            structuresDimensionIds.add(GraveStoneWorldGenerator.DEFAULT_DIMENSION_ID);
        }

        generateCatacombs = config.get(CATEGORY_STRUCTURES_CATACOMBS, "GenerateCatacombs", true).getBoolean(true);
        maxCatacombsHeight = config.get(CATEGORY_STRUCTURES_CATACOMBS, "MaximumCatacombsGenerationHeight", 75).getInt();
        catacombsGenerationChance = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsGenerationChance", CatacombsGenerator.DEFAULT_GENERATION_CHANCE).getDouble();
        generateCatacombsGraveyard = config.get(CATEGORY_STRUCTURES_CATACOMBS, "GenerateCatacombsGraveyard", true).getBoolean(true);
        generatePilesOfBones = config.get(CATEGORY_STRUCTURES_CATACOMBS, "GeneratePilesOfBones", true).getBoolean(true);

        catacombsDimensionId = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsDimensionId", GSDimensions.CATACOMBS_DEFAULT_DIMENSION_ID).getInt();

        catacombsMinRoomsCountAt1Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt1Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_1_LEVEL).getInt();
        catacombsMaxRoomsCountAt1Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt1Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_1_LEVEL).getInt();

        catacombsMinRoomsCountAt2Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt2Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_2_LEVEL).getInt();
        catacombsMaxRoomsCountAt2Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt2Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_2_LEVEL).getInt();

        catacombsMinRoomsCountAt3Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt3Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_3_LEVEL).getInt();
        catacombsMaxRoomsCountAt3Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt3Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_3_LEVEL).getInt();

        catacombsMinRoomsCountAt4Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMinRoomsCountAt4Level", CatacombsLevel.DEFAULT_MIN_ROOMS_COUNT_AT_4_LEVEL).getInt();
        catacombsMaxRoomsCountAt4Level = config.get(CATEGORY_STRUCTURES_CATACOMBS, "CatacombsMaxRoomsCountAt4Level", CatacombsLevel.DEFAULT_MAX_ROOMS_COUNT_AT_4_LEVEL).getInt();

        // other
        gravesGenerationChance = config.get(CATEGORY_STRUCTURES_OTHER, "GravesGenerationChance", SingleGraveGenerator.DEFAULT_GENERATION_CHANCE).getDouble();
        memorialsGenerationChance = config.get(CATEGORY_STRUCTURES_OTHER, "MemorialsGenerationChance", MemorialGenerator.DEFAULT_GENERATION_CHANCE).getDouble();

        generateGravesInMushroomBiomes = config.get(CATEGORY_STRUCTURES_OTHER, "GenerateGravesInMushroomBiomes", true).getBoolean(true);
        generateMemorials = config.get(CATEGORY_STRUCTURES_OTHER, "GenerateMemorials", true).getBoolean(true);
        generateSingleGraves = config.get(CATEGORY_STRUCTURES_OTHER, "GenerateSingleGraves", true).getBoolean(true);
        // village
        generateCemeteries = config.get(CATEGORY_STRUCTURES_VILLAGE, "GenerateCemeteries", false).getBoolean(false);
        generateVillageMemorials = config.get(CATEGORY_STRUCTURES_VILLAGE, "GenerateVillageMemorials", true).getBoolean(true);
        generateUndertaker = config.get(CATEGORY_STRUCTURES_VILLAGE, "GenerateUndertaker", true).getBoolean(true);
    }

    // graves for entities
    public static int graveSpawnRate;
    public static boolean spawnMobsByGraves;
    public static boolean spawnMobAtGraveDestruction;
    public static boolean isFogEnabled;
    public static int spawnChance;

    private static void gravesConfig() {
        // spawn rate
        Property graveSpawnRateProperty = config.get(Config.CATEGORY_GRAVES, "GravesMobsSpawnRate", 1000);
        graveSpawnRateProperty.setComment("This value must be bigger than 600!");
        graveSpawnRate = graveSpawnRateProperty.getInt();

        if (graveSpawnRate < 600) {
            graveSpawnRate = 600;
        }

        spawnMobsByGraves = config.get(Config.CATEGORY_GRAVES, "SpawnMobsByGraves", true).getBoolean(true);
        spawnMobAtGraveDestruction = config.get(Config.CATEGORY_GRAVES, "SpawnMobAtGraveDestruction", true).getBoolean(true);
        spawnChance = config.get(Config.CATEGORY_GRAVES, "GravesMobsSpawnChance", 80).getInt();

        isFogEnabled = config.get(Config.CATEGORY_GRAVES, "CemeteryFogEnabled", true).getBoolean(true);
    }


    public static boolean infernoDealsDamageToPlayers;

    private static void potionsConfigs() {
        infernoDealsDamageToPlayers = config.get(CATEGORY_POTIONS, "InfernoDealsDamageToPlayers", false).getBoolean(false);
    }

    // disable/enable time changing by night stone
    public static boolean enableNightStone;
    public static boolean enableThunderStone;
    public static boolean showNightStoneMessage;
    // haunted chest
    public static boolean replaceHauntedChest;
    public static boolean createCorpsesForModdedNotVanillaVillagers;
    public static boolean createCorpsesForModdedNotVanillaDogs;
    public static boolean createCorpsesForModdedNotVanillaCats;
    public static boolean createCorpsesForModdedNotVanillaHorses;
    public static boolean overrideVanillaFishing;
    public static boolean spreadToxicWater;
    public static boolean removeToxicWater;

    private static void otherConfigs() {
        // trap blocks
        enableNightStone = config.get(Configuration.CATEGORY_GENERAL, "EnableNightStone", true).getBoolean(true);
        enableThunderStone = config.get(Configuration.CATEGORY_GENERAL, "EnableThunderStone", true).getBoolean(true);
        showNightStoneMessage = config.get(Configuration.CATEGORY_GENERAL, "ShowNightStoneMessage", true).getBoolean(true);

        // haunted chest
        replaceHauntedChest = config.get(Configuration.CATEGORY_GENERAL, "ReplaceHauntedChest", false).getBoolean(false);

        createCorpsesForModdedNotVanillaVillagers = config.get(Configuration.CATEGORY_GENERAL, "CreateCorpsesForModdedNotVanillaVillagers", false).getBoolean();
        createCorpsesForModdedNotVanillaDogs = config.get(Configuration.CATEGORY_GENERAL, "CreateCorpsesForModdedNotVanillaDogs", true).getBoolean();
        createCorpsesForModdedNotVanillaCats = config.get(Configuration.CATEGORY_GENERAL, "CreateCorpsesForModdedNotVanillaCats", true).getBoolean();
        createCorpsesForModdedNotVanillaHorses = config.get(Configuration.CATEGORY_GENERAL, "CreateCorpsesForModdedNotVanillaHorses", true).getBoolean();

        // override fishing
        overrideVanillaFishing = config.get(Configuration.CATEGORY_GENERAL, "OverrideVanillaFishing", true).getBoolean(true);

        spreadToxicWater = config.get(Configuration.CATEGORY_GENERAL, "SpreadToxicWater", true).getBoolean(true);
        removeToxicWater = config.get(Configuration.CATEGORY_GENERAL, "RemoveToxicWater", false).getBoolean(false);
    }

    // recipes
    public static boolean craftableCreeperStatues;
    public static boolean craftableWitherSpawner;
    public static boolean craftableSpawners;
    public static boolean craftableNightStone;
    public static boolean craftableThunderStone;
    public static boolean hardAltarRecipe;

    private static void recipesConfigs() {
        // creeper statues
        craftableCreeperStatues = config.get(CATEGORY_RECIPES, "CraftableCreeperStatues", false).getBoolean(false);

        // spawners recipes
        craftableWitherSpawner = config.get(CATEGORY_RECIPES, "CraftableWitherSpawner", true).getBoolean(true);
        craftableSpawners = config.get(CATEGORY_RECIPES, "CraftableSpawners", true).getBoolean(true);

        craftableNightStone = config.get(CATEGORY_RECIPES, "CraftableNightStone", true).getBoolean(true);
        craftableThunderStone = config.get(CATEGORY_RECIPES, "CraftableThunderStone", true).getBoolean(true);
        hardAltarRecipe = config.get(CATEGORY_RECIPES, "HardAltarRecipe", false).getBoolean(false);
    }

    // mobs
    public static boolean spawnZombieDogs;
    public static boolean spawnZombieCats;
    public static boolean spawnSkeletonDogs;
    public static boolean spawnSkeletonCats;
    public static boolean spawnSkullCrawlersAtMobsDeath;
    public static boolean spawnSkullCrawlersAtBoneBlockDestruction;
    public static boolean spawnSkullCrawlersAtPileBonesDestruction;
    public static boolean spawnUndeadHorses;
    public static boolean spawnSkeletonRaiders;
    public static boolean spawnZombieRaiders;
    public static boolean spawnPossessedArmor;
    public static boolean spawnMummy;
    public static boolean spawnDrowned;
    public static boolean spawnPhantomDiver;
    public static boolean spawnVampireBat;
    public static boolean spawnBarghest;
    public static boolean spawnSwampThing;
    public static boolean toxicSludgeAndWaterChangeBlocks;
    public static boolean zombiePetsAttackAnimals;
    public static boolean zombiePetsAttackPets;
    public static int phantomDiverSpawnWeight;

    private static void entityConfig() {
        //mob spawn
        spawnZombieDogs = config.get(CATEGORY_MOBS, "SpawnZombieDogsInTheWorld", true).getBoolean(true);
        spawnZombieCats = config.get(CATEGORY_MOBS, "SpawnZombieCatsInTheWorld", true).getBoolean(true);
        spawnSkeletonDogs = config.get(CATEGORY_MOBS, "SpawnSkeletonDogsInTheWorld", true).getBoolean(true);
        spawnSkeletonCats = config.get(CATEGORY_MOBS, "SpawnSkeletonCatsInTheWorld", true).getBoolean(true);
        spawnUndeadHorses = config.get(CATEGORY_MOBS, "SpawnUndeadHorses", true).getBoolean(true);
        spawnSkeletonRaiders = config.get(CATEGORY_MOBS, "SpawnSkeletonRaidersInTheWorld", true).getBoolean(true);
        spawnZombieRaiders = config.get(CATEGORY_MOBS, "SpawnZombieRaidersInTheWorld", true).getBoolean(true);
        spawnPossessedArmor = config.get(CATEGORY_MOBS, "SpawnPossessedArmorInTheWorld", true).getBoolean(true);
        spawnMummy = config.get(CATEGORY_MOBS, "SpawnMummyInTheWorld", true).getBoolean(true);
        spawnDrowned = config.get(CATEGORY_MOBS, "SpawnDrownedInTheWorld", true).getBoolean(true);
        spawnPhantomDiver = config.get(CATEGORY_MOBS, "SpawnPhantomDiverInTheWorld", true).getBoolean(true);
        spawnVampireBat = config.get(CATEGORY_MOBS, "SpawnVampireBatInTheWorld", true).getBoolean(true);
        spawnBarghest = config.get(CATEGORY_MOBS, "SpawnBarghestInTheWorld", true).getBoolean(true);
        spawnSwampThing = config.get(CATEGORY_MOBS, "SpawnSwampThingInTheWorld", true).getBoolean(true);

        phantomDiverSpawnWeight = config.get(CATEGORY_MOBS, "PhantomDiverSpawnWeight", 5).getInt();


        spawnSkullCrawlersAtMobsDeath = config.get(CATEGORY_MOBS, "SpawnSkullCrawlersAtMobsDeath", true).getBoolean(true);
        spawnSkullCrawlersAtBoneBlockDestruction = config.get(CATEGORY_MOBS, "SpawnSkullCrawlersAnBoneBlockDestruction", true).getBoolean(true);
        spawnSkullCrawlersAtPileBonesDestruction = config.get(CATEGORY_MOBS, "SpawnSkullCrawlersAtPileBonesDestruction", true).getBoolean(true);

        zombiePetsAttackAnimals = config.get(CATEGORY_MOBS, "ZombiePetsAttackAnimals", true).getBoolean(true);
        zombiePetsAttackPets = config.get(CATEGORY_MOBS, "ZombiePetsAttackPets", true).getBoolean(true);

        // toxic sludge and water
        toxicSludgeAndWaterChangeBlocks = config.get(CATEGORY_MOBS, "ToxicSludgeAndWaterChangeBlocks", true).getBoolean(true);
    }

    // COMPATIBILITY
    public static boolean spawnMoCreaturesMobs;
    public static boolean enableForestryBackpacks;
    public static boolean enableAntiqueAtlasDeathMarkers;//TODO ????
    public static boolean disableInfernalMobs;

    private static void compatibilityConfigs() {
        spawnMoCreaturesMobs = config.get(Config.CATEGORY_COMPATIBILITY, "SpawnMoCreaturesMobs", true).getBoolean(true);

        enableForestryBackpacks = config.get(Config.CATEGORY_COMPATIBILITY, "EnableForestryBackpacks", true).getBoolean(true);

        enableAntiqueAtlasDeathMarkers = config.get(Config.CATEGORY_COMPATIBILITY, "EnableAntiqueAtlasDeathMarkers", true).getBoolean(true);

        disableInfernalMobs = config.get(Config.CATEGORY_COMPATIBILITY, "DisableInfernalMobs", true).getBoolean(true);
    }


    public static int particleCatacombsPortalId;
    public static int particleToxicWaterDripId;
    public static int particleToxicWaterSplashId;
    public static int particleToxicWaterBubbleId;
    public static int particleToxicWaterWakeId;

    private static void particlesConfigs() {
        particleCatacombsPortalId = config.get(CATEGORY_PARTICLES, "ParticleCatacombsPortalId", GSParticles.CATACOMBS_PORTAL_DEFAULT_ID).getInt();
        particleToxicWaterDripId = config.get(CATEGORY_PARTICLES, "ParticleToxicWaterDripId", GSParticles.TOXIC_WATER_DRIP_DEFAULT_ID).getInt();
        particleToxicWaterSplashId = config.get(CATEGORY_PARTICLES, "ParticleToxicWaterSplashId", GSParticles.TOXIC_WATER_SPLASH_DEFAULT_ID).getInt();
        particleToxicWaterBubbleId = config.get(CATEGORY_PARTICLES, "ParticleToxicWaterBubbleId", GSParticles.TOXIC_WATER_BUBBLE_DEFAULT_ID).getInt();
        particleToxicWaterWakeId = config.get(CATEGORY_PARTICLES, "ParticleToxicWaterWakeId", GSParticles.TOXIC_WATER_WAKE_DEFAULT_ID).getInt();
    }


    public static boolean debugMode;

    private static void debugConfigs() {
        debugMode = config.get(CATEGORY_DEBUG, "DebugMode", false).getBoolean(false);
    }
}