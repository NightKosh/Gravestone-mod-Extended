package nightkosh.gravestone_extended.core.compatibility.forestry;

import forestry.api.storage.IBackpackDefinition;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSItem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class UndertakerBackpack implements IBackpackDefinition {

    protected static final List allowedBlocks = Arrays.asList(
            GSBlock.GRAVE_STONE,
            GSBlock.MEMORIAL,
            GSBlock.CORPSE,
            GSBlock.CANDLE,
            GSBlock.SKULL_CANDLE_SKELETON
    );
    protected static final List<Item> allowedItems = Arrays.asList(
            GSItem.CHISEL,
            Items.SKULL
    );

    @Override
    public String getName(ItemStack backpack) {
        return ModGravestoneExtended.proxy.getLocalizedString(backpack.getItem().getUnlocalizedName());
    }

    @Override
    public int getPrimaryColour() {
        return 1842478;
    }

    @Override
    public int getSecondaryColour() {
        return 3552587;
    }

    @Override
    public Predicate<ItemStack> getFilter() {
        return stack -> allowedBlocks.contains(Block.getBlockFromItem(stack.getItem())) || allowedItems.contains(stack.getItem());
    }
}