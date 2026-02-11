package nightkosh.gravestone_extended.helper;

import net.minecraft.world.entity.animal.equine.Horse;
import nightkosh.gravestone.api.GraveStoneAPI;
import nightkosh.gravestone_extended.core.GSEConfigs;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveGenerationHelper extends nightkosh.gravestone.helper.GraveGenerationHelper {

    protected static final Random rand = new Random();
//TODO
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
        GraveStoneAPI.graveGenerationAtDeath.addVillagerItemsHandler((villager, source) -> {
            if (GSEConfigs.CREATE_VILLAGERS_CORPSES.get()) {
                return List.of(CorpseHelper.addVillagerCorpse(villager));
            } else {
                return Collections.EMPTY_LIST;
            }
        });
        GraveStoneAPI.graveGenerationAtDeath.addDogItemsHandler((dog, source) -> {
            if (GSEConfigs.CREATE_DOGS_CORPSES.get()) {
                return List.of(CorpseHelper.addDogCorpse(dog));
            } else {
                return Collections.EMPTY_LIST;
            }
        });
        GraveStoneAPI.graveGenerationAtDeath.addCatItemsHandler((cat, source) -> {
            if (GSEConfigs.CREATE_CATS_CORPSES.get()) {
                return List.of(CorpseHelper.getCatCorpse(cat));
            } else {
                return Collections.EMPTY_LIST;
            }
        });
        GraveStoneAPI.graveGenerationAtDeath.addHorseItemsHandler((horse, source) -> {
            if (GSEConfigs.CREATE_HORSES_CORPSES.get() && horse instanceof Horse horse1) {
                return List.of(CorpseHelper.getHorseCorpse(horse1));
            } else {
                return Collections.EMPTY_LIST;
            }
        });
    }

}
