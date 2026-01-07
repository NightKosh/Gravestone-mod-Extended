package nightkosh.gravestone_extended.structures.catacombs.components;

import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MausoleumEntrance extends CatacombsBaseComponent {

    private int offsetY;

//    public MausoleumEntrance(EnumFacing direction, Random random, StructureBoundingBox structureBoundingBox, int offsetY) {
//        super(0, direction);
//        this.boundingBox = structureBoundingBox;
//        this.offsetY = offsetY;
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
//        this.boundingBox.offset(0, averageGroundLevel - this.boundingBox.minY - 1, 0);
//
//        if (this.offsetY + 1 > this.boundingBox.minY) {
//            this.boundingBox.offset(0, this.offsetY + 1 - this.boundingBox.minY, 0);
//        }
//
//        IBlockState netherBrickStairsTopState = StateHelper.NETHER_BRICK_STAIRS_SOUTH;
//        IBlockState netherBrickStairsBotState = StateHelper.NETHER_BRICK_STAIRS_NORTH;
//        IBlockState netherBrickStairsLeftState = StateHelper.NETHER_BRICK_STAIRS_EAST;
//        IBlockState netherBrickStairsRightState = StateHelper.NETHER_BRICK_STAIRS_WEST;
//        this.fillWithAir(world, boundingBox, 0, 0, 6, 13, 5, 13);
//
//        // fire
//        this.placeBlockAtCurrentPosition(world, StateHelper.NETHERRACK, 4, 0, 9, boundingBox);
//        this.placeBlockAtCurrentPosition(world, StateHelper.FIRE, 4, 1, 9, boundingBox);
//
//        // fire stairs
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 3, 0, 8, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 4, 0, 8, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 5, 0, 8, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, 3, 0, 9, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, 5, 0, 9, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 3, 0, 10, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 4, 0, 10, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 5, 0, 10, boundingBox);
//
//        for (int x = 3; x < 5; x++) {
//            for (int z = 8; z < 10; z++) {
//                this.fillDownwards(world, StateHelper.NETHER_BRICK, x, -1, z, boundingBox);
//            }
//        }
//
//        // fire
//        this.placeBlockAtCurrentPosition(world, StateHelper.NETHERRACK, 9, 0, 9, boundingBox);
//        this.placeBlockAtCurrentPosition(world, StateHelper.FIRE, 9, 1, 9, boundingBox);
//
//        // fire stairs
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 8, 0, 8, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 9, 0, 8, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 10, 0, 8, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, 8, 0, 9, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, 10, 0, 9, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 8, 0, 10, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 9, 0, 10, boundingBox);
//        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 10, 0, 10, boundingBox);
//
//        for (int x = 3; x < 6; x++) {
//            for (int z = 8; z < 11; z++) {
//                this.fillDownwards(world, StateHelper.NETHER_BRICK, x, -1, z, boundingBox);
//            }
//        }
//
//        for (int x = 8; x < 11; x++) {
//            for (int z = 8; z < 11; z++) {
//                this.fillDownwards(world, StateHelper.NETHER_BRICK, x, -1, z, boundingBox);
//            }
//        }
//
//        return true;
//    }
}
