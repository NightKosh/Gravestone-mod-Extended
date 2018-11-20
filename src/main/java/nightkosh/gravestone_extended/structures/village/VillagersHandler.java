package nightkosh.gravestone_extended.structures.village;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import nightkosh.gravestone_extended.core.ModInfo;
import nightkosh.gravestone_extended.core.Resources;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class VillagersHandler {

    public static final String UNDERTAKER_NAME = ModInfo.ID.toLowerCase() + ":undertaker";

    public static VillagerRegistry.VillagerProfession undertakerProfession;
    public static VillagerRegistry.VillagerCareer undertakerCareer;

    public static void registerVillagers() {
        undertakerProfession = new VillagerRegistry.VillagerProfession(UNDERTAKER_NAME, Resources.UNDERTAKER, Resources.UNDERTAKER_ZOMBIE);
        IForgeRegistry<VillagerRegistry.VillagerProfession> villagerProfessions = ForgeRegistries.VILLAGER_PROFESSIONS;
        villagerProfessions.register(undertakerProfession);

        undertakerCareer = new VillagerRegistry.VillagerCareer(undertakerProfession, UNDERTAKER_NAME);
        undertakerCareer.addTrade(1,
                new EntityVillager.ListItemForEmeralds(new ItemStack(Items.SKULL, 1), new EntityVillager.PriceInfo(5, 10)),// skeleton
                new EntityVillager.ListItemForEmeralds(new ItemStack(Items.SKULL, 1, 2), new EntityVillager.PriceInfo(5, 10))// zombie
        );
        undertakerCareer.addTrade(2,
                new EntityVillager.ListItemForEmeralds(new ItemStack(Items.SKULL, 1, 3), new EntityVillager.PriceInfo(10, 20)),// steve
                new EntityVillager.ListItemForEmeralds(new ItemStack(Items.SKULL, 1, 4), new EntityVillager.PriceInfo(15, 25))// creeper
        );
        undertakerCareer.addTrade(3, new EntityVillager.ListItemForEmeralds(new ItemStack(Items.SKULL, 1, 1), new EntityVillager.PriceInfo(25, 35)));// wither
    }
}
