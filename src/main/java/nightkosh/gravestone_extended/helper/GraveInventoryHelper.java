package nightkosh.gravestone_extended.helper;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nightkosh.gravestone.helper.GraveGenerationHelper.EnumGraveTypeByEntity;
import nightkosh.gravestone_extended.core.GSLootTables;
import nightkosh.gravestone_extended.item.corpse.CatCorpseHelper;
import nightkosh.gravestone_extended.item.corpse.DogCorpseHelper;
import nightkosh.gravestone_extended.item.corpse.HorseCorpseHelper;
import nightkosh.gravestone_extended.item.corpse.VillagerCorpseHelper;

import java.util.ArrayList;
import java.util.List;
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

    private static GraveCorpseContentType getRandomCorpseContentType(ContentMaterials contentMaterials, Random random) {
        switch (contentMaterials) {
            case DIAMOND:
            case EMERALD:
                return random.nextBoolean() ? GraveCorpseContentType.CORPSE : GraveCorpseContentType.SKULL_BONES_AND_FLESH;//50%
            case GOLDEN:
            case REDSTONE:
            case QUARTZ:
            case LAPIS:
                if (random.nextInt(10) < 5) {
                    return GraveCorpseContentType.BONES_AND_FLESH;//50%
                } else {
                    return random.nextBoolean() ? GraveCorpseContentType.CORPSE : GraveCorpseContentType.SKULL_BONES_AND_FLESH;//25%
                }
            case IRON:
            case CHAINMAIL:
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
        DOG,
        CAT,
        HORSE,
        OTHER
    }

    public static enum ContentMaterials {
        OTHER,
        IRON,
        GOLDEN,
        DIAMOND,
        EMERALD,
        REDSTONE,
        QUARTZ,
        LAPIS,
        CHAINMAIL
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
                return GraveContentType.DOG;
            case CATS_GRAVES:
                return GraveContentType.CAT;
            case HORSE_GRAVES:
                return GraveContentType.HORSE;
            default:
                return GraveContentType.OTHER;
        }
    }

    public static ContentMaterials getContentMaterial(GraveContentType contentType, Random random) {
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
            case DOG:
            case CAT:
                return getPetContentType(random);
            case HORSE:
                return getHorseContentType(random);
            case JUNK:
            case OTHER:
                return ContentMaterials.OTHER;
        }
    }

    private static ContentMaterials getWarriorContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 5) {
            return ContentMaterials.DIAMOND;//5%
        } else if (chance < 20) {
            return ContentMaterials.GOLDEN;//15%
        } else if (chance < 40) {
            return ContentMaterials.CHAINMAIL;//20% CHAINMAIL
        } else if (chance < 65) {
            return ContentMaterials.IRON;//25%
        } else {
            return ContentMaterials.OTHER;//35% LEATHER
        }
    }

    public static ItemStack getWarriorSword(ContentMaterials contentMaterial, Random random) {
        Item sword;
        switch (contentMaterial) {
            case IRON:
            case CHAINMAIL:
                sword = Items.IRON_SWORD;
                break;
            case GOLDEN:
                sword = Items.GOLDEN_SWORD;
                break;
            case DIAMOND:
                sword = Items.DIAMOND_SWORD;
                break;
            default:
            case OTHER:
                sword = random.nextBoolean() ? Items.STONE_SWORD : Items.WOODEN_SWORD;
                break;
        }
        return new ItemStack(sword, 1, getRandomDamage(random, 30));
    }

    private static ContentMaterials getMinerContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 10) {
            return ContentMaterials.DIAMOND;//10%
        } else if (chance < 30) {
            return ContentMaterials.GOLDEN;//20%
        } else if (chance < 60) {
            return ContentMaterials.IRON;//30%
        } else {
            return ContentMaterials.OTHER;//40%
        }
    }

    private static ContentMaterials getWizardContentType(Random random) {
        int chance = random.nextInt(10);
        if (chance < 1) {
            return ContentMaterials.REDSTONE;//10%
        } else if (chance < 2) {
            return ContentMaterials.QUARTZ;//10%
        } else if (chance < 4) {
            return ContentMaterials.LAPIS;//20%
        } else {
            return ContentMaterials.OTHER;//60%
        }
    }


    private static ContentMaterials getWorkerContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 10) {
            return ContentMaterials.DIAMOND;//10%
        } else if (chance < 30) {
            return ContentMaterials.GOLDEN;//20%
        } else if (chance < 60) {
            return ContentMaterials.IRON;//30%
        } else {
            return ContentMaterials.OTHER;//40%
        }
    }

    private static ContentMaterials getAdventureContentType(Random random) {
        if (random.nextInt(10) <= 2) {
            return ContentMaterials.EMERALD;//20%
        } else {
            return ContentMaterials.OTHER;//80%
        }
    }

    private static ContentMaterials getTreasuryContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 10) {
            return ContentMaterials.EMERALD;//10%
        } else if (chance < 30) {
            return ContentMaterials.DIAMOND;//20%
        } else if (chance < 60) {
            return ContentMaterials.GOLDEN;//30%
        } else if (chance < 90) {
            return ContentMaterials.IRON;//30%
        } else {
            return ContentMaterials.OTHER;//10%
        }
    }

    private static ContentMaterials getPetContentType(Random random) {
        int chance = random.nextInt(10);
        if (chance == 0) {
            return ContentMaterials.GOLDEN;//10%
        } else if (chance == 1) {
            return ContentMaterials.DIAMOND;//10%
        } else {
            return ContentMaterials.OTHER;//80%
        }
    }

    private static ContentMaterials getHorseContentType(Random random) {
        int chance = random.nextInt(100);
        if (chance < 5) {
            return ContentMaterials.DIAMOND;//5%
        } else if (chance < 12) {
            return ContentMaterials.GOLDEN;//7%
        } else if (chance < 25) {
            return ContentMaterials.IRON;//13%
        } else {
            return ContentMaterials.OTHER;//75%
        }
    }

    private static int getRandomDamage(Random random, int maxDamage) {
        return random.nextInt(maxDamage);
    }

    public static List<ItemStack> getRandomGraveContent(World world, Random random, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity, GraveContentType contentType,
                                                        GraveCorpseContentType corpseType, ContentMaterials contentMaterials) {
        List<ItemStack> itemList = new ArrayList<>();
        if (corpseType == GraveCorpseContentType.RANDOM) {
            corpseType = getRandomCorpseContentType(contentMaterials, random);
        }
        switch (corpseType) {
            case CORPSE:
                addCorpse(contentType, random, itemList);//TODO
                break;
            case BONES_AND_FLESH:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_BONES_AND_FLESH, contentMaterials));
                break;
            case SKULL_BONES_AND_FLESH:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_SKULL, contentMaterials));
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_BONES_AND_FLESH, contentMaterials));
                break;
        }

        if (contentType != GraveContentType.JUNK) {
            switch (graveTypeByEntity) {
                case DOGS_GRAVES:
                case CATS_GRAVES:
                    fillPetGrave(world, random, itemList, contentMaterials);
                    break;
                case HORSE_GRAVES:
                    fillHorseGrave(world, random, itemList, contentMaterials);
                    break;
                default:
                    switch (contentType) {
                        case WORKER:
                            fillWorkerGrave(world, random, itemList, contentMaterials);
                            break;
                        case MINER:
                            fillMinerGrave(world, random, itemList, contentMaterials);//TODO
                            break;
                        case WIZARD:
                            itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WIZARD, contentMaterials));
                            break;
                        case WARRIOR:
                            fillWarriorGrave(world, random, itemList, contentMaterials);//TODO
                            break;
                        case ADVENTURER:
                            itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_ADVENTURER, contentMaterials));//TODO EGGS
                            break;
                        case TREASURY:
                            itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_TREASURY, contentMaterials));
                            break;
                    }
            }
        }
        return itemList;
    }

    private static void addCorpse(GraveContentType contentType, Random random, List<ItemStack> itemList) {
        switch (contentType) {
            case DOG:
                itemList.add(DogCorpseHelper.getRandomCorpse(random));
                break;
            case CAT:
                itemList.add(CatCorpseHelper.getRandomCorpse(random));
                break;
            case HORSE:
                itemList.add(HorseCorpseHelper.getRandomCorpse(random));
                break;
            default:
                itemList.add(VillagerCorpseHelper.getRandomCorpse(random));
                break;
        }
    }

    private static void fillPetGrave(World world, Random random, List<ItemStack> itemList, ContentMaterials material) {
        switch (material) {
            case GOLDEN:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PET_GOLDEN, material));
                break;
            case DIAMOND:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PET_DIAMOND, material));
                break;
        }
    }

    private static void fillHorseGrave(World world, Random random, List<ItemStack> itemList, ContentMaterials material) {
        switch (material) {
            case IRON:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_HORSE_ARMOR_IRON, material));
                break;
            case GOLDEN:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_HORSE_ARMOR_GOLDEN, material));
                break;
            case DIAMOND:
            case EMERALD:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_HORSE_ARMOR_DIAMOND, material));
                break;
            default:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_HORSE, material));
                break;
        }
    }

    private static void fillWorkerGrave(World world, Random random, List<ItemStack> itemList, ContentMaterials material) {
        switch (material) {
            case IRON:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WORKER_IRON, material));
                break;
            case GOLDEN:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WORKER_GOLDEN, material));
                break;
            case DIAMOND:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WORKER_DIAMOND, material));
                break;
        }
    }

    private static void fillMinerGrave(World world, Random random, List<ItemStack> itemList, ContentMaterials material) {
        switch (material) {
            case IRON:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_MINER_IRON, material));
                break;
            case GOLDEN:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_MINER_GOLDEN, material));
                break;
            case DIAMOND:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_MINER_DIAMOND, material));
                break;
            default:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_MINER_STONE, material));
                break;
        }
    }

    private static void fillWarriorGrave(World world, Random random, List<ItemStack> itemList, ContentMaterials material) {
        //TODO !!!
        switch (material) {
            case OTHER:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WARRIOR_LEATHER, material));
                break;
            case IRON:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WARRIOR_IRON, material));
                break;
            case CHAINMAIL:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WARRIOR_CHAINMAIL, material));
                break;
            case GOLDEN:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WARRIOR_GOLDEN, material));
                break;
            case DIAMOND:
                itemList.addAll(GSLootTables.getGraveLoot(world, random, GSLootTables.GRAVE_PLAYER_WARRIOR_DIAMOND, material));
                break;
        }
    }
}
