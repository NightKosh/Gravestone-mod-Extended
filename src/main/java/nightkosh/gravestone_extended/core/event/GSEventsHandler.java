package nightkosh.gravestone_extended.core.event;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.ItemFishedEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import nightkosh.gravestone_extended.core.*;
import nightkosh.gravestone_extended.enchantment.*;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentAwkwardCurse;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentBrokenHookCurse;
import nightkosh.gravestone_extended.helper.CemeteryHelper;
import nightkosh.gravestone_extended.helper.GSEnchantmentHelper;
import nightkosh.gravestone_extended.item.weapon.IBoneSword;
import nightkosh.gravestone_extended.potion.PotionPurification;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEventsHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            CemeteryHelper.cloneCemetery(event.getOriginal(), event.getEntity());
        }
    }

    // Hopefully ensure we capture items before other things do (set to high so other mods can run before if they have more specialness
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onEntityLivingDeath(LivingDeathEvent event) {
        //TODO
//        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
//            if (event.getEntity() instanceof Creeper creeper && creeper.isPowered()) {
//                // drop creeper statue if entity is a charged creeper
//                GSBlock.MEMORIAL.dropCreeperMemorial(creeper.level(), creeper.blockPosition());
//            }
//        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void breakBlockEvent(BlockEvent.BreakEvent event) {
        //TODO
//        if (EnchantmentBloodyReplication.applyEffect(event.getPlayer(), event.getState(), event.getPos())) {
//            event.setCanceled(true);
//        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void livingDamageEvent(LivingDamageEvent event) {
        //TODO
//        if (EnchantmentAwkwardCurse.applyCurseEffect(event.getSource(), event.getEntityLiving(), event.getAmount())) {
//            event.setCanceled(true);
//        }
    }
//TODO
//    @SubscribeEvent
//    public void livingAttackEvent(LivingAttackEvent event) {
//        if (event.getEntityLiving() instanceof Player player) {
//            EnchantmentPainMirror.applyEffect(player, event.getSource().getTrueSource(), event.getAmount());
//        }
//    }
//
//    @SubscribeEvent(priority = EventPriority.HIGHEST)
//    public void onPlayerUpdate(LivingEvent.LivingUpdateEvent event) {
//        if (event.getEntityLiving() instanceof Player player) {
//            EnchantmentFrozenNether.applyEffect(player);
//            EnchantmentWebCrawler.applyEffect(player);
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

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void itemFishedEvent(ItemFishedEvent event) {
        //TODO
//        EnchantmentBrokenHookCurse.applyEffect(event);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onEntityLivingDamage(LivingDamageEvent event) {
        //TODO
//        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
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
    }
//TODO
//    private static void applyEntityLivingDamageEnchantments(LivingEntity attacker, LivingEntity target, ItemStack weapon, float damage) {
//        NBTTagList nbtList = weapon.getEnchantmentTagList();
//        for (NBTBase nbt : nbtList) {
//            if (GSEnchantmentHelper.hasEnchantment(nbt, GSEnchantment.VAMPIRIC_TOUCH)) {
//                EnchantmentVampiricTouch.applyEnchantmentEffect(attacker, damage);
//            } else if (GSEnchantmentHelper.hasEnchantment(nbt, GSEnchantment.NECROTIC_CORROSION)) {
//                EnchantmentNecroticCorrosion.applyEnchantmentEffect(target, damage, ((NBTTagCompound) nbt).getShort("lvl"));
//            }
//        }
//    }
//
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

    @SubscribeEvent
    public void lootLoad(LootTableLoadEvent event) {
        //TODO
//        GSLootTables.inject(event);
    }

}
