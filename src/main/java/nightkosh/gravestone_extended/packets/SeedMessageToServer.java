package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nightkosh.gravestone_extended.core.MessageHandler;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SeedMessageToServer implements IMessage, IMessageHandler<SeedMessageToServer, IMessage> {

    public SeedMessageToServer() {

    }

    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    @Override
    public IMessage onMessage(SeedMessageToServer message, MessageContext ctx) {
        if (ctx.side.isServer()) {
            WorldServer world = DimensionManager.getWorld(0);
            if (world != null) {
                MessageHandler.networkWrapper.sendToAll(new SeedMessageToClient(world.getSeed()));
            }
        }
        return null;
    }
}
