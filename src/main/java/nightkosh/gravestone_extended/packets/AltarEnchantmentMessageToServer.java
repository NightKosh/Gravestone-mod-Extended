package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;
import nightkosh.gravestone_extended.inventory.AltarEnchantmentInventory;
import nightkosh.gravestone_extended.tileentity.TileEntityAltar;

import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class AltarEnchantmentMessageToServer implements IMessage, IMessageHandler<AltarEnchantmentMessageToServer, IMessage> {

    private int playerID;
    private int dimensionID;
    private int x;
    private int y;
    private int z;

    public AltarEnchantmentMessageToServer() {

    }

    public AltarEnchantmentMessageToServer(EntityPlayer player, int x, int y, int z) {
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
    public IMessage onMessage(AltarEnchantmentMessageToServer message, MessageContext ctx) {
        if (ctx.side.isServer()) {
            World world = DimensionManager.getWorld(message.dimensionID);
            if (world == null || ((ctx.getServerHandler().player != null) && (ctx.getServerHandler().player.getEntityId() != message.playerID))) {
                return null;
            }
            EntityPlayer player = (EntityPlayer) world.getEntityByID(message.playerID);
            TileEntity te = world.getTileEntity(new BlockPos(message.x, message.y, message.z));
            if (te != null && te instanceof TileEntityAltar) {
                transferEnchantments(player, ((TileEntityAltar) te).getEnchantmentInventory());
            }
        }
        return null;
    }

    public void transferEnchantments(EntityPlayer player, AltarEnchantmentInventory inventory) {
        if (!inventory.isEmpty()) {
            ItemStack enchItem = inventory.getEnchItem();
            ItemStack skull = inventory.getEnchSkull();
            Map<Enchantment, Integer> itemEnchantments = EnchantmentHelper.getEnchantments(enchItem);

            if (skull.getItem() == GSItem.ENCHANTED_SKULL && !ItemEnchantedBook.getEnchantments(skull).hasNoTags()) {
                int requiredLevels = 0;
                Map<Enchantment, Integer> skullEnchantments = GSEnchantmentHelper.getSkullEnchantments(skull);

                for (Enchantment skullEnchantment : skullEnchantments.keySet()) {
                    if (skullEnchantment != null) {
                        int itemEnchLvl = itemEnchantments.containsKey(skullEnchantment) ? itemEnchantments.get(skullEnchantment) : 0;
                        if (itemEnchLvl < skullEnchantment.getMaxLevel()) {
                            int skullEnchLvl = skullEnchantments.get(skullEnchantment);
                            if (skullEnchLvl >= itemEnchLvl) {
                                if (itemEnchLvl == skullEnchLvl) {
                                    skullEnchLvl = skullEnchLvl + 1;
                                } else {
                                    skullEnchLvl = Math.max(skullEnchLvl, itemEnchLvl);
                                }

                                if (skullEnchantment.canApply(enchItem)) {
                                    boolean canApply = true;
                                    for (Enchantment enchantment : itemEnchantments.keySet()) {
                                        if (enchantment != skullEnchantment && !skullEnchantment.isCompatibleWith(enchantment)) {
                                            canApply = false;
                                            break;
                                        }
                                    }
                                    if (canApply) {
                                        itemEnchantments.put(skullEnchantment, skullEnchLvl);

                                        switch (skullEnchantment.getRarity()) {
                                            case COMMON:
                                                requiredLevels += 2;
                                                break;
                                            case UNCOMMON:
                                                requiredLevels += 4;
                                                break;
                                            case RARE:
                                                requiredLevels += 8;
                                                break;
                                            case VERY_RARE:
                                                requiredLevels += 15;
                                        }
                                        requiredLevels += skullEnchLvl - itemEnchLvl;
                                    }
                                }
                            }
                        }
                    }
                }

                boolean isCreativeMode = player.getEntityWorld().getWorldInfo().getGameType().equals(GameType.CREATIVE);
                if (requiredLevels > 0 && (isCreativeMode || player.experienceLevel >= requiredLevels)) {
                    if (enchItem.getItem() == GSItem.ENCHANTED_SKULL) {
                        for (Map.Entry<Enchantment, Integer> entry : itemEnchantments.entrySet()) {
                            Enchantment enchantment = entry.getKey();
                            if (enchantment != null) {
                                ItemEnchantedBook.addEnchantment(enchItem, new EnchantmentData(enchantment, entry.getValue()));
                            }
                        }
                    } else {
                        EnchantmentHelper.setEnchantments(itemEnchantments, enchItem);
                    }


                    inventory.setEnchItem(enchItem);
                    inventory.setEnchSkull(new ItemStack(Items.SKULL, 1, skull.getMetadata()));

                    if (!isCreativeMode) {
                        player.addExperienceLevel(-requiredLevels);
                    }
                }
            }
        }
    }
}
