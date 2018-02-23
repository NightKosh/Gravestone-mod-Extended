package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone.helper.GraveGenerationHelper.EnumGraveTypeByEntity;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.GraveGenerationHelper;
import nightkosh.gravestone_extended.structures.MobSpawnHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveHall extends CatacombsBaseComponent {

    public GraveHall(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        xLength = 16;
        height = 5;
        zLength = 18;

        Passage entrance = new Passage(this, 6, 0, 0);

        this.setEntrance(entrance);
        this.addExit(Passage.getFrontExit(this, 6, 0, zLength));

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y, z, xLength, height, zLength, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        this.fillWithAir(world, boundingBox, 1, 1, 1, 15, 5, 17);
        this.fillWithAir(world, boundingBox, 7, 1, 0, 9, 3, 1);
        this.fillWithAir(world, boundingBox, 7, 1, 17, 9, 3, 17);

        // fill exit
        this.fillWithRandomizedBlocks(world, boundingBox, 7, 1, 18, 9, 3, 18, false, random, stoneBricks);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 3, 1, 3, 13, 5, 15, StateHelper.WEB, false);
        // piles of bones
        if (ExtendedConfig.generatePilesOfBones) {
            this.fillWithRandomizedPilesOfBones(world, boundingBox, 3, 1, 3, 13, 1, 15, false, random);
        }

        // nether floor
        this.fillWithBlocks(world, boundingBox, 1, 0, 1, 1, 0, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 15, 0, 1, 15, 0, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 0, 3, 5, 0, 15, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 11, 0, 3, 11, 0, 15, StateHelper.NETHER_BRICK);

        // nether floor lines
        this.fillWithBlocks(world, boundingBox, 2, 0, 1, 14, 0, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 0, 6, 14, 0, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 0, 12, 14, 0, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 0, 17, 14, 0, 17, StateHelper.NETHER_BRICK);

        // floor entrance
        this.fillWithBlocks(world, boundingBox, 5, 0, 0, 11, 0, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 0, 16, 11, 0, 18, StateHelper.NETHER_BRICK);

        // block floor
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 2, 4, 0, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 0, 3, 10, 0, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 0, 2, 14, 0, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 7, 4, 0, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 0, 7, 10, 0, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 0, 7, 14, 0, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 13, 4, 0, 16, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 0, 13, 10, 0, 15, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 0, 13, 14, 0, 16, false, random, stoneBricks);

        // nether ceiling
        this.fillWithBlocks(world, boundingBox, 1, 6, 1, 1, 6, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 15, 6, 1, 15, 6, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 6, 3, 5, 6, 15, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 11, 6, 3, 11, 6, 15, StateHelper.NETHER_BRICK);

        // nether ceiling lines
        this.fillWithBlocks(world, boundingBox, 2, 6, 1, 14, 6, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 6, 6, 14, 6, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 6, 12, 14, 6, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 6, 17, 14, 6, 17, StateHelper.NETHER_BRICK);

        // ceiling entrance
        this.fillWithBlocks(world, boundingBox, 5, 4, 0, 11, 6, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 4, 16, 11, 6, 18, StateHelper.NETHER_BRICK);

        // block ceiling
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 6, 2, 4, 6, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 6, 3, 10, 6, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 6, 2, 14, 6, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 6, 7, 4, 6, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 6, 7, 10, 6, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 6, 7, 14, 6, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 6, 13, 4, 6, 16, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 6, 13, 10, 6, 15, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 6, 13, 14, 6, 16, false, random, stoneBricks);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 1, 1, 1, 1, 5, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 15, 1, 1, 15, 5, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 6, 1, 5, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 15, 1, 6, 15, 5, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 12, 1, 5, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 15, 1, 12, 15, 5, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 17, 1, 5, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 15, 1, 17, 15, 5, 17, StateHelper.NETHER_BRICK);

        // nether walls lines
        this.fillWithBlocks(world, boundingBox, 1, 3, 1, 1, 3, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 15, 3, 1, 15, 3, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 3, 1, 4, 3, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 3, 1, 14, 3, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 3, 17, 4, 3, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 3, 17, 14, 3, 17, StateHelper.NETHER_BRICK);

        // nether wall entrance
        this.fillWithBlocks(world, boundingBox, 5, 1, 0, 6, 3, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 1, 0, 11, 3, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 1, 16, 6, 3, 18, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 1, 16, 11, 3, 18, StateHelper.NETHER_BRICK);

        // block walls
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 0, 0, 6, 18, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 16, 0, 0, 16, 6, 18, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 0, 4, 6, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 0, 0, 16, 6, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 18, 4, 6, 18, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 0, 18, 16, 6, 18, false, random, stoneBricks);

        // columns
        buildColumn(world, 5, 6);
        buildColumn(world, 11, 6);
        buildColumn(world, 5, 12);
        buildColumn(world, 11, 12);

        // graves
        IBlockState leftGraveState = StateHelper.getGravestone(this.getLeftDirectionForBlocks());
        IBlockState rightGraveState = StateHelper.getGravestone(this.getRightDirectionForBlocks());
        IBlockState topGraveState = StateHelper.getGravestone(this.getCoordBaseMode().getOpposite());
        IBlockState botGraveState = StateHelper.getGravestone(this.getCoordBaseMode());

        EntityGroupOfGravesMobSpawnerHelper spawnerHelper = GraveGenerationHelper.createSpawnerHelper(world, this.boundingBox);

        // left wall
        GraveGenerationHelper.placeGrave(this, world, random, 1, 1, 2, leftGraveState, spawnerHelper);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 1, 5, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 1, 8, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 1, 10, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 1, 13, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 1, 16, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 4, 2, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 4, 5, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 4, 8, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 4, 10, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 4, 13, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 1, 4, 16, leftGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);

        // right wall
        GraveGenerationHelper.placeGrave(this, world, random, 15, 1, 2, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 1, 5, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 1, 8, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 1, 10, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 1, 13, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 1, 16, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 4, 2, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 4, 5, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 4, 8, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 4, 10, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 4, 13, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 15, 4, 16, rightGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        // top walls
        GraveGenerationHelper.placeGrave(this, world, random, 3, 1, 17, topGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 13, 1, 17, topGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 3, 4, 17, topGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 13, 4, 17, topGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);

        // bot walls
        GraveGenerationHelper.placeGrave(this, world, random, 3, 1, 1, botGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 13, 1, 1, botGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 3, 4, 1, botGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
        GraveGenerationHelper.placeGrave(this, world, random, 13, 4, 1, botGraveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);

        // trap floor
        this.fillWithBlocks(world, boundingBox, 7, 0, 6, 9, 0, 6, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 7, 0, 12, 9, 0, 12, StateHelper.NIGHTSTONE);

        // spawn bats
        MobSpawnHelper.spawnBats(world, random, boundingBox);

        return true;
    }

    private void buildColumn(World world, int x, int z) {
        this.fillWithBlocks(world, boundingBox, x, 1, z, x, 5, z, StateHelper.NETHER_BRICK);
        IBlockState netherBrickStairsTopState = StateHelper.NETHER_BRICK_STAIRS_SOUTH;
        IBlockState netherBrickStairsBotState = StateHelper.NETHER_BRICK_STAIRS_NORTH;
        IBlockState netherBrickStairsLeftState = StateHelper.NETHER_BRICK_STAIRS_EAST;
        IBlockState netherBrickStairsRightState = StateHelper.NETHER_BRICK_STAIRS_WEST;

        // stairs
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, x - 1, 1, z - 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, x, 1, z - 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, x + 1, 1, z - 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, x - 1, 1, z, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, x + 1, 1, z, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, x - 1, 1, z + 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, x, 1, z + 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, x + 1, 1, z + 1, boundingBox);

        // stairs top
        netherBrickStairsTopState = netherBrickStairsTopState.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        netherBrickStairsBotState = netherBrickStairsBotState.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        netherBrickStairsLeftState = netherBrickStairsLeftState.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        netherBrickStairsRightState = netherBrickStairsRightState.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, x - 1, 5, z - 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, x, 5, z - 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsBotState, x + 1, 5, z - 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsLeftState, x - 1, 5, z, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsRightState, x + 1, 5, z, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, x - 1, 5, z + 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, x, 5, z + 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, netherBrickStairsTopState, x + 1, 5, z + 1, boundingBox);
    }
}
