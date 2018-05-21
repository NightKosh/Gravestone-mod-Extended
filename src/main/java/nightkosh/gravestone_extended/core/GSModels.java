package nightkosh.gravestone_extended.core;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nightkosh.gravestone_extended.ModGravestoneExtended;
import nightkosh.gravestone_extended.block.enums.*;
import nightkosh.gravestone_extended.item.ItemFish;
import nightkosh.gravestone_extended.item.ItemGSMonsterPlacer;
import nightkosh.gravestone_extended.tileentity.*;

/**
 * GraveStone mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@GameRegistry.ObjectHolder(ModInfo.ID)
public class GSModels {

    @Mod.EventBusSubscriber(modid = ModInfo.ID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerModels(final ModelRegistryEvent event) {
            //memorials
            registerModelsForTEBlocks(EnumMemorials.WOODEN_CROSS.ordinal(), EnumMemorials.ICE_CROSS.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_OBELISK.ordinal(), EnumMemorials.ICE_OBELISK.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.Obelisk.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_CELTIC_CROSS.ordinal(), EnumMemorials.ICE_CELTIC_CROSS.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.CelticCross.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_STEVE_STATUE.ordinal(), EnumMemorials.ICE_STEVE_STATUE.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.SteveStatue.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_VILLAGER_STATUE.ordinal(), EnumMemorials.ICE_VILLAGER_STATUE.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.VillagerStatue.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_ANGEL_STATUE.ordinal(), EnumMemorials.ICE_ANGEL_STATUE.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.AngelStatue.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_DOG_STATUE.ordinal(), EnumMemorials.ICE_DOG_STATUE.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.DogStatue.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_CAT_STATUE.ordinal(), EnumMemorials.ICE_CAT_STATUE.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.CatStatue.class);
            registerModelsForTEBlocks(EnumMemorials.WOODEN_CREEPER_STATUE.ordinal(), EnumMemorials.ICE_CREEPER_STATUE.ordinal(), GSBlock.MEMORIAL, ResourcesModels.MEMORIAL, TileEntityMemorial.CreeperStatue.class);
            //executions
            registerModelsForTEBlocks(EnumExecution.GALLOWS.ordinal(), GSBlock.EXECUTION, ResourcesModels.EXECUTION, TileEntityExecution.class);
            registerModelsForTEBlocks(EnumExecution.GIBBET.ordinal(), GSBlock.EXECUTION, ResourcesModels.EXECUTION, TileEntityExecution.Gibbet.class);
            registerModelsForTEBlocks(EnumExecution.STOCKS.ordinal(), GSBlock.EXECUTION, ResourcesModels.EXECUTION, TileEntityExecution.Stocks.class);
            registerModelsForTEBlocks(EnumExecution.BURNING_STAKE.ordinal(), GSBlock.EXECUTION, ResourcesModels.EXECUTION, TileEntityExecution.BurningStake.class);
            //spawners
            registerModelsForTEBlocks(EnumSpawner.WITHER_SPAWNER.ordinal(), GSBlock.SPAWNER, ResourcesModels.SPAWNER, TileEntitySpawner.class);
            registerModelsForTEBlocks(EnumSpawner.SKELETON_SPAWNER.ordinal(), GSBlock.SPAWNER, ResourcesModels.SPAWNER, TileEntitySpawner.Skeleton.class);
            registerModelsForTEBlocks(EnumSpawner.ZOMBIE_SPAWNER.ordinal(), GSBlock.SPAWNER, ResourcesModels.SPAWNER, TileEntitySpawner.Zombie.class);
            registerModelsForTEBlocks(EnumSpawner.SPIDER_SPAWNER.ordinal(), GSBlock.SPAWNER, ResourcesModels.SPAWNER, TileEntitySpawner.Spider.class);
            //piles of bones
            registerModelsForTEBlocks(EnumPileOfBones.PILE_OF_BONES.ordinal(), GSBlock.PILE_OF_BONES, ResourcesModels.PILE_OF_BONES, TileEntityPileOfBones.class);
            registerModelsForTEBlocks(EnumPileOfBones.PILE_OF_BONES_WITH_SKULL.ordinal(), GSBlock.PILE_OF_BONES, ResourcesModels.PILE_OF_BONES, TileEntityPileOfBones.Skull.class);
            registerModelsForTEBlocks(EnumPileOfBones.PILE_OF_BONES_WITH_SKULL_CRAWLER.ordinal(), GSBlock.PILE_OF_BONES, ResourcesModels.PILE_OF_BONES, TileEntityPileOfBones.Crawler.class);

            //haunted chest
            registerModelsForTEBlocks(0, EnumHauntedChest.values().length - 1, GSBlock.HAUNTED_CHEST, ResourcesModels.HAUNTED_CHEST, TileEntityHauntedChest.class);

            //skull candle
            registerModelsForTEBlocks(EnumSkullCandle.SKELETON_SKULL.ordinal(), GSBlock.SKULL_CANDLE, ResourcesModels.SKULL_CANDLE, TileEntitySkullCandle.class);
            registerModelsForTEBlocks(EnumSkullCandle.WITHER_SKULL.ordinal(), GSBlock.SKULL_CANDLE, ResourcesModels.SKULL_CANDLE, TileEntitySkullCandle.Wither.class);
            registerModelsForTEBlocks(EnumSkullCandle.ZOMBIE_SKULL.ordinal(), GSBlock.SKULL_CANDLE, ResourcesModels.SKULL_CANDLE, TileEntitySkullCandle.Zombie.class);

            //corpses
            registerModelsForTEBlocks(EnumCorpse.STEVE.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Steve.class);
            registerModelsForTEBlocks(EnumCorpse.VILLAGER.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Villager.class);
            registerModelsForTEBlocks(EnumCorpse.DOG.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Dog.class);
            registerModelsForTEBlocks(EnumCorpse.CAT.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Cat.class);
            registerModelsForTEBlocks(EnumCorpse.HORSE.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Horse.class);
            registerModelsForTEBlocks(EnumCorpse.ZOMBIE.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Zombie.class);
            registerModelsForTEBlocks(EnumCorpse.ZOMBIE_VILLAGER.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.ZombieVillager.class);
            registerModelsForTEBlocks(EnumCorpse.SKELETON.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Skeleton.class);
            registerModelsForTEBlocks(EnumCorpse.WITCH.ordinal(), GSBlock.CORPSE, ResourcesModels.CORPSE, TileEntityCorpse.Witch.class);

            //traps
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.TRAP), EnumTrap.NIGHT_STONE.ordinal(), ResourcesModels.NIGHT_STONE);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.TRAP), EnumTrap.THUNDER_STONE.ordinal(), ResourcesModels.THUNDER_STONE);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.TRAP), ResourcesModels.NIGHT_STONE, ResourcesModels.THUNDER_STONE);

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.WITHERED_GLASS), 0, ResourcesModels.WITHERED_GLASS);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.WITHERED_GLASS_PANE), 0, ResourcesModels.WITHERED_GLASS_PANE);

            //bone blocks
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.BONE_BLOCK), EnumBoneBlock.BONE_BLOCK.ordinal(), ResourcesModels.BONE_BLOCK);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.BONE_BLOCK), EnumBoneBlock.SKULL_BONE_BLOCK.ordinal(), ResourcesModels.BONE_BLOCK_WITH_SKULL);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.BONE_BLOCK), EnumBoneBlock.CRAWLER_BONE_BLOCK.ordinal(), ResourcesModels.BONE_BLOCK);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.BONE_BLOCK), EnumBoneBlock.CRAWLER_SKULL_BONE_BLOCK.ordinal(), ResourcesModels.BONE_BLOCK_WITH_SKULL);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.BONE_BLOCK), ResourcesModels.BONE_BLOCK, ResourcesModels.BONE_BLOCK_WITH_SKULL,
                    ResourcesModels.BONE_BLOCK, ResourcesModels.BONE_BLOCK_WITH_SKULL);


            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.BONE_SLAB), 0, ResourcesModels.BONE_SLAB);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.BONE_SLAB), ResourcesModels.BONE_SLAB);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.BONE_STAIRS), 0, ResourcesModels.BONE_STAIRS);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.BONE_STAIRS), ResourcesModels.BONE_STAIRS);

            //altar
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.ALTAR), 0, ResourcesModels.ALTAR);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.ALTAR), ResourcesModels.ALTAR);

            //candle
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.CANDLE), 0, ResourcesModels.CANDLE);
            ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(GSBlock.CANDLE), 0, TileEntityCandle.class);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.CANDLE), 0, ResourcesModels.CANDLE);

            //portal
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.CATACOMBS_PORTAL), 0, ResourcesModels.CATACOMBS_PORTAL);


            // ITEMS
            ModelLoader.setCustomModelResourceLocation(GSItem.CHISEL, 0, ResourcesModels.CHISEL);
            ModelBakery.registerItemVariants(GSItem.CHISEL, ResourcesModels.CHISEL);

            for (ItemGSMonsterPlacer.EnumEggs egg : ItemGSMonsterPlacer.EnumEggs.values()) {
                ModelLoader.setCustomModelResourceLocation(GSItem.SPAWN_EGG, egg.ordinal(), ResourcesModels.SPAWN_EGG_MODEL);
            }
            ModelBakery.registerItemVariants(GSItem.SPAWN_EGG, ResourcesModels.SPAWN_EGG_MODEL);

            ModelLoader.setCustomModelResourceLocation(GSItem.TOXIC_SLIME, 0, ResourcesModels.TOXIC_SLIME);

            ModelLoader.setCustomModelResourceLocation(GSItem.RAVEN_FEATHER, 0, ResourcesModels.RAVEN_FEATHER);

            ModelLoader.setCustomModelResourceLocation(GSItem.BAT_WING, 0, ResourcesModels.BAT_WING);

            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.BLUE_JELLYFISH.ordinal(), ResourcesModels.BLUE_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.GREEN_JELLYFISH.ordinal(), ResourcesModels.GREEN_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.MAGMA_JELLYFISH.ordinal(), ResourcesModels.MAGMA_JELLYFISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.BONE_FISH.ordinal(), ResourcesModels.BONE_FISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.MUD_TUNA.ordinal(), ResourcesModels.MUD_TUNA);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.FROST_MINNOW.ordinal(), ResourcesModels.FROST_MINNOW);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.PIRANHA.ordinal(), ResourcesModels.PIRANHA);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.GOLDEN_KOI.ordinal(), ResourcesModels.GOLDEN_KOI);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.SPECULAR_FISH.ordinal(), ResourcesModels.SPECULAR_FISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.CAVEFISH.ordinal(), ResourcesModels.CAVEFISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.CURSED_KOI.ordinal(), ResourcesModels.CURSED_KOI);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.SPOOKYFIN.ordinal(), ResourcesModels.SPOOKYFIN);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.OBSIDIFISH.ordinal(), ResourcesModels.OBSIDIFISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.NETHER_SALMON.ordinal(), ResourcesModels.NETHER_SALMON);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.QUARTZ_COD.ordinal(), ResourcesModels.QUARTZ_COD);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.FLAREFIN_KOI.ordinal(), ResourcesModels.FLAREFIN_KOI);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.BLAZE_COD.ordinal(), ResourcesModels.BLAZE_COD);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.ENDERFIN.ordinal(), ResourcesModels.ENDERFIN);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.PEARL_BASS.ordinal(), ResourcesModels.PEARL_BASS);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.CHORUS_KOI.ordinal(), ResourcesModels.CHORUS_KOI);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.EXPLOSIVE_CRUCIAN.ordinal(), ResourcesModels.EXPLOSIVE_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.RUFFE.ordinal(), ResourcesModels.RUFFE);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.SPARKLING_EEL.ordinal(), ResourcesModels.SPARKLING_EEL);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.ANGELFISH.ordinal(), ResourcesModels.ANGELFISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.ANGLER_FISH.ordinal(), ResourcesModels.ANGLER_FISH);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.SPONGE_EATER.ordinal(), ResourcesModels.SPONGE_EATER);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.SNOWY_CRUCIAN.ordinal(), ResourcesModels.SNOWY_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.SQUID.ordinal(), ResourcesModels.SQUID);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.WITHERED_CRUCIAN.ordinal(), ResourcesModels.WITHERED_CRUCIAN);
            ModelLoader.setCustomModelResourceLocation(GSItem.FISH, ItemFish.EnumFishType.SANDY_BASS.ordinal(), ResourcesModels.SANDY_BASS);
            ModelBakery.registerItemVariants(GSItem.FISH, ResourcesModels.BLUE_JELLYFISH, ResourcesModels.GREEN_JELLYFISH, ResourcesModels.MAGMA_JELLYFISH,
                    ResourcesModels.BONE_FISH, ResourcesModels.MUD_TUNA, ResourcesModels.PIRANHA, ResourcesModels.GOLDEN_KOI, ResourcesModels.SPECULAR_FISH,
                    ResourcesModels.CAVEFISH, ResourcesModels.CURSED_KOI, ResourcesModels.SPOOKYFIN, ResourcesModels.OBSIDIFISH, ResourcesModels.NETHER_SALMON,
                    ResourcesModels.QUARTZ_COD, ResourcesModels.FLAREFIN_KOI, ResourcesModels.BLAZE_COD, ResourcesModels.ENDERFIN, ResourcesModels.PEARL_BASS,
                    ResourcesModels.CHORUS_KOI, ResourcesModels.EXPLOSIVE_CRUCIAN, ResourcesModels.RUFFE, ResourcesModels.SPARKLING_EEL, ResourcesModels.ANGELFISH,
                    ResourcesModels.ANGLER_FISH, ResourcesModels.SPONGE_EATER, ResourcesModels.SNOWY_CRUCIAN, ResourcesModels.SQUID, ResourcesModels.WITHERED_CRUCIAN,
                    ResourcesModels.SANDY_BASS);

            ModelLoader.setCustomModelResourceLocation(GSItem.ENCHANTED_SKULL, 0, ResourcesModels.ENCHANTED_SKULL);
            ModelLoader.setCustomModelResourceLocation(GSItem.ENCHANTED_SKULL, 1, ResourcesModels.ENCHANTED_SKULL_WITHERED);
            ModelBakery.registerItemVariants(GSItem.ENCHANTED_SKULL, ResourcesModels.ENCHANTED_SKULL, ResourcesModels.ENCHANTED_SKULL_WITHERED);

            ModelLoader.setCustomModelResourceLocation(GSItem.SLIME_CHUNK, 0, ResourcesModels.SLIME_CHUNK);
            ModelLoader.setCustomModelResourceLocation(GSItem.IMP_SKULL, 0, ResourcesModels.IMP_SKULL);
            ModelLoader.setCustomModelResourceLocation(GSItem.ENDER_SKULL, 0, ResourcesModels.ENDER_SKULL);

            ModelLoader.setCustomModelResourceLocation(GSItem.FROZEN_MIRROR, 0, ResourcesModels.FROZEN_MIRROR);

            ModelLoader.setCustomModelResourceLocation(GSItem.DIVING_HELMET, 0, ResourcesModels.DIVING_HELMET);

            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SWORD, 0, ResourcesModels.BONE_SWORD);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SWORD_IRON, 0, ResourcesModels.BONE_SWORD_IRON);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SWORD_GOLDEN, 0, ResourcesModels.BONE_SWORD_GOLDEN);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SWORD_DIAMOND, 0, ResourcesModels.BONE_SWORD_DIAMOND);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SHIELD, 0, ResourcesModels.BONE_SHIELD);

            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_FISHING_POLE, 0, ResourcesModels.BONE_FISHING_POLE);

            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_HOE, 0, ResourcesModels.BONE_HOE);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_HOE_IRON, 0, ResourcesModels.BONE_HOE_IRON);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_HOE_GOLDEN, 0, ResourcesModels.BONE_HOE_GOLDEN);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_HOE_DIAMOND, 0, ResourcesModels.BONE_HOE_DIAMOND);

            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_AXE, 0, ResourcesModels.BONE_AXE);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_AXE_IRON, 0, ResourcesModels.BONE_AXE_IRON);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_AXE_GOLDEN, 0, ResourcesModels.BONE_AXE_GOLDEN);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_AXE_DIAMOND, 0, ResourcesModels.BONE_AXE_DIAMOND);

            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_PICKAXE, 0, ResourcesModels.BONE_PICKAXE);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_PICKAXE_IRON, 0, ResourcesModels.BONE_PICKAXE_IRON);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_PICKAXE_GOLDEN, 0, ResourcesModels.BONE_PICKAXE_GOLDEN);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_PICKAXE_DIAMOND, 0, ResourcesModels.BONE_PICKAXE_DIAMOND);

            registerFluidModel(GSBlock.TOXIC_WATER);
        }

        private static void registerFluidModel(BlockFluidClassic block) {
            final Item item = Item.getItemFromBlock(block);
            assert item != null;

            ModelBakery.registerItemVariants(item);
            final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(ModInfo.ID + ":fluid", block.getFluid().getName());
            ModelLoader.setCustomMeshDefinition(item, stack -> modelResourceLocation);
            ModGravestoneExtended.proxy.registerFluidRenderers(block, modelResourceLocation);
        }

        private static void registerModelsForTEBlocks(int startMeta, int endMeta, Block block, ModelResourceLocation model, Class TEClass) {
            for (int meta = startMeta; meta <= endMeta; meta++) {
                registerModelsForTEBlocks(meta, block, model, TEClass);
            }
        }

        private static void registerModelsForTEBlocks(int meta, Block block, ModelResourceLocation model, Class TEClass) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, model);
            ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(block), meta, TEClass);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, model);
        }
    }
}
