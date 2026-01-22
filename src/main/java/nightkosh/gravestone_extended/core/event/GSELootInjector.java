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

        if (event.getName().toString().equals(AdvancedFishingCompatibility.NETHER_FISHING_TREASURE_LOOT_TABLE)) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("LootTableLoadEvent event triggered. Going to inject enchanted skulls as nether fishing treasure loot.");
            }

            var table = event.getTable();
            var targetPool = table.getPool(AdvancedFishingCompatibility.NETHER_FISHING_TREASURE_POOL_NAME);
            if (targetPool != null) {
                var ref = ResourceKey.create(
                        Registries.LOOT_TABLE,
                        fromNamespaceAndPath(ModInfo.ID, "inject/fishing_nether_enchanted_skull"));
                var newEntry = NestedLootTable.lootTableReference(ref)
                        .setWeight(10)
                        .build();

                var entries = new ArrayList<>(targetPool.entries);
                entries.add(newEntry);
                targetPool.entries = entries;
            } else {
                if (GSEConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("Can't find loot pool {}", AdvancedFishingCompatibility.NETHER_FISHING_TREASURE_POOL_NAME);
                }
            }

        }
    }

}
