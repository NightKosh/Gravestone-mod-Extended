package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
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
public class Bridge extends CatacombsBaseComponent {

    public static final int X_LENGTH = 13;
    public static final int HEIGHT = 14;
    public static final int Z_LENGTH = 7;

    public Bridge(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        Passage entrance = new Passage(this, 4, 6, 0);
        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y - HEIGHT, z, X_LENGTH, HEIGHT, Z_LENGTH, entrance);

        this.setEntrance(entrance);
        this.addExit(new Passage(this, 4, 8, Z_LENGTH, ComponentSide.FRONT));
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();

        this.fillWithAir(world, boundingBox, 3, 3, 1, 9, 12, 6);
        this.fillWithAir(world, boundingBox, 1, 9, 1, 2, 10, 6);
        this.fillWithAir(world, boundingBox, 10, 9, 1, 11, 10, 6);
        // neter floor and ceiling
        this.fillWithBlocks(world, boundingBox, 2, 0, 0, 10, 0, 7, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 2, 13, 0, 10, 13, 7, StateHelper.NETHER_BRICK);
        // nether walls
        this.fillWithBlocks(world, boundingBox, 3, 1, 0, 9, 12, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 1, 7, 9, 12, 7, StateHelper.NETHER_BRICK);
        // block walls
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 1, 0, 2, 8, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 11, 0, 2, 12, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 1, 0, 10, 8, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 11, 0, 10, 12, 7, false, random, stoneBricks);
        // graves floor & ceilng
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 8, 0, 1, 8, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 11, 0, 1, 11, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 11, 8, 0, 11, 8, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 11, 11, 0, 11, 11, 7, false, random, stoneBricks);
        // graves walls
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 9, 0, 0, 10, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 9, 0, 12, 10, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 9, 0, 2, 10, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 9, 0, 2, 10, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 9, 7, 2, 10, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 9, 7, 2, 10, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 9, 0, 11, 10, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 9, 0, 11, 10, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 9, 7, 11, 10, 7, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 9, 7, 11, 10, 7, false, random, stoneBricks);

        EntityGroupOfGravesMobSpawnerHelper spawnerHelper = GraveGenerationHelper.createSpawnerHelper(world, this.boundingBox);

        GraveGenerationHelper.fillGraves(this, world, random, 1, 9, 1, 1, 9, 6, StateHelper.getGravestone(this.getLeftDirectionForBlocks()), spawnerHelper);
        GraveGenerationHelper.fillGraves(this, world, random, 11, 9, 1, 11, 9, 6, StateHelper.getGravestone(this.getRightDirectionForBlocks()), spawnerHelper);
        // lava
        this.fillWithBlocks(world, boundingBox, 3, 1, 1, 9, 2, 6, StateHelper.TOXIC_WATER);
        // bridge
        this.fillWithBlocks(world, boundingBox, 6, 8, 1, 6, 8, 6, StateHelper.NETHERBRICK_SLAB_TOP);

        if (random.nextInt(10) < 4) {
            this.placeBlockAtCurrentPosition(world, StateHelper.AIR, 6, 8, 5, boundingBox);
        }

        // block exit wall
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 9, 7, 7, 11, 7, false, random, stoneBricks);
        this.fillWithAir(world, boundingBox, 5, 9, 0, 7, 11, 0);
        // spawn bats
        MobSpawnHelper.spawnBats(world, random, boundingBox);
        return true;
    }
}
