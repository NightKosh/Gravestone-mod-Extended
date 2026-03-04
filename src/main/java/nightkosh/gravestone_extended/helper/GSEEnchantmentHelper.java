package nightkosh.gravestone_extended.helper;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import nightkosh.gravestone.helper.AdvancementsHelper;
import nightkosh.gravestone_extended.core.GSEAdvancements;
import nightkosh.gravestone_extended.core.GSEConfigs;
import nightkosh.gravestone_extended.core.GSEEnchantments;
import nightkosh.gravestone_extended.core.GSEItems;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEEnchantmentHelper {

    public static boolean isCurse(Holder<Enchantment> holder) {
        return holder.is(EnchantmentTags.CURSE);
    }

    public static int getLevel(Level level, ResourceKey<Enchantment> key, ItemStack item) {
        try {
            if (level == null || key == null || item == null) {
                return 0;
            } else {
                return EnchantmentHelper.getItemEnchantmentLevel(getEnchantmentHolder(level, key), item);
            }
        } catch (Exception e) {
            LOGGER.error("Cant get Enchantment", e);
            return 0;
        }
    }

    public static boolean enchanted(Level level, ResourceKey<Enchantment> key, ItemStack item) {
        return getLevel(level, key, item) > 0;
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

                if (event.getEntity() instanceof Player player) {
                    AdvancementsHelper.giveAdvancement(player, level, GSEAdvancements.BONE_RAIN);
                }
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

    public static ItemStack createSkull(Holder.Reference<Enchantment> reference, Item skull) {
        var itemstack = new ItemStack(skull);
        var enchantment = new EnchantmentInstance(reference, reference.value().getMaxLevel());
        itemstack.enchant(enchantment.enchantment(), enchantment.level());
        return itemstack;
    }

    public static List<Pair<Holder<Enchantment>, Integer>> getEnchantmentsWithLevel(ItemStack item) {
        List<Pair<Holder<Enchantment>, Integer>> enchList = new ArrayList<>();
        var enchants = EnchantmentHelper.getEnchantmentsForCrafting(item);
        enchants.keySet().forEach((enchantment) ->
                enchList.add(Pair.of(enchantment, enchants.getLevel(enchantment))));
        return enchList;
    }

    public static int getLevelsToDisenchant(List<Pair<Holder<Enchantment>, Integer>> enchList) {
        int requiredLevels = 0;
        if (!enchList.isEmpty()) {
            for (var enchantment : enchList) {
                requiredLevels += 1 + enchantment.getValue();
            }
        }
        return requiredLevels * 5;
    }

    public static int getLevelsToEnchant(ItemStack itemToEnchant, List<Pair<Holder<Enchantment>, Integer>> enchList) {
        int requiredLevels = 0;
        if (!enchList.isEmpty()) {
            for (var enchantment : enchList) {
                if (itemToEnchant.supportsEnchantment(enchantment.getKey())) {
                    requiredLevels += enchantment.getValue();
                }
            }
        }
        return requiredLevels * 5;
    }

    public static ItemStack transferEnchantmentToSkull(ItemStack skull, Pair<Holder<Enchantment>, Integer> enchantment) {
        var enchantedSkull = skull.is(Items.SKELETON_SKULL) ?
                new ItemStack(GSEItems.ENCHANTED_SKELETON_SKULL) :
                new ItemStack(GSEItems.ENCHANTED_WITHER_SKULL);
        enchantedSkull.enchant(enchantment.getKey(), enchantment.getValue());
        return enchantedSkull;
    }

    public static void transferEnchantmentToItem(ItemStack itemToEnchant, Pair<Holder<Enchantment>, Integer> enchantment) {
        if (itemToEnchant.supportsEnchantment(enchantment.getKey())) {
            itemToEnchant.enchant(enchantment.getKey(), enchantment.getValue());
        }
    }

}
