package nightkosh.gravestone_extended.item.corpse;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
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
public class ZombieVillagerCorpseHelper extends CorpseHelper {
    private static final Random RANDOM = new Random();

    private static List<ItemStack> DEFAULT_CORPSE_LIST;

    public static ItemStack getRandomCorpse(Random random) {
        List<ItemStack> corpses = getDefaultCorpses();
        return corpses.get(random.nextInt(corpses.size()));
    }

    public static List<ItemStack> getDefaultCorpses() {
        if (DEFAULT_CORPSE_LIST == null) {
            DEFAULT_CORPSE_LIST = new ArrayList<>();

            DEFAULT_CORPSE_LIST.add(createCorpse(0, 1)); // Farmer - farmer
            DEFAULT_CORPSE_LIST.add(createCorpse(0, 2)); // Farmer - fisherman
            DEFAULT_CORPSE_LIST.add(createCorpse(0, 3)); // Farmer - shepherd
            DEFAULT_CORPSE_LIST.add(createCorpse(0, 4)); // Farmer - fletcher
            DEFAULT_CORPSE_LIST.add(createCorpse(1, 1)); // Librarian - librarian
            DEFAULT_CORPSE_LIST.add(createCorpse(1, 2)); // Librarian - cartographer
            DEFAULT_CORPSE_LIST.add(createCorpse(2, 1)); // Priest - cleric
            DEFAULT_CORPSE_LIST.add(createCorpse(3, 1)); // Smith - armor
            DEFAULT_CORPSE_LIST.add(createCorpse(3, 2)); // Smith - weapon
            DEFAULT_CORPSE_LIST.add(createCorpse(3, 3)); // Smith - tool
            DEFAULT_CORPSE_LIST.add(createCorpse(4, 1)); // Butcher - butcher
            DEFAULT_CORPSE_LIST.add(createCorpse(4, 2)); // Butcher - leather
            DEFAULT_CORPSE_LIST.add(createCorpse(5, 1)); // Nitwit - nitwit

            List<VillagerRegistry.VillagerProfession> villagers = ForgeRegistries.VILLAGER_PROFESSIONS.getValues();
            for (VillagerRegistry.VillagerProfession villagerProfession : villagers) {
                List<VillagerRegistry.VillagerCareer> careersList = ReflectionHelper.getPrivateValue(VillagerRegistry.VillagerProfession.class, villagerProfession, "careers");
                if (!careersList.isEmpty()) {
                    DEFAULT_CORPSE_LIST.add(createCorpse(VillagerRegistry.getId(villagerProfession), villagerProfession.getRandomCareer(RANDOM)));
                }
            }
        }
        return DEFAULT_CORPSE_LIST;
    }

    private static ItemStack createCorpse(int profession, int career) {
        ItemStack corpse = new ItemStack(GSBlock.CORPSE, 1, EnumCorpse.ZOMBIE_VILLAGER.ordinal());

        NBTTagCompound nbtTag = new NBTTagCompound();
        nbtTag.setInteger("Profession", profession);
        nbtTag.setInteger("Career", career);
        nbtTag.setByte("MobType", (byte) EnumUndeadMobType.ZOMBIE.ordinal());
        corpse.setTagCompound(nbtTag);

        return corpse;
    }

    public static int getProfession(NBTTagCompound nbtTag) {
        if (nbtTag == null) {
            return -1;
        } else {
            return nbtTag.getInteger("Profession");
        }
    }
}
