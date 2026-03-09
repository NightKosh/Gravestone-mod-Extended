package nightkosh.gravestone_extended.core.event;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.GSEEnchantments;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;
import nightkosh.gravestone_extended.helper.TimeHelper;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class TickEventHandler {

    private static short ticCount = 0;

    private static final short fogTicCount = 0;
    public static final short MAX_FOG_TICK_COUNT = 100;

    public static short getFogTicCount() {
        return fogTicCount;
    }

    @SubscribeEvent
    public static void onLevelTick(LevelTickEvent.Post event) {
        if (event.getLevel() instanceof ServerLevel level) {
            ticCount++;

            if (ticCount >= TimeHelper.SECONDS_25) {
                TimeHelper.updateIsGraveSpawnTime(level);
                ticCount = 0;
            }
        }
    }

    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof Player player &&
                !player.level().isClientSide() &&
                (player.tickCount % 40) == 0) {
                if (GSEConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("EntityTickEvent.Post event triggered. Going to spawn player gilded_sheen.");
                }
            var chestplate = player.getItemBySlot(EquipmentSlot.CHEST);

            if (!chestplate.isEmpty() && GSEEnchantmentHelper.enchanted(player.level(), GSEEnchantments.GILDED_SHEEN, chestplate)) {
                ((ServerLevel) player.level()).sendParticles(
                        ParticleTypes.GLOW,
                        player.getX(), player.getY() + 1, player.getZ(),
                        6,
                        0.3, 0.5, 0.3,
                        0
                );
            }

        }
    }

//TODO
//    @SubscribeEvent
//    @SideOnly(Side.CLIENT)
//    public void playerTick(TickEvent.PlayerTickEvent event) {
//        if (event.phase == TickEvent.Phase.END) {
//            if (event.player.equals(Minecraft.getMinecraft().player)) {
//                fogTicCount++;
//                if (fogTicCount > MAX_FOG_TICK_COUNT) {
//                    fogTicCount = 0;
//                    RenderEventHandler.resetAmountOfFogSources(event.player.getEntityWorld());
//                }
//            }
//        }
//    }
}
