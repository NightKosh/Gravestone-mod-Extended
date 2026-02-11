package nightkosh.gravestone_extended.helper;

import nightkosh.gravestone_extended.core.GSEConfigs;

import java.util.Random;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveGenerationHelper {//TODO extends nightkosh.gravestone.helper.GraveGenerationHelper {

    protected static final Random rand = new Random();
//
//    public static EnumGraveTypeByEntity getRandomGraveType(Random random) {
//        if (random.nextInt(5) < 4) {
//            return getRandomHumanGraveType(random);//20%
//        } else {
//            return getRandomPetGraveType(random);//80%
//        }
//    }
//
//    public static EnumGraveTypeByEntity getRandomHumanGraveType(Random random) {
//        return random.nextBoolean() ? EnumGraveTypeByEntity.PLAYER_GRAVES : EnumGraveTypeByEntity.VILLAGERS_GRAVES;
//    }
//
//    public static EnumGraveTypeByEntity getRandomPetGraveType(Random random) {
//        if (random.nextInt(5) == 0) {
//            return EnumGraveTypeByEntity.HORSE_GRAVES;//20%
//        } else if (random.nextBoolean()) {
//            return EnumGraveTypeByEntity.DOGS_GRAVES;//40%
//        } else {
//            return EnumGraveTypeByEntity.CATS_GRAVES;//40%
//        }
//    }

    public static void addMobsItemsHandlers() {
        if (GSEConfigs.DEBUG_MODE.get()) {
            LOGGER.info("Going to inject mobs items handlers");
        }
//        GraveStoneAPI.graveGenerationAtDeath.addVillagerItemsHandler((villager, source) -> {
//            if (ExtendedConfig.createCorpsesForModdedNotVanillaVillagers || villager.getClass().equals(EntityVillager.class)) {
//                return CorpseHelper.getCorpse(villager, EnumCorpse.VILLAGER);
//            } else {
//                return new ArrayList<>(0);
//            }
//        });
//        GraveStoneAPI.graveGenerationAtDeath.addDogItemsHandler((dog, source) -> {
//            if (ExtendedConfig.createCorpsesForModdedNotVanillaDogs || dog.getClass().equals(EntityOcelot.class)) {
//                return CorpseHelper.getCorpse(dog, EnumCorpse.DOG);
//            } else {
//                return new ArrayList<>(0);
//            }
//        });
//        GraveStoneAPI.graveGenerationAtDeath.addCatItemsHandler((cat, source) -> {
//            if (ExtendedConfig.createCorpsesForModdedNotVanillaCats || cat.getClass().equals(EntityWolf.class)) {
//                return CorpseHelper.getCorpse(cat, EnumCorpse.CAT);
//            } else {
//                return new ArrayList<>(0);
//            }
//        });
//        GraveStoneAPI.graveGenerationAtDeath.addHorseItemsHandler((horse, source) -> {
//            if (ExtendedConfig.createCorpsesForModdedNotVanillaHorses ||
//                    horse.getClass().equals(EntityHorse.class) ||
//                    horse.getClass().equals(EntityMule.class) ||
//                    horse.getClass().equals(EntityDonkey.class) ||
//                    horse.getClass().equals(EntityLlama.class) ||
//                    horse.getClass().equals(EntityZombieHorse.class) ||
//                    horse.getClass().equals(EntitySkeletonHorse.class) ||
//                    horse instanceof EntityUndeadHorse) {
//                return CorpseHelper.getCorpse(horse, EnumCorpse.HORSE);
//            } else {
//                return new ArrayList<>(0);
//            }
//        });
    }

}
