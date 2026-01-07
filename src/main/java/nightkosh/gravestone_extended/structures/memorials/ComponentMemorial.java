package nightkosh.gravestone_extended.structures.memorials;

import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.ComponentGraveStone;
import nightkosh.gravestone_extended.structures.MemorialGenerationHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ComponentMemorial extends ComponentGraveStone {

    public static final int X_LENGTH = 3;
    public static final int HEIGHT = 7;
    public static final int Z_LENGTH = 3;

//    public ComponentMemorial(int componentType, EnumFacing direction, Random random, int x, int z) {
//        super(componentType, direction);
//        boundingBox = BoundingBoxHelper.getCorrectBox(direction, x, 64, z, X_LENGTH, HEIGHT, Z_LENGTH);
//    }
//
//    /**
//     * Build component
//     */
//    @Override
//    public boolean addComponentParts(World world, Random random) {
//        int averageGroundLevel = BoundingBoxHelper.getAverageGroundLevel(world, boundingBox);
//
//        if (averageGroundLevel < 0) {
//            return true;
//        }
//
//        this.boundingBox.offset(0, averageGroundLevel - boundingBox.maxY + HEIGHT - 1, 0);
//
//        IBlockState groundState, undergroundState;
//        BlockPos pos = new BlockPos(getXWithOffset(0, 0), getYWithOffset(0), getZWithOffset(0, 0));
//        Biome biome = world.getBiome(pos);
//
//        if (biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS || biome == Biomes.BEACH) {
//            groundState = StateHelper.SAND;
//            undergroundState = StateHelper.SAND;
//        } else {
//            groundState = StateHelper.GRASS;
//            undergroundState = StateHelper.DIRT;
//        }
//
//        this.fillWithAir(world, boundingBox, 0, 0, 2, 0, 6, 2);
//        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 2, 0, 2, groundState);
//        MemorialGenerationHelper.placeMemorial(this, world, random, 1, 1, 1, this.getCoordBaseMode().getOpposite());
//
//        for (int x = 0; x < 3; x++) {
//            for (int z = 0; z < 3; z++) {
//                this.setBlockState(world, undergroundState, x, -1, z, boundingBox);
//            }
//        }
//
//        for (int x = 0; x < 3; x++) {
//            for (int z = 0; z < 3; z++) {
//                this.clearCurrentPositionBlocksUpwards(world, x, HEIGHT, z, boundingBox);
//            }
//        }
//
//        return true;
//    }
}