package nightkosh.gravestone_extended.item.itemblock.skull_candle;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.block.enums.EnumSkullCandle;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class IBSkullCandleWither extends ItemBlock {

    public IBSkullCandleWither(Block block) {
        super(block);
        this.setHasSubtypes(true);
        this.setRegistryName(GSBlock.SKULL_CANDLE_WITHER.getRegistryName());
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return EnumSkullCandle.WITHER_SKULL.getUnLocalizedName();
    }
}
