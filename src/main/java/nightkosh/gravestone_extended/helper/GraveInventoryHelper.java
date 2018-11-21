package nightkosh.gravestone_extended.helper;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
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
            case HORSE://TODO
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

    private static void fillWarriorGrave(Random random, List<ItemStack> itemList, ContentMaterials materials) {
        switch (materials) {
            case OTHER:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.LEATHER_CHESTPLATE, 1, getRandomDamage(random, 30)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.LEATHER_LEGGINGS, 1, getRandomDamage(random, 30)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.LEATHER_HELMET, 1, getRandomDamage(random, 30)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.LEATHER_BOOTS, 1, getRandomDamage(random, 30)));
                }
                break;
            case IRON:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.IRON_CHESTPLATE, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.IRON_LEGGINGS, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.IRON_HELMET, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.IRON_BOOTS, 1, getRandomDamage(random)));
                }
                break;
            case CHAINMAIL:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.CHAINMAIL_CHESTPLATE, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.CHAINMAIL_LEGGINGS, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.CHAINMAIL_HELMET, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.CHAINMAIL_BOOTS, 1, getRandomDamage(random)));
                }
                break;
            case GOLDEN:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.GOLDEN_CHESTPLATE, 1, getRandomDamage(random, 50)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.GOLDEN_LEGGINGS, 1, getRandomDamage(random, 50)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.GOLDEN_HELMET, 1, getRandomDamage(random, 30)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.GOLDEN_BOOTS, 1, getRandomDamage(random, 40)));
                }
                break;
            case DIAMOND:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.DIAMOND_CHESTPLATE, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.DIAMOND_LEGGINGS, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.DIAMOND_HELMET, 1, getRandomDamage(random)));
                }
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.DIAMOND_BOOTS, 1, getRandomDamage(random)));
                }
                break;
        }

        if (random.nextInt(3) == 0) {
            itemList.add(new ItemStack(Items.BOW, 1, getRandomDamage(random)));
            itemList.add(new ItemStack(Items.ARROW, 10 + random.nextInt(54), 0));
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

    private static void fillMinerGrave(Random random, List<ItemStack> itemList, ContentMaterials materials) {
        switch (materials) {
            case IRON:
                itemList.add(new ItemStack(Items.IRON_PICKAXE, 1, getRandomDamage(random)));
                break;
            case GOLDEN:
                itemList.add(new ItemStack(Items.GOLDEN_PICKAXE, 1, getRandomDamage(random, 15)));
                break;
            case DIAMOND:
                itemList.add(new ItemStack(Items.DIAMOND_PICKAXE, 1, getRandomDamage(random)));
                break;
            default:
                itemList.add(new ItemStack(Items.STONE_PICKAXE, 1, getRandomDamage(random, 30)));
                break;
        }

        switch (random.nextInt(10)) {
            case 0:
                itemList.add(new ItemStack(Items.DIAMOND, 1 + random.nextInt(3), 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.EMERALD, 1 + random.nextInt(3), 0));
                break;
        }
        switch (random.nextInt(5)) {
            case 0:
                itemList.add(new ItemStack(Items.GOLD_INGOT, 3 + random.nextInt(5), 0));
                break;
            case 1:
            case 2:
                itemList.add(new ItemStack(Items.IRON_INGOT, 3 + random.nextInt(5), 0));
                break;
        }
        switch (random.nextInt(5)) {
            case 0:
                itemList.add(new ItemStack(Items.REDSTONE, 3 + random.nextInt(8), 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.DYE, 3 + random.nextInt(8), 4));
                break;
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


    private static void fillWizardGrave(Random random, List<ItemStack> itemList, ContentMaterials contentMaterials) {
        switch (contentMaterials) {
            case REDSTONE: // enchanted book
                itemList.add(EnchantmentHelper.addRandomEnchantment(random, new ItemStack(Items.BOOK), 5, true));
                break;
            case QUARTZ:
                itemList.add(PotionHelper.getGravesPotion(random));
                itemList.add(new ItemStack(Items.DRAGON_BREATH, 5 + random.nextInt(10)));
                break;
            case LAPIS:
                itemList.add(new ItemStack(Items.BOOK, 3 + random.nextInt(8), 0));
                break;
        }
        switch (random.nextInt(15)) {
            case 0:
                itemList.add(new ItemStack(Items.ENDER_PEARL, 1, 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.BLAZE_POWDER, 1, 0));
                break;
            case 2:
                itemList.add(new ItemStack(Items.GLOWSTONE_DUST, 3 + random.nextInt(8), 0));
                break;
        }
        switch (random.nextInt(6)) {
            case 0:
                itemList.add(new ItemStack(Items.MAGMA_CREAM, 1, 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.GUNPOWDER, 1, 0));
                break;
        }
        switch (random.nextInt(10)) {
            case 0:
                itemList.add(new ItemStack(Items.GHAST_TEAR, 1, 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.NETHER_WART, 1, 0));
                break;
        }
        switch (random.nextInt(5)) {
            case 0:
                itemList.add(new ItemStack(Items.SPIDER_EYE, 1, 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.FERMENTED_SPIDER_EYE, 1, 0));
                break;
        }
        switch (random.nextInt(8)) {
            case 0:
                itemList.add(new ItemStack(Items.GOLDEN_CARROT, 1, 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.SPECKLED_MELON, 1, 0));
                break;
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

    private static void fillWorkerGrave(Random random, List<ItemStack> itemList, ContentMaterials materials) {
        switch (materials) {
            case IRON:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.IRON_AXE, 1, getRandomDamage(random)));
                } else {
                    itemList.add(new ItemStack(Items.IRON_SHOVEL, 1, getRandomDamage(random)));
                }
                break;
            case GOLDEN:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.GOLDEN_AXE, 1, getRandomDamage(random, 15)));
                } else {
                    itemList.add(new ItemStack(Items.GOLDEN_SHOVEL, 1, getRandomDamage(random, 15)));
                }
                break;
            case DIAMOND:
                if (random.nextBoolean()) {
                    itemList.add(new ItemStack(Items.DIAMOND_AXE, 1, getRandomDamage(random)));
                } else {
                    itemList.add(new ItemStack(Items.DIAMOND_SHOVEL, 1, getRandomDamage(random)));
                }
                break;
        }

        if (random.nextInt(8) == 0) {
            itemList.add(new ItemStack(Items.SADDLE, 1, 0));
        }
    }

    private static ContentMaterials getAdventureContentType(Random random) {
        if (random.nextInt(10) <= 2) {
            return ContentMaterials.EMERALD;//20%
        } else {
            return ContentMaterials.OTHER;//80%
        }
    }

    private static void fillAdventureGrave(Random random, List<ItemStack> itemList, ContentMaterials contentMaterials) {
        switch (random.nextInt(8)) {
            case 0:
                itemList.add(new ItemStack(Items.COMPASS, 1, 0));
                break;
            case 1:
                itemList.add(new ItemStack(Items.CLOCK, 1, 0));
                break;
            case 2:
                itemList.add(new ItemStack(Items.MAP, 1, 0));
                break;
        }

        switch (random.nextInt(10)) {
            case 0:
                itemList.add(new ItemStack(Items.PAINTING, 1 + random.nextInt(5), 0));
                break;
            case 1:
                itemList.add(getRandomRecord(random));
                break;
            case 2:
                itemList.add(new ItemStack(Items.WRITABLE_BOOK, 1, 0));
                break;
        }

        if (random.nextInt(4) == 0) {
            itemList.add(new ItemStack(Items.STICK, 3 + random.nextInt(9), 0));
        }

        if (random.nextInt(5) == 0) {
            itemList.add(new ItemStack(Items.COOKIE, 3 + random.nextInt(5), 0));
        }

        if (contentMaterials == ContentMaterials.EMERALD) {
            itemList.add(EggHelper.getRandomEgg(random));
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

    private static void fillTreasuryGrave(Random random, List<ItemStack> itemList) {
        if (random.nextInt(10) == 0) {
            itemList.add(getRandomRecord(random));
        }
        if (random.nextInt(10) == 0) {
            itemList.add(EggHelper.getRandomEgg(random));
        }
        if (random.nextInt(10) == 0) {// enchanted book
            itemList.add(EnchantmentHelper.addRandomEnchantment(random, new ItemStack(Items.BOOK), 5, true));
        }
        if (random.nextInt(10) == 0) {
            itemList.add(new ItemStack(Items.ENDER_PEARL, 1 + random.nextInt(5), 0));
        }
        if (random.nextInt(10) == 0) {
            itemList.add(new ItemStack(Items.GHAST_TEAR, 1 + random.nextInt(5), 0));
        }
        if (random.nextInt(10) == 0) {
            itemList.add(new ItemStack(Items.BLAZE_ROD, 1 + random.nextInt(5), 0));
        }

        if (random.nextInt(5) == 0) {
            itemList.add(new ItemStack(Items.MAGMA_CREAM, 1 + random.nextInt(5), 0));
        }
        if (random.nextInt(5) == 0) {
            itemList.add(new ItemStack(Items.GLOWSTONE_DUST, 3 + random.nextInt(13), 0));
        }

        if (random.nextInt(10) == 0) {
            itemList.add(new ItemStack(Items.DIAMOND, 1 + random.nextInt(5), 0));
        } else if (random.nextInt(10) == 0) {
            itemList.add(new ItemStack(Items.EMERALD, 1 + random.nextInt(5), 0));
        } else {
            itemList.add(new ItemStack(Items.GOLD_INGOT, 3 + random.nextInt(8), 0));
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

    private static List<ItemStack> getLoot(World world, ResourceLocation lootTable) {
        LootContext.Builder lootContextBuilder = new LootContext.Builder((WorldServer) world);

        return world.getLootTableManager().getLootTableFromLocation(lootTable).generateLootForPools(world.rand, lootContextBuilder.build());
    }

    private static void fillPetGrave(List<ItemStack> itemList, ContentMaterials contentMaterials) {
        switch (contentMaterials) {
            case GOLDEN:
                itemList.addAll(getLoot(world, GSLootTables.GRAVE_PET_GOLDEN));
                break;
            case DIAMOND:
                itemList.addAll(getLoot(world, GSLootTables.GRAVE_PET_DIAMOND));
                break;
        }
    }

    private static int getRandomDamage(Random random) {
        return 20 + random.nextInt(100);
    }

    private static int getRandomDamage(Random random, int maxDamage) {
        return random.nextInt(maxDamage);
    }

    private static ItemStack getRandomRecord(Random random) {
        switch (random.nextInt(13)) {
            case 1:
                return new ItemStack(Items.RECORD_CAT, 1, 0);
            case 2:
                return new ItemStack(Items.RECORD_BLOCKS, 1, 0);
            case 3:
                return new ItemStack(Items.RECORD_CHIRP, 1, 0);
            case 4:
                return new ItemStack(Items.RECORD_FAR, 1, 0);
            case 5:
                return new ItemStack(Items.RECORD_MALL, 1, 0);
            case 6:
                return new ItemStack(Items.RECORD_MELLOHI, 1, 0);
            case 7:
                return new ItemStack(Items.RECORD_STAL, 1, 0);
            case 8:
                return new ItemStack(Items.RECORD_STRAD, 1, 0);
            case 9:
                return new ItemStack(Items.RECORD_WARD, 1, 0);
            case 10:
                return new ItemStack(Items.RECORD_11, 1, 0);
            case 11:
                return new ItemStack(Items.RECORD_WAIT, 1, 0);
            case 12:
                return new ItemStack(Items.RECORD_13, 1, 0);
            case 0:
            default:
                return new ItemStack(Items.RECORD_CAT, 1, 0);
        }
    }

    public static List<ItemStack> getRandomGraveContent(Random random, GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity, GraveContentType contentType,
                                                        GraveCorpseContentType corpseType, ContentMaterials contentMaterials) {
        List<ItemStack> itemList = new ArrayList<>();
        if (corpseType == GraveInventoryHelper.GraveCorpseContentType.RANDOM) {
            corpseType = GraveInventoryHelper.getRandomCorpseContentType(contentMaterials, random);
        }
        switch (corpseType) {
            case CORPSE:
                GraveInventoryHelper.addCorpse(contentType, random, itemList);
                break;
            case BONES_AND_FLESH:
                itemList.addAll(getLoot(world, GSLootTables.GRAVE_BONES_AND_FLESH));
                break;
            case SKULL_BONES_AND_FLESH:
                itemList.addAll(getLoot(world, GSLootTables.GRAVE_SKULL));
                itemList.addAll(getLoot(world, GSLootTables.GRAVE_BONES_AND_FLESH));
                break;
        }

        if (contentType != GraveContentType.JUNK) {
            switch (graveTypeByEntity) {
                case DOGS_GRAVES:
                case CATS_GRAVES:
                    GraveInventoryHelper.fillPetGrave(world, itemList, contentMaterials);
                    break;
                case HORSE_GRAVES:
                    break;//TODO !!!!!
                default:
                    switch (contentType) {
                        case WORKER:
                            GraveInventoryHelper.fillWorkerGrave(random, itemList, contentMaterials);
                            break;
                        case MINER:
                            GraveInventoryHelper.fillMinerGrave(random, itemList, contentMaterials);
                            break;
                        case WIZARD:
                            GraveInventoryHelper.fillWizardGrave(random, itemList, contentMaterials);
                            break;
                        case WARRIOR:
                            GraveInventoryHelper.fillWarriorGrave(random, itemList, contentMaterials);
                            break;
                        case ADVENTURER:
                            GraveInventoryHelper.fillAdventureGrave(random, itemList, contentMaterials);
                            break;
                        case TREASURY:
                            GraveInventoryHelper.fillTreasuryGrave(random, itemList);
                            break;
                    }
            }
        }
        return itemList;
    }
}
