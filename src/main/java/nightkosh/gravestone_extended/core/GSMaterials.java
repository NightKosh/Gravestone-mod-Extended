package nightkosh.gravestone_extended.core;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSMaterials {

    public static ItemArmor.ArmorMaterial BONE_ARMOR;
    public static Item.ToolMaterial BONE_TOOL;


    public static void registration() {
        BONE_ARMOR = EnumHelper.addArmorMaterial("gs_bone", "", 40, new int[]{4, 7, 9, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 3);
        BONE_TOOL = EnumHelper.addToolMaterial("gs_bone", 3, 1800, 12, 4, 25);
    }
}
