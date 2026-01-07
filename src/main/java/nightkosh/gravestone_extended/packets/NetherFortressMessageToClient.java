package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import nightkosh.gravestone_extended.helper.VanillaStructuresPosition;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class NetherFortressMessageToClient {//TODO implements IMessage, IMessageHandler<NetherFortressMessageToClient, IMessage> {

    private int x;
    private int y;
    private int z;

    public NetherFortressMessageToClient() {

    }
//
//    public NetherFortressMessageToClient(BlockPos pos) {
//        this.x = pos.getX();
//        this.y = pos.getY();
//        this.z = pos.getZ();
//    }
//
//    @Override
//    public void fromBytes(ByteBuf buf) {
//        this.x = buf.readInt();
//        this.y = buf.readInt();
//        this.z = buf.readInt();
//    }
//
//    @Override
//    public void toBytes(ByteBuf buf) {
//        buf.writeInt(this.x);
//        buf.writeInt(this.y);
//        buf.writeInt(this.z);
//    }
//
//    @Override
//    public IMessage onMessage(NetherFortressMessageToClient message, MessageContext ctx) {
//        if (ctx.side.isClient()) {
//            VanillaStructuresPosition.setNetherFortress(new BlockPos(message.x, message.y, message.z));
//        }
//        return null;
//    }
}
