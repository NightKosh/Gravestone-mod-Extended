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
public class ItemRavenFeather extends Item {

    public ItemRavenFeather() {
        this.setUnlocalizedName("gravestone.raven_feather");
        this.setRegistryName(ModInfo.ID, "gs_raven_feather");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }
}
