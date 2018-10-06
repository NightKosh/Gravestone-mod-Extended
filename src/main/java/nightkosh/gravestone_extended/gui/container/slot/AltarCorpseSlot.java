package nightkosh.gravestone_extended.gui.container.slot;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.block.BlockCorpse;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.entity.monster.pet.EnumUndeadMobType;
import nightkosh.gravestone_extended.item.corpse.CorpseHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarCorpseSlot extends Slot {

    public AltarCorpseSlot(IInventory inventory, int slotNum, int xPos, int yPos) {
        super(inventory, slotNum, xPos, yPos);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return Block.getBlockFromItem(stack.getItem()) instanceof BlockCorpse &&
                EnumCorpse.getById((byte) stack.getItemDamage()).canBeResurrected() &&
                CorpseHelper.getMobType(stack.getTagCompound()) == EnumUndeadMobType.OTHER;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}
