package nightkosh.gravestone_extended.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

import java.util.Arrays;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarDisenchantmentInventory implements IInventory {

    private TileEntityAltar te;
    private static final int SKULL_LIST_SIZE = 5;

    private ItemStack enchItem = ItemStack.EMPTY;
    protected ItemStack[] skulls = new ItemStack[SKULL_LIST_SIZE];


    public AltarDisenchantmentInventory(TileEntityAltar te) {
        this.te = te;
        Arrays.fill(skulls, ItemStack.EMPTY);
    }

    public void readItems(NBTTagCompound nbtTag) {
        if (nbtTag.hasKey("DisenchantedItem")) {
            enchItem = new ItemStack(nbtTag.getCompoundTag("DisenchantedItem"));
        }

        NBTTagList ntbItemsList = nbtTag.getTagList("Skulls", 10);

        for (int i = 0; i < ntbItemsList.tagCount(); i++) {
            skulls[i] = new ItemStack(ntbItemsList.getCompoundTagAt(i));
        }
    }

    public void saveItems(NBTTagCompound nbtTag) {
        if (!enchItem.isEmpty()) {
            nbtTag.setTag("DisenchantedItem", enchItem.writeToNBT(new NBTTagCompound()));
        }

        NBTTagList ntbList = new NBTTagList();

        for (ItemStack stack : skulls) {
            if (stack != null) {
                NBTTagCompound nbt = new NBTTagCompound();
                stack.writeToNBT(nbt);
                ntbList.appendTag(nbt);
            }
        }

        nbtTag.setTag("Skulls", ntbList);
    }


    public ItemStack getEnchItem() {
        return enchItem;
    }

    public void setEnchItem(ItemStack enchItem) {
        this.enchItem = enchItem;
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
        return SKULL_LIST_SIZE + 1;
    }

    @Override
    public boolean isEmpty() {
        return enchItem.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot == 0) {
            return this.getEnchItem();
        } else {
            return skulls[slot - 1];
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if (slot == 0) {
            this.setEnchItem(stack);
        } else {
            skulls[slot - 1] = stack;
        }
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
