package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
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
public class SpidersCorridor extends CatacombsBaseComponent {

    public SpidersCorridor(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        xLength = 5;
        height = 5;
        zLength = 13;

        Passage entrance = new Passage(this, 0, 0, 0);
        this.setEntrance(entrance);
        this.addExit(Passage.getFrontExit(this, 0, 0, zLength - 1));

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y, z, xLength, height, zLength, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        this.fillWithAir(world, boundingBox, 1, 1, 0, 3, 3, zLength - 1);
        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE + 0.3F, 1, 1, 0, 3, 3, zLength - 1, StateHelper.WEB, false);

        for (int i = 0; i < 3; i++) {
            int z = i * 4;

            // block floor
            this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 1 + z, 4, 0, 3 + z, false, random, stoneBricks);

            // neter ceiling
            this.fillWithBlocks(world, boundingBox, 0, 4, 0 + z, 4, 4, 3 + z, StateHelper.NETHER_BRICK);

            // trap floor
            this.fillWithBlocks(world, boundingBox, 0, 0, 0 + z, 4, 0, 0 + z, StateHelper.NIGHTSTONE);

            // block walls
            this.fillWithRandomizedBlocks(world, boundingBox, 0, 1, 1 + z, 0, 3, 3 + z, false, random, stoneBricks);
            this.fillWithRandomizedBlocks(world, boundingBox, 4, 1, 1 + z, 4, 3, 3 + z, false, random, stoneBricks);

            // nether walls
            this.fillWithBlocks(world, boundingBox, 0, 1, 0 + z, 0, 3, 0 + z, StateHelper.NETHER_BRICK);
            this.fillWithBlocks(world, boundingBox, 4, 1, 0 + z, 4, 3, 0 + z, StateHelper.NETHER_BRICK);
        }

        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 12, 4, 4, 12, false, random, stoneBricks);

        // spawner
        ObjectsGenerationHelper.generateSpawner(this, world, 2, 1, 6, EnumSpawner.SPIDER_SPAWNER);
        return true;
    }
}
