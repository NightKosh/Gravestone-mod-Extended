package nightkosh.gravestone_extended.gui.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSItem;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarEnchantmentSkullSlot extends Slot {

    public AltarEnchantmentSkullSlot(IInventory inventory, int slotNum, int xPos, int yPos) {
        super(inventory, slotNum, xPos, yPos);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() == GSItem.ENCHANTED_SKULL;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}
