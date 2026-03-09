package nightkosh.gravestone_extended.core.event;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.GSEEnchantments;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEBlockEvents {

    @SubscribeEvent
    public static void onBlockBreakEvent(BlockEvent.BreakEvent event) {
        if (!event.getLevel().isClientSide() &&
                event.getPlayer() instanceof ServerPlayer player &&
                !player.isCreative() &&
                !player.isShiftKeyDown()) {
            var level = (Level) event.getLevel();

            var pos = event.getPos();
            var state = level.getBlockState(pos);

            if (state.is(BlockTags.LOGS) || state.is(BlockTags.LOGS_THAT_BURN) ||
                    state.is(Blocks.CRIMSON_STEM) ||
                    state.is(Blocks.WARPED_STEM) ||
                    state.is(Blocks.CRIMSON_HYPHAE) ||
                    state.is(Blocks.WARPED_HYPHAE)) {
                var tool = player.getMainHandItem();
                if (!tool.isEmpty() &&
                        tool.canPerformAction(ItemAbilities.AXE_STRIP) &&
                        state.canHarvestBlock(level, pos, player)) {
                    int enchantLevel = GSEEnchantmentHelper.getLevel(level, GSEEnchantments.CRIMSON_COPY, tool);
                    if (enchantLevel > 0) {
                        if (GSEConfigs.DEBUG_MODE.get()) {
                            LOGGER.info("BlockEvent.BreakEvent triggered. Going to cancel event and copy wood log block due to CRIMSON_COPY enchantment");
                        }

                        try {
                            var lootBuilder = new LootParams.Builder((ServerLevel) level)
                                    .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                                    .withParameter(LootContextParams.TOOL, tool)
                                    .withParameter(LootContextParams.BLOCK_STATE, state)
                                    .withParameter(LootContextParams.THIS_ENTITY, player)
                                    .withOptionalParameter(LootContextParams.BLOCK_ENTITY, level.getBlockEntity(pos));

                            for (var drop : state.getDrops(lootBuilder)) {
                                if (!drop.isEmpty()) {
                                    Block.popResource(level, player.blockPosition(), drop.copy());
                                }
                            }

                            float damage = switch (enchantLevel) {
                                case 3 -> 0.1F;
                                case 2 -> 0.5F;
                                default -> 1;
                            };

                            tool.hurtAndBreak(1, player, InteractionHand.MAIN_HAND);
                            player.hurtServer((ServerLevel) level, level.damageSources().magic(), damage);

                            event.setCanceled(true);
                        } catch (Exception e) {
                            LOGGER.error("Something goes wrong with CRIMSON_COPY enchantment", e);
                        }
                    }
                }
            }
        }
    }

}
