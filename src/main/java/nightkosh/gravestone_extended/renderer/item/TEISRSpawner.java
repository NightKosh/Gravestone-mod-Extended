package nightkosh.gravestone_extended.renderer.item;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.renderer.tileentity.TileEntitySpawnerRenderer;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TEISRSpawner extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack stack) {
        TileEntitySpawnerRenderer.instance.renderSpawnerAsItem(EnumSpawner.getById((byte) stack.getItemDamage()));
    }
}
