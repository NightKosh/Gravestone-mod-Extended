package nightkosh.gravestone_extended.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.core.event.GSEMessages;
import nightkosh.gravestone_extended.gui.container.AAltarContainerMenu;
import nightkosh.gravestone_extended.packets.AltarSwitchScreenMessageToServer;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class AAltarScreen extends AbstractContainerScreen<AAltarContainerMenu> {

    private static final int TEXTURE_SIZE = 256;

    private final MutableComponent requirementsStr = Component.translatable("gui.gravestone_extended.altar.requirements");
    private final MutableComponent resurrectionStr = Component.translatable("gui.gravestone_extended.altar.tab.resurrection");
    private final MutableComponent enchantingStr = Component.translatable("gui.gravestone_extended.altar.tab.enchanting");
    private final MutableComponent disenchantingStr = Component.translatable("gui.gravestone_extended.altar.tab.disenchanting");

    protected Button guiResurrectionButton;
    protected Button guiEnchantmentButton;
    protected Button guiDisenchantmentButton;
    protected Button button;

    protected boolean isCreative;
    protected Player player;
    protected AltarBlockEntity altar;
    protected AAltarContainerMenu container;

    public AAltarScreen(AAltarContainerMenu menu, Inventory inventoryPlayer, Component title) {
        super(menu, inventoryPlayer, title);
        this.altar = menu.altar;
        this.player = inventoryPlayer.player;
        this.container = menu;
        this.isCreative = player.isCreative();
    }

    @Override
    public void init() {
        super.init();

        this.addRenderableWidget(button = Button.builder(getButtonStr(), btn -> sendMessage())
                .bounds(this.leftPos + 100, this.topPos + 33, 70, 20)
                        .tooltip(Tooltip.create(getTooltipStr()))
                .build());

        this.addRenderableWidget(guiResurrectionButton = Button.builder(resurrectionStr, btn -> switchGui(1))
                .bounds(this.leftPos - 40, this.topPos - 25, 80, 20)
                .build());

        this.addRenderableWidget(guiEnchantmentButton = Button.builder(enchantingStr, btn -> switchGui(2))
                .bounds(this.leftPos + 50, this.topPos - 25, 80, 20)
                .build());

        this.addRenderableWidget(guiDisenchantmentButton = Button.builder(disenchantingStr, btn -> switchGui(3))
                .bounds(this.leftPos + 140, this.topPos - 25, 80, 20)
                .build());

        button.active = false;
        guiResurrectionButton.active = false;//TODO remove
    }

    @Override
    public void render(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);

        if (player != null) {
            int requiredLevel = getLevel();
            button.active = requiredLevel > 0 && (isCreative || player.experienceLevel >= requiredLevel);
        }
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, getGuiTexture(),
                this.leftPos, this.topPos,
                0, 0,
                TEXTURE_SIZE, TEXTURE_SIZE,
                TEXTURE_SIZE, TEXTURE_SIZE);
    }

    @Override
    protected void renderLabels(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font,
                String.format(requirementsStr.getString(), getLevel()),
                100, 69,
                -12566464,
                false);
    }

    protected void switchGui(int id) {
        GSEMessages.sendToServer(
                new AltarSwitchScreenMessageToServer(
                        this.player.getUUID().toString(),
                        id,
                        altar.getBlockPos().getX(),
                        altar.getBlockPos().getY(),
                        altar.getBlockPos().getZ()));
    }

    protected int getLevel() {
        return container.getRequiredLevel();
    }

    protected Component getTooltipStr() {
        return Component.translatable("gui.gravestone_extended.altar.tooltip.destroy_item");
    }

    protected abstract void sendMessage();

    protected abstract MutableComponent getButtonStr();

    protected abstract Identifier getGuiTexture();

}
