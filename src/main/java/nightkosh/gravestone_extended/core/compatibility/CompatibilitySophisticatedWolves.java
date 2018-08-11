package nightkosh.gravestone_extended.core.compatibility;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import sophisticated_wolves.api.EnumWolfSpecies;
import sophisticated_wolves.api.ISophisticatedWolf;
import sophisticated_wolves.api.SophisticatedWolvesAPI;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CompatibilitySophisticatedWolves {

    private CompatibilitySophisticatedWolves() {
    }

    public static String NBT_FLAG = "Sophisticated";

    public static String NBT_NAME = "Species";

    public static boolean isSophisticated(EntityWolf dog) {
        return dog instanceof ISophisticatedWolf;
    }

    public static boolean isSophisticated(NBTTagCompound nbtTag) {
        return nbtTag.hasKey(NBT_FLAG);
    }

    public static int getSpeciesNum() {
        return EnumWolfSpecies.values().length;
    }

    public static int getSpecies(EntityWolf dog) {
        return ((ISophisticatedWolf) dog).getSpecies().ordinal();
    }

    public static int getRandomSpecies(Random random) {
        return random.nextInt(EnumWolfSpecies.values().length);
    }

    public static EntityWolf getWolf(World world, NBTTagCompound nbtTag) {
        EntityWolf wolf = SophisticatedWolvesAPI.entityHandler.getNewSophisticatedWolf(world);
        ((ISophisticatedWolf) wolf).updateSpecies(EnumWolfSpecies.getSpeciesByNum(nbtTag.getInteger(NBT_NAME)));
        return wolf;
    }

    public static String getSpeciesStr(int speciesNum) {
        return ModGravestoneExtended.proxy.getLocalizedString("item.corpse.dog_type") + " " + EnumWolfSpecies.getSpeciesName(EnumWolfSpecies.getSpeciesByNum(speciesNum));
    }
}
