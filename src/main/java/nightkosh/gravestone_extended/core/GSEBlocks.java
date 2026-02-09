package nightkosh.gravestone_extended.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import nightkosh.gravestone_extended.block.*;
import nightkosh.gravestone_extended.block.bone_block.*;
import nightkosh.gravestone_extended.block.pile_of_bones.*;
import nightkosh.gravestone_extended.block.spawner.*;

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
            () -> new SkullCandle(SKULL_CANDLE_SKELETON_RK));

    public static final ResourceKey SKULL_CANDLE_ZOMBIE_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_zombie"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_ZOMBIE = registerBlock("skull_candle_zombie",
            () -> new SkullCandle(SKULL_CANDLE_ZOMBIE_RK));

    public static final ResourceKey SKULL_CANDLE_WITHER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_wither"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_WITHER = registerBlock("skull_candle_wither",
            () -> new SkullCandle(SKULL_CANDLE_WITHER_RK));

    public static final ResourceKey SKULL_CANDLE_DROWNED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_drowned"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_DROWNED = registerBlock("skull_candle_drowned",
            () -> new SkullCandle(SKULL_CANDLE_DROWNED_RK));

    public static final ResourceKey SKULL_CANDLE_HUSK_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_husk"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_HUSK = registerBlock("skull_candle_husk",
            () -> new SkullCandle(SKULL_CANDLE_HUSK_RK));

    public static final ResourceKey SKULL_CANDLE_PARCHED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_parched"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_PARCHED = registerBlock("skull_candle_parched",
            () -> new SkullCandle(SKULL_CANDLE_PARCHED_RK));

    public static final ResourceKey SKULL_CANDLE_BOGGED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_bogged"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_BOGGED = registerBlock("skull_candle_bogged",
            () -> new SkullCandle(SKULL_CANDLE_BOGGED_RK));

    public static final ResourceKey SKULL_CANDLE_PIGLIN_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_piglin"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_PIGLIN = registerBlock("skull_candle_piglin",
            () -> new SkullCandle(SKULL_CANDLE_PIGLIN_RK));

    public static final ResourceKey SKULL_CANDLE_STRAY_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "skull_candle_stray"));
    public static final DeferredHolder<Block, Block> SKULL_CANDLE_STRAY = registerBlock("skull_candle_stray",
            () -> new SkullCandle(SKULL_CANDLE_STRAY_RK));

    // spawners
    public static final ResourceKey SPAWNER_SKELETON_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_skeleton"));
    public static final DeferredHolder<Block, Block> SPAWNER_SKELETON = registerBlock("spawner_skeleton",
            SpawnerSkeleton::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_SKELETON.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_SKELETON_RK)));

    public static final ResourceKey SPAWNER_STRAY_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_stray"));
    public static final DeferredHolder<Block, Block> SPAWNER_STRAY = registerBlock("spawner_stray",
            SpawnerStray::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_STRAY.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_STRAY_RK)));

    public static final ResourceKey SPAWNER_BOGGED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_bogged"));
    public static final DeferredHolder<Block, Block> SPAWNER_BOGGED = registerBlock("spawner_bogged",
            SpawnerBogged::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_BOGGED.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_BOGGED_RK)));

    public static final ResourceKey SPAWNER_PARCHED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_parched"));
    public static final DeferredHolder<Block, Block> SPAWNER_PARCHED = registerBlock("spawner_parched",
            SpawnerParched::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_PARCHED.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_PARCHED_RK)));

    public static final ResourceKey SPAWNER_WITHER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_wither"));
    public static final DeferredHolder<Block, Block> SPAWNER_WITHER = registerBlock("spawner_wither",
            SpawnerWither::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_WITHER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_WITHER_RK)));

    public static final ResourceKey SPAWNER_ZOMBIE_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_zombie"));
    public static final DeferredHolder<Block, Block> SPAWNER_ZOMBIE = registerBlock("spawner_zombie",
            SpawnerZombie::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_ZOMBIE.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_ZOMBIE_RK)));

    public static final ResourceKey SPAWNER_HUSK_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_husk"));
    public static final DeferredHolder<Block, Block> SPAWNER_HUSK = registerBlock("spawner_husk",
            SpawnerHusk::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_HUSK.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_HUSK_RK)));

    public static final ResourceKey SPAWNER_DROWNED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_drowned"));
    public static final DeferredHolder<Block, Block> SPAWNER_DROWNED = registerBlock("spawner_drowned",
            SpawnerDrowned::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_DROWNED.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_DROWNED_RK)));

    public static final ResourceKey SPAWNER_PIGLIN_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "spawner_piglin"));
    public static final DeferredHolder<Block, Block> SPAWNER_PIGLIN = registerBlock("spawner_piglin",
            SpawnerPiglin::new,
            () -> new BlockItem(
                    GSEBlocks.SPAWNER_PIGLIN.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.SPAWNER_PIGLIN_RK)));

    // pile of bones
    public static final ResourceKey PILE_OF_BONES_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES = registerBlock("pile_of_bones",
            PileOfBones::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL = registerBlock("pile_of_bones_skull",
            PileOfBonesSkull::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_SKELETON_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_skeleton_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_SKELETON = registerBlock("pile_of_bones_skull_skeleton_crawler",
            PileOfBonesSkeleton::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_SKELETON.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_SKELETON_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_STRAY_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_stray_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_STRAY = registerBlock("pile_of_bones_skull_stray_crawler",
            PileOfBonesStray::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_STRAY.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_STRAY_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_BOGGED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_bogged_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_BOGGED = registerBlock("pile_of_bones_skull_bogged_crawler",
            PileOfBonesBogged::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_BOGGED.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_BOGGED_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_PARCHED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_parched_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_PARCHED = registerBlock("pile_of_bones_skull_parched_crawler",
            PileOfBonesParched::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_PARCHED.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_PARCHED_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_WITHER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_wither_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_WITHER = registerBlock("pile_of_bones_skull_wither_crawler",
            PileOfBonesWither::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_WITHER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_WITHER_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_ZOMBIE_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_zombie_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_ZOMBIE = registerBlock("pile_of_bones_skull_zombie_crawler",
            PileOfBonesZombie::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_ZOMBIE.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_ZOMBIE_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_HUSK_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_husk_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_HUSK = registerBlock("pile_of_bones_skull_husk_crawler",
            PileOfBonesHusk::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_HUSK.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_HUSK_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_DROWNED_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_drowned_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_DROWNED = registerBlock("pile_of_bones_skull_drowned_crawler",
            PileOfBonesDrowned::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_DROWNED.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_DROWNED_RK)));

    public static final ResourceKey PILE_OF_BONES_SKULL_PIGLIN_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "pile_of_bones_skull_piglin_crawler"));
    public static final DeferredHolder<Block, Block> PILE_OF_BONES_SKULL_PIGLIN = registerBlock("pile_of_bones_skull_piglin_crawler",
            PileOfBonesPiglin::new,
            () -> new BlockItem(
                    GSEBlocks.PILE_OF_BONES_SKULL_PIGLIN.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.PILE_OF_BONES_SKULL_PIGLIN_RK)));

    // bone blocks
    public static final ResourceKey BONE_BLOCK_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK = registerBlock("bone_block",
            BoneBlock::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL = registerBlock("bone_block_skull",
            BoneBlockSkull::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_RK)));

    public static final ResourceKey BONE_SLAB_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_slab"));
    public static final DeferredHolder<Block, Block> BONE_SLAB = registerBlock("bone_slab",
            BoneSlab::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_SLAB.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_SLAB_RK)));

    public static final ResourceKey BONE_STAIRS_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_stairs"));
    public static final DeferredHolder<Block, Block> BONE_STAIRS = registerBlock("bone_stairs",
            BoneStairs::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_STAIRS.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_STAIRS_RK)));

    public static final ResourceKey BONE_BLOCK_SKELETON_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skeleton_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKELETON_CRAWLER = registerBlock("bone_block_skeleton_crawler",
            BoneBlockSkeletonCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKELETON_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKELETON_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_SKELETON_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_skeleton_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_SKELETON_CRAWLER = registerBlock("bone_block_skull_skeleton_crawler",
            BoneBlockSkullSkeletonCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_SKELETON_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_SKELETON_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_STRAY_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_stray_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_STRAY_CRAWLER = registerBlock("bone_block_stray_crawler",
            BoneBlockStrayCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_STRAY_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_STRAY_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_STRAY_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_stray_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_STRAY_CRAWLER = registerBlock("bone_block_skull_stray_crawler",
            BoneBlockSkullStrayCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_STRAY_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_STRAY_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_BOGGED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_bogged_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_BOGGED_CRAWLER = registerBlock("bone_block_bogged_crawler",
            BoneBlockBoggedCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_BOGGED_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_BOGGED_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_BOGGED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_bogged_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_BOGGED_CRAWLER = registerBlock("bone_block_skull_bogged_crawler",
            BoneBlockSkullBoggedCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_BOGGED_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_BOGGED_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_PARCHED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_parched_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_PARCHED_CRAWLER = registerBlock("bone_block_parched_crawler",
            BoneBlockParchedCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_PARCHED_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_PARCHED_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_PARCHED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_parched_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_PARCHED_CRAWLER = registerBlock("bone_block_skull_parched_crawler",
            BoneBlockSkullParchedCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_PARCHED_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_PARCHED_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_WITHER_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_wither_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_WITHER_CRAWLER = registerBlock("bone_block_wither_crawler",
            BoneBlockWitherCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_WITHER_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_WITHER_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_WITHER_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_wither_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_WITHER_CRAWLER = registerBlock("bone_block_skull_wither_crawler",
            BoneBlockSkullWitherCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_WITHER_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_WITHER_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_ZOMBIE_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_zombie_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_ZOMBIE_CRAWLER = registerBlock("bone_block_zombie_crawler",
            BoneBlockZombieCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_ZOMBIE_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_ZOMBIE_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_ZOMBIE_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_zombie_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_ZOMBIE_CRAWLER = registerBlock("bone_block_skull_zombie_crawler",
            BoneBlockSkullZombieCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_ZOMBIE_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_ZOMBIE_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_HUSK_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_husk_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_HUSK_CRAWLER = registerBlock("bone_block_husk_crawler",
            BoneBlockHuskCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_HUSK_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_HUSK_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_HUSK_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_husk_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_HUSK_CRAWLER = registerBlock("bone_block_skull_husk_crawler",
            BoneBlockSkullHuskCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_HUSK_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_HUSK_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_DROWNED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_drowned_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_DROWNED_CRAWLER = registerBlock("bone_block_drowned_crawler",
            BoneBlockDrownedCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_DROWNED_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_DROWNED_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_DROWNED_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_drowned_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_DROWNED_CRAWLER = registerBlock("bone_block_skull_drowned_crawler",
            BoneBlockSkullDrownedCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_DROWNED_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_DROWNED_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_PIGLIN_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_piglin_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_PIGLIN_CRAWLER = registerBlock("bone_block_piglin_crawler",
            BoneBlockPiglinCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_PIGLIN_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_PIGLIN_CRAWLER_RK)));

    public static final ResourceKey BONE_BLOCK_SKULL_PIGLIN_CRAWLER_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "bone_block_skull_piglin_crawler"));
    public static final DeferredHolder<Block, Block> BONE_BLOCK_SKULL_PIGLIN_CRAWLER = registerBlock("bone_block_skull_piglin_crawler",
            BoneBlockSkullPiglinCrawler::new,
            () -> new BlockItem(
                    GSEBlocks.BONE_BLOCK_SKULL_PIGLIN_CRAWLER.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.BONE_BLOCK_SKULL_PIGLIN_CRAWLER_RK)));

    // withered blocks
    public static final ResourceKey WITHERED_GLASS_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "withered_glass"));
    public static final DeferredHolder<Block, Block> WITHERED_GLASS = registerBlock("withered_glass",
            WitheredGlass::new,
            () -> new BlockItem(
                    GSEBlocks.WITHERED_GLASS.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.WITHERED_GLASS_RK)));

    public static final ResourceKey WITHERED_BRICKS_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "withered_bricks"));
    public static final DeferredHolder<Block, Block> WITHERED_BRICKS = registerBlock("withered_bricks",
            WitheredBricks::new,
            () -> new BlockItem(
                    GSEBlocks.WITHERED_BRICKS.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.WITHERED_BRICKS_RK)));

    // altar
    public static final ResourceKey ALTAR_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "altar"));
    public static final DeferredHolder<Block, Block> ALTAR = registerBlock("altar",
            Altar::new,
            () -> new BlockItem(
                    GSEBlocks.ALTAR.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.ALTAR_RK)));

    // other
    public static final ResourceKey FROZEN_LAVA_RK = ResourceKey.create(
            Registries.BLOCK,
            fromNamespaceAndPath(ModInfo.ID, "frozen_lava"));
    public static final DeferredHolder<Block, Block> FROZEN_LAVA = registerBlock("frozen_lava",
            FrozenLava::new,
            () -> new BlockItem(
                    GSEBlocks.FROZEN_LAVA.get(),
                    new Item.Properties()
                            .stacksTo(64)
                            .setId(GSEBlocks.FROZEN_LAVA_RK)));

    private static <T extends Block> DeferredHolder<Block, T> registerBlock(
            String name, Supplier<T> block, Supplier<Item> itemBlock) {
        GSEItems.ITEMS_REGISTER.register(name, itemBlock);
        return registerBlock(name, block);
    }

    private static <T extends Block> DeferredHolder<Block, T> registerBlock(
            String name, Supplier<T> block) {
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
//                    HAUNTED_CHEST, INVISIBLE_WALL, CORPSE, TOXIC_WATER, CATACOMBS_PORTAL, CURSED_FLAME);
//        }
//
//        @SubscribeEvent
//        public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
//            final IForgeRegistry<Item> registry = event.getRegistry();
//            registry.registerAll(MEMORIAL_IB, EXECUTION_IB, SPAWNER_IB, TRAP_IB,
//                    HAUNTED_CHEST_IB, CORPSE_IB, CATACOMBS_PORTAL_IB, CURSED_FLAME_IB);
//        }
//    }

    public static void register(IEventBus eventBus) {
        BLOCKS_REGISTER.register(eventBus);
    }

}
