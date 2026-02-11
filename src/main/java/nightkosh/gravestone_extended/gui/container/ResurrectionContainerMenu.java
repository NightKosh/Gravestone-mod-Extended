package nightkosh.gravestone_extended.gui.container;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import nightkosh.gravestone_extended.block_entity.inventory.CorpseInventory;
import nightkosh.gravestone_extended.core.GSEItems;
import nightkosh.gravestone_extended.core.GSEMenus;
import nightkosh.gravestone_extended.gui.container.slot.CorpseSlot;
import nightkosh.gravestone_extended.item.corpse.CorpseHelper;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ResurrectionContainerMenu extends AAltarContainerMenu {

    protected CorpseInventory inventory;
    public static final int PLAYER_INVENTORY_ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 9;
    public static final int SLOT_WIDTH = 18;

    public ResurrectionContainerMenu(int containerId, Inventory inventoryPlayer, FriendlyByteBuf extraData) {
        this(containerId, inventoryPlayer, inventoryPlayer.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public ResurrectionContainerMenu(int containerId, Inventory inventoryPlayer, BlockEntity blockEntity) {
        super(GSEMenus.ALTAR_RESURRECTION.get(), containerId, blockEntity);
        this.inventory = this.altar.getCorpseInventory();
        this.inventory.startOpen(inventoryPlayer.player);

        this.addSlot(new CorpseSlot(inventory, 0, 37, 35));

        for (int row = 0; row < PLAYER_INVENTORY_ROWS_COUNT; row++) {
            for (int column = 0; column < COLUMNS_COUNT; column++) {
                this.addSlot(new Slot(inventoryPlayer, column + row * COLUMNS_COUNT + COLUMNS_COUNT,
                        8 + column * SLOT_WIDTH, 84 + row * SLOT_WIDTH));
            }
        }
        for (int column = 0; column < COLUMNS_COUNT; column++) {
            this.addSlot(new Slot(inventoryPlayer, column, 8 + column * SLOT_WIDTH, 142));
        }
    }

    @Nonnull
    @Override
    public ItemStack quickMoveStack(@Nonnull Player player, int index) {
        var stack = ItemStack.EMPTY;
        var slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            var stackInSlot = slot.getItem();
            stack = stackInSlot.copy();

            if (index == 0) {
                if (!this.moveItemStackTo(stackInSlot, 0, inventory.getContainerSize(), false)) {
                    return ItemStack.EMPTY;
                }
            } else if (stack.is(GSEItems.CORPSE_VILLAGER) ||
                    stack.is(GSEItems.CORPSE_DOG) || stack.is(GSEItems.CORPSE_CAT) ||
                    stack.is(GSEItems.CORPSE_HORSE)) {
                if (!this.moveItemStackTo(stackInSlot, 0, 0, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stackInSlot, 0, 0, false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
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
        return CorpseHelper.getRequiredLevel(inventory.getCorpse());
    }

    @Override
    public boolean stillValid(@Nonnull Player player) {
        return inventory.stillValid(player);
    }

    @Override
    public void removed(@Nonnull Player player) {
        super.removed(player);
        inventory.stopOpen(player);
    }

}
