package nightkosh.gravestone_extended.gui.container;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.gui.container.slot.AltarEnchantmentSkullSlot;
import nightkosh.gravestone_extended.gui.container.slot.AltarEnchantmentSlot;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;
import nightkosh.gravestone_extended.inventory.AltarEnchantmentInventory;

import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarEnchantmentContainer extends AltarContainer {

    protected AltarEnchantmentInventory inventory;
    public static final int PLAYER_INVENTORY_ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 9;
    public static final int SLOT_WIDTH = 18;

    public AltarEnchantmentContainer(InventoryPlayer inventoryPlayer, AltarEnchantmentInventory inventory) {
        this.inventory = inventory;

        this.addSlotToContainer(new AltarEnchantmentSlot(inventory, 0, 37, 35));
        this.addSlotToContainer(new AltarEnchantmentSkullSlot(inventory, 1, 68, 35));

        for (int row = 0; row < PLAYER_INVENTORY_ROWS_COUNT; row++) {
            for (int column = 0; column < COLUMNS_COUNT; column++) {
                this.addSlotToContainer(new Slot(inventoryPlayer, column + row * COLUMNS_COUNT + COLUMNS_COUNT, 8 + column * SLOT_WIDTH, 84 + row * SLOT_WIDTH));
            }
        }

        for (int column = 0; column < COLUMNS_COUNT; column++) {
            this.addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * SLOT_WIDTH, 142));
        }
    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return inventory.isUsableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack stackInSlot = slot.getStack();
            stack = stackInSlot.copy();

            if (index == 0 || index == 1) {
                if (!this.mergeItemStack(stackInSlot, 2, inventorySlots.size(), false)) {
                    return ItemStack.EMPTY;
                }
            } else if (stackInSlot.getItem() == GSItem.ENCHANTED_SKULL) {
                if (!this.mergeItemStack(stackInSlot, 1, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(stackInSlot, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (stackInSlot.getCount() == stack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, stackInSlot);
        }
        return stack;
    }

    @Override
    public int getRequiredLevel() {
        int requiredLevels = 0;

        if (!inventory.isEmpty()) {
            ItemStack enchItem = inventory.getEnchItem();
            ItemStack skull = inventory.getEnchSkull();
            Map<Enchantment, Integer> itemEnchantments;
            if (enchItem.getItem() == GSItem.ENCHANTED_SKULL) {
                itemEnchantments = GSEnchantmentHelper.getSkullEnchantments(enchItem);
            } else {
                itemEnchantments = EnchantmentHelper.getEnchantments(enchItem);
            }

            if (enchItem.getItem() != Items.SKULL && skull.getItem() == GSItem.ENCHANTED_SKULL) {
                Map<Enchantment, Integer> skullEnchantments = GSEnchantmentHelper.getSkullEnchantments(skull);

                for (Enchantment skullEnchantment : skullEnchantments.keySet()) {
                    if (skullEnchantment != null) {
                        int itemEnchLvl = itemEnchantments.containsKey(skullEnchantment) ? itemEnchantments.get(skullEnchantment) : 0;
                        if (itemEnchLvl < skullEnchantment.getMaxLevel()) {
                            int skullEnchLvl = skullEnchantments.get(skullEnchantment);
                            if (skullEnchLvl >= itemEnchLvl) {
                                if (itemEnchLvl == skullEnchLvl) {
                                    skullEnchLvl = skullEnchLvl + 1;
                                } else {
                                    skullEnchLvl = Math.max(skullEnchLvl, itemEnchLvl);
                                }

                                if (skullEnchantment.canApply(enchItem) || enchItem.getItem() == Items.BOOK) {
                                    boolean canApply = true;
                                    for (Enchantment enchantment : itemEnchantments.keySet()) {
                                        if (enchantment != skullEnchantment && !skullEnchantment.isCompatibleWith(enchantment)) {
                                            canApply = false;
                                            break;
                                        }
                                    }
                                    if (canApply) {
                                        switch (skullEnchantment.getRarity()) {
                                            case COMMON:
                                                requiredLevels += 2;
                                                break;
                                            case UNCOMMON:
                                                requiredLevels += 4;
                                                break;
                                            case RARE:
                                                requiredLevels += 8;
                                                break;
                                            case VERY_RARE:
                                                requiredLevels += 15;
                                        }
                                        requiredLevels += skullEnchLvl - itemEnchLvl;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return requiredLevels;
    }
}