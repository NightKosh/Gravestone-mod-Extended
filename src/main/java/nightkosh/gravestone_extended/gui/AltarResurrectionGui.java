package nightkosh.gravestone_extended.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.core.Resources;
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

    private final String resurrectionButtonStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.resurrect");

    public AltarResurrectionGui(InventoryPlayer inventoryPlayer, TileEntityAltar tileEntity) {
        super(inventoryPlayer,  tileEntity, new AltarResurrectionContainer(inventoryPlayer, tileEntity.getCorpseInventory()));
    }

    @Override
    public void initGui() {
        super.initGui();
        guiResurrectionButton.enabled = false;
    }

    @Override
    protected void sendMessage() {
        MessageHandler.networkWrapper.sendToServer(new AltarResurrectionMessageToServer(this.player, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), AltarResurrectionMessageToServer.MOB_TYPE.LIVED));
    }

    @Override
    protected String getButtonStr() {
        return resurrectionButtonStr;
    }

    @Override
    protected ResourceLocation getGuiTexture() {
        return Resources.ALTAR_RESURRECTION_GUI;
    }
}
