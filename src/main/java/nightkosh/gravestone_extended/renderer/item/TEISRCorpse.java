package nightkosh.gravestone_extended.renderer.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.renderer.tileentity.CorpseRendererHelper;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TEISRCorpse extends TileEntityItemStackRenderer {

    public static void renderCorpseOnAltar(ItemStack item, double x, double y, double z, float ticks) {
        if (item != null) {
            GL11.glPushMatrix();
            float time = Minecraft.getMinecraft().world.getTotalWorldTime() + ticks;
            GL11.glTranslated(x + 0.5F, y + 1.2F, z + 0.5F);
            GL11.glRotatef(time % 360, 0, 1, 0);

            CorpseRendererHelper.renderCorpse(EnumCorpse.getById((byte) item.getItemDamage()), item.getTagCompound(), true);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void renderByItem(ItemStack stack) {
        GL11.glPushMatrix();

        GL11.glRotatef(-35, 0, 1, 0);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        GL11.glTranslated(1.7F, 0, 0);
        CorpseRendererHelper.renderCorpse(EnumCorpse.getById((byte) stack.getItemDamage()), stack.getTagCompound(), false);
        GL11.glPopMatrix();
    }
}
