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
        if (event.getName().toString().equals("withered_lands:entities/phantom_diver")) {
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
    }

}
