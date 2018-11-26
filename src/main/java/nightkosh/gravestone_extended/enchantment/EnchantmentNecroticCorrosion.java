package nightkosh.gravestone_extended.enchantment;

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
public class EnchantmentNecroticCorrosion extends EnchantmentTreasure {

    public EnchantmentNecroticCorrosion() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        this.setName("necrotic_corrosion");
        this.setRegistryName(ModInfo.ID, "gs_necrotic_corrosion");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 10 + 20 * (enchantmentLevel - 1);
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return super.canApply(stack) && stack.getItem() instanceof IBoneSword;
    }

    public static void applyEnchantmentEffect(EntityLivingBase target, float damage, short level) {
        float additionalDamage = damage * 0.1F * level;
        if (additionalDamage < 0.5) {
            additionalDamage = 0.5F;
        }
        float health = target.getHealth();
        if (health > additionalDamage + 0.5) {
            target.setHealth(health - additionalDamage);
        } else if (health > 0.5) {
            target.setHealth(0.5F);
        }
    }
}
