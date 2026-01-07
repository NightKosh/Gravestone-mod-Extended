package nightkosh.gravestone_extended.structures.graves;

import nightkosh.gravestone_extended.config.ExtendedConfig;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class OpenedGraveGenerator extends SingleGraveGenerator {
    public static final OpenedGraveGenerator INSTANCE = new OpenedGraveGenerator();

//
//    @Override
//    public boolean generate(World world, Random rand, int x, int z, EnumFacing direction, double chance, boolean isCommand) {
//        if (!isCommand) {
//            x += 7;
//            z += 7;
//        }
//        if (isCommand || (ExtendedConfig.generateSingleGraves && canSpawnStructureAtCoords(world, x, z, chance))) {
//            new ComponentOpenedGrave(0, direction, rand, x, z).addComponentParts(world, rand);
//            structuresList.add(new ChunkPos(x, z));
//            return true;
//        }
//
//        return false;
//    }
}
