package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
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
    private AltarDisenchantmentContainer container;

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
        guiDisenchantmentButton.enabled = false;
    }

    @Override
    public void actionPerformed(GuiButton button) {
        switch (button.id) {
            case 0:
                MessageHandler.networkWrapper.sendToServer(new AltarDisenchantmentMessageToServer(this.player, tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ()));
                break;
            default:
                super.actionPerformed(button);
                break;
        }
    }

    @Override
    protected String getButtonStr() {
        return disenchantButtonStr;
    }

    @Override
    protected ResourceLocation getGuiTexture() {
        return Resources.ALTAR_DISENCHANTMENT_GUI;
    }

    @Override
    protected int getLevel() {
        //TODO level!!
        return container.getDisenchantmentLevel();
    }
}
