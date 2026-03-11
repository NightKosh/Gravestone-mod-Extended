package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.block.fluid.BlightwaterFluid;

import java.util.function.Supplier;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEFluids {

    public static final TagKey<Fluid> BLIGHTWATER_TAG = TagKey.create(
            Registries.FLUID,
            fromNamespaceAndPath(ModInfo.ID, "blightwater"));

    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, ModInfo.ID);

    public static final Supplier<FlowingFluid> BLIGHTWATER = FLUIDS.register(
            "blightwater", BlightwaterFluid.Source::new);

    public static final Supplier<FlowingFluid> BLIGHTWATER_FLOWING = FLUIDS.register(
            "blightwater_flowing", BlightwaterFluid.Flowing::new);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }

}
