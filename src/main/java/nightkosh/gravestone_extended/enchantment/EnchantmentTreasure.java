package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class EnchantmentTreasure extends EnchantmentBase {

    protected EnchantmentTreasure(Rarity rarity, EnumEnchantmentType type, EntityEquipmentSlot[] slots) {
        super(rarity, type, slots);
    }

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
}
