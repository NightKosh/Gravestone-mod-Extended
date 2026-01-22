package nightkosh.gravestone_extended.block_entity.inventory;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ItemStackWithSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DisenchantmentInventory implements Container {

    private final AltarBlockEntity altar;
    private static final int INVENTORY_SIZE = 6;

    public static final int ENCHANTED_SLOT = 0;

    protected NonNullList<ItemStack> items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);

    public DisenchantmentInventory(AltarBlockEntity altar) {
        this.altar = altar;
    }

    public void loadAdditional(@Nonnull ValueInput in) {
        for (var itemstackwithslot : in.listOrEmpty(getKeyName(), ItemStackWithSlot.CODEC)) {
            if (itemstackwithslot.isValidInContainer(this.items.size())) {
                this.items.set(itemstackwithslot.slot(), itemstackwithslot.stack());
            }
        }
    }

    public void saveAdditional(@Nonnull ValueOutput out) {
        var typedoutputlist = out.list(getKeyName(), ItemStackWithSlot.CODEC);

        for (int i = 0; i < this.items.size(); i++) {
            var itemstack = this.items.get(i);
            if (!itemstack.isEmpty()) {
                typedoutputlist.add(new ItemStackWithSlot(i, itemstack));
            }
        }

        if (typedoutputlist.isEmpty()) {
            out.discard(getKeyName());
        }
    }

    @Override
    public int getContainerSize() {
        return INVENTORY_SIZE;
    }

    @Override
    public boolean isEmpty() {
        for (var s : items) {
            if (!s.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Nonnull
    public ItemStack getEnchItem() {
        return this.getItem(ENCHANTED_SLOT);
    }

    @Nonnull
    @Override
    public ItemStack getItem(int slot) {
        return this.items.get(slot);
    }

    public void removeEnchantedItem() {
        removeItemNoUpdate(ENCHANTED_SLOT);
    }

    @Nonnull
    @Override
    public ItemStack removeItem(int slot, int amount) {
        return removeItemNoUpdate(slot);
    }

    @Nonnull
    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        var stack = getItem(slot);
        if (!stack.isEmpty()) {
            this.items.set(slot, ItemStack.EMPTY);
        }
        return stack;
    }

    @Override
    public void setItem(int slot, @Nonnull ItemStack stack) {
        this.items.set(slot, stack);
    }

    @Override
    public void setChanged() {
        altar.setChanged();
    }

    @Override
    public boolean stillValid(@Nonnull Player player) {
        return player.level().getBlockEntity(
                this.altar.getBlockPos()) == this.altar &&
                player.distanceToSqr(
                        this.altar.getBlockPos().getX() + 0.5,
                        this.altar.getBlockPos().getY() + 0.5,
                        this.altar.getBlockPos().getZ() + 0.5) < 64;
    }

    @Override
    public void clearContent() {
        this.items.clear();
        this.items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        this.setChanged();
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }

    protected String getKeyName() {
        return "Disenchant";
    }

}
