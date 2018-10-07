package nightkosh.gravestone_extended.helper;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
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

    public static Map<Enchantment, Integer> getSkullEnchantments(ItemStack skull) {
        Map<Enchantment, Integer> map = new HashMap<>();
        if (skull.hasTagCompound()) {
            NBTTagList nbttaglist = skull.getTagCompound().getTagList("StoredEnchantments", 10);
            for (int i = 0; i < nbttaglist.tagCount(); i++) {
                NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
                map.put(Enchantment.getEnchantmentByID(nbttagcompound.getShort("id")), (int) nbttagcompound.getShort("lvl"));
            }
        }

        return map;
    }
}
