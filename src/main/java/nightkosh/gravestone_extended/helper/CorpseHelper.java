package nightkosh.gravestone_extended.helper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.village.ReputationEventType;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import nightkosh.gravestone_extended.core.GSEItems;
import nightkosh.gravestone_extended.core.GSEMobEffects;
import nightkosh.gravestone_extended.core.compatibility.SophisticatedWolvesCompatibility;

import java.util.function.BiConsumer;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class CorpseHelper {

    public static final String CUSTOM_NAME = "CUSTOM_NAME";
    public static final String WOLF_TYPE = "variant";
    public static final String WOLF_SOPHISTICATED = "SOPHISTICATED_WOLF";
    public static final String CAT_TYPE = "variant";
    public static final String MOB_DATA = "MOB_DATA";
    public static final String VILLAGER_DATA = "VillagerData";
    public static final String VILLAGER_PROFESSION = "profession";
    public static final String VILLAGER_LEVEL = "level";
    public static final String VILLAGER_OFFERS = "Offers";
    public static final String VILLAGER_OFFERS_RECIPES = "Recipes";
    public static final String VILLAGER_OFFERS_SELL = "sell";
    public static final String VILLAGER_OFFERS_ITEM_ID = "id";
    public static final String VILLAGER_OFFERS_ITEM_COMPONENTS = "components";
    public static final String VILLAGER_OFFERS_ITEM_ENCHANTMENTS = "minecraft:stored_enchantments";

    public static ItemStack addVillagerCorpse(Villager villager) {
        return getCorpse(
                villager,
                (tag, o) -> villager.addAdditionalSaveData(o),
                GSEItems.CORPSE_VILLAGER.get());
    }

    public static ItemStack addDogCorpse(Wolf wolf) {
        return getCorpse(
                wolf,
                (tag, o) -> {
                    wolf.addAdditionalSaveData(o);

                    if (SophisticatedWolvesCompatibility.loaded()) {
                        var type = SophisticatedWolvesCompatibility.getEntityType();
                        if (wolf.getType().equals(type)) {
                            tag.putBoolean(WOLF_SOPHISTICATED, true);
                        }
                    }
                },
                GSEItems.CORPSE_DOG.get());
    }

    public static ItemStack getCatCorpse(Cat cat) {
        return getCorpse(
                cat,
                (tag, o) -> cat.addAdditionalSaveData(o),
                GSEItems.CORPSE_CAT.get());
    }

    public static ItemStack getHorseCorpse(Horse horse) {
        return getCorpse(
                horse,
                (tag, o) -> horse.addAdditionalSaveData(o),
                GSEItems.CORPSE_HORSE.get());
    }

    private static ItemStack getCorpse(LivingEntity mob, BiConsumer<CompoundTag, TagValueOutput> consumer, Item corpseItem) {
        var tag = new CompoundTag();
        var output = TagValueOutput.createWithContext(
                ProblemReporter.DISCARDING,
                mob.level().registryAccess());
        consumer.accept(tag, output);

        var corpseData = output.buildResult();
        tag.put(MOB_DATA, corpseData);

        if (mob.hasCustomName()) {
            tag.putString(CUSTOM_NAME, mob.getCustomName().getString());
        }

        var corpse = new ItemStack(corpseItem);
        corpse.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));

        return corpse;
    }

    private static ValueInput readData(Level level, CompoundTag tag) {
        return TagValueInput.create(
                ProblemReporter.DISCARDING,
                level.registryAccess(),
                tag);
    }

    public static void spawnMob(ItemStack corpse, Level level, BlockPos pos, Player player) {
        try {
            EntityType entityType = null;
            if (corpse.is(GSEItems.CORPSE_VILLAGER)) {
                entityType = EntityType.VILLAGER;
            } else if (corpse.is(GSEItems.CORPSE_DOG)) {
                entityType = EntityType.WOLF;

                // Sophisticated Wolves
                if (SophisticatedWolvesCompatibility.loaded()) {
                    var data = corpse.get(DataComponents.CUSTOM_DATA);
                    if (data != null) {
                        var tag = data.copyTag();
                        var type = SophisticatedWolvesCompatibility.getEntityType();
                        if (type != null && tag.contains(WOLF_SOPHISTICATED)) {
                            entityType = type;
                        }
                    }
                }

            } else if (corpse.is(GSEItems.CORPSE_CAT)) {
                entityType = EntityType.CAT;
            } else if (corpse.is(GSEItems.CORPSE_HORSE)) {
                entityType = EntityType.HORSE;
            }

            if (entityType != null) {
                var mob = (LivingEntity) entityType.create(level, EntitySpawnReason.EVENT);
                var data = corpse.get(DataComponents.CUSTOM_DATA);
                if (data != null) {
                    var tag = data.copyTag();
                    if (tag.contains(MOB_DATA)) {
                        if (mob instanceof Villager villager) {
                            villager.readAdditionalSaveData(readData(level, tag.getCompound(MOB_DATA).get()));
                        } else if (mob instanceof Wolf wolf) {
                            wolf.readAdditionalSaveData(readData(level, tag.getCompound(MOB_DATA).get()));
                        } else if (mob instanceof Cat cat) {
                            cat.readAdditionalSaveData(readData(level, tag.getCompound(MOB_DATA).get()));
                        } else if (mob instanceof Horse horse) {//TODO AbstractHorse
                            horse.readAdditionalSaveData(readData(level, tag.getCompound(MOB_DATA).get()));
                        }
                    }

                    if (tag.contains(CUSTOM_NAME)) {
                        mob.setCustomName(Component.literal(tag.getStringOr(CUSTOM_NAME, "")));
                    }
                }
                // for creative items and any cases without data
                if (mob instanceof Villager villager) {
                    // increase reputation
                    villager.onReputationEventFrom(ReputationEventType.ZOMBIE_VILLAGER_CURED, player);
                } else if (mob instanceof Wolf wolf) {
                    wolf.tame(player);
                } else if (mob instanceof Cat cat) {
                    cat.tame(player);
                } else if (mob instanceof Horse horse) {
                    horse.setTamed(true);
                }

                mob.setHealth(mob.getMaxHealth());
                mob.snapTo(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
                mob.addEffect(new MobEffectInstance(MobEffects.REGENERATION, TimeHelper.SECONDS_15, 0));
                mob.addEffect(new MobEffectInstance(GSEMobEffects.PURIFICATION, TimeHelper.SECONDS_1, 0));

                level.addFreshEntity(mob);
            }
        } catch (Exception e) {
            LOGGER.error("Something went wrong at resurrection process", e);
        }
    }

    public static boolean canSpawnMob(Player player, ItemStack corpse) {
        return (corpse.is(GSEItems.CORPSE_VILLAGER) ||
                corpse.is(GSEItems.CORPSE_DOG) || corpse.is(GSEItems.CORPSE_CAT) ||
                corpse.is(GSEItems.CORPSE_HORSE)) &&
                (player.isCreative() || player.experienceLevel >= getRequiredLevel(corpse));
    }

    public static int getRequiredLevel(ItemStack stack) {
        if (stack.is(GSEItems.CORPSE_VILLAGER)) {
            return 20;
        } else if (stack.is(GSEItems.CORPSE_DOG) || stack.is(GSEItems.CORPSE_CAT)) {
            return 7;
        } else if (stack.is(GSEItems.CORPSE_HORSE)) {
            return 15;
        }
        return 0;
    }

}
