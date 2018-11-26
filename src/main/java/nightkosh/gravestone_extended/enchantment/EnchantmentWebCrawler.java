package nightkosh.gravestone_extended.enchantment;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;
import nightkosh.gravestone_extended.item.armor.bone.ItemBoneLeggings;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentWebCrawler extends EnchantmentTreasure {

    public EnchantmentWebCrawler() {
        super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_LEGS, new EntityEquipmentSlot[] {EntityEquipmentSlot.LEGS});
        this.setName("web_crawler");
        this.setRegistryName(ModInfo.ID, "web_crawler");
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
        return super.canApply(stack) && stack.getItem() instanceof ItemBoneLeggings;
    }

    public static void applyEffect(EntityPlayer player) {
        if (player.isInWeb) {
            if (GSEnchantmentHelper.getEnchantmentLevel(player.getItemStackFromSlot(EntityEquipmentSlot.LEGS), GSEnchantment.WEB_CRAWLER) > 0) {
                player.isInWeb = false;
            }
        }
    }
}
