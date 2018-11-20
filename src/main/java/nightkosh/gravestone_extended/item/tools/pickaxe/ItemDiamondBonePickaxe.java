package nightkosh.gravestone_extended.item.tools.pickaxe;

import nightkosh.gravestone_extended.core.GSMaterials;
import nightkosh.gravestone_extended.core.GSTabs;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemDiamondBonePickaxe extends ItemBonePickaxe {

    public ItemDiamondBonePickaxe() {
        super(GSMaterials.BONE_TOOL, "bone_pickaxe_diamond");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }
}
