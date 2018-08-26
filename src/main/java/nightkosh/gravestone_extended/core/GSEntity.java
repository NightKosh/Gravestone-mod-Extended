package nightkosh.gravestone_extended.core;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.entity.EntityRaven;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.entity.item.EntityFireproofItem;
import nightkosh.gravestone_extended.entity.monster.*;
import nightkosh.gravestone_extended.entity.monster.crawler.*;
import nightkosh.gravestone_extended.entity.monster.horse.EntitySkeletonHorse;
import nightkosh.gravestone_extended.entity.monster.horse.EntityZombieHorse;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntitySkeletonDog;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieCat;
import nightkosh.gravestone_extended.entity.monster.pet.EntityZombieDog;
import nightkosh.gravestone_extended.entity.monster.water.EntityDrowned;
import nightkosh.gravestone_extended.entity.monster.water.EntityPhantomDiver;
import nightkosh.gravestone_extended.entity.monster.water.EntitySwampThing;
import nightkosh.gravestone_extended.entity.projectile.EntityBoneFishHook;
import nightkosh.gravestone_extended.entity.projectile.EntityCustomFishHook;
import nightkosh.gravestone_extended.entity.projectile.EntityObsidianFishHook;

import java.util.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEntity {

    private static final List<BiomeDictionary.Type> OVERWORLD_BIOMES = new ArrayList<>(Arrays.asList(
            BiomeDictionary.Type.MESA,
            BiomeDictionary.Type.FOREST,
            BiomeDictionary.Type.JUNGLE,
            BiomeDictionary.Type.PLAINS,
            BiomeDictionary.Type.MOUNTAIN,
            BiomeDictionary.Type.HILLS,
            BiomeDictionary.Type.SWAMP,
            BiomeDictionary.Type.SANDY,
            BiomeDictionary.Type.SNOWY,
            BiomeDictionary.Type.WASTELAND,
            BiomeDictionary.Type.BEACH,
            BiomeDictionary.Type.WATER
    ));

    private static int mobId = 0;

    private GSEntity() {
    }

    public static final String SKELETON_NAME = "GSSkeleton";
    public static final String ZOMBIE_DOG_NAME = "GSZombieDog";
    public static final String ZOMBIE_CAT_NAME = "GSZombieCat";
    public static final String SKELETON_DOG_NAME = "GSSkeletonDog";
    public static final String SKELETON_CAT_NAME = "GSSkeletonCat";
    public static final String SKULL_CRAWLER_NAME = "GSSkullCrawler";
    public static final String STRAY_SKULL_CRAWLER_NAME = "GSStraySkullCrawler";
    public static final String WITHER_SKULL_CRAWLER_NAME = "GSWitherSkullCrawler";
    public static final String ZOMBIE_SKULL_CRAWLER_NAME = "GSZombieSkullCrawler";
    public static final String HUSK_SKULL_CRAWLER_NAME = "GSHuskSkullCrawler";
    public static final String PIGMAN_SKULL_CRAWLER_NAME = "GSPigmanSkullCrawler";
    public static final String ZOMBIE_HORSE_NAME = "GSZombieHorse";
    public static final String SKELETON_HORSE_NAME = "GSSkeletonHorse";
    public static final String SKELETON_RAIDER_NAME = "GSSkeletonRaider";
    public static final String ZOMBIE_RAIDER_NAME = "GSZombieRaider";
    public static final String TOXIC_SLUDGE_NAME = "GSToxicSludge";
    public static final String POSSESSED_ARMOR_NAME = "GSPossessedArmor";
    public static final String MUMMY_NAME = "GSMummy";
    public static final String DROWNED_NAME = "GSDrowned";
    public static final String PHANTOM_DIVER_NAME = "GSPhantomDiver";
    public static final String VAMPIRE_BAT_NAME = "GSVampireBat";
    public static final String BARGHEST_NAME = "GSBarghest";
    public static final String SWAMP_THING_NAME = "GSSwampThing";
    public static final String RAVEN_NAME = "GSRaven";
    public static final String DAMNED_WARRIOR_NAME = "GSDamnedWarrior";
    public static final String SPAWNER_HELPER_NAME = "GSSpawnerHelper";
    public static final String CUSTOM_FISH_HOOK_NAME = "GSCustomFishHook";
    public static final String BONE_FISH_HOOK_NAME = "GSBoneFishHook";
    public static final String OBSIDIAN_FISH_HOOK_NAME = "GSObsidianFishHook";
    public static final String FIREPROOF_ITEM_NAME = "GSFireproofItem";

    // EntityList
    public static final ResourceLocation MINECRAFT_ZOMBIE_ID = new ResourceLocation("zombie");
    public static final ResourceLocation MINECRAFT_HUSK_ID = new ResourceLocation("husk");
    public static final ResourceLocation MINECRAFT_PIGZOMBIE_ID = new ResourceLocation("zombie_pigman");
    public static final ResourceLocation MINECRAFT_SKELETON_ID = new ResourceLocation("skeleton");
    public static final ResourceLocation MINECRAFT_WITHER_SKELETON_ID = new ResourceLocation("wither_skeleton");
    public static final ResourceLocation MINECRAFT_STRAY_ID = new ResourceLocation("stray");
    public static final ResourceLocation MINECRAFT_SPIDER_ID = new ResourceLocation("spider");
    public static final ResourceLocation MINECRAFT_CAVE_SPIDER_ID = new ResourceLocation("cave_spider");
    public static final ResourceLocation MINECRAFT_ENDERMAN_ID = new ResourceLocation("enderman");
    public static final ResourceLocation MINECRAFT_CREEPER_ID = new ResourceLocation("creeper");
    public static final ResourceLocation MINECRAFT_WITHER_ID = new ResourceLocation("wither");

    public static final ResourceLocation SKELETON_ID = new ResourceLocation(ModInfo.ID + ":" + SKELETON_NAME);
    public static final ResourceLocation ZOMBIE_DOG_ID = new ResourceLocation(ModInfo.ID + ":" + ZOMBIE_DOG_NAME);
    public static final ResourceLocation ZOMBIE_CAT_ID = new ResourceLocation(ModInfo.ID + ":" + ZOMBIE_CAT_NAME);
    public static final ResourceLocation SKELETON_DOG_ID = new ResourceLocation(ModInfo.ID + ":" + SKELETON_DOG_NAME);
    public static final ResourceLocation SKELETON_CAT_ID = new ResourceLocation(ModInfo.ID + ":" + SKELETON_CAT_NAME);
    public static final ResourceLocation SKULL_CRAWLER_ID = new ResourceLocation(ModInfo.ID + ":" + SKULL_CRAWLER_NAME);
    public static final ResourceLocation STRAY_SKULL_CRAWLER_ID = new ResourceLocation(ModInfo.ID + ":" + STRAY_SKULL_CRAWLER_NAME);
    public static final ResourceLocation WITHER_SKULL_CRAWLER_ID = new ResourceLocation(ModInfo.ID + ":" + WITHER_SKULL_CRAWLER_NAME);
    public static final ResourceLocation ZOMBIE_SKULL_CRAWLER_ID = new ResourceLocation(ModInfo.ID + ":" + ZOMBIE_SKULL_CRAWLER_NAME);
    public static final ResourceLocation HUSK_SKULL_CRAWLER_ID = new ResourceLocation(ModInfo.ID + ":" + HUSK_SKULL_CRAWLER_NAME);
    public static final ResourceLocation PIGMAN_SKULL_CRAWLER_ID = new ResourceLocation(ModInfo.ID + ":" + PIGMAN_SKULL_CRAWLER_NAME);
    public static final ResourceLocation ZOMBIE_HORSE_ID = new ResourceLocation(ModInfo.ID + ":" + ZOMBIE_HORSE_NAME);
    public static final ResourceLocation SKELETON_HORSE_ID = new ResourceLocation(ModInfo.ID + ":" + SKELETON_HORSE_NAME);
    public static final ResourceLocation SKELETON_RAIDER_ID = new ResourceLocation(ModInfo.ID + ":" + SKELETON_RAIDER_NAME);
    public static final ResourceLocation ZOMBIE_RAIDER_ID = new ResourceLocation(ModInfo.ID + ":" + ZOMBIE_RAIDER_NAME);
    public static final ResourceLocation TOXIC_SLUDGE_ID = new ResourceLocation(ModInfo.ID + ":" + TOXIC_SLUDGE_NAME);
    public static final ResourceLocation POSSESSED_ARMOR_ID = new ResourceLocation(ModInfo.ID + ":" + POSSESSED_ARMOR_NAME);
    public static final ResourceLocation MUMMY_ID = new ResourceLocation(ModInfo.ID + ":" + MUMMY_NAME);
    public static final ResourceLocation DROWNED_ID = new ResourceLocation(ModInfo.ID + ":" + DROWNED_NAME);
    public static final ResourceLocation PHANTOM_DIVER_ID = new ResourceLocation(ModInfo.ID + ":" + PHANTOM_DIVER_NAME);
    public static final ResourceLocation VAMPIRE_BAT_ID = new ResourceLocation(ModInfo.ID + ":" + VAMPIRE_BAT_NAME);
    public static final ResourceLocation BARGHEST_ID = new ResourceLocation(ModInfo.ID + ":" + BARGHEST_NAME);
    public static final ResourceLocation SWAMP_THING_ID = new ResourceLocation(ModInfo.ID + ":" + SWAMP_THING_NAME);
    public static final ResourceLocation DAMNED_WARRIOR_ID = new ResourceLocation(ModInfo.ID + ":" + DAMNED_WARRIOR_NAME);
    public static final ResourceLocation RAVEN_ID = new ResourceLocation(ModInfo.ID + ":" + RAVEN_NAME);
    public static final ResourceLocation SPAWNER_HELPER_ID = new ResourceLocation(ModInfo.ID + ":spawner_helper");
    public static final ResourceLocation CUSTOM_FISH_HOOK_ID = new ResourceLocation(ModInfo.ID + ":custom_fish_hook");
    public static final ResourceLocation BONE_FISH_HOOK_ID = new ResourceLocation(ModInfo.ID + ":bone_fish_hook");
    public static final ResourceLocation OBSIDIAN_FISH_HOOK_ID = new ResourceLocation(ModInfo.ID + ":obsidian_fish_hook");
    public static final ResourceLocation FIREPROOF_ITEM_ID = new ResourceLocation(ModInfo.ID + ":fireproof_item");

    public static final String MINECRAFT_SKELETON_NAME = "Skeleton";
    public static final String MINECRAFT_ZOMBIE_HORSE_NAME = "ZombieHorse";
    public static final String MINECRAFT_SKELETON_HORSE_NAME = "SkeletonHorse";

    public static void registration() {
        // zombie dog
        registerModEntity(ZOMBIE_DOG_ID, EntityZombieDog.class, ZOMBIE_DOG_NAME);
        if (ExtendedConfig.spawnZombieDogs) {
            addSpawn(BiomeDictionary.Type.FOREST, EntityZombieDog.class, 50, 1, 3);
        }

        // zombie cat
        registerModEntity(ZOMBIE_CAT_ID, EntityZombieCat.class, ZOMBIE_CAT_NAME);
        if (ExtendedConfig.spawnZombieCats) {
            addSpawn(BiomeDictionary.Type.JUNGLE, EntityZombieCat.class, 50, 1, 1);
        }

        // skeleton dog
        registerModEntity(SKELETON_DOG_ID, EntitySkeletonDog.class, SKELETON_DOG_NAME);
        if (ExtendedConfig.spawnSkeletonDogs) {
            addSpawn(BiomeDictionary.Type.FOREST, EntityZombieDog.class, 50, 1, 1);
        }

        // skeleton cat
        registerModEntity(SKELETON_CAT_ID, EntitySkeletonCat.class, SKELETON_CAT_NAME);
        if (ExtendedConfig.spawnSkeletonCats) {
            addSpawn(BiomeDictionary.Type.JUNGLE, EntityZombieCat.class, 50, 1, 1);
        }

        // skull crawlers
        registerModEntity(SKULL_CRAWLER_ID, EntitySkullCrawler.class, SKULL_CRAWLER_NAME);
        registerModEntity(STRAY_SKULL_CRAWLER_ID, EntityStraySkullCrawler.class, STRAY_SKULL_CRAWLER_NAME);
        // wither
        registerModEntity(WITHER_SKULL_CRAWLER_ID, EntityWitherSkullCrawler.class, WITHER_SKULL_CRAWLER_NAME);
        addSpawn(BiomeDictionary.Type.NETHER, EntityWitherSkullCrawler.class, 5, 1, 4);
        // zombie
        registerModEntity(ZOMBIE_SKULL_CRAWLER_ID, EntityZombieSkullCrawler.class, ZOMBIE_SKULL_CRAWLER_NAME);
        registerModEntity(HUSK_SKULL_CRAWLER_ID, EntityHuskSkullCrawler.class, HUSK_SKULL_CRAWLER_NAME);
        registerModEntity(PIGMAN_SKULL_CRAWLER_ID, EntityPigmanSkullCrawler.class, PIGMAN_SKULL_CRAWLER_NAME);

        registerModEntity(SKELETON_ID, EntityGSSkeleton.class, SKELETON_NAME);
        EntityRegistry.addSpawn(EntityGSSkeleton.class, 40, 1, 3, EnumCreatureType.MONSTER);

        registerModEntity(ZOMBIE_HORSE_ID, EntityZombieHorse.class, ZOMBIE_HORSE_NAME);
        registerModEntity(SKELETON_HORSE_ID, EntitySkeletonHorse.class, SKELETON_HORSE_NAME);
        if (ExtendedConfig.spawnUndeadHorses) {
            addSpawn(BiomeDictionary.Type.PLAINS, EntityZombieHorse.class, 5, 1, 3);
            addSpawn(BiomeDictionary.Type.PLAINS, EntitySkeletonHorse.class, 5, 1, 3);
        }

        registerModEntity(ZOMBIE_RAIDER_ID, EntityZombieRaider.class, ZOMBIE_RAIDER_NAME);
        if (ExtendedConfig.spawnZombieRaiders) {
            addSpawn(BiomeDictionary.Type.PLAINS, EntityZombieRaider.class, 2, 1, 1);
        }
        registerModEntity(SKELETON_RAIDER_ID, EntitySkeletonRaider.class, SKELETON_RAIDER_NAME);
        if (ExtendedConfig.spawnSkeletonRaiders) {
            addSpawn(BiomeDictionary.Type.PLAINS, EntitySkeletonRaider.class, 2, 1, 1);
        }

        registerModEntity(TOXIC_SLUDGE_ID, EntityToxicSludge.class, TOXIC_SLUDGE_NAME);
        addSpawn(OVERWORLD_BIOMES, EntityToxicSludge.class, 5, 1, 2);

        registerModEntity(POSSESSED_ARMOR_ID, EntityPossessedArmor.class, POSSESSED_ARMOR_NAME);
        if (ExtendedConfig.spawnPossessedArmor) {
            addSpawn(OVERWORLD_BIOMES, EntityPossessedArmor.class, 20, 1, 3);
        }

        registerModEntity(MUMMY_ID, EntityMummy.class, MUMMY_NAME);
        if (ExtendedConfig.spawnMummy) {
            addSpawn(BiomeDictionary.Type.SANDY, EntityMummy.class, 20, 1, 3);
        }

        registerModEntity(DROWNED_ID, EntityDrowned.class, DROWNED_NAME);
        if (ExtendedConfig.spawnDrowned) {
            addSpawnWater(new ArrayList<>(Arrays.asList(
                    BiomeDictionary.Type.BEACH, BiomeDictionary.Type.RIVER, BiomeDictionary.Type.SWAMP
            )), EntityDrowned.class, 15, 1, 1);
        }

        registerModEntity(PHANTOM_DIVER_ID, EntityPhantomDiver.class, PHANTOM_DIVER_NAME);
        if (ExtendedConfig.spawnPhantomDiver) {
            addSpawnWater(BiomeDictionary.Type.OCEAN, EntityPhantomDiver.class, ExtendedConfig.phantomDiverSpawnWeight, 1, 1);
        }

        registerModEntity(VAMPIRE_BAT_ID, EntityVampireBat.class, VAMPIRE_BAT_NAME);
        if (ExtendedConfig.spawnVampireBat) {
            addSpawn(OVERWORLD_BIOMES, EntityVampireBat.class, 30, 1, 5);
        }

        registerModEntity(BARGHEST_ID, EntityBarghest.class, BARGHEST_NAME);
        if (ExtendedConfig.spawnBarghest) {
            addSpawn(BiomeDictionary.Type.FOREST, EntityBarghest.class, 5, 1, 1);
        }

        registerModEntity(SWAMP_THING_ID, EntitySwampThing.class, SWAMP_THING_NAME);
        if (ExtendedConfig.spawnSwampThing) {
            addSpawnWater(BiomeDictionary.Type.SWAMP, EntitySwampThing.class, 50, 1, 3);
        }

        registerModEntity(RAVEN_ID, EntityRaven.class, RAVEN_NAME);
//        EntityRegistry.addSpawn(EntityRaven.class, 1, 3, 10, EnumCreatureType.AMBIENT);//TODO!!!!

        // Damned Warrior
        registerModEntity(DAMNED_WARRIOR_ID, EntityDamnedWarrior.class, DAMNED_WARRIOR_NAME);

        registerModEntity(SPAWNER_HELPER_ID, EntityGroupOfGravesMobSpawnerHelper.class, SPAWNER_HELPER_NAME);

        registerModEntity(CUSTOM_FISH_HOOK_ID, EntityCustomFishHook.class, CUSTOM_FISH_HOOK_NAME);
        registerModEntity(BONE_FISH_HOOK_ID, EntityBoneFishHook.class, BONE_FISH_HOOK_NAME);
        registerModEntity(OBSIDIAN_FISH_HOOK_ID, EntityObsidianFishHook.class, OBSIDIAN_FISH_HOOK_NAME);
        registerModEntity(FIREPROOF_ITEM_ID, EntityFireproofItem.class, FIREPROOF_ITEM_NAME);
    }

    private static void addSpawnWater(BiomeDictionary.Type biomeType, Class<? extends EntityLiving> entityClass,
                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
        addSpawnWater(Arrays.asList(biomeType), entityClass, spawnProbability, spawnMinCount, spawnMaxCount);
    }

    private static void addSpawnWater(List<BiomeDictionary.Type> biomeTypes, Class<? extends EntityLiving> entityClass,
                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
        addSpawn(biomeTypes, entityClass, EnumCreatureType.WATER_CREATURE, spawnProbability, spawnMinCount, spawnMaxCount);
        EntitySpawnPlacementRegistry.setPlacementType(entityClass, EntityLiving.SpawnPlacementType.IN_WATER);
    }

    private static void addSpawn(BiomeDictionary.Type biomeType, Class<? extends EntityLiving> entityClass,
                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
        addSpawn(Arrays.asList(biomeType), entityClass, EnumCreatureType.MONSTER, spawnProbability, spawnMinCount, spawnMaxCount);
    }

    private static void addSpawn(List<BiomeDictionary.Type> biomeTypes, Class<? extends EntityLiving> entityClass,
                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
        addSpawn(biomeTypes, entityClass, EnumCreatureType.MONSTER, spawnProbability, spawnMinCount, spawnMaxCount);
    }

    private static void addSpawn(List<BiomeDictionary.Type> biomeTypes, Class<? extends EntityLiving> entityClass,
                                 EnumCreatureType mobType, int spawnProbability, int spawnMinCount, int spawnMaxCount) {
        List<Biome> biomes = new ArrayList<>();
        for (BiomeDictionary.Type biomeType : biomeTypes) {
            Set<Biome> bSet = BiomeDictionary.getBiomes(biomeType);
            Iterator<Biome> it = bSet.iterator();
            while (it.hasNext()) {
                Biome biome = it.next();
                if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM)) {
                    biomes.add(biome);
                }
            }
        }
        Biome[] biomeArray = new Biome[biomes.size()];
        biomes.toArray(biomeArray);
        EntityRegistry.addSpawn(entityClass, spawnProbability, spawnMinCount, spawnMaxCount, mobType, biomeArray);
    }

    private static void registerModEntity(ResourceLocation resource, Class<? extends net.minecraft.entity.Entity> entityClass, String entityName) {
        registerModEntity(resource, entityClass, entityName, mobId, ModInfo.ID, 100, 1, true);
        mobId++;
    }

    private static void registerModEntity(ResourceLocation resource, Class<? extends net.minecraft.entity.Entity> entityClass, String entityName, int id,
                                          Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(resource, entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
    }
}
