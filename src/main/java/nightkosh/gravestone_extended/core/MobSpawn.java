package nightkosh.gravestone_extended.core;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MobSpawn {

//    /**
//     * Check can grave spawn hell creature or not
//     *
//     * @param world
//     * @param x     X coordinate
//     * @param y     Y coordinate
//     * @param z     Z coordinate
//     */
//    private static boolean canSpawnHellCreatures(World world, int x, int y, int z) {
//        return world != null && y < HELL_HEIGHT && world.getBlockState(new BlockPos(x, y - 1, z)).getBlock().equals(Blocks.NETHER_BRICK);
//    }
//
//    /**
//     * will create the entity from the internalID the first time it is accessed
//     */
//    public static net.minecraft.entity.Entity getMobEntity(World world, EnumGraves graveType, int x, int y, int z) {
//        ResourceLocation id;
//
//        switch (graveType.getGraveType()) {
//            case DOG_STATUE:
//                id = getMobID(world.rand, EnumMobType.UNDEAD_DOGS);
//                break;
//            case CAT_STATUE:
//                id = getMobID(world.rand, EnumMobType.UNDEAD_CATS);
//                break;
//            case HORSE_STATUE:
//                id = getMobID(world.rand, EnumMobType.UNDEAD_HORSES);
//                break;
//            default:
//                if (canSpawnHellCreatures(world, x, y, z) && world.rand.nextInt(10) == 0) {
//                    id = getMobID(world.rand, EnumMobType.HELL_MOBS);
//
//                    if (id.equals(GSEntity.SKELETON_ID)) {
//                        EntityGSSkeleton skeleton = getSkeleton(world, RANDOM.nextBoolean());
//                        skeleton.setSkeletonType(SkeletonType.WITHER);
//                        return skeleton;
//                    }
//                } else {
//                    id = getMobID(world.rand, EnumMobType.DEFAULT_MOBS);
//
//                    if (id.equals(GSEntity.SKELETON_ID)) {
//                        EntityGSSkeleton skeleton = getSkeleton(world, RANDOM.nextBoolean());
//                        if (RANDOM.nextInt(5) == 0) {
//                            skeleton.setSkeletonType(SkeletonType.STRAY);
//                        }
//                        return skeleton;
//                    }
//
//                    if (id.equals(GSEntity.MINECRAFT_ZOMBIE_ID) && world.rand.nextInt(5) == 0) {
//                        return EntityList.createEntityByIDFromName(GSEntity.MINECRAFT_HUSK_ID, world);
//                    }
//                }
//                break;
//        }
//
//        EntityLiving entity = (EntityLiving) EntityList.createEntityByIDFromName(id, world);
//
//        if (entity == null) {
//            entity = getForeinMob(world, id);
//        }
//
//        try {
//            entity.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(x, y, z)), null);
//        } catch (Exception e) {
//            GSLogger.logError("getMobEntity exception with onSpawnWithEgg");
//            e.printStackTrace();
//        }
//
//        return entity;
//    }

    public enum EnumMobType {

        DEFAULT_MOBS,
        HELL_MOBS,
        UNDEAD_DOGS,
        UNDEAD_CATS,
        UNDEAD_HORSES
    }
}