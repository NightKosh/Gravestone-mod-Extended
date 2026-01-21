package nightkosh.gravestone_extended.renderer.tileentity;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityHauntedChestRenderer {//TODOextends TileEntitySpecialRenderer {
//
//    private ModelChest chestModel = new ModelChest();
//    private boolean isChristmas;
//
//    private static final TileEntityHauntedChest CHEST_TE = new TileEntityHauntedChest();
//
//    public TileEntityHauntedChestRenderer() {
//        Calendar calendar = Calendar.getInstance();
//
//        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
//            this.isChristmas = true;
//        }
//    }
//
//    /**
//     * Renders the TileEntity for the chest at a position.
//     */
//    public void renderTileEntityChestAt(TileEntityHauntedChest te, double x, double y, double z, float par8) {
//        int metadata = 0;
//
//        if(te == null) {
//            te = CHEST_TE;
//        }
//
//        GL11.glPushMatrix();
//        if (te.hasWorld()) {
//            metadata = te.getBlockMetadata();
//        } else {
//            GL11.glRotatef(45, 0, 1, 0);
//            GL11.glScalef(0.6F, 0.6F, 0.6F);
//            GL11.glTranslatef((float) x + 0.2F, (float) y + 0.3F, (float) z);
//        }
//
//
//        ModelChest modelchest = this.chestModel;
//
//        if (this.isChristmas) {
//            this.bindTexture(Resources.CHRISTMAS_CHEST);
//        } else {
//            this.bindTexture(Resources.DEFAULT_CHEST);
//        }
//
//        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
//        GL11.glColor4f(1, 1, 1, 1);
//        GL11.glTranslatef((float) x, (float) y + 1, (float) z + 1);
//        GL11.glScalef(1, -1, -1);
//        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
//        float direction = 0;
//
//        switch (metadata) {
//            case 2:
//                direction = 180;
//                break;
//            case 3:
//                direction = 0;
//                break;
//            case 4:
//                direction = 90;
//                break;
//            case 5:
//                direction = -90;
//                break;
//        }
//
//        GL11.glRotatef(direction, 0, 1, 0);
//        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
//        float f1 = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * par8;
//
//        f1 = 1 - f1;
//        f1 = 1 - f1 * f1 * f1;
//        modelchest.chestLid.rotateAngleX = -(f1 * (float) Math.PI / 2F);
//        modelchest.renderAll();
//        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
//        GL11.glPopMatrix();
//        GL11.glColor4f(1, 1, 1, 1);
//    }
//
//    @Override
//    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
//        this.renderTileEntityChestAt((TileEntityHauntedChest) te, x, y, z, alpha);
//    }
}
