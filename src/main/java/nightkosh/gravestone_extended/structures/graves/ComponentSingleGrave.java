package nightkosh.gravestone_extended.structures.graves;

import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.ComponentGraveStone;
import nightkosh.gravestone_extended.structures.GraveGenerationHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ComponentSingleGrave extends ComponentGraveStone {

//    public ComponentSingleGrave(int componentType, EnumFacing direction, Random random, int x, int z) {
//        super(componentType, direction);
//        boundingBox = new StructureBoundingBox(x, 0, z, x, 240, z);
//    }
//
//    /**
//     * Build component
//     */
//    @Override
//    public boolean addComponentParts(World world, Random random) {
//        int positionX, positionZ, y;
//        positionX = getIXWithOffset(0, 0);
//        positionZ = getIZWithOffset(0, 0);
//        y = world.getTopSolidOrLiquidBlock(new BlockPos(positionX, 0, positionZ)).getY() - boundingBox.minY;
//
//        if (GraveGenerationHelper.canPlaceGrave(world, positionX, boundingBox.minY + y, positionZ, boundingBox.maxY)) {
//            GSLogger.logInfo("Generate grave at " + positionX + "x" + positionZ);
//
//            GraveGenerationHelper.placeGrave(this, world, random, 0, y, 0, StateHelper.getGravestone(this.getCoordBaseMode().getOpposite()), null);
//        }
//
//        return true;
//    }

//    @Override
//    public NBTTagCompound createStructureBaseNBT() {
//        NBTTagCompound nbttagcompound = new NBTTagCompound();
//        nbttagcompound.setString("id", "GSSingleGrave");
//        nbttagcompound.setTag("BB", this.boundingBox.toNBTTagIntArray());
//        nbttagcompound.setInteger("O", this.getCoordBaseMode() == null ? -1 : this.getCoordBaseMode().getHorizontalIndex());
//        nbttagcompound.setInteger("GD", this.componentType);
//        this.writeStructureToNBT(nbttagcompound);
//        return nbttagcompound;
//    }
}
