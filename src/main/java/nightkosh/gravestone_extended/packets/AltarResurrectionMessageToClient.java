package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarResurrectionMessageToClient {//TODO implements IMessage, IMessageHandler<AltarResurrectionMessageToClient, IMessage> {

    public AltarResurrectionMessageToClient() {

    }

//    @Override
//    public void fromBytes(ByteBuf buf) {
//    }
//
//    @Override
//    public void toBytes(ByteBuf buf) {
//    }
//
//    @Override
//    public IMessage onMessage(AltarResurrectionMessageToClient message, MessageContext ctx) {
//        if (ctx.side.isClient()) {
//            Minecraft.getMinecraft().displayGuiScreen(null);
//        }
//        return null;
//    }
}
