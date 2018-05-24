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
public class ItemRavenClaws extends Item {

    public ItemRavenClaws() {
        this.setUnlocalizedName("gravestone.raven_claws");
        this.setRegistryName(ModInfo.ID, "gs_raven_claws");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }
}
