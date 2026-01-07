package nightkosh.gravestone_extended.models.block;


/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModelSpiderSpawner {//TODO extends ModelSpawnerBase {
//
//    ModelRenderer cube1;
//    ModelRenderer cube2;
//    ModelRenderer cube3;
//    ModelRenderer cube4;
//    ModelRenderer bottomWeb1;
//    ModelRenderer bottomWeb2;
//    ModelRenderer bottomWeb3;
//    ModelRenderer bottomWeb4;
//    ModelRenderer bottomWeb5;
//    ModelRenderer bottomWeb6;
//    ModelRenderer bottomWeb7;
//    ModelRenderer bottomWeb8;
//    ModelRenderer topWeb1;
//    ModelRenderer topWeb2;
//    ModelRenderer topWeb3;
//    ModelRenderer topWeb4;
//    ModelRenderer innerWeb1;
//    ModelRenderer innerWeb2;
//
//    public ModelSpiderSpawner() {
//        textureWidth = 128;
//        textureHeight = 128;
//
//        cube1 = new ModelRenderer(this, 0, -5);
//        cube1.addBox(0F, 0F, 0F, 16, 32, 32);
//        cube1.setRotationPoint(-8F, -8F, -16F);
//        setRotation(cube1, 0F, 0F, 0F);
//
//        cube2 = new ModelRenderer(this, 0, -5);
//        cube2.addBox(0F, 0F, 0F, 16, 32, 32);
//        cube2.setRotationPoint(-16F, -8F, 8F);
//        setRotation(cube2, 0F, 1.570796F, 0F);
//
//        cube3 = new ModelRenderer(this, 0, 60);
//        cube3.addBox(0F, 0F, 0F, 12, 32, 34);
//        cube3.setRotationPoint(-16F, -8F, -8F);
//        setRotation(cube3, 0F, 0.7853982F, 0F);
//
//        cube4 = new ModelRenderer(this, 0, 60);
//        cube4.addBox(0F, 0F, 0F, 12, 32, 34);
//        cube4.setRotationPoint(-8F, -8F, 16F);
//        setRotation(cube4, 0F, 2.356194F, 0F);
//
//        bottomWeb1 = new ModelRenderer(this, 0, 0);
//        bottomWeb1.addBox(0F, 0F, 0F, 16, 16, 0);
//        bottomWeb1.setRotationPoint(-8F, 9F, -16F);
//        setRotation(bottomWeb1, -0.4363323F, 0F, 0F);
//
//        bottomWeb2 = new ModelRenderer(this, 0, 0);
//        bottomWeb2.addBox(0F, 0F, 0F, 16, 16, 0);
//        bottomWeb2.setRotationPoint(-8F, 9F, 16F);
//        setRotation(bottomWeb2, 0.4363323F, 0F, 0F);
//
//        bottomWeb3 = new ModelRenderer(this, 64, -6);
//        bottomWeb3.addBox(0F, 0F, 0F, 0, 16, 16);
//        bottomWeb3.setRotationPoint(-16F, 9F, -8F);
//        setRotation(bottomWeb3, 0F, 0F, 0.4363323F);
//
//        bottomWeb4 = new ModelRenderer(this, 64, -6);
//        bottomWeb4.addBox(0F, 0F, 0F, 0, 16, 16);
//        bottomWeb4.setRotationPoint(16F, 9F, -8F);
//        setRotation(bottomWeb4, 0F, 0F, -0.4363323F);
//
//        bottomWeb5 = new ModelRenderer(this, 97, 0);
//        bottomWeb5.addBox(0F, 0F, 0F, 12, 16, 0);
//        bottomWeb5.setRotationPoint(-16F, 9F, -8F);
//        setRotation(bottomWeb5, -0.4363323F, 0.7853982F, 0F);
//
//        bottomWeb6 = new ModelRenderer(this, 97, 0);
//        bottomWeb6.addBox(0F, 0F, 0F, 12, 16, 0);
//        bottomWeb6.setRotationPoint(8F, 9F, 16F);
//        setRotation(bottomWeb6, 0.4363323F, 0.7853982F, 0F);
//
//        bottomWeb7 = new ModelRenderer(this, 97, 0);
//        bottomWeb7.addBox(0F, 0F, 0F, 12, 16, 0);
//        bottomWeb7.setRotationPoint(-8F, 9F, 16F);
//        setRotation(bottomWeb7, -0.4363323F, 2.356194F, 0F);
//
//        bottomWeb8 = new ModelRenderer(this, 97, 0);
//        bottomWeb8.addBox(0F, 0F, 0F, 12, 16, 0);
//        bottomWeb8.setRotationPoint(16F, 9F, -8F);
//        setRotation(bottomWeb8, 0.4363323F, 2.356194F, 0F);
//
//        topWeb1 = new ModelRenderer(this, 0, 60);
//        topWeb1.addBox(0F, 0F, 0F, 16, 18, 0);
//        topWeb1.setRotationPoint(-8F, -8F, -16F);
//        setRotation(topWeb1, 2.007129F, 0F, 0F);
//
//        topWeb2 = new ModelRenderer(this, 0, 60);
//        topWeb2.addBox(0F, 0F, 0F, 16, 18, 0);
//        topWeb2.setRotationPoint(-8F, -8F, 16F);
//        setRotation(topWeb2, -2.007129F, 0F, 0F);
//
//        topWeb3 = new ModelRenderer(this, 0, 63);
//        topWeb3.addBox(0F, 0F, 0F, 0, 18, 16);
//        topWeb3.setRotationPoint(-16F, -8F, -8F);
//        setRotation(topWeb3, 0F, 0F, -2.007129F);
//
//        topWeb4 = new ModelRenderer(this, 0, 63);
//        topWeb4.addBox(0F, 0F, 0F, 0, 18, 16);
//        topWeb4.setRotationPoint(16F, -8F, -8F);
//        setRotation(topWeb4, 0F, 0F, 2.007129F);
//
//        innerWeb1 = new ModelRenderer(this, 64, 28);
//        innerWeb1.addBox(0F, 0F, 0F, 0, 32, 32);
//        innerWeb1.setRotationPoint(0F, -8F, -16F);
//        setRotation(innerWeb1, 0F, 0F, 0F);
//
//        innerWeb2 = new ModelRenderer(this, 64, 28);
//        innerWeb2.addBox(0F, 0F, 0F, 0, 32, 32);
//        innerWeb2.setRotationPoint(-16F, -8F, 0F);
//        setRotation(innerWeb2, 0F, 1.570796F, 0F);
//    }
//
//    public void renderAll() {
//        float f5 = 0.0625F;
//        cube1.render(f5);
//        cube2.render(f5);
//        cube3.render(f5);
//        cube4.render(f5);
//        bottomWeb1.render(f5);
//        bottomWeb2.render(f5);
//        bottomWeb3.render(f5);
//        bottomWeb4.render(f5);
//        bottomWeb5.render(f5);
//        bottomWeb6.render(f5);
//        bottomWeb7.render(f5);
//        bottomWeb8.render(f5);
//        topWeb1.render(f5);
//        topWeb2.render(f5);
//        topWeb3.render(f5);
//        topWeb4.render(f5);
//        innerWeb1.render(f5);
//        innerWeb2.render(f5);
//    }
//
//    private void setRotation(ModelRenderer model, float x, float y, float z) {
//        model.rotateAngleX = x;
//        model.rotateAngleY = y;
//        model.rotateAngleZ = z;
//    }
}
