package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.item.tools.hoe.IBoneHoe;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentBoneRain extends EnchantmentTreasure {
    public EnchantmentBoneRain() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.ALL, new EntityEquipmentSlot[]{EntityEquipmentSlot.MAINHAND});
        this.setName("bone_rain");
        this.setRegistryName(ModInfo.ID, "gs_bone_rain");
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
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return this.canApply(stack);
    }

    @Override
    public boolean canApply(ItemStack stack) {
        return stack.getItem() instanceof IBoneHoe || stack.getItem() instanceof ItemBook;
    }
}
