package nightkosh.gravestone_extended.item.itemblock;

import nightkosh.gravestone_extended.block.enums.EnumPileOfBones;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemBlockGSPileOfBones extends ItemBlock {

    public ItemBlockGSPileOfBones(Block block) {
        super(block);
        this.setRegistryName(GSBlock.PILE_OF_BONES.getRegistryName());
    }

    @Override
    public int getMetadata(int damageValue) {
        return damageValue;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return EnumPileOfBones.values()[itemStack.getItemDamage() / 4].getUnLocalizedName();
    }
}
