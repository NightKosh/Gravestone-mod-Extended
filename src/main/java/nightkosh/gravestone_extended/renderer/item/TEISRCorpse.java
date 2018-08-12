package nightkosh.gravestone_extended.renderer.item;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.renderer.tileentity.TileEntityCorpseRenderer;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TEISRCorpse extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack stack) {
        TileEntityCorpseRenderer.instance.renderCorpseAsItem(EnumCorpse.getById((byte) stack.getItemDamage()), stack.getTagCompound());
    }
}
