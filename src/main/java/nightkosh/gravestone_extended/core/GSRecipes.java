package nightkosh.gravestone_extended.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.gravestone_extended.block.enums.EnumExecution;
import nightkosh.gravestone_extended.block.enums.EnumPileOfBones;
import nightkosh.gravestone_extended.block.enums.EnumSkullCandle;
import nightkosh.gravestone_extended.block.enums.EnumSpawner;
import nightkosh.gravestone_extended.config.ExtendedConfig;
import nightkosh.gravestone_extended.item.ItemFish;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSRecipes {

    private static final ResourceLocation GROUP = new ResourceLocation(ModInfo.ID);

    public static void registration() {
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "toxic_water_bucket"), GROUP, FluidUtil.getFilledBucket(FluidRegistry.getFluidStack(GSFluids.TOXIC_WATER.getName(), 1)),
                "ws", "ss",
                'w', Items.BUCKET,
                's', GSItem.TOXIC_SLIME);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "raven_feather_to_chicken"), GROUP, new ItemStack(Items.FEATHER),
                "fm",
                'f', GSItem.RAVEN_FEATHER,
                'm', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "ooze_to_vine"), GROUP, new ItemStack(Blocks.VINE),
                "o",
                'o', GSItem.OOZE);

        // fishes
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_bones"), GROUP, new ItemStack(GSBlock.PILE_OF_BONES),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.BONE_FISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_toxic_slime"), GROUP, new ItemStack(GSItem.TOXIC_SLIME),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.GREEN_JELLYFISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_magma_cream"), GROUP, new ItemStack(Items.MAGMA_CREAM),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.MAGMA_JELLYFISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_lava"), GROUP, new ItemStack(Items.LAVA_BUCKET),
                "fb",
                'b', Items.BUCKET,
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.MAGMA_JELLYFISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_obsidian"), GROUP, new ItemStack(Blocks.OBSIDIAN),
                "ff",
                "ff",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.OBSIDIFISH.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_netherrack"), GROUP, new ItemStack(Blocks.NETHERRACK),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.NETHER_SALMON.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_quartz"), GROUP, new ItemStack(Items.QUARTZ, 4),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.QUARTZ_COD.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_glowstone_dust"), GROUP, new ItemStack(Items.GLOWSTONE_DUST, 2),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.FLAREFIN_KOI.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_blaze_rod"), GROUP, new ItemStack(Items.BLAZE_ROD),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.BLAZE_COD.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_end_stone"), GROUP, new ItemStack(Blocks.END_STONE),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.ENDERFIN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_ender_pearl"), GROUP, new ItemStack(Items.ENDER_PEARL),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.PEARL_BASS.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_chorus_fruit"), GROUP, new ItemStack(Items.CHORUS_FRUIT),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.CHORUS_KOI.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_sand"), GROUP, new ItemStack(Blocks.SAND),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SANDY_BASS.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_clay"), GROUP, new ItemStack(Items.CLAY_BALL, 4),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.MUD_TUNA.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_snow"), GROUP, new ItemStack(Items.SNOWBALL, 4),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SNOWY_CRUCIAN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_ice"), GROUP, new ItemStack(Blocks.ICE, 1),
                "ff",
                "ff",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.FROST_MINNOW.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_packed_ice"), GROUP, new ItemStack(Blocks.PACKED_ICE, 2),
                "fi",
                "if",
                'i', Blocks.ICE,
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.FROST_MINNOW.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_gunpowder"), GROUP, new ItemStack(Items.GUNPOWDER, 3),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.EXPLOSIVE_CRUCIAN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_sponge"), GROUP, new ItemStack(Blocks.SPONGE, 1),
                "ff",
                "ff",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SPONGE_EATER.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_soul_sand"), GROUP, new ItemStack(Blocks.SOUL_SAND, 1),
                "ff",
                "ff",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.WITHERED_CRUCIAN.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "fish_to_black_dye"), GROUP, new ItemStack(Items.DYE, 5, EnumDyeColor.BLACK.getDyeDamage()),
                "f",
                'f', new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SQUID.ordinal()));


        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "slime_chunk"), GROUP, new ItemStack(GSItem.SLIME_CHUNK),
                "bsb", "scs", "bsb",
                'b', Items.BONE,
                's', GSItem.TOXIC_SLIME,
                'c', Items.COMPASS);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "imp_skull"), GROUP, new ItemStack(GSItem.IMP_SKULL),
                "qqq", "qsq", "gcg",
                'q', Items.QUARTZ,
                's', new ItemStack(Items.SKULL, 1, 0),
                'g', Items.GLOWSTONE_DUST,
                'c', Items.COMPASS);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "ender_skull"), GROUP, new ItemStack(GSItem.ENDER_SKULL),
                "yey", "ysy", "gcg",
                'y', Items.ENDER_EYE,
                'e', Items.END_CRYSTAL,
                's', new ItemStack(Items.SKULL, 1, 1),
                'g', Items.GLOWSTONE_DUST,
                'c', Items.COMPASS);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "frozen_mirror"), GROUP, new ItemStack(GSItem.FROZEN_MIRROR),
                "ipi", "psp", "imi",
                'i', Blocks.PACKED_ICE,
                'p', PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), GSPotion.RECALL_TYPE),
                's', Items.NETHER_STAR,
                'm', Items.IRON_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "chisel"), GROUP, new ItemStack(GSItem.CHISEL),
                "   ", "s  ", " i ",
                's', Items.STICK,
                'i', Items.IRON_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_fishing_pole"), GROUP, new ItemStack(GSItem.BONE_FISHING_POLE),
                "p  ", "tp ", "s p",
                'p', new ItemStack(GSBlock.PILE_OF_BONES, 1, EnumPileOfBones.PILE_OF_BONES.ordinal()),
                't', Items.STRING,
                's', new ItemStack(Items.SKULL, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_pickaxe"), GROUP, new ItemStack(GSItem.BONE_PICKAXE),
                "bsb", " w ", " w ",
                'b', GSBlock.BONE_BLOCK,
                's', new ItemStack(Items.SKULL, 1, 0),
                'w', Items.STICK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_pickaxe_iron"), GROUP, new ItemStack(GSItem.BONE_PICKAXE_IRON),
                "bi",
                'b', GSItem.BONE_PICKAXE,
                'i', Items.IRON_PICKAXE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_pickaxe_golden"), GROUP, new ItemStack(GSItem.BONE_PICKAXE_GOLDEN),
                "bg",
                'b', GSItem.BONE_PICKAXE,
                'g', Items.GOLDEN_PICKAXE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_pickaxe_diamond"), GROUP, new ItemStack(GSItem.BONE_PICKAXE_DIAMOND),
                "bd",
                'b', GSItem.BONE_PICKAXE,
                'd', Items.DIAMOND_PICKAXE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_axe"), GROUP, new ItemStack(GSItem.BONE_AXE),
                "bs ", "bw ", " w ",
                'b', GSBlock.BONE_BLOCK,
                's', new ItemStack(Items.SKULL, 1, 0),
                'w', Items.STICK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_axe_iron"), GROUP, new ItemStack(GSItem.BONE_AXE_IRON),
                "bi",
                'b', GSItem.BONE_AXE,
                'i', Items.IRON_AXE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_axe_golden"), GROUP, new ItemStack(GSItem.BONE_AXE_GOLDEN),
                "bg",
                'b', GSItem.BONE_AXE,
                'g', Items.GOLDEN_AXE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_axe_diamond"), GROUP, new ItemStack(GSItem.BONE_AXE_DIAMOND),
                "bd",
                'b', GSItem.BONE_AXE,
                'd', Items.DIAMOND_AXE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_hoe"), GROUP, new ItemStack(GSItem.BONE_HOE),
                "bs ", " w ", " w ",
                'b', GSBlock.BONE_BLOCK,
                's', new ItemStack(Items.SKULL, 1, 0),
                'w', Items.STICK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_hoe_iron"), GROUP, new ItemStack(GSItem.BONE_HOE_IRON),
                "bi",
                'b', GSItem.BONE_HOE,
                'i', Items.IRON_HOE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_hoe_golden"), GROUP, new ItemStack(GSItem.BONE_HOE_GOLDEN),
                "bg",
                'b', GSItem.BONE_HOE,
                'g', Items.GOLDEN_HOE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_hoe_diamond"), GROUP, new ItemStack(GSItem.BONE_HOE_DIAMOND),
                "bd",
                'b', GSItem.BONE_HOE,
                'd', Items.DIAMOND_HOE);



        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_sword"), GROUP, new ItemStack(GSItem.BONE_SWORD),
                " b ", "sbs", " w ",
                'b', GSBlock.BONE_BLOCK,
                's', new ItemStack(Items.SKULL, 1, 0),
                'w', Items.STICK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_sword_iron"), GROUP, new ItemStack(GSItem.BONE_SWORD_IRON),
                "bs",
                'b', GSItem.BONE_SWORD,
                's', Items.IRON_SWORD);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_sword_golden"), GROUP, new ItemStack(GSItem.BONE_SWORD_GOLDEN),
                "bs",
                'b', GSItem.BONE_SWORD,
                's', Items.GOLDEN_SWORD);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_sword_diamond"), GROUP, new ItemStack(GSItem.BONE_SWORD_DIAMOND),
                "bs",
                'b', GSItem.BONE_SWORD,
                's', Items.DIAMOND_SWORD);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_shield"), GROUP, new ItemStack(GSItem.BONE_SHIELD),
                "sss", "pbp", "pcp",
                's', new ItemStack(Items.SKULL, 1, 0),
                'p', GSBlock.PILE_OF_BONES,
                'b', GSBlock.BONE_BLOCK,
                'c', Items.SHIELD);


        // alternative recipes
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_pickaxe_iron_2"), GROUP, new ItemStack(GSItem.BONE_PICKAXE_IRON),
                "bi", "ii",
                'b', GSItem.BONE_PICKAXE,
                'i', Items.IRON_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_pickaxe_golden_2"), GROUP, new ItemStack(GSItem.BONE_PICKAXE_GOLDEN),
                "bg", "gg",
                'b', GSItem.BONE_PICKAXE,
                'g', Items.GOLD_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_pickaxe_diamond_2"), GROUP, new ItemStack(GSItem.BONE_PICKAXE_DIAMOND),
                "bd", "dd",
                'b', GSItem.BONE_PICKAXE,
                'd', Items.DIAMOND);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_axe_iron_2"), GROUP, new ItemStack(GSItem.BONE_AXE_IRON),
                "bi", "ii",
                'b', GSItem.BONE_AXE,
                'i', Items.IRON_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_axe_golden_2"), GROUP, new ItemStack(GSItem.BONE_AXE_GOLDEN),
                "bg", "gg",
                'b', GSItem.BONE_AXE,
                'g', Items.GOLD_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_axe_diamond_2"), GROUP, new ItemStack(GSItem.BONE_AXE_DIAMOND),
                "bd", "dd",
                'b', GSItem.BONE_AXE,
                'd', Items.DIAMOND);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_hoe_iron_2"), GROUP, new ItemStack(GSItem.BONE_HOE_IRON),
                "b ", "ii",
                'b', GSItem.BONE_HOE,
                'i', Items.IRON_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_hoe_golden_2"), GROUP, new ItemStack(GSItem.BONE_HOE_GOLDEN),
                "b ", "gg",
                'b', GSItem.BONE_HOE,
                'g', Items.GOLD_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_hoe_diamond_2"), GROUP, new ItemStack(GSItem.BONE_HOE_DIAMOND),
                "b ", "dd",
                'b', GSItem.BONE_HOE,
                'd', Items.DIAMOND);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_sword_iron_2"), GROUP, new ItemStack(GSItem.BONE_SWORD_IRON),
                "b ", "ii",
                'b', GSItem.BONE_SWORD,
                'i', Items.IRON_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_sword_golden_2"), GROUP, new ItemStack(GSItem.BONE_SWORD_GOLDEN),
                "b ", "gg",
                'b', GSItem.BONE_SWORD,
                'g', Items.GOLD_INGOT);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_sword_diamond_2"), GROUP, new ItemStack(GSItem.BONE_SWORD_DIAMOND),
                "b ", "dd",
                'b', GSItem.BONE_SWORD,
                'd', Items.DIAMOND);

        //armor
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "diving_chestplate"), GROUP, new ItemStack(GSItem.DIVING_CHESTPLATE),
                "pcp", "ppp", "ppp",
                'p', GSItem.PIECE_OF_DIVING_SUIT,
                'c', Items.LEATHER_CHESTPLATE);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "diving_leggings"), GROUP, new ItemStack(GSItem.DIVING_LEGGINGS),
                "ppp", "plp", "p p",
                'p', GSItem.PIECE_OF_DIVING_SUIT,
                'l', Items.LEATHER_LEGGINGS);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "diving_boots"), GROUP, new ItemStack(GSItem.DIVING_BOOTS),
                "p p", "pbp",
                'p', GSItem.PIECE_OF_DIVING_SUIT,
                'b', Items.LEATHER_BOOTS);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "swamp_thing_helmet"), GROUP, new ItemStack(GSItem.SWAMP_THING_HELMET),
                "ooo", "oho",
                'o', GSItem.OOZE,
                'h', Items.LEATHER_HELMET);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "swamp_thing_chestplate"), GROUP, new ItemStack(GSItem.SWAMP_THING_CHESTPLATE),
                "oco", "ooo", "ooo",
                'o', GSItem.OOZE,
                'c', Items.LEATHER_CHESTPLATE);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "swamp_thing_leggings"), GROUP, new ItemStack(GSItem.SWAMP_THING_LEGGINGS),
                "ooo", "olo", "o o",
                'o', GSItem.OOZE,
                'l', Items.LEATHER_LEGGINGS);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "swamp_thing_boots"), GROUP, new ItemStack(GSItem.SWAMP_THING_BOOTS),
                "o o", "obo",
                'o', GSItem.OOZE,
                'b', Items.LEATHER_BOOTS);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "mummy_helmet"), GROUP, new ItemStack(GSItem.MUMMY_HELMET),
                "ppp", "php",
                'p', GSItem.PIECE_OF_MUMMY_CLOTH,
                'h', Items.LEATHER_HELMET);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "mummy_chestplate"), GROUP, new ItemStack(GSItem.MUMMY_CHESTPLATE),
                "pcp", "ppp", "ppp",
                'p', GSItem.PIECE_OF_MUMMY_CLOTH,
                'c', Items.LEATHER_CHESTPLATE);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "mummy_leggings"), GROUP, new ItemStack(GSItem.MUMMY_LEGGINGS),
                "ppp", "plp", "p p",
                'p', GSItem.PIECE_OF_MUMMY_CLOTH,
                'l', Items.LEATHER_LEGGINGS);
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "mummy_boots"), GROUP, new ItemStack(GSItem.MUMMY_BOOTS),
                "p p", "pbp",
                'p', GSItem.PIECE_OF_MUMMY_CLOTH,
                'b', Items.LEATHER_BOOTS);

        // blocks
        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "withered_glass"), GROUP, new ItemStack(GSBlock.WITHERED_GLASS, 6),
                "ggg", "sos", "ggg",
                'g', Blocks.GLASS,
                's', Blocks.SOUL_SAND,
                'o', Blocks.OBSIDIAN);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "withered_glass_pane"), GROUP, new ItemStack(GSBlock.WITHERED_GLASS_PANE, 16),
                "ggg", "ggg",
                'g', GSBlock.WITHERED_GLASS);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "pile_of_bones"), GROUP, new ItemStack(GSBlock.PILE_OF_BONES, 1, 0),
                "bb", "bb",
                'b', Items.BONE);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "pile_of_bones_with_skull"), GROUP, new ItemStack(GSBlock.PILE_OF_BONES, 9, 1),
                "bbb", "bsb", "bbb",
                'b', new ItemStack(GSBlock.PILE_OF_BONES, 1, 0),
                's', new ItemStack(Items.SKULL, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "piles_to_bones"), GROUP, new ItemStack(Items.BONE, 4),
                "p",
                'p', new ItemStack(GSBlock.PILE_OF_BONES, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "skull_from_piles"), GROUP, new ItemStack(Items.SKULL, 1, 0),
                "ppp", "ppp", "ppp",
                'p', new ItemStack(GSBlock.PILE_OF_BONES, 1, 1));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_block"), GROUP, new ItemStack(GSBlock.BONE_BLOCK, 1, 0),
                "ppp", "ppp", "ppp",
                'p', new ItemStack(GSBlock.PILE_OF_BONES, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_block_with_skull"), GROUP, new ItemStack(GSBlock.BONE_BLOCK, 9, 1),
                "bbb", "bsb", "bbb",
                'b', new ItemStack(GSBlock.BONE_BLOCK, 1, 0), 's', new ItemStack(Items.SKULL, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_block_from_slabs"), GROUP, new ItemStack(GSBlock.BONE_BLOCK),
                "x", "x",
                'x', GSBlock.BONE_SLAB);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_slabs"), GROUP, new ItemStack(GSBlock.BONE_SLAB, 6),
                "xxx",
                'x', GSBlock.BONE_BLOCK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "bone_stairs"), GROUP, new ItemStack(GSBlock.BONE_STAIRS, 4),
                "x  ", "xx ", "xxx",
                'x', GSBlock.BONE_BLOCK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "pile_of_bones_from_block"), GROUP, new ItemStack(GSBlock.PILE_OF_BONES, 9, 0),
                "x",
                'x', GSBlock.BONE_BLOCK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "gallows"), GROUP, new ItemStack(GSBlock.EXECUTION, 1, EnumExecution.GALLOWS.ordinal()),
                "ww ", "wr ", "ww ",
                'w', Blocks.PLANKS,
                'r', Items.LEAD);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "gibbets"), GROUP, new ItemStack(GSBlock.EXECUTION, 1, EnumExecution.GIBBET.ordinal()),
                "ww ", "wr ", "wi ",
                'w', Blocks.PLANKS,
                'r', Items.LEAD,
                'i', Blocks.IRON_BLOCK);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "stocks"), GROUP, new ItemStack(GSBlock.EXECUTION, 1, EnumExecution.STOCKS.ordinal()),
                "wsw", "w w",
                'w', Blocks.PLANKS,
                's', Blocks.WOODEN_SLAB);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "burning_stake"), GROUP, new ItemStack(GSBlock.EXECUTION, 1, EnumExecution.BURNING_STAKE.ordinal()),
                " w ", "www", "hwh",
                'w', Blocks.PLANKS,
                'h', Blocks.HAY_BLOCK);

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
                    'c', new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.WITHER_SKULL.ordinal()),
                    'b', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()), 'e', Items.ENDER_EYE);
        }
        if (ExtendedConfig.craftableSpawners) {
            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "skeleton_spawner"), GROUP, new ItemStack(GSBlock.SPAWNER, 1, EnumSpawner.SKELETON_SPAWNER.ordinal()),
                    "bcb", "cec", "cbc",
                    'c', new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.SKELETON_SKULL.ordinal()),
                    'b', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()), 'e', Items.ENDER_EYE);

            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "zombie_spawner"), GROUP, new ItemStack(GSBlock.SPAWNER, 1, EnumSpawner.ZOMBIE_SPAWNER.ordinal()),
                    "bcb", "cec", "cbc",
                    'c', new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.ZOMBIE_SKULL.ordinal()),
                    'b', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()), 'e', Items.ENDER_EYE);

            GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "spider_spawner"), GROUP, new ItemStack(GSBlock.SPAWNER, 1, EnumSpawner.SPIDER_SPAWNER.ordinal()),
                    "www", "ses", "www",
                    'w', Blocks.WEB, 's', Items.SPIDER_EYE, 'e', Items.ENDER_EYE);
        }

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "candle"), GROUP, new ItemStack(GSBlock.CANDLE, 1, 0),
                "t", "m", "s",
                't', Items.STRING,
                'm', new ItemStack(Items.DYE, 1, EnumDyeColor.WHITE.getDyeDamage()),
                's', Items.SLIME_BALL);

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "skeleton_candle"), GROUP, new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.SKELETON_SKULL.ordinal()),
                "c", "s",
                's', new ItemStack(Items.SKULL, 1, 0),
                'c', new ItemStack(GSBlock.CANDLE, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "wither_candle"), GROUP, new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.WITHER_SKULL.ordinal()),
                "c", "s",
                's', new ItemStack(Items.SKULL, 1, 1),
                'c', new ItemStack(GSBlock.CANDLE, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "zombie_candle"), GROUP, new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.ZOMBIE_SKULL.ordinal()),
                "c", "s",
                's', new ItemStack(Items.SKULL, 1, 2),
                'c', new ItemStack(GSBlock.CANDLE, 1, 0));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "skeleton_skull"), GROUP, new ItemStack(Items.SKULL, 1, 0),
                "c",
                'c', new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.SKELETON_SKULL.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "wither_skull"), GROUP, new ItemStack(Items.SKULL, 1, 1),
                "c",
                'c', new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.WITHER_SKULL.ordinal()));

        GameRegistry.addShapedRecipe(new ResourceLocation(ModInfo.ID, "zombie_skull"), GROUP, new ItemStack(Items.SKULL, 1, 2),
                "c",
                'c', new ItemStack(GSBlock.SKULL_CANDLE, 1, EnumSkullCandle.ZOMBIE_SKULL.ordinal()));

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
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.BLUE_JELLYFISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.GREEN_JELLYFISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.MAGMA_JELLYFISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.MUD_TUNA.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.FROST_MINNOW.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.PIRANHA.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.GOLDEN_KOI.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SPECULAR_FISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.CAVEFISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.CURSED_KOI.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SPOOKYFIN.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.OBSIDIFISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.NETHER_SALMON.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 1), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.QUARTZ_COD.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.FLAREFIN_KOI.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.BLAZE_COD.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.ENDERFIN.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.PEARL_BASS.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.CHORUS_KOI.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.EXPLOSIVE_CRUCIAN.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.RUFFE.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SPARKLING_EEL.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.ANGELFISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.ANGLER_FISH.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SPONGE_EATER.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SNOWY_CRUCIAN.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SQUID.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.WITHERED_CRUCIAN.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
        GameRegistry.addSmelting(new ItemStack(GSItem.FISH, 1, ItemFish.EnumFishType.SANDY_BASS.ordinal()), new ItemStack(Items.COOKED_FISH, 1, 0), 1);
    }
}
