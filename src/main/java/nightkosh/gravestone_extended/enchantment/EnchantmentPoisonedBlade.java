package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentFireAspect;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentPoisonedBlade extends EnchantmentBase {

    public EnchantmentPoisonedBlade() {
        super(Enchantment.Rarity.RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});
        this.setName("poisoned_blade");
        this.setRegistryName(ModInfo.ID, this.getNameForRegistry());
    }

    public boolean canApplyTogether(Enchantment ench) {
        return !(ench instanceof EnchantmentFireAspect || ench instanceof EnchantmentPoisonedBlade || ench instanceof EnchantmentWitheredBlade);
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
        return super.canApply(stack);
    }

    @Override
    public void onEntityDamaged(EntityLivingBase user, Entity target, int level) {
        if (target instanceof EntityLivingBase) {
            ((EntityLivingBase) target).addPotionEffect(new PotionEffect(MobEffects.POISON, 200 * level));
        }
    }

    protected String getNameForRegistry() {
        return "gs_poisoned_blade";
    }
}
