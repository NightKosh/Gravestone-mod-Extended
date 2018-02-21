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

    public static final int X_LENGTH = 22;
    public static final int HEIGHT = 14;
    public static final int Z_LENGTH = 22;

    public CatacombsPortal(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);
        Passage entrance = new Passage(this, 9, 0, 0);

        this.setEntrance(entrance);

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y - HEIGHT + 7, z, X_LENGTH, HEIGHT, Z_LENGTH, entrance);
    }

    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();

        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 21, 13, 21, StateHelper.NETHER_BRICK);
        this.fillWithAir(world, boundingBox, 2, 2, 2, 19, 12, 19);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 2, 4, 2, 19, 12, 19, StateHelper.WEB, false);


        // floor
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 1, 2, 19, 1, 19, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 1, 1, 20, 1, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 5, 20, 1, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 9, 20, 1, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 12, 20, 1, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 16, 20, 1, 16, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 20, 20, 1, 20, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 1, 2, 1, 1, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 1, 2, 5, 1, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 2, 9, 1, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 2, 12, 1, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 1, 2, 16, 1, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 1, 2, 20, 1, 19, StateHelper.NETHER_BRICK);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 9, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 12, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 0, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 0, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 9, 0, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 12, 0, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 0, 16, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 12, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 12, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 12, 1, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 1, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 12, 1, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 1, 16, boundingBox);

        this.fillWithBlocks(world, boundingBox, 2, 2, 2, 19, 3, 19, StateHelper.TOXIC_WATER);

        // ceiling
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 13, 2, 19, 13, 19, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 13, 1, 20, 13, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 5, 20, 13, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 9, 20, 13, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 12, 20, 13, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 16, 20, 13, 16, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 20, 20, 13, 20, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 13, 2, 1, 13, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 13, 2, 5, 13, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 13, 2, 9, 13, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 13, 2, 12, 13, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 13, 2, 16, 13, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 13, 2, 20, 13, 19, StateHelper.NETHER_BRICK);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 13, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 13, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 13, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 13, 16, boundingBox);

        //walls
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 2, 2, 1, 12, 19, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 20, 2, 2, 20, 12, 19, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 2, 1, 19, 12, 1, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 2, 20, 19, 12, 20, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 7, 2, 1, 7, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 7, 2, 20, 7, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 7, 1, 19, 7, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 7, 20, 19, 7, 20, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 2, 1, 1, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 2, 1, 5, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 1, 9, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 2, 1, 12, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 2, 1, 16, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 1, 20, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 20, 1, 12, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 2, 20, 5, 12, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 20, 9, 12, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 2, 20, 12, 12, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 2, 20, 16, 12, 20, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 20, 20, 12, 20, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 2, 5, 1, 12, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 9, 1, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 12, 1, 12, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 16, 1, 12, 16, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 5, 20, 12, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 9, 20, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 12, 20, 12, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 16, 20, 12, 16, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 9, 7, 9, 9, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 7, 9, 12, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 7, 12, 9, 12, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 7, 12, 12, 12, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 2, 9, 11, 6, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 10, 12, 6, 11, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 2, 2, 2, 2, 12, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 19, 2, 2, 19, 12, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 2, 19, 2, 12, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 19, 2, 19, 19, 12, 19, StateHelper.NETHER_BRICK);

        //wall lanterns
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 0, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 0, 7, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 1, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 1, 7, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 21, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 21, 7, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 20, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 20, 7, 16, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 7, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 7, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 7, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 7, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 7, 21, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 7, 21, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 7, 20, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 7, 20, boundingBox);

        //wall water
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 1, 10, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 1, 10, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 20, 10, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 20, 10, 16, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 5, 10, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 16, 10, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 5, 10, 20, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 16, 10, 20, boundingBox);

        // entrance
        this.fillWithBlocks(world, boundingBox, 9, 7, 0, 12, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 8, 1, 11, 11, 1, StateHelper.getCatacombsPortal(EnumFacing.EAST));
        this.fillWithBlocks(world, boundingBox, 10, 8, 0, 11, 11, 0, StateHelper.SEA_LANTERN);

        // exits
        this.fillWithBlocks(world, boundingBox, 9, 7, 20, 12, 12, 21, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 8, 20, 11, 10, 20, StateHelper.IRON_BARS);

        this.fillWithBlocks(world, boundingBox, 0, 7, 9, 1, 12, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 8, 10, 1, 10, 11, StateHelper.IRON_BARS);

        this.fillWithBlocks(world, boundingBox, 20, 7, 9, 21, 12, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 8, 10, 20, 10, 11, StateHelper.IRON_BARS);

        //
        this.fillWithBlocks(world, boundingBox, 5, 12, 4, 5, 12, 17, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 16, 12, 4, 16, 12, 17, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 4, 12, 5, 17, 12, 5, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 4, 12, 16, 17, 12, 16, StateHelper.NETHERBRICK_SLAB_TOP);

        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 5, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 5, 12, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 16, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 16, 12, 16, boundingBox);

        IBlockState stairsTopF = StateHelper.NETHER_BRICK_STAIRS_SOUTH.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsTopB = StateHelper.NETHER_BRICK_STAIRS_NORTH.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsLeft = StateHelper.NETHER_BRICK_STAIRS_EAST.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsRight = StateHelper.NETHER_BRICK_STAIRS_WEST.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);

        this.fillWithBlocks(world, boundingBox, 3, 12, 19, 18, 12, 19, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 3, 12, 2, 18, 12, 2, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 2, 12, 3, 2, 12, 18, stairsRight);
        this.fillWithBlocks(world, boundingBox, 19, 12, 3, 19, 12, 18, stairsLeft);

        this.placeBlockAtCurrentPosition(world, stairsRight, 2, 11, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsRight, 3, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 2, 12, 5, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsRight, 2, 11, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsRight, 3, 12, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 2, 12, 16, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsLeft, 19, 11, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsLeft, 18, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 19, 12, 5, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsLeft, 19, 11, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsLeft, 18, 12, 16, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 19, 12, 16, boundingBox);


        this.placeBlockAtCurrentPosition(world, stairsTopF, 5, 11, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopF, 5, 12, 3, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 5, 12, 2, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopF, 16, 11, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopF, 16, 12, 3, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 16, 12, 2, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopB, 5, 11, 19, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopB, 5, 12, 18, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 5, 12, 19, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopB, 16, 11, 19, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopB, 16, 12, 18, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 16, 12, 19, boundingBox);


        // bridge
        this.fillWithBlocks(world, boundingBox, 10, 7, 2, 11, 7, 19, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 2, 12, 7, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 19, 12, 7, 19, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 9, 8, 13, 9, 8, 19, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 9, 12, 13, 9, 12, 19, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 12, 8, 13, 12, 8, 19, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 12, 12, 13, 12, 12, 19, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 9, 9, 19, 9, 11, 19, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 12, 9, 19, 12, 11, 19, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 9, 8, 2, 9, 8, 8, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 9, 12, 2, 9, 12, 8, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 12, 8, 2, 12, 8, 8, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 12, 12, 2, 12, 12, 8, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 9, 9, 2, 9, 11, 2, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 12, 9, 2, 12, 11, 2, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 9, 11, 3, 9, 11, 8, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 9, 11, 13, 9, 11, 18, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 12, 11, 3, 12, 11, 8, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 12, 11, 13, 12, 11, 18, StateHelper.NETHERBRICK_SLAB_TOP);

        this.fillWithBlocks(world, boundingBox, 9, 7, 3, 9, 7, 18, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 12, 7, 3, 12, 7, 18, stairsRight);


        this.fillWithBlocks(world, boundingBox, 10, 6, 7, 11, 6, 7, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 5, 8, 11, 5, 8, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 6, 17, 11, 6, 18, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 5, 18, 11, 5, 18, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 10, 6, 3, 11, 6, 4, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 5, 3, 11, 5, 3, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 6, 13, 11, 6, 14, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 5, 13, 11, 5, 13, stairsTopF);


        this.fillWithBlocks(world, boundingBox, 7, 6, 10, 7, 6, 11, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 8, 5, 10, 8, 5, 10, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 17, 6, 10, 18, 6, 11, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 18, 5, 10, 18, 5, 11, stairsLeft);

        this.fillWithBlocks(world, boundingBox, 3, 6, 10, 4, 6, 11, stairsRight);
        this.fillWithBlocks(world, boundingBox, 3, 5, 10, 3, 5, 11, stairsRight);
        this.fillWithBlocks(world, boundingBox, 13, 6, 10, 14, 6, 11, stairsRight);
        this.fillWithBlocks(world, boundingBox, 13, 5, 10, 13, 5, 11, stairsRight);


        this.fillWithBlocks(world, boundingBox, 3, 8, 9, 8, 8, 9, stairsRight);
        this.fillWithBlocks(world, boundingBox, 13, 8, 9, 18, 8, 9, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 7, 9, 8, 7, 9, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 13, 7, 9, 18, 7, 9, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 3, 8, 12, 8, 8, 12, stairsRight);
        this.fillWithBlocks(world, boundingBox, 13, 8, 12, 18, 8, 12, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 7, 12, 8, 7, 12, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 13, 7, 12, 18, 7, 12, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 3, 7, 10, 18, 7, 11, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 2, 2, 9, 2, 7, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 19, 2, 9, 19, 7, 12, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 2, 8, 9, 2, 11, 9, stairsRight);
        this.fillWithBlocks(world, boundingBox, 2, 8, 12, 2, 11, 12, stairsRight);
        this.fillWithBlocks(world, boundingBox, 19, 8, 9, 19, 11, 9, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 19, 8, 12, 19, 11, 12, stairsLeft);

        this.fillWithBlocks(world, boundingBox, 3, 12, 9, 8, 12, 9, stairsRight);
        this.fillWithBlocks(world, boundingBox, 13, 12, 9, 18, 12, 9, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 11, 9, 8, 11, 9, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 13, 11, 9, 18, 11, 9, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 3, 12, 12, 8, 12, 12, stairsRight);
        this.fillWithBlocks(world, boundingBox, 13, 12, 12, 18, 12, 12, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 3, 11, 12, 8, 11, 12, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 13, 11, 12, 18, 11, 12, StateHelper.NETHERBRICK_SLAB_TOP);

        this.fillWithBlocks(world, boundingBox, 10, 12, 3, 11, 12, 18, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 3, 12, 10, 18, 12, 11, StateHelper.NETHERBRICK_SLAB_TOP);

        return true;
    }
}
