package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ChiselMessageToServer implements IMessage, IMessageHandler<ChiselMessageToServer, IMessage> {

    public static final String DATA_GROUP = "GraveCrafting";
    public static final String IS_GRAVESTONE = "IsGravestone";
    public static final String GRAVE_TYPE = "GraveType";
    public static final String MEMORIAL_TYPE = "MemorialType";
    public static final String MATERIAL = "Material";
    public static final String IS_ENCHANTED = "IsEnchanted";
    public static final String IS_MOSSY = "IsMossy";

    private int playerID;
    private int dimensionID;
    private boolean isGravestone;
    private int graveType;
    private int memorialType;
    private int material;
    private boolean isEnchanted;
    private boolean isMossy;

    public ChiselMessageToServer() {
    }

    public ChiselMessageToServer(EntityPlayer player, boolean isGravestone, int graveType, int memorialType, int material, boolean isEnchanted, boolean isMossy) {
        this.playerID = player.getEntityId();
        this.dimensionID = player.getEntityWorld().provider.getDimension();
        this.isGravestone = isGravestone;
        this.graveType = graveType;
        this.memorialType = memorialType;
        this.material = material;
        this.isEnchanted = isEnchanted;
        this.isMossy = isMossy;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.playerID = buf.readInt();
        this.dimensionID = buf.readInt();
        this.isGravestone = buf.readBoolean();
        this.graveType = buf.readInt();
        this.memorialType = buf.readInt();
        this.material = buf.readInt();
        this.isEnchanted = buf.readBoolean();
        this.isMossy = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(playerID);
        buf.writeInt(dimensionID);
        buf.writeBoolean(isGravestone);
        buf.writeInt(graveType);
        buf.writeInt(memorialType);
        buf.writeInt(material);
        buf.writeBoolean(isEnchanted);
        buf.writeBoolean(isMossy);
    }

    @Override
    public IMessage onMessage(ChiselMessageToServer message, MessageContext ctx) {
        if (ctx.side.isServer()) {
            World world = DimensionManager.getWorld(message.dimensionID);
            if (world != null && ctx.getServerHandler().player != null && ctx.getServerHandler().player.getEntityId() == message.playerID) {
                EntityPlayer player = (EntityPlayer) world.getEntityByID(message.playerID);
                NBTTagCompound playerNbt = player.getEntityData();
                NBTTagCompound graveNbt = new NBTTagCompound();
                graveNbt.setBoolean(IS_GRAVESTONE, message.isGravestone);
                graveNbt.setInteger(GRAVE_TYPE, message.graveType);
                graveNbt.setInteger(MEMORIAL_TYPE, message.memorialType);
                graveNbt.setInteger(MATERIAL, message.material);
                graveNbt.setBoolean(IS_ENCHANTED, message.isEnchanted);
                graveNbt.setBoolean(IS_MOSSY, message.isMossy);
                playerNbt.setTag(DATA_GROUP, graveNbt);
            }
        }
        return null;
    }
}
