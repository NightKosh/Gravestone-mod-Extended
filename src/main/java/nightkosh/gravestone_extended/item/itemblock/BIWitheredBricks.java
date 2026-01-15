package nightkosh.gravestone_extended.item.itemblock;

import net.minecraft.world.item.BlockItem;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BIWitheredBricks extends BlockItem {

    public BIWitheredBricks() {
        super(GSEBlocks.WITHERED_BRICKS.get(), new Properties()
                .stacksTo(64)
                .setId(GSEBlocks.WITHERED_BRICKS_RK));
    }

}
