package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;
import nightkosh.gravestone_extended.item.weapon.IBoneShiled;
import nightkosh.gravestone_extended.item.weapon.ItemBoneShield;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentPainMirror extends EnchantmentTreasure {

    public EnchantmentPainMirror() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.ALL, HAND_SLOTS);
        this.setName("pain_mirror");
        this.setRegistryName(ModInfo.ID, "gs_pain_mirror");
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return 5 + (enchantmentLevel - 1) * 8;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return this.canApply(stack);
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return stack.getItem() instanceof IBoneShiled || stack.getItem() instanceof ItemBook;
    }

    public static void applyEffect(EntityPlayer player, Entity attacker, float amount) {
        ItemStack stack = player.getActiveItemStack();
        if (!stack.isEmpty() && stack.getItem() instanceof IBoneShiled) {

            int level = GSEnchantmentHelper.getEnchantmentLevel(stack, GSEnchantment.PAIN_MIRROR);
            if (level > 0) {
                if (player.world.rand.nextInt(100) <= 10 * level) {
                    if (attacker instanceof EntityLivingBase) {
                        attacker.attackEntityFrom(DamageSource.MAGIC, amount);
                    }
                }
            }

            if (amount >= 3) {
                ((ItemBoneShield) stack.getItem()).damageShield(stack, player, amount);
            }
        }
    }
}
