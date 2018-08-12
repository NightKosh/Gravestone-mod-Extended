package nightkosh.gravestone_extended.renderer.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import nightkosh.gravestone.renderer.tileentity.TileEntityRenderer;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.tileentity.TileEntityCorpse;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityCorpseRenderer extends TileEntityRenderer {

    private static final TileEntityCorpse CORPSE_TE = new TileEntityCorpse();

    public static TileEntityCorpseRenderer instance;

    public TileEntityCorpseRenderer() {
        instance = this;
    }

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

    public void renderCorpseAsTE(TileEntityCorpse te, double x, double y, double z) {
        if (te == null) {
            te = getDefaultTE();
        }
        renderCorpse(EnumCorpse.getById((byte) te.getBlockMetadata()), null, x, y, z);
    }

    public void renderCorpseAsItem(EnumCorpse corpse, NBTTagCompound nbt) {
        renderCorpse(corpse, nbt, 0, 0, 0);
    }

    private void renderCorpse(EnumCorpse corpse, NBTTagCompound nbt, double x, double y, double z) {
        GL11.glPushMatrix();

        GL11.glRotatef(-35, 0, 1, 0);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        GL11.glTranslated(x + 1.7F, y, z);
        CorpseRendererHelper.renderCorpse(corpse, nbt, false);
        GL11.glPopMatrix();
    }

    protected TileEntityCorpse getDefaultTE() {
        return CORPSE_TE;
    }

    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        renderCorpseAsTE((TileEntityCorpse) te, x, y, z);
    }
}
