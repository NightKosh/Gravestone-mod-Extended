package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.inventory.AltarDisenchantmentInventory;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

import java.util.ArrayList;
import java.util.List;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarDisenchantmentMessageToServer implements IMessage, IMessageHandler<AltarDisenchantmentMessageToServer, IMessage> {

    private int playerID;
    private int dimensionID;
    private int x;
    private int y;
    private int z;

    public AltarDisenchantmentMessageToServer() {

    }

    public AltarDisenchantmentMessageToServer(EntityPlayer player, int x, int y, int z) {
        this.playerID = player.getEntityId();
        this.dimensionID = player.getEntityWorld().provider.getDimension();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.playerID = buf.readInt();
        this.dimensionID = buf.readInt();
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(playerID);
        buf.writeInt(dimensionID);
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
    }

    @Override
    public IMessage onMessage(AltarDisenchantmentMessageToServer message, MessageContext ctx) {
        if (ctx.side.isServer()) {
            World world = DimensionManager.getWorld(message.dimensionID);
            if (world == null || ((ctx.getServerHandler().player != null) && (ctx.getServerHandler().player.getEntityId() != message.playerID))) {
                return null;
            }
            EntityPlayer player = (EntityPlayer) world.getEntityByID(message.playerID);
            TileEntity te = world.getTileEntity(new BlockPos(message.x, message.y, message.z));
            if (te != null && te instanceof TileEntityAltar) {
                TileEntityAltar tileEntity = (TileEntityAltar) te;
                AltarDisenchantmentInventory inventory = tileEntity.getDisenchantmentInventory();
                if (!inventory.isEmpty()) {
                    ItemStack item = inventory.getEnchItem();
                    NBTTagList enchantmenstList = item.getEnchantmentTagList();
                    List<NBTBase> enchantments = new ArrayList<>();
                    for (NBTBase nbt : enchantmenstList) {
                        enchantments.add(nbt);
                    }
                    if (!enchantments.isEmpty()) {
                        int requiredLevels = 0;
                        int skullNum = 0;
                        for (int i = 1; i < inventory.getSizeInventory(); i++) {
                            ItemStack skull = inventory.getStackInSlot(i);
                            if (skull != ItemStack.EMPTY && skull.getItem() == Items.SKULL) {
                                ItemStack enchantedSkull = new ItemStack(GSItem.ENCHANTED_SKULL, 1, skull.getMetadata());
                                NBTTagList nbt = new NBTTagList();
                                nbt.appendTag(enchantments.get(skullNum));
                                enchantedSkull.setTagInfo("ench", nbt);

                                requiredLevels += 10;
                                requiredLevels += ((NBTTagCompound) enchantments.get(skullNum)).getShort("lvl");

                                inventory.setInventorySlotContents(i, enchantedSkull);

                                skullNum++;
                                if (skullNum >= enchantments.size()) {
                                    break;
                                }
                            }
                        }
                        if (skullNum > 0) {
                            inventory.setEnchItem(ItemStack.EMPTY);
                            if (!player.getEntityWorld().getWorldInfo().getGameType().equals(GameType.CREATIVE)) {
                                player.addExperienceLevel(-requiredLevels);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
