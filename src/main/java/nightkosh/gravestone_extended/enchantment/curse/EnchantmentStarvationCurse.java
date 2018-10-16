package nightkosh.gravestone_extended.enchantment.curse;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EnchantmentStarvationCurse extends EnchantmentCurse {
    private static final int HUNGER_POTION_ID = Potion.getIdFromPotion(MobEffects.HUNGER);

    public EnchantmentStarvationCurse() {
        this.setName("starvation_curse");
        this.setRegistryName(ModInfo.ID, "gs_starvation_curse");
    }

    public static void applyCurseEffect(EntityPlayer player) {
        Iterable<ItemStack> equipment = player.getEquipmentAndArmor();
        if (equipment != null) {
            int count = 0;
            for (ItemStack stack : equipment) {
                if (stack != null && stack != ItemStack.EMPTY) {
                    NBTTagList nbtList = stack.getEnchantmentTagList();
                    for (NBTBase nbt : nbtList) {
                        if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.CURSE_STARVATION)) {
                            count++;
                        }
                    }
                }
            }

            if (count > 0) {
                int duration = 0;
                int curseDuration = 200 * count;
                for (PotionEffect potion : player.getActivePotionEffects()) {
                    if (Potion.getIdFromPotion(potion.getPotion()) == HUNGER_POTION_ID) {
                        duration += potion.getDuration();
                    }
                }
                if (duration < curseDuration) {
                    player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, curseDuration + 100));
                }
            }
        }
    }
}
