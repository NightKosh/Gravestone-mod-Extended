package nightkosh.gravestone_extended.structures.village.memorial;

import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.IComponentGraveStone;
import nightkosh.gravestone_extended.structures.MemorialGenerationHelper;

import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ComponentVillageMemorial {//TODO extends StructureVillagePieces.Village implements IComponentGraveStone {

    private int averageGroundLevel = -1;
    private static final int HEIGHT = 6;

    public ComponentVillageMemorial() {
    }
//
//    public ComponentVillageMemorial(StructureVillagePieces.Start startPiece, int componentType, Random random, StructureBoundingBox structureBoundingBox, EnumFacing direction) {
//        super(startPiece, componentType);
//        this.setCoordBaseMode(direction);
//        this.boundingBox = structureBoundingBox;
//    }
//
//    public static ComponentVillageMemorial buildComponent(StructureVillagePieces.Start startPiece, List list, Random random, int par3, int par4, int par5, EnumFacing direction, int componentType) {
//        StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 5, HEIGHT, 5, direction);
//        return canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new ComponentVillageMemorial(startPiece, componentType, random, structureBoundingBox, direction) : null;
//    }
//
//    /**
//     * second Part of Structure generating, this for example places Spiderwebs,
//     * Mob Spawners, it closes Mineshafts at the end, it adds Fences...
//     */
//    @Override
//    public boolean addComponentParts(World world, Random random, StructureBoundingBox structureBoundingBox) {
//        if (this.averageGroundLevel < 0) {
//            this.averageGroundLevel = this.getAverageGroundLevel(world, structureBoundingBox);
//
//            if (this.averageGroundLevel < 0) {
//                return true;
//            }
//
//            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + HEIGHT - 2, 0);
//        }
//
//        IBlockState groundState;
//        Biome biome = world.getBiome(new BlockPos(this.getXWithOffset(0, 0), this.getYWithOffset(0), this.getZWithOffset(0, 0)));
//        if (biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS) {
//            groundState = StateHelper.SAND;
//        } else {
//            groundState = StateHelper.GRASS;
//        }
//
//        this.fillWithBlocks(world, structureBoundingBox, 0, -5, 0, 5, 0, 5, groundState, groundState, false);
//
//        MemorialGenerationHelper.placeMemorial(this, world, random, 2, 1, 2, this.getCoordBaseMode().getOpposite());
//
//        for (int x = 0; x < 5; x++) {
//            for (int z = 0; z < 5; z++) {
//                this.clearCurrentPositionBlocksUpwards(world, x, HEIGHT, z, structureBoundingBox);
//                this.setBlockState(world, groundState, x, -1, z, structureBoundingBox);
//            }
//        }
//
//        return true;
//    }
//
//    @Override
//    public void setBlockState(World world, IBlockState blockState, int x, int y, int z, StructureBoundingBox boundingBox) {
//        super.setBlockState(world, blockState, x, y, z, boundingBox);
//    }
//
//    @Override
//    public void placeBlockAtCurrentPosition(World world, IBlockState blockState, int x, int y, int z, StructureBoundingBox boundingBox) {
//        setBlockState(world, blockState, x, y, z, boundingBox);
//    }
//
//    @Override
//    public StructureBoundingBox getIBoundingBox() {
//        return getBoundingBox();
//    }
//
//    @Override
//    public int getIXWithOffset(int x, int z) {
//        return getXWithOffset(x, z);
//    }
//
//    @Override
//    public int getIYWithOffset(int y) {
//        return getYWithOffset(y);
//    }
//
//    @Override
//    public int getIZWithOffset(int x, int z) {
//        return getZWithOffset(x, z);
//    }

//    @Override
//    public NBTTagCompound createStructureBaseNBT() {
//        NBTTagCompound nbttagcompound = new NBTTagCompound();
//        nbttagcompound.setString("id", "GSVillageMemorial");
//        nbttagcompound.setTag("BB", this.boundingBox.toNBTTagIntArray());
//        nbttagcompound.setInteger("O", this.getCoordBaseMode() == null ? -1 : this.getCoordBaseMode().getHorizontalIndex());
//        nbttagcompound.setInteger("GD", this.componentType);
//        this.writeStructureToNBT(nbttagcompound);
//        return nbttagcompound;
//    }
}
