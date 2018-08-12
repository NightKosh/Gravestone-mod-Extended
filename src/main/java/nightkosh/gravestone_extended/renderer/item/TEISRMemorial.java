package nightkosh.gravestone_extended.renderer.item;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.renderer.tileentity.TileEntityMemorialRenderer;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TEISRMemorial extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack stack) {
        if (stack.hasTagCompound()) {
            NBTTagCompound nbt = stack.getTagCompound();
            EnumMemorials memorial = EnumMemorials.getById(stack.getItemDamage());
            boolean isEnchanted = nbt.hasKey("Enchanted") && nbt.getBoolean("Enchanted");
            boolean isMossy = nbt.hasKey("Mossy") && nbt.getBoolean("Mossy");

            TileEntityMemorialRenderer.instance.renderMemorialAsItem(memorial, memorial.getMemorialType(), isEnchanted, isMossy);
        }
    }
}
