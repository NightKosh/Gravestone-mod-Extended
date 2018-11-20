package nightkosh.gravestone_extended.item.tools.shovel;

import nightkosh.gravestone_extended.core.GSMaterials;
import nightkosh.gravestone_extended.core.GSTabs;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemDiamondBoneShovel extends ItemBoneShovel {

    public ItemDiamondBoneShovel() {
        super(GSMaterials.BONE_TOOL, "bone_shovel_diamond");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }
}
