package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.MobSpawnHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Mausoleum extends CatacombsBaseComponent {

    public Mausoleum(EnumFacing direction, Random random, StructureBoundingBox structureBoundingBox) {
        super(0, direction);
        this.boundingBox = structureBoundingBox;
        this.addRequiredExit(Passage.getFrontExit(this, 5, 0, 5));
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        int averageGroundLevel = BoundingBoxHelper.getAverageGroundLevel(world, boundingBox);

        if (averageGroundLevel < 0) {
            return true;
        }

        this.boundingBox.offset(0, averageGroundLevel - this.boundingBox.minY - 1, 0);
        this.fillWithAir(world, boundingBox, 2, 1, 2, 11, 5, 11);
        this.fillWithAir(world, boundingBox, 1, 1, 0, 12, 5, 1);
        this.fillWithAir(world, boundingBox, 6, 0, 6, 7, 0, 8);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 4, 1, 4, 9, 3, 9, StateHelper.WEB, false);
        // brick floor
        this.fillWithRandomizedBlocks(world, boundingBox, 3, 0, 3, 10, 0, 10, false, random, stoneBricks);

        // nether floor
        this.fillWithBlocks(world, boundingBox, 5, 0, 3, 5, 0, 10, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 8, 0, 3, 8, 0, 10, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 0, 5, 5, 0, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 8, 0, 5, 10, 0, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 0, 8, 5, 0, 8, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 8, 0, 8, 10, 0, 8, StateHelper.NETHER_BRICK);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 2, 0, 1, 2, 4, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 0, 2, 1, 4, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 0, 1, 5, 4, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 8, 0, 1, 8, 4, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 11, 0, 1, 11, 4, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 0, 2, 12, 4, 2, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 0, 11, 2, 4, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 0, 11, 1, 4, 11, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 0, 11, 5, 4, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 8, 0, 11, 8, 4, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 11, 0, 12, 11, 4, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 11, 0, 11, 12, 4, 11, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 0, 5, 2, 4, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 11, 0, 5, 12, 4, 5, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 0, 8, 2, 4, 8, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 11, 0, 8, 12, 4, 8, StateHelper.NETHER_BRICK);

        // brick walls
        this.fillWithRandomizedBlocks(world, boundingBox, 3, 0, 2, 4, 4, 2, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 3, 2, 7, 4, 2, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 0, 2, 10, 4, 2, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 3, 0, 11, 4, 4, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 0, 11, 7, 4, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, 0, 11, 10, 4, 11, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 3, 2, 4, 4, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 6, 2, 4, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 9, 2, 4, 10, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 11, 0, 3, 11, 4, 4, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 11, 0, 6, 11, 4, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 11, 0, 9, 11, 4, 10, false, random, stoneBricks);

        // trap floor
        this.fillWithBlocks(world, boundingBox, 6, 0, 2, 7, 0, 2, StateHelper.NIGHTSTONE);

        // brick columns
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 1, 5, 5, 4, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 8, 1, 5, 8, 4, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 1, 8, 5, 4, 8, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 8, 1, 8, 8, 4, 8, false, random, stoneBricks);

        // roof 1
        this.fillWithBlocks(world, boundingBox, 0, 5, 0, 0, 5, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 13, 5, 0, 13, 5, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 2, 5, 0, 11, 5, 0, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 2, 5, 13, 11, 5, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 1, 5, 1, 12, 5, 12, StateHelper.NETHER_BRICK);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 1, 5, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 12, 5, 0, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 1, 5, 13, boundingBox);
        this.placeBlockAtCurrentPosition(world, StateHelper.NETHER_BRICK, 12, 5, 13, boundingBox);

        // roof 2
        this.fillWithBlocks(world, boundingBox, 2, 6, 0, 2, 6, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 11, 6, 0, 11, 6, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 3, 6, 0, 3, 6, 13, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 10, 6, 0, 10, 6, 13, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 3, 6, 1, 10, 6, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 6, 12, 10, 6, 12, StateHelper.NETHER_BRICK);

        // roof 3
        this.fillWithBlocks(world, boundingBox, 4, 7, 0, 4, 7, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 9, 7, 0, 9, 7, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);
        this.fillWithBlocks(world, boundingBox, 5, 7, 0, 5, 7, 13, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 8, 7, 0, 8, 7, 13, StateHelper.NETHERBRICK_SLAB_TOP);
        this.fillWithBlocks(world, boundingBox, 5, 7, 1, 8, 7, 1, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 7, 12, 8, 7, 12, StateHelper.NETHER_BRICK);

        // roof 4
        this.fillWithBlocks(world, boundingBox, 6, 8, 0, 7, 8, 13, StateHelper.NETHERBRICK_SLAB_BOTTOM);

        for (int x = 2; x < 12; x++) {
            for (int z = 2; z < 12; z++) {
                this.fillDownwards(world, StateHelper.STONEBRICK_MOSSY, x, -1, z, boundingBox);
            }
        }

        this.fillDownwards(world, StateHelper.NETHER_BRICK, 2, -1, 1, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 5, -1, 1, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 8, -1, 1, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 11, -1, 1, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 2, -1, 12, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 5, -1, 12, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 8, -1, 12, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 11, -1, 12, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 1, -1, 2, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 1, -1, 5, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 1, -1, 8, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 1, -1, 11, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 12, -1, 2, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 12, -1, 5, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 12, -1, 8, boundingBox);
        this.fillDownwards(world, StateHelper.NETHER_BRICK, 12, -1, 11, boundingBox);

        // spawn bats
        MobSpawnHelper.spawnBats(world, random, boundingBox);

        return true;
    }
}
