package nightkosh.gravestone_extended.core.event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.api.grave.EnumGraveType;
import nightkosh.gravestone.core.GSBlocks;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.compatibility.WitheredLandsCompatibility;

import java.util.List;
import java.util.Optional;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;
import static nightkosh.gravestone_extended.core.GSEVillagers.UNDERTAKER_ID;
import static nightkosh.gravestone_extended.core.GSEVillagers.UNDERTAKER_KEY;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEEventsVillagerTrades {

    private static final List<EnumGraveMaterial> BASIC_MATERIALS = List.of(
            EnumGraveMaterial.STONE,
            EnumGraveMaterial.DIORITE,
            EnumGraveMaterial.GRANITE,
            EnumGraveMaterial.SANDSTONE,
            EnumGraveMaterial.MOSSY,
            EnumGraveMaterial.ICE);

    private static final List<EnumGraveMaterial> ADVANCED_MATERIALS = List.of(
            EnumGraveMaterial.QUARTZ,
            EnumGraveMaterial.OBSIDIAN,
            EnumGraveMaterial.PRIZMARINE,
            EnumGraveMaterial.GOLD,
            EnumGraveMaterial.DIAMOND);

    private static final List<EnumGraveType> GRAVE_TYPES = List.of(
            EnumGraveType.GRAVE_STONE,
            EnumGraveType.GRAVE_PLATE,
            EnumGraveType.CROSS,
            EnumGraveType.CELTIC_CROSS,
            EnumGraveType.OBELISK,
            EnumGraveType.DOG_GRAVE_STONE,
            EnumGraveType.CAT_GRAVE_STONE);

    @SubscribeEvent
    public static void addTrades(VillagerTradesEvent event) {
        if (event.getType() == UNDERTAKER_KEY) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("VillagerTradesEvent event for {} villager triggered", UNDERTAKER_ID);
            }
            var trades = event.getTrades();

            for (var material : BASIC_MATERIALS) {
                for (var graveType : GRAVE_TYPES)
                    trades.get(1).add((trader, entity, rand) -> new MerchantOffer(
                            new ItemCost(Items.EMERALD, rand.nextInt(2, 5)),
                            Optional.of(new ItemCost(material.getBlock())),
                            new ItemStack(GSBlocks.getGraveBlock(graveType, material), 8),
                            10, 5, 0.02F));
            }

            for (var material : ADVANCED_MATERIALS) {
                for (var graveType : GRAVE_TYPES)
                    trades.get(2).add((trader, entity, rand) -> new MerchantOffer(
                            new ItemCost(Items.EMERALD, rand.nextInt(5, 10)),
                            Optional.of(new ItemCost(material.getBlock())),
                            new ItemStack(GSBlocks.getGraveBlock(graveType, material), 8),
                            10, 10, 0.02F));
            }

            trades.get(3).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(30, 40)),
                    new ItemStack(Items.SKELETON_SKULL),
                    2, 15, 0.02F));
            trades.get(3).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(30, 40)),
                    new ItemStack(Items.ZOMBIE_HEAD),
                    2, 15, 0.02F));

            trades.get(4).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(35, 45)),
                    new ItemStack(WitheredLandsCompatibility.SKULL_HUSK),
                    1, 20, 0.02F));
            trades.get(4).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(35, 45)),
                    new ItemStack(WitheredLandsCompatibility.SKULL_DROWNED),
                    1, 20, 0.02F));
            trades.get(4).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(35, 45)),
                    new ItemStack(WitheredLandsCompatibility.SKULL_STRAY),
                    1, 20, 0.02F));
            trades.get(4).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(35, 45)),
                    new ItemStack(WitheredLandsCompatibility.SKULL_BOGGED),
                    1, 20, 0.02F));
            trades.get(4).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(35, 45)),
                    new ItemStack(WitheredLandsCompatibility.SKULL_PARCHED),
                    1, 20, 0.02F));
            trades.get(4).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(35, 45)),
                    new ItemStack(WitheredLandsCompatibility.SKULL_PIGLIN),
                    1, 20, 0.02F));

            trades.get(5).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(45, 55)),
                    new ItemStack(Items.CREEPER_HEAD),
                    1, 30, 0.02F));
            trades.get(5).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(45, 55)),
                    new ItemStack(Items.PIGLIN_HEAD),
                    1, 30, 0.02F));
            trades.get(5).add((trader, entity, rand) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, rand.nextInt(50, 60)),
                    new ItemStack(Items.WITHER_SKELETON_SKULL),
                    1, 30, 0.02F));
        }
    }

}
