package nightkosh.gravestone_extended.packets;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarResurrectionMessageToServer {//TODO implements IMessage, IMessageHandler<AltarResurrectionMessageToServer, IMessage> {

    private int playerID;
    private int dimensionID;
    private int x;
    private int y;
    private int z;
    private MOB_TYPE mobType;

    public enum MOB_TYPE {
        LIVED,
        ZOMBIE,
        SKELETON,
        GHOST;

        public static MOB_TYPE getMobType(int num) {
            if (MOB_TYPE.values().length <= num) {
                return LIVED;
            } else {
                return MOB_TYPE.values()[num];
            }
        }
    }

    public AltarResurrectionMessageToServer() {

    }
//
//    public AltarResurrectionMessageToServer(EntityPlayer player, int x, int y, int z, MOB_TYPE mobType) {
//        this.playerID = player.getEntityId();
//        this.dimensionID = player.getEntityWorld().provider.getDimension();
//        this.x = x;
//        this.y = y;
//        this.z = z;
//        this.mobType = mobType;
//    }
//
//    @Override
//    public void fromBytes(ByteBuf buf) {
//        this.playerID = buf.readInt();
//        this.dimensionID = buf.readInt();
//        this.x = buf.readInt();
//        this.y = buf.readInt();
//        this.z = buf.readInt();
//        this.mobType = MOB_TYPE.getMobType(buf.readInt());
//    }
//
//    @Override
//    public void toBytes(ByteBuf buf) {
//        buf.writeInt(playerID);
//        buf.writeInt(dimensionID);
//        buf.writeInt(x);
//        buf.writeInt(y);
//        buf.writeInt(z);
//        buf.writeInt(mobType.ordinal());
//    }
//
//    @Override
//    public IMessage onMessage(AltarResurrectionMessageToServer message, MessageContext ctx) {
//        if (ctx.side.isServer()) {
//            World world = DimensionManager.getWorld(message.dimensionID);
//            if (world == null || ((ctx.getServerHandler().player != null) && (ctx.getServerHandler().player.getEntityId() != message.playerID))) {
//                return null;
//            }
//            EntityPlayer player = (EntityPlayer) world.getEntityByID(message.playerID);
//            TileEntity te = world.getTileEntity(new BlockPos(message.x, message.y, message.z));
//            if (te != null && te instanceof TileEntityAltar) {
//                TileEntityAltar tileEntity = (TileEntityAltar) te;
//                if (!tileEntity.getCorpseInventory().isEmpty()) {
//                    ItemStack corpse = tileEntity.getCorpseInventory().getStackInSlot(0);
//                    if (corpse != null && !corpse.isEmpty() && Block.getBlockFromItem(corpse.getItem()) instanceof BlockCorpse && CorpseHelper.canSpawnMob(player, corpse)) {
//                        CorpseHelper.spawnMob(corpse.getItemDamage(), tileEntity.getWorld(), tileEntity.getPos().getX(), tileEntity.getPos().getY(), tileEntity.getPos().getZ(), corpse.getTagCompound(), player);
//                        CorpseHelper.getExperience(player, corpse.getItemDamage());
//                        MessageHandler.networkWrapper.sendTo(new AltarResurrectionMessageToClient(), (EntityPlayerMP) player);
//                        tileEntity.getCorpseInventory().setInventorySlotContents(0, ItemStack.EMPTY);
//                    }
//                }
//            }
//        }
//        return null;
//    }
}
