package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone.helper.GraveGenerationHelper.EnumGraveTypeByEntity;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.GraveGenerationHelper;
import nightkosh.gravestone_extended.structures.MobSpawnHelper;
import nightkosh.gravestone_extended.structures.ObjectsGenerationHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveCorridor extends CatacombsBaseComponent {

    public GraveCorridor(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        xLength = 7;
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
        this.fillWithAir(world, boundingBox, 1, 1, 1, 5, 3, 3);
        this.fillWithAir(world, boundingBox, 2, 1, 0, 4, 3, 0);

        // block floor
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 1, 4, 0, 3, false, random, stoneBricks);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 2, 1, 2, 5, 3, 3, StateHelper.WEB, false);
        // piles of bones
        if (ExtendedConfig.generatePilesOfBones) {
            this.fillWithRandomizedPilesOfBones(world, boundingBox, 2, 1, 2, 5, 1, 3, false, random);
        }

        // trap floor
        this.fillWithBlocks(world, boundingBox, 1, 0, 0, 5, 0, 0, StateHelper.NIGHTSTONE);

        // neter floor
        this.fillWithBlocks(world, boundingBox, 1, 0, 4, 5, 0, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 0, 1, 1, 0, 3, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 0, 1, 5, 0, 3, StateHelper.NETHER_BRICK);

        // neter ceiling
        this.fillWithBlocks(world, boundingBox, 1, 4, 0, 5, 4, 4, StateHelper.NETHER_BRICK);

        // block walls
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 1, 0, 4, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, 0, 1, 6, 4, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 2, 0, 4, 4, 4, 4, false, random, stoneBricks);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 1, 1, 0, 1, 3, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, 1, 4, 1, 3, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 1, 0, 5, 3, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 5, 1, 4, 5, 3, 4, StateHelper.NETHER_BRICK);

        // graves
        EntityGroupOfGravesMobSpawnerHelper spawnerHelper = GraveGenerationHelper.createSpawnerHelper(world, this.boundingBox);
        GraveGenerationHelper.fillGraves(this, world, random, 1, 1, 1, 1, 1, 3, StateHelper.getGravestone(this.getLeftDirectionForBlocks()), spawnerHelper, EnumGraveTypeByEntity.ALL_GRAVES);
        GraveGenerationHelper.fillGraves(this, world, random, 5, 1, 1, 5, 1, 3, StateHelper.getGravestone(this.getRightDirectionForBlocks()), spawnerHelper, EnumGraveTypeByEntity.ALL_GRAVES);

        // chest
        if (random.nextInt(5) < 2) {
            ObjectsGenerationHelper.generateChest(this, world, random, 3, 1, 2, this.getCoordBaseMode().getOpposite(), true, ObjectsGenerationHelper.EnumChestTypes.ALL_CHESTS);
        }

        // spawn bats
        MobSpawnHelper.spawnBats(world, random, boundingBox);

        return true;
    }
}
