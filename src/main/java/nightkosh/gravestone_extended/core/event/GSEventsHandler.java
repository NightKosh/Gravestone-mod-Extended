package nightkosh.gravestone_extended.core.event;

import net.minecraft.block.material.Material;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.ItemFishedEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.capability.ChokeProvider;
import nightkosh.gravestone_extended.capability.IChoke;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.GSEnchantment;
import nightkosh.gravestone_extended.core.GSPotion;
import nightkosh.gravestone_extended.core.MobSpawn;
import nightkosh.gravestone_extended.enchantment.EnchantmentBloodyReplication;
import nightkosh.gravestone_extended.enchantment.EnchantmentNecroticCorrosion;
import nightkosh.gravestone_extended.enchantment.EnchantmentPainMirror;
import nightkosh.gravestone_extended.enchantment.EnchantmentVampiricTouch;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentAwkwardCurse;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentBrokenHookCurse;
import nightkosh.gravestone_extended.enchantment.curse.EnchantmentStarvationCurse;
import nightkosh.gravestone_extended.entity.monster.crawler.EntitySkullCrawler;
import nightkosh.gravestone_extended.entity.monster.crawler.EntityStraySkullCrawler;
import nightkosh.gravestone_extended.entity.monster.crawler.EntityWitherSkullCrawler;
import nightkosh.gravestone_extended.entity.monster.crawler.EntityZombieSkullCrawler;
import nightkosh.gravestone_extended.entity.projectile.EntityCustomFishHook;
import nightkosh.gravestone_extended.item.weapon.IBoneShiled;
import nightkosh.gravestone_extended.item.weapon.IBoneSword;
import nightkosh.gravestone_extended.item.weapon.ItemBoneShield;
import nightkosh.gravestone_extended.potion.PotionBleeding;
import nightkosh.gravestone_extended.potion.PotionPurification;
import org.lwjgl.opengl.GL11;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEventsHandler {

    // Hopefully ensure we capture items before other things do (set to high so other mods can run before if they have more specialness
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onEntityLivingDeath(LivingDeathEvent event) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            if (ExtendedConfig.spawnSkullCrawlersAtMobsDeath) {
                if (event.getEntity() instanceof AbstractSkeleton) {
                    EntitySkullCrawler crawler;
                    if (MobSpawn.isWitherSkeleton((AbstractSkeleton) event.getEntity())) {
                        crawler = new EntityWitherSkullCrawler(event.getEntity().getEntityWorld());
                    } else if (MobSpawn.isStraySkeleton((AbstractSkeleton) event.getEntity())) {
                        crawler = new EntityStraySkullCrawler(event.getEntity().getEntityWorld());
                    } else {
                        crawler = new EntitySkullCrawler(event.getEntity().getEntityWorld());
                    }
                    MobSpawn.spawnCrawler(event.getEntity(), crawler);
                } else if (event.getEntity() instanceof EntityZombie) {
                    MobSpawn.spawnCrawler(event.getEntity(), new EntityZombieSkullCrawler(event.getEntity().getEntityWorld()));
                }
            }
            if (event.getEntity() instanceof EntityCreeper && ((EntityCreeper) event.getEntity()).getPowered()) {
                // drop creeper statue if entity is a charged creeper
                GSBlock.MEMORIAL.dropCreeperMemorial(event.getEntity().getEntityWorld(), new BlockPos(event.getEntity()));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void breakBlockEvent(BlockEvent.BreakEvent event) {
        if (EnchantmentBloodyReplication.applyEffect(event.getPlayer(), event.getState(), event.getPos())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void livingDamageEvent(LivingDamageEvent event) {
        if (EnchantmentAwkwardCurse.applyCurseEffect(event.getSource(), event.getEntityLiving(), event.getAmount())) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public void livingAttackEvent(LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            ItemStack stack = player.getActiveItemStack();
            if (!stack.isEmpty() && stack.getItem() instanceof IBoneShiled) {
                float amount = event.getAmount();

                EnchantmentPainMirror.applyEnchantmentEffect(player, event.getSource().getTrueSource(), stack, amount);

                if (event.getAmount() >= 3)
                    ((ItemBoneShield) stack.getItem()).damageShield(stack, player, amount);
            }
        }
    }

    @SubscribeEvent
    public void livingUpdateEvent(LivingEvent.LivingUpdateEvent event) {
        if (event.getEntityLiving() != null && event.getEntityLiving() instanceof EntityPlayer) {
            EnchantmentStarvationCurse.applyCurseEffect((EntityPlayer) event.getEntityLiving());
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void livingHealEvent(LivingHealEvent event) {
        if (PotionBleeding.hasPotion(event.getEntityLiving())) {
            event.setCanceled(true);
        }
    }

//    @SubscribeEvent
//    public void livingUseItemEvent(LivingEntityUseItemEvent event) {
//        if (!event.getItem().isEmpty()) {
//            NBTTagList nbtList = event.getItem().getEnchantmentTagList();
//            for (NBTBase nbt : nbtList) {
//                if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.CURSE_FRAGILITY)) {
//                    event.getItem().damageItem(2, event.getEntityLiving());
//                }
//            }
//        }
//    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void itemFishedEvent(ItemFishedEvent event) {
        ItemStack stack = event.getEntityPlayer().getHeldItemMainhand();

        if (!stack.isEmpty()) {
            NBTTagList nbtList = stack.getEnchantmentTagList();
            for (NBTBase nbt : nbtList) {
                if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.CURSE_BROKEN_HOOK)) {
                    if (EnchantmentBrokenHookCurse.cancelFishing()) {
                        event.setCanceled(true);
                    }
                    break;
                }
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void entityJoinWorldEvent(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();

        if (ExtendedConfig.overrideVanillaFishing && entity instanceof EntityFishHook && entity.getClass().equals(EntityFishHook.class)) {
            World world = event.getWorld();
            if (!world.isRemote) {
                EntityPlayer player = ((EntityFishHook) entity).getAngler();
                ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
                if (stack.getItem() != Items.FISHING_ROD) {
                    stack = player.getHeldItem(EnumHand.OFF_HAND);
                }
                entity.setDead();

                EntityCustomFishHook hook = new EntityCustomFishHook(world, player);

                int speed = EnchantmentHelper.getFishingSpeedBonus(stack);
                if (speed > 0) {
                    hook.setLureSpeed(speed);
                }
                int luck = EnchantmentHelper.getFishingLuckBonus(stack);
                if (luck > 0) {
                    hook.setLuck(luck);
                }

                world.spawnEntity(hook);

                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onEntityLivingDamage(LivingDamageEvent event) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            Entity entity = event.getSource().getTrueSource();
            if (entity instanceof EntityLivingBase && event.getEntity() instanceof EntityLivingBase) {
                EntityLivingBase attacker = (EntityLivingBase) entity;
                ItemStack itemMainHand = attacker.getHeldItemMainhand();
                ItemStack itemOffHand = attacker.getHeldItemOffhand();
                if (itemMainHand.getItem() instanceof IBoneSword) {
                    applyEntityLivingDamageEnchantments(attacker, (EntityLivingBase) event.getEntity(), itemMainHand, event.getAmount());
                } else if (itemOffHand.getItem() instanceof IBoneSword) {
                    applyEntityLivingDamageEnchantments(attacker, (EntityLivingBase) event.getEntity(), itemOffHand, event.getAmount());
                }
            }
        }
    }

    private static void applyEntityLivingDamageEnchantments(EntityLivingBase attacker, EntityLivingBase target, ItemStack weapon, float damage) {
        NBTTagList nbtList = weapon.getEnchantmentTagList();
        for (NBTBase nbt : nbtList) {
            if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.VAMPIRIC_TOUCH)) {
                EnchantmentVampiricTouch.applyEnchantmentEffect(attacker, damage);
            } else if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(GSEnchantment.NECROTIC_CORROSION)) {
                EnchantmentNecroticCorrosion.applyEnchantmentEffect(target, damage, ((NBTTagCompound) nbt).getShort("lvl"));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void onProjectileImpact(ProjectileImpactEvent.Throwable event) {
        if (FMLCommonHandler.instance().getEffectiveSide().isServer()) {
            if (event.getThrowable() instanceof EntityPotion) {
                EntityPotion entityPotion = (EntityPotion) event.getThrowable();
                PotionType potionType = PotionUtils.getPotionFromItem(entityPotion.getPotion());

                if (potionType == GSPotion.PURIFICATION_TYPE) {
                    PotionPurification.applyPotionOnBlocks(entityPotion);
                }
            }
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onTick(RenderGameOverlayEvent.Pre event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.AIR) {

            EntityPlayer player = FMLClientHandler.instance().getClient().player;
            IChoke choke = player.getCapability(ChokeProvider.AIR_CAP, null);
            int air = choke.getAir();

            if (choke.isActive() && !player.isInsideOfMaterial(Material.WATER)) {
                final ScaledResolution res = new ScaledResolution(FMLClientHandler.instance().getClient());
                GL11.glEnable(GL11.GL_BLEND);

                final int left = res.getScaledWidth() / 2 + 91;
                final int top = res.getScaledHeight() - 49;
                final int full = MathHelper.ceil((air - 2) * 10 / 300D);
                final int partial = MathHelper.ceil(air * 10 / 300D) - full;

                for (int i = 0; i < full + partial; i++) {
                    FMLClientHandler.instance().getClient().ingameGUI.drawTexturedModalRect(left - i * 8 - 9, top, (i < full ? 16 : 25), 18, 9, 9);
                }
                GL11.glDisable(GL11.GL_BLEND);
            }
        }
    }
}
