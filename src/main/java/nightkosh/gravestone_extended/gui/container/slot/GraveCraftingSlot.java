package nightkosh.gravestone_extended.gui.container.slot;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveCraftingSlot {//TODO extends SlotCrafting {
//
//    protected final InventoryCrafting craftMatrix;
//    protected final IInventory recipeMatrix;
//    protected final EntityPlayer player;
//
//    public GraveCraftingSlot(EntityPlayer player, InventoryCrafting craftingInventory, IInventory inventory, IInventory recipeMatrix, int slotIndex, int xPosition, int yPosition) {
//        super(player, craftingInventory, inventory, slotIndex, xPosition, yPosition);
//        this.craftMatrix = craftingInventory;
//        this.recipeMatrix = recipeMatrix;
//        this.player = player;
//    }
//
//    @Override
//    public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {
//        this.onCrafting(stack);
//
//        for (int slot = 0; slot < recipeMatrix.getSizeInventory(); slot++) {
//            ItemStack recipeStack = recipeMatrix.getStackInSlot(slot).copy();
//
//            for (int craftSlot = 0; craftSlot < craftMatrix.getSizeInventory(); craftSlot++) {
//                ItemStack itemstack = this.craftMatrix.getStackInSlot(craftSlot);
//                if (!itemstack.isEmpty() && ((itemstack.getItem() == Items.ENCHANTED_BOOK && recipeStack.getItem() == Items.ENCHANTED_BOOK) ||
//                        ItemStack.areItemsEqual(itemstack, recipeStack) && ItemStack.areItemStackTagsEqual(itemstack, recipeStack))) {
//                    this.craftMatrix.decrStackSize(craftSlot, recipeStack.getCount());
//                    break;
//                }
//            }
//        }
//
//        return stack;
//    }
}
