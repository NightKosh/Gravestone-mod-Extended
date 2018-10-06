package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nightkosh.gravestone_extended.ModGravestoneExtended;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarGuiMessageToServer implements IMessage, IMessageHandler<AltarGuiMessageToServer, IMessage> {

    private int playerID;
    private int dimensionID;
    private int guiId;

    public AltarGuiMessageToServer() {

    }

    public AltarGuiMessageToServer(EntityPlayer player, int id) {
        this.playerID = player.getEntityId();
        this.dimensionID = player.getEntityWorld().provider.getDimension();
        this.guiId = id;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.playerID = buf.readInt();
        this.dimensionID = buf.readInt();
        this.guiId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(playerID);
        buf.writeInt(dimensionID);
        buf.writeInt(guiId);
    }

    @Override
    public IMessage onMessage(AltarGuiMessageToServer message, MessageContext ctx) {
        if (ctx.side.isServer()) {
            World world = DimensionManager.getWorld(message.dimensionID);
            if (world == null || ((ctx.getServerHandler().player != null) && (ctx.getServerHandler().player.getEntityId() != message.playerID))) {
                return null;
            }
            EntityPlayer player = (EntityPlayer) world.getEntityByID(message.playerID);
            player.openGui(ModGravestoneExtended.instance, message.guiId, player.getEntityWorld(), player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
        }
        return null;
    }
}
