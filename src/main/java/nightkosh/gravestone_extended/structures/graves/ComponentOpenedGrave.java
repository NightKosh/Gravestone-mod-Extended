package nightkosh.gravestone_extended.structures.graves;

import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;
import nightkosh.gravestone_extended.helper.StateHelper;
import nightkosh.gravestone_extended.structures.BoundingBoxHelper;
import nightkosh.gravestone_extended.structures.ComponentGraveStone;
import nightkosh.gravestone_extended.structures.GraveGenerationHelper;
import nightkosh.gravestone_extended.structures.ObjectsGenerationHelper;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ComponentOpenedGrave extends ComponentGraveStone {
//    protected ComponentOpenedGrave(int componentType, EnumFacing facing, Random random, int x, int z) {
//        super(componentType, facing);
//        boundingBox = BoundingBoxHelper.getCorrectBox(facing, x, 0, z, 1, 240, 3);
//    }
//
//    @Override
//    public boolean addComponentParts(World world, Random random) {
//        int gravePositionX, gravePositionZ, y;
//        gravePositionX = getXWithOffset(0, 2);
//        gravePositionZ = getZWithOffset(0, 2);
//        y = world.getTopSolidOrLiquidBlock(new BlockPos(gravePositionX, 0, gravePositionZ)).getY() - boundingBox.minY;
//
//        if (GraveGenerationHelper.canPlaceGrave(world, gravePositionX, boundingBox.minY + y, gravePositionZ, boundingBox.maxY)) {
//            GSLogger.logInfo("Generate opened grave at " + gravePositionX + "x" + gravePositionZ);
//
//            GraveGenerationHelper.placeGrave(this, world, random, 0, y, 2,
//                    StateHelper.getGravestone(this.getCoordBaseMode().getOpposite()),
//                    null, EnumGraveTypeByEntity.HUMAN_GRAVES, GraveInventoryHelper.GraveContentType.RANDOM);
//                    //, GraveInventory.GraveCorpseContentType.EMPTY); TODO
//
//            this.fillWithAir(world, this.boundingBox, 0, y - 1, 0, 0, y + 1, 1);
//            ObjectsGenerationHelper.generatePileOfBones(this, world, 0, y - 2, 0, this.getCoordBaseMode(), EnumPileOfBones.PILE_OF_BONES);
//            ObjectsGenerationHelper.generatePileOfBones(this, world, 0, y - 2, 1, this.getCoordBaseMode(), EnumPileOfBones.PILE_OF_BONES_WITH_SKULL);
//        }
//
//        return true;
//    }
}
