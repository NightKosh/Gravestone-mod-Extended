package nightkosh.gravestone_extended.structures;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MobSpawnHelper {

    private MobSpawnHelper() {
    }

    /**
     * Spawn bats
     *
     * @param world       World object
     * @param random
     * @param boundingBox Bounding box
     */
//    public static void spawnBats(World world, Random random, StructureBoundingBox boundingBox) {
//        EntityBat bat;
//        int batsCount = 3 + random.nextInt(8);
//
//        for (byte i = 0; i < batsCount; i++) {
//            bat = new EntityBat(world);
//            Vec3i center = boundingBox.getLength();
//            bat.setLocationAndAngles(center.getX() - 1.5 + random.nextInt(5), center.getY(),
//                    center.getZ() - 1.5 + random.nextInt(5), 0, 0);
//
//            if (bat.getCanSpawnHere()) {
//                world.spawnEntity(bat);
//            }
//        }
//    }
}