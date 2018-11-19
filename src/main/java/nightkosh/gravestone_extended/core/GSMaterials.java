package nightkosh.gravestone_extended.core;

import net.minecraft.init.SoundEvents;
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


    public static void registration() {
        BONE_ARMOR = EnumHelper.addArmorMaterial("gs_bone_armor", "", 33, new int[]{3, 6, 8, 3}, ItemArmor.ArmorMaterial.GOLD.getEnchantability(),
                SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ItemArmor.ArmorMaterial.DIAMOND.getToughness());
    }
}
