package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.GameType;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.MessageHandler;
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

    private final String requirementsStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.requirements");
    private final String enchantButtonStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.enchant");
    private AltarEnchantmentContainer container;
    private GuiButton enchantButton;

    public AltarEnchantmentGui(InventoryPlayer inventoryPlayer, TileEntityAltar tileEntity) {
        super(new AltarEnchantmentContainer(inventoryPlayer, tileEntity.getEnchantmentInventory()));
        this.tileEntity = tileEntity;
        this.player = inventoryPlayer.player;
        this.container = (AltarEnchantmentContainer) this.inventorySlots;
        isCreative = player.getEntityWorld().getWorldInfo().getGameType().equals(GameType.CREATIVE);
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(enchantButton = new GuiButton(0, (width - xSize) / 2 + 100, (height - ySize) / 2 + 25, 70, 20, enchantButtonStr));
        enchantButton.enabled = false;
        guiEnchantmentButton.enabled = false;
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                MessageHandler.networkWrapper.sendToServer(new AltarEnchantmentMessageToServer(this.player, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()));
                break;
            default:
                super.actionPerformed(button);
                break;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        //TODO level!!
        this.drawString(this.fontRenderer, String.format(requirementsStr, container.getEnchantmentLevel()), this.width / 2 - 40, (height - ySize) / 2 + 55, 16777215);
        if (player != null) {
            enchantButton.enabled = isCreative || player.experienceLevel >= container.getEnchantmentLevel();
        }
    }
}
