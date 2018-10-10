package nightkosh.gravestone_extended.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.gui.container.AltarDisenchantmentContainer;
import nightkosh.gravestone_extended.packets.AltarDisenchantmentMessageToServer;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarDisenchantmentGui extends AltarGui {

    private final String disenchantButtonStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.disenchant");

    public AltarDisenchantmentGui(InventoryPlayer inventoryPlayer, TileEntityAltar tileEntity) {
        super(inventoryPlayer,  tileEntity, new AltarDisenchantmentContainer(inventoryPlayer, tileEntity.getDisenchantmentInventory()));
    }

    @Override
    public void initGui() {
        super.initGui();
        guiDisenchantmentButton.enabled = false;
    }

    @Override
    protected void sendMessage() {
        MessageHandler.networkWrapper.sendToServer(new AltarDisenchantmentMessageToServer(this.player, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()));
    }

    @Override
    protected String getButtonStr() {
        return disenchantButtonStr;
    }

    @Override
    protected ResourceLocation getGuiTexture() {
        return Resources.ALTAR_DISENCHANTMENT_GUI;
    }
}
