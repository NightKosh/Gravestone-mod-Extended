package nightkosh.gravestone_extended.renderer.entity.layers;

import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.monster.EntitySwampThing;
import nightkosh.gravestone_extended.renderer.entity.RenderSwampThing;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class LayerSwampThing implements LayerRenderer<EntitySwampThing> {

    private final RenderSwampThing renderer;
    private final ModelZombie layerModel = new ModelZombie(0.2F, true);

    public LayerSwampThing(RenderSwampThing renderer) {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntitySwampThing entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.layerModel.setModelAttributes(this.renderer.getMainModel());
        this.layerModel.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTicks);
        GlStateManager.color(1, 1, 1, 1);
        this.renderer.bindTexture(Resources.SWAMP_THING_OVERLAY);
        this.layerModel.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
