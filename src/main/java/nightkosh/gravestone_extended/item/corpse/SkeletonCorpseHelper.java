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
public class SkeletonCorpseHelper extends CorpseHelper {

    private static List<ItemStack> DEFAULT_CORPSE_LIST;

    public static ItemStack getRandomCorpse(Random random) {
        List<ItemStack> corpses = getDefaultCorpses();
        return corpses.get(random.nextInt(corpses.size() - 1));
    }

    public static List<ItemStack> getDefaultCorpses() {
        if (DEFAULT_CORPSE_LIST == null) {
            DEFAULT_CORPSE_LIST = new ArrayList<>();
            DEFAULT_CORPSE_LIST.add(createCorpse(EnumUndeadMobType.SKELETON));
            DEFAULT_CORPSE_LIST.add(createCorpse(EnumUndeadMobType.STRAY));
            DEFAULT_CORPSE_LIST.add(createCorpse(EnumUndeadMobType.WITHER));
        }
        return DEFAULT_CORPSE_LIST;
    }

    private static ItemStack createCorpse(EnumUndeadMobType mobType) {
        ItemStack corpse = new ItemStack(GSBlock.CORPSE, 1, EnumCorpse.SKELETON.ordinal());
        NBTTagCompound nbtTag = new NBTTagCompound();
        nbtTag.setByte("MobType", (byte) mobType.ordinal());
        corpse.setTagCompound(nbtTag);

        return corpse;
    }
}
