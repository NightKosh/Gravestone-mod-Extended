package nightkosh.gravestone_extended.helper;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.GSEEnchantments;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEEnchantmentHelper {

    public static int getLevel(Level level, ResourceKey<Enchantment> key, ItemStack item) {
        return EnchantmentHelper.getItemEnchantmentLevel(getEnchantmentHolder(level, key), item);
    }

    public static boolean enchanted(Level level, ResourceKey<Enchantment> key, ItemStack item) {
        return getLevel(level, key, item) > 0;
    }

    public static boolean enchanted(Holder<Enchantment> enchantment, ItemStack item) {
        return EnchantmentHelper.getItemEnchantmentLevel(enchantment, item) > 0;
    }

    public static Holder<Enchantment> getEnchantmentHolder(Level level, ResourceKey<Enchantment> key) {
        return level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(key);
    }

    public static void applyBoneRain(Level level, ItemStack stack, PlayerInteractEvent.RightClickBlock event) {
        if (enchanted(level, GSEEnchantments.BONE_RAIN, stack)) {
            var pos = event.getPos();
            var state = level.getBlockState(pos);
            if (event.getEntity().isCrouching() || !(
                    state.is(Blocks.DIRT) || state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT_PATH) ||
                            state.is(Blocks.COARSE_DIRT) || state.is(Blocks.ROOTED_DIRT) ||
                            state.is(Blocks.FARMLAND))) {
                if (GSEConfigs.DEBUG_MODE.get()) {
                    LOGGER.info("Going to apply BONE_RAIN enchantment on pos {}", pos.toShortString());
                }
                stack.setDamageValue(stack.getDamageValue() + 1);
                level.levelEvent(1505, pos, 15);
                BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), level, pos, event.getEntity());
            }
        }
    }

    public static boolean applyAwkwardCurse(Level level, ItemStack weapon, Player player, LivingIncomingDamageEvent event) {
        if (enchanted(level, GSEEnchantments.CURSE_OF_AWKWARDNESS, weapon) && player.getRandom().nextInt(10) == 0) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to cancel player {} attack due to CURSE_OF_AWKWARDNESS", player.getScoreboardName());
            }
            event.setCanceled(true);
            return true;
        }
        return false;
    }

    public static void applyVampiricTouch(Level level, ItemStack weapon, Player player, float damage) {
        if (enchanted(level, GSEEnchantments.VAMPIRIC_TOUCH, weapon)) {
            float healed = damage * 0.1F;
            if (healed < 0.5) {
                healed = 0.5F;
            }
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to heal {} health player {} by VAMPIRIC_TOUCH", healed, player.getScoreboardName());
            }
            player.heal(healed);
        }
    }

    public static void applyPoisonedBlade(Level level, ItemStack weapon, LivingEntity target, Player player) {
        var lvl = getLevel(level, GSEEnchantments.POISONED_BLADE, weapon);
        if (lvl > 0) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to apply POISONED_BLADE effect on {} by player {} by VAMPIRIC_TOUCH",
                        target.getScoreboardName(),
                        player.getScoreboardName());
            }
            target.addEffect(new MobEffectInstance(MobEffects.POISON, lvl * 200), player);
        }
    }

    public static void applyWitheredBlade(Level level, ItemStack weapon, LivingEntity target, Player player) {
        var lvl = getLevel(level, GSEEnchantments.WITHERED_BLADE, weapon);
        if (lvl > 0) {
            if (GSEConfigs.DEBUG_MODE.get()) {
                LOGGER.info("Going to apply WITHERED_BLADE effect on {} by player {} by VAMPIRIC_TOUCH",
                        target.getScoreboardName(),
                        player.getScoreboardName());
            }
            target.addEffect(new MobEffectInstance(MobEffects.WITHER, lvl * 100), player);
        }
    }

    public static void applyMirrorOfPain(Level level, Player player, Entity attacker, float damage) {
        if (attacker instanceof LivingEntity attackerEntity) {
            var stack = player.getActiveItem();
            if (!stack.isEmpty()) {
                var lvl = getLevel(level, GSEEnchantments.MIRROR_OF_PAIN, stack);
                if (damage > 0 && level.random.nextInt(10) < lvl) {
                    if (GSEConfigs.DEBUG_MODE.get()) {
                        LOGGER.info("Going to reflect {} damage to {} entity", damage, player.getScoreboardName());
                    }
                    attackerEntity.hurt(level.damageSources().magic(), damage);
                }
            }
        }
    }

//
//    public static boolean hasEnchantment(NBTBase nbt, Enchantment enchantment) {
//        return ((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(enchantment);
//    }
//
//    public static short getEnchantmentLevel(ItemStack stack, Enchantment enchantment) {
//        if (stack != null && stack != ItemStack.EMPTY) {
//            NBTTagList nbtList = stack.getEnchantmentTagList();
//            for (NBTBase nbt : nbtList) {
//                if (((NBTTagCompound) nbt).getInteger("id") == Enchantment.getEnchantmentID(enchantment)) {
//                    return ((NBTTagCompound) nbt).getShort("lvl");
//                }
//            }
//        }
//        return 0;
//    }
//
//    public static Map<Enchantment, Integer> getSkullEnchantments(ItemStack skull) {
//        Map<Enchantment, Integer> map = new HashMap<>();
//        if (skull.hasTagCompound()) {
//            addEnchantmentsToMap(map, skull.getTagCompound(), "StoredEnchantments");
//            addEnchantmentsToMap(map, skull.getTagCompound(), "ench");
//        }
//
//        return map;
//    }
//
//    private static void addEnchantmentsToMap(Map<Enchantment, Integer> map, NBTTagCompound nbt, String tagName) {
//        NBTTagList list = nbt.getTagList(tagName, 10);
//        for (int i = 0; i < list.tagCount(); i++) {
//            NBTTagCompound enchantmentTag = list.getCompoundTagAt(i);
//            map.put(Enchantment.getEnchantmentByID(enchantmentTag.getShort("id")), (int) enchantmentTag.getShort("lvl"));
//        }
//    }
}
