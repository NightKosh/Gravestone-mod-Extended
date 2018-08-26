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

    public static ItemStack getDefaultCorpse() {
        return createCorpse(0, 1);
    }

    public static List<ItemStack> getDefaultCorpses() {
        List<ItemStack> list = new ArrayList<>();

        list.add(createCorpse(0, 1)); // Farmer - farmer
        list.add(createCorpse(0, 2)); // Farmer - fisherman
        list.add(createCorpse(0, 3)); // Farmer - shepherd
        list.add(createCorpse(0, 4)); // Farmer - fletcher
        list.add(createCorpse(1, 1)); // Librarian - librarian
        list.add(createCorpse(1, 2)); // Librarian - cartographer
        list.add(createCorpse(2, 1)); // Priest - cleric
        list.add(createCorpse(3, 1)); // Smith - armor
        list.add(createCorpse(3, 2)); // Smith - weapon
        list.add(createCorpse(3, 3)); // Smith - tool
        list.add(createCorpse(4, 1)); // Butcher - butcher
        list.add(createCorpse(4, 2)); // Butcher - leather
        list.add(createCorpse(5, 1)); // Nitwit - nitwit

        List<VillagerRegistry.VillagerProfession> villagers = ForgeRegistries.VILLAGER_PROFESSIONS.getValues();
        for (VillagerRegistry.VillagerProfession villagerProfession : villagers) {
            List<VillagerRegistry.VillagerCareer> careersList = ReflectionHelper.getPrivateValue(VillagerRegistry.VillagerProfession.class, villagerProfession, "careers");
            if (!careersList.isEmpty()) {
                list.add(createCorpse(VillagerRegistry.getId(villagerProfession), villagerProfession.getRandomCareer(RANDOM)));
            }
        }

        return list;
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
