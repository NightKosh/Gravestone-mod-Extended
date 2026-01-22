package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public record EnchantmentMessageToServer(String playerId, int xPos, int yPos, int zPos) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<EnchantmentMessageToServer> TYPE =
            new CustomPacketPayload.Type<>(fromNamespaceAndPath(ModInfo.ID, "altar_enchantment"));

    public static final StreamCodec<ByteBuf, EnchantmentMessageToServer> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, EnchantmentMessageToServer::playerId,
                    ByteBufCodecs.INT, EnchantmentMessageToServer::xPos,
                    ByteBufCodecs.INT, EnchantmentMessageToServer::yPos,
                    ByteBufCodecs.INT, EnchantmentMessageToServer::zPos,
                    EnchantmentMessageToServer::new);

    public static void handle(EnchantmentMessageToServer msg, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to handle EnchantmentMessageToServer message");
            }
            var pos = new BlockPos(msg.xPos, msg.yPos, msg.zPos);
            var player = context.player();
            var level = player.level();
            if (level.getBlockEntity(pos) instanceof AltarBlockEntity altar) {
                var inventory = altar.getEnchantmentInventory();
                if (!inventory.isEmpty()) {
                    var itemToEnchant = inventory.getEnchItem();
                    var enchantedSkull = inventory.getSkull();
                    if (!itemToEnchant.isEmpty()) {
                        var enchList = GSEEnchantmentHelper.getEnchantmentsWithLevel(enchantedSkull);
                        if (!enchList.isEmpty()) {
                            int requiredLevels = GSEEnchantmentHelper.getLevelsToEnchant(enchList);
                            if (player.isCreative() || player.experienceLevel >= requiredLevels) {
                                if (GSEConfigs.DEBUG_MODE.get()) {
                                    LOGGER.info("Going to enchant item py player {} at {} for {} levels",
                                            player.getScoreboardName(), pos.toShortString(), requiredLevels);
                                }
                                for (var enchantment : enchList) {
                                    GSEEnchantmentHelper.transferEnchantmentToItem(itemToEnchant, enchantment);
                                }
                                inventory.setSkull(enchantedSkull);
                                if (!player.isCreative()) {
                                    player.giveExperienceLevels(-requiredLevels);
                                }
                                altar.setChanged();
                            } else if (GSEConfigs.DEBUG_MODE.get()) {
                                LOGGER.info("Can't enchant item py player {} at {} - not enough levels",
                                        player.getScoreboardName(), pos.toShortString());
                            }
                        }
                    }
                }
            }
        });
    }

    @Nonnull
    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

}
