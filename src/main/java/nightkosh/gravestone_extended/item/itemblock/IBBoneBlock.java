/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nightkosh.gravestone_extended.item.itemblock;

import nightkosh.gravestone_extended.block.enums.EnumBoneBlock;
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
public class IBBoneBlock extends ItemBlock {

    public IBBoneBlock(Block block) {
        super(block);
        this.setHasSubtypes(true);
        this.setRegistryName(GSBlock.BONE_BLOCK.getRegistryName());
    }

    @Override
    public int getMetadata(int damageValue) {
        return damageValue;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return EnumBoneBlock.values()[itemstack.getItemDamage()].getUnLocalizedName();
    }
}
