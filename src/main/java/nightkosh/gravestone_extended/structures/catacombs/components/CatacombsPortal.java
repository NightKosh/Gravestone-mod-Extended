package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.block.BlockStairs;
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
public class CatacombsPortal extends CatacombsBaseComponent {

    public static final int X_LENGTH = 23;
    public static final int HEIGHT = 14;
    public static final int Z_LENGTH = 23;

    public CatacombsPortal(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);
        Passage entrance = new Passage(this, 9, 0, 0);

        this.setEntrance(entrance);
        this.addRequiredExit(new Passage(this, 9, 7, Z_LENGTH - 1, ComponentSide.FRONT));

        switch (facing) {
            case SOUTH:
                this.addRequiredExit(new Passage(this, X_LENGTH - 1, 7, 9, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, 0, 7, 9, ComponentSide.RIGHT, true));
                break;
            case NORTH:
                this.addRequiredExit(new Passage(this, 0, 7, 13, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, X_LENGTH - 1, 7, 13, ComponentSide.RIGHT, true));
                break;
            case WEST:
                this.addRequiredExit(new Passage(this, X_LENGTH - 1, 7, 13, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, 0, 7, 13, ComponentSide.RIGHT, true));
                break;
            case EAST:
                this.addRequiredExit(new Passage(this, 0, 7, 9, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, X_LENGTH - 1, 7, 9, ComponentSide.RIGHT, true));
                break;
        }

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y - HEIGHT + 7, z, X_LENGTH, HEIGHT, Z_LENGTH, entrance);
    }

    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();

        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 22, 13, 22, StateHelper.NETHER_BRICK);
        this.fillWithAir(world, boundingBox, 2, 2, 2, 20, 12, 20);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 2, 4, 2, 20, 12, 20, StateHelper.WEB, false);


        // floor
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 1, 2, 20, 1, 20, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 1, 1, 21, 1, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 5, 21, 1, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 9, 21, 1, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 13, 21, 1, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 17, 21, 1, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 21, 21, 1, 21, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 1, 2, 1, 1, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 1, 2, 5, 1, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 2, 9, 1, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 13, 1, 2, 13, 1, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 17, 1, 2, 17, 1, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 1, 2, 21, 1, 21, StateHelper.NETHER_BRICK);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 9, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 13, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 0, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 13, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 0, 13, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 9, 0, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 13, 0, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 0, 17, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 13, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 17, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 17, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 13, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 17, 1, 13, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 13, 1, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 17, 1, 17, boundingBox);

        this.fillWithBlocks(world, boundingBox, 2, 2, 2, 20, 3, 20, StateHelper.TOXIC_WATER);

        // ceiling
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 13, 2, 20, 13, 20, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 13, 1, 21, 13, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 5, 21, 13, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 9, 21, 13, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 13, 21, 13, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 17, 21, 13, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 21, 21, 13, 21, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 13, 2, 1, 13, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 13, 2, 5, 13, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 13, 2, 9, 13, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 13, 13, 2, 13, 13, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 17, 13, 2, 17, 13, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 13, 2, 21, 13, 20, StateHelper.NETHER_BRICK);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 13, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 13, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 13, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 13, 17, boundingBox);

        //walls
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 2, 2, 1, 12, 20, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 21, 2, 2, 21, 12, 20, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 2, 1, 20, 12, 1, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 2, 21, 20, 12, 21, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 7, 2, 1, 7, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 7, 2, 21, 7, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 7, 1, 20, 7, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 7, 21, 20, 7, 21, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 2, 1, 1, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 2, 1, 5, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 1, 9, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 13, 2, 1, 13, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 17, 2, 1, 17, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 2, 1, 21, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 21, 1, 12, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 2, 21, 5, 12, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 21, 9, 12, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 13, 2, 21, 13, 12, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 17, 2, 21, 17, 12, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 2, 21, 21, 12, 21, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 2, 5, 1, 12, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 9, 1, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 13, 1, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 17, 1, 12, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 2, 5, 21, 12, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 2, 9, 21, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 2, 13, 21, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 2, 17, 21, 12, 17, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 9, 7, 9, 9, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 13, 7, 9, 13, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 7, 13, 9, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 13, 7, 13, 13, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 2, 9, 12, 6, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 10, 13, 6, 12, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 2, 2, 2, 2, 12, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 2, 20, 12, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 2, 20, 2, 12, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 20, 20, 12, 20, StateHelper.NETHER_BRICK);

        //wall lanterns
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 0, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 0, 7, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 1, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 1, 7, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 22, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 22, 7, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 21, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 21, 7, 17, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 7, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 7, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 7, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 17, 7, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 7, 22, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 17, 7, 22, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 7, 21, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 17, 7, 21, boundingBox);

        //wall water
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 1, 10, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 1, 10, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 21, 10, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 21, 10, 17, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 5, 10, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 17, 10, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 5, 10, 21, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 17, 10, 21, boundingBox);

        // entrance
        this.fillWithBlocks(world, boundingBox, 9, 7, 0, 13, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 8, 1, 12, 11, 1, StateHelper.getCatacombsPortal(EnumFacing.EAST));
        this.fillWithBlocks(world, boundingBox, 10, 8, 0, 12, 11, 0, StateHelper.SEA_LANTERN);

        // exits
        this.fillWithBlocks(world, boundingBox, 9, 7, 21, 13, 12, 22, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 8, 21, 12, 10, 21, StateHelper.IRON_BARS);

        this.fillWithBlocks(world, boundingBox, 0, 7, 9, 1, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 8, 10, 1, 10, 12, StateHelper.IRON_BARS);

        this.fillWithBlocks(world, boundingBox, 21, 7, 9, 22, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 21, 8, 10, 21, 10, 12, StateHelper.IRON_BARS);

        //
        this.fillWithBlocks(world, boundingBox, 5, 12, 4, 5, 12, 18, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 17, 12, 4, 17, 12, 18, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 4, 12, 5, 18, 12, 5, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 4, 12, 17, 18, 12, 17, StateHelper.NETHERBRICK_SLAB_TOP);

        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 5, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 5, 12, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 17, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 17, 12, 17, boundingBox);

        IBlockState stairsTopF = StateHelper.NETHER_BRICK_STAIRS_SOUTH.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsTopB = StateHelper.NETHER_BRICK_STAIRS_NORTH.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsLeft = StateHelper.NETHER_BRICK_STAIRS_EAST.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsRight = StateHelper.NETHER_BRICK_STAIRS_WEST.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);

        this.fillWithBlocks(world, boundingBox, 3, 12, 20, 19, 12, 20, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 3, 12, 2, 19, 12, 2, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 2, 12, 3, 2, 12, 19, stairsRight);
        this.fillWithBlocks(world, boundingBox, 20, 12, 3, 20, 12, 19, stairsLeft);

        this.placeBlockAtCurrentPosition(world, stairsRight, 2, 11, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsRight, 3, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 2, 12, 5, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsRight, 2, 11, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsRight, 3, 12, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 2, 12, 17, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsLeft, 20, 11, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsLeft, 19, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 20, 12, 5, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsLeft, 20, 11, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsLeft, 19, 12, 17, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 20, 12, 17, boundingBox);


        this.placeBlockAtCurrentPosition(world, stairsTopF, 5, 11, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopF, 5, 12, 3, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 5, 12, 2, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopF, 17, 11, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopF, 17, 12, 3, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 17, 12, 2, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopB, 5, 11, 20, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopB, 5, 12, 19, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 5, 12, 20, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopB, 17, 11, 20, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopB, 17, 12, 19, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 17, 12, 20, boundingBox);


        // bridge
        this.fillWithBlocks(world, boundingBox, 10, 7, 2, 12, 7, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 2, 13, 7, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 20, 13, 7, 20, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 9, 8, 14, 9, 8, 20, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 9, 12, 14, 9, 12, 20, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 13, 8, 14, 13, 8, 20, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 13, 12, 14, 13, 12, 20, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 9, 9, 20, 9, 11, 20, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 13, 9, 20, 13, 11, 20, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 9, 8, 2, 9, 8, 8, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 9, 12, 2, 9, 12, 8, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 13, 8, 2, 13, 8, 8, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 13, 12, 2, 13, 12, 8, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 9, 9, 2, 9, 11, 2, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 13, 9, 2, 13, 11, 2, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 9, 11, 3, 9, 11, 8, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 9, 11, 14, 9, 11, 19, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 13, 11, 3, 13, 11, 8, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 13, 11, 14, 13, 11, 19, StateHelper.NETHERBRICK_SLAB_TOP);

        this.fillWithBlocks(world, boundingBox, 9, 7, 3, 9, 7, 19, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 13, 7, 3, 13, 7, 19, stairsRight);


        this.fillWithBlocks(world, boundingBox, 10, 6, 7, 12, 6, 7, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 5, 8, 12, 5, 8, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 6, 18, 12, 6, 19, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 5, 19, 12, 5, 20, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 10, 6, 3, 12, 6, 4, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 5, 3, 12, 5, 3, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 6, 14, 12, 6, 15, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 5, 14, 12, 5, 14, stairsTopF);


        this.fillWithBlocks(world, boundingBox, 7, 6, 10, 7, 6, 12, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 8, 5, 10, 8, 5, 12, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 18, 6, 10, 19, 6, 12, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 19, 5, 10, 19, 5, 12, stairsLeft);

        this.fillWithBlocks(world, boundingBox, 3, 6, 10, 4, 6, 12, stairsRight);
        this.fillWithBlocks(world, boundingBox, 3, 5, 10, 3, 5, 12, stairsRight);
        this.fillWithBlocks(world, boundingBox, 14, 6, 10, 15, 6, 12, stairsRight);
        this.fillWithBlocks(world, boundingBox, 14, 5, 10, 14, 5, 12, stairsRight);


        this.fillWithBlocks(world, boundingBox, 3, 8, 9, 8, 8, 9, stairsRight);
        this.fillWithBlocks(world, boundingBox, 14, 8, 9, 19, 8, 9, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 7, 9, 8, 7, 9, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 14, 7, 9, 19, 7, 9, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 3, 8, 13, 8, 8, 13, stairsRight);
        this.fillWithBlocks(world, boundingBox, 14, 8, 13, 19, 8, 13, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 7, 13, 8, 7, 13, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 14, 7, 13, 19, 7, 13, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 3, 7, 10, 19, 7, 12, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 2, 2, 9, 2, 7, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 9, 20, 7, 13, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 2, 8, 9, 2, 11, 9, stairsRight);
        this.fillWithBlocks(world, boundingBox, 2, 8, 13, 2, 11, 13, stairsRight);
        this.fillWithBlocks(world, boundingBox, 20, 8, 9, 20, 11, 9, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 20, 8, 13, 20, 11, 13, stairsLeft);

        this.fillWithBlocks(world, boundingBox, 3, 12, 9, 8, 12, 9, stairsRight);
        this.fillWithBlocks(world, boundingBox, 14, 12, 9, 19, 12, 9, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 11, 9, 8, 11, 9, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 14, 11, 9, 19, 11, 9, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 3, 12, 13, 8, 12, 13, stairsRight);
        this.fillWithBlocks(world, boundingBox, 14, 12, 13, 19, 12, 13, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 11, 13, 8, 11, 13, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 14, 11, 13, 19, 11, 13, StateHelper.NETHERBRICK_SLAB_TOP);

        this.fillWithBlocks(world, boundingBox, 10, 12, 3, 12, 12, 19, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 3, 12, 10, 19, 12, 12, StateHelper.NETHERBRICK_SLAB_TOP);

        return true;
    }
}
