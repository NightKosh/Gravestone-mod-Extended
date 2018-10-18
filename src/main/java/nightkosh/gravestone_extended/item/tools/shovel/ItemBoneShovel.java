package nightkosh.gravestone_extended.item.tools.shovel;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBoneShovel extends ItemPickaxe implements IBoneShovel {

    public ItemBoneShovel() {
        this(ToolMaterial.STONE, "bone_shovel");
    }

    public ItemBoneShovel(ToolMaterial material, String str) {
        super(material);
        this.setCreativeTab(GSTabs.otherItemsTab);
        this.setUnlocalizedName("gravestone." + str);
        this.setRegistryName(ModInfo.ID, str);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
    }
}
