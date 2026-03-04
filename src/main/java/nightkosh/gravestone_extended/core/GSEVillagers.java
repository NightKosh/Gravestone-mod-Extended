package nightkosh.gravestone_extended.core;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone.api.grave.EnumGraveMaterial;
import nightkosh.gravestone.api.grave.EnumGraveType;
import nightkosh.gravestone.core.GSBlocks;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEVillagers {

    public static final String UNDERTAKER_ID = "undertaker";

    public static final DeferredRegister<PoiType> POI_TYPES_REGISTER =
            DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, ModInfo.ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS_REGISTER =
            DeferredRegister.create(Registries.VILLAGER_PROFESSION, ModInfo.ID);

    public static final ResourceKey<VillagerProfession> UNDERTAKER_KEY =
            ResourceKey.create(Registries.VILLAGER_PROFESSION, fromNamespaceAndPath(ModInfo.ID, UNDERTAKER_ID));

    public static final DeferredHolder<PoiType, PoiType> GOLDEN_GRAVE_STONE = POI_TYPES_REGISTER.register(
            "golden_grave_stone_poi",
            () -> new PoiType(ImmutableSet.copyOf(
                    GSBlocks.getGraveBlock(EnumGraveType.GRAVE_STONE, EnumGraveMaterial.GOLD)
                            .getStateDefinition()
                            .getPossibleStates()),
                    1, 1));

    public static final DeferredHolder<VillagerProfession, VillagerProfession> UNDERTAKER = VILLAGER_PROFESSIONS_REGISTER.register(
            UNDERTAKER_ID,
            () -> new VillagerProfession(
                    Component.translatable("entity." + ModInfo.ID + ".villager." + UNDERTAKER_ID),
                    x -> x.getDelegate().is(GOLDEN_GRAVE_STONE),
                    x -> x.getDelegate().is(GOLDEN_GRAVE_STONE),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER));

    public static void register(IEventBus eventBus) {
        POI_TYPES_REGISTER.register(eventBus);
        VILLAGER_PROFESSIONS_REGISTER.register(eventBus);
    }

}
