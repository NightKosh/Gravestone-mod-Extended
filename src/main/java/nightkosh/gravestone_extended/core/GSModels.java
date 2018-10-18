package nightkosh.gravestone_extended.core;

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
import nightkosh.gravestone_extended.block.enums.EnumBoneBlock;
import nightkosh.gravestone_extended.block.enums.EnumHauntedChest;
import nightkosh.gravestone_extended.block.enums.EnumPileOfBones;
import nightkosh.gravestone_extended.block.enums.EnumTrap;
import nightkosh.gravestone_extended.item.ItemGSMonsterPlacer;
import nightkosh.gravestone_extended.tileentity.TileEntityHauntedChest;

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
            ModGravestoneExtended.proxy.addModelRotationsAndTEISR();

            //piles of bones
            for (int i = EnumPileOfBones.PILE_OF_BONES.ordinal(); i < EnumPileOfBones.PILE_OF_BONES_WITH_SKULL.ordinal() * 4 - 1; i++) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.PILE_OF_BONES), i, ResourcesModels.PILE_OF_BONES);
            }
            for (int i = EnumPileOfBones.PILE_OF_BONES_WITH_SKULL.ordinal() * 4; i <= EnumPileOfBones.PILE_OF_BONES_WITH_SKULL_CRAWLER.ordinal() * 4; i++) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.PILE_OF_BONES), i, ResourcesModels.PILE_OF_BONES_WITH_SKULL);
            }
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.PILE_OF_BONES), ResourcesModels.PILE_OF_BONES, ResourcesModels.PILE_OF_BONES_WITH_SKULL);

            //haunted chest
            for (int meta = 0; meta <= EnumHauntedChest.values().length - 1; meta++) {
                ForgeHooksClient.registerTESRItemStack(Item.getItemFromBlock(GSBlock.HAUNTED_CHEST), meta, TileEntityHauntedChest.class);
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.HAUNTED_CHEST), meta, ResourcesModels.HAUNTED_CHEST);
            }

            //skull candle
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.SKULL_CANDLE_SKELETON), 0, ResourcesModels.SKULL_CANDLE_SKELETON);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.SKULL_CANDLE_SKELETON), ResourcesModels.SKULL_CANDLE_SKELETON);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.SKULL_CANDLE_ZOMBIE), 0, ResourcesModels.SKULL_CANDLE_ZOMBIE);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.SKULL_CANDLE_ZOMBIE), ResourcesModels.SKULL_CANDLE_ZOMBIE);
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(GSBlock.SKULL_CANDLE_WITHER), 0, ResourcesModels.SKULL_CANDLE_WITHER);
            ModelBakery.registerItemVariants(Item.getItemFromBlock(GSBlock.SKULL_CANDLE_WITHER), ResourcesModels.SKULL_CANDLE_WITHER);

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
            ModelLoader.setCustomModelResourceLocation(GSItem.RAVEN_CLAWS, 0, ResourcesModels.RAVEN_CLAWS);

            ModelLoader.setCustomModelResourceLocation(GSItem.BAT_WING, 0, ResourcesModels.BAT_WING);

            ModelLoader.setCustomModelResourceLocation(GSItem.OOZE, 0, ResourcesModels.OOZE);

            ModelLoader.setCustomModelResourceLocation(GSItem.PIECE_OF_MUMMY_CLOTH, 0, ResourcesModels.PIECE_OF_MUMMY_CLOTH);

            ModelLoader.setCustomModelResourceLocation(GSItem.PIECE_OF_DIVING_SUIT, 0, ResourcesModels.PIECE_OF_DIVING_SUIT);

            ModelLoader.setCustomModelResourceLocation(GSItem.ENCHANTED_SKULL, 0, ResourcesModels.ENCHANTED_SKULL);
            ModelLoader.setCustomModelResourceLocation(GSItem.ENCHANTED_SKULL, 1, ResourcesModels.ENCHANTED_SKULL_WITHERED);
            ModelBakery.registerItemVariants(GSItem.ENCHANTED_SKULL, ResourcesModels.ENCHANTED_SKULL, ResourcesModels.ENCHANTED_SKULL_WITHERED);

            ModelLoader.setCustomModelResourceLocation(GSItem.SLIME_CHUNK, 0, ResourcesModels.SLIME_CHUNK);
            ModelLoader.setCustomModelResourceLocation(GSItem.IMP_SKULL, 0, ResourcesModels.IMP_SKULL);
            ModelLoader.setCustomModelResourceLocation(GSItem.ENDER_SKULL, 0, ResourcesModels.ENDER_SKULL);

            ModelLoader.setCustomModelResourceLocation(GSItem.FROZEN_MIRROR, 0, ResourcesModels.FROZEN_MIRROR);

            ModelLoader.setCustomModelResourceLocation(GSItem.DIVING_HELMET, 0, ResourcesModels.DIVING_HELMET);
            ModelLoader.setCustomModelResourceLocation(GSItem.DIVING_CHESTPLATE, 0, ResourcesModels.DIVING_CHESTPLATE);
            ModelLoader.setCustomModelResourceLocation(GSItem.DIVING_LEGGINGS, 0, ResourcesModels.DIVING_LEGGINGS);
            ModelLoader.setCustomModelResourceLocation(GSItem.DIVING_BOOTS, 0, ResourcesModels.DIVING_BOOTS);

            ModelLoader.setCustomModelResourceLocation(GSItem.SWAMP_THING_HELMET, 0, ResourcesModels.SWAMP_THING_HELMET);
            ModelLoader.setCustomModelResourceLocation(GSItem.SWAMP_THING_CHESTPLATE, 0, ResourcesModels.SWAMP_THING_CHESTPLATE);
            ModelLoader.setCustomModelResourceLocation(GSItem.SWAMP_THING_LEGGINGS, 0, ResourcesModels.SWAMP_THING_LEGGINGS);
            ModelLoader.setCustomModelResourceLocation(GSItem.SWAMP_THING_BOOTS, 0, ResourcesModels.SWAMP_THING_BOOTS);

            ModelLoader.setCustomModelResourceLocation(GSItem.MUMMY_HELMET, 0, ResourcesModels.MUMMY_HELMET);
            ModelLoader.setCustomModelResourceLocation(GSItem.MUMMY_CHESTPLATE, 0, ResourcesModels.MUMMY_CHESTPLATE);
            ModelLoader.setCustomModelResourceLocation(GSItem.MUMMY_LEGGINGS, 0, ResourcesModels.MUMMY_LEGGINGS);
            ModelLoader.setCustomModelResourceLocation(GSItem.MUMMY_BOOTS, 0, ResourcesModels.MUMMY_BOOTS);

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

            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SHOVEL, 0, ResourcesModels.BONE_SHOVEL);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SHOVEL_IRON, 0, ResourcesModels.BONE_SHOVEL_IRON);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SHOVEL_GOLDEN, 0, ResourcesModels.BONE_SHOVEL_GOLDEN);
            ModelLoader.setCustomModelResourceLocation(GSItem.BONE_SHOVEL_DIAMOND, 0, ResourcesModels.BONE_SHOVEL_DIAMOND);

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
    }
}
