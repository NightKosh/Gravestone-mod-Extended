package nightkosh.gravestone_extended.structures.village.undertaker;

import nightkosh.gravestone_extended.structures.GSStructureGenerator;

import java.util.Random;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class VillageCemeteryGenerator implements GSStructureGenerator {
    public static final VillageCemeteryGenerator INSTANCE = new VillageCemeteryGenerator();
//
//    @Override
//    public boolean generate(World world, Random rand, int x, int z, EnumFacing facing, double chance, boolean isCommand) {
//        if (isCommand) {
//            StructureBoundingBox boundingBox = ComponentVillageUndertaker.getBoundingBox(facing, x, z);
//            new ComponentVillageUndertaker(new StructureVillagePieces.Start(), 0, rand, boundingBox, facing)
//                    .generateComponent(world, rand, boundingBox, true);
//            return true;
//        }
//        return false;
//    }
}
