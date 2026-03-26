package nightkosh.gravestone_extended.core;

import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.core.cauldron.CauldronInteractions;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LayeredCauldronBlock;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSECauldronInteractions {

    public static final CauldronInteraction.Dispatcher BLIGHTWATER =
            CauldronInteractions.newDispatcher("blightwater");

    public static void register() {
        CauldronInteractions.EMPTY.put(GSEItems.BLIGHTWATER_BUCKET.get(),
                (state, level, pos, player, hand, stack) -> {
                    if (!level.isClientSide()) {
                        player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(Items.BUCKET)));

                        level.setBlockAndUpdate(pos, GSEBlocks.BLIGHTWATER_CAULDRON.get().defaultBlockState()
                                .setValue(LayeredCauldronBlock.LEVEL, 3));
                    }

                    return InteractionResult.SUCCESS;
                });

        BLIGHTWATER.put(Items.BUCKET, (state, level, pos, player, hand, stack) -> {
            if (!level.isClientSide()) {
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(GSEItems.BLIGHTWATER_BUCKET.get())));

                level.setBlockAndUpdate(pos, Blocks.CAULDRON.defaultBlockState());
            }

            return InteractionResult.SUCCESS;
        });
    }

}
