package nightkosh.gravestone_extended.gui;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import nightkosh.gravestone_extended.core.GSETextures;
import nightkosh.gravestone_extended.core.event.GSEMessages;
import nightkosh.gravestone_extended.gui.container.AAltarContainerMenu;
import nightkosh.gravestone_extended.packets.DisenchantmentMessageToServer;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class DisenchantmentScreen extends AAltarScreen {

    private final MutableComponent disenchantButtonStr = Component.translatable("gui.gravestone_extended.altar.disenchant");

    public DisenchantmentScreen(AAltarContainerMenu menu, Inventory inventoryPlayer, Component title) {
        super(menu, inventoryPlayer, title);
    }

    @Override
    public void init() {
        super.init();
        guiDisenchantmentButton.active = false;
    }

    @Override
    protected void sendMessage() {
        GSEMessages.sendToServer(
                new DisenchantmentMessageToServer(
                        this.player.getUUID().toString(),
                        altar.getBlockPos().getX(),
                        altar.getBlockPos().getY(),
                        altar.getBlockPos().getZ()));
    }

    @Override
    protected Component getTooltipStr() {
        return Component.translatable("gui.gravestone_extended.altar.tooltip.destroy_item");
    }

    @Override
    protected MutableComponent getButtonStr() {
        return disenchantButtonStr;
    }

    @Override
    protected Identifier getGuiTexture() {
        return GSETextures.ALTAR_DISENCHANTMENT_GUI;
    }

}
