package nightkosh.gravestone_extended.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveCraftingSlot extends SlotCrafting {

    protected final InventoryCrafting craftMatrix;
    protected final IInventory recipeMatrix;
    protected final EntityPlayer player;

    public GraveCraftingSlot(EntityPlayer player, InventoryCrafting craftingInventory, IInventory inventory, IInventory recipeMatrix, int slotIndex, int xPosition, int yPosition) {
        super(player, craftingInventory, inventory, slotIndex, xPosition, yPosition);
        this.craftMatrix = craftingInventory;
        this.recipeMatrix = recipeMatrix;
        this.player = player;
    }

    @Override
    public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
        this.onCrafting(stack);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(thePlayer);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);

        for (int slot = 0; slot < recipeMatrix.getSizeInventory(); slot++) {
            ItemStack itemstack = this.craftMatrix.getStackInSlot(slot);
            ItemStack recipeStack = recipeMatrix.getStackInSlot(slot).copy();

            if (!itemstack.isEmpty() && ((itemstack.getItem() == Items.ENCHANTED_BOOK && recipeStack.getItem() == Items.ENCHANTED_BOOK) ||
                    ItemStack.areItemsEqual(itemstack, recipeStack) && ItemStack.areItemStackTagsEqual(itemstack, recipeStack))) {
                this.craftMatrix.decrStackSize(slot, recipeStack.getCount());
            }
        }

        return stack;
    }
}
