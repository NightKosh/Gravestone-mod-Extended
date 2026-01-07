package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import nightkosh.gravestone_extended.core.MessageHandler;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class StrongholdMessageToServer {//TODO implements IMessage, IMessageHandler<StrongholdMessageToServer, IMessage> {

    private int playerID;
    private int dimensionID;

    public StrongholdMessageToServer() {

    }
//
//    public StrongholdMessageToServer(EntityPlayer player) {
//        this.playerID = player.getEntityId();
//        this.dimensionID = player.getEntityWorld().provider.getDimension();
//    }
//
//    @Override
//    public void fromBytes(ByteBuf buf) {
//        this.playerID = buf.readInt();
//        this.dimensionID = buf.readInt();
//    }
//
//    @Override
//    public void toBytes(ByteBuf buf) {
//        buf.writeInt(this.playerID);
//        buf.writeInt(this.dimensionID);
//    }
//
//    @Override
//    public IMessage onMessage(StrongholdMessageToServer message, MessageContext ctx) {
//        if (ctx.side.isServer()) {
//            WorldServer world = DimensionManager.getWorld(message.dimensionID);
//            if (world == null || ((ctx.getServerHandler().player != null) && (ctx.getServerHandler().player.getEntityId() != message.playerID))) {
//                return null;
//            }
//            EntityPlayerMP player = (EntityPlayerMP) world.getEntityByID(message.playerID);
//            if (player != null) {
//                BlockPos pos = world.getChunkProvider().getNearestStructurePos(world, "Stronghold", new BlockPos(player), false);
//                if (pos != null) {
//                    MessageHandler.networkWrapper.sendTo(new StrongholdMessageToClient(pos), player);
//                }
//            }
//        }
//        return null;
//    }
}
