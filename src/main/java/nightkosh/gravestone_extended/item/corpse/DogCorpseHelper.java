package nightkosh.gravestone_extended.item.corpse;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.compatibility.Compatibility;
import nightkosh.gravestone_extended.core.compatibility.CompatibilitySophisticatedWolves;
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
public class DogCorpseHelper extends CorpseHelper {

    private static List<ItemStack> DEFAULT_CORPSE_LIST;

    public static ItemStack getRandomCorpse(Random random) {
        List<ItemStack> corpses = getDefaultCorpses();
        return corpses.get(random.nextInt(corpses.size()));
    }

    public static List<ItemStack> getDefaultCorpses() {
        if (DEFAULT_CORPSE_LIST == null) {
            DEFAULT_CORPSE_LIST = new ArrayList<>();

            DEFAULT_CORPSE_LIST.add(createCorpse(false, EnumUndeadMobType.OTHER, 0));

            if (Compatibility.sophisticatedWolvesInstalled) {
                for (int speciesNum = 0; speciesNum < CompatibilitySophisticatedWolves.getSpeciesNum(); speciesNum++) {
                    DEFAULT_CORPSE_LIST.add(createCorpse(true, EnumUndeadMobType.OTHER, speciesNum));
                }
            }

            DEFAULT_CORPSE_LIST.add(createCorpse(false, EnumUndeadMobType.ZOMBIE, 0));
            DEFAULT_CORPSE_LIST.add(createCorpse(false, EnumUndeadMobType.HUSK, 0));
            DEFAULT_CORPSE_LIST.add(createCorpse(false, EnumUndeadMobType.SKELETON, 0));
//          DEFAULT_CORPSE_LIST.add(createCorpse(false, EnumUndeadMobType.STRAY, 0)); //TODO
//          DEFAULT_CORPSE_LIST.add(createCorpse(false, EnumUndeadMobType.WITHER, 0));
        }
        return DEFAULT_CORPSE_LIST;
    }

    private static ItemStack createCorpse(boolean sophisticated, EnumUndeadMobType mobType, int speciesNum) {
        ItemStack corpse = new ItemStack(GSBlock.CORPSE, 1, EnumCorpse.DOG.ordinal());
        NBTTagCompound nbtTag = new NBTTagCompound();

        nbtTag.setByte("MobType", (byte) mobType.ordinal());
        nbtTag.setByte("Collar", (byte) EnumDyeColor.RED.ordinal());

        if (sophisticated) {
            nbtTag.setBoolean(CompatibilitySophisticatedWolves.NBT_FLAG, true);
            nbtTag.setInteger(CompatibilitySophisticatedWolves.NBT_NAME, speciesNum);
        }

        corpse.setTagCompound(nbtTag);

        return corpse;
    }

    public static void setNbt(EntityWolf dog, NBTTagCompound nbt) {
        setName(dog, nbt);
        nbt.setByte("MobType", (byte) EnumUndeadMobType.OTHER.ordinal());
        nbt.setByte("Collar", (byte) dog.getCollarColor().getMetadata());

        if (Compatibility.sophisticatedWolvesInstalled && CompatibilitySophisticatedWolves.isSophisticated(dog)) {
            nbt.setBoolean(CompatibilitySophisticatedWolves.NBT_FLAG, true);
            nbt.setInteger(CompatibilitySophisticatedWolves.NBT_NAME, CompatibilitySophisticatedWolves.getSpecies(dog));
        }
    }

    public static void spawnDog(World world, int x, int y, int z, NBTTagCompound nbtTag, EntityPlayer player) {
        EntityWolf wolf;
        if (Compatibility.sophisticatedWolvesInstalled && CompatibilitySophisticatedWolves.isSophisticated(nbtTag)) {
            wolf = CompatibilitySophisticatedWolves.getWolf(world, nbtTag);
        } else {
            wolf = new EntityWolf(world);
        }
        setMobName(wolf, nbtTag);
        wolf.setTamed(true);
        wolf.setHealth(20);
        wolf.setOwnerId(player.getUniqueID());
        wolf.setCollarColor(EnumDyeColor.byMetadata(nbtTag.getByte("Collar")));
        world.setEntityState(wolf, (byte) 7);
        spawnMob(wolf, world, x, y, z);
    }

    public static void addInfo(List list, NBTTagCompound nbtTag) {
        addNameInfo(list, nbtTag);
        if (hasCollar(nbtTag)) {
            list.add(getCollarStr(nbtTag));
        }
        if (Compatibility.sophisticatedWolvesInstalled && CompatibilitySophisticatedWolves.isSophisticated(nbtTag)) {
            list.add(CompatibilitySophisticatedWolves.getSpeciesStr(nbtTag.getInteger(CompatibilitySophisticatedWolves.NBT_NAME)));
        }
        addMobTypeInfo(list, nbtTag);
    }

    private static boolean hasCollar(NBTTagCompound nbtTag) {
        return nbtTag.hasKey("Collar");
    }

    private static String getCollarStr(NBTTagCompound nbtTag) {
        return ModGravestoneExtended.proxy.getLocalizedString("item.corpse.collar") + " " +
                ModGravestoneExtended.proxy.getLocalizedString(getCollar(nbtTag.getByte("Collar")));
    }

    private static String getCollar(int type) {
        switch (type) {
            case 0:
                return "item.corpse.collar.white";
            case 1:
                return "item.corpse.collar.orange";
            case 2:
                return "item.corpse.collar.purple";
            case 3:
                return "item.corpse.collar.azure";
            case 4:
                return "item.corpse.collar.yellow";
            case 5:
                return "item.corpse.collar.lime";
            case 6:
                return "item.corpse.collar.pink";
            case 7:
                return "item.corpse.collar.grey";
            case 8:
                return "item.corpse.collar.light_grey";
            case 9:
                return "item.corpse.collar.turquoise";//бирюзовый
            case 10:
                return "item.corpse.collar.violet";
            case 11:
                return "item.corpse.collar.blue";
            case 12:
                return "item.corpse.collar.brown";
            case 13:
                return "item.corpse.collar.green";
            case 14:
                return "item.corpse.collar.red";
            case 15:
                return "item.corpse.collar.black";
            default:
                return "item.corpse.collar.unknown";
        }
    }
}
