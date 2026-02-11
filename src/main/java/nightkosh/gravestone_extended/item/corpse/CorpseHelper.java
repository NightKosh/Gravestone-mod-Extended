package nightkosh.gravestone_extended.item.corpse;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.equine.Horse;
import net.minecraft.world.entity.animal.feline.Cat;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import nightkosh.gravestone_extended.core.GSEItems;
import nightkosh.gravestone_extended.helper.TimeHelper;

import static nightkosh.gravestone_extended.ModGravestoneExtended.LOGGER;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class CorpseHelper {

//    public static void addMobTypeInfo(List list, NBTTagCompound nbtTag) {
//        if (nbtTag.hasKey("MobType")) {
//            EnumUndeadMobType mobType = getMobType(nbtTag);
//            if (mobType != EnumUndeadMobType.OTHER) {
//                list.add(ModGravestoneExtended.proxy.getLocalizedString("mobtype.title") + " - " + mobType.getLocalizedName());
//            }
//        }
//    }
//
//    protected static void setMobName(EntityLiving entity, NBTTagCompound nbtTag) {
//        if (nbtTag.hasKey("Name") && nbtTag.getString("Name").length() != 0) {
//            entity.setCustomNameTag(nbtTag.getString("Name"));
//        }
//    }
//
//    protected static void setName(EntityLiving entity, NBTTagCompound nbtTag) {
//        if (entity.hasCustomName()) {
//            nbtTag.setString("Name", entity.getCustomNameTag());
//        }
//    }
//
//    protected static void addNameInfo(List list, NBTTagCompound nbtTag) {
//        if (nbtTag.hasKey("Name") && nbtTag.getString("Name").length() != 0) {
//            list.add(ModGravestoneExtended.proxy.getLocalizedString("item.corpse.entity_name") + " " + nbtTag.getString("Name"));
//        }
//    }
//
//    public static void addInfo(int corpseType, List list, NBTTagCompound nbtTag) {
//        switch (EnumCorpse.values()[corpseType]) {
//            case VILLAGER:
//                VillagerCorpseHelper.addInfo(list, nbtTag);
//                break;
//            case ZOMBIE_VILLAGER:
//                VillagerCorpseHelper.addInfo(list, nbtTag);
//                break;
//            case HORSE:
//                HorseCorpseHelper.addInfo(list, nbtTag);
//                break;
//            case DOG:
//                DogCorpseHelper.addInfo(list, nbtTag);
//                break;
//            case CAT:
//                CatCorpseHelper.addInfo(list, nbtTag);
//                break;
//            case ZOMBIE:
//            case SKELETON:
//                addMobTypeInfo(list, nbtTag);
//                break;
//        }
//    }
//
//    public static List<ItemStack> getCorpse(Entity entity, EnumCorpse type) {
//        NBTTagCompound nbtTag = new NBTTagCompound();
//        switch (type) {
//            case VILLAGER:
//                VillagerCorpseHelper.setNbt((EntityVillager) entity, nbtTag);
//                break;
//            case HORSE:
//                HorseCorpseHelper.setNbt((AbstractHorse) entity, nbtTag);
//                break;
//            case DOG:
//                DogCorpseHelper.setNbt((EntityWolf) entity, nbtTag);
//                break;
//            case CAT:
//                CatCorpseHelper.setNbt((EntityOcelot) entity, nbtTag);
//                break;
//        }
//
//        List<ItemStack> corpse = new ArrayList<>();
//        ItemStack stack = new ItemStack(GSBlock.CORPSE, 1, type.ordinal());
//        stack.setTagCompound(nbtTag);
//        corpse.add(stack);
//        return corpse;
//    }
//
    public static CompoundTag addData(Wolf pet) {
        var output = TagValueOutput.createWithContext(
                ProblemReporter.DISCARDING,
                pet.level().registryAccess());
        pet.addAdditionalSaveData(output);
        return output.buildResult();
    }

    private static ValueInput readData(Level level, CompoundTag tag) {
        return TagValueInput.create(
                ProblemReporter.DISCARDING,
                level.registryAccess(),
                tag);
    }

    private static final String MOB_INFO = "MOB_INFO";
    public static void spawnMob(ItemStack corpse, Level level, BlockPos pos, Player player) {
        try {
            EntityType entityType = null;
            if (corpse.is(GSEItems.CORPSE_VILLAGER)) {
                entityType = EntityType.VILLAGER;
            } else if (corpse.is(GSEItems.CORPSE_DOG)) {
                entityType = EntityType.WOLF;
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
                    if (tag.contains(MOB_INFO)) {
                        if (mob instanceof Villager villager) {
                            villager.readAdditionalSaveData(readData(level, tag.getCompound(MOB_INFO).get()));
                        } else if (mob instanceof Wolf wolf) {
                            wolf.readAdditionalSaveData(readData(level, tag.getCompound(MOB_INFO).get()));
                        } else if (mob instanceof Cat cat) {
                            cat.readAdditionalSaveData(readData(level, tag.getCompound(MOB_INFO).get()));
                        } else if (mob instanceof Horse horse) {//TODO AbstractHorse
                            horse.readAdditionalSaveData(readData(level, tag.getCompound(MOB_INFO).get()));
                        }
                    }
                }
                // for creative items and any cases without data
                if (mob instanceof Wolf wolf) {
                    wolf.tame(player);
                } else if (mob instanceof Cat cat) {
                    cat.tame(player);
                } else if (mob instanceof Horse horse) {
                    horse.setTamed(true);
                }

                mob.snapTo(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 0);
                mob.addEffect(new MobEffectInstance(MobEffects.REGENERATION, TimeHelper.SECONDS_15, 0));

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
