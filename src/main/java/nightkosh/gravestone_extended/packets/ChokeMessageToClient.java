package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nightkosh.gravestone_extended.capability.choke.ChokeProvider;
import nightkosh.gravestone_extended.capability.choke.IChoke;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChokeMessageToClient implements IMessage, IMessageHandler<ChokeMessageToClient, IMessage> {

    private int air;
    private boolean isActive;

    public ChokeMessageToClient() {
    }

    public ChokeMessageToClient(int air, boolean isActive) {
        this.air = air;
        this.isActive = isActive;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.air = buf.readInt();
        this.isActive = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(air);
        buf.writeBoolean(isActive);
    }

    @Override
    public IMessage onMessage(ChokeMessageToClient message, MessageContext ctx) {
        if (ctx.side.isClient()) {
            IChoke choke = FMLClientHandler.instance().getClient().player.getCapability(ChokeProvider.AIR_CAP, null);
            choke.setAir(message.air);
            choke.setActive(message.isActive);
        }
        return null;
    }
}
