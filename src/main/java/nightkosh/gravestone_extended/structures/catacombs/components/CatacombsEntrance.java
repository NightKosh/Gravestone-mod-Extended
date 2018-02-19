package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatacombsEntrance extends CatacombsBaseComponent {

    public static final int X_LENGTH = 4;
    private int stairsLength;
    private int corridorLength;

    public CatacombsEntrance(EnumFacing direction, int level, Random random, int x, int y, int z) {
        this(direction, random, x, y, z);
    }

    public CatacombsEntrance(EnumFacing direction, Random random, int x, int y, int z) {
        super(0, direction);
        stairsLength = 4 + random.nextInt(4);
        corridorLength = 2;

        Passage entrance = new Passage(this, 0, 0, 0);
        this.setEntrance(entrance);

        this.addExit(new Passage(this, 0, 0, stairsLength * 3 + 3, ComponentSide.FRONT));

        boundingBox = BoundingBoxHelper.getCorrectBox(direction, x, y - stairsLength * 3, z, X_LENGTH, stairsLength * 3, stairsLength * 3 + 3, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        int top = boundingBox.maxY - boundingBox.minY - 1;
        IBlockState netherBrickStairsBotState = StateHelper.NETHER_BRICK_STAIRS_SOUTH;

        IBlockState stairsTopState = StateHelper.getStairs(StateHelper.STONE_BRICK_STAIRS_TOP, EnumFacing.NORTH);
        int shiftY = top;
        int shiftZ = 0;
        int i;

        for (i = 0; i < stairsLength; i++) {
            shiftZ = i * 3;
            shiftY = top - i * 3 + 1;
            this.fillWithAir(world, boundingBox, 1, shiftY, shiftZ, 2, shiftY, shiftZ + 3);
            this.fillWithAir(world, boundingBox, 1, shiftY - 1, shiftZ + 1, 2, shiftY - 1, shiftZ + 4);
            this.fillWithAir(world, boundingBox, 1, shiftY - 2, shiftZ + 2, 2, shiftY - 2, shiftZ + 5);

            // nether walls
            this.fillWithBlocks(world, boundingBox, 0, shiftY, shiftZ, 0, shiftY + 4, shiftZ, StateHelper.NETHER_BRICK);
            this.fillWithBlocks(world, boundingBox, 3, shiftY, shiftZ, 3, shiftY + 4, shiftZ, StateHelper.NETHER_BRICK);

            // block walls
            this.fillWithRandomizedBlocks(world, boundingBox, 0, shiftY - 2, shiftZ + 1, 0, shiftY + 3, shiftZ + 2, false, random, stoneBricks);
            this.fillWithRandomizedBlocks(world, boundingBox, 3, shiftY - 2, shiftZ + 1, 3, shiftY + 3, shiftZ + 2, false, random, stoneBricks);

            // nether stairs
            this.fillWithBlocks(world, boundingBox, 1, shiftY, shiftZ, 2, shiftY, shiftZ, netherBrickStairsBotState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 1, shiftZ + 1, 2, shiftY - 1, shiftZ + 1, netherBrickStairsBotState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 2, shiftZ + 2, 2, shiftY - 2, shiftZ + 2, netherBrickStairsBotState);

            // block stairs
            this.fillWithBlocks(world, boundingBox, 1, shiftY, shiftZ + 4, 2, shiftY, shiftZ + 4, stairsTopState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 1, shiftZ + 5, 2, shiftY - 1, shiftZ + 5, stairsTopState);
            this.fillWithBlocks(world, boundingBox, 1, shiftY - 2, shiftZ + 6, 2, shiftY - 2, shiftZ + 6, stairsTopState);
        }

        shiftY += 1;
        shiftZ += 3;
        int zLength = 3;
        this.fillWithAir(world, boundingBox, 1, shiftY - 2, shiftZ, 2, shiftY - 1, shiftZ);
        this.fillWithAir(world, boundingBox, 1, shiftY - 3, shiftZ + 1, 2, shiftY - 1, shiftZ + zLength);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 0, shiftY, shiftZ, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 3, shiftY, shiftZ, boundingBox);

        // ceiling
        this.fillWithBlocks(world, boundingBox, 0, shiftY, shiftZ + 1, 3, shiftY, shiftZ + zLength, StateHelper.NETHER_BRICK);

        // trap floor
        this.fillWithBlocks(world, boundingBox, 0, shiftY - 4, shiftZ, 3, shiftY - 4, shiftZ + zLength, StateHelper.NIGHTSTONE);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 0, shiftY - 3, shiftZ, 0, shiftY - 1, shiftZ, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, shiftY - 3, shiftZ, 3, shiftY - 1, shiftZ, StateHelper.NETHER_BRICK);

        // block walls
        this.fillWithRandomizedBlocks(world, boundingBox, 0, shiftY - 3, shiftZ + 1, 0, shiftY - 1, shiftZ + 2, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 3, shiftY - 3, shiftZ + 1, 3, shiftY - 1, shiftZ + 2, false, random, stoneBricks);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, this.WEB_GENERATION_CHANCE, 1, shiftY - 3, shiftZ, 2, shiftY - 1, shiftZ + 2, StateHelper.WEB, false);
        shiftZ += 3;

        this.fillWithRandomizedBlocks(world, boundingBox, 1, shiftY - 3, shiftZ, 2, shiftY - 1, shiftZ, false, random, stoneBricks);

        return true;
    }
}