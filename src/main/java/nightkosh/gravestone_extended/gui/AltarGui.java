package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
import nightkosh.gravestone.gui.GuiContainerBase;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.GuiHandler;
import nightkosh.gravestone_extended.core.MessageHandler;
import nightkosh.gravestone_extended.gui.container.AltarContainer;
import nightkosh.gravestone_extended.packets.AltarSwitchGuiMessageToServer;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AltarGui extends GuiContainerBase {

    private final String requirementsStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.requirements");
    private final String resurrectionStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.tab.resurrection");
    private final String enchantingStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.tab.enchanting");
    private final String disenchantingStr = ModGravestoneExtended.proxy.getLocalizedString("gui.altar.tab.disenchanting");

    protected GuiButton guiResurrectionButton;
    protected GuiButton guiEnchantmentButton;
    protected GuiButton guiDisenchantmentButton;
    protected GuiButton button;

    protected boolean isCreative = false;
    protected EntityPlayer player = null;
    protected TileEntityAltar tileEntity = null;
    protected AltarContainer container;

    public AltarGui(InventoryPlayer inventoryPlayer, TileEntityAltar tileEntity, Container container) {
        super(container);
        this.tileEntity = tileEntity;
        this.player = inventoryPlayer.player;
        this.container = (AltarContainer) this.inventorySlots;
        this.isCreative = player.getEntityWorld().getWorldInfo().getGameType().equals(GameType.CREATIVE);
    }

    @Override
    public void initGui() {
        super.initGui();
        int centerX = (width - xSize) / 2;
        int centerY = (height - ySize) / 2;
        this.buttonList.add(button = new GuiButton(0, centerX + 100, centerY + 33, 70, 20, getButtonStr()));
        this.buttonList.add(guiResurrectionButton = new GuiButton(-1, centerX - 40, centerY - 25, 80, 20, resurrectionStr));
        this.buttonList.add(guiEnchantmentButton = new GuiButton(-2, centerX + 50, centerY - 25, 80, 20, enchantingStr));
        this.buttonList.add(guiDisenchantmentButton = new GuiButton(-3, centerX + 140, centerY - 25, 80, 20, disenchantingStr));
        button.enabled = false;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.renderEngine.bindTexture(getGuiTexture());
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        this.drawString(this.fontRenderer, String.format(requirementsStr, getLevel()), (width - xSize) / 2 + 82, (height - ySize) / 2 + 69, 16777215);
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                sendMessage();
                break;
            case -1:
                switchGui(GuiHandler.ALTAR_RESURRECTION_GUI_ID);
                break;
            case -2:
                switchGui(GuiHandler.ALTAR_ENCHANTMENT_GUI_ID);
                break;
            case -3:
                switchGui(GuiHandler.ALTAR_DISENCHANTMENT_GUI_ID);
                break;
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);

        if (player != null) {
            int requiredLevel = getLevel();
            button.enabled = requiredLevel > 0  && (isCreative || player.experienceLevel >= requiredLevel);
        }
    }

    protected void switchGui(int id) {
        MessageHandler.networkWrapper.sendToServer(new AltarSwitchGuiMessageToServer(this.player, id, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()));
    }

    protected abstract void sendMessage();

    protected abstract String getButtonStr();

    protected abstract ResourceLocation getGuiTexture();

    protected int getLevel() {
        return container.getRequiredLevel();
    }
}
