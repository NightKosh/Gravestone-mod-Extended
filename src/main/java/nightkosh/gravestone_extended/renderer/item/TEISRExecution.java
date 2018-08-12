package nightkosh.gravestone_extended.renderer.item;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import nightkosh.gravestone_extended.block.enums.EnumExecution;
import nightkosh.gravestone_extended.renderer.tileentity.TileEntityExecutionRenderer;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TEISRExecution extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack stack) {
        TileEntityExecutionRenderer.instance.renderExecution(0, 0, 0, null, EnumExecution.getById(stack.getItemDamage()), ItemStack.EMPTY, null, 0, EnumFacing.SOUTH);
    }
}
