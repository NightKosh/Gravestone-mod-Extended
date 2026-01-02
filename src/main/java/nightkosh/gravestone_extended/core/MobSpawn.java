package nightkosh.gravestone_extended.core;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nightkosh.gravestone.block.enums.EnumGraves;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.entity.monster.EntityGSSkeleton;
import nightkosh.gravestone_extended.entity.monster.EntityGSSkeleton.SkeletonType;
import nightkosh.gravestone_extended.entity.monster.crawler.EntitySkullCrawler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MobSpawn {

    private static final int HELL_HEIGHT = 51;
    private static final Random RANDOM = new Random();
    /**
     * Provides a mapping between entity classes and a string
     */
    public static Map<ResourceLocation, Constructor<EntityLiving>> mobNameToClassMapping = new HashMap<>();
    public static List<ResourceLocation> MOB_ID = new ArrayList<>(Arrays.asList(GSEntity.MINECRAFT_ZOMBIE_ID, GSEntity.SKELETON_ID));
    public static List<ResourceLocation> HORSE_ID = new ArrayList<>(Arrays.asList(GSEntity.ZOMBIE_HORSE_ID, GSEntity.SKELETON_HORSE_ID));
    public static List<ResourceLocation> HELL_MOB_ID = new ArrayList<>(Arrays.asList(GSEntity.MINECRAFT_PIGZOMBIE_ID, GSEntity.SKELETON_ID));
    // spawner mobs
    public static List<ResourceLocation> skeletonSpawnerMobs = new ArrayList<>(Arrays.asList(
            GSEntity.SKELETON_ID, GSEntity.SKELETON_ID, GSEntity.SKELETON_ID, GSEntity.SKELETON_ID,
            GSEntity.SKELETON_DOG_ID,
            GSEntity.SKELETON_CAT_ID,
            GSEntity.SKELETON_HORSE_ID,
            GSEntity.SKELETON_RAIDER_ID
    ));
    public static List<ResourceLocation> zombieSpawnerMobs = new ArrayList<>(Arrays.asList(
            GSEntity.MINECRAFT_ZOMBIE_ID, GSEntity.MINECRAFT_ZOMBIE_ID, GSEntity.MINECRAFT_ZOMBIE_ID, GSEntity.MINECRAFT_ZOMBIE_ID, GSEntity.MINECRAFT_ZOMBIE_ID,
            GSEntity.MINECRAFT_HUSK_ID,
            GSEntity.ZOMBIE_DOG_ID,
            GSEntity.ZOMBIE_CAT_ID,
            GSEntity.ZOMBIE_HORSE_ID,
            GSEntity.ZOMBIE_RAIDER_ID
    ));
    public static List<ResourceLocation> spiderSpawnerMobs = new ArrayList<>(Arrays.asList(
            GSEntity.MINECRAFT_SPIDER_ID, GSEntity.MINECRAFT_CAVE_SPIDER_ID, GSEntity.MINECRAFT_SPIDER_ID));
    // catacombs statues mobs
    public static List<ResourceLocation> catacombsStatuesMobs = new ArrayList<>(Arrays.asList(
            GSEntity.SKELETON_ID, GSEntity.MINECRAFT_ZOMBIE_ID, GSEntity.POSSESSED_ARMOR_ID));


    /**
     * Check can grave spawn hell creature or not
     *
     * @param world
     * @param x     X coordinate
     * @param y     Y coordinate
     * @param z     Z coordinate
     */
    private static boolean canSpawnHellCreatures(World world, int x, int y, int z) {
        return world != null && y < HELL_HEIGHT && world.getBlockState(new BlockPos(x, y - 1, z)).getBlock().equals(Blocks.NETHER_BRICK);
    }

    /**
     * will create the entity from the internalID the first time it is accessed
     */
    public static net.minecraft.entity.Entity getMobEntity(World world, EnumGraves graveType, int x, int y, int z) {
        ResourceLocation id;

        switch (graveType.getGraveType()) {
            case DOG_STATUE:
                id = getMobID(world.rand, EnumMobType.UNDEAD_DOGS);
                break;
            case CAT_STATUE:
                id = getMobID(world.rand, EnumMobType.UNDEAD_CATS);
                break;
            case HORSE_STATUE:
                id = getMobID(world.rand, EnumMobType.UNDEAD_HORSES);
                break;
            default:
                if (canSpawnHellCreatures(world, x, y, z) && world.rand.nextInt(10) == 0) {
                    id = getMobID(world.rand, EnumMobType.HELL_MOBS);

                    if (id.equals(GSEntity.SKELETON_ID)) {
                        EntityGSSkeleton skeleton = getSkeleton(world, RANDOM.nextBoolean());
                        skeleton.setSkeletonType(SkeletonType.WITHER);
                        return skeleton;
                    }
                } else {
                    id = getMobID(world.rand, EnumMobType.DEFAULT_MOBS);

                    if (id.equals(GSEntity.SKELETON_ID)) {
                        EntityGSSkeleton skeleton = getSkeleton(world, RANDOM.nextBoolean());
                        if (RANDOM.nextInt(5) == 0) {
                            skeleton.setSkeletonType(SkeletonType.STRAY);
                        }
                        return skeleton;
                    }

                    if (id.equals(GSEntity.MINECRAFT_ZOMBIE_ID) && world.rand.nextInt(5) == 0) {
                        return EntityList.createEntityByIDFromName(GSEntity.MINECRAFT_HUSK_ID, world);
                    }
                }
                break;
        }

        EntityLiving entity = (EntityLiving) EntityList.createEntityByIDFromName(id, world);

        if (entity == null) {
            entity = getForeinMob(world, id);
        }

        try {
            entity.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(x, y, z)), null);
        } catch (Exception e) {
            GSLogger.logError("getMobEntity exception with onSpawnWithEgg");
            e.printStackTrace();
        }

        return entity;
    }

    /**
     * will create the entity from the internalID the first time it is accessed
     */
    public static net.minecraft.entity.Entity getMobEntityForSpawner(World world, EnumSpawner spawnerType, int x, int y, int z) {
        ResourceLocation mobId;

        switch (spawnerType) {
            case WITHER_SPAWNER:
                mobId = GSEntity.MINECRAFT_WITHER_ID;
                break;
            case SKELETON_SPAWNER:
                mobId = skeletonSpawnerMobs.get(world.rand.nextInt(skeletonSpawnerMobs.size()));

                if (mobId.equals(GSEntity.SKELETON_ID)) {
                    EntityGSSkeleton skeleton = getSkeleton(world, RANDOM.nextBoolean());
                    if (world.rand.nextInt(5) == 0) {
                        skeleton.setSkeletonType(SkeletonType.STRAY);
                    } else if (world.rand.nextInt(10) == 0) {
                        skeleton.setSkeletonType(SkeletonType.WITHER);
                    }
                    return skeleton;
                }
                break;
            case SPIDER_SPAWNER:
                mobId = spiderSpawnerMobs.get(world.rand.nextInt(spiderSpawnerMobs.size()));
                break;
            case ZOMBIE_SPAWNER:
            default:
                mobId = zombieSpawnerMobs.get(world.rand.nextInt(zombieSpawnerMobs.size()));
        }

        EntityLiving entity = (EntityLiving) EntityList.createEntityByIDFromName(mobId, world);

        if (entity == null) {
            entity = getForeinMob(world, mobId);
        }

        try {
            entity.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(x, y, z)), (IEntityLivingData) null);
        } catch (Exception e) {
            GSLogger.logError("getMobEntity exception with onSpawnWithEgg");
            e.printStackTrace();
        }

        return entity;
    }

    /**
     * Return Skeleton with bow/sword
     */
    public static EntityGSSkeleton getSkeleton(World world, boolean withBow) {
        EntityGSSkeleton skeleton = (EntityGSSkeleton) EntityList.createEntityByIDFromName(GSEntity.SKELETON_ID, world);
        if (skeleton != null) {
            if (withBow) {
                skeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW, 1));
            } else {
                skeleton.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD, 1));
            }
        }

        return skeleton;
    }

    public static boolean isWitherSkeleton(AbstractSkeleton skeleton) {
        return skeleton instanceof EntityGSSkeleton && ((EntityGSSkeleton) skeleton).getSkeletonType() == SkeletonType.WITHER ||
                skeleton instanceof EntityWitherSkeleton;
    }

    public static boolean isStraySkeleton(AbstractSkeleton skeleton) {
        return skeleton instanceof EntityGSSkeleton && ((EntityGSSkeleton) skeleton).getSkeletonType() == SkeletonType.STRAY ||
                skeleton instanceof EntityStray;
    }

    /**
     * Create and return instance for forein mobs
     *
     * @param world
     * @param mobName
     */
    private static EntityLiving getForeinMob(World world, ResourceLocation mobName) {
        EntityLiving mob = null;
        String name = mobName.getResourcePath();
        try {
            mob = mobNameToClassMapping.get(name).newInstance(new Object[]{world});
        } catch (InstantiationException e) {
            GSLogger.logError("getForeinMob InstantiationException. mob name " + name);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            GSLogger.logError("getForeinMob IllegalAccessException. mob name " + name);
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            GSLogger.logError("getForeinMob InvocationTargetException. mob name " + name);
            e.getCause().printStackTrace();
        } catch (NullPointerException e) {
            GSLogger.logError("getForeinMob NullPointerException. mob name " + name);
            e.getCause().printStackTrace();
        }

        return mob;
    }

    /**
     * Return random mob id from list
     *
     * @param random
     * @param mobType
     */
    public static ResourceLocation getMobID(Random random, EnumMobType mobType) {
        switch (mobType) {
            case HELL_MOBS:
                return HELL_MOB_ID.get(random.nextInt(HELL_MOB_ID.size()));
            case UNDEAD_DOGS:
                return DOG_ID.get(random.nextInt(DOG_ID.size()));
            case UNDEAD_CATS:
                return CAT_ID.get(random.nextInt(CAT_ID.size()));
            case UNDEAD_HORSES:
                return HORSE_ID.get(random.nextInt(HORSE_ID.size()));
            case DEFAULT_MOBS:
            default:
                return MOB_ID.get(random.nextInt(MOB_ID.size()));
        }
    }

    public static boolean spawnMob(World world, net.minecraft.entity.Entity mob, double x, double y, double z, boolean checkSpawn) {
        float rotation = world.rand.nextFloat() * 360;
        return spawnMob(world, mob, x, y, z, rotation, checkSpawn);
    }

    /**
     * Spawn mob in world
     *
     * @param world World object
     * @param mob   Spawned mob
     * @param x     X coordinate
     * @param y     Y coordinate
     * @param z     Z coordinate
     */
    public static boolean spawnMob(World world, net.minecraft.entity.Entity mob, double x, double y, double z, float rotation, boolean checkSpawn) {
        EntityLiving livingEntity = (EntityLiving) mob;
        boolean canSpawn = false;
        double xPosition = x + 0.5;
        double yPosition = y;
        double zPosition = z + 0.5;
        mob.setLocationAndAngles(xPosition, yPosition, zPosition, rotation, 0);

        if (!checkSpawn || livingEntity.getCanSpawnHere()) {
            canSpawn = true;
        } else {
            if (!(mob instanceof EntityZombie)) {
                xPosition += 1;
                mob.setLocationAndAngles(xPosition, yPosition, zPosition, rotation, 0);

                if (livingEntity.getCanSpawnHere()) {
                    canSpawn = true;
                } else {
                    xPosition -= 1;
                    zPosition += 1;
                    mob.setLocationAndAngles(xPosition, yPosition, zPosition, rotation, 0);

                    if (livingEntity.getCanSpawnHere()) {
                        canSpawn = true;
                    } else {
                        zPosition -= 2;
                        mob.setLocationAndAngles(xPosition, yPosition, zPosition, rotation, 0);

                        if (livingEntity.getCanSpawnHere()) {
                            canSpawn = true;
                        } else {
                            xPosition -= 1;
                            zPosition += 1;
                            mob.setLocationAndAngles(xPosition, yPosition, zPosition, rotation, 0);

                            if (livingEntity.getCanSpawnHere()) {
                                canSpawn = true;
                            }
                        }
                    }
                }
            }
        }

        if (canSpawn) {
            xPosition = x + world.rand.nextFloat();
            yPosition = y + world.rand.nextFloat();
            zPosition = z + world.rand.nextFloat();
            world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, xPosition, yPosition + 2, zPosition, 0.0D, 0.0D, 0.0D);
            world.spawnParticle(EnumParticleTypes.FLAME, xPosition, yPosition + 1, zPosition, 0.0D, 0.0D, 0.0D);
            world.spawnEntity(mob);
            world.playEvent(2004, new BlockPos(x, y, z), 0);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check spawn mob or
     */
    public static boolean checkChance(Random random) {
        return random.nextInt(100) < ExtendedConfig.spawnChance;
    }

    /**
     * Return random mob for spawner
     */
    public static ResourceLocation getMobForSkeletonSpawner(Random random) {
        return skeletonSpawnerMobs.get(random.nextInt(skeletonSpawnerMobs.size()));
    }

    public static ResourceLocation getMobForZombieSpawner(Random random) {
        return zombieSpawnerMobs.get(random.nextInt(zombieSpawnerMobs.size()));
    }

    /**
     * Return random mob for spawner
     */
    public static ResourceLocation getMobForStatueSpawner(Random random) {
        return catacombsStatuesMobs.get(random.nextInt(catacombsStatuesMobs.size()));
    }

    public static void spawnCrawler(net.minecraft.entity.Entity entity, EntitySkullCrawler crawler) {
        if (entity.getEntityWorld().rand.nextInt(10) == 0) {
            MobSpawn.spawnMob(entity.getEntityWorld(), crawler,
                    (int) Math.floor(entity.posX), entity.posY + 1.5, (int) Math.floor(entity.posZ),
                    entity.rotationYaw, false);
        }
    }

    public enum EnumMobType {

        DEFAULT_MOBS,
        HELL_MOBS,
        UNDEAD_DOGS,
        UNDEAD_CATS,
        UNDEAD_HORSES
    }
}