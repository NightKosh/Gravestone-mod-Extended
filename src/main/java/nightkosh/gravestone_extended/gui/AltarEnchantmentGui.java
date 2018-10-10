package nightkosh.gravestone_extended.gui;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.core.Resources;
import nightkosh.gravestone_extended.gui.container.AltarEnchantmentContainer;
import nightkosh.gravestone_extended.packets.AltarEnchantmentMessageToServer;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarEnchantmentGui extends AltarGui {

    private final String enchantButtonStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.enchant");

    public AltarEnchantmentGui(InventoryPlayer inventoryPlayer, TileEntityAltar tileEntity) {
        super(inventoryPlayer,  tileEntity, new AltarEnchantmentContainer(inventoryPlayer, tileEntity.getEnchantmentInventory()));
    }

    @Override
    public void initGui() {
        super.initGui();
        guiEnchantmentButton.enabled = false;
    }

    @Override
    protected void sendMessage() {
        MessageHandler.networkWrapper.sendToServer(new AltarEnchantmentMessageToServer(this.player, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()));
    }

    @Override
    protected String getButtonStr() {
        return enchantButtonStr;
    }

    @Override
    protected ResourceLocation getGuiTexture() {
        return Resources.ALTAR_ENCHANTMENT_GUI;
    }
}
