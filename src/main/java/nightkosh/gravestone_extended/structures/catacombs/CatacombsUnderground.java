package nightkosh.gravestone_extended.structures.catacombs;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.structures.catacombs.components.CatacombsBaseComponent;
import nightkosh.gravestone_extended.structures.catacombs.components.CatacombsPortal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatacombsUnderground {

    public static final int LEVELS_COUNT = 4;

    public static void build(World world, Random rand, EnumFacing direction, int x, int z) {
        CatacombsBaseComponent portal = new CatacombsPortal(direction, 1, rand, x, 100, z);
        portal.addComponentParts(world, rand);

        List<CatacombsBaseComponent> startComponents = new ArrayList<>();
        startComponents.add(portal);
        CatacombsLevel level = null;
        for (int levelNum = 1; levelNum <= LEVELS_COUNT; levelNum++) {
            level = new CatacombsLevel((levelNum == 1) ? startComponents : level.getEndParts(), levelNum, world, rand);
        }
    }
}