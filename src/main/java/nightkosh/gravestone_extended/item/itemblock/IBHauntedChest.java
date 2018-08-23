/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nightkosh.gravestone_extended.item.itemblock;

import nightkosh.gravestone_extended.block.enums.EnumHauntedChest;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.core.GSBlock;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class IBHauntedChest extends ItemBlock {

    public IBHauntedChest(Block block) {
        super(block);
        this.setHasSubtypes(true);
        this.setRegistryName(GSBlock.HAUNTED_CHEST.getRegistryName());
    }

    @Override
    public int getMetadata(int damageValue) {
        return 0;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        int id = 0;
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("ChestType")) {
            id = itemStack.getTagCompound().getInteger("ChestType");
        }
        return EnumHauntedChest.getById(id).getUnLocalizedName();
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (stack.getTagCompound() == null) {
            stack.setTagCompound(new NBTTagCompound());
        }
    }
}
