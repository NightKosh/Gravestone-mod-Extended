package nightkosh.gravestone_extended.item.itemblock.glass;

import net.minecraft.world.item.BlockItem;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BIWitheredGlass extends BlockItem {

    public BIWitheredGlass() {
        super(GSEBlocks.WITHERED_GLASS.get(), new Properties()
                .stacksTo(64)
                .setId(GSEBlocks.WITHERED_GLASS_RK));
    }

}
