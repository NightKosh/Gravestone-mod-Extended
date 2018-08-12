package nightkosh.gravestone_extended.renderer.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import nightkosh.gravestone.renderer.tileentity.TileEntityRenderer;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.block.enums.EnumExecution;
import nightkosh.gravestone_extended.models.block.ModelExecution;
import nightkosh.gravestone_extended.models.block.execution.ModelBurningStake;
import nightkosh.gravestone_extended.models.block.execution.ModelGallows;
import nightkosh.gravestone_extended.models.block.execution.ModelGibbet;
import nightkosh.gravestone_extended.models.block.execution.ModelStocks;
import nightkosh.gravestone_extended.tileentity.TileEntityExecution;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityExecutionRenderer extends TileEntityRenderer {

    public static ModelExecution gallows = new ModelGallows();
    public static ModelExecution gibbet = new ModelGibbet();
    public static ModelExecution stocks = new ModelStocks();
    public static ModelExecution burningStake = new ModelBurningStake();

    public static TileEntityExecutionRenderer instance;

    private static final TileEntityExecution EXECUTION_TE = new TileEntityExecution();

    public TileEntityExecutionRenderer() {
        instance = this;
    }

    @Override
    public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        TileEntityExecution tileEntity = (TileEntityExecution) te;

        if (tileEntity == null) {
            tileEntity = EXECUTION_TE;
        }
        EnumExecution execution = EnumExecution.getById(tileEntity.getBlockMetadata());
        renderExecution(x, y, z, tileEntity.getWorld(), execution, tileEntity.getCorpse(), tileEntity.getCorpseType(), tileEntity.getHangedVillagerProfession(), EnumFacing.values()[tileEntity.getDirection()]);
    }

    public void renderExecution(double x, double y, double z, World world, EnumExecution execution,
                                 ItemStack corpse, EnumCorpse corpseType, int hangedVillagerProfession, EnumFacing facing) {
        GL11.glPushMatrix();

        if (world != null) {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glScalef(1, -1, -1);
        } else {
            GL11.glRotatef(-35, 0, 1, 0);
            GL11.glTranslatef((float) x + 0.9F, (float) y + 0.5F, (float) z + 0.5F);
            GL11.glScalef(0.3F, -0.3F, -0.3F);
        }

        switch (facing) {
            case SOUTH:
                GL11.glRotatef(0, 0, 1, 0);
                break;
            case WEST:
                GL11.glRotatef(90, 0, 1, 0);
                break;
            case NORTH:
                GL11.glRotatef(180, 0, 1, 0);
                break;
            case EAST:
                GL11.glRotatef(270, 0, 1, 0);
                break;
        }

        renderExecution(execution, corpse, corpseType, hangedVillagerProfession);

        GL11.glPopMatrix();
    }

    private void renderExecution(EnumExecution execution, ItemStack corpse, EnumCorpse corpseType, int hangedVillagerProfession) {
        ModelExecution model = getModel(execution);
        bindTextureByName(execution.getTexture());
        model.customRender(corpse, corpseType, hangedVillagerProfession);
    }

    private static ModelExecution getModel(EnumExecution execution) {
        switch (execution) {
            case GALLOWS:
            default:
                return gallows;
            case GIBBET:
                return gibbet;
            case STOCKS:
                return stocks;
            case BURNING_STAKE:
                return burningStake;
        }
    }
}
