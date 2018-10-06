package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.GameType;
import nightkosh.gravestone.gui.GuiContainerBase;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.gui.container.AltarDisenchantmentContainer;
import nightkosh.gravestone_extended.packets.AltarDisenchantmentMessageToServer;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarDisenchantmentGui extends GuiContainerBase {

    private final String requirementsStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.requirements");
    private final String disenchantButtonStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.disenchant");
    private AltarDisenchantmentContainer container;
    private GuiButton disenchantButton;
    private GuiButton switchGuiButton;
    private TileEntityAltar tileEntity = null;
    private EntityPlayer player = null;
    private boolean isCreative = false;

    public AltarDisenchantmentGui(InventoryPlayer inventoryPlayer, TileEntityAltar tileEntity) {
        super(new AltarDisenchantmentContainer(inventoryPlayer, tileEntity.getDisenchantmentInventory()));
        this.tileEntity = tileEntity;
        this.player = inventoryPlayer.player;
        this.container = (AltarDisenchantmentContainer) this.inventorySlots;
        isCreative = player.getEntityWorld().getWorldInfo().getGameType().equals(GameType.CREATIVE);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(disenchantButton = new GuiButton(0, (width - xSize) / 2 + 100, (height - ySize) / 2 + 25, 70, 20, disenchantButtonStr));
        disenchantButton.enabled = false;
        this.buttonList.add(switchGuiButton = new GuiButton(1, (width - xSize) / 2 + 100, (height - ySize) / 2 + 45, 70, 20, "!!!"));
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                MessageHandler.networkWrapper.sendToServer(new AltarDisenchantmentMessageToServer(this.player, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()));
                break;
            case 1:
//                MessageHandler.networkWrapper.sendToServer(new AltarGuiMessageToServer(this.player, GuiHandler.ALTAR_RESURRECTION_GUI_ID));
//                this.mc.displayGuiScreen(null);
//                player.openGui(ModGravestoneExtended.instance, GuiHandler.ALTAR_RESURRECTION_GUI_ID, player.getEntityWorld(), player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
                break;
        }
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.renderEngine.bindTexture(Resources.ALTAR_GUI);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        //TODO level!!
        this.drawString(this.fontRenderer, String.format(requirementsStr, container.getDisenchantmentLevel()), this.width / 2 - 40, (height - ySize) / 2 + 55, 16777215);
        if (player != null) {
            disenchantButton.enabled = isCreative || player.experienceLevel >= container.getDisenchantmentLevel();
        }
    }
}
