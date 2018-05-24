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
public class ItemPieceOfMummyCloth extends Item {

    public ItemPieceOfMummyCloth() {
        this.setUnlocalizedName("gravestone.piece_of_mummy_cloth");
        this.setRegistryName(ModInfo.ID, "gs_piece_of_mummy_cloth");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }
}
