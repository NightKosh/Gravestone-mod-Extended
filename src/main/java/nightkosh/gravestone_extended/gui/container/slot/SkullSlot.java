package nightkosh.gravestone_extended.gui.container.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SkullSlot extends Slot {

    public SkullSlot(Container container, int slotNum, int xPos, int yPos) {
        super(container, slotNum, xPos, yPos);
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        return stack.is(Items.SKELETON_SKULL) ||
                stack.is(Items.WITHER_SKELETON_SKULL);
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

}
