package nightkosh.gravestone_extended.item.tools.axe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSMaterials;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemDiamondBoneAxe extends ItemAxe implements IBoneAxe {

    public ItemDiamondBoneAxe() {
        super(GSMaterials.BONE_TOOL, 9, -2.9F);
        this.setUnlocalizedName("gravestone.bone_axe_diamond");
        this.setRegistryName(ModInfo.ID, "gs_bone_axe_diamond");
        this.setCreativeTab(GSTabs.otherItemsTab);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
    }
}
