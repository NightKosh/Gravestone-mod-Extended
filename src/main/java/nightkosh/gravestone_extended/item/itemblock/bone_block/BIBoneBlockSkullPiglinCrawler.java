package nightkosh.gravestone_extended.item.itemblock.bone_block;

import net.minecraft.world.item.BlockItem;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BIBoneBlockSkullPiglinCrawler extends BlockItem {

    public BIBoneBlockSkullPiglinCrawler() {
        super(GSEBlocks.BONE_BLOCK_SKULL_PIGLIN_CRAWLER.get(), new Properties()
                .stacksTo(64)
                .setId(GSEBlocks.BONE_BLOCK_SKULL_PIGLIN_CRAWLER_RK));
    }

}
