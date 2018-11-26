package nightkosh.gravestone_extended.helper;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.HashMap;
import java.util.Map;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEnchantmentHelper extends nightkosh.gravestone.helper.EnchantmentHelper {

    public static short getMaxEnchantmentLevel(ItemStack stack, Enchantment enchantment) {
        if (stack != null && stack != ItemStack.EMPTY) {
            NBTTagList nbtList = stack.getEnchantmentTagList();
            for (NBTBase nbt : nbtList) {
                if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(enchantment)) {
                    return ((NBTTagCompound) nbt).getShort("lvl");
                }
            }
        }
        return 0;
    }

    public static Map<Enchantment, Integer> getSkullEnchantments(ItemStack skull) {
        Map<Enchantment, Integer> map = new HashMap<>();
        if (skull.hasTagCompound()) {
            addEnchantmentsToMap(map, skull.getTagCompound(), "StoredEnchantments");
            addEnchantmentsToMap(map, skull.getTagCompound(), "ench");
        }

        return map;
    }

    private static void addEnchantmentsToMap(Map<Enchantment, Integer> map, NBTTagCompound nbt, String tagName) {
        NBTTagList list = nbt.getTagList(tagName, 10);
        for (int i = 0; i < list.tagCount(); i++) {
            NBTTagCompound enchantmentTag = list.getCompoundTagAt(i);
            map.put(Enchantment.getEnchantmentByID(enchantmentTag.getShort("id")), (int) enchantmentTag.getShort("lvl"));
        }
    }
}
