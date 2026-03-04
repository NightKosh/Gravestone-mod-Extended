package nightkosh.gravestone_extended.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import nightkosh.gravestone.helper.AdvancementsHelper;
import nightkosh.gravestone_extended.core.GSEAdvancements;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.TeleportationHelper;

import javax.annotation.Nonnull;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class FrozenMirror extends Item {

    private static final ResourceKey<Item> RK = ResourceKey.create(
            Registries.ITEM, fromNamespaceAndPath(ModInfo.ID, "frozen_mirror"));

    public FrozenMirror() {
        super(new Item.Properties()
                .stacksTo(1)
                .useCooldown(5)
                .rarity(Rarity.EPIC)
                .setId(RK));
    }

    @Nonnull
    @Override
    public InteractionResult use(Level level, @Nonnull Player player, @Nonnull InteractionHand hand) {
        if (!level.isClientSide() && level instanceof ServerLevel server) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to teleport player {} back to home by FrozenMirror", player.getScoreboardName());
            }
            TeleportationHelper.teleportToSpawn(server, player);
            AdvancementsHelper.giveAdvancement(player, level, GSEAdvancements.THROUGH_THE_LOOKING_GLASS);
        }
        return InteractionResult.SUCCESS;
    }

}
