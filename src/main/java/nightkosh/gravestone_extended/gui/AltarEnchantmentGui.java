package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
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
    private AltarEnchantmentContainer container;

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
    protected String getButtonStr() {
        return enchantButtonStr;
    }

    @Override
    protected ResourceLocation getGuiTexture() {
        return Resources.ALTAR_ENCHANTMENT_GUI;
    }

    @Override
    protected int getLevel() {
        //TODO level!!
        return container.getEnchantmentLevel();
    }
}
