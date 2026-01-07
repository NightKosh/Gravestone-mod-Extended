package nightkosh.gravestone_extended.item.corpse;

import com.mojang.authlib.GameProfile;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.entity.monster.pet.EnumUndeadMobType;
import nightkosh.gravestone_extended.helper.GameProfileHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class CorpseHelper {
//
//    public static EnumUndeadMobType getMobType(NBTTagCompound nbtTag) {
//        if (nbtTag == null) {
//            return EnumUndeadMobType.OTHER;
//        } else {
//            return EnumUndeadMobType.getById(nbtTag.getByte("MobType"));
//        }
//    }
//
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
//    protected static void spawnMob(EntityLiving entity, World world, int x, int y, int z) {
//        entity.setPosition(x + 0.5, y + 1, z + 0.5);
//        world.spawnEntity(entity);
//        entity.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 300));
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
//    public static ItemStack getDefaultCorpse(Random random, Block block, EnumCorpse corpseType) {
//        switch (corpseType) {
//            case VILLAGER:
//                return VillagerCorpseHelper.getRandomCorpse(random);
//            case DOG:
//                return DogCorpseHelper.getRandomCorpse(random);
//            case CAT:
//                return CatCorpseHelper.getRandomCorpse(random);
//            case HORSE:
//                return HorseCorpseHelper.getRandomCorpse(random);
//            default:
//                return new ItemStack(block, 1, corpseType.ordinal());
//        }
//    }
//
//    public static ItemStack getDefaultPlayerCorpse(GameProfile profile) {
//        return GameProfileHelper.getBlock(profile, GSBlock.CORPSE, EnumCorpse.STEVE.ordinal());
//    }
//
//    public static List<ItemStack> getDefaultCorpse(int corpseType) {
//        switch (EnumCorpse.values()[corpseType]) {
//            case ZOMBIE:
//                return ZombieCorpseHelper.getDefaultCorpses();
//            case SKELETON:
//                return SkeletonCorpseHelper.getDefaultCorpses();
//            case VILLAGER:
//                return VillagerCorpseHelper.getDefaultCorpses();
//            case ZOMBIE_VILLAGER:
//                return ZombieVillagerCorpseHelper.getDefaultCorpses();
//            case DOG:
//                return DogCorpseHelper.getDefaultCorpses();
//            case CAT:
//                return CatCorpseHelper.getDefaultCorpses();
//            case HORSE:
//                return HorseCorpseHelper.getDefaultCorpses();
//            default:
//                List<ItemStack> list = new ArrayList<>();
//                list.add(new ItemStack(GSBlock.CORPSE, 1, corpseType));
//                return list;
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
//    public static void spawnMob(int type, World world, int x, int y, int z, NBTTagCompound nbtTag, EntityPlayer player) {
//        if (!world.isRemote) {
//            switch (EnumCorpse.values()[type]) {
//                case VILLAGER:
//                    VillagerCorpseHelper.spawnVillager(world, x, y, z, nbtTag);
//                    break;
//                case HORSE:
//                    HorseCorpseHelper.spawnHorse(world, x, y, z, nbtTag, player);
//                    break;
//                case DOG:
//                    DogCorpseHelper.spawnDog(world, x, y, z, nbtTag, player);
//                    break;
//                case CAT:
//                    CatCorpseHelper.spawnCat(world, x, y, z, nbtTag, player);
//                    break;
//            }
//        }
//    }
//
//    public static boolean canSpawnMob(EntityPlayer player, ItemStack corpse) {
//        return EnumCorpse.getById((byte) corpse.getItemDamage()).canBeResurrected() &&
//                getMobType(corpse.getTagCompound()) == EnumUndeadMobType.OTHER && //TODO
//                player.getEntityWorld().getWorldInfo().getGameType().equals(GameType.CREATIVE) || player.experienceLevel >= getRequiredLevel(corpse.getItemDamage());
//    }
//
//    public static void getExperience(EntityPlayer player, int damage) {
//        player.addExperienceLevel(-getRequiredLevel(damage));
//    }
//
//    public static int getRequiredLevel(int damage) {
//        switch (EnumCorpse.getById((byte) damage)) {
//            case VILLAGER:
//                return 20;
//            case DOG:
//            case CAT:
//                return 7;
//            case HORSE:
//                return 15;
//            default:
//                return 0;
//        }
//    }
//
//    public static int getRequiredLevel(ItemStack itemStack) {
//        if (itemStack != null) {
//            return getRequiredLevel(itemStack.getItemDamage());
//        } else {
//            return 0;
//        }
//    }
//
//    public static EnumCorpse getTypeByCorpse(ItemStack corpse) {
//        if (corpse == null) {
//            return null;
//        } else {
//            return EnumCorpse.getById((byte) corpse.getItemDamage());
//        }
//    }
}
