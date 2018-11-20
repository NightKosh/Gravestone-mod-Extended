package nightkosh.gravestone_extended.renderer.entity;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.util.ResourceLocation;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.entity.monster.EntityPossessedArmor;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RendererPossessedArmor extends RenderBiped<EntityPossessedArmor> {

    public RendererPossessedArmor(RenderManager renderManager) {
        super(renderManager, new ModelBiped(), 0.5F);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this);
        this.addLayer(layerbipedarmor);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityPossessedArmor entity) {
        return Resources.POSSESSED_ARMOR;
    }
}
