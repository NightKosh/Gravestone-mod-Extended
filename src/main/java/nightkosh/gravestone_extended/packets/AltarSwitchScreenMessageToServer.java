package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.SimpleMenuProvider;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.gui.container.DisenchantmentContainerMenu;
import nightkosh.gravestone_extended.gui.container.EnchantmentContainerMenu;
import nightkosh.gravestone_extended.gui.container.ResurrectionContainerMenu;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public record AltarSwitchScreenMessageToServer(String playerId, int guiId, int xPos, int yPos, int zPos)
        implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<AltarSwitchScreenMessageToServer> TYPE =
            new CustomPacketPayload.Type<>(fromNamespaceAndPath(ModInfo.ID, "altar_switch_screen"));

    public static final StreamCodec<ByteBuf, AltarSwitchScreenMessageToServer> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, AltarSwitchScreenMessageToServer::playerId,
                    ByteBufCodecs.INT, AltarSwitchScreenMessageToServer::guiId,
                    ByteBufCodecs.INT, AltarSwitchScreenMessageToServer::xPos,
                    ByteBufCodecs.INT, AltarSwitchScreenMessageToServer::yPos,
                    ByteBufCodecs.INT, AltarSwitchScreenMessageToServer::zPos,
                    AltarSwitchScreenMessageToServer::new);

    public static void handle(AltarSwitchScreenMessageToServer msg, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to handle AltarSwitchScreenMessageToServer message");
            }
            var pos = new BlockPos(msg.xPos, msg.yPos, msg.zPos);
            var player = context.player();
            var level = player.level();
            if (level.getBlockEntity(pos) instanceof AltarBlockEntity altar) {
                var provider = switch (msg.guiId()) {
                    case 1 -> new SimpleMenuProvider(
                            (containerId, inv, p) -> new ResurrectionContainerMenu(containerId, inv, altar),
                              Component.empty()
                    );
                    case 2 -> new SimpleMenuProvider(
                            (containerId, inv, p) -> new EnchantmentContainerMenu(containerId, inv, altar),
                            Component.empty()
                    );
                    case 3 -> new SimpleMenuProvider(
                            (containerId, inv, p) -> new DisenchantmentContainerMenu(containerId, inv, altar),
                            Component.empty()
                    );
                    default -> null;
                };

                if (provider != null) {
                    player.openMenu(provider, (RegistryFriendlyByteBuf buf) -> {
                        buf.writeBlockPos(pos);
                    });
                }
            }
        });
    }

    @Nonnull
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

}
