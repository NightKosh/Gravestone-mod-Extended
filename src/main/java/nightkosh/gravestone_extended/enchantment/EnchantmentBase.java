package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class EnchantmentBase extends Enchantment {
    protected static final EntityEquipmentSlot[] HAND_SLOTS = {
            EntityEquipmentSlot.MAINHAND,
            EntityEquipmentSlot.OFFHAND
    };

    protected EnchantmentBase(Rarity rarity, EnumEnchantmentType type, EntityEquipmentSlot[] slots) {
        super(rarity, type, slots);
    }
}
