package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
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
public class TrapCorridor extends CatacombsBaseComponent {

    public TrapCorridor(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        xLength = 6;
        height = 5;
        zLength = 5;

        Passage entrance = new Passage(this, 1, 0, 0);

        this.setEntrance(entrance);
        this.addExit(Passage.getFrontExit(this, 1, 0, zLength - 1));

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y, z, xLength, height, zLength, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        this.fillWithAir(world, boundingBox, 2, 1, 0, 4, 3, 3);

        // block floor
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 0, 1, 5, 0, 3, false, random, stoneBricks);

        // trap floor
        this.fillWithBlocks(world, boundingBox, 1, 0, 0, 5, 0, 0, StateHelper.NIGHTSTONE);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 2, 1, 0, 4, 3, 3, StateHelper.WEB, false);

        // neter ceiling
        this.fillWithBlocks(world, boundingBox, 1, 4, 0, 5, 4, 3, StateHelper.NETHER_BRICK);

        // block walls
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 1, 1, 1, 3, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 1, 1, 5, 3, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 0, 4, 5, 4, 4, false, random, stoneBricks);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 1, 1, 0, 1, 3, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 1, 0, 5, 3, 0, StateHelper.NETHER_BRICK);
        // blocks
        this.placeBlockAtCurrentPosition(world, StateHelper.STONEBRICK, 0, 1, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.STONEBRICK, 6, 1, 2, boundingBox);

        // tripWire hook
        this.placeBlockAtCurrentPosition(world, StateHelper.getTripWireHook(EnumFacing.EAST), 1, 1, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.getTripWireHook(EnumFacing.WEST), 5, 1, 2, boundingBox);

        // tripWire
        this.fillWithBlocks(world, boundingBox, 2, 1, 2, 4, 1, 2, StateHelper.TRIPWIRE);

        //dispencer
        ObjectsGenerationHelper.generateDispenser(world, this, random, 0, 2, 2, this.getLeftDirectionForBlocks());
        ObjectsGenerationHelper.generateDispenser(world, this, random, 6, 2, 2, this.getRightDirectionForBlocks());
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 1, 2, 2, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 5, 2, 2, boundingBox);

        return true;
    }
}
