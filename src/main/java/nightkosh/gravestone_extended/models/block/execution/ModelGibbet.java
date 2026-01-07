package nightkosh.gravestone_extended.models.block.execution;

import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.models.block.ModelExecution;
import nightkosh.gravestone_extended.renderer.tileentity.CorpseRendererHelper;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelGibbet extends ModelExecution {
//
//    private ModelRenderer horizontalPlank;
//    private ModelRenderer verticalPlank;
//    private ModelRenderer plank1;
//    private ModelRenderer plank2;
//    private ModelRenderer plank3;
//    private ModelRenderer plank4;
//    private ModelRenderer rope;
//    private ModelRenderer rope2;
//
//    ModelRenderer cage1;
//    ModelRenderer cage2;
//    ModelRenderer cage11;
//    ModelRenderer cage12;
//    ModelRenderer cage21;
//    ModelRenderer cage22;
//    ModelRenderer cage3;
//    ModelRenderer cage31;
//    ModelRenderer cage32;
//    ModelRenderer cage33;
//    ModelRenderer cage34;
//    ModelRenderer cage35;
//    ModelRenderer cage36;
//    ModelRenderer cage37;
//    ModelRenderer cageBottom;
//
//    public ModelGibbet() {
//        textureWidth = 64;
//        textureHeight = 128;
//
//        horizontalPlank = new ModelRenderer(this, 0, 0);
//        horizontalPlank.addBox(0, 0, 0, 4, 52, 4);
//        horizontalPlank.setRotationPoint(-2, -28, 3);
//        horizontalPlank.setTextureSize(this.textureWidth, this.textureHeight);
//
//        verticalPlank = new ModelRenderer(this, 0, 83);
//        verticalPlank.addBox(0, 0, 0, 4, 4, 24);
//        verticalPlank.setRotationPoint(-2, -32, -17);
//        verticalPlank.setTextureSize(this.textureWidth, this.textureHeight);
//
//        plank1 = new ModelRenderer(this, 31, 24);
//        plank1.addBox(0, 0, 0, 4, 15, 3);
//        plank1.setRotationPoint(-2, 13.3F, 3.5F);
//        plank1.setTextureSize(this.textureWidth, this.textureHeight);
//        setRotation(plank1, 0, 0, 0.7853982F);
//
//        plank2 = new ModelRenderer(this, 16, 24);
//        plank2.addBox(0, 0, 0, 3, 15, 4);
//        plank2.setRotationPoint(-1.5F, 13.3F, 3);
//        plank2.setTextureSize(this.textureWidth, this.textureHeight);
//        setRotation(plank2, -0.7853982F, 0, 0);
//
//        plank3 = new ModelRenderer(this, 31, 42);
//        plank3.addBox(0, 0, 0, 4, 15, 3);
//        plank3.setRotationPoint(-1, 16, 3.5F);
//        plank3.setTextureSize(this.textureWidth, this.textureHeight);
//        setRotation(plank3, 0, 0, -0.7853982F);
//
//        plank4 = new ModelRenderer(this, 16, 43);
//        plank4.addBox(0, 0, 0, 3, 15, 4);
//        plank4.setRotationPoint(-1.5F, -20.3F, 6);
//        plank4.setTextureSize(this.textureWidth, this.textureHeight);
//        setRotation(plank4, -2.356194F, 0, 0);
//
//        rope = new ModelRenderer(this, 0, 62);
//        rope.addBox(0, 0, 0, 5, 5, 3);
//        rope.setRotationPoint(-2.5F, -32.5F, -16);
//        rope.setTextureSize(this.textureWidth, this.textureHeight);
//
//        rope2 = new ModelRenderer(this, 0, 71);
//        rope2.addBox(0, 0, 0, 1, 10, 1);
//        rope2.setRotationPoint(-0.5F, -28, -15);
//        rope2.setTextureSize(this.textureWidth, this.textureHeight);
//
//
//        cage1 = new ModelRenderer(this, 17, 0);
//        cage1.addBox(0, 0, 0, 16, 1, 1);
//        cage1.setRotationPoint(-8, -18, -15);
//        cage1.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage2 = new ModelRenderer(this, 17, 0);
//        cage2.addBox(0, 0, 0, 16, 1, 1);
//        cage2.setRotationPoint(-0.5F, -18, -7);
//        cage2.setTextureSize(this.textureWidth, this.textureHeight);
//        setRotation(cage2, 0, 1.570796F, 0);
//
//        cage11 = new ModelRenderer(this, 17, 0);
//        cage11.addBox(0, 0, 0, 16, 1, 1);
//        cage11.setRotationPoint(-8, -18, -23);
//        cage11.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage12 = new ModelRenderer(this, 17, 0);
//        cage12.addBox(0, 0, 0, 16, 1, 1);
//        cage12.setRotationPoint(-8, -18, -8);
//        cage12.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage21 = new ModelRenderer(this, 17, 0);
//        cage21.addBox(0, 0, 0, 16, 1, 1);
//        cage21.setRotationPoint(-8.5F, -18, -7);
//        cage21.setTextureSize(this.textureWidth, this.textureHeight);
//        setRotation(cage21, 0, 1.570796F, 0);
//
//        cage22 = new ModelRenderer(this, 17, 0);
//        cage22.addBox(0, 0, 0, 16, 1, 1);
//        cage22.setRotationPoint(7.5F, -18, -7);
//        cage22.setTextureSize(this.textureWidth, this.textureHeight);
//        setRotation(cage22, 0, 1.570796F, 0);
//
//        cage3 = new ModelRenderer(this, 53, 0);
//        cage3.addBox(0, 0, 0, 1, 34, 1);
//        cage3.setRotationPoint(-0.5F, -17, -23);
//        cage3.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage31 = new ModelRenderer(this, 53, 0);
//        cage31.addBox(0, 0, 0, 1, 34, 1);
//        cage31.setRotationPoint(-0.5F, -17, -8);
//        cage31.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage32 = new ModelRenderer(this, 53, 0);
//        cage32.addBox(0, 0, 0, 1, 34, 1);
//        cage32.setRotationPoint(7.5F, -17, -23);
//        cage32.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage33 = new ModelRenderer(this, 53, 0);
//        cage33.addBox(0, 0, 0, 1, 34, 1);
//        cage33.setRotationPoint(-8.5F, -17, -23);
//        cage33.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage34 = new ModelRenderer(this, 53, 0);
//        cage34.addBox(0, 0, 0, 1, 34, 1);
//        cage34.setRotationPoint(-8.5F, -17, -15);
//        cage34.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage35 = new ModelRenderer(this, 53, 0);
//        cage35.addBox(0, 0, 0, 1, 34, 1);
//        cage35.setRotationPoint(-8.5F, -17, -8);
//        cage35.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage36 = new ModelRenderer(this, 53, 0);
//        cage36.addBox(0, 0, 0, 1, 34, 1);
//        cage36.setRotationPoint(7.5F, -17, -15);
//        cage36.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cage37 = new ModelRenderer(this, 53, 0);
//        cage37.addBox(0, 0, 0, 1, 34, 1);
//        cage37.setRotationPoint(7.5F, -17, -8);
//        cage37.setTextureSize(this.textureWidth, this.textureHeight);
//
//        cageBottom = new ModelRenderer(this, 0, 112);
//        cageBottom.addBox(0, 0, 0, 16, 1, 15);
//        cageBottom.setRotationPoint(-8, 16, -22.5F);
//        cageBottom.setTextureSize(this.textureWidth, this.textureHeight);
//    }
//
//    public void renderAllWithoutLoop() {
//        horizontalPlank.render(0.0625F);
//        verticalPlank.render(0.0625F);
//        plank1.render(0.0625F);
//        plank2.render(0.0625F);
//        plank3.render(0.0625F);
//        plank4.render(0.0625F);
//        rope.render(0.0625F);
//        rope2.render(0.0625F);
//        cage1.render(0.0625F);
//        cage2.render(0.0625F);
//        cage11.render(0.0625F);
//        cage12.render(0.0625F);
//        cage21.render(0.0625F);
//        cage22.render(0.0625F);
//        cage3.render(0.0625F);
//        cage31.render(0.0625F);
//        cage32.render(0.0625F);
//        cage33.render(0.0625F);
//        cage34.render(0.0625F);
//        cage35.render(0.0625F);
//        cage36.render(0.0625F);
//        cage37.render(0.0625F);
//        cageBottom.render(0.0625F);
//    }
//
//    @Override
//    public void renderAll() {
//        renderAllWithoutLoop();
//    }
//
//    @Override
//    public void customRender(ItemStack corpse, EnumCorpse corpseType, int villagerProfession) {
//        if (corpseType == null) {
//            renderAll();
//        } else {
//            renderAllWithoutLoop();
//
//            GL11.glPushMatrix();
//            GL11.glTranslatef(0, -0.5F, -0.9F);
//            CorpseRendererHelper.renderCorpse(corpseType, corpse.getTagCompound(), false, true);
//            GL11.glPopMatrix();
//        }
//    }
}
