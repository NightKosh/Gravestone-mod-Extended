package nightkosh.gravestone_extended.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import nightkosh.gravestone_extended.gui.container.slot.AltarDisenchantmentSkullSlot;
import nightkosh.gravestone_extended.gui.container.slot.AltarDisenchantmentSlot;
import nightkosh.gravestone_extended.inventory.AltarDisenchantmentInventory;

import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarDisenchantmentContainer extends Container {

    protected AltarDisenchantmentInventory inventory;
    public static final int PLAYER_INVENTORY_ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 9;
    public static final int SLOT_WIDTH = 18;

    public AltarDisenchantmentContainer(InventoryPlayer inventoryPlayer, AltarDisenchantmentInventory inventory) {
        this.inventory = inventory;

        this.addSlotToContainer(new AltarDisenchantmentSlot(inventory, 0, 37, 35));
        this.addSlotToContainer(new AltarDisenchantmentSkullSlot(inventory, 1, 19, 10));
        this.addSlotToContainer(new AltarDisenchantmentSkullSlot(inventory, 2, 55, 10));
        this.addSlotToContainer(new AltarDisenchantmentSkullSlot(inventory, 3, 8, 45));
        this.addSlotToContainer(new AltarDisenchantmentSkullSlot(inventory, 4, 65, 45));
        this.addSlotToContainer(new AltarDisenchantmentSkullSlot(inventory, 5, 37, 63));

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

    public int getDisenchantmentLevel() {
        int requiredLevels = 0;
        if (!inventory.isEmpty()) {
            List<NBTBase> enchantments = new ArrayList<>();
            for (NBTBase nbt : inventory.getEnchItem().getEnchantmentTagList()) {
                enchantments.add(nbt);
            }
            if (!enchantments.isEmpty()) {
                int skullNum = 0;
                for (int i = 1; i < inventory.getSizeInventory(); i++) {
                    ItemStack skull = inventory.getStackInSlot(i);
                    if (skull != ItemStack.EMPTY && skull.getItem() == Items.SKULL) {
                        requiredLevels += 10;
                        requiredLevels += ((NBTTagCompound) enchantments.get(skullNum)).getShort("lvl");

                        skullNum++;
                        if (skullNum >= enchantments.size()) {
                            break;
                        }
                    }
                }
            }
        }
        return requiredLevels;
    }
}