package nightkosh.gravestone_extended.structures.catacombs;

import net.minecraft.world.gen.structure.StructureComponent;
import nightkosh.gravestone_extended.helper.StateHelper;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CatacombsPileOfBonesSelector extends StructureComponent.BlockSelector {

    protected static final float PILE_OF_BONES_GENERATION_CHANCE = 0.35F;

    public CatacombsPileOfBonesSelector() {
    }

    @Override
    public void selectBlocks(Random random, int x, int y, int z, boolean wall) {
        selectBlocks(random, wall);
    }

    public boolean selectBlocks(Random random, boolean wall) {
        if (wall && random.nextFloat() <= PILE_OF_BONES_GENERATION_CHANCE) {
            selectPileOfBones(random);
            return true;
        } else {
            this.blockstate = StateHelper.AIR;
            return false;
        }
    }

    private void selectPileOfBones(Random random) {
        if (random.nextInt(30) == 0) {
            if (random.nextBoolean()) {
                this.blockstate = StateHelper.PILE_OF_BONES_WITH_SKULL_CRAWLER;
            } else {
                this.blockstate = StateHelper.PILE_OF_BONES_WITH_SKULL;
            }
        } else {
            this.blockstate = StateHelper.PILE_OF_BONES;
        }
    }
}