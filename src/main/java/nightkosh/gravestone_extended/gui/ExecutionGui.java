package nightkosh.gravestone_extended.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import nightkosh.gravestone.gui.GuiContainerBase;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.gui.container.ExecutionContainer;
import nightkosh.gravestone_extended.tileentity.TileEntityExecution;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ExecutionGui extends GuiContainerBase {

    private ExecutionContainer container;
    private TileEntityExecution tileEntity = null;
    private EntityPlayer player = null;

    public ExecutionGui(InventoryPlayer inventoryPlayer, TileEntityExecution tileEntity) {
        super(new ExecutionContainer(inventoryPlayer, tileEntity));
        this.tileEntity = tileEntity;
        this.player = inventoryPlayer.player;
        this.container = (ExecutionContainer) this.inventorySlots;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.renderEngine.bindTexture(Resources.ALTAR_RESURRECTION_GUI);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
