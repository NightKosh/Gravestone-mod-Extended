package nightkosh.gravestone_extended.renderer.entity;

import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.monster.water.EntityPhantomDiver;
import nightkosh.gravestone_extended.models.entity.ModelPhantomDiver;
import nightkosh.gravestone_extended.renderer.entity.layers.LayerPhantomDiverFace;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RenderPhantomDiver<T extends EntityPhantomDiver> extends RenderBiped<EntityPhantomDiver> {

    public RenderPhantomDiver(RenderManager renderManager) {
        super(renderManager, new ModelPhantomDiver(), 0.5F);
        this.addLayer(new LayerPhantomDiverFace(this));
    }

    @Override
    public ModelPhantomDiver getMainModel() {
        return (ModelPhantomDiver) this.mainModel;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPhantomDiver entity) {
        return Resources.PHANTOM_DIVER;
    }
}
