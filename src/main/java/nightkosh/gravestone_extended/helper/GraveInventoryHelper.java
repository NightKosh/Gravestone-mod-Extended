package nightkosh.gravestone_extended.helper;

import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.helper.GraveGenerationHelper.EnumGraveTypeByEntity;

import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GraveInventoryHelper {

    public static enum GraveCorpseContentType {
        EMPTY,
        CORPSE,
        BONES_AND_FLESH,
        SKULL_BONES_AND_FLESH,
        RANDOM
    }

    public static GraveCorpseContentType getRandomCorpseContentType(EnumGraveMaterial graveMaterial, Random random) {
        switch (graveMaterial) {
            case DIAMOND:
            case EMERALD:
                return random.nextBoolean() ? GraveCorpseContentType.CORPSE : GraveCorpseContentType.SKULL_BONES_AND_FLESH;//50%
            case GOLD:
            case REDSTONE:
            case QUARTZ:
            case LAPIS:
                if (random.nextInt(10) < 5) {
                    return GraveCorpseContentType.BONES_AND_FLESH;//50%
                } else {
                    return random.nextBoolean() ? GraveCorpseContentType.CORPSE : GraveCorpseContentType.SKULL_BONES_AND_FLESH;//25%
                }
            case IRON:
                if (random.nextInt(10) < 7) {
                    return GraveCorpseContentType.BONES_AND_FLESH;//70%
                } else {
                    return random.nextBoolean() ? GraveCorpseContentType.CORPSE : GraveCorpseContentType.SKULL_BONES_AND_FLESH;//15%
                }
            default:
            case OTHER:
                if (random.nextInt(10) < 8) {
                    return GraveCorpseContentType.BONES_AND_FLESH;//80%
                } else {
                    return random.nextBoolean() ? GraveCorpseContentType.CORPSE : GraveCorpseContentType.SKULL_BONES_AND_FLESH;//10%
                }
        }
    }

    public static enum GraveContentType {
        JUNK,
        WORKER,
        MINER,
        WIZARD,
        WARRIOR,
        ADVENTURER,
        TREASURY,
        RANDOM,
        OTHER
    }

    public static GraveContentType getRandomContentType(EnumGraveTypeByEntity graveTypeByEntity, Random random) {
        switch (graveTypeByEntity) {
            case PLAYER_GRAVES:
            case VILLAGERS_GRAVES:
                int chance = random.nextInt(100);
                if (chance < 35) {
                    return GraveContentType.JUNK;//35%
                } else if (chance < 55) {
                    return GraveContentType.WORKER;//20%
                } else if (chance < 70) {
                    return GraveContentType.MINER;//15%
                } else if (chance < 85) {
                    return GraveContentType.WIZARD;//15%
                } else if (chance < 95) {
                    return GraveContentType.ADVENTURER;//10%
                } else {
                    return GraveContentType.WARRIOR;//5%
                }
            case DOGS_GRAVES:
            case CATS_GRAVES:
            case HORSE_GRAVES:
            default:
                return GraveContentType.OTHER;
        }
    }

    public static EnumGraveMaterial getContentMaterial(EnumGraveTypeByEntity graveTypeByEntity, GraveContentType contentType, Random random) {
        switch (graveTypeByEntity) {
            case DOGS_GRAVES:
            case CATS_GRAVES:
                return getPetContentType(random);
            case HORSE_GRAVES:
                return getHorseContentType(random);
            default:
                switch (contentType) {
                    case WORKER:
                        return getWorkerContentType(random);
                    case MINER:
                        return getMinerContentType(random);
                    case WIZARD:
                        return getWizardContentType(random);
                    case WARRIOR:
                        return getWarriorContentType(random);
                    case ADVENTURER:
                        return getAdventureContentType(random);
                    case TREASURY:
                        return getTreasuryContentType(random);
                    default:
                        return EnumGraveMaterial.OTHER;
                }
        }
    }

    private static EnumGraveMaterial getWarriorContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 5) {
            return EnumGraveMaterial.DIAMOND;//5%
        } else if (chance < 20) {
            return EnumGraveMaterial.GOLD;//15%
        } else if (chance < 65) {
            return EnumGraveMaterial.IRON;//45%
        } else {
            return EnumGraveMaterial.OTHER;//35% LEATHER
        }
    }

    private static EnumGraveMaterial getMinerContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 10) {
            return EnumGraveMaterial.DIAMOND;//10%
        } else if (chance < 30) {
            return EnumGraveMaterial.GOLD;//20%
        } else if (chance < 60) {
            return EnumGraveMaterial.IRON;//30%
        } else {
            return EnumGraveMaterial.OTHER;//40%
        }
    }

    private static EnumGraveMaterial getWizardContentType(Random random) {
        int chance = random.nextInt(10);
        if (chance < 1) {
            return EnumGraveMaterial.REDSTONE;//10%
        } else if (chance < 2) {
            return EnumGraveMaterial.QUARTZ;//10%
        } else if (chance < 4) {
            return EnumGraveMaterial.LAPIS;//20%
        } else {
            return EnumGraveMaterial.OTHER;//60%
        }
    }


    private static EnumGraveMaterial getWorkerContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 10) {
            return EnumGraveMaterial.DIAMOND;//10%
        } else if (chance < 30) {
            return EnumGraveMaterial.GOLD;//20%
        } else if (chance < 60) {
            return EnumGraveMaterial.IRON;//30%
        } else {
            return EnumGraveMaterial.OTHER;//40%
        }
    }

    private static EnumGraveMaterial getAdventureContentType(Random random) {
        if (random.nextInt(10) <= 2) {
            return EnumGraveMaterial.EMERALD;//20%
        } else {
            return EnumGraveMaterial.OTHER;//80%
        }
    }

    private static EnumGraveMaterial getTreasuryContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 10) {
            return EnumGraveMaterial.EMERALD;//10%
        } else if (chance < 30) {
            return EnumGraveMaterial.DIAMOND;//20%
        } else if (chance < 60) {
            return EnumGraveMaterial.GOLD;//30%
        } else if (chance < 90) {
            return EnumGraveMaterial.IRON;//30%
        } else {
            return EnumGraveMaterial.OTHER;//10%
        }
    }

    private static EnumGraveMaterial getPetContentType(Random random) {
        int chance = random.nextInt(10);
        if (chance == 0) {
            return EnumGraveMaterial.GOLD;//10%
        } else if (chance == 1) {
            return EnumGraveMaterial.DIAMOND;//10%
        } else {
            return EnumGraveMaterial.OTHER;//80%
        }
    }

    private static EnumGraveMaterial getHorseContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 5) {
            return EnumGraveMaterial.DIAMOND;//5%
        } else if (chance < 12) {
            return EnumGraveMaterial.GOLD;//7%
        } else if (chance < 25) {
            return EnumGraveMaterial.IRON;//13%
        } else {
            return EnumGraveMaterial.OTHER;//75%
        }
    }
}
