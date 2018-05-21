package nightkosh.gravestone_extended.item;

import net.minecraft.item.Item;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemPieceOfDivingSuit extends Item {

    public ItemPieceOfDivingSuit() {
        this.setUnlocalizedName("gravestone.piece_of_diving_suit");
        this.setRegistryName(ModInfo.ID, "gs_piece_of_diving_suit");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }
}
