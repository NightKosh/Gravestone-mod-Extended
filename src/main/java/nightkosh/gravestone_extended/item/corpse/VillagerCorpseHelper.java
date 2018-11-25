package nightkosh.gravestone_extended.item.corpse;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.block.enums.EnumCorpse;
import nightkosh.gravestone_extended.core.GSBlock;
import nightkosh.gravestone_extended.core.compatibility.Compatibility;
import nightkosh.gravestone_extended.core.compatibility.CompatibilitySophisticatedWolves;
import nightkosh.gravestone_extended.core.compatibility.forestry.CompatibilityForestry;
import nightkosh.gravestone_extended.core.logger.GSLogger;
import nightkosh.gravestone_extended.structures.village.VillagersHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class VillagerCorpseHelper extends CorpseHelper {
    private static final Random RANDOM = new Random();

    private static final int CORPSE_TYPE = EnumCorpse.VILLAGER.ordinal();

    private static List<ItemStack> DEFAULT_CORPSE_LIST;

    public static ItemStack getRandomCorpse(Random random) {
        List<ItemStack> corpses = getDefaultCorpses();
        return corpses.get(random.nextInt(corpses.size()));
    }

    public static List<ItemStack> getDefaultCorpses() {
        if (DEFAULT_CORPSE_LIST == null) {
            DEFAULT_CORPSE_LIST = new ArrayList<>();

            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(0, 1)); // Farmer - farmer
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(0, 2)); // Farmer - fisherman
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(0, 3)); // Farmer - shepherd
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(0, 4)); // Farmer - fletcher
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(1, 1)); // Librarian - librarian
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(1, 2)); // Librarian - cartographer
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(2, 1)); // Priest - cleric
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(3, 1)); // Smith - armor
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(3, 2)); // Smith - weapon
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(3, 3)); // Smith - tool
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(4, 1)); // Butcher - butcher
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(4, 2)); // Butcher - leather
            DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(5, 1)); // Nitwit - nitwit

            List<VillagerRegistry.VillagerProfession> villagers = ForgeRegistries.VILLAGER_PROFESSIONS.getValues();
            for (VillagerRegistry.VillagerProfession villagerProfession : villagers) {
                List<VillagerRegistry.VillagerCareer> careersList = ReflectionHelper.getPrivateValue(VillagerRegistry.VillagerProfession.class, villagerProfession, "careers");
                if (!careersList.isEmpty()) {
                    DEFAULT_CORPSE_LIST.add(getDefaultVillagerCorpse(VillagerRegistry.getId(villagerProfession), villagerProfession.getRandomCareer(RANDOM)));
                }
            }
        }
        return DEFAULT_CORPSE_LIST;
    }

    private static ItemStack getDefaultVillagerCorpse(int profession, int career) {
        ItemStack corpse = new ItemStack(GSBlock.CORPSE, 1, CORPSE_TYPE);

        NBTTagCompound nbtTag = new NBTTagCompound();
        nbtTag.setInteger("Profession", profession);
        nbtTag.setInteger("Career", career);
        nbtTag.setInteger("CareerLevel", 1);

        corpse.setTagCompound(nbtTag);
        return corpse;
    }

    public static void setNbt(EntityVillager villager, NBTTagCompound nbt) {
        setName(villager, nbt);

        NBTTagCompound villagerNbt = new NBTTagCompound();
        villager.writeEntityToNBT(villagerNbt);
        nbt.setInteger("Profession", villagerNbt.getInteger("Profession"));
        nbt.setInteger("Career", villagerNbt.getInteger("Career"));
        nbt.setInteger("CareerLevel", villagerNbt.getInteger("CareerLevel"));

        MerchantRecipeList recipes = villager.getRecipes(null);
        if (recipes != null) {
            try {
                MerchantRecipe recipe;
                NBTTagCompound recipeTag;
                for (Object recipe1 : recipes) {
                    try {
                        recipe = (MerchantRecipe) recipe1;
                        if (recipe != null &&
                                recipe.getItemToSell() != null && !recipe.getItemToSell().isEmpty() &&
                                recipe.getItemToBuy() != null && !recipe.getItemToBuy().isEmpty() &&
                                recipe.getSecondItemToBuy() != null) {
                            recipeTag = recipe.writeToTags();
                            recipeTag.setInteger("uses", 0);
                            recipeTag.setInteger("maxUses", 7);
                            recipe.readFromTags(recipeTag);
                        }
                    } catch (Exception e) {
                        GSLogger.logError("Can't read villager trades!");
                    }
                }
                nbt.setTag("Offers", recipes.getRecipiesAsTags());
            } catch (Exception e) {
                GSLogger.logError("Can't store villager trades!");
            }
        }
    }

    public static void spawnVillager(World world, int x, int y, int z, NBTTagCompound nbtTag) {
        EntityVillager villager = new EntityVillager(world, getVillagerType(nbtTag));
        setMobName(villager, nbtTag);

        NBTTagCompound nbt = new NBTTagCompound();
        villager.writeEntityToNBT(nbt);
        nbt.setInteger("Career", nbtTag.getInteger("Career"));
        nbt.setInteger("CareerLevel", nbtTag.getInteger("CareerLevel"));
        if (nbtTag.hasKey("Offers")) {
            nbt.setTag("Offers", nbtTag.getCompoundTag("Offers"));
        }
        villager.readEntityFromNBT(nbt);

        spawnMob(villager, world, x, y, z);
    }

    public static int getVillagerType(NBTTagCompound nbtTag) {
        return nbtTag.getInteger("Profession");
    }

    public static int getVillagerCareer(NBTTagCompound nbtTag) {
        return nbtTag.getInteger("Career");
    }

    public static void addInfo(List list, NBTTagCompound nbtTag) {
        addNameInfo(list, nbtTag);
        if (hasProfession(nbtTag)) {
            list.add(getProfession(nbtTag));
            if (hasCareer(nbtTag)) {
                String career = getCareer(nbtTag);
                if (StringUtils.isNotBlank(career)) {
                    list.add(getCareer(nbtTag));
                }
            }
        }
        if (hasTrades(nbtTag)) {
            addTrades(list, nbtTag);
        }
    }

    private static boolean hasProfession(NBTTagCompound nbtTag) {
        return nbtTag.hasKey("Profession");
    }

    private static String getProfession(NBTTagCompound nbtTag) {
        return ModGravestoneExtended.proxy.getLocalizedString("item.corpse.villager_type") + " - " +
                ModGravestoneExtended.proxy.getLocalizedString(getVillagerProfession(getVillagerType(nbtTag)));
    }

    private static boolean hasCareer(NBTTagCompound nbtTag) {
        return nbtTag.hasKey("Career");
    }

    private static String getCareer(NBTTagCompound nbtTag) {
        String career = getVillagerCareerStr(getVillagerType(nbtTag), getVillagerCareer(nbtTag));
        if (StringUtils.isBlank(career)) {
            return "";
        } else {
            return ModGravestoneExtended.proxy.getLocalizedString("item.corpse.villager_career") + " - " +
                    ModGravestoneExtended.proxy.getLocalizedString(career);
        }
    }

    private static String getVillagerProfession(int type) {
        switch (type) {
            case 0:
                return "item.corpse.villager_type.farmer";
            case 1:
                return "item.corpse.villager_type.librarian";
            case 2:
                return "item.corpse.villager_type.priest";
            case 3:
                return "item.corpse.villager_type.smith";
            case 4:
                return "item.corpse.villager_type.butcher";
            default:
                return getNotVanillaVillagerProfession(type);
        }
    }

    private static String getVillagerCareerStr(int type, int career) {
        String careerName = "";
        switch (type) {
            case 0:
                switch (career) {
                    case 1:
                        careerName = "farmer";
                        break;
                    case 2:
                        careerName = "fisherman";
                        break;
                    case 3:
                        careerName = "shepherd";
                        break;
                    case 4:
                        careerName = "fletcher";
                        break;
                }
                break;
            case 1:
                switch (career) {
                    case 1:
                        careerName = "librarian";
                        break;
                }
                break;
            case 2:
                switch (career) {
                    case 1:
                        careerName = "cleric";
                        break;
                }
                break;
            case 3:
                switch (career) {
                    case 1:
                        careerName = "armor";
                        break;
                    case 2:
                        careerName = "weapon";
                        break;
                    case 3:
                        careerName = "tool";
                        break;
                }
                break;
            case 4:
                switch (career) {
                    case 1:
                        careerName = "butcher";
                        break;
                    case 2:
                        careerName = "leather";
                        break;
                }
                break;
            default:
                return getNotVanillaVillagerCareer(type, career);
        }
        return "entity.Villager." + careerName;
    }

    private static String getNotVanillaVillagerProfession(int type) {
        VillagerRegistry.VillagerProfession profession = VillagerRegistry.getById(type);
        String professionName = profession.getRegistryName().getResourceDomain() + ":" + profession.getRegistryName().getResourcePath();

        if (professionName.equals(VillagersHandler.UNDERTAKER_NAME)) {
            return "item.corpse.villager_type.undertaker";
        } else if (Compatibility.forestryInstalled && professionName.equals(CompatibilityForestry.getApicultureVillagerID())) {
            return "item.corpse.villager_type.beekeeper";
        } else if (Compatibility.forestryInstalled && professionName.equals(CompatibilityForestry.getArboricultureVillagerID())) {
            return "item.corpse.villager_type.lumberjack";
        } else if (Compatibility.sophisticatedWolvesInstalled && professionName.equals(CompatibilitySophisticatedWolves.getPetSellerVillagerID())) {
            return CompatibilitySophisticatedWolves.getPetSellerVillagerName();
        }
//        else if (type == 10) {
//            return "item.corpse.villager_type.brewer";
//        } else if (type == 206) {
//            return "item.corpse.villager_type.thaumaturge";
//        }
        return "item.corpse.villager_type.unknown";
    }

    private static String getNotVanillaVillagerCareer(int type, int career) {
//        VillagerRegistry.VillagerProfession profession = VillagerRegistry.getById(type);
//        String professionName = profession.getRegistryName().getResourceDomain() + ":" + profession.getRegistryName().getResourcePath();
//        if (professionName.equals(VillagersHandler.UNDERTAKER_NAME)) {
        return "";
//        }
//        return "item.corpse.villager_career.unknown";
    }

    private static boolean hasTrades(NBTTagCompound nbtTag) {
        return nbtTag.hasKey("Offers");
    }

    private static void addTrades(List list, NBTTagCompound nbtTag) {
        for (Object trade : new MerchantRecipeList(nbtTag.getCompoundTag("Offers"))) {
            MerchantRecipe recipe = (MerchantRecipe) trade;
            StringBuilder str = new StringBuilder();
            str.append(recipe.getItemToBuy().getCount()).append(" ").append(recipe.getItemToBuy().getDisplayName());
            if (recipe.getSecondItemToBuy() != null && !recipe.getSecondItemToBuy().isEmpty()) {
                str.append(" + ").append(recipe.getSecondItemToBuy().getCount()).append(" ").append(recipe.getItemToBuy().getDisplayName());
            }
            str.append(" -> ").append(recipe.getItemToSell().getCount()).append(" ").append(recipe.getItemToSell().getDisplayName());
            list.add(str.toString());
        }
    }
}
