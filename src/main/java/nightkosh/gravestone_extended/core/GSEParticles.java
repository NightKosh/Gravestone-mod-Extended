package nightkosh.gravestone_extended.core;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, ModInfo.ID);

    public static final Supplier<SimpleParticleType> BLIGHTWATER_DRIP = PARTICLES.register(
            "blightwater_drip",
            () -> new SimpleParticleType(false));

    public static final Supplier<SimpleParticleType> BLIGHTWATER_FALL = PARTICLES.register(
            "blightwater_fall",
            () -> new SimpleParticleType(false));

    public static final Supplier<SimpleParticleType> BLIGHTWATER_SPLASH = PARTICLES.register(
            "blightwater_splash",
            () -> new SimpleParticleType(false));

    public static final Supplier<SimpleParticleType> BLIGHTWATER_BUBBLE = PARTICLES.register(
            "blightwater_bubble",
            () -> new SimpleParticleType(false));

    public static final Supplier<SimpleParticleType> BLIGHTWATER_WAKE = PARTICLES.register(
            "blightwater_wake",
            () -> new SimpleParticleType(false));

    public static final Supplier<SimpleParticleType> GREEN_FLAME = PARTICLES.register(
            "green_flame",
            () -> new SimpleParticleType(false));

    public static final Supplier<SimpleParticleType> CATACOMBS_PORTAL = PARTICLES.register(
            "catacombs_portal",
            () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }

}
