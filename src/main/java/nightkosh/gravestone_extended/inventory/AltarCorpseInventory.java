package nightkosh.gravestone_extended.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarCorpseInventory implements IInventory {

    private TileEntityAltar te;
    private ItemStack corpse = ItemStack.EMPTY;

    public AltarCorpseInventory(TileEntityAltar te) {
        this.te = te;
    }


    public void readItems(NBTTagCompound nbtTag) {
        if (nbtTag.hasKey("Corpse")) {
            corpse = new ItemStack(nbtTag.getCompoundTag("Corpse"));
        }
    }

    public void saveItems(NBTTagCompound nbtTag) {
        if (!corpse.isEmpty()) {
            nbtTag.setTag("Corpse", corpse.writeToNBT(new NBTTagCompound()));
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return false;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return null;
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return corpse.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.corpse;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        this.corpse = stack;
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null && !stack.isEmpty()) {
            if (stack.getCount() <= amt) {
                setInventorySlotContents(slot, ItemStack.EMPTY);
            } else {
                stack = stack.splitStack(amt);
                if (stack.isEmpty()) {
                    setInventorySlotContents(slot, ItemStack.EMPTY);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = getStackInSlot(index);
        if (stack != null && !stack.isEmpty()) {
            setInventorySlotContents(index, ItemStack.EMPTY);
        }
        return stack;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return te.getWorld().getTileEntity(te.getPos()) == te &&
                player.getDistanceSq(new BlockPos(te.getPos().getX() + 0.5, te.getPos().getY() + 0.5, te.getPos().getZ() + 0.5)) < 64;
    }
}
