package nightkosh.gravestone_extended.core.event;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingShieldBlockEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.helper.GSEEnchantmentHelper;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@EventBusSubscriber(modid = ModInfo.ID)
public class GSEEventsHandler {

//    @SubscribeEvent(priority = EventPriority.HIGHEST)
//    public void onPlayerClone(PlayerEvent.Clone event) {
//        if (event.isWasDeath()) {
//            CemeteryHelper.cloneCemetery(event.getOriginal(), event.getEntity());
//        }
//    }
//
//    // Hopefully ensure we capture items before other things do (set to high so other mods can run before if they have more specialness
//    @SubscribeEvent(priority = EventPriority.LOWEST)
//    public void onEntityLivingDeath(LivingDeathEvent event) {
//        //TODO
////        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
////            if (event.getEntity() instanceof Creeper creeper && creeper.isPowered()) {
////                // drop creeper statue if entity is a charged creeper
////                GSBlock.MEMORIAL.dropCreeperMemorial(creeper.level(), creeper.blockPosition());
////            }
////        }
//    }
//
//    @SubscribeEvent(priority = EventPriority.HIGHEST)
//    public void breakBlockEvent(BlockEvent.BreakEvent event) {
//        //TODO
////        if (EnchantmentBloodyReplication.applyEffect(event.getPlayer(), event.getState(), event.getPos())) {
////            event.setCanceled(true);
////        }
//    }

    @SubscribeEvent
    public static void onLivingShieldBlockEvent(LivingShieldBlockEvent event) {
        if (event.getEntity() instanceof Player player) {
            var level = player.level();
            if (!level.isClientSide()) {
                if (GSEConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("LivingShieldBlockEvent event triggered for player: {}", player.getScoreboardName());
                }

                GSEEnchantmentHelper.applyMirrorOfPain(level, player, event.getDamageSource().getDirectEntity(), event.getOriginalBlockedDamage());
            }
        }
    }

//TODO
//    @SubscribeEvent(priority = EventPriority.HIGHEST)
//    public void onPlayerUpdate(LivingEvent event) {
//        if (event.getEntity() instanceof Player player && !player.level().isClientSide()) {
//            if (GSEConfigs.DEBUG_MODE.get()) {
//                LOGGER.info("LivingEvent event triggered by player {}", player.getScoreboardName());
//            }
//            EnchantmentFrozenNether.applyEffect(player);
//        }
//    }

//    @SubscribeEvent
//    public void livingUseItemEvent(LivingEntityUseItemEvent event) {
//        if (!event.getItem().isEmpty()) {
//            NBTTagList nbtList = event.getItem().getEnchantmentTagList();
//            for (NBTBase nbt : nbtList) {
//                if (GSEnchantmentHelper.hasEnchantment(nbt, GSEnchantment.CURSE_FRAGILITY)) {
//                    event.getItem().damageItem(2, event.getEntityLiving());
//                }
//            }
//        }
//    }

    @SubscribeEvent
    public static void onLivingHurt(LivingIncomingDamageEvent event) {
        var entity = event.getSource().getEntity();
        if (entity != null) {
            var level = entity.level();
            if (!level.isClientSide()) {
                if (GSEConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("LivingIncomingDamageEvent event triggered by entity {}", entity.getScoreboardName());
                }

                if (entity instanceof Player player) {
                    if (GSEEnchantmentHelper.applyAwkwardCurse(level, event.getSource().getWeaponItem(), player, event)) {
                        return;
                    }
                    GSEEnchantmentHelper.applyVampiricTouch(level, event.getSource().getWeaponItem(), player, event.getAmount());
                    GSEEnchantmentHelper.applyPoisonedBlade(level, event.getSource().getWeaponItem(), event.getEntity(), player);
                    GSEEnchantmentHelper.applyWitheredBlade(level, event.getSource().getWeaponItem(), event.getEntity(), player);
                }
            }
        }
    }

//    @SubscribeEvent(priority = EventPriority.HIGH)
//    public void onEntityLivingDamage(LivingDamageEvent event) {
//        if (event) {
//            Entity entity = event.getSource().getTrueSource();
//            if (entity instanceof LivingEntity attacker && event.getEntity() instanceof LivingEntity targert) {
//                ItemStack itemMainHand = attacker.getHeldItemMainhand();
//                ItemStack itemOffHand = attacker.getHeldItemOffhand();
//                if (itemMainHand.getItem() instanceof IBoneSword) {
//                    applyEntityLivingDamageEnchantments(attacker, targert, itemMainHand, event.getAmount());
//                } else if (itemOffHand.getItem() instanceof IBoneSword) {
//                    applyEntityLivingDamageEnchantments(attacker, targert, itemOffHand, event.getAmount());
//                }
//            }
//        }
//    }
//TODO
//    @SubscribeEvent(priority = EventPriority.HIGH)
//    public void onProjectileImpact(ProjectileImpactEvent.Throwable event) {
//        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
//            if (event.getThrowable() instanceof EntityPotion) {
//                EntityPotion entityPotion = (EntityPotion) event.getThrowable();
//                PotionType potionType = PotionUtils.getPotionFromItem(entityPotion.getPotion());
//
//                if (potionType == GSPotion.PURIFICATION_TYPE) {
//                    PotionPurification.applyPotionOnBlocks(entityPotion);
//                }
//            }
//        }
//    }

//    @SubscribeEvent
//    public void lootLoad(LootTableLoadEvent event) {
//        //TODO
////        GSLootTables.inject(event);
//    }

}
