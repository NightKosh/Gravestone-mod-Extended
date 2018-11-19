package nightkosh.gravestone_extended.item.armor.bone;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSMaterials;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AbstractBoneArmor extends ItemArmor implements IBoneArmor {

    public AbstractBoneArmor(EntityEquipmentSlot equipmentSlotIn) {
        super(GSMaterials.BONE_ARMOR, 1, equipmentSlotIn);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return super.getIsRepairable(toRepair, repair) || repair.getItem() == Item.getItemFromBlock(GSBlock.BONE_BLOCK);
    }
}
