package nightkosh.gravestone_extended.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone.block.enums.EnumGraves;
import nightkosh.gravestone.renderer.tileentity.TileEntityGraveStoneRenderer;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveInGuiRenderer {

    protected static float SCALE_GRAVE = 50;
    protected static float SCALE_MEMORIAL = 19;

    public static void renderGraveInGui(float x, float y, EnumGraves grave, boolean isEnchanted, boolean isMossy, float partialTicks) {
        GL11.glPushMatrix();

        scaleAndRotate(x, y, SCALE_GRAVE, partialTicks);

        TileEntityGraveStoneRenderer.instance.renderGrave(null, grave, isEnchanted, isMossy, false, ItemStack.EMPTY, false, ItemStack.EMPTY);

        GL11.glPopMatrix();
    }

    public static void renderMemorialInGui(float x, float y, EnumMemorials memorial, boolean isEnchanted, boolean isMossy, float partialTicks) {
        GL11.glPushMatrix();

        scaleAndRotate(x, y, SCALE_MEMORIAL, partialTicks);

        TileEntityMemorialRenderer.instance.renderMemorial(memorial, memorial.getMemorialType(), isEnchanted, isMossy, null);

        GL11.glPopMatrix();
    }

    protected static void scaleAndRotate(float x, float y, float scale, float partialTicks) {
        GL11.glTranslatef(x, y, 80);

        GL11.glRotatef((Minecraft.getMinecraft().world.getTotalWorldTime() + partialTicks) % 360, 0, 1, 0);

        GL11.glScaled(scale, scale, scale);
    }
}
