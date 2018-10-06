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
public class AltarEnchantmentInventory implements IInventory {

    private TileEntityAltar te;

    private ItemStack enchItem = ItemStack.EMPTY;
    private ItemStack enchSkull = ItemStack.EMPTY;


    public AltarEnchantmentInventory(TileEntityAltar te) {
        this.te = te;
    }

    public void readItems(NBTTagCompound nbtTag) {
        if (nbtTag.hasKey("EnchantedItem")) {
            enchItem = new ItemStack(nbtTag.getCompoundTag("EnchantedItem"));
        }
        if (nbtTag.hasKey("EnchantedSkull")) {
            enchSkull = new ItemStack(nbtTag.getCompoundTag("EnchantedSkull"));
        }
    }

    public void saveItems(NBTTagCompound nbtTag) {
        if (!enchItem.isEmpty()) {
            nbtTag.setTag("EnchantedItem", enchItem.writeToNBT(new NBTTagCompound()));
        }
        if (!enchItem.isEmpty()) {
            nbtTag.setTag("EnchantedSkull", enchSkull.writeToNBT(new NBTTagCompound()));
        }
    }

    public ItemStack getEnchItem() {
        return enchItem;
    }

    public void setEnchItem(ItemStack enchItem) {
        this.enchItem = enchItem;
    }


    public ItemStack getEnchSkull() {
        return enchSkull;
    }

    public void setEnchSkull(ItemStack enchSkull) {
        this.enchSkull = enchSkull;
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
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return enchItem.isEmpty() && enchSkull.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot == 0) {
            return this.getEnchItem();
        } else {
            return this.getEnchSkull();
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        if (slot == 0) {
            this.setEnchItem(stack);
        } else {
            this.setEnchSkull(stack);
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
