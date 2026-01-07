package nightkosh.gravestone_extended.renderer.item;

import com.mojang.authlib.GameProfile;
import nightkosh.gravestone_extended.block.enums.EnumMemorials;
import nightkosh.gravestone_extended.helper.GameProfileHelper;
import nightkosh.gravestone_extended.renderer.tileentity.TileEntityMemorialRenderer;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TEISRMemorial {//TODOextends TileEntityItemStackRenderer {
//
//    @Override
//    public void renderByItem(ItemStack stack) {
//        EnumMemorials memorial = EnumMemorials.getById(stack.getItemDamage());
//        boolean isEnchanted = false;
//        boolean isMossy = false;
//        GameProfile profile = null;
//        if (stack.hasTagCompound()) {
//            NBTTagCompound nbt = stack.getTagCompound();
//            isEnchanted = nbt.hasKey("Enchanted") && nbt.getBoolean("Enchanted");
//            isMossy = nbt.hasKey("Mossy") && nbt.getBoolean("Mossy");
//
//            profile = memorial.getMemorialType() == EnumMemorials.EnumMemorialType.STEVE_STATUE ? GameProfileHelper.getProfile(nbt) : null;
//        }
//
//        TileEntityMemorialRenderer.instance.renderMemorialAsItem(memorial, memorial.getMemorialType(), isEnchanted, isMossy, profile);
//    }
}
