package nightkosh.gravestone_extended.core;

import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEFluidTypes {

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, ModInfo.ID);

    public static final DeferredHolder<FluidType, FluidType> BLIGHTWATER = FLUID_TYPES.register(
            "blightwater",
            () -> new FluidType(FluidType.Properties.create()
                    .descriptionId("block.gravestone_extended.blightwater")
                    .fallDistanceModifier(0)
                    .lightLevel(1)
                    .canSwim(true)
                    .canDrown(true)
                    .canHydrate(false)
                    .isWaterLike(true)
                    .canExtinguish(true)
                    .supportsBoating(true)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                    .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH))
            //TODO ??
//            .addDripstoneDripping(
//                    PointedDripstoneBlock.WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK,
//                    ParticleTypes.DRIPPING_DRIPSTONE_WATER,
//                    Blocks.WATER_CAULDRON,
//                    SoundEvents.POINTED_DRIPSTONE_DRIP_WATER_INTO_CAULDRON))

    );

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }

}
