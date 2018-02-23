package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.ObjectsGenerationHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Crossing extends CatacombsBaseComponent {

    public Crossing(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        xLength = 13;
        height = 6;
        zLength = 13;

        Passage entrance = new Passage(this, 4, 0, 0);
        this.setEntrance(entrance);

        this.addRequiredExit(Passage.getFrontExit(this, 4, 0, 12));
        this.addRequiredExit(Passage.getSideExit(this, 0, 0, 4, ComponentSide.LEFT, facing));
        this.addRequiredExit(Passage.getSideExit(this, xLength - 1, 0, 4, ComponentSide.RIGHT, facing));

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y, z, xLength, height, zLength, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        this.fillWithAir(world, boundingBox, 1, 1, 1, 11, 4, 11);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 1, 1, 1, 11, 4, 11, StateHelper.WEB, false);
        // piles of bones
        if (ExtendedConfig.generatePilesOfBones) {
            this.fillWithRandomizedPilesOfBones(world, boundingBox, 1, 1, 1, 12, 1, 12, false, random);
        }

        // trap floor
        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 0, 0, 12, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 4, 0, 0, 4, 0, 12, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 8, 0, 0, 8, 0, 12, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 12, 0, 0, 12, 0, 12, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 1, 0, 0, 11, 0, 0, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 1, 0, 4, 11, 0, 4, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 1, 0, 8, 11, 0, 8, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 1, 0, 12, 11, 0, 12, StateHelper.NIGHTSTONE);

        // stoneBrick floor
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 0, 1, 3, 0, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 0, 5, 3, 0, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 0, 9, 3, 0, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 0, 1, 7, 0, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 0, 9, 7, 0, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 0, 1, 11, 0, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 0, 5, 11, 0, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 0, 9, 11, 0, 11, false, random, stoneBricks);

        // nether ceiling
        this.fillWithBlocks(world, boundingBox, 0, 5, 0, 0, 5, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 4, 5, 0, 4, 5, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 8, 5, 0, 8, 5, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 5, 0, 12, 5, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 5, 0, 11, 5, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 5, 4, 11, 5, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 5, 8, 11, 5, 8, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 5, 12, 11, 5, 12, StateHelper.NETHER_BRICK);

        // stoneBrick ceiling
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 5, 1, 3, 5, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 5, 5, 3, 5, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 5, 9, 3, 5, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 5, 1, 7, 5, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 5, 9, 7, 5, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 5, 1, 11, 5, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 5, 5, 11, 5, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 5, 9, 11, 5, 11, false, random, stoneBricks);

        // cutted stoneBrick floor and ceiling
        this.fillWithBlocks(world, boundingBox, 5, 0, 5, 7, 0, 7, StateHelper.STONEBRICK_CHISELED);
        this.fillWithBlocks(world, boundingBox, 5, 5, 5, 7, 5, 7, StateHelper.STONEBRICK_CHISELED);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 0, 1, 0, 0, 4, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 0, 12, 4, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 12, 11, 4, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 0, 11, 4, 0, StateHelper.NETHER_BRICK);

        // columns
        this.fillWithRandomizedBlocks(world, boundingBox, 4, 1, 8, 4, 4, 8, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 4, 1, 4, 4, 4, 4, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 8, 1, 8, 8, 4, 8, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 8, 1, 4, 8, 4, 4, false, random, stoneBricks);

        // fire
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHERRACK, 1, 1, 11, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHERRACK, 1, 1, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHERRACK, 11, 1, 11, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHERRACK, 11, 1, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.FIRE, 1, 2, 11, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.FIRE, 1, 2, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.FIRE, 11, 2, 11, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.FIRE, 11, 2, 1, boundingBox);

        // fire stairs
        IBlockState netherBrickStairsTopState = StateHelper.NETHER_BRICK_STAIRS_SOUTH;
        IBlockState netherBrickStairsBotState = StateHelper.NETHER_BRICK_STAIRS_NORTH;
        IBlockState netherBrickStairsLeftState = StateHelper.NETHER_BRICK_STAIRS_EAST;
        IBlockState netherBrickStairsRightState = StateHelper.NETHER_BRICK_STAIRS_WEST;
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 1, 1, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, 2, 1, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, 2, 1, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, 11, 1, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, 10, 1, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, 10, 1, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 1, 1, 10, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, 2, 1, 10, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, 2, 1, 11, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, 11, 1, 10, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, 10, 1, 10, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, 10, 1, 11, boundingBox);

        // fill exit
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 1, 12, 7, 3, 12, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 1, 5, 0, 3, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 1, 5, 12, 3, 7, false, random, stoneBricks);

        // clear enter
        this.fillWithAir(world, boundingBox, 5, 1, 0, 7, 3, 0);

        // spawner
        ObjectsGenerationHelper.generateSpawner(this, world, random, 6, 1, 6);

        return true;
    }
}
