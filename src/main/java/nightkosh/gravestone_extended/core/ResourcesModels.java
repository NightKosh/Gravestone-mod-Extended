package nightkosh.gravestone_extended.core;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ResourcesModels extends Resources {
    // armor
    public static final ModelResourceLocation DIVING_HELMET = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_HELMET.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation DIVING_CHESTPLATE = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_CHESTPLATE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation DIVING_LEGGINGS = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_LEGGINGS.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation DIVING_BOOTS = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_BOOTS.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation SWAMP_THING_HELMET = new ModelResourceLocation(ModInfo.ID + ":armor/swamp_thing_costume/" + GSItem.SWAMP_THING_HELMET.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation SWAMP_THING_CHESTPLATE = new ModelResourceLocation(ModInfo.ID + ":armor/swamp_thing_costume/" + GSItem.SWAMP_THING_CHESTPLATE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation SWAMP_THING_LEGGINGS = new ModelResourceLocation(ModInfo.ID + ":armor/swamp_thing_costume/" + GSItem.SWAMP_THING_LEGGINGS.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation SWAMP_THING_BOOTS = new ModelResourceLocation(ModInfo.ID + ":armor/swamp_thing_costume/" + GSItem.SWAMP_THING_BOOTS.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation MUMMY_HELMET = new ModelResourceLocation(ModInfo.ID + ":armor/mummy_costume/" + GSItem.MUMMY_HELMET.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation MUMMY_CHESTPLATE = new ModelResourceLocation(ModInfo.ID + ":armor/mummy_costume/" + GSItem.MUMMY_CHESTPLATE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation MUMMY_LEGGINGS = new ModelResourceLocation(ModInfo.ID + ":armor/mummy_costume/" + GSItem.MUMMY_LEGGINGS.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation MUMMY_BOOTS = new ModelResourceLocation(ModInfo.ID + ":armor/mummy_costume/" + GSItem.MUMMY_BOOTS.getRegistryName().getResourcePath(), "inventory");

    // tools
    public static final ModelResourceLocation CHISEL = new ModelResourceLocation(ModInfo.ID + ":tools/chisel", "inventory");

    public static final ModelResourceLocation BONE_SWORD = new ModelResourceLocation(ModInfo.ID + ":weapon/sword/bone", "inventory");
    public static final ModelResourceLocation BONE_SWORD_IRON = new ModelResourceLocation(ModInfo.ID + ":weapon/sword/iron", "inventory");
    public static final ModelResourceLocation BONE_SWORD_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":weapon/sword/golden", "inventory");
    public static final ModelResourceLocation BONE_SWORD_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":weapon/sword/diamond", "inventory");
    public static final ModelResourceLocation BONE_SHIELD = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SHIELD.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_FISHING_POLE = new ModelResourceLocation(ModInfo.ID + ":tools/bone_fishing_pole", "inventory");

    public static final ModelResourceLocation BONE_HOE = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/bone", "inventory");
    public static final ModelResourceLocation BONE_HOE_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/iron", "inventory");
    public static final ModelResourceLocation BONE_HOE_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/golden", "inventory");
    public static final ModelResourceLocation BONE_HOE_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/diamond", "inventory");

    public static final ModelResourceLocation BONE_SHOVEL = new ModelResourceLocation(ModInfo.ID + ":tools/shovel/bone", "inventory");
    public static final ModelResourceLocation BONE_SHOVEL_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/shovel/iron", "inventory");
    public static final ModelResourceLocation BONE_SHOVEL_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/shovel/golden", "inventory");
    public static final ModelResourceLocation BONE_SHOVEL_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/shovel/diamond", "inventory");

    public static final ModelResourceLocation BONE_AXE = new ModelResourceLocation(ModInfo.ID + ":tools/axe/bone", "inventory");
    public static final ModelResourceLocation BONE_AXE_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/axe/iron", "inventory");
    public static final ModelResourceLocation BONE_AXE_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/axe/golden", "inventory");
    public static final ModelResourceLocation BONE_AXE_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/axe/diamond", "inventory");

    public static final ModelResourceLocation BONE_PICKAXE = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/bone", "inventory");
    public static final ModelResourceLocation BONE_PICKAXE_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/iron", "inventory");
    public static final ModelResourceLocation BONE_PICKAXE_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/golden", "inventory");
    public static final ModelResourceLocation BONE_PICKAXE_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/diamond", "inventory");

    public static final ModelResourceLocation CORPSE = new ModelResourceLocation(ModInfo.ID + ":corpse", "inventory");

    public static final ModelResourceLocation SPAWN_EGG_MODEL = new ModelResourceLocation(GSItem.SPAWN_EGG.getRegistryName(), "inventory");

    public static final ModelResourceLocation TOXIC_SLIME = new ModelResourceLocation(GSItem.TOXIC_SLIME.getRegistryName(), "inventory");

    public static final ModelResourceLocation RAVEN_FEATHER = new ModelResourceLocation(GSItem.RAVEN_FEATHER.getRegistryName(), "inventory");
    public static final ModelResourceLocation RAVEN_CLAWS = new ModelResourceLocation(GSItem.RAVEN_CLAWS.getRegistryName(), "inventory");

    public static final ModelResourceLocation BAT_WING = new ModelResourceLocation(GSItem.BAT_WING.getRegistryName(), "inventory");

    public static final ModelResourceLocation OOZE = new ModelResourceLocation(GSItem.OOZE.getRegistryName(), "inventory");

    public static final ModelResourceLocation PIECE_OF_MUMMY_CLOTH = new ModelResourceLocation(GSItem.PIECE_OF_MUMMY_CLOTH.getRegistryName(), "inventory");

    public static final ModelResourceLocation PIECE_OF_DIVING_SUIT = new ModelResourceLocation(GSItem.PIECE_OF_DIVING_SUIT.getRegistryName(), "inventory");

    public static final ModelResourceLocation ENCHANTED_SKULL = new ModelResourceLocation(GSItem.ENCHANTED_SKULL.getRegistryName(), "inventory");
    public static final ModelResourceLocation ENCHANTED_SKULL_WITHERED = new ModelResourceLocation(GSItem.ENCHANTED_SKULL.getRegistryName() + "_withered", "inventory");

    public static final ModelResourceLocation SLIME_CHUNK = new ModelResourceLocation(ModInfo.ID + ":compasses/slime_chunk/" + GSItem.SLIME_CHUNK.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation IMP_SKULL = new ModelResourceLocation(ModInfo.ID + ":compasses/imp_skull/" + GSItem.IMP_SKULL.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation ENDER_SKULL = new ModelResourceLocation(ModInfo.ID + ":compasses/ender_skull/" + GSItem.ENDER_SKULL.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation FROZEN_MIRROR = new ModelResourceLocation(GSItem.FROZEN_MIRROR.getRegistryName(), "inventory");

    public static final ModelResourceLocation MEMORIAL = new ModelResourceLocation(ModInfo.ID + ":block/memorial", "inventory");
    public static final ModelResourceLocation EXECUTION = new ModelResourceLocation(ModInfo.ID + ":block/execution", "inventory");
    public static final ModelResourceLocation SPAWNER = new ModelResourceLocation(ModInfo.ID + ":block/spawner", "inventory");

    public static final ModelResourceLocation NIGHT_STONE = new ModelResourceLocation(ModInfo.ID + ":block/trap/night_stone", "inventory");
    public static final ModelResourceLocation THUNDER_STONE = new ModelResourceLocation(ModInfo.ID + ":block/trap/thunder_stone", "inventory");

    public static final ModelResourceLocation WITHERED_GLASS = new ModelResourceLocation(ModInfo.ID + ":block/withered_glass/withered_glass", "inventory");
    public static final ModelResourceLocation WITHERED_GLASS_PANE = new ModelResourceLocation(ModInfo.ID + ":block/withered_glass/withered_glass_pane", "inventory");

    public static final ModelResourceLocation PILE_OF_BONES = new ModelResourceLocation(ModInfo.ID + ":block/pile_of_bones/pile_of_bones", "inventory");
    public static final ModelResourceLocation PILE_OF_BONES_WITH_SKULL = new ModelResourceLocation(ModInfo.ID + ":block/pile_of_bones/pile_of_bones_with_skull", "inventory");

    public static final ModelResourceLocation BONE_BLOCK = new ModelResourceLocation(ModInfo.ID + ":block/bone_block/bone_block", "inventory");
    public static final ModelResourceLocation BONE_BLOCK_WITH_SKULL = new ModelResourceLocation(ModInfo.ID + ":block/bone_block/bone_block_with_skull", "inventory");

    public static final ModelResourceLocation BONE_SLAB = new ModelResourceLocation(ModInfo.ID + ":block/bone_slab", "inventory");
    public static final ModelResourceLocation BONE_STAIRS = new ModelResourceLocation(ModInfo.ID + ":block/bone_stairs", "inventory");

    public static final ModelResourceLocation HAUNTED_CHEST = new ModelResourceLocation(ModInfo.ID + ":block/haunted_chest", "inventory");
    public static final ModelResourceLocation CANDLE = new ModelResourceLocation(ModInfo.ID + ":block/candle", "inventory");

    public static final ModelResourceLocation SKULL_CANDLE_SKELETON = new ModelResourceLocation(ModInfo.ID + ":block/skull_candle/skeleton", "inventory");
    public static final ModelResourceLocation SKULL_CANDLE_WITHER = new ModelResourceLocation(ModInfo.ID + ":block/skull_candle/wither", "inventory");
    public static final ModelResourceLocation SKULL_CANDLE_ZOMBIE = new ModelResourceLocation(ModInfo.ID + ":block/skull_candle/zombie", "inventory");

    public static final ModelResourceLocation ALTAR = new ModelResourceLocation(ModInfo.ID + ":block/altar", "inventory");

    public static final ModelResourceLocation CATACOMBS_PORTAL = new ModelResourceLocation(ModInfo.ID + ":block/catacombs_portal", "inventory");
}
