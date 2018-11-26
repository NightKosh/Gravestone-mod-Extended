package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.item.weapon.IBoneSword;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentVampiricTouch extends EnchantmentTreasure {

    public EnchantmentVampiricTouch() {
        super(Enchantment.Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        this.setName("vampiric_touch");
        this.setRegistryName(ModInfo.ID, "gs_vampiric_touch");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 15;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return super.canApply(stack) && stack.getItem() instanceof IBoneSword;
    }

    public static void applyEnchantmentEffect(EntityLivingBase attacker, float damage) {
        float healed = damage * 0.2F;
        if (healed < 0.5) {
            healed = 0.5F;
        }
        attacker.heal(healed);
    }
}
