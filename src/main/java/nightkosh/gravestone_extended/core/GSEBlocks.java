package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.block.bone_block.*;
import nightkosh.gravestone_extended.item.itemblock.bone_block.*;

import java.util.function.Supplier;

import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

/**
 * Gravestone mod - Extended
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GSEBlocks {
    
    public static final DeferredRegister<Block> BLOCKS_REGISTER =
            DeferredRegister.create(Registries.BLOCK, ModInfo.ID);

    // bone blocks
    public static final ResourceKey BONE_BLOCK_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK = registerBlock("bone_block",
            BoneBlock::new,
            BIBoneBlock::new);

    public static final ResourceKey BONE_BLOCK_SKULL_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL = registerBlock("bone_block_skull",
            BoneBlockSkull::new,
            BIBoneBlockSkull::new);

    public static final ResourceKey BONE_SLAB_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_slab"));
    public static final DeferredHolder<Block, Block> BONE_SLAB = registerBlock("bone_slab",
            BoneSlab::new,
            BIBoneSlab::new);

    public static final ResourceKey BONE_STAIRS_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_stairs"));
    public static final DeferredHolder<Block, Block> BONE_STAIRS = registerBlock("bone_stairs",
            BoneStairs::new,
            BIBoneStairs::new);

    public static final ResourceKey BONE_BLOCK_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_CRAWLER = registerBlock("bone_block_crawler",
            BoneBlockCrawler::new,
            BIBoneBlockCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_CRAWLER = registerBlock("bone_block_skull_crawler",
            BoneBlockSkullCrawler::new,
            BIBoneBlockSkullCrawler::new);

    private static <T extends Block> DeferredHolder<Block, T> registerBlock(
            String name, Supplier<T> block, Supplier<Item> itemBlock) {
        GSEItems.ITEMS_REGISTER.register(name, itemBlock);
        return BLOCKS_REGISTER.register(name, block);
    }
//
//    public static final BlockMemorial MEMORIAL = new BlockMemorial();
//    public static final ItemBlock MEMORIAL_IB = new IBMemorial(MEMORIAL);
//
//    public static final BlockExecution EXECUTION = new BlockExecution();
//    public static final ItemBlock EXECUTION_IB = new IBExecution(EXECUTION);
//
//    public static final BlockSpawner SPAWNER = new BlockSpawner();
//    public static final ItemBlock SPAWNER_IB = new IBSpawner(SPAWNER);
//
//    public static final BlockTrap TRAP = new BlockTrap();
//    public static final ItemBlock TRAP_IB = new IBTrap(TRAP);
//
//    public static final Block WITHERED_GLASS = new BlockWitheredGlass();
//    public static final ItemBlock WITHERED_GLASS_IB = new IBWitheredGlass(WITHERED_GLASS);
//
//    public static final Block WITHERED_GLASS_PANE = new BlockWitheredPane();
//    public static final ItemBlock WITHERED_GLASS_PANE_IB = new IBWitheredPane(WITHERED_GLASS_PANE);
//
//    public static final BlockPileOfBones PILE_OF_BONES = new BlockPileOfBones();
//    public static final ItemBlock PILE_OF_BONES_IB = new IBPileOfBones(PILE_OF_BONES);
//
//    public static final BlockHauntedChest HAUNTED_CHEST = new BlockHauntedChest();
//    public static final ItemBlock HAUNTED_CHEST_IB = new IBHauntedChest(HAUNTED_CHEST);
//
//    public static final BlockCandle CANDLE = new BlockCandle();
//    public static final ItemBlock CANDLE_IB = new IBCandle(CANDLE);
//
//    public static final BlockSkullCandleSkeleton SKULL_CANDLE_SKELETON = new BlockSkullCandleSkeleton();
//    public static final ItemBlock SKULL_CANDLE_SKELETON_IB = new IBSkullCandleSkeleton(SKULL_CANDLE_SKELETON);
//    public static final BlockSkullCandleSkeleton SKULL_CANDLE_ZOMBIE = new BlockSkullCandleZombie();
//    public static final ItemBlock SKULL_CANDLE_ZOMBIE_IB = new IBSkullCandleZombie(SKULL_CANDLE_ZOMBIE);
//    public static final BlockSkullCandleSkeleton SKULL_CANDLE_WITHER = new BlockSkullCandleWither();
//    public static final ItemBlock SKULL_CANDLE_WITHER_IB = new IBSkullCandleWither(SKULL_CANDLE_WITHER);
//
//    public static final BlockAltar ALTAR = new BlockAltar();
//    public static final ItemBlock ALTAR_IB = new IBAltar(ALTAR);
//
//    public static final BlockInvisibleWall INVISIBLE_WALL = new BlockInvisibleWall();
//
//    public static final BlockCorpse CORPSE = new BlockCorpse();
//    public static final ItemBlock CORPSE_IB = new IBCorpse(CORPSE);
//
//    public static final Block CATACOMBS_PORTAL = new BlockCatacombsPortal();
//    public static final ItemBlock CATACOMBS_PORTAL_IB = new IBCatacombsPortal(CATACOMBS_PORTAL);
//
//    public static final Block FROZEN_LAVA = new BlockFrozenLava();
//    public static final ItemBlock FROZEN_LAVA_IB = new IBFrozenLava(FROZEN_LAVA);
//
//    public static final Block CURSED_FLAME = new BlockCursedFlame();
//    public static final ItemBlock CURSED_FLAME_IB = new IBCursedFlame(CURSED_FLAME);
//
//    public static final BlockFluidToxicWater TOXIC_WATER = new BlockFluidToxicWater();
//
//    @Mod.EventBusSubscriber(modid = ModInfo.ID)
//    public static class RegistrationHandler {
//
//        @SubscribeEvent
//        public static void registerBlocks(final RegistryEvent.Register<Block> event) {
//            final IForgeRegistry<Block> registry = event.getRegistry();
//            registry.registerAll(MEMORIAL, EXECUTION, SPAWNER, TRAP, WITHERED_GLASS, PILE_OF_BONES, WITHERED_GLASS_PANE,
//                    BONE_BLOCK, BONE_SLAB, BONE_STAIRS, HAUNTED_CHEST, CANDLE, SKULL_CANDLE_SKELETON, SKULL_CANDLE_ZOMBIE, SKULL_CANDLE_WITHER,
//                    ALTAR, INVISIBLE_WALL, CORPSE, TOXIC_WATER, CATACOMBS_PORTAL, FROZEN_LAVA, CURSED_FLAME);
//        }
//
//        @SubscribeEvent
//        public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
//            final IForgeRegistry<Item> registry = event.getRegistry();
//            registry.registerAll(MEMORIAL_IB, EXECUTION_IB, SPAWNER_IB, TRAP_IB, WITHERED_GLASS_IB, WITHERED_GLASS_PANE_IB,
//                    PILE_OF_BONES_IB, BONE_BLOCK_IB, BONE_SLAB_IB, BONE_STAIRS_IB, HAUNTED_CHEST_IB, CANDLE_IB,
//                    SKULL_CANDLE_SKELETON_IB, SKULL_CANDLE_ZOMBIE_IB, SKULL_CANDLE_WITHER_IB,
//                    ALTAR_IB, CORPSE_IB, CATACOMBS_PORTAL_IB, FROZEN_LAVA_IB, CURSED_FLAME_IB);
//        }
//    }

    public static void register(IEventBus eventBus) {
        BLOCKS_REGISTER.register(eventBus);
    }

}
