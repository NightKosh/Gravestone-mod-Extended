package nightkosh.gravestone_extended.item.itemblock.bone_block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import nightkosh.gravestone_extended.core.GSEBlocks;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BIBoneBlock extends BlockItem {

    public BIBoneBlock() {
        super(GSEBlocks.BONE_BLOCK.get(), new Item.Properties()
                .stacksTo(64)
                .setId(GSEBlocks.BONE_BLOCK_RK));
    }

}
