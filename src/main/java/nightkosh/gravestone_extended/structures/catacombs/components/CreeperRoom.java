package nightkosh.gravestone_extended.structures.catacombs.components;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone.helper.GraveGenerationHelper;
import nightkosh.gravestone_extended.core.GSEntity;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.MemorialGenerationHelper;
import nightkosh.gravestone_extended.structures.ObjectsGenerationHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CreeperRoom extends CatacombsBaseComponent {

    public static final int X_LENGTH = 11;
    public static final int HEIGHT = 14;
    public static final int Z_LENGTH = 11;

    public CreeperRoom(EnumFacing facing, int level, Random random, int x, int y, int z) {
        super(0, facing, level);

        Passage entrance = new Passage(this, 3, 6, 0);
        this.setEntrance(entrance);

        this.addRequiredExit(new Passage(this, 3, 8, 10, ComponentSide.FRONT, true));
        switch (facing) {
            case SOUTH:
                this.addRequiredExit(new Passage(this, 10, 8, 3, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, 0, 8, 3, ComponentSide.RIGHT, true));
                break;
            case NORTH:
                this.addRequiredExit(new Passage(this, 0, 8, 7, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, 10, 8, 7, ComponentSide.RIGHT, true));
                break;
            case WEST:
                this.addRequiredExit(new Passage(this, 10, 8, 7, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, 0, 8, 7, ComponentSide.RIGHT, true));
                break;
            case EAST:
                this.addRequiredExit(new Passage(this, 0, 8, 3, ComponentSide.LEFT, true));
                this.addRequiredExit(new Passage(this, 10, 8, 3, ComponentSide.RIGHT, true));
                break;
        }

        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, y - HEIGHT, z, X_LENGTH, HEIGHT, Z_LENGTH, entrance);
    }

    /**
     * Build component
     */
    @Override
    public boolean addComponentParts(World world, Random random) {
        this.fillWithAir(world, boundingBox, 1, 1, 1, 9, 12, 9);
        buildTopPart(world, random, 8);

        // columns
        this.fillWithBlocks(world, boundingBox, 4, 1, 4, 4, 8, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 4, 1, 6, 4, 8, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 1, 4, 6, 8, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, 1, 6, 6, 8, 6, StateHelper.NETHER_BRICK);

        // bottom
        this.fillWithBlocks(world, boundingBox, 0, 0, 0, 10, 0, 10, StateHelper.NETHER_BRICK);

        // lava
        this.fillWithBlocks(world, boundingBox, 1, 1, 1, 9, 2, 9, StateHelper.TOXIC_WATER);

        // bottom walls
        this.fillWithBlocks(world, boundingBox, 0, 1, 0, 10, 8, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 1, 10, 10, 8, 10, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, 1, 1, 0, 8, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, 1, 1, 10, 8, 9, StateHelper.NETHER_BRICK);

        return true;
    }

    private void buildTopPart(World world, Random random, int yStart) {
        BlockSelector stoneBricks = getCemeteryCatacombsStones();
        // nether floor
        this.fillWithBlocks(world, boundingBox, 4, yStart, 1, 4, yStart, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, yStart, 1, 6, yStart, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 4, yStart, 6, 4, yStart, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, yStart, 6, 6, yStart, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, yStart, 4, 3, yStart, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 7, yStart, 4, 9, yStart, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, yStart, 6, 3, yStart, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 7, yStart, 6, 9, yStart, 6, StateHelper.NETHER_BRICK);

        // stoneBrick floor
        this.fillWithRandomizedBlocks(world, boundingBox, 5, yStart, 1, 5, yStart, 4, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, yStart, 6, 5, yStart, 9, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, yStart, 5, 4, yStart, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, yStart, 5, 9, yStart, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, yStart, 1, 3, yStart, 1, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 7, yStart, 1, 9, yStart, 1, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, yStart, 2, 1, yStart, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, yStart, 2, 9, yStart, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, yStart, 9, 3, yStart, 9, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 7, yStart, 9, 9, yStart, 9, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, yStart, 7, 1, yStart, 8, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 9, yStart, 7, 9, yStart, 8, false, random, stoneBricks);

        // spawner
        ObjectsGenerationHelper.generateMinecraftSpawner(this, world, 5, yStart, 5, GSEntity.MINECRAFT_CREEPER_ID);

        // nether ceiling
        int ceilingLevel = yStart + 5;
        this.fillWithBlocks(world, boundingBox, 4, ceilingLevel, 1, 4, ceilingLevel, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, ceilingLevel, 1, 6, ceilingLevel, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 4, ceilingLevel, 6, 4, ceilingLevel, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 6, ceilingLevel, 6, 6, ceilingLevel, 9, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, ceilingLevel, 4, 3, ceilingLevel, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 7, ceilingLevel, 4, 9, ceilingLevel, 4, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, ceilingLevel, 6, 3, ceilingLevel, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 7, ceilingLevel, 6, 9, ceilingLevel, 6, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, ceilingLevel, 0, 10, ceilingLevel, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, ceilingLevel, 10, 10, ceilingLevel, 10, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, ceilingLevel, 0, 9, ceilingLevel, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 1, ceilingLevel, 10, 9, ceilingLevel, 10, StateHelper.NETHER_BRICK);

        // stoneBrick ceiling
        this.fillWithRandomizedBlocks(world, boundingBox, 5, ceilingLevel, 1, 5, ceilingLevel, 4, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 5, ceilingLevel, 6, 5, ceilingLevel, 9, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, ceilingLevel, 5, 4, ceilingLevel, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 6, ceilingLevel, 5, 9, ceilingLevel, 5, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, ceilingLevel, 1, 3, ceilingLevel, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 7, ceilingLevel, 1, 9, ceilingLevel, 3, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, ceilingLevel, 7, 3, ceilingLevel, 9, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 7, ceilingLevel, 7, 9, ceilingLevel, 9, false, random, stoneBricks);

        // valueable block
        this.placeBlockAtCurrentPosition(world, getValuableBlock(random).getDefaultState(), 5, ceilingLevel, 5, boundingBox);

        // nether walls
        this.fillWithBlocks(world, boundingBox, 0, yStart + 1, 0, 0, yStart + 4, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, yStart + 1, 0, 10, yStart + 4, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, yStart + 1, 10, 0, yStart + 4, 10, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, yStart + 1, 10, 10, yStart + 4, 10, StateHelper.NETHER_BRICK);

        // stoneBrick walls
        this.fillWithRandomizedBlocks(world, boundingBox, 1, yStart + 1, 0, 2, yStart + 4, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 8, yStart + 1, 0, 9, yStart + 4, 0, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 1, yStart + 1, 10, 2, yStart + 4, 10, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 8, yStart + 1, 10, 9, yStart + 4, 10, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, yStart + 1, 1, 0, yStart + 4, 2, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, yStart + 1, 8, 0, yStart + 4, 9, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, yStart + 1, 1, 10, yStart + 4, 2, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, yStart + 1, 8, 10, yStart + 4, 9, false, random, stoneBricks);

        // doors
        this.fillWithBlocks(world, boundingBox, 3, yStart + 1, 0, 7, yStart + 4, 0, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 3, yStart + 1, 10, 7, yStart + 4, 10, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 0, yStart + 1, 3, 0, yStart + 4, 7, StateHelper.NETHER_BRICK);
        this.fillWithBlocks(world, boundingBox, 10, yStart + 1, 3, 10, yStart + 4, 7, StateHelper.NETHER_BRICK);
        this.fillWithRandomizedBlocks(world, boundingBox, 4, yStart + 1, 10, 6, yStart + 3, 10, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 0, yStart + 1, 4, 0, yStart + 3, 6, false, random, stoneBricks);
        this.fillWithRandomizedBlocks(world, boundingBox, 10, yStart + 1, 4, 10, yStart + 3, 6, false, random, stoneBricks);


        // creeper statue
        MemorialGenerationHelper.placeMemorial(this, world, random, 5, yStart + 1, 5, getCoordBaseMode().getOpposite(),
                MemorialGenerationHelper.GENERATED_CREEPER_STATUES_MEMORIALS_TYPES, GraveGenerationHelper.EnumGraveTypeByEntity.HUMAN_GRAVES);

        // clear enter
        this.fillWithAir(world, boundingBox, 4, yStart + 1, 0, 6, yStart + 3, 0);
    }
}
