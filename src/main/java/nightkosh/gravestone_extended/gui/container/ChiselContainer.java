package nightkosh.gravestone_extended.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.api.grave.EnumGraveType;
import nightkosh.gravestone_extended.crafting.GravesCraftingManager;
import nightkosh.gravestone_extended.inventory.GraveRecipeInventory;

import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChiselContainer extends Container {

    public static final int PLAYER_INVENTORY_ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 9;
    public static final int SLOT_WIDTH = 18;
    public static final int CRAFTING_SLOTS_COUNT = 4;

    public InventoryCrafting craftMatrix = new InventoryCrafting(this, CRAFTING_SLOTS_COUNT, 1);
    public IInventory recipeMatrix = new GraveRecipeInventory(CRAFTING_SLOTS_COUNT);
    public IInventory craftResult = new InventoryCraftResult();

    private EntityPlayer player;
    private World world;

    public static final boolean IS_GRAVESTONE = true;
    public static final EnumGraveType TYPE = EnumGraveType.VERTICAL_PLATE;
    public static final EnumGraveMaterial MATERIAL = EnumGraveMaterial.WOOD;
    public static final boolean IS_ENCHANTED = false;
    public static final boolean IS_MOSSY = false;

    public boolean isGravestone = IS_GRAVESTONE;
    public EnumGraveType graveType = TYPE;
    public EnumGraveMaterial material = MATERIAL;
    public boolean isEnchanted = IS_ENCHANTED;
    public boolean isMossy = IS_MOSSY;
    //TODO sword;

    public ChiselContainer(EntityPlayer player, InventoryPlayer inventoryPlayer) {
        this.player = player;
        this.world = player.getEntityWorld();
        this.addSlotToContainer(new SlotCrafting(inventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 135, 90));

        for (int column = 0; column < CRAFTING_SLOTS_COUNT; column++) {
            this.addSlotToContainer(new Slot(this.craftMatrix, column, 23 + column * SLOT_WIDTH, 90));
        }

        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 2; column++) {
                this.addSlotToContainer(new GraveRecipeSlot(this.recipeMatrix, column + row * 2, 200 + column * SLOT_WIDTH, 86 + row * SLOT_WIDTH));
            }
        }

        for (int row = 0; row < PLAYER_INVENTORY_ROWS_COUNT; row++) {
            for (int column = 0; column < COLUMNS_COUNT; column++) {
                this.addSlotToContainer(new Slot(inventoryPlayer, column + row * COLUMNS_COUNT + COLUMNS_COUNT, 8 + column * SLOT_WIDTH, 114 + row * SLOT_WIDTH));
            }
        }

        for (int column = 0; column < COLUMNS_COUNT; column++) {
            this.addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * SLOT_WIDTH, 172));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {
        List<ItemStack> items = new ArrayList<>(inventory.getSizeInventory());
        for (int i = 0; i < inventory.getSizeInventory(); i++) {
            items.add(inventory.getStackInSlot(i));
        }

        this.craftResult.setInventorySlotContents(0, GravesCraftingManager.INSTANCE.findMatchingRecipe(items, isGravestone, graveType, material, isEnchanted, isMossy));
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);

        if (!this.world.isRemote) {
            for (int i = 0; i < CRAFTING_SLOTS_COUNT; i++) {
                ItemStack itemstack = this.craftMatrix.getStackInSlot(i);

                if (itemstack != null && itemstack != ItemStack.EMPTY) {
//                    player.dropPlayerItemWithRandomChoice(itemstack, false); //TODO
                    player.dropItem(itemstack, false);
                }
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 9 && index < 36) {
                if (!this.mergeItemStack(itemstack1, 36, 45, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 36 && index < 45) {
                if (!this.mergeItemStack(itemstack1, 9, 36, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 9, 45, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean canMergeSlot(ItemStack itemStack, Slot slot) {
        return slot.inventory != this.craftResult && slot.inventory != this.recipeMatrix && super.canMergeSlot(itemStack, slot);
    }

    @Override
    public void detectAndSendChanges() {
        List<ItemStack> items = GravesCraftingManager.INSTANCE.findMatchingRecipe(isGravestone, graveType, material, isEnchanted, isMossy);
        this.recipeMatrix.clear();
        if (items != null) {
            int slot = 0;
            for (ItemStack stack : items) {
                if (stack != null && stack != ItemStack.EMPTY) {
                    this.recipeMatrix.setInventorySlotContents(slot, stack.copy());
                }
                slot++;
            }
        }
        super.detectAndSendChanges();

//        if (player != null) {
//            NBTTagCompound nbt = new NBTTagCompound();// = player.getEntityData();
//            player.writeEntityToNBT(nbt);// = player.getEntityData().hasKey("GraveCrafting");
//            if (nbt != null && nbt.hasKey("GraveCrafting")) {
//                NBTTagCompound graveNbt = nbt.getCompoundTag("GraveCrafting");
//                isGravestone = graveNbt.getBoolean("IsGravestone");
//                graveType = EnumGraves.EnumGraveType.values()[graveNbt.getInteger("GraveType")];
//                material = EnumGraveMaterial.values()[graveNbt.getInteger("Material")];
//                isEnchanted = graveNbt.getBoolean("IsEnchanted");
//                isMossy = graveNbt.getBoolean("IsMossy");
//            }
//        }
    }
}
