package nightkosh.gravestone_extended.item.itemblock.skull_candle;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BISkullCandleSkeleton extends BlockItem {

    public BISkullCandleSkeleton() {
        super(GSEBlocks.SKULL_CANDLE_SKELETON.get(), new Item.Properties()
                .stacksTo(64)
                .setId(GSEBlocks.SKULL_CANDLE_SKELETON_RK));
    }

}
