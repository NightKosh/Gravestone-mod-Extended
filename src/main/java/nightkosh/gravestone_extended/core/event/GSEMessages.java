package nightkosh.gravestone_extended.core.event;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.packets.ResurrectionMessageToServer;
import nightkosh.gravestone_extended.packets.AltarSwitchScreenMessageToServer;
import nightkosh.gravestone_extended.packets.DisenchantmentMessageToServer;
import nightkosh.gravestone_extended.packets.EnchantmentMessageToServer;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEMessages {

    public static final String NETWORK_VERSION = "1";

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final var registrar = event.registrar(NETWORK_VERSION);

        registrar.playToServer(
                ResurrectionMessageToServer.TYPE,
                ResurrectionMessageToServer.STREAM_CODEC,
                ResurrectionMessageToServer::handle);

        registrar.playToServer(
                DisenchantmentMessageToServer.TYPE,
                DisenchantmentMessageToServer.STREAM_CODEC,
                DisenchantmentMessageToServer::handle);

        registrar.playToServer(
                EnchantmentMessageToServer.TYPE,
                EnchantmentMessageToServer.STREAM_CODEC,
                EnchantmentMessageToServer::handle);

        registrar.playToServer(
                AltarSwitchScreenMessageToServer.TYPE,
                AltarSwitchScreenMessageToServer.STREAM_CODEC,
                AltarSwitchScreenMessageToServer::handle);
    }

    public static void sendToServer(CustomPacketPayload payload) {
        ClientPacketDistributor.sendToServer(payload);
    }

    public static void sendToPlayer(CustomPacketPayload payload, ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, payload);
    }

}
