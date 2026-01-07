package nightkosh.gravestone_extended.models.block;

import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.renderer.tileentity.TileEntityMemorialRenderer;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelSkullCandle {//TODO extends ModelBaseAdapter {
//
//    private ModelRendererSkull skull;
//    private ModelCandle candle;
//
//    public ModelSkullCandle() {
//        skull = new ModelRendererSkull(this);
//
//        textureWidth = 32;
//        textureHeight = 32;
//        candle = new ModelCandle();
//    }
//
//    /**
//     * Sets the models various rotation angles then renders the model.
//     */
//    @Override
//    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//        super.render(entity, f, f1, f2, f3, f4, f5);
//        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
//
//        skull.render(f5);
//        candle.render(entity, f, f1, f2, f3, f4, f5);
//    }
//
//    public void renderAll(ModelRendererSkull.EnumSkullType skullType) {
//        skull.renderWithTexture(0.0625F, skullType);
//
//        TileEntityMemorialRenderer.instance.bindTextureByName(Resources.CANDLE);
//
//        GL11.glPushMatrix();
//        GL11.glTranslated(0, -0.34, -0.07);
//        candle.renderAll();
//        GL11.glPopMatrix();
//    }
}
