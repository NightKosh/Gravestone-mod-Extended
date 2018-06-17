package nightkosh.gravestone_extended.renderer.entity.layers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.monster.water.EntityPhantomDiver;
import nightkosh.gravestone_extended.renderer.entity.RenderPhantomDiver;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LayerPhantomDiverFace<T extends EntityPhantomDiver> implements LayerRenderer<T> {
    private final RenderPhantomDiver<T> phantomDiverRenderer;

    public LayerPhantomDiverFace(RenderPhantomDiver<T> phantomDiverRenderer) {
        this.phantomDiverRenderer = phantomDiverRenderer;
    }

    @Override
    public void doRenderLayer(T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.phantomDiverRenderer.bindTexture(Resources.PHANTOM_DIVER_FACE);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!entity.isInvisible());

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680, 0);
        GlStateManager.enableLighting();
        GlStateManager.color(1, 1, 1, 1);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
        this.phantomDiverRenderer.getMainModel().renderHead(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
        this.phantomDiverRenderer.setLightmap(entity);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
