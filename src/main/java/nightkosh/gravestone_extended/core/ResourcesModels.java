package nightkosh.gravestone_extended.core;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import nightkosh.gravestone_extended.item.ItemFish;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@SideOnly(Side.CLIENT)
public class ResourcesModels extends Resources {

    public static final String MOD_NAME = ModInfo.ID.toLowerCase();

    // MODEL RESOURCES
    public static final ModelResourceLocation DIVING_HELMET = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_HELMET.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation DIVING_CHESTPLATE = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_CHESTPLATE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation DIVING_LEGGINGS = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_LEGGINGS.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation DIVING_BOOTS = new ModelResourceLocation(ModInfo.ID + ":armor/phantom_diver_costume/" + GSItem.DIVING_BOOTS.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation CHISEL = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.CHISEL.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_SWORD = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SWORD_IRON = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD_IRON.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SWORD_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD_GOLDEN.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SWORD_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SWORD_DIAMOND.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_SHIELD = new ModelResourceLocation(ModInfo.ID + ":weapon/" + GSItem.BONE_SHIELD.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_FISHING_POLE = new ModelResourceLocation(ModInfo.ID + ":tools/" + GSItem.BONE_FISHING_POLE.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_HOE = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/" + GSItem.BONE_HOE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_HOE_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/" + GSItem.BONE_HOE_IRON.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_HOE_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/" + GSItem.BONE_HOE_GOLDEN.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_HOE_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/hoe/" + GSItem.BONE_HOE_DIAMOND.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_AXE = new ModelResourceLocation(ModInfo.ID + ":tools/axe/" + GSItem.BONE_AXE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_AXE_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/axe/" + GSItem.BONE_AXE_IRON.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_AXE_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/axe/" + GSItem.BONE_AXE_GOLDEN.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_AXE_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/axe/" + GSItem.BONE_AXE_DIAMOND.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation BONE_PICKAXE = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/" + GSItem.BONE_PICKAXE.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_PICKAXE_IRON = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/" + GSItem.BONE_PICKAXE_IRON.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_PICKAXE_GOLDEN = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/" + GSItem.BONE_PICKAXE_GOLDEN.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation BONE_PICKAXE_DIAMOND = new ModelResourceLocation(ModInfo.ID + ":tools/pickaxe/" + GSItem.BONE_PICKAXE_DIAMOND.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation CORPSE = new ModelResourceLocation(MOD_NAME + ":gscorpse", "inventory");

    public static final ModelResourceLocation SPAWN_EGG_MODEL = new ModelResourceLocation(GSItem.SPAWN_EGG.getRegistryName(), "inventory");

    public static final ModelResourceLocation TOXIC_SLIME = new ModelResourceLocation(GSItem.TOXIC_SLIME.getRegistryName(), "inventory");

    public static final ModelResourceLocation RAVEN_FEATHER = new ModelResourceLocation(GSItem.RAVEN_FEATHER.getRegistryName(), "inventory");

    public static final ModelResourceLocation BAT_WING = new ModelResourceLocation(GSItem.BAT_WING.getRegistryName(), "inventory");

    public static final ModelResourceLocation OOZE = new ModelResourceLocation(GSItem.OOZE.getRegistryName(), "inventory");

    public static final ModelResourceLocation PIECE_OF_DIVING_SUIT = new ModelResourceLocation(GSItem.PIECE_OF_DIVING_SUIT.getRegistryName(), "inventory");

    public static final ModelResourceLocation BLUE_JELLYFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.BLUE_JELLYFISH.getName(), "inventory");
    public static final ModelResourceLocation GREEN_JELLYFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.GREEN_JELLYFISH.getName(), "inventory");
    public static final ModelResourceLocation MAGMA_JELLYFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.MAGMA_JELLYFISH.getName(), "inventory");
    public static final ModelResourceLocation BONE_FISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.BONE_FISH.getName(), "inventory");
    public static final ModelResourceLocation MUD_TUNA = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.MUD_TUNA.getName(), "inventory");
    public static final ModelResourceLocation FROST_MINNOW = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.FROST_MINNOW.getName(), "inventory");
    public static final ModelResourceLocation PIRANHA = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.PIRANHA.getName(), "inventory");
    public static final ModelResourceLocation GOLDEN_KOI = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.GOLDEN_KOI.getName(), "inventory");
    public static final ModelResourceLocation SPECULAR_FISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.SPECULAR_FISH.getName(), "inventory");
    public static final ModelResourceLocation CAVEFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.CAVEFISH.getName(), "inventory");
    public static final ModelResourceLocation CURSED_KOI = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.CURSED_KOI.getName(), "inventory");
    public static final ModelResourceLocation SPOOKYFIN = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.SPOOKYFIN.getName(), "inventory");
    public static final ModelResourceLocation OBSIDIFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.OBSIDIFISH.getName(), "inventory");
    public static final ModelResourceLocation NETHER_SALMON = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.NETHER_SALMON.getName(), "inventory");
    public static final ModelResourceLocation QUARTZ_COD = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.QUARTZ_COD.getName(), "inventory");
    public static final ModelResourceLocation FLAREFIN_KOI = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.FLAREFIN_KOI.getName(), "inventory");
    public static final ModelResourceLocation BLAZE_COD = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.BLAZE_COD.getName(), "inventory");
    public static final ModelResourceLocation ENDERFIN = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.ENDERFIN.getName(), "inventory");
    public static final ModelResourceLocation PEARL_BASS = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.PEARL_BASS.getName(), "inventory");
    public static final ModelResourceLocation CHORUS_KOI = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.CHORUS_KOI.getName(), "inventory");
    public static final ModelResourceLocation EXPLOSIVE_CRUCIAN = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.EXPLOSIVE_CRUCIAN.getName(), "inventory");
    public static final ModelResourceLocation RUFFE = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.RUFFE.getName(), "inventory");
    public static final ModelResourceLocation SPARKLING_EEL = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.SPARKLING_EEL.getName(), "inventory");
    public static final ModelResourceLocation ANGELFISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.ANGELFISH.getName(), "inventory");
    public static final ModelResourceLocation ANGLER_FISH = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.ANGLER_FISH.getName(), "inventory");
    public static final ModelResourceLocation SPONGE_EATER = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.SPONGE_EATER.getName(), "inventory");
    public static final ModelResourceLocation SNOWY_CRUCIAN = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.SNOWY_CRUCIAN.getName(), "inventory");
    public static final ModelResourceLocation SQUID = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.SQUID.getName(), "inventory");
    public static final ModelResourceLocation WITHERED_CRUCIAN = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.WITHERED_CRUCIAN.getName(), "inventory");
    public static final ModelResourceLocation SANDY_BASS = new ModelResourceLocation(ModInfo.ID + ":fish/" + ItemFish.EnumFishType.SANDY_BASS.getName(), "inventory");

    public static final ModelResourceLocation ENCHANTED_SKULL = new ModelResourceLocation(GSItem.ENCHANTED_SKULL.getRegistryName(), "inventory");
    public static final ModelResourceLocation ENCHANTED_SKULL_WITHERED = new ModelResourceLocation(GSItem.ENCHANTED_SKULL.getRegistryName() + "_withered", "inventory");

    public static final ModelResourceLocation SLIME_CHUNK = new ModelResourceLocation(ModInfo.ID + ":compasses/slime_chunk/" + GSItem.SLIME_CHUNK.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation IMP_SKULL = new ModelResourceLocation(ModInfo.ID + ":compasses/imp_skull/" + GSItem.IMP_SKULL.getRegistryName().getResourcePath(), "inventory");
    public static final ModelResourceLocation ENDER_SKULL = new ModelResourceLocation(ModInfo.ID + ":compasses/ender_skull/" + GSItem.ENDER_SKULL.getRegistryName().getResourcePath(), "inventory");

    public static final ModelResourceLocation FROZEN_MIRROR = new ModelResourceLocation(GSItem.FROZEN_MIRROR.getRegistryName(), "inventory");

    public static final ModelResourceLocation MEMORIAL = new ModelResourceLocation(MOD_NAME + ":gsmemorial", "inventory");
    public static final ModelResourceLocation EXECUTION = new ModelResourceLocation(MOD_NAME + ":gsexecution", "inventory");
    public static final ModelResourceLocation SPAWNER = new ModelResourceLocation(MOD_NAME + ":gsspawner", "inventory");
    //trap
    public static final ModelResourceLocation NIGHT_STONE = new ModelResourceLocation(MOD_NAME + ":gstrap_night_stone", "inventory");
    public static final ModelResourceLocation THUNDER_STONE = new ModelResourceLocation(MOD_NAME + ":gstrap_thunder_stone", "inventory");

    public static final ModelResourceLocation WITHERED_GLASS = new ModelResourceLocation(GSBlock.WITHERED_GLASS.getRegistryName(), "inventory");
    public static final ModelResourceLocation WITHERED_GLASS_PANE = new ModelResourceLocation(GSBlock.WITHERED_GLASS_PANE.getRegistryName(), "inventory");

    public static final ModelResourceLocation PILE_OF_BONES = new ModelResourceLocation(MOD_NAME + ":gspileofbones", "inventory");
    //bone blocks
    public static final ModelResourceLocation BONE_BLOCK = new ModelResourceLocation(MOD_NAME + ":gsboneblock", "inventory");
    public static final ModelResourceLocation BONE_BLOCK_WITH_SKULL = new ModelResourceLocation(MOD_NAME + ":gsboneblock_with_skull", "inventory");

    public static final ModelResourceLocation BONE_SLAB = new ModelResourceLocation(MOD_NAME + ":gsboneslab", "inventory");
    public static final ModelResourceLocation BONE_STAIRS = new ModelResourceLocation(MOD_NAME + ":gsbonestairs", "inventory");

    public static final ModelResourceLocation HAUNTED_CHEST = new ModelResourceLocation(MOD_NAME + ":gshauntedchest", "inventory");
    public static final ModelResourceLocation CANDLE = new ModelResourceLocation(MOD_NAME + ":gscandle", "inventory");
    public static final ModelResourceLocation SKULL_CANDLE = new ModelResourceLocation(MOD_NAME + ":gsskullcandle", "inventory");
    public static final ModelResourceLocation ALTAR = new ModelResourceLocation(MOD_NAME + ":gsaltar", "inventory");

    public static final ModelResourceLocation CATACOMBS_PORTAL = new ModelResourceLocation(GSBlock.CATACOMBS_PORTAL.getRegistryName(), "inventory");
}
