package nightkosh.gravestone_extended.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import nightkosh.gravestone_extended.block_entity.AltarBlockEntity;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.item.corpse.Corpse;
import nightkosh.gravestone_extended.item.corpse.CorpseHelper;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public record ResurrectionMessageToServer(String playerId, int xPos, int yPos,
                                          int zPos) implements CustomPacketPayload {

    public static final CustomPacketPayload.Type<ResurrectionMessageToServer> TYPE =
            new CustomPacketPayload.Type<>(fromNamespaceAndPath(ModInfo.ID, "altar_resurrection"));

    public static final StreamCodec<ByteBuf, ResurrectionMessageToServer> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, ResurrectionMessageToServer::playerId,
                    ByteBufCodecs.INT, ResurrectionMessageToServer::xPos,
                    ByteBufCodecs.INT, ResurrectionMessageToServer::yPos,
                    ByteBufCodecs.INT, ResurrectionMessageToServer::zPos,
                    ResurrectionMessageToServer::new);


    public static void handle(ResurrectionMessageToServer msg, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to handle ResurrectionMessageToServer message");
            }
            var pos = new BlockPos(msg.xPos, msg.yPos, msg.zPos);
            var player = context.player();
            var level = player.level();
            if (level.getBlockEntity(pos) instanceof AltarBlockEntity altar) {
                var inventory = altar.getCorpseInventory();
                if (!inventory.isEmpty()) {
                    var corpse = inventory.getCorpse();
                    if (corpse != null && !corpse.isEmpty() &&
                            corpse.getItem() instanceof Corpse &&
                            CorpseHelper.canSpawnMob(player, corpse)) {
                        if (!player.isCreative()) {
                            player.giveExperienceLevels(-CorpseHelper.getRequiredLevel(corpse));
                        }
                        CorpseHelper.spawnMob(corpse, level, pos, player);
                        inventory.setCorpse(ItemStack.EMPTY);
                        altar.setChanged();
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
