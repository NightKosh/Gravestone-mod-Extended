package nightkosh.gravestone_extended.structures.village.undertaker;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import nightkosh.gravestone.helper.GraveGenerationHelper.EnumGraveTypeByEntity;
import nightkosh.gravestone_extended.block.skull_candle.BlockSkullCandleSkeleton;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.entity.helper.EntityGroupOfGravesMobSpawnerHelper;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.GraveGenerationHelper;
import nightkosh.gravestone_extended.structures.IComponentGraveStone;
import nightkosh.gravestone_extended.structures.village.VillagersHandler;

import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ComponentVillageUndertaker extends StructureVillagePieces.Village implements IComponentGraveStone {

    private int averageGroundLevel = -1;
    private static final int HEIGHT = 7;
    private static final int CEMETERY_HEIGHT = 2;
    private static final int X_LENGTH = 12;
    private static final int Z_LENGTH = 14;
    private static final int HOUSE_WIDTH = 6;

    private boolean isCemetery = false;

    public ComponentVillageUndertaker() {
    }

    public ComponentVillageUndertaker(StructureVillagePieces.Start startPiece, int componentType, Random random, StructureBoundingBox structureBoundingBox, EnumFacing direction) {
        super(startPiece, componentType);
        this.setCoordBaseMode(direction);
        this.boundingBox = structureBoundingBox;

        if (ExtendedConfig.generateCemeteries) {
            isCemetery = random.nextBoolean();
        }
    }

    public static ComponentVillageUndertaker buildComponent(StructureVillagePieces.Start startPiece, List list, Random random, int par3, int par4, int par5, EnumFacing facing, int par7) {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, X_LENGTH, HEIGHT, Z_LENGTH, facing);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(list, structureboundingbox) == null ? new ComponentVillageUndertaker(startPiece, par7, random, structureboundingbox, facing) : null;
    }

    public static StructureBoundingBox getBoundingBox(EnumFacing facing, int x, int z) {
        return BoundingBoxHelper.getCorrectBox(facing, x, 64, z, X_LENGTH, HEIGHT, Z_LENGTH);
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox boundingBox) {
        return generateComponent(world, random, boundingBox, isCemetery);
    }

    public boolean generateComponent(World world, Random random, StructureBoundingBox boundingBox, boolean isCemetery) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, boundingBox);

            if (this.averageGroundLevel < 0) {
                return true;
            }
            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + HEIGHT - 2, 0);
        }

        IBlockState groundState;
        IBlockState fenceState;
        IBlockState gateState = StateHelper.getDarkOakFenceGate(this.getCoordBaseMode());

        Biome biome = world.getBiome(new BlockPos(this.getXWithOffset(0, 0), this.getYWithOffset(0), this.getZWithOffset(0, 0)));
        if (biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS) {
            groundState = StateHelper.SAND;
            fenceState = StateHelper.COBBLESTONE_WALL;
        } else {
            groundState = StateHelper.GRASS;
            fenceState = StateHelper.COBBLESTONE_WALL_MOSSY;
        }

        if (isCemetery) {
            generateCemetery(world, random, boundingBox, 0, 0, isCemetery, groundState, fenceState, gateState);
        } else {
            this.fillWithAir(world, boundingBox, 0, 1, 0, X_LENGTH, HEIGHT, HOUSE_WIDTH);


            // ground
            this.fillWithBlocks(world, boundingBox, 1, 0, 0, 11, 0, 5, StateHelper.STAINED_HARDENED_CLAY_BLACK, StateHelper.STAINED_HARDENED_CLAY_BLACK, false);

            generateCemetery(world, random, boundingBox, 0, 4, isCemetery, groundState, StateHelper.DARK_OAK_FENCE, gateState);

            // fence
            this.fillWithBlocks(world, boundingBox, 1, 1, 1, 1, 1, 6, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);
            this.fillWithBlocks(world, boundingBox, 2, 1, 5, 4, 1, 5, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);
            this.fillWithBlocks(world, boundingBox, 1, 1, 0, 1, 3, 0, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);
            this.fillWithBlocks(world, boundingBox, 1, 1, 5, 1, 3, 5, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);

            this.fillWithBlocks(world, boundingBox, 6, 1, 0, 7, 1, 0, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);
            this.fillWithBlocks(world, boundingBox, 9, 1, 0, 10, 1, 0, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);
            this.fillWithBlocks(world, boundingBox, 5, 1, 0, 5, 3, 0, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);
            this.fillWithBlocks(world, boundingBox, 11, 1, 0, 11, 3, 0, StateHelper.DARK_OAK_FENCE, StateHelper.DARK_OAK_FENCE, false);

            //gate
            this.setBlockState(world, gateState, 3, 1, 5, boundingBox);

            // candles
            this.setBlockState(world, StateHelper.CANDLE, 1, 2, 1, boundingBox);
            this.setBlockState(world, StateHelper.CANDLE, 1, 2, 4, boundingBox);
            this.setBlockState(world, StateHelper.CANDLE, 2, 2, 5, boundingBox);
            this.setBlockState(world, StateHelper.CANDLE, 4, 2, 5, boundingBox);
            this.setBlockState(world, StateHelper.CANDLE, 7, 2, 0, boundingBox);
            this.setBlockState(world, StateHelper.CANDLE, 9, 2, 0, boundingBox);
            this.setBlockState(world, StateHelper.CANDLE, 1, 2, 13, boundingBox);
            this.setBlockState(world, StateHelper.CANDLE, 11, 2, 13, boundingBox);

            // walls
            this.fillWithBlocks(world, boundingBox, 5, 1, 2, 5, 3, 2, StateHelper.STAINED_HARDENED_CLAY_BLACK, StateHelper.STAINED_HARDENED_CLAY_BLACK, false);
            this.fillWithBlocks(world, boundingBox, 5, 1, 5, 5, 3, 5, StateHelper.STAINED_HARDENED_CLAY_BLACK, StateHelper.STAINED_HARDENED_CLAY_BLACK, false);
            this.fillWithBlocks(world, boundingBox, 11, 1, 2, 11, 3, 2, StateHelper.STAINED_HARDENED_CLAY_BLACK, StateHelper.STAINED_HARDENED_CLAY_BLACK, false);
            this.fillWithBlocks(world, boundingBox, 11, 1, 5, 11, 3, 5, StateHelper.STAINED_HARDENED_CLAY_BLACK, StateHelper.STAINED_HARDENED_CLAY_BLACK, false);
            this.fillWithBlocks(world, boundingBox, 7, 1, 2, 7, 3, 2, StateHelper.STAINED_HARDENED_CLAY_BLACK, StateHelper.STAINED_HARDENED_CLAY_BLACK, false);
            this.fillWithBlocks(world, boundingBox, 9, 1, 2, 9, 3, 2, StateHelper.STAINED_HARDENED_CLAY_BLACK, StateHelper.STAINED_HARDENED_CLAY_BLACK, false);
            this.setBlockState(world, StateHelper.STAINED_HARDENED_CLAY_BLACK, 8, 3, 2, boundingBox);

            this.fillWithBlocks(world, boundingBox, 5, 1, 3, 5, 3, 4, StateHelper.STAINED_HARDENED_CLAY_BROWN, StateHelper.STAINED_HARDENED_CLAY_BROWN, false);
            this.fillWithBlocks(world, boundingBox, 11, 1, 3, 11, 3, 4, StateHelper.STAINED_HARDENED_CLAY_BROWN, StateHelper.STAINED_HARDENED_CLAY_BROWN, false);
            this.fillWithBlocks(world, boundingBox, 6, 1, 5, 10, 3, 5, StateHelper.STAINED_HARDENED_CLAY_BROWN, StateHelper.STAINED_HARDENED_CLAY_BROWN, false);
            this.fillWithBlocks(world, boundingBox, 6, 1, 2, 6, 3, 2, StateHelper.STAINED_HARDENED_CLAY_BROWN, StateHelper.STAINED_HARDENED_CLAY_BROWN, false);
            this.fillWithBlocks(world, boundingBox, 10, 1, 2, 10, 3, 2, StateHelper.STAINED_HARDENED_CLAY_BROWN, StateHelper.STAINED_HARDENED_CLAY_BROWN, false);

            this.setBlockState(world, StateHelper.STAINED_GLASS_PANE_GRAY, 6, 2, 2, boundingBox);
            this.setBlockState(world, StateHelper.STAINED_GLASS_PANE_GRAY, 10, 2, 2, boundingBox);

            // door
            this.placeDoorCurrentPosition(world, boundingBox, random, 8, 1, 2, EnumFacing.NORTH);

            // book shelf
            this.fillWithBlocks(world, boundingBox, 6, 1, 3, 6, 1, 4, StateHelper.BOOKSHELF, StateHelper.BOOKSHELF, false);
            this.setBlockState(world, StateHelper.BOOKSHELF, 10, 1, 4, boundingBox);

            // candle
            this.generateSkullCandle(world, boundingBox, 10, 2, 4, getCoordBaseMode());

            // painting
            this.generatePainting(world, 6, 2, 3, getCoordBaseMode());

            // bed
            this.generateBed(world, 9, 1, 3, boundingBox);

            // roof
            IBlockState stairsState = StateHelper.getStairs(StateHelper.DARK_OAK_STAIRS, getCoordBaseMode());
            IBlockState stairsBackState = StateHelper.getStairs(StateHelper.DARK_OAK_STAIRS, getCoordBaseMode().getOpposite());
            this.fillWithBlocks(world, boundingBox, 1, 4, 1, 11, 4, 5, StateHelper.WOODEN_SLAB_DARK_OAK, StateHelper.WOODEN_SLAB_DARK_OAK, false);

            this.fillWithBlocks(world, boundingBox, 0, 4, 0, 12, 4, 0, stairsState, stairsState, false);
            this.fillWithBlocks(world, boundingBox, 0, 4, 6, 12, 4, 6, stairsBackState, stairsBackState, false);

            this.fillWithBlocks(world, boundingBox, 0, 5, 1, 12, 5, 1, stairsState, stairsState, false);
            this.fillWithBlocks(world, boundingBox, 0, 5, 5, 12, 5, 5, stairsBackState, stairsBackState, false);

            this.fillWithBlocks(world, boundingBox, 0, 6, 2, 12, 6, 2, stairsState, stairsState, false);
            this.fillWithBlocks(world, boundingBox, 0, 6, 4, 12, 6, 4, stairsBackState, stairsBackState, false);

            this.fillWithBlocks(world, boundingBox, 0, 7, 3, 12, 7, 3, StateHelper.WOODEN_SLAB_DARK_OAK, StateHelper.WOODEN_SLAB_DARK_OAK, false);

            this.fillWithBlocks(world, boundingBox, 1, 4, 1, 1, 4, 5, StateHelper.PLANKS_DARK_OAK, StateHelper.PLANKS_DARK_OAK, false);
            this.fillWithBlocks(world, boundingBox, 11, 4, 1, 11, 4, 5, StateHelper.PLANKS_DARK_OAK, StateHelper.PLANKS_DARK_OAK, false);
            this.setBlockState(world, StateHelper.PLANKS_DARK_OAK, 1, 5, 2, boundingBox);
            this.setBlockState(world, StateHelper.PLANKS_DARK_OAK, 1, 5, 4, boundingBox);
            this.setBlockState(world, StateHelper.PLANKS_DARK_OAK, 11, 5, 2, boundingBox);
            this.setBlockState(world, StateHelper.PLANKS_DARK_OAK, 11, 5, 4, boundingBox);

            this.setBlockState(world, StateHelper.PLANKS_DARK_OAK, 1, 6, 3, boundingBox);
            this.setBlockState(world, StateHelper.PLANKS_DARK_OAK, 11, 6, 3, boundingBox);

            this.setBlockState(world, StateHelper.STAINED_GLASS_PANE_GRAY, 1, 5, 3, boundingBox);
            this.setBlockState(world, StateHelper.STAINED_GLASS_PANE_GRAY, 11, 5, 3, boundingBox);


            for (int i = 0; i < X_LENGTH; i++) {
                for (int j = 0; j < Z_LENGTH; j++) {
                    this.clearCurrentPositionBlocksUpwards(world, i, 8, j, boundingBox);
                    this.setBlockState(world, StateHelper.COBBLESTONE, i, -1, j, boundingBox);
                }
            }

            this.spawnVillagers(world, boundingBox, 8, 1, 3, 1);
        }
        return true;
    }

    public void generateCemetery(World world, Random random, StructureBoundingBox structureBoundingBox, int startX, int startZ,
                                 boolean isOnlyCemetery, IBlockState groundState, IBlockState fenceState, IBlockState gateState) {
        this.fillWithAir(world, structureBoundingBox, startX, 1, startZ, startX, 1, startZ + 10);
        this.fillWithAir(world, structureBoundingBox, startX + 12, 1, startZ, startX + 12, 1, startZ + 10);
        this.fillWithAir(world, structureBoundingBox, startX, 1, startZ, startX + 12, 1, startZ);
        this.fillWithAir(world, structureBoundingBox, startX, 1, startZ + 10, startX + 12, 1, startZ + 10);
        this.fillWithAir(world, structureBoundingBox, startX + 2, 1, startZ + 2, startX + 2, 1, startZ + 8);
        this.fillWithAir(world, structureBoundingBox, startX + 4, 1, startZ + 2, startX + 4, 1, startZ + 8);
        this.fillWithAir(world, structureBoundingBox, startX + 6, 1, startZ + 2, startX + 6, 1, startZ + 8);
        this.fillWithAir(world, structureBoundingBox, startX + 8, 1, startZ + 2, startX + 8, 1, startZ + 8);
        this.fillWithAir(world, structureBoundingBox, startX + 10, 1, startZ + 2, startX + 10, 1, startZ + 8);
        this.fillWithAir(world, structureBoundingBox, startX + 3, 1, startZ + 2, startX + 9, 1, startZ + 2);
        this.fillWithAir(world, structureBoundingBox, startX + 3, 1, startZ + 4, startX + 9, 1, startZ + 4);
        this.fillWithAir(world, structureBoundingBox, startX + 3, 1, startZ + 6, startX + 9, 1, startZ + 6);
        this.fillWithAir(world, structureBoundingBox, startX + 3, 1, startZ + 8, startX + 9, 1, startZ + 8);

        int startZGroundCoord = isOnlyCemetery ? startZ : startZ + 2;
        this.fillWithBlocks(world, structureBoundingBox, startX, -5, startZGroundCoord, startX + 12, 0, startZ + 10, groundState, groundState, false);

        if (isOnlyCemetery) {
            this.fillWithBlocks(world, boundingBox, startX + 1, 1, startZ + 1, startX + 11, 1, startZ + 1, fenceState, fenceState, false);
            this.setBlockState(world, gateState, startX + 6, 1, startZ + 1, structureBoundingBox);
        }
        this.fillWithBlocks(world, boundingBox, startX + 1, 1, startZ + 9, startX + 11, 1, startZ + 9, fenceState, fenceState, false);

        this.fillWithBlocks(world, boundingBox, startX + 1, 1, startZ + 2, startX + 1, 1, startZ + 8, fenceState, fenceState, false);
        this.fillWithBlocks(world, boundingBox, startX + 11, 1, startZ + 2, startX + 11, 1, startZ + 8, fenceState, fenceState, false);

        this.setBlockState(world, gateState, startX + 6, 1, startZ + 9, structureBoundingBox);

        IBlockState graveState = StateHelper.getGravestone(this.getCoordBaseMode().getOpposite());
        EntityGroupOfGravesMobSpawnerHelper spawnerHelper = GraveGenerationHelper.createSpawnerHelper(world, boundingBox);

        for (int x = startX + 3; x < startX + 11; x += 2) {
            for (int z = 3 + startZ; z < 9 + startZ; z += 2) {
                if (!GraveGenerationHelper.isGraveAlreadyPlaced(world, this.getIXWithOffset(x, z), this.getIYWithOffset(1), this.getIZWithOffset(x, z))) {
                    GraveGenerationHelper.placeGrave(this, world, random, x, 1, z, graveState, spawnerHelper, EnumGraveTypeByEntity.HUMAN_GRAVES);
                }
            }
        }

        for (int x = startX; x <= startX + 11; x++) {
            for (int z = startZGroundCoord; z <= startZ + 9; z++) {
                this.clearCurrentPositionBlocksUpwards(world, x, CEMETERY_HEIGHT, z, structureBoundingBox);
                this.setBlockState(world, groundState, x, -1, z, structureBoundingBox);
            }
        }
    }

    //    @Override
    protected void placeDoorCurrentPosition(World worldIn, StructureBoundingBox boundingBoxIn, Random rand, int x, int y, int z, EnumFacing facing) {
        this.setBlockState(worldIn, Blocks.DARK_OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing), x, y, z, boundingBoxIn);
        this.setBlockState(worldIn, Blocks.DARK_OAK_DOOR.getDefaultState().withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER), x, y + 1, z, boundingBoxIn);
    }

    @Override
    protected void setBlockState(World world, IBlockState blockState, int x, int y, int z, StructureBoundingBox boundingBox) {
        int xPos = this.getXWithOffset(x, z);
        int yPos = this.getYWithOffset(y);
        int zPos = this.getZWithOffset(x, z);

        BlockPos pos = new BlockPos(xPos, yPos, zPos);
        if (boundingBox.isVecInside(pos)) {
            world.setBlockState(pos, blockState, 2);
        }
    }

    @Override
    protected net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession chooseForgeProfession(int count, net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession prof) {
        return VillagersHandler.undertakerProfession;
    }

    protected void generateBed(World world, int x, int y, int z, StructureBoundingBox boundingBox) {
        EnumFacing facing = getBedMeta(this.getCoordBaseMode());
        this.setBlockState(world, StateHelper.getBedState(StateHelper.BED_FOOT, facing), x, y, z, boundingBox);
        this.setBlockState(world, StateHelper.getBedState(StateHelper.BED_HEAD, facing), x + 1, y, z, boundingBox);
    }

    public static EnumFacing getBedMeta(EnumFacing direction) {
        switch (direction) {
            case WEST:
            case EAST:
                return EnumFacing.SOUTH;
            case SOUTH:
            case NORTH:
            default:
                return EnumFacing.EAST;
        }
    }

    public byte getSkullCandleDirection(EnumFacing direction) {
        switch (direction) {
            case SOUTH:
            case EAST:
                return 3;
            case WEST:
                return 5;
            case NORTH:
            default:
                return 1;
        }
    }

    protected void generateSkullCandle(World world, StructureBoundingBox boundingBox, int x, int y, int z, EnumFacing direction) {
        BlockPos pos = new BlockPos(this.getXWithOffset(x, z), this.getYWithOffset(y), this.getZWithOffset(x, z));
        if (world.getBlockState(pos).getBlock() != GSBlock.SKULL_CANDLE_SKELETON) {
            this.setBlockState(world, StateHelper.SKELETON_SKULL_CANDLE.withProperty(GSBlock.SKULL_CANDLE_SKELETON.FACING,
                    BlockSkullCandleSkeleton.EnumAdvancedFacing.getById(getSkullCandleDirection(direction))), x, y, z, boundingBox);

        }
    }

    private EntityPainting.EnumArt[] paintings = {
            EntityPainting.EnumArt.SKULL_AND_ROSES,
            EntityPainting.EnumArt.WITHER,
            EntityPainting.EnumArt.STAGE
    };

    protected void generatePainting(World world, int x, int y, int z, EnumFacing direction) {
        z += getPaintingZCoordinateShift(direction);
        int xCoord = this.getXWithOffset(x, z);
        int yCoord = this.getYWithOffset(y);
        int zCoord = this.getZWithOffset(x, z);

        if (checkPainting(world, xCoord, yCoord, zCoord)) {
            EntityPainting painting = new EntityPainting(world, new BlockPos(xCoord, yCoord, zCoord), getPaintingDirection(direction));
            painting.art = paintings[world.rand.nextInt(paintings.length)];
            world.spawnEntity(painting);
        }
    }

    public static int getPaintingZCoordinateShift(EnumFacing direction) {
        switch (direction) {
            case SOUTH:
            case WEST:
                return 1;
            default:
                return 0;
        }
    }

    public static EnumFacing getPaintingDirection(EnumFacing direction) {
        switch (direction) {
            case WEST:
            case EAST:
                return EnumFacing.SOUTH;
            case SOUTH:
            case NORTH:
            default:
                return EnumFacing.EAST;
        }
    }

    public static boolean checkPainting(World world, int x, int y, int z) {
        return world.getEntitiesWithinAABB(EntityPainting.class, new AxisAlignedBB(x, y, z, x, y, z).expand(1, 1, 1)).size() == 0;
    }

//    @Override
//    public NBTTagCompound createStructureBaseNBT() {
//        NBTTagCompound nbttagcompound = new NBTTagCompound();
//        nbttagcompound.setString("id", "GSVillageUndertaker");
//        nbttagcompound.setTag("BB", this.boundingBox.toNBTTagIntArray());
//        nbttagcompound.setInteger("O", this.getCoordBaseMode() == null ? -1 : this.getCoordBaseMode().getHorizontalIndex());
//        nbttagcompound.setInteger("GD", this.componentType);
//        this.writeStructureToNBT(nbttagcompound);
//        return nbttagcompound;
//    }

    @Override
    public void placeBlockAtCurrentPosition(World world, IBlockState blockState, int x, int y, int z, StructureBoundingBox boundingBox) {
        setBlockState(world, blockState, x, y, z, boundingBox);
    }

    @Override
    public int getXWithOffset(int x, int z) {
        return super.getXWithOffset(x, z);
    }

    @Override
    public int getIXWithOffset(int x, int z) {
        return getXWithOffset(x, z);
    }

    @Override
    public int getYWithOffset(int y) {
        return super.getYWithOffset(y);
    }

    @Override
    public int getIYWithOffset(int y) {
        return getYWithOffset(y);
    }

    @Override
    public int getZWithOffset(int x, int z) {
        return super.getZWithOffset(x, z);
    }

    @Override
    public int getIZWithOffset(int x, int z) {
        return getZWithOffset(x, z);
    }

    @Override
    public StructureBoundingBox getIBoundingBox() {
        return getBoundingBox();
    }
}
