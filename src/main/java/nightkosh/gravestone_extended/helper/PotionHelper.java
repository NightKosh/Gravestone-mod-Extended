package nightkosh.gravestone_extended.helper;

import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PotionHelper {

    public static final PotionType[] CATACOMBS_DISPENSER_POTIONS = {
            PotionTypes.LONG_POISON, PotionTypes.STRONG_HARMING,
            PotionTypes.LONG_WEAKNESS, PotionTypes.LONG_SLOWNESS,
            PotionTypes.LONG_INVISIBILITY
    };

    public static ItemStack getCatacombsDispenserPotion(Random random) {
        return getSplashOrLingeringPotion(random, CATACOMBS_DISPENSER_POTIONS[random.nextInt(CATACOMBS_DISPENSER_POTIONS.length)], 1 + random.nextInt(5));
    }

    public static ItemStack getSplashOrLingeringPotion(Random random, PotionType potionType, int count) {
        return random.nextBoolean() ? getSplashPotion(potionType, count) : getLingeringPotion(potionType, count);
    }

    public static ItemStack getSplashPotion(PotionType potionType, int count) {
        return getPotion(Items.SPLASH_POTION, potionType, count);
    }

    public static ItemStack getLingeringPotion(PotionType potionType, int count) {
        return getPotion(Items.LINGERING_POTION, potionType, count);
    }

    private static ItemStack getPotion(Item item, PotionType potionType, int count) {
        ItemStack potion = new ItemStack(item, count);
        return PotionUtils.addPotionToItemStack(potion, potionType);
    }
}
