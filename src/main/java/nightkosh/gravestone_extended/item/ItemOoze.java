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
public class ItemOoze extends Item {

    public ItemOoze() {
        this.setUnlocalizedName("gravestone.ooze");
        this.setRegistryName(ModInfo.ID, "gs_ooze");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }
}
