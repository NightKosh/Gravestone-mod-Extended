package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import java.util.Comparator;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public record DisenchantmentMessageToServer(String playerId, int xPos, int yPos, int zPos) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<DisenchantmentMessageToServer> TYPE =
            new CustomPacketPayload.Type<>(fromNamespaceAndPath(ModInfo.ID, "altar_disenchantment"));

    public static final StreamCodec<ByteBuf, DisenchantmentMessageToServer> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, DisenchantmentMessageToServer::playerId,
                    ByteBufCodecs.INT, DisenchantmentMessageToServer::xPos,
                    ByteBufCodecs.INT, DisenchantmentMessageToServer::yPos,
                    ByteBufCodecs.INT, DisenchantmentMessageToServer::zPos,
                    DisenchantmentMessageToServer::new);

    public static void handle(DisenchantmentMessageToServer msg, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to handle DisenchantmentMessageToServer message");
            }
            var pos = new BlockPos(msg.xPos, msg.yPos, msg.zPos);
            var player = context.player();
            var level = player.level();
            if (level.getBlockEntity(pos) instanceof AltarBlockEntity altar) {
                var inventory = altar.getDisenchantmentInventory();
                if (!inventory.isEmpty()) {
                    var item = inventory.getItem(0);
                    if (!item.isEmpty()) {
                        var enchList = GSEEnchantmentHelper.getEnchantmentsWithLevel(item);
                        enchList.sort(Comparator.comparing(
                                (Pair<Holder<Enchantment>, Integer> p) -> !GSEEnchantmentHelper.isCurse(p.getKey())));
                        if (!enchList.isEmpty()) {
                            int requiredLevels = GSEEnchantmentHelper.getLevelsToDisenchant(enchList);
                            if (player.isCreative() || player.experienceLevel >= requiredLevels) {
                                if (GSEConfigs.DEBUG_MODE.get()) {
                                    LOGGER.info("Going to disenchant item py player {} at {} for {} levels",
                                            player.getScoreboardName(), pos.toShortString(), requiredLevels);
                                }
                                for (int slot = 1, enchantmentIndex = 0; slot < inventory.getContainerSize() && enchantmentIndex < enchList.size(); slot++) {
                                    var skull = inventory.getItem(slot);
                                    if (skull.is(Items.SKELETON_SKULL) || skull.is(Items.WITHER_SKELETON_SKULL)) {
                                        var enchantedSkull = GSEEnchantmentHelper.transferEnchantmentToSkull(skull, enchList.get(enchantmentIndex));
                                        enchantmentIndex++;

                                        inventory.setItem(slot, enchantedSkull);
                                    }
                                }
                                inventory.removeEnchantedItem();
                                if (!player.isCreative()) {
                                    player.giveExperienceLevels(-requiredLevels);
                                }
                                altar.setChanged();
                            } else if (GSEConfigs.DEBUG_MODE.get()) {
                                LOGGER.info("Can't disenchant item py player {} at {} - not enough levels",
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
