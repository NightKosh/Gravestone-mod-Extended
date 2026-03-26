package nightkosh.gravestone_extended.models.block.execution;

import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.models.block.ModelExecution;
import org.lwjgl.opengl.GL11;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelStocks extends ModelExecution {
//
//    private ModelRenderer horizontalPlank;
//    private ModelRenderer verticalPlank1;
//    private ModelRenderer verticalPlank2;
//    private ModelRenderer headHole;
//    private ModelRenderer armHole1;
//    private ModelRenderer armHole2;
//
//    public ModelStocks() {
//        textureWidth = 128;
//        textureHeight = 64;
//
//        horizontalPlank = new ModelRenderer(this, 0, 0);
//        horizontalPlank.addBox(0, 0, 0, 32, 12, 1);
//        horizontalPlank.setRotationPoint(-16, -2, 0);
//        horizontalPlank.setTextureSize(128, this.textureHeight);
//
//        verticalPlank1 = new ModelRenderer(this, 0, 13);
//        verticalPlank1.addBox(0, 0, 0, 3, 28, 2);
//        verticalPlank1.setRotationPoint(-19, -4, -0.5F);
//        verticalPlank1.setTextureSize(128, this.textureHeight);
//
//        verticalPlank2 = new ModelRenderer(this, 11, 13);
//        verticalPlank2.addBox(0, 0, 0, 3, 28, 2);
//        verticalPlank2.setRotationPoint(16, -4, -0.5F);
//        verticalPlank2.setTextureSize(128, this.textureHeight);
//
//        headHole = new ModelRenderer(this, 22, 13);
//        headHole.addBox(0, 0, 0, 6, 6, 1);
//        headHole.setRotationPoint(-3, 1, 0);
//        headHole.setTextureSize(128, this.textureHeight);
//
//        armHole1 = new ModelRenderer(this, 37, 13);
//        armHole1.addBox(0, 0, 0, 2, 2, 1);
//        armHole1.setRotationPoint(-11, 3, 0);
//        armHole1.setTextureSize(128, this.textureHeight);
//
//        armHole2 = new ModelRenderer(this, 44, 13);
//        armHole2.addBox(0, 0, 0, 2, 2, 1);
//        armHole2.setRotationPoint(9, 3, 0);
//        armHole2.setTextureSize(128, this.textureHeight);
//
//    }
//
//    @Override
//    public void renderAll() {
//        horizontalPlank.render(0.0625F);
//        verticalPlank1.render(0.0625F);
//        verticalPlank2.render(0.0625F);
//        headHole.render(0.0625F);
//        armHole1.render(0.0625F);
//        armHole2.render(0.0625F);
//    }
//
//    @Override
//    public void customRender(ItemStack corpse, EnumCorpse corpseType, int villagerProfession) {
//        renderAll();
//        if (corpseType != null) {
//            GL11.glPushMatrix();
//            GL11.glTranslatef(0, 0.35F, 0.125F);
//            GL11.glRotatef(45, 1, 0, 0);
//            CorpseRendererHelper.renderCorpse(corpseType, corpse.getTagCompound(), false, true, true);
//            GL11.glPopMatrix();
//        }
//
//    }
}
