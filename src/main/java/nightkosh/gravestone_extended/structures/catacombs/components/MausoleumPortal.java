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
public class MausoleumPortal extends CatacombsBaseComponent {

    public MausoleumPortal(EnumFacing direction, Random random, CatacombsBaseComponent component, CatacombsBaseComponent.Passage previousExit) {
        this(direction, 1, random, component.getXEnd(previousExit), component.getYEnd(previousExit), component.getZEnd(previousExit));
    }

    public MausoleumPortal(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        xLength = 22;
        height = 14;
        zLength = 15;

        Passage entrance = new Passage(this, 9, 7, 0);

        this.setEntrance(entrance);

        this.addRequiredExit(Passage.getFrontExit(this, 9, 7, zLength));

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y - height, z, xLength, height, zLength, entrance);
    }

    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();

        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 21, 13, 14, StateHelper.NETHER_BRICK);
        this.fillWithAir(world, boundingBox, 2, 2, 2, 19, 12, 12);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 2, 4, 2, 19, 12, 12, StateHelper.WEB, false);


        // floor
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 1, 2, 19, 1, 12, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 1, 1, 20, 1, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 5, 20, 1, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 9, 20, 1, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 13, 20, 1, 13, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 1, 2, 1, 1, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 1, 2, 5, 1, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 2, 9, 1, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 2, 12, 1, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 1, 2, 16, 1, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 1, 2, 20, 1, 12, StateHelper.NETHER_BRICK);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 9, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 12, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 0, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 0, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 9, 0, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 12, 0, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 0, 9, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 12, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 1, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 9, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 12, 1, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 1, 9, boundingBox);

        this.fillWithBlocks(world, boundingBox, 2, 2, 2, 19, 3, 12, StateHelper.TOXIC_WATER);

        // ceiling
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 13, 2, 19, 13, 12, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 13, 1, 20, 13, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 5, 20, 13, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 9, 20, 13, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 13, 13, 20, 13, 13, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 13, 2, 1, 13, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 13, 2, 5, 13, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 13, 2, 9, 13, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 13, 2, 12, 13, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 13, 2, 16, 13, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 13, 2, 20, 13, 12, StateHelper.NETHER_BRICK);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 13, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 13, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 13, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 13, 9, boundingBox);

        //walls
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 2, 2, 1, 12, 12, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 20, 2, 2, 20, 12, 12, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 2, 1, 19, 12, 1, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 2, 13, 19, 12, 13, false, random, stoneBricks);

        this.fillWithBlocks(world, boundingBox, 1, 7, 2, 1, 7, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 7, 2, 20, 7, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 7, 1, 19, 7, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 7, 13, 19, 7, 13, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 2, 1, 1, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 2, 1, 5, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 1, 9, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 2, 1, 12, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 2, 1, 16, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 1, 20, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 13, 1, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 2, 13, 5, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 13, 9, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 2, 13, 12, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 16, 2, 13, 16, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 13, 20, 12, 13, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 1, 2, 5, 1, 12, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 2, 9, 1, 12, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 5, 20, 12, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 20, 2, 9, 20, 12, 9, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 9, 7, 7, 9, 12, 7, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 7, 7, 12, 12, 7, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 2, 7, 11, 6, 7, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 2, 2, 2, 2, 12, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 19, 2, 2, 19, 12, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 2, 12, 2, 12, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 19, 2, 12, 19, 12, 12, StateHelper.NETHER_BRICK);

        //wall lanterns
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 0, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 0, 7, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 1, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 1, 7, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 21, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 21, 7, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 20, 7, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 20, 7, 9, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 7, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 7, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 7, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 7, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 5, 7, 14, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.SEA_LANTERN, 16, 7, 14, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 5, 7, 13, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STAINED_GLASS_LIME, 16, 7, 13, boundingBox);

        //wall water
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 1, 10, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 1, 10, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 20, 10, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 20, 10, 9, boundingBox);

        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 5, 10, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 16, 10, 1, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 5, 10, 13, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.TOXIC_WATER, 16, 10, 13, boundingBox);

        // entrance
        this.fillWithBlocks(world, boundingBox, 9, 7, 0, 12, 12, 1, StateHelper.NETHER_BRICK);
        this.fillWithAir(world, boundingBox, 10, 8, 0, 11, 10, 1);

        // portal
        this.fillWithBlocks(world, boundingBox, 9, 7, 13, 12, 12, 13, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 8, 13, 11, 11, 13, StateHelper.getCatacombsPortal(EnumFacing.EAST));
        this.fillWithBlocks(world, boundingBox, 10, 8, 14, 11, 11, 14, StateHelper.SEA_LANTERN);
        this.fillWithAir(world, boundingBox, 10, 8, 0, 11, 10, 1);

        //
        this.fillWithBlocks(world, boundingBox, 5, 12, 4, 5, 12, 10, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 16, 12, 4, 16, 12, 10, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 4, 12, 5, 17, 12, 5, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 4, 12, 9, 17, 12, 9, StateHelper.NETHERBRICK_SLAB_TOP);

        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 5, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 5, 12, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 16, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 16, 12, 9, boundingBox);

        IBlockState stairsTopF = StateHelper.NETHER_BRICK_STAIRS_SOUTH.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsTopB = StateHelper.NETHER_BRICK_STAIRS_NORTH.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsLeft = StateHelper.NETHER_BRICK_STAIRS_EAST.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);
        IBlockState stairsRight = StateHelper.NETHER_BRICK_STAIRS_WEST.withProperty(BlockStairs.HALF, BlockStairs.EnumHalf.TOP);

        this.fillWithBlocks(world, boundingBox, 3, 12, 12, 18, 12, 12, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 3, 12, 2, 18, 12, 2, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 2, 12, 3, 2, 12, 11, stairsRight);
        this.fillWithBlocks(world, boundingBox, 19, 12, 3, 19, 12, 11, stairsLeft);

        this.placeBlockAtCurrentPosition(world, stairsRight, 2, 11, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsRight, 3, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 2, 12, 5, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsRight, 2, 11, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsRight, 3, 12, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 2, 12, 9, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsLeft, 19, 11, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsLeft, 18, 12, 5, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 19, 12, 5, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsLeft, 19, 11, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsLeft, 18, 12, 9, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 19, 12, 9, boundingBox);


        this.placeBlockAtCurrentPosition(world, stairsTopF, 5, 11, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopF, 5, 12, 3, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 5, 12, 2, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopF, 16, 11, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopF, 16, 12, 3, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 16, 12, 2, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopB, 5, 11, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopB, 5, 12, 11, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 5, 12, 12, boundingBox);

        this.placeBlockAtCurrentPosition(world, stairsTopB, 16, 11, 12, boundingBox);
        this.placeBlockAtCurrentPosition(world, stairsTopB, 16, 12, 11, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 16, 12, 12, boundingBox);


        // bridge
        this.fillWithBlocks(world, boundingBox, 10, 7, 2, 11, 7, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 2, 12, 7, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 2, 12, 12, 7, 12, StateHelper.NETHER_BRICK);

        this.fillWithBlocks(world, boundingBox, 9, 8, 8, 9, 8, 12, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 9, 12, 8, 9, 12, 12, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 12, 8, 8, 12, 8, 12, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 12, 12, 8, 12, 12, 12, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 9, 9, 12, 9, 11, 12, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 12, 9, 12, 12, 11, 12, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 9, 8, 2, 9, 8, 6, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 9, 12, 2, 9, 12, 6, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 12, 8, 2, 12, 8, 6, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 12, 12, 2, 12, 12, 6, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 9, 9, 2, 9, 11, 2, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 12, 9, 2, 12, 11, 2, stairsTopF);

        this.fillWithBlocks(world, boundingBox, 9, 11, 3, 9, 11, 6, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 9, 11, 8, 9, 11, 11, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 12, 11, 3, 12, 11, 6, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 12, 11, 8, 12, 11, 11, StateHelper.NETHERBRICK_SLAB_TOP);

        this.fillWithBlocks(world, boundingBox, 9, 7, 3, 9, 7, 11, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 12, 7, 3, 12, 7, 11, stairsRight);


        this.fillWithBlocks(world, boundingBox, 10, 6, 5, 11, 6, 6, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 5, 6, 11, 5, 6, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 6, 10, 11, 6, 11, stairsTopB);
        this.fillWithBlocks(world, boundingBox, 10, 5, 11, 11, 5, 11, stairsTopB);

        this.fillWithBlocks(world, boundingBox, 10, 6, 3, 11, 6, 4, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 5, 3, 11, 5, 3, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 6, 8, 11, 6, 9, stairsTopF);
        this.fillWithBlocks(world, boundingBox, 10, 5, 8, 11, 5, 8, stairsTopF);


        this.fillWithBlocks(world, boundingBox, 2, 8, 7, 8, 8, 7, stairsRight);
        this.fillWithBlocks(world, boundingBox, 13, 8, 7, 19, 8, 7, stairsLeft);
        this.fillWithBlocks(world, boundingBox, 2, 7, 7, 8, 7, 7, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 13, 7, 7, 19, 7, 7, StateHelper.NETHERBRICK_SLAB_TOP);

        this.fillWithBlocks(world, boundingBox, 10, 12, 3, 11, 12, 11, StateHelper.NETHERBRICK_SLAB_TOP);

        return true;
    }
}
