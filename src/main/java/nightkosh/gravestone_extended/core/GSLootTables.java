package nightkosh.gravestone_extended.core;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.LootConditionManager;
import net.minecraftforge.event.LootTableLoadEvent;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;
import nightkosh.gravestone_extended.loot.LootConditionGraveContentMaterial;
import nightkosh.gravestone_extended.loot.LootContextGrave;

import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSLootTables {

    public static final ResourceLocation ZOMBIE_DOG = new ResourceLocation(ModInfo.ID, "entities/zombie_dog");
    public static final ResourceLocation ZOMBIE_CAT = new ResourceLocation(ModInfo.ID, "entities/zombie_cat");
    public static final ResourceLocation SKELETON_DOG = new ResourceLocation(ModInfo.ID, "entities/skeleton_dog");
    public static final ResourceLocation SKELETON_CAT = new ResourceLocation(ModInfo.ID, "entities/skeleton_cat");
    public static final ResourceLocation SKULL_CRAWLER = new ResourceLocation(ModInfo.ID, "entities/skull_crawler");
    public static final ResourceLocation STRAY_SKULL_CRAWLER = new ResourceLocation(ModInfo.ID, "entities/stray_skull_crawler");
    public static final ResourceLocation WITHER_SKULL_CRAWLER = new ResourceLocation(ModInfo.ID, "entities/wither_skull_crawler");
    public static final ResourceLocation ZOMBIE_SKULL_CRAWLER = new ResourceLocation(ModInfo.ID, "entities/zombie_skull_crawler");
    public static final ResourceLocation HUSK_SKULL_CRAWLER = new ResourceLocation(ModInfo.ID, "entities/husk_skull_crawler");
    public static final ResourceLocation PIGMAN_SKULL_CRAWLER = new ResourceLocation(ModInfo.ID, "entities/pigman_skull_crawler");
    public static final ResourceLocation TOXIC_SLUDGE = new ResourceLocation(ModInfo.ID, "entities/toxic_sludge");
    public static final ResourceLocation POSSESSED_ARMOR = new ResourceLocation(ModInfo.ID, "entities/possessed_armor");
    public static final ResourceLocation MUMMY = new ResourceLocation(ModInfo.ID, "entities/mummy");
    public static final ResourceLocation DROWNED = new ResourceLocation(ModInfo.ID, "entities/drowned");
    public static final ResourceLocation PHANTOM_DIVER = new ResourceLocation(ModInfo.ID, "entities/phantom_diver");
    public static final ResourceLocation VAMPIRE_BAT = new ResourceLocation(ModInfo.ID, "entities/vampire_bat");
    public static final ResourceLocation WITHERED_BAT = new ResourceLocation(ModInfo.ID, "entities/withered_bat");
    public static final ResourceLocation BARGHEST = new ResourceLocation(ModInfo.ID, "entities/barghest");
    public static final ResourceLocation SWAMP_THING = new ResourceLocation(ModInfo.ID, "entities/swamp_thing");
    public static final ResourceLocation RAVEN = new ResourceLocation(ModInfo.ID, "entities/raven");
    public static final ResourceLocation DAMNED_WARRIOR = new ResourceLocation(ModInfo.ID, "entities/damned_warrior");
    // Skeletons, undead horses, raiders ??

    //fishing
    public static final ResourceLocation FISHING_TOXIC_WATER = new ResourceLocation(ModInfo.ID, "gameplay/fishing_toxic_water");
    public static final ResourceLocation FISHING_TOXIC_WATER_TREASURE = new ResourceLocation(ModInfo.ID, "gameplay/fishing_toxic_water/treasure");

    //graves
    public static final ResourceLocation GRAVE_SKULL = new ResourceLocation(ModInfo.ID, "graves/corpse/skull");
    public static final ResourceLocation GRAVE_BONES_AND_FLESH = new ResourceLocation(ModInfo.ID, "graves/corpse/bones_and_flesh");

    public static final ResourceLocation GRAVE_PLAYER_ADVENTURER = new ResourceLocation(ModInfo.ID, "graves/player/adventurer");
    public static final ResourceLocation GRAVE_PLAYER_WIZARD = new ResourceLocation(ModInfo.ID, "graves/player/wizard");
    public static final ResourceLocation GRAVE_PLAYER_WORKER = new ResourceLocation(ModInfo.ID, "graves/player/worker");
    public static final ResourceLocation GRAVE_PLAYER_MINER = new ResourceLocation(ModInfo.ID, "graves/player/miner");

    public static final ResourceLocation GRAVE_PLAYER_WARRIOR = new ResourceLocation(ModInfo.ID, "graves/player/warrior");
    public static final ResourceLocation GRAVE_PLAYER_WARRIOR_BOW = new ResourceLocation(ModInfo.ID, "graves/player/warrior/bow");
    public static final ResourceLocation GRAVE_PLAYER_WARRIOR_ARMOR_LEATHER = new ResourceLocation(ModInfo.ID, "graves/player/warrior/armor/leather");
    public static final ResourceLocation GRAVE_PLAYER_WARRIOR_ARMOR_IRON = new ResourceLocation(ModInfo.ID, "graves/player/warrior/armor/iron");
    public static final ResourceLocation GRAVE_PLAYER_WARRIOR_ARMOR_CHAINMAIL = new ResourceLocation(ModInfo.ID, "graves/player/warrior/armor/chainmail");
    public static final ResourceLocation GRAVE_PLAYER_WARRIOR_ARMOR_GOLDEN = new ResourceLocation(ModInfo.ID, "graves/player/warrior/armor/golden");
    public static final ResourceLocation GRAVE_PLAYER_WARRIOR_ARMOR_DIAMOND = new ResourceLocation(ModInfo.ID, "graves/player/warrior/armor/diamond");

    public static final ResourceLocation GRAVE_PLAYER_TREASURY = new ResourceLocation(ModInfo.ID, "graves/player/treasury");

    public static final ResourceLocation GRAVE_PET_GOLDEN = new ResourceLocation(ModInfo.ID, "graves/pet/golden");
    public static final ResourceLocation GRAVE_PET_DIAMOND = new ResourceLocation(ModInfo.ID, "graves/pet/diamond");
    public static final ResourceLocation GRAVE_PET_DOG = new ResourceLocation(ModInfo.ID, "graves/pet/dog");
    public static final ResourceLocation GRAVE_PET_CAT = new ResourceLocation(ModInfo.ID, "graves/pet/cat");
    public static final ResourceLocation GRAVE_PET_HORSE = new ResourceLocation(ModInfo.ID, "graves/pet/horse");

    public static final ResourceLocation GRAVE_OTHER_EGGS = new ResourceLocation(ModInfo.ID, "graves/other/eggs");
    public static final ResourceLocation GRAVE_OTHER_RECORDS = new ResourceLocation(ModInfo.ID, "graves/other/records");
    public static final ResourceLocation GRAVE_OTHER_POTIONS = new ResourceLocation(ModInfo.ID, "graves/other/potions");

    //inject
    public static final ResourceLocation INJECT_BAT = new ResourceLocation(ModInfo.ID, "inject/bat");
    public static final ResourceLocation INJECT_FISHING_LAVA_NETHER_ENCHANTED_SKULL = new ResourceLocation(ModInfo.ID, "inject/fishing_lava_nether_enchanted_skull");


    public static void registration() {
        LootTableList.register(ZOMBIE_DOG);
        LootTableList.register(ZOMBIE_CAT);
        LootTableList.register(SKELETON_DOG);
        LootTableList.register(SKELETON_CAT);
        LootTableList.register(SKULL_CRAWLER);
        LootTableList.register(STRAY_SKULL_CRAWLER);
        LootTableList.register(WITHER_SKULL_CRAWLER);
        LootTableList.register(ZOMBIE_SKULL_CRAWLER);
        LootTableList.register(HUSK_SKULL_CRAWLER);
        LootTableList.register(PIGMAN_SKULL_CRAWLER);
        LootTableList.register(TOXIC_SLUDGE);
        LootTableList.register(POSSESSED_ARMOR);
        LootTableList.register(MUMMY);
        LootTableList.register(DROWNED);
        LootTableList.register(PHANTOM_DIVER);
        LootTableList.register(VAMPIRE_BAT);
        LootTableList.register(BARGHEST);
        LootTableList.register(SWAMP_THING);
        LootTableList.register(RAVEN);
        LootTableList.register(DAMNED_WARRIOR);

        //fishing
        LootTableList.register(FISHING_TOXIC_WATER);
        LootTableList.register(FISHING_TOXIC_WATER_TREASURE);

        //graves
        LootTableList.register(GRAVE_SKULL);
        LootTableList.register(GRAVE_BONES_AND_FLESH);

        LootTableList.register(GRAVE_PLAYER_ADVENTURER);
        LootTableList.register(GRAVE_PLAYER_WIZARD);
        LootTableList.register(GRAVE_PLAYER_WORKER);//TODO add loot
        LootTableList.register(GRAVE_PLAYER_MINER);

        LootTableList.register(GRAVE_PLAYER_WARRIOR);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_BOW);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_LEATHER);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_IRON);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_CHAINMAIL);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_GOLDEN);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_DIAMOND);

        LootTableList.register(GRAVE_PLAYER_TREASURY);

        LootTableList.register(GRAVE_PET_GOLDEN);
        LootTableList.register(GRAVE_PET_DIAMOND);

        LootTableList.register(GRAVE_PET_DOG);
        LootTableList.register(GRAVE_PET_CAT);
        LootTableList.register(GRAVE_PET_HORSE);

        LootTableList.register(GRAVE_OTHER_EGGS);
        LootTableList.register(GRAVE_OTHER_RECORDS);
        LootTableList.register(GRAVE_OTHER_POTIONS);

        //inject
        LootTableList.register(INJECT_BAT);
        LootTableList.register(INJECT_FISHING_LAVA_NETHER_ENCHANTED_SKULL);


        // conditions
        LootConditionManager.registerCondition(new LootConditionGraveContentMaterial.Serializer());
    }

    public static void inject(LootTableLoadEvent event) {
        if (event.getName().toString().equals("minecraft:entities/bat")) {
            LootEntry entry = new LootEntryTable(INJECT_BAT, 1, 1, new LootCondition[0], "bat_wing");
            LootPool pool = new LootPool(new LootEntry[]{entry}, new LootCondition[]{}, new RandomValueRange(1, 1), new RandomValueRange(0, 1), "bat_wing");
            event.getTable().addPool(pool);
        }

        if (event.getName().toString().equals("advanced-fishing:gameplay/fishing_lava_nether/treasure")) {
            LootEntry entry = new LootEntryTable(INJECT_FISHING_LAVA_NETHER_ENCHANTED_SKULL, 1, 1, new LootCondition[0], "fishing_lava_nether_enchanted_skull");
            LootPool pool = new LootPool(new LootEntry[]{entry}, new LootCondition[]{}, new RandomValueRange(1, 1), new RandomValueRange(0, 1), "fishing_lava_nether_enchanted_skull");
            event.getTable().addPool(pool);
        }
    }

    public static List<ItemStack> getGraveLoot(World world, Random random, ResourceLocation lootTable, GraveInventoryHelper.ContentMaterials contentMaterial) {
        return world.getLootTableManager().getLootTableFromLocation(lootTable).generateLootForPools(random,
                new LootContextGrave.Builder((WorldServer) world).withContentMaterial(contentMaterial).build());
    }
}
