package nightkosh.gravestone_extended.core;

import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.common.util.EnumHelper;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.config.ExtendedConfig;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSParticles {

    public static final int CATACOMBS_PORTAL_DEFAULT_ID = 1456278126;
    public static final int TOXIC_WATER_SPLASH_DEFAULT_ID = 1456278127;
    public static final int TOXIC_WATER_BUBBLE_DEFAULT_ID = 1456278128;
    public static final int TOXIC_WATER_WAKE_DEFAULT_ID = 1456278129;

    public static EnumParticleTypes CATACOMBS_PORTAL;
    public static EnumParticleTypes TOXIC_WATER_SPLASH;
    public static EnumParticleTypes TOXIC_WATER_BUBBLE;
    public static EnumParticleTypes TOXIC_WATER_WAKE;

    public static void registration() {
        Class<?>[] particlesParams = {
                String.class, int.class, boolean.class
        };

        CATACOMBS_PORTAL = EnumHelper.addEnum(EnumParticleTypes.class, "CATACOMBS_PORTAL", particlesParams, "catacombsPortal", ExtendedConfig.particleCatacombsPortalId, false);
        TOXIC_WATER_SPLASH = EnumHelper.addEnum(EnumParticleTypes.class, "TOXIC_WATER_SPLASH", particlesParams, "toxicWaterSplash", ExtendedConfig.particleToxicWaterSplashId, false);
        TOXIC_WATER_BUBBLE = EnumHelper.addEnum(EnumParticleTypes.class, "TOXIC_WATER_BUBBLE", particlesParams, "toxicWaterBubble", ExtendedConfig.particleToxicWaterBubbleId, false);
        TOXIC_WATER_WAKE = EnumHelper.addEnum(EnumParticleTypes.class, "TOXIC_WATER_WAKE", particlesParams, "toxicWaterWake", ExtendedConfig.particleToxicWaterWakeId, false);

        EnumParticleTypes.PARTICLES.put(CATACOMBS_PORTAL.getParticleID(), CATACOMBS_PORTAL);
        EnumParticleTypes.PARTICLES.put(TOXIC_WATER_SPLASH.getParticleID(), TOXIC_WATER_SPLASH);
        EnumParticleTypes.PARTICLES.put(TOXIC_WATER_BUBBLE.getParticleID(), TOXIC_WATER_BUBBLE);
        EnumParticleTypes.PARTICLES.put(TOXIC_WATER_WAKE.getParticleID(), TOXIC_WATER_WAKE);

        EnumParticleTypes.BY_NAME.put(CATACOMBS_PORTAL.getParticleName(), CATACOMBS_PORTAL);
        EnumParticleTypes.BY_NAME.put(TOXIC_WATER_SPLASH.getParticleName(), TOXIC_WATER_SPLASH);
        EnumParticleTypes.BY_NAME.put(TOXIC_WATER_BUBBLE.getParticleName(), TOXIC_WATER_BUBBLE);
        EnumParticleTypes.BY_NAME.put(TOXIC_WATER_WAKE.getParticleName(), TOXIC_WATER_WAKE);

        ModGravestoneExtended.proxy.registerParticles();
    }
}
