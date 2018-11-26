package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.item.tools.IBoneFishingPole;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentHellishAngling extends EnchantmentTreasure {

    public EnchantmentHellishAngling() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.FISHING_ROD, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        this.setName("hellish_angling");
        this.setRegistryName(ModInfo.ID, "gs_hellish_angling");
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
        return super.canApply(stack) && stack.getItem() instanceof IBoneFishingPole;
    }
}
