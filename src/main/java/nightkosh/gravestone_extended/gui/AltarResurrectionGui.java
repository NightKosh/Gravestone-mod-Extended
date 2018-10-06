package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.GameType;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.gui.container.AltarResurrectionContainer;
import nightkosh.gravestone_extended.packets.AltarResurrectionMessageToServer;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarResurrectionGui extends AltarGui {

    private final String requirementsStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.requirements");
    private final String resurrectionButtonStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.resurrect");
    private AltarResurrectionContainer container;
    private GuiButton resurrectionButton;

    public AltarResurrectionGui(InventoryPlayer inventoryPlayer, TileEntityAltar tileEntity) {
        super(new AltarResurrectionContainer(inventoryPlayer, tileEntity.getCorpseInventory()));
        this.tileEntity = tileEntity;
        this.player = inventoryPlayer.player;
        this.container = (AltarResurrectionContainer) this.inventorySlots;
        isCreative = player.getEntityWorld().getWorldInfo().getGameType().equals(GameType.CREATIVE);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(resurrectionButton = new GuiButton(0, (width - xSize) / 2 + 100, (height - ySize) / 2 + 25, 70, 20, resurrectionButtonStr));
        resurrectionButton.enabled = false;
        guiResurrectionButton.enabled = false;
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                MessageHandler.networkWrapper.sendToServer(new AltarResurrectionMessageToServer(this.player, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), AltarResurrectionMessageToServer.MOB_TYPE.LIVED));
                break;
            default:
                super.actionPerformed(button);
                break;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        this.drawString(this.fontRenderer, String.format(requirementsStr, container.getResurrectionLevel()), this.width / 2 - 40, (height - ySize) / 2 + 55, 16777215);
        if (player != null) {
            resurrectionButton.enabled = isCreative || player.experienceLevel >= container.getResurrectionLevel();
        }
    }
}
