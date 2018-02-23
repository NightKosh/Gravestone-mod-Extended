package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSEntity;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.MobSpawnHelper;
import nightkosh.gravestone_extended.structures.ObjectsGenerationHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnderHall extends CatacombsBaseComponent {

    public EnderHall(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        xLength = 12;
        height = 5;
        zLength = 18;

        Passage entrance = new Passage(this, 4, 0, 0);
        this.setEntrance(entrance);

        this.addExit(Passage.getFrontExit(this, 4, 0, zLength));

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y, z, xLength, height, zLength, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        this.fillWithAir(world, boundingBox, 1, 1, 1, 11, 3, 17);

        // block floor
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 0, 0, 12, 0, 18, false, random, stoneBricks);

        // web
        this.randomlyFillWithBlocks(world, boundingBox, random, WEB_GENERATION_CHANCE, 1, 1, 1, 11, 3, 17, StateHelper.WEB, false);
        // piles of bones
        if (ExtendedConfig.generatePilesOfBones) {
            this.fillWithRandomizedPilesOfBones(world, boundingBox, 1, 1, 1, 11, 1, 17, false, random);
        }

        // neter floor
        this.fillWithBlocks(world, boundingBox, 0, 0, 3, 12, 0, 3, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 0, 6, 12, 0, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 0, 9, 12, 0, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 0, 12, 12, 0, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 0, 15, 12, 0, 15, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 0, 1, 3, 0, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 0, 1, 6, 0, 17, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 0, 1, 9, 0, 17, StateHelper.NETHER_BRICK);

        // neter ceiling
        this.fillWithBlocks(world, boundingBox, 0, 4, 0, 12, 4, 18, StateHelper.NETHER_BRICK);

        // block walls
        this.fillWithRandomizedBlocks(world, boundingBox, 0, 1, 0, 0, 3, 18, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 12, 1, 0, 12, 3, 18, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 1, 0, 2, 3, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 1, 0, 11, 3, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, 1, 18, 2, 3, 18, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, 1, 18, 11, 3, 18, false, random, stoneBricks);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 3, 0, 0, 9, 3, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 0, 18, 9, 3, 18, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 1, 3, 0, 3, 3, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 1, 6, 0, 3, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 1, 9, 0, 3, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 1, 12, 0, 3, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 1, 15, 0, 3, 15, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 3, 12, 3, 3, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 6, 12, 3, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 9, 12, 3, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 12, 12, 3, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 12, 1, 15, 12, 3, 15, StateHelper.NETHER_BRICK);

        // nether columns
        this.fillWithBlocks(world, boundingBox, 3, 1, 3, 3, 3, 3, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 1, 6, 3, 3, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 1, 9, 3, 3, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 1, 12, 3, 3, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, 1, 15, 3, 3, 15, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 1, 3, 6, 3, 3, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 1, 6, 6, 3, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 1, 9, 6, 3, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 1, 12, 6, 3, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 1, 15, 6, 3, 15, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 3, 9, 3, 3, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 6, 9, 3, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 9, 9, 3, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 12, 9, 3, 12, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 9, 1, 15, 9, 3, 15, StateHelper.NETHER_BRICK);

        // trap floor
        this.fillWithBlocks(world, boundingBox, 4, 0, 3, 8, 0, 3, StateHelper.NIGHTSTONE);
        this.fillWithBlocks(world, boundingBox, 4, 0, 15, 8, 0, 15, StateHelper.NIGHTSTONE);

        // spawner
        ObjectsGenerationHelper.generateMinecraftSpawner(this, world, 3, 0, 3, GSEntity.MINECRAFT_ENDERMAN_ID);
        ObjectsGenerationHelper.generateMinecraftSpawner(this, world, 9, 0, 3, GSEntity.MINECRAFT_ENDERMAN_ID);
        ObjectsGenerationHelper.generateMinecraftSpawner(this, world, 6, 0, 9, GSEntity.MINECRAFT_ENDERMAN_ID);
        ObjectsGenerationHelper.generateMinecraftSpawner(this, world, 3, 0, 15, GSEntity.MINECRAFT_ENDERMAN_ID);
        ObjectsGenerationHelper.generateMinecraftSpawner(this, world, 9, 0, 15, GSEntity.MINECRAFT_ENDERMAN_ID);

        // fill exit
        this.fillWithRandomizedBlocks(world, boundingBox, 5, 1, 18, 7, 3, 18, false, random, stoneBricks);
        this.fillWithAir(world, boundingBox, 5, 1, 0, 7, 3, 0);

        // spawn bats
        MobSpawnHelper.spawnBats(world, random, boundingBox);

        return true;
    }
}
