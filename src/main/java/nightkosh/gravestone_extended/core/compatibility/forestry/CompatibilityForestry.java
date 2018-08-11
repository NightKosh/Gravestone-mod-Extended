package nightkosh.gravestone_extended.core.compatibility.forestry;

import forestry.api.core.ForestryAPI;
import forestry.api.recipes.RecipeManagers;
import forestry.api.storage.BackpackManager;
import forestry.api.storage.EnumBackpackType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.core.GSItem;
import nightkosh.gravestone_extended.core.GSRecipes;
import nightkosh.gravestone_extended.core.GSTabs;
import nightkosh.gravestone_extended.core.ModInfo;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CompatibilityForestry {

    public static final String BACKPACK_UID = "gravestone.undertaker";

    public static Item backpackItemT1;
    public static Item backpackItemT2;

    public static String getApicultureVillagerID() {
        if (ForestryAPI.forestryConstants != null) {
            return ForestryAPI.forestryConstants.getApicultureVillagerID();
        } else {
            return "";
        }
    }

    public static String getArboricultureVillagerID() {
        if (ForestryAPI.forestryConstants != null) {
            return ForestryAPI.forestryConstants.getArboricultureVillagerID();
        } else {
            return "";
        }
    }

    public static void addBackpack(final IForgeRegistry<Item> registry) {
        if (ExtendedConfig.enableForestryBackpacks) {
            BackpackManager.backpackInterface.registerBackpackDefinition(BACKPACK_UID, new UndertakerBackpack());
            backpackItemT1 = BackpackManager.backpackInterface.createBackpack(BACKPACK_UID, EnumBackpackType.NORMAL);
            backpackItemT1.setCreativeTab(GSTabs.otherItemsTab);
            backpackItemT1.setRegistryName(ModInfo.ID, "gs_undertaker_backpack");
            backpackItemT1.setUnlocalizedName("backpack.undertaker.t1");

            backpackItemT2 = BackpackManager.backpackInterface.createBackpack(BACKPACK_UID, EnumBackpackType.WOVEN);
            backpackItemT2.setCreativeTab(GSTabs.otherItemsTab);
            backpackItemT2.setRegistryName(ModInfo.ID, "gs_undertaker_backpack_woven");
            backpackItemT2.setUnlocalizedName("backpack.undertaker.t2");

            GSRecipes.addForestryBackpack(new ItemStack(backpackItemT1), GSItem.CHISEL);
            ItemStack silk = GameRegistry.makeItemStack("forestry:crafting_material", 3, 1, "");
            if (!silk.isEmpty()) {
                ItemStack backpackStackT2 = new ItemStack(backpackItemT2);
                RecipeManagers.carpenterManager.addRecipe(200, FluidRegistry.getFluidStack("water", 1000), ItemStack.EMPTY, backpackStackT2,
                        new Object[]{
                                "sds", "sbs", "sss",
                                'd', Items.DIAMOND,
                                'b', backpackItemT1,
                                's', silk
                        }
                );
            }


            registry.registerAll(CompatibilityForestry.backpackItemT1, CompatibilityForestry.backpackItemT2);

            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.BAT_WING));
            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.TOXIC_SLIME));
            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.OOZE));
            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.PIECE_OF_MUMMY_CLOTH));
            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.RAVEN_FEATHER));
            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.RAVEN_CLAWS));
            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.PIECE_OF_DIVING_SUIT));
            BackpackManager.backpackInterface.addItemToForestryBackpack(BackpackManager.HUNTER_UID, new ItemStack(GSItem.FISH));
        }
    }
}