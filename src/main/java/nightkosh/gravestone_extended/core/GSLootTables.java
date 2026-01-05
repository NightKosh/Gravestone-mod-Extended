package nightkosh.gravestone_extended.core;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.helper.GraveGenerationHelper;
import nightkosh.gravestone_extended.helper.GraveInventoryHelper;
import nightkosh.gravestone_extended.loot.LootContextGrave;
import nightkosh.gravestone_extended.loot.condition.LootConditionCorpseContentType;
import nightkosh.gravestone_extended.loot.condition.LootConditionGraveContentType;
import nightkosh.gravestone_extended.loot.condition.LootConditionGraveMaterial;
import nightkosh.gravestone_extended.loot.condition.LootConditionGraveTypeByEntity;
import nightkosh.gravestone_extended.loot.function.LootFunctionCorpse;

import java.util.List;
import java.util.Random;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSLootTables {

    public static final Identifier RAVEN = fromNamespaceAndPath(ModInfo.ID, "entities/raven");
    public static final Identifier DAMNED_WARRIOR = fromNamespaceAndPath(ModInfo.ID, "entities/damned_warrior");

    //fishing
    public static final Identifier FISHING_TOXIC_WATER = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing_toxic_water");
    public static final Identifier FISHING_TOXIC_WATER_TREASURE = fromNamespaceAndPath(ModInfo.ID, "gameplay/fishing_toxic_water/treasure");

    //graves
    public static final Identifier GRAVE = fromNamespaceAndPath(ModInfo.ID, "graves/grave");

    public static final Identifier GRAVE_PLAYER = fromNamespaceAndPath(ModInfo.ID, "graves/player");

    public static final Identifier GRAVE_PLAYER_SKULL = fromNamespaceAndPath(ModInfo.ID, "graves/player/corpse/skull");
    public static final Identifier GRAVE_PLAYER_BONES_AND_FLESH = fromNamespaceAndPath(ModInfo.ID, "graves/player/corpse/bones_and_flesh");
    public static final Identifier GRAVE_PLAYER_SKULL_AND_BONES_AND_FLESH = fromNamespaceAndPath(ModInfo.ID, "graves/player/corpse/skull_and_bones_and_flesh");

    public static final Identifier GRAVE_PLAYER_ADVENTURER = fromNamespaceAndPath(ModInfo.ID, "graves/player/adventurer");
    public static final Identifier GRAVE_PLAYER_WIZARD = fromNamespaceAndPath(ModInfo.ID, "graves/player/wizard");
    public static final Identifier GRAVE_PLAYER_WORKER = fromNamespaceAndPath(ModInfo.ID, "graves/player/worker");
    public static final Identifier GRAVE_PLAYER_MINER = fromNamespaceAndPath(ModInfo.ID, "graves/player/miner");

    public static final Identifier GRAVE_PLAYER_WARRIOR = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior");
    public static final Identifier GRAVE_PLAYER_WARRIOR_BOW = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior/bow");
    public static final Identifier GRAVE_PLAYER_WARRIOR_SWORD = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior/sword");
    public static final Identifier GRAVE_PLAYER_WARRIOR_ARMOR_LEATHER = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior/armor/leather");
    public static final Identifier GRAVE_PLAYER_WARRIOR_ARMOR_IRON = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior/armor/iron");
    public static final Identifier GRAVE_PLAYER_WARRIOR_ARMOR_CHAINMAIL = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior/armor/chainmail");
    public static final Identifier GRAVE_PLAYER_WARRIOR_ARMOR_GOLDEN = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior/armor/golden");
    public static final Identifier GRAVE_PLAYER_WARRIOR_ARMOR_DIAMOND = fromNamespaceAndPath(ModInfo.ID, "graves/player/warrior/armor/diamond");

    public static final Identifier GRAVE_PLAYER_TREASURY = fromNamespaceAndPath(ModInfo.ID, "graves/player/treasury");

    public static final Identifier GRAVE_VILLAGER = fromNamespaceAndPath(ModInfo.ID, "graves/villager");

    public static final Identifier GRAVE_DOG = fromNamespaceAndPath(ModInfo.ID, "graves/dog");
    public static final Identifier GRAVE_DOG_ITEMS = fromNamespaceAndPath(ModInfo.ID, "graves/dog/items");
    public static final Identifier GRAVE_DOG_CORPSE = fromNamespaceAndPath(ModInfo.ID, "graves/dog/corpse/corpse");
    public static final Identifier GRAVE_DOG_BONES_AND_FLESH = fromNamespaceAndPath(ModInfo.ID, "graves/dog/corpse/bones_and_flesh");

    public static final Identifier GRAVE_CAT = fromNamespaceAndPath(ModInfo.ID, "graves/cat");
    public static final Identifier GRAVE_CAT_ITEMS = fromNamespaceAndPath(ModInfo.ID, "graves/cat/items");
    public static final Identifier GRAVE_CAT_CORPSE = fromNamespaceAndPath(ModInfo.ID, "graves/cat/corpse/corpse");
    public static final Identifier GRAVE_CAT_BONES_AND_FLESH = fromNamespaceAndPath(ModInfo.ID, "graves/cat/corpse/bones_and_flesh");

    public static final Identifier GRAVE_HORSE = fromNamespaceAndPath(ModInfo.ID, "graves/horse");
    public static final Identifier GRAVE_HORSE_ITEMS = fromNamespaceAndPath(ModInfo.ID, "graves/horse/items");
    public static final Identifier GRAVE_HORSE_CORPSE = fromNamespaceAndPath(ModInfo.ID, "graves/horse/corpse/corpse");
    public static final Identifier GRAVE_HORSE_BONES_AND_FLESH = fromNamespaceAndPath(ModInfo.ID, "graves/horse/corpse/bones_and_flesh");

    public static final Identifier GRAVE_OTHER_EGGS = fromNamespaceAndPath(ModInfo.ID, "graves/other/eggs");
    public static final Identifier GRAVE_OTHER_RECORDS = fromNamespaceAndPath(ModInfo.ID, "graves/other/records");
    public static final Identifier GRAVE_OTHER_POTIONS = fromNamespaceAndPath(ModInfo.ID, "graves/other/potions");

    //inject
    public static final Identifier INJECT_BAT = fromNamespaceAndPath(ModInfo.ID, "inject/bat");
    public static final Identifier INJECT_FISHING_LAVA_NETHER_ENCHANTED_SKULL = fromNamespaceAndPath(ModInfo.ID, "inject/fishing_lava_nether_enchanted_skull");


    public static void registration() {
        LootTableList.register(RAVEN);
        LootTableList.register(DAMNED_WARRIOR);

        //fishing
        LootTableList.register(FISHING_TOXIC_WATER);
        LootTableList.register(FISHING_TOXIC_WATER_TREASURE);

        //graves
        LootTableList.register(GRAVE);

        LootTableList.register(GRAVE_PLAYER);

        LootTableList.register(GRAVE_PLAYER_SKULL);
        LootTableList.register(GRAVE_PLAYER_BONES_AND_FLESH);
        LootTableList.register(GRAVE_PLAYER_SKULL_AND_BONES_AND_FLESH);

        LootTableList.register(GRAVE_PLAYER_ADVENTURER);
        LootTableList.register(GRAVE_PLAYER_WIZARD);
        LootTableList.register(GRAVE_PLAYER_WORKER);//TODO add loot
        LootTableList.register(GRAVE_PLAYER_MINER);

        LootTableList.register(GRAVE_PLAYER_WARRIOR);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_BOW);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_SWORD);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_LEATHER);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_IRON);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_CHAINMAIL);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_GOLDEN);
        LootTableList.register(GRAVE_PLAYER_WARRIOR_ARMOR_DIAMOND);

        LootTableList.register(GRAVE_PLAYER_TREASURY);

        LootTableList.register(GRAVE_VILLAGER);

        LootTableList.register(GRAVE_DOG);
        LootTableList.register(GRAVE_DOG_ITEMS);
        LootTableList.register(GRAVE_DOG_CORPSE);
        LootTableList.register(GRAVE_DOG_BONES_AND_FLESH);

        LootTableList.register(GRAVE_CAT);
        LootTableList.register(GRAVE_CAT_ITEMS);
        LootTableList.register(GRAVE_CAT_CORPSE);
        LootTableList.register(GRAVE_CAT_BONES_AND_FLESH);

        LootTableList.register(GRAVE_HORSE);
        LootTableList.register(GRAVE_HORSE_ITEMS);
        LootTableList.register(GRAVE_HORSE_CORPSE);
        LootTableList.register(GRAVE_HORSE_BONES_AND_FLESH);

        LootTableList.register(GRAVE_OTHER_EGGS);
        LootTableList.register(GRAVE_OTHER_RECORDS);
        LootTableList.register(GRAVE_OTHER_POTIONS);

        //inject
        LootTableList.register(INJECT_BAT);
        LootTableList.register(INJECT_FISHING_LAVA_NETHER_ENCHANTED_SKULL);


        // conditions
        LootConditionManager.registerCondition(new LootConditionGraveMaterial.Serializer());
        LootConditionManager.registerCondition(new LootConditionGraveContentType.Serializer());
        LootConditionManager.registerCondition(new LootConditionGraveTypeByEntity.Serializer());
        LootConditionManager.registerCondition(new LootConditionCorpseContentType.Serializer());

        // functions
        LootFunctionManager.registerFunction(new LootFunctionCorpse.Serializer());
    }

    public static void inject(LootTableLoadEvent event) {
        if (event.getName().toString().equals("advanced-fishing:gameplay/fishing_lava_nether/treasure")) {
            event.getTable().getPool("fishing_lava_nether_treasure").addEntry(
                    new LootEntryTable(INJECT_FISHING_LAVA_NETHER_ENCHANTED_SKULL, 10, 1, new LootCondition[0], "fishing_lava_nether_enchanted_skull"));
        }
    }

    public static List<ItemStack> getGraveLoot(World world, Random random, Identifier lootTable,
                                               GraveInventoryHelper.GraveCorpseContentType corpseContentType,
                                               GraveGenerationHelper.EnumGraveTypeByEntity graveTypeByEntity,
                                               GraveInventoryHelper.GraveContentType graveContentType,
                                               EnumGraveMaterial graveMaterial) {
        return world.getLootTableManager().getLootTableFromLocation(lootTable).generateLootForPools(random,
                new LootContextGrave.Builder((WorldServer) world)
                        .withCorpseContentType(corpseContentType)
                        .withGraveTypeByEntity(graveTypeByEntity)
                        .withGraveContentType(graveContentType)
                        .withGraveMaterial(graveMaterial)
                        .build());
    }
    
}
