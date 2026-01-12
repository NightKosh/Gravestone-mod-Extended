package nightkosh.gravestone_extended.item.itemblock.pile_of_bones;

import net.minecraft.world.item.BlockItem;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BIPileOfBonesDrowned extends BlockItem {

    public BIPileOfBonesDrowned() {
        super(GSEBlocks.PILE_OF_BONES_SKULL_DROWNED.get(), new Properties()
                .stacksTo(64)
                .setId(GSEBlocks.PILE_OF_BONES_SKULL_DROWNED_RK));
    }

}
