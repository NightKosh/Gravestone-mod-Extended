package nightkosh.gravestone_extended.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.renderer.item.TEISRCorpse;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class TileEntityRenderAltar extends TileEntitySpecialRenderer {

    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        ItemStack corpse = ((TileEntityAltar) te).getCorpseInventory().getStackInSlot(0);
        if (!corpse.isEmpty()) {
            TEISRCorpse.renderCorpseOnAltar(corpse, x, y, z, partialTicks);
        }
    }
}
