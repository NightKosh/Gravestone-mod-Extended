package nightkosh.gravestone_extended.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.gui.container.slot.AltarCorpseSlot;
import nightkosh.gravestone_extended.inventory.AltarCorpseInventory;
import nightkosh.gravestone_extended.item.corpse.CorpseHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarResurrectionContainer extends AltarContainer {

    protected AltarCorpseInventory inventory;
    public static final int PLAYER_INVENTORY_ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 9;
    public static final int SLOT_WIDTH = 18;

    public AltarResurrectionContainer(InventoryPlayer inventoryPlayer, AltarCorpseInventory inventory) {
        this.inventory = inventory;

        this.addSlotToContainer(new AltarCorpseSlot(inventory, 0, 37, 35));

        for (int row = 0; row < PLAYER_INVENTORY_ROWS_COUNT; ++row) {
            for (int column = 0; column < COLUMNS_COUNT; ++column) {
                this.addSlotToContainer(new Slot(inventoryPlayer, column + row * COLUMNS_COUNT + COLUMNS_COUNT, 8 + column * SLOT_WIDTH, 84 + row * SLOT_WIDTH));
            }
        }

        for (int column = 0; column < COLUMNS_COUNT; ++column) {
            this.addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * SLOT_WIDTH, 142));
        }
    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return inventory.isUsableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slotObject = inventorySlots.get(slot);

        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            if (slot == 0) {
                if (!this.mergeItemStack(stackInSlot, 0, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (this.inventorySlots.get(0).getHasStack() || !this.inventorySlots.get(0).isItemValid(stackInSlot)) {
                    return ItemStack.EMPTY;
                }

                if (stackInSlot.hasTagCompound() && stackInSlot.getCount() == 1) {
                    this.inventorySlots.get(0).putStack(stackInSlot.copy());
                    stackInSlot.setCount(0);
                } else if (stackInSlot.getCount() >= 1) {
                    ItemStack newStack = new ItemStack(stackInSlot.getItem(), 1, stackInSlot.getItemDamage());
                    if (stackInSlot.hasTagCompound()) {
                        newStack.setTagCompound(stackInSlot.getTagCompound().copy());
                    }
                    this.inventorySlots.get(0).putStack(newStack);
                    stackInSlot.setCount(stackInSlot.getCount() - 1);
                }
            }

            if (stackInSlot.isEmpty()) {
                slotObject.putStack(ItemStack.EMPTY);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.getCount() == stack.getCount()) {
                return ItemStack.EMPTY;
            }
            slotObject.onTake(player, stackInSlot);
        }
        return stack;
    }

    @Override
    public int getRequiredLevel() {
        return CorpseHelper.getRequiredLevel(inventory.getStackInSlot(0));
    }
}