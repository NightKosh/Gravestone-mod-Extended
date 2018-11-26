package nightkosh.gravestone_extended.item.tools.pickaxe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBonePickaxe extends ItemPickaxe implements IBonePickaxe {

    public ItemBonePickaxe() {
        this(Item.ToolMaterial.STONE, "bone_pickaxe");
    }

    public ItemBonePickaxe(Item.ToolMaterial material, String str) {
        super(material);
        this.setUnlocalizedName("gravestone." + str);
        this.setRegistryName(ModInfo.ID, "gs_" + str);
        this.setCreativeTab(null);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
    }
}
