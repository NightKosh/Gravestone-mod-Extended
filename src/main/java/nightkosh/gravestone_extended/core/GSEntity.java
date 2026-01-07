package nightkosh.gravestone_extended.core;

import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.compatibility.Compatibility;
import nightkosh.gravestone_extended.entity.EntityRaven;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.entity.monster.*;
import nightkosh.gravestone_extended.entity.projectile.EntityBoneFishHook;
import nightkosh.gravestone_extended.entity.projectile.EntityObsidianFishHook;

import java.util.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEntity {
//
//    private static int mobId = 0;
//
//    private GSEntity() {
//    }
//
//    public static final String SKELETON_NAME = "GSSkeleton";
//    public static final String RAVEN_NAME = "GSRaven";
//    public static final String DAMNED_WARRIOR_NAME = "GSDamnedWarrior";
//    public static final String SPAWNER_HELPER_NAME = "GSSpawnerHelper";
//
//    public static final String BONE_FISH_HOOK_NAME = "GSBoneFishHook";
//    public static final String OBSIDIAN_FISH_HOOK_NAME = "GSObsidianFishHook";
//
//    // EntityList
//    public static final ResourceLocation MINECRAFT_ZOMBIE_ID = new ResourceLocation("zombie");
//    public static final ResourceLocation MINECRAFT_HUSK_ID = new ResourceLocation("husk");
//    public static final ResourceLocation MINECRAFT_PIGZOMBIE_ID = new ResourceLocation("zombie_pigman");
//    public static final ResourceLocation MINECRAFT_SPIDER_ID = new ResourceLocation("spider");
//    public static final ResourceLocation MINECRAFT_CAVE_SPIDER_ID = new ResourceLocation("cave_spider");
//    public static final ResourceLocation MINECRAFT_ENDERMAN_ID = new ResourceLocation("enderman");
//    public static final ResourceLocation MINECRAFT_CREEPER_ID = new ResourceLocation("creeper");
//    public static final ResourceLocation MINECRAFT_WITHER_ID = new ResourceLocation("wither");
//
//    public static final ResourceLocation SKELETON_ID = new ResourceLocation(ModInfo.ID + ":" + SKELETON_NAME);
//    public static final ResourceLocation DAMNED_WARRIOR_ID = new ResourceLocation(ModInfo.ID + ":" + DAMNED_WARRIOR_NAME);
//    public static final ResourceLocation RAVEN_ID = new ResourceLocation(ModInfo.ID + ":" + RAVEN_NAME);
//    public static final ResourceLocation SPAWNER_HELPER_ID = new ResourceLocation(ModInfo.ID + ":spawner_helper");
//
//    public static final ResourceLocation BONE_FISH_HOOK_ID = new ResourceLocation(ModInfo.ID + ":bone_fish_hook");
//    public static final ResourceLocation OBSIDIAN_FISH_HOOK_ID = new ResourceLocation(ModInfo.ID + ":obsidian_fish_hook");
//
//    public static final String MINECRAFT_SKELETON_NAME = "Skeleton";
//
//    public static void registration() {
//
//        registerModEntity(SKELETON_ID, EntityGSSkeleton.class, SKELETON_NAME);
//        EntityRegistry.addSpawn(EntityGSSkeleton.class, 40, 1, 3, EnumCreatureType.MONSTER);
//
//        registerModEntity(RAVEN_ID, EntityRaven.class, RAVEN_NAME);
////        EntityRegistry.addSpawn(EntityRaven.class, 1, 3, 10, EnumCreatureType.AMBIENT);//TODO!!!!
//
//        // Damned Warrior
//        registerModEntity(DAMNED_WARRIOR_ID, EntityDamnedWarrior.class, DAMNED_WARRIOR_NAME);
//
//        registerModEntity(SPAWNER_HELPER_ID, EntityGroupOfGravesMobSpawnerHelper.class, SPAWNER_HELPER_NAME);
//
//        if (Compatibility.isModLoaded(Compatibility.ADVANCED_FISHING_ID)) {
//            registerModEntity(BONE_FISH_HOOK_ID, EntityBoneFishHook.class, BONE_FISH_HOOK_NAME);
//            registerModEntity(OBSIDIAN_FISH_HOOK_ID, EntityObsidianFishHook.class, OBSIDIAN_FISH_HOOK_NAME);
//        }
//    }
//
//    private static void addSpawnWater(BiomeDictionary.Type biomeType, Class<? extends EntityLiving> entityClass,
//                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
//        addSpawnWater(Arrays.asList(biomeType), entityClass, spawnProbability, spawnMinCount, spawnMaxCount);
//    }
//
//    private static void addSpawnWater(List<BiomeDictionary.Type> biomeTypes, Class<? extends EntityLiving> entityClass,
//                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
//        addSpawn(biomeTypes, entityClass, EnumCreatureType.WATER_CREATURE, spawnProbability, spawnMinCount, spawnMaxCount);
//        EntitySpawnPlacementRegistry.setPlacementType(entityClass, EntityLiving.SpawnPlacementType.IN_WATER);
//    }
//
//    private static void addSpawn(BiomeDictionary.Type biomeType, Class<? extends EntityLiving> entityClass,
//                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
//        addSpawn(Arrays.asList(biomeType), entityClass, EnumCreatureType.MONSTER, spawnProbability, spawnMinCount, spawnMaxCount);
//    }
//
//    private static void addSpawn(List<BiomeDictionary.Type> biomeTypes, Class<? extends EntityLiving> entityClass,
//                                 int spawnProbability, int spawnMinCount, int spawnMaxCount) {
//        addSpawn(biomeTypes, entityClass, EnumCreatureType.MONSTER, spawnProbability, spawnMinCount, spawnMaxCount);
//    }
//
//    private static void addSpawn(List<BiomeDictionary.Type> biomeTypes, Class<? extends EntityLiving> entityClass,
//                                 EnumCreatureType mobType, int spawnProbability, int spawnMinCount, int spawnMaxCount) {
//        List<Biome> biomes = new ArrayList<>();
//        for (BiomeDictionary.Type biomeType : biomeTypes) {
//            Set<Biome> bSet = BiomeDictionary.getBiomes(biomeType);
//            Iterator<Biome> it = bSet.iterator();
//            while (it.hasNext()) {
//                Biome biome = it.next();
//                if (!BiomeDictionary.hasType(biome, BiomeDictionary.Type.MUSHROOM)) {
//                    biomes.add(biome);
//                }
//            }
//        }
//        Biome[] biomeArray = new Biome[biomes.size()];
//        biomes.toArray(biomeArray);
//        EntityRegistry.addSpawn(entityClass, spawnProbability, spawnMinCount, spawnMaxCount, mobType, biomeArray);
//    }
//
//    private static void registerModEntity(ResourceLocation resource, Class<? extends net.minecraft.entity.Entity> entityClass, String entityName) {
//        registerModEntity(resource, entityClass, entityName, mobId, ModInfo.ID, 100, 1, true);
//        mobId++;
//    }
//
//    private static void registerModEntity(ResourceLocation resource, Class<? extends net.minecraft.entity.Entity> entityClass, String entityName, int id,
//                                          Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
//        EntityRegistry.registerModEntity(resource, entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
//    }
}
