package nightkosh.gravestone_extended.item.corpse;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.entity.monster.pet.EnumUndeadMobType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ZombieCorpseHelper extends CorpseHelper {

    private static List<ItemStack> DEFAULT_CORPSE_LIST;

    public static ItemStack getRandomCorpse(Random random) {
        List<ItemStack> corpses = getDefaultCorpses();
        return corpses.get(random.nextInt(corpses.size() - 1));
    }

    public static ItemStack getDefaultCorpse() {
        return createCorpse(EnumUndeadMobType.ZOMBIE);
    }

    public static List<ItemStack> getDefaultCorpses() {
        if (DEFAULT_CORPSE_LIST == null) {
            DEFAULT_CORPSE_LIST = new ArrayList<>();
            DEFAULT_CORPSE_LIST.add(createCorpse(EnumUndeadMobType.ZOMBIE));
            DEFAULT_CORPSE_LIST.add(createCorpse(EnumUndeadMobType.HUSK));
            DEFAULT_CORPSE_LIST.add(createCorpse(EnumUndeadMobType.PIGMAN));
        }
        return DEFAULT_CORPSE_LIST;
    }

    private static ItemStack createCorpse(EnumUndeadMobType mobType) {
        ItemStack corpse = new ItemStack(GSBlock.CORPSE, 1, EnumCorpse.ZOMBIE.ordinal());
        NBTTagCompound nbtTag = new NBTTagCompound();
        nbtTag.setByte("MobType", (byte) mobType.ordinal());
        corpse.setTagCompound(nbtTag);

        return corpse;
    }
}
