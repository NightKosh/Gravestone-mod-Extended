package nightkosh.gravestone_extended.core;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import nightkosh.gravestone_extended.packets.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class MessageHandler {
    public static final SimpleNetworkWrapper networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(ModInfo.ID.toLowerCase());

    public static void init() {
        networkWrapper.registerMessage(GraveDeathMessageToServer.class, GraveDeathMessageToServer.class, 0, Side.SERVER);
        networkWrapper.registerMessage(AltarResurrectionMessageToServer.class, AltarResurrectionMessageToServer.class, 1, Side.SERVER);
        networkWrapper.registerMessage(AltarResurrectionMessageToClient.class, AltarResurrectionMessageToClient.class, 2, Side.CLIENT);
        networkWrapper.registerMessage(ChiselMessageToServer.class, ChiselMessageToServer.class, 3, Side.SERVER);
        networkWrapper.registerMessage(ChokeMessageToClient.class, ChokeMessageToClient.class, 4, Side.CLIENT);
        networkWrapper.registerMessage(StrongholdMessageToServer.class, StrongholdMessageToServer.class, 5, Side.SERVER);
        networkWrapper.registerMessage(StrongholdMessageToClient.class, StrongholdMessageToClient.class, 6, Side.CLIENT);
        networkWrapper.registerMessage(NetherFortressMessageToServer.class, NetherFortressMessageToServer.class, 7, Side.SERVER);
        networkWrapper.registerMessage(NetherFortressMessageToClient.class, NetherFortressMessageToClient.class, 8, Side.CLIENT);
        networkWrapper.registerMessage(AltarDisenchantmentMessageToServer.class, AltarDisenchantmentMessageToServer.class, 9, Side.SERVER);
        networkWrapper.registerMessage(AltarEnchantmentMessageToServer.class, AltarEnchantmentMessageToServer.class, 10, Side.SERVER);
//        networkWrapper.registerMessage(AltarGuiMessageToServer.class, AltarGuiMessageToServer.class, 9, Side.SERVER);
    }
}
