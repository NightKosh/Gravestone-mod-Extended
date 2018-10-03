package nightkosh.gravestone_extended.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.config.ExtendedConfig;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSRecipes {

    private static final ResourceLocation GROUP = new ResourceLocation(ModInfo.ID);

    public static void registration() {
//        RecipesJsonGenerator.addShapedRecipe(


        //TODO ????
        // sword graves TODO remove
//        for (net.minecraft.item.Item sword : GraveStoneHelper.swordsList) {
//            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, ""), GROUP, GraveStoneHelper.getSwordAsGrave(net.minecraft.item.Item.getItemFromBlock(Block.graveStone), new ItemStack(sword, 1)),
//                    "sc",
//                    's', sword,
//                    'c', ExtendedItem.chisel);
//        }

        if (ExtendedConfig.craftableWitherSpawner) {
            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "wither_spawner"), GROUP, new ItemStack(GSBlock.SPAWNER, 1, EnumSpawner.WITHER_SPAWNER.ordinal()),
                    "bcb", "cec", "cbc",
                    'c', new ItemStack(GSBlock.SKULL_CANDLE_WITHER, 1),
                    'b', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()), 'e', Items.ENDER_EYE);
        }
        if (ExtendedConfig.craftableSpawners) {
            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "skeleton_spawner"), GROUP, new ItemStack(GSBlock.SPAWNER, 1, EnumSpawner.SKELETON_SPAWNER.ordinal()),
                    "bcb", "cec", "cbc",
                    'c', new ItemStack(GSBlock.SKULL_CANDLE_SKELETON, 1),
                    'b', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()), 'e', Items.ENDER_EYE);

            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "zombie_spawner"), GROUP, new ItemStack(GSBlock.SPAWNER, 1, EnumSpawner.ZOMBIE_SPAWNER.ordinal()),
                    "bcb", "cec", "cbc",
                    'c', new ItemStack(GSBlock.SKULL_CANDLE_ZOMBIE, 1),
                    'b', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()), 'e', Items.ENDER_EYE);

            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "spider_spawner"), GROUP, new ItemStack(GSBlock.SPAWNER, 1, EnumSpawner.SPIDER_SPAWNER.ordinal()),
                    "www", "ses", "www",
                    'w', Blocks.WEB, 's', Items.SPIDER_EYE, 'e', Items.ENDER_EYE);
        }

        if (ExtendedConfig.craftableNightStone) {
            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "nightstone"), GROUP, new ItemStack(GSBlock.TRAP, 1, 0),
                    " p ", "rnr", " s ",
                    'n', Blocks.NETHER_BRICK,
                    'p', Blocks.STONE_PRESSURE_PLATE,
                    'r', Items.REDSTONE,
                    's', Blocks.SOUL_SAND);
        }
        if (ExtendedConfig.craftableThunderStone) {
            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "thunderstone"), GROUP, new ItemStack(GSBlock.TRAP, 1, 1),
                    " p ", "rnr", " s ",
                    'n', Blocks.STONEBRICK,
                    'p', Blocks.STONE_PRESSURE_PLATE,
                    'r', Items.REDSTONE,
                    's', Blocks.SOUL_SAND);
        }

        // altar
        Item altarCrystal = (ExtendedConfig.hardAltarRecipe) ? Items.NETHER_STAR : Items.DIAMOND;
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "altar"), GROUP, new ItemStack(GSBlock.ALTAR),
                " h ", "sns", "bbb",
                'h', altarCrystal,
                's', new ItemStack(Items.SKULL, 1, 0),
                'n', new ItemStack(GSBlock.TRAP, 1, 0),
                'b', new ItemStack(GSBlock.BONE_BLOCK, 1, 0));
    }

    public static void addForestryBackpack(ItemStack backpack, Item item) {
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "backpack"), GROUP, backpack,
                "sws", "ici", "sws",
                'w', Blocks.WOOL,
                'i', item,
                's', Items.STRING,
                'c', Blocks.CHEST);
    }

    public static void smeltingRecipesRegistration() {
    }
}
