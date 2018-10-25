package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nightkosh.gravestone_extended.helper.VanillaStructuresPosition;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class SeedMessageToClient implements IMessage, IMessageHandler<SeedMessageToClient, IMessage> {

    private long seed;

    public SeedMessageToClient() {

    }

    public SeedMessageToClient(long seed) {
        this.seed = seed;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.seed = buf.readLong();

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(this.seed);
    }

    @Override
    public IMessage onMessage(SeedMessageToClient message, MessageContext ctx) {
        if (ctx.side.isClient()) {
            VanillaStructuresPosition.SEEDS.put(Minecraft.getMinecraft().world.getWorldInfo().getWorldName(),  message.seed);
        }
        return null;
    }
}
