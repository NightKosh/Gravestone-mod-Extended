package nightkosh.gravestone_extended.core.event;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.compatibility.AdvancedFishingCompatibility;
import nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility;

import java.util.ArrayList;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;
import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSELootInjector {

    @SubscribeEvent
    public static void inject(LootTableLoadEvent event) {
        if (event.getName().toString().equals(WitheredLandsCompatibility.PHANTOM_DIVER_LOOT_TABLE)) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("LootTableLoadEvent event triggered. Going to inject additional phantom_diver loot.");
            }

            event.getTable().addPool(
                    LootPool.lootPool()
                            .name("phantom_diver_armor_inject")
                            .add(NestedLootTable.lootTableReference(
                                            ResourceKey.create(
                                                    Registries.LOOT_TABLE,
                                                    fromNamespaceAndPath(ModInfo.ID, "inject/phantom_diver")))
                                    .setWeight(1))
                            .build());
        }

        if (AdvancedFishingCompatibility.loaded()) {
            if (!injectFishingLoot(event,
                    AdvancedFishingCompatibility.NETHER_FISHING_TREASURE_LOOT_TABLE,
                    AdvancedFishingCompatibility.NETHER_FISHING_TREASURE_POOL_NAME,
                    "inject/fishing_nether_enchanted_skull")) {
                injectFishingLoot(event,
                        AdvancedFishingCompatibility.FISHING_DEAD_TREASURE_LOOT_TABLE,
                        AdvancedFishingCompatibility.FISHING_DEAD_TREASURE_POOL_NAME,
                        "inject/fishing_blightwater_enchanted_skull");
            }
        }
    }

    private static boolean injectFishingLoot(LootTableLoadEvent event, String lootTable, String poolName, String inject) {
        if (event.getName().toString().equals(lootTable)) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("LootTableLoadEvent event triggered. Going to inject enchanted skulls as fishing treasure loot.");
            }

            var table = event.getTable();
            var targetPool = table.getPool(poolName);
            if (targetPool != null) {
                var ref = ResourceKey.create(
                        Registries.LOOT_TABLE,
                        fromNamespaceAndPath(ModInfo.ID, inject));
                var newEntry = NestedLootTable.lootTableReference(ref)
                        .setWeight(10)
                        .build();

                var entries = new ArrayList<>(targetPool.entries);
                entries.add(newEntry);
                targetPool.entries = entries;
                return true;
            } else {
                if (GSEConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("Can't find loot pool {}", poolName);
                }
            }
        }
        return false;
    }

}
