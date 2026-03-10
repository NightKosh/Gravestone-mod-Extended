package nightkosh.gravestone_extended.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.DripParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.material.Fluid;
import nightkosh.gravestone_extended.core.GSEFluids;
import nightkosh.gravestone_extended.core.GSEParticles;

import javax.annotation.Nonnull;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlightwaterDripParticle extends DripParticle {

    public BlightwaterDripParticle(ClientLevel level, double x, double y, double z, Fluid type, TextureAtlasSprite sprite) {
        super(level, x, y, z, type, sprite);
    }

    public static class DripHangParticle extends DripParticle {
        private final ParticleOptions fallingParticle;

        public DripHangParticle(
                ClientLevel level,
                double x, double y, double z,
                Fluid type,
                ParticleOptions fallingParticle,
                TextureAtlasSprite sprite) {
            super(level, x, y, z, type, sprite);
            this.fallingParticle = fallingParticle;
            this.gravity *= 0.02F;
            this.lifetime = 40;
        }

        @Override
        protected void preMoveUpdate() {
            if (this.lifetime-- <= 0) {
                this.remove();
                this.level.addParticle(this.fallingParticle, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }
        }

        @Override
        protected void postMoveUpdate() {
            this.xd *= 0.02;
            this.yd *= 0.02;
            this.zd *= 0.02;
        }
    }

    public static class FallingParticle extends DripParticle {
        public FallingParticle(ClientLevel level, double x, double y, double z, Fluid type, TextureAtlasSprite sprite) {
            super(level, x, y, z, type, sprite);
        }

        @Override
        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
            }
        }
    }

    public static class FallAndLandParticle extends FallingParticle {
        protected final ParticleOptions landParticle;

        public FallAndLandParticle(
                ClientLevel level,
                double x, double y, double z,
                Fluid type,
                ParticleOptions landParticle,
                TextureAtlasSprite sprite) {
            super(level, x, y, z, type, sprite);
            this.lifetime = (int) (64 / (this.random.nextFloat() * 0.8 + 0.2));
            this.landParticle = landParticle;
        }

        @Override
        protected void postMoveUpdate() {
            if (this.onGround) {
                this.remove();
                this.level.addParticle(this.landParticle, this.x, this.y, this.z, 0, 0, 0);
            }
        }
    }

    public static class FallProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public FallProvider(SpriteSet sprite) {
            this.sprite = sprite;
        }

        public Particle createParticle(
                SimpleParticleType particleType, @Nonnull ClientLevel level,
                double x, double y, double z,
                double xSpeed, double ySpeed, double zSpeed,
                @Nonnull RandomSource random) {
            var particle = new FallAndLandParticle(
                    level, x, y, z,
                    GSEFluids.BLIGHTWATER.get(), GSEParticles.BLIGHTWATER_SPLASH.get(),
                    this.sprite.get(random));
            particle.setColor(0.153F, 1, 0);
            return particle;
        }
    }

    public static class HangProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public HangProvider(SpriteSet sprite) {
            this.sprite = sprite;
        }

        @Override
        public Particle createParticle(
                SimpleParticleType particleType, @Nonnull ClientLevel level,
                double x, double y, double z,
                double xSpeed, double ySpeed, double zSpeed,
                @Nonnull RandomSource random) {
            var particle = new DripHangParticle(
                    level, x, y, z,
                    GSEFluids.BLIGHTWATER.get(), GSEParticles.BLIGHTWATER_FALL.get(),
                    this.sprite.get(random));
            particle.setColor(0.153F, 1, 0);
            return particle;
        }
    }

}
