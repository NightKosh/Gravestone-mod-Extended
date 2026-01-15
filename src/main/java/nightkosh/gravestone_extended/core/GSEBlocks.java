package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.block.FrozenLava;
import nightkosh.gravestone_extended.block.WitheredBricks;
import nightkosh.gravestone_extended.block.bone_block.*;
import nightkosh.gravestone_extended.block.WitheredGlass;
import nightkosh.gravestone_extended.block.pile_of_bones.*;
import nightkosh.gravestone_extended.block.skull_candle.SkullCandleSkeleton;
import nightkosh.gravestone_extended.block.skull_candle.SkullCandleWither;
import nightkosh.gravestone_extended.block.skull_candle.SkullCandleZombie;
import nightkosh.gravestone_extended.item.itemblock.BIWitheredBricks;
import nightkosh.gravestone_extended.item.itemblock.BIFrozenLava;
import nightkosh.gravestone_extended.item.itemblock.bone_block.*;
import nightkosh.gravestone_extended.item.itemblock.BIWitheredGlass;
import nightkosh.gravestone_extended.item.itemblock.pile_of_bones.*;
import nightkosh.gravestone_extended.item.itemblock.skull_candle.BISkullCandleSkeleton;
import nightkosh.gravestone_extended.item.itemblock.skull_candle.BISkullCandleWither;
import nightkosh.gravestone_extended.item.itemblock.skull_candle.BISkullCandleZombie;

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

    // skull candles
    public static final ResourceKey SKULL_CANDLE_SKELETON_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_skeleton"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_SKELETON = registerBlock("skull_candle_skeleton",
            SkullCandleSkeleton::new,
            BISkullCandleSkeleton::new);

    public static final ResourceKey SKULL_CANDLE_ZOMBIE_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_zombie"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_ZOMBIE = registerBlock("skull_candle_zombie",
            SkullCandleZombie::new,
            BISkullCandleZombie::new);

    public static final ResourceKey SKULL_CANDLE_WITHER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_wither"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_WITHER = registerBlock("skull_candle_wither",
            SkullCandleWither::new,
            BISkullCandleWither::new);

    // pile of bones
    public static final ResourceKey PILE_OF_BONES_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES = registerBlock("pile_of_bones",
            PileOfBones::new,
            BIPileOfBones::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL = registerBlock("pile_of_bones_skull",
            PileOfBonesSkull::new,
            BIPileOfBonesSkull::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_SKELETON_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_skeleton_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_SKELETON = registerBlock("pile_of_bones_skull_skeleton_crawler",
            PileOfBonesSkeleton::new,
            BIPileOfBonesSkeleton::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_STRAY_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_stray_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_STRAY = registerBlock("pile_of_bones_skull_stray_crawler",
            PileOfBonesStray::new,
            BIPileOfBonesStray::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_BOGGED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_bogged_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_BOGGED = registerBlock("pile_of_bones_skull_bogged_crawler",
            PileOfBonesBogged::new,
            BIPileOfBonesBogged::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_PARCHED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_parched_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_PARCHED = registerBlock("pile_of_bones_skull_parched_crawler",
            PileOfBonesParched::new,
            BIPileOfBonesParched::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_WITHER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_wither_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_WITHER = registerBlock("pile_of_bones_skull_wither_crawler",
            PileOfBonesWither::new,
            BIPileOfBonesWither::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_ZOMBIE_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_zombie_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_ZOMBIE = registerBlock("pile_of_bones_skull_zombie_crawler",
            PileOfBonesZombie::new,
            BIPileOfBonesZombie::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_HUSK_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_husk_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_HUSK = registerBlock("pile_of_bones_skull_husk_crawler",
            PileOfBonesHusk::new,
            BIPileOfBonesHusk::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_DROWNED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_drowned_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_DROWNED = registerBlock("pile_of_bones_skull_drowned_crawler",
            PileOfBonesDrowned::new,
            BIPileOfBonesDrowned::new);

    public static final ResourceKey PILE_OF_BONES_SKULL_PIGLIN_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_piglin_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_PIGLIN = registerBlock("pile_of_bones_skull_piglin_crawler",
            PileOfBonesPiglin::new,
            BIPileOfBonesPiglin::new);

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

    public static final ResourceKey BONE_BLOCK_SKELETON_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skeleton_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKELETON_CRAWLER = registerBlock("bone_block_skeleton_crawler",
            BoneBlockSkeletonCrawler::new,
            BIBoneBlockSkeletonCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_SKELETON_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_skeleton_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_SKELETON_CRAWLER = registerBlock("bone_block_skull_skeleton_crawler",
            BoneBlockSkullSkeletonCrawler::new,
            BIBoneBlockSkullSkeletonCrawler::new);

    public static final ResourceKey BONE_BLOCK_STRAY_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_stray_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_STRAY_CRAWLER = registerBlock("bone_block_stray_crawler",
            BoneBlockStrayCrawler::new,
            BIBoneBlockStrayCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_STRAY_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_stray_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_STRAY_CRAWLER = registerBlock("bone_block_skull_stray_crawler",
            BoneBlockSkullStrayCrawler::new,
            BIBoneBlockSkullStrayCrawler::new);

    public static final ResourceKey BONE_BLOCK_BOGGED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_bogged_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_BOGGED_CRAWLER = registerBlock("bone_block_bogged_crawler",
            BoneBlockBoggedCrawler::new,
            BIBoneBlockBoggedCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_BOGGED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_bogged_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_BOGGED_CRAWLER = registerBlock("bone_block_skull_bogged_crawler",
            BoneBlockSkullBoggedCrawler::new,
            BIBoneBlockSkullBoggedCrawler::new);

    public static final ResourceKey BONE_BLOCK_PARCHED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_parched_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_PARCHED_CRAWLER = registerBlock("bone_block_parched_crawler",
            BoneBlockParchedCrawler::new,
            BIBoneBlockParchedCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_PARCHED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_parched_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_PARCHED_CRAWLER = registerBlock("bone_block_skull_parched_crawler",
            BoneBlockSkullParchedCrawler::new,
            BIBoneBlockSkullParchedCrawler::new);

    public static final ResourceKey BONE_BLOCK_WITHER_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_wither_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_WITHER_CRAWLER = registerBlock("bone_block_wither_crawler",
            BoneBlockWitherCrawler::new,
            BIBoneBlockWitherCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_WITHER_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_wither_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_WITHER_CRAWLER = registerBlock("bone_block_skull_wither_crawler",
            BoneBlockSkullWitherCrawler::new,
            BIBoneBlockSkullWitherCrawler::new);

    public static final ResourceKey BONE_BLOCK_ZOMBIE_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_zombie_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_ZOMBIE_CRAWLER = registerBlock("bone_block_zombie_crawler",
            BoneBlockZombieCrawler::new,
            BIBoneBlockZombieCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_ZOMBIE_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_zombie_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_ZOMBIE_CRAWLER = registerBlock("bone_block_skull_zombie_crawler",
            BoneBlockSkullZombieCrawler::new,
            BIBoneBlockSkullZombieCrawler::new);

    public static final ResourceKey BONE_BLOCK_HUSK_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_husk_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_HUSK_CRAWLER = registerBlock("bone_block_husk_crawler",
            BoneBlockHuskCrawler::new,
            BIBoneBlockHuskCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_HUSK_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_husk_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_HUSK_CRAWLER = registerBlock("bone_block_skull_husk_crawler",
            BoneBlockSkullHuskCrawler::new,
            BIBoneBlockSkullHuskCrawler::new);

    public static final ResourceKey BONE_BLOCK_DROWNED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_drowned_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_DROWNED_CRAWLER = registerBlock("bone_block_drowned_crawler",
            BoneBlockDrownedCrawler::new,
            BIBoneBlockDrownedCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_DROWNED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_drowned_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_DROWNED_CRAWLER = registerBlock("bone_block_skull_drowned_crawler",
            BoneBlockSkullDrownedCrawler::new,
            BIBoneBlockSkullDrownedCrawler::new);

    public static final ResourceKey BONE_BLOCK_PIGLIN_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_piglin_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_PIGLIN_CRAWLER = registerBlock("bone_block_piglin_crawler",
            BoneBlockPiglinCrawler::new,
            BIBoneBlockPiglinCrawler::new);

    public static final ResourceKey BONE_BLOCK_SKULL_PIGLIN_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_piglin_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_PIGLIN_CRAWLER = registerBlock("bone_block_skull_piglin_crawler",
            BoneBlockSkullPiglinCrawler::new,
            BIBoneBlockSkullPiglinCrawler::new);

    // glass
    public static final ResourceKey WITHERED_GLASS_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "withered_glass"));
    public static final DeferredHolder<Block, Block> WITHERED_GLASS = registerBlock("withered_glass",
            WitheredGlass::new,
            BIWitheredGlass::new);

    public static final ResourceKey WITHERED_BRICKS_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "withered_bricks"));
    public static final DeferredHolder<Block, Block> WITHERED_BRICKS = registerBlock("withered_bricks",
            WitheredBricks::new,
            BIWitheredBricks::new);

    public static final ResourceKey FROZEN_LAVA_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "frozen_lava"));
    public static final DeferredHolder<Block, Block> FROZEN_LAVA = registerBlock("frozen_lava",
            FrozenLava::new,
            BIFrozenLava::new);

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
//    public static final BlockHauntedChest HAUNTED_CHEST = new BlockHauntedChest();
//    public static final ItemBlock HAUNTED_CHEST_IB = new IBHauntedChest(HAUNTED_CHEST);
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
//            registry.registerAll(MEMORIAL, EXECUTION, SPAWNER, TRAP,
//                    HAUNTED_CHEST, ALTAR, INVISIBLE_WALL, CORPSE, TOXIC_WATER, CATACOMBS_PORTAL, CURSED_FLAME);
//        }
//
//        @SubscribeEvent
//        public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
//            final IForgeRegistry<Item> registry = event.getRegistry();
//            registry.registerAll(MEMORIAL_IB, EXECUTION_IB, SPAWNER_IB, TRAP_IB,
//                    HAUNTED_CHEST_IB, ALTAR_IB, CORPSE_IB, CATACOMBS_PORTAL_IB, CURSED_FLAME_IB);
//        }
//    }

    public static void register(IEventBus eventBus) {
        BLOCKS_REGISTER.register(eventBus);
    }

}
